package Model;

import Sources.Images;
import Sources.VisitorState;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Point;

/**
 * Látogatók osztálya.
 */
public class Visitor {
    private static int id = 0;
    private int counter;
    private boolean adult;
    private Images imageID;
    private List<Integer> toVisit;
    private List<List<Point>> pathToVisit;
    private List<Point> pathToDest;
    private GameModel model;
    private Point position;
    private Point realPosition;
    private int onGame=0;
    private int onTile = 1;
    private VisitorSimulation simulate;
    private boolean toRemove;

    private int happinessLevel;
    private VisitorState state;
    //private boolean busy;

    /**
     * Teljes konstruktor
     * @param adult
     * @param builtSize
     * @param happinessLevel
     * @param simulate
     * @param model
     */
    public Visitor(boolean adult, int happinessLevel, int builtSize, GameModel model, VisitorSimulation simulate) {
        this.adult = adult;
        adult = generateIsAdult();
        if(adult)
            imageID = Images.ADULT;
        else
            imageID = Images.YOUTH;
        this.happinessLevel = happinessLevel;
        toVisit = new ArrayList<>();
        generateToVisit(builtSize);
        state = VisitorState.WAITING;
        counter = ++id;
        this.model = model;
        this.simulate = simulate;
        pathToVisit = new ArrayList<>();
        pathToDest = new ArrayList<>();
        toRemove = false;
        position = new Point(31,31);
        realPosition = new Point(position.x*20,position.y*20);
        if(model.getSites().size() > 0){
            addPathToDest(model.getSites().get(toVisit.get(onGame)).getPosition(), model.getSites().get(toVisit.get(onGame)).getSizeX(), model.getSites().get(toVisit.get(onGame)).getSizeY());
        }
    }
    
    /**
     * Személy felnőtt-e vagy sem.
     * @return 
     */
    public boolean generateIsAdult()
    {
        return getRandom(1, 1000) % 2 == 0;
    }
    
    /**
     * Személy érdeklődési körének kigenerálása.
     * @param builtSize 
     */
    public void generateToVisit(int builtSize){
        int toVisitSize = 1;
        if(builtSize == 0){
            toVisitSize = 0;
        } else if(builtSize == 1){
           toVisitSize = 1;  
        } else if(builtSize < 5){
            toVisitSize = getRandom(1, builtSize);
        } else if(builtSize < 10){
            toVisitSize = getRandom(4, builtSize);
        } else {
            toVisitSize = getRandom(6, builtSize);
        }
        fillToVisit(toVisitSize, builtSize);
    }

    /**
     * Pontos meghatározása a megtekinteni kívánt épületeknek.
     * @param size
     * @param builtSize 
     */
    public void fillToVisit(int size, int builtSize){
        for(int i=0; i<size; i++){
            int num = getRandom(0, builtSize);
            toVisit.add(num);
        }
    }
      
    /**
     * Random szám generálása.
     * @param min
     * @param max
     * @return 
     */
    public int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Images getImageID() {
        return imageID;
    }

    public void setImageID(Images imageID) {
        this.imageID = imageID;
    }
    
    public int getHappinessLevel() {
        return happinessLevel;
    }

    /**
     * Boldogás testreszabása.
     * @param happinessLevel 
     */
    public void setHappinessLevel(int happinessLevel) {
        if(happinessLevel>100) this.happinessLevel = 100;
        else if(happinessLevel<0) this.happinessLevel = 0;
        else this.happinessLevel = happinessLevel;
    }

    public List<Integer> getToVisit() {
        return toVisit;
    }

    public void setToVisit(List<Integer> toVisit) {
        this.toVisit = toVisit;
    }

    public VisitorState getState() {
        return state;
    }

    public void setState(VisitorState state) {
        this.state = state;
    }

    public Point getRealPosition() {
        return realPosition;
    }

    public int getOnPath() {
        return onGame;
    }

    public int getCounter() {
        return counter;
    }

    public static void setId(int id) {
        Visitor.id = id;
    }
    
    public List<List<Point>> getPathToVisit(){
        return pathToVisit;
    }
    
    public Point getPosition(){
        return position;
    }
    
    public void setPosition(Point position){
        this.position = position;
    }

    public List<Point> getPathToDest() {
        return pathToDest;
    }

    public void setPathToDest(List<Point> pathToDest) {
        this.pathToDest = pathToDest;
    }
    
    /**
     * Adott személy útjának kigenerálása.
     * @param destination
     * @param sizei
     * @param sizej 
     */
    public void addPathToDest(Point destination, int sizei, int sizej){
        position = pathToDest.size() > 0 ? pathToDest.get(0) : new Point(31,31);
        pathToDest.clear();
        onTile = 1;
        Path pathFinder = new Path(model.getBoard());
        pathToDest.addAll(pathFinder.findPath(destination, position, sizei, sizej));
        realPosition = new Point(position.x*20,position.y*20);
    }
    
    /**
     * Személy folyamatos mozgatása.
     */
    public void setRealPosition() {
        Buildable game;
        if(onGame <= toVisit.size()-1){
            game = model.getSites().get(toVisit.get(onGame));        
        }else {
            game = model.getSites().get(toVisit.get(toVisit.size()-1));
        }
        if(Integer.parseInt(model.getGameTime().getDate().split(":")[1]) % 2 == 0){
            if(realPosition.x > position.x*20){
                realPosition.x -= 4;
            }
            else if(realPosition.x < position.x*20){
                realPosition.x += 4;
            }
            else if(realPosition.y > position.y*20){
                realPosition.y -= 4;
            }
            else if(realPosition.y < position.y*20){
                realPosition.y += 4;
            } else {
                if(pathToDest.size()-onTile >= 0)
                position = pathToDest.get(pathToDest.size()-onTile++);
                
                if(onTile == pathToDest.size()+1 && game.getVisitorCount() < game.getCapacity() && state == VisitorState.WAITING && realPosition.x == position.x*20 && realPosition.y == position.y*20){
                    game.setCapacity(game.getCapacity()+1);
                    state = VisitorState.PLAYING;
                    
                } else if(onTile == pathToDest.size()+1 && game.getVisitorCount() < game.getCapacity()+game.getQueueCap() && state == VisitorState.WAITING && realPosition.x == position.x*20 && realPosition.y == position.y*20){
                    state = VisitorState.INQUEUE;
                    game.setCapacity(game.getCapacity()+1);
                }
                if(onTile == pathToDest.size()+1 && state == VisitorState.ROAMING && realPosition.x == position.x*20 && realPosition.y == position.y*20){
                    if(!toRemove){
                        nextPath();
                    } else {
                        state = VisitorState.LEAVING;
                        model.getVisitorSimulation().Simulate();
                    }
                }
            }
        }
    }

    public int getOnGame() {
        return onGame;
    }
    
    /**
     * Végzett játék után a következő hely meglátogatása.
     */
    public void nextPath(){
        onGame += 1;
        onTile = 1;
        Path pathFinder = new Path(model.getBoard());
        if(onGame >= toVisit.size()-1){
            state = VisitorState.ROAMING;
            if(Integer.parseInt(model.getGameTime().getDate().split("nap, ")[1].split(":")[0]) < 18){
                Random rand;
                int randDestId = (int)(Math.random() * (model.getPaths().size()-1));
                addPathToDest(model.getPaths().get(randDestId).getPosition(), 0, 0);
            } else {
                addPathToDest(new Point(31,32), 0, 0);
                toRemove = true;
            }
        } else {
            state = VisitorState.WAITING;
            Buildable game = model.getSites().get(toVisit.get(onGame));
            onGame += 1;
            onTile = 1;
            pathToDest.clear();
            pathToDest.addAll(pathFinder.findPath(game.getPosition(),position,game.getSizeX(),game.getSizeY()));
        }
    }
}



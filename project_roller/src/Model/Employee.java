package Model;

import Sources.EmployeeType;
import Sources.EmployeeState;
import Sources.Images;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Mindenki aki nem látogató.
 */
public class Employee {

    private EmployeeType type;
    private EmployeeState state;
    private Images imageID;
    private List<Point> pathToDest;
    private GameModel gameModel;
    private Point base;
    private Point realPosition;
    private Point position;
    private Point destination;
    private int onTile = 1;
    private EmployeeSimulation simulation;
    boolean reversed;
    int needToFixId;
    int toolId;

    /**
     * Alap konstruktor
     * @param type
     * @param state
     * @param imageID
     * @param gameModel
     * @param base
     * @param simulation
     */
    
    public Employee(EmployeeType type,EmployeeState state,Images imageID, GameModel gameModel, Point base, EmployeeSimulation simulation) {
        this.type = type;
        this.state = state;
        this.imageID = imageID;
        this.gameModel = gameModel;
        this.base = base;
        pathToDest = new ArrayList<>();
        realPosition = new Point(0,0);
        position = new Point(0,0);
        this.simulation = simulation; 
        destination = new Point(0,0);
        reversed = false;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public EmployeeState getState() {
        return state;
    }

    public void setState(EmployeeState state) {
        this.state = state;
    }

    public Images getImageID() {
        return imageID;
    }

    public void setImageID(Images imageID) {
        this.imageID = imageID;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    
    /**
     * RendőrÚr járkál A-ból B-be amíg nem talál tolvajUrat.
     */
    public void startPatrol(){
        if(simulation.getOfficers().size() > gameModel.getPoliceStations().size()){
            simulation.removeOfficer(this);
        } else {
            state = EmployeeState.PATROLLING;

            Random rand;
            int randDestId = (int)(Math.random() * (gameModel.getPaths().size()-1));
            addPathToDest(gameModel.getPaths().get(randDestId).getPosition(), randDestId, 0);
            
        }
    }

    public Point getBase() {
        return base;
    }

    public void setBase(Point base) {
        this.base = base;
    }

    public List<Point> getPathToDest() {
        return pathToDest;
    }

    public void setPathToDest(List<Point> pathToDest) {
        this.pathToDest = pathToDest;
    }

    /**
     * Útvonal hozzáadása a személyhez.
     * @param destination
     * @param needToFixId
     * @param toolId 
     */
    public void addPathToDest(Point destination, int needToFixId, int toolId){
        onTile = 1;
        reversed = false;
        pathToDest.clear();
        if(type == EmployeeType.JANITOR){
            state = EmployeeState.CLEANING;
        }
        this.needToFixId = needToFixId;
        this.toolId = toolId;
        this.destination = destination;
        Path pathFinder = new Path(gameModel.getBoard());
        pathToDest.addAll(pathFinder.findPath(base, new Point(destination), 3, 3));
        position = new Point(pathToDest.get(onTile));
        realPosition = new Point(position.x*20,position.y*20);
    }
    
    /**
     * Személyek mozgatása a kigenerált útvonalon.
     */
    public void setRealPosition() {
        
        if(type == EmployeeType.OFFICER && simulation.getThief() != null){
            Employee thief = simulation.getThief();
            if(pathToDest.get(pathToDest.size()-1) != thief.position && position != thief.getPosition()){
                pathToDest.add(thief.position);
            }
            if(position == thief.getPosition()){
                //elkapva
                gameModel.getEmployeeSimulation().lockThief();
                state = EmployeeState.PATROLLING;
                Path pathfinder = new Path(gameModel.getBoard());
            }
        }
        if(realPosition.x > position.x*20){
            realPosition.x -= 1;
        }
        else if(realPosition.x < position.x*20){
            realPosition.x += 1;
        }
        else if(realPosition.y > position.y*20){
            realPosition.y -= 1;
        }
        else if(realPosition.y < position.y*20){
            realPosition.y += 1;
        } else {
            if(realPosition.x == position.x*20 && realPosition.y == position.y*20){
            if(onTile == pathToDest.size()-1 && reversed && Integer.parseInt(gameModel.getGameTime().getDate().split(":")[1]) % 12 == 0){
                if(type == EmployeeType.JANITOR){
                    state=EmployeeState.WAITING;
                    simulation.removeChore(needToFixId);
                    simulation.janitorStartNewDuty();
                }
                if(type == EmployeeType.OFFICER){
                    state = EmployeeState.WAITING;
                    if(Integer.parseInt(gameModel.getGameTime().getDate().split(":")[1]) % 27 == 0)
                        startPatrol();
                }
                if(type == EmployeeType.THIEF){
                    gameModel.getEmployeeSimulation().escapeThief();
                    gameModel.getEmployeeSimulation().setOfficersPatrol();
                }
            }

            if(pathToDest.size()-onTile >= 0)
            position = pathToDest.get(onTile);
            if(onTile < pathToDest.size()-1){
                onTile++;
            } else if(!reversed) {
                if(onTile == pathToDest.size()-1){
                    if(type == EmployeeType.JANITOR && gameModel.getBoard()[destination.x][destination.y].getType() == "full_bin"){
                        gameModel.getBoard()[destination.x][destination.y].setType("bin");
                        gameModel.getBoard()[destination.x][destination.y].setImageID(Images.BIN);
                        gameModel.getTools().get(toolId).setType("bin");
                        gameModel.getTools().get(toolId).setImageID(Images.BIN);
                    } else if(type == EmployeeType.JANITOR && gameModel.getBoard()[destination.x][destination.y].getType() == "trash"){
                        gameModel.getBoard()[destination.x][destination.y].setType("empty");
                        gameModel.getBoard()[destination.x][destination.y].setImageID(Images.GRASS);
                        gameModel.getBoard()[destination.x][destination.y].setUsable(true);
                    }
                    if(type != EmployeeType.THIEF){
                        List<Point> temp = new ArrayList<>();
                        temp.addAll(pathToDest);
                        pathToDest.clear();
                        for(int i=temp.size()-1; i>=0 ;i--){
                            pathToDest.add(temp.get(i));
                            onTile = 0;

                            reversed = true;
                        }
                    } else {
                        reversed = true;
                    }
                }
            }
        }
    }
    }
    
    /**
     * TolvajPapa lopni indul.
     */
    public void steal(){
        Path pathFinder = new Path(gameModel.getBoard());
        Random rand;
        int randDestId = (int)(Math.random() * (gameModel.getPaths().size()-1));
        List<Point> escapeRoute = new ArrayList<>();
        List<Point> temp = new ArrayList<>();
        escapeRoute.addAll(pathFinder.findPath(base, new Point(31,31), 0, 0));
        if(escapeRoute.size()<3){
            do{
                pathToDest.clear();
                temp.clear();
                pathToDest.addAll(pathFinder.findPath(base, new Point(gameModel.getPaths().get(randDestId).getPosition()), 0, 0));
                if(pathToDest.size()>2){
                    for(int i=0; i<2; i++){
                        temp.add(pathToDest.get(i));
                    }
                    pathToDest.clear();
                    pathToDest.addAll(temp);
                    pathToDest.addAll(pathFinder.findPath(pathToDest.get(pathToDest.size()-1), new Point(31,31), 0, 0));
                }
            } while(pathToDest.size() < 1);
        } else {
            pathToDest.clear();
            pathToDest.addAll(escapeRoute);
            
        }
        position = base;
        realPosition.x = position.x * 20;
        realPosition.y = position.y * 20;
    }
    
    /**
     * Elindult a bűnüldözés. Nyerjen a jobbik.
     */ 
    public void chase(){
        List<Point> pathSoFar = new ArrayList<>();
        Path pathFinder = new Path(gameModel.getBoard());
        pathSoFar.addAll(pathFinder.findPath(base, position, 3, 3));
        onTile = pathSoFar.size()-1;
        pathSoFar.addAll(pathFinder.findPath(position,simulation.getThief().getPosition(),0,0));
        reversed = false;
        pathToDest = pathSoFar;
        position = pathToDest.get(onTile);
        realPosition.x = position.x * 20;
        realPosition.y = position.y * 20;
        state = EmployeeState.CATCHING;
    }
    
    public Point getRealPosition() {
        return realPosition;
    }
}
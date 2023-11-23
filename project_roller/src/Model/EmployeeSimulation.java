package Model;

import Sources.EmployeeState;
import Sources.EmployeeType;
import Sources.Images;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeSimulation {
    private GameModel gameModel;
    private ArrayList<Unit> needToFix;
    private List<Employee> janitors;
    private List<Employee> officers;
    Employee thief;
    
    /**
     * Konstruktor
     * @param gameModel 
     */
    public EmployeeSimulation(GameModel gameModel) {
        this.gameModel = gameModel;
        this.needToFix = new ArrayList<>();
        janitors = new ArrayList<>();
        officers = new ArrayList<>();
    }
    
    /**
     * Gondozók létrehozása és feladat beállítása -> szemét szedés adott kukáknál.
     */
    public void generateStaff(){
        janitors.clear();
         for(int i=0; i<gameModel.getJanitorStations().size(); i++){
            janitors.add(new Employee(EmployeeType.JANITOR, EmployeeState.WAITING, Images.JANITOR, gameModel, gameModel.getJanitorStations().get(i).getPosition(),this));
        }
         if(janitors.size() > 0) {
             janitorStartNewDuty();
         }
    }
    
    public void removeOfficer(Employee e){
        officers.remove(e);
    }
    
    /**
     * Szemét generálás adott kukába -> nincs kuka akkor az út mentén keletkeznek
     * szemetes zsákok.
     */
    public void createMess()
    {
        boolean rand = getRandom(1,100) % 2 == 0;
        boolean b = true;
        int num = 0;
        if(rand)
        {
            for(int i=0; i<gameModel.getTools().size(); i++)
            {
                if(gameModel.getTools().get(i).getType() == "bin" && num==0)
                {
                    Buildable build = gameModel.getTools().get(i);
                    build.setType("full_bin");
                    build.setImageID(Images.FULL_BIN);
                    gameModel.getBoard()[build.getPosition().x][build.getPosition().y].setType("full_bin");
                    gameModel.getBoard()[build.getPosition().x][build.getPosition().y].setImageID(Images.FULL_BIN);
                    needToFix.add(build);
                    janitorStartNewDuty();
                    num++;
                }
            }
            if(num == 0)
            {
                for(int i = 0; i<gameModel.getPaths().size() && b;i++)
                {
                    Buildable path = gameModel.getPaths().get(i);
                    if(path.getPosition().x + 1 < 32 && b)
                    {
                        if(gameModel.getBoard()[path.getPosition().x + 1][path.getPosition().y].getType().equals("empty"))
                        {
                            gameModel.getBoard()[path.getPosition().x + 1][path.getPosition().y].setType("trash");
                            gameModel.getBoard()[path.getPosition().x + 1][path.getPosition().y].setImageID(Images.TRASH);
                            gameModel.getBoard()[path.getPosition().x + 1][path.getPosition().y].setUsable(false);
                            needToFix.add(gameModel.getBoard()[path.getPosition().x + 1][path.getPosition().y]);
                            janitorStartNewDuty();
                            b = false;
                        }
                    }
                    if(path.getPosition().x - 1 > 0 && b)
                    {
                        if(gameModel.getBoard()[path.getPosition().x - 1][path.getPosition().y].getType().equals("empty"))
                        {
                            gameModel.getBoard()[path.getPosition().x - 1][path.getPosition().y].setType("trash");
                            gameModel.getBoard()[path.getPosition().x - 1][path.getPosition().y].setImageID(Images.TRASH);
                            gameModel.getBoard()[path.getPosition().x - 1][path.getPosition().y].setUsable(false);
                            needToFix.add(gameModel.getBoard()[path.getPosition().x - 1][path.getPosition().y]);
                            janitorStartNewDuty();
                            b = false;
                        }
                    }
                    if(path.getPosition().y + 1 < 64 && b)
                    {
                        if(gameModel.getBoard()[path.getPosition().x][path.getPosition().y+1].getType().equals("empty"))
                        {
                            gameModel.getBoard()[path.getPosition().x][path.getPosition().y+1].setType("trash");
                            gameModel.getBoard()[path.getPosition().x][path.getPosition().y+1].setImageID(Images.TRASH);
                            gameModel.getBoard()[path.getPosition().x][path.getPosition().y+1].setUsable(false);
                            needToFix.add(gameModel.getBoard()[path.getPosition().x][path.getPosition().y+1]);
                            janitorStartNewDuty();
                            b = false;
                        }
                    }
                    if(path.getPosition().y - 1 > 0 && b)
                    {
                        if(gameModel.getBoard()[path.getPosition().x][path.getPosition().y-1].getType().equals("empty"))
                        {
                            gameModel.getBoard()[path.getPosition().x][path.getPosition().y-1].setType("trash");
                            gameModel.getBoard()[path.getPosition().x][path.getPosition().y-1].setImageID(Images.TRASH);
                            gameModel.getBoard()[path.getPosition().x][path.getPosition().y-1].setUsable(false);
                            needToFix.add(gameModel.getBoard()[path.getPosition().x][path.getPosition().y-1]);
                            janitorStartNewDuty();
                            b = false;
                        }
                    }
                }
            }
        }
    }  
    
    public void removeChore(int id){
        if(needToFix.size() <= 1){
            needToFix.clear();
        } else {   
            needToFix.remove(id);
        }
    }

    public void removeJanitors(){
        janitors.clear();
    }
    
    public List<Employee> getJanitors() {
        return janitors;
    }
    
    public ArrayList<Unit> getNeedToFix() {
        return needToFix;
    }

    public void setNeedToFix(ArrayList<Unit> needToFix) {
        this.needToFix = needToFix;
    }
    
    public void addEmployee(Employee e){
        switch(e.getType()){
            case JANITOR:
                janitors.add(e);
                break;
            case OFFICER:
                officers.add(e);
                patrol();
                break;
            default:
                
                break;
        }
    }

    public void setJanitors(List<Employee> janitors) {
        this.janitors = janitors;
    }
    
    /**
     * Gondozó feladatának meghatározása.
     */
    public void janitorStartNewDuty()
    {
        int waitingJanitors = 0;
        for(int i=0; i<janitors.size();i++){
            if(janitors.get(i).getState() == EmployeeState.WAITING){
                waitingJanitors += 1;
            }
        }
        if(janitors.size() > gameModel.getJanitorStations().size() && waitingJanitors == janitors.size()){
            generateStaff();
        }
        if(needToFix.size()>0){
            for(int i=0; i<needToFix.size();i++){
                for(int j=0; j<janitors.size(); j++){
                    if(janitors.get(j).getState() == EmployeeState.WAITING){
                        int toolId = 0;
                        for(int k=0; k<gameModel.getTools().size() && toolId == 0; k++){
                            Buildable built = gameModel.getTools().get(k);
                            if(built.getPosition() == needToFix.get(i).getPosition()){
                                toolId = k;
                            }
                        }
                        janitors.get(j).addPathToDest(needToFix.get(i).getPosition(),i,toolId);
                    }
                }
            }
        }
    }
    
    /**
     * Rabló letétele adott személy mellé (akit meglop).
     */
    public void spawnThief(){
        List<Visitor> visitors = gameModel.getVisitorSimulation().getVisitors();
        if(visitors.size() > 0){
            Point p = visitors.get(getRandom(0,visitors.size()-1)).getPosition();
        
            thief = new Employee(EmployeeType.THIEF,EmployeeState.WAITING,Images.THIEF,gameModel,new Point(p),this);
            thief.steal();
            catchTheThief();
        }
    };
    
    /**
     * Elmenekülés esetén büntetés kiszabása.
     */
    public void escapeThief(){
        thief = null;
        gameModel.setMoney(gameModel.getMoney()-200);
        gameModel.getGameField().setBalance(gameModel.getGameField().getBalance() - 200);
        gameModel.getGameField().setMoneyText();
    }

    public Employee getThief() {
        return thief;
    }

    /**
     * Rendőr járkál fel s alá.
     */
    public void patrol()
    {
        for(int i=0; i<officers.size(); i++){
            if(officers.get(i).getState() == EmployeeState.WAITING){
                officers.get(i).startPatrol();
            }
        }
    }
    
    /**
     * Hajsza.
     */
    public void catchTheThief()
    {
        for(int i=0; i<officers.size(); i++){
            officers.get(i).chase();
        }
    }
    
    public void lockThief(){
        thief = null;
    }
    
    /**
     * Állapot beállítása járőrözésre.
     */
    public void setOfficersPatrol(){
        for(int i=0; i<officers.size(); i++){
            if(officers.get(i).getState() == EmployeeState.CATCHING){
                officers.get(i).setState(EmployeeState.PATROLLING);
            }
        }
    }
    
    /**
     * Randomszám generálása.
     * @param min
     * @param max
     * @return 
     */
    public int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public List<Employee> getOfficers() {
        return officers;
    }

    public void setOfficers(List<Employee> officers) {
        this.officers = officers;
    }
}

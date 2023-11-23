package Model;

import Sources.DifficultyLevel;
import Sources.EmployeeState;
import Sources.EmployeeType;
import Sources.Images;
import Sources.UnitType;
import View.GameField;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Játék logikáját leíró osztály
 */

public class GameModel {
    private GameField gameField;
    private Unit[][] board;
    private TimeSimulate gameTime;
    private int happiness;
    private int sumIncome;
    private int sumCost;
    private int money;
    private List<Buildable> built;
    private List<Buildable> sites;
    private List<Buildable> tools;
    private List<Employee> employed;
    private List<Buildable> paths;
    private List<Buildable> janitorStations;
    private List<Buildable> policeStations;
    private int maxVisitor;
    private UnitType newBuilding;
    private Point chosenPoint;
    private boolean selectedAreaClear = true;
    private boolean canChangeBuilding = true;
    private DifficultyLevel dif;
    private boolean started = false;
    
    private VisitorSimulation visitorSimulation;
    private EmployeeSimulation employeeSimulation;

    /**
     * Teljes konstruktor
     * @param happiness
     * @param money
     * @param maxVisitor
     * @param boardRowCount
     * @param boardColumnCount 
     */
    public GameModel(int happiness, int money, int maxVisitor, int boardRowCount, int boardColumnCount) {
        this.happiness = happiness;
        this.money = money;
        this.maxVisitor = maxVisitor;

        /**
         * adatok inicializálása
         */
        
        board = new Unit[boardColumnCount][boardRowCount];
        sumIncome = 0;
        sumCost = 0;
        built = new ArrayList<>();
        tools = new ArrayList<>();
        paths = new ArrayList<>();
        employed = new ArrayList<>();
        janitorStations = new ArrayList<>();
        policeStations = new ArrayList<>();
        sites = new ArrayList<>();
        
        gameTime = new TimeSimulate();
        visitorSimulation = new VisitorSimulation(this);
        employeeSimulation = new EmployeeSimulation(this);
        
        generateStarterBoard();
    }

    /**
     * Alapterület feltöltése üres -> képeken fűvel.
     */
    public void generateStarterBoard(){
        //System.out.println(board.length);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = new Unit(new Point(i,j), true, "empty", Images.GRASS);
            }
        }
        starterpack();
    }
    
    /**
     * Új épület felvétele a boardra.
     * A metódus először megnézi hogy a felvett elem nem null-e, 
     * illetve hogy az adott területen nem foglalt-e.
     * Ezután a zseton,CASH,summa ellenörzése következik,
     * majd ha minden feltétel helyes volt létrehozódik az új elem.
     * Ezt felvesszük az adott paraméterekkel, illetve hozzáadjuk az elemeket
     * tartalmazó listához és levonjuk a megfelelő összeget (Zsozsót)
     */
    public void drawNewBuilding(){
        if(newBuilding != null && selectedAreaClear){
            if(newBuilding.getItem().getBuildPrice() < money){
                Buildable temp;
                int tempSizeX;
                int tempSizeY;
                temp = new Buildable(newBuilding.getItem().getBuildPrice(), newBuilding.getItem().getUpgradeCost(), newBuilding.getItem().getHappiness(), 
                        newBuilding.getItem().getCost(), newBuilding.getItem().getIncome(), 
                        newBuilding.getItem().getSizeX(), newBuilding.getItem().getSizeY(), chosenPoint,
                        newBuilding.getItem().isUsable(), newBuilding.getItem().getType(), newBuilding.getItem().getImageID());
                tempSizeX = temp.getSizeX();
                tempSizeY = temp.getSizeY();
                Point tempP = new Point(chosenPoint.y,chosenPoint.x);
                chosenPoint = tempP;
                temp.setPosition(chosenPoint);
                if(chosenPoint.x+tempSizeY <= board.length && chosenPoint.y+tempSizeX <= board[0].length){
                    for(int i=chosenPoint.x; i<chosenPoint.x+tempSizeY; i++){
                        for(int j=chosenPoint.y; j<chosenPoint.y+tempSizeX; j++){
                            board[i][j].setImageID(temp.getImageID());
                            board[i][j].setPosition(temp.getPosition());
                            board[i][j].setType(temp.getType());
                            board[i][j].setUsable(temp.isUsable());
                        }
                    }
                }
                if(newBuilding != null)
                {
                    if(newBuilding.equals(UnitType.JANITOR_STATION))
                    {
                        addToEmployeeList(new Employee(EmployeeType.JANITOR,EmployeeState.WAITING,Images.JANITOR,this, new Point(temp.getPosition()),employeeSimulation));
                        janitorStations.add(temp);
                        employeeSimulation.addEmployee(new Employee(EmployeeType.JANITOR, EmployeeState.WAITING, Images.JANITOR, this, temp.getPosition(), employeeSimulation));
                    }
                    if(newBuilding.equals(UnitType.POLICE_STATION))
                    {
                        addToEmployeeList(new Employee(EmployeeType.OFFICER,EmployeeState.PATROLLING,Images.OFFICER,this,new Point(temp.getPosition()),employeeSimulation));
                        policeStations.add(temp);
                        employeeSimulation.addEmployee(new Employee(EmployeeType.OFFICER, EmployeeState.WAITING, Images.OFFICER, this, temp.getPosition(), employeeSimulation));
                        
                    }
                    if(newBuilding.equals(UnitType.RESTAURANT))
                    {
                        addToEmployeeList(new Employee(EmployeeType.CHEF,EmployeeState.COOKING,Images.CHEF,this,new Point(temp.getPosition()),employeeSimulation));
                    }
                }
                if(multiplyItems()){
                    newBuilding = null;
                    temp.setPosition(chosenPoint);
                    built.add(temp);
                    if(temp.getType() != "janitor_station" && temp.getType() != "police_station"){
                       sites.add(temp); 
                    }
                }
                else
                {
                    if(!newBuilding.equals(UnitType.PATH))
                        tools.add(temp);
                    else
                        paths.add(temp);
                }
                
                if(gameField.getDif() == DifficultyLevel.NORMAL){
                    money = money - ((2 * temp.getBuildPrice() / 8)*5);
                }
                else if(gameField.getDif() == DifficultyLevel.HARD){
                    money = money - ((3 * temp.getBuildPrice() / 6)*3);
                }else{
                    money = money - temp.getBuildPrice();
                }
                
                gameField.setBalance(money);
            }
        }
    }

    public void setSites(List<Buildable> sites) {
        this.sites = sites;
    }
    
    public List<Buildable> getJanitorStations() {
        return janitorStations;
    }

    public void setJanitorStations(List<Buildable> janitorStations) {
        this.janitorStations = janitorStations;
    }

    public DifficultyLevel getDif() {
        return dif;
    }

    public void setDif(DifficultyLevel dif) {
        this.dif = dif;
    }

    
    
    public List<Buildable> getTools() {
        return tools;
    }

    public void setTools(List<Buildable> tools) {
        this.tools = tools;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
    
    
    /**
     * Adott elemek többszöri letételének engedélyezése.
     * @return 
     */
    public boolean multiplyItems()
    {
        return !(newBuilding.equals(UnitType.PATH) || 
               newBuilding.equals(UnitType.BIN) ||
               newBuilding.equals(UnitType.TRASH) ||
               newBuilding.equals(UnitType.BUSH1) ||
               newBuilding.equals(UnitType.BUSH2) ||
               newBuilding.equals(UnitType.BUSH3) ||
               newBuilding.equals(UnitType.TREE) ||
               newBuilding.equals(UnitType.TOITOI) ||
               newBuilding.equals(UnitType.FOUNTAIN) ||
               newBuilding.equals(UnitType.GRASS));            
    }
    
    /**
     * Alkalmaztottak felévétele a listába.
     * @param e 
     */
    public void addToEmployeeList(Employee e)
    {
        for(int i = 0;i<5;i++)
        {
            employed.add(e);
        }
    }

    public List<Buildable> getPaths() {
        return paths;
    }

    public void setPaths(List<Buildable> paths) {
        this.paths = paths;
    }
    
    public Unit[][] getBoard() {
        return board;
    }

    public void setBoard(Unit[][] board) {
        this.board = board;
    }

    public TimeSimulate getGameTime() {
        return gameTime;
    }

    public void setGameTime(TimeSimulate gameTime) {
        this.gameTime = gameTime;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getSumIncome() {
        return sumIncome;
    }

    public void setSumIncome(int sumIncome) {
        this.sumIncome = sumIncome;
    }

    public int getSumCost() {
        return sumCost;
    }

    public void setSumCost(int sumCost) {
        this.sumCost = sumCost;
    }

    public int getMoney() {
        return money;
    }

    /**
     * Pénz beállítása.
     * Adott esetben a játék véget is érhet.
     * @param money 
     */
    public void setMoney(int money) {
        this.money = money;
        if(money < 0){
            try {
                gameField.gameOver();
            } catch (IOException ex) {
                Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public List<Buildable> getBuilt() {
        return built;
    }

    public void setBuilt(List<Buildable> built) {
        this.built = built;
    }

    public List<Employee> getEmployed() {
        return employed;
    }

    public void setEmployed(List<Employee> employed) {
        this.employed = employed;
    }

    public int getMaxVisitor() {
        return maxVisitor;
    }

    public List<Buildable> getPoliceStations() {
        return policeStations;
    }

    public void setPoliceStations(List<Buildable> policeStations) {
        this.policeStations = policeStations;
    }

    public void setMaxVisitor(int maxVisitor) {
        this.maxVisitor = maxVisitor;
    }

    public UnitType getNewBuilding() {
        return newBuilding;
    }

    public void setNewBuilding(UnitType newBuilding) {
        this.newBuilding = newBuilding;
    }

    public Point getChosenPoint() {
        return chosenPoint;
    }

    public void setChosenPoint(Point chosenPoint) {
        this.chosenPoint = chosenPoint;
    }

    public void setSelectedAreaClear(boolean selectedAreaClear) {
        this.selectedAreaClear = selectedAreaClear;
    }

    public VisitorSimulation getVisitorSimulation() {
        return visitorSimulation;
    }

    public void setVisitorSimulation(VisitorSimulation visitorSimulation) {
        this.visitorSimulation = visitorSimulation;
    }

    public EmployeeSimulation getEmployeeSimulation() {
        return employeeSimulation;
    }

    public void setEmployeeSimulation(EmployeeSimulation employeeSimulation) {
        this.employeeSimulation = employeeSimulation;
    }

    public List<Buildable> getSites() {
        return sites;
    }

    /**
     * Játék kezdeti állapotának generálása:
     * Büfé
     * Gondozói ház
     * Bokrok
     * Kukák
     * Utak
     */
    private void starterpack() { 
        
        board[31][29] = new Unit(new Point(31,29), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(31,29), false, "path", Images.PATH));
        board[31][30] = new Unit(new Point(31,30), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(31,30), false, "path", Images.PATH));
        board[31][31] = new Unit(new Point(31,31), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(31,31), false, "path", Images.PATH));
        board[31][32] = new Unit(new Point(31,32), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(31,32), false, "path", Images.PATH));
        board[31][33] = new Unit(new Point(31,33), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(31,33), false, "path", Images.PATH));
        board[31][34] = new Unit(new Point(31,34), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(31,34), false, "path", Images.PATH));
        
        board[30][29] = new Unit(new Point(30,29), false, "bush3", Images.BUSH3);
        tools.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(30,29), false, "bush3", Images.BUSH3));
        board[30][30] = new Unit(new Point(30,30), false, "bush2", Images.BUSH2);
        tools.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(30,30), false, "bush2", Images.BUSH2));
        board[30][31] = new Unit(new Point(30,31), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(30,31), false, "path", Images.PATH));
        board[30][32] = new Unit(new Point(30,32), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(30,32), false, "path", Images.PATH));
        board[30][33] = new Unit(new Point(30,33), false, "bush2", Images.BUSH2);
        tools.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(30,33), false, "bush2", Images.BUSH2));
        board[30][34] = new Unit(new Point(30,34), false, "bush3", Images.BUSH3);
        tools.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(30,34), false, "bush3", Images.BUSH3));
        
        
        board[29][30] = new Unit(new Point(29,30), false, "bin", Images.BIN);
        tools.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(29,30), false, "bin", Images.BIN));
        board[29][31] = new Unit(new Point(29,31), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(29,31), false, "path", Images.PATH));
        board[29][32] = new Unit(new Point(29,32), false, "path", Images.PATH);
        paths.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(29,32), false, "path", Images.PATH));
        board[29][33] = new Unit(new Point(29,33), false, "bin", Images.BIN);
        tools.add(new Buildable(100, 0, 0, 0, 0, 1, 1, new Point(29,33), false, "bin", Images.BIN));

        

        Buildable temp;
        int tempSizeX;
        int tempSizeY;
        temp = new Buildable(1000, 600, 0, 50, 0, 3, 3, new Point(0,0), false, "janitor_station", Images.JANITOR_STATION);
        tempSizeX = temp.getSizeX();
        tempSizeY = temp.getSizeY();
        Point p = new Point(29,26);
        temp.setPosition(p);
        if(p.x+tempSizeX <= board.length && p.y+tempSizeY <= board[0].length){
            for(int i=p.x; i<p.x+tempSizeX; i++){
                for(int j=p.y; j<p.y+tempSizeY; j++){
                    board[i][j].setImageID(temp.getImageID());
                    board[i][j].setPosition(new Point(temp.getPosition()));
                    board[i][j].setType(temp.getType());
                    board[i][j].setUsable(temp.isUsable());
                }
            }
            built.add(temp);
            janitorStations.add(temp);
            employeeSimulation.addEmployee(new Employee(EmployeeType.JANITOR, EmployeeState.WAITING, Images.JANITOR, this, new Point(29,26), employeeSimulation));
        }
        temp = new Buildable(1000, 700, 10, 50, 60, 3, 3, new Point(0,0), false, "restaurant", Images.RESTAURANT);
        tempSizeX = temp.getSizeX();
        tempSizeY = temp.getSizeY();
        p = new Point(29,35);
        temp.setPosition(p);
        if(p.x+tempSizeX <= board.length && p.y+tempSizeY <= board[0].length){
            for(int i=p.x; i<p.x+tempSizeX; i++){
                for(int j=p.y; j<p.y+tempSizeY; j++){
                    board[i][j].setImageID(temp.getImageID());
                    board[i][j].setPosition(temp.getPosition());
                    board[i][j].setType(temp.getType());
                    board[i][j].setUsable(temp.isUsable());
                }
            }
            built.add(temp);
            sites.add(temp);
        }
        
        for(int i =0;i<10;i++)
        {
            if(i%2==0)
            {
                employed.add(new Employee(EmployeeType.CHEF, EmployeeState.COOKING,Images.CHEF, this,new Point(temp.getPosition()),employeeSimulation));
            }
            else
            {
                employed.add(new Employee(EmployeeType.JANITOR, EmployeeState.WAITING,Images.JANITOR, this,new Point(temp.getPosition()),employeeSimulation));
            }
        }
    }
    
    /**
     * Épületek törlése.
     * @param b 
     */
    public void destroyBuilding(Buildable b){
        if(canChangeBuilding){
            int x = b.getPosition().x;
            int y = b.getPosition().y;
            int sizeX = b.getSizeX();
            int sizeY = b.getSizeY();
            for(int i= x; i< x+sizeX; i++){
                for(int j = y; j< y+sizeY; j++){
                    board[i][j] = new Unit(new Point(i,j), true, "empty", Images.GRASS);
                }
            }

            Buildable temp = null;
            for(Buildable building : built){
                if(building.getPosition().x <= x && building.getPosition().x+building.getSizeX() > x && 
                        building.getPosition().y <= y && building.getPosition().y+building.getSizeY() > y){
                    temp = building;
                }
            }
            if(temp != null){
                money += temp.getBuildPrice()/2;
                gameField.setBalance(money);
                built.remove(temp);
                sites.remove(temp);
            }
            if(temp != null && temp.getType() == "janitor_station"){
                janitorStations.remove(temp);
            }
            if(temp != null && temp.getType() == "police_station"){
                policeStations.remove(temp);
            }
        }
    }
    
    public void upgradeBuilding(Buildable b){
        if(canChangeBuilding){
            if(b.getLevel()<3){
                if(money - b.getUpgradeCost()>0){
                    money -= b.getUpgradeCost();
                    gameField.setBalance(money);
                    b.setUpgradeCost(b.getUpgradeCost()*2);
                    b.setLevel(b.getLevel()+1);
                    b.setIncome(b.getIncome()*2);
                }
            }
        }
    }

    public void setCanChangeBuilding(boolean canChangeBuilding) {
        this.canChangeBuilding = canChangeBuilding;
    }

    public boolean getCanChangeBuilding() {
        return canChangeBuilding;
    }
    
    public void setNewBuildingToZero()
    {
        this.newBuilding = null;
    }
}

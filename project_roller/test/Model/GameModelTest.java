package Model;

import Sources.EmployeeState;
import Sources.EmployeeType;
import Sources.Images;
import Sources.UnitType;
import View.GameField;
import java.awt.Point;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class GameModelTest {
       
    GameModel gm = new GameModel(75, 10000, 150, 64, 32);
    GameField gf = new GameField();
    Point base = new Point(0,0);
    EmployeeSimulation sim = new EmployeeSimulation(gm);
    
    @Before
    public void setUp() {
        GameModel gm = new GameModel(75, 10000, 150, 64, 32);
    }
    
    @Test
    public void testGenerateStarterBoard(){
        int boardWidht = gm.getBoard().length;
        int boardHeight = gm.getBoard()[0].length;
        int numOfUnits = 0;
        for(int i = 0; i < boardWidht ; i++){
            for(int j = 0; j < boardHeight; j++){
                numOfUnits++;
            }
        }
        assertEquals(2048, numOfUnits);
    }
    
    @Test
    public void testStarterPack(){
        int numOfUsedUnits = 0;
        int numOfBuildings = 0;
        Unit board[][] = gm.getBoard();
        List<Buildable> built = gm.getBuilt();
        numOfBuildings = built.size();
        for(int i = 0 ; i < 32; i++){
            for(int j = 0; j < 64 ; j++){
                if(!board[i][j].isUsable()){
                    numOfUsedUnits++;
                }
            }
        }
        assertEquals(34, numOfUsedUnits);
        assertEquals(2, numOfBuildings);                
    }
    
    @Test
    public void testDestroyBuilding(){
        
        Buildable b = new Buildable(1000, 600, 0, 50, 0, 3, 3, new Point(29,26), false, "janitor_station", Images.JANITOR_STATION);
        gm.setGameField(gf);
        gm.destroyBuilding(b);
        
        int numOfUsedUnits = 0;
        int numOfBuildings = 0;
        int numOfEmptyUnits = 0;
        int numOfGrass = 0;
        Unit board[][] = gm.getBoard();
        List<Buildable> built = gm.getBuilt();
        numOfBuildings = built.size();
        int money = gm.getMoney();
        for(int i = 0 ; i < 32; i++){
            for(int j = 0; j < 64 ; j++){
                if(!board[i][j].isUsable()){
                    numOfUsedUnits++;
                }
                if(board[i][j].getType() == "empty"){
                    numOfEmptyUnits++;
                }
                if(board[i][j].getImageID() == Images.GRASS){
                    numOfGrass++;
                }
            }
        }
        
        assertEquals(25, numOfUsedUnits);
        assertEquals(1, numOfBuildings);
        assertEquals(2023, numOfEmptyUnits);
        assertEquals(2023, numOfGrass);
        assertEquals(10500, money);
    }
    
    @Test
    public void testUpgradeBuilding(){
        Buildable b = new Buildable(1000, 600, 0, 50, 0, 3, 3, new Point(26,29), false, "janitor_station", Images.JANITOR_STATION);
        gm.setGameField(gf);
        
        int lvl1 = b.getLevel();
        assertEquals(1, lvl1);
        
        gm.upgradeBuilding(b);
        int lvl2 = b.getLevel();
        assertEquals(2, lvl2);
        
        gm.upgradeBuilding(b);
        int lvl3 = b.getLevel();
        assertEquals(3, lvl3);
        
        gm.upgradeBuilding(b);
        int lvl4 = b.getLevel();
        assertEquals(3, lvl4);
        
    }
    
    @Test
    public void testAddToEmpList(){
        Employee e = new Employee(EmployeeType.JANITOR, EmployeeState.WAITING, Images.PATH, gm, base, sim);
        gm.addToEmployeeList(e);
        
        int employed = gm.getEmployed().size();

        assertEquals(15, employed);
    }
    
    @Test
    public void testDrawNewBuilding(){
        gm.setGameField(gf);
        Unit board[][] = gm.getBoard();
        int boardWidth = board.length;
        int boardHeigth = board[0].length;
        
        // 1. Nincs új épület kiválasztva és elérhető a terület és van elég pénz,
        gm.setSelectedAreaClear(true);
        gm.setMoney(10000);
        gm.setChosenPoint(new Point(10,10));
          
        gm.drawNewBuilding();
        
        int freeUnits = 0;
        for(int i = 0; i < boardWidth; i++ ){
            for(int j = 0; j < boardHeigth;j++){
                if(board[i][j].getType() == "empty"){
                    freeUnits++;
                }
            }
        }
        assertEquals(2014, freeUnits);
        
        // 2.Van épület, van rá pénz de nem elérhetőa  terület
        gm.setNewBuilding(UnitType.JANITOR_STATION);
        gm.setSelectedAreaClear(false);
        gm.setMoney(10000);
        gm.setChosenPoint(new Point(10,10));
          
        gm.drawNewBuilding();
        
        int freeUnits2 = 0;
        for(int i = 0; i < boardWidth; i++ ){
            for(int j = 0; j < boardHeigth;j++){
                if(board[i][j].getType() == "empty"){
                    freeUnits2++;
                }
            }
        }
        assertEquals(2014, freeUnits2);
        
        //3. Van épület nincs rá pénz a terület elérhető
        gm.setNewBuilding(UnitType.JANITOR_STATION);
        gm.setSelectedAreaClear(false);
        gm.setMoney(10);
        gm.setChosenPoint(new Point(10,10));
          
        gm.drawNewBuilding();
        
        int freeUnits3 = 0;
        for(int i = 0; i < boardWidth; i++ ){
            for(int j = 0; j < boardHeigth;j++){
                if(board[i][j].getType() == "empty"){
                    freeUnits3++;
                }
            }
        }
        assertEquals(2014, freeUnits3);
        
        
        // 4.Van épület van rá pénz és elérhetőa  terület és van épület
        gm.setNewBuilding(UnitType.JANITOR_STATION);
        gm.setSelectedAreaClear(true);
        gm.setMoney(10000);
        gm.setChosenPoint(new Point(10,10));
          
        gm.drawNewBuilding();
        
        int numOfImgID = 0;
        int numOfType = 0;
        int numOfUsable = 0;
        int JanStations = gm.getJanitorStations().size();
        int tools = gm.getTools().size();
        int freeUnits4 = 0;
        for(int i=10; i<13; i++){
            for(int j=10; j<13; j++){
                if(board[i][j].getImageID() == Images.JANITOR_STATION) numOfImgID++ ; 
                if(board[i][j].getType() == "janitor_station") numOfType++;
                if(!board[i][j].isUsable()) numOfUsable++;
            }
        }
        
        for(int i = 0; i < boardWidth; i++ ){
            for(int j = 0; j < boardHeigth;j++){
                if(board[i][j].getType() == "empty"){
                    freeUnits4++;
                }
            }
        }
        
        assertEquals(9, numOfImgID);
        assertEquals(9, numOfType);
        assertEquals(9, numOfUsable);
        assertEquals(2, JanStations);
        assertEquals(6, tools);
        assertEquals(2005, freeUnits4);
    }
}

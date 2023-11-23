package View;

import Model.Buildable;
import Model.Unit;
import Model.Employee;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import Model.GameModel;
import Sources.Images;
import java.util.ArrayList;
import Model.Visitor;
import Sources.EmployeeState;
import Sources.VisitorState;
import javax.swing.JOptionPane;

/**
 * Játéktérnek a grafikus reprezentációja
 */
public class GameArea extends JPanel{
    Unit[][] board;
    List<Buildable> built;
    private GameModel gameModel;
    private List<Unit> selected;
    
    int prevMin = 0;
    int currMin = 1;
    int times = 0;
    
    /**
     * Teljes konstruktor
     * EgérAkcióHallgató 
     * Ha van kiválasztott elem az EgérKattintásra leteszi azt, 
     * kivéve ha nem tudja ( GameModelben megadott logika alapján ),
     * ekkor piros kocka jelzi hogy az elem nem letehető
     * Amennyiben lehető új Unit jön létre a típusnak megfelelő mennyiségben 
     * a GameModelben, és ezt rajzolja ki.
     */
    public GameArea() {
        selected = new ArrayList<>();
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                boolean connected = false;
                boolean usable = true;
                boolean onLockedGrass = false;
                selected.clear();
                gameModel.setSelectedAreaClear(true);
                if (gameModel.getNewBuilding() != null) {
                    gameModel.getGameField().setBuyingCancelBtn(true);
                    
                    int sizeX = gameModel.getNewBuilding().getItem().getSizeX();
                    int sizeY = gameModel.getNewBuilding().getItem().getSizeY();
                    int MouseCoordX = e.getX() / 20;
                    int MouseCoordY = e.getY() / 20;
                    
                    if(MouseCoordY+sizeY>32 || MouseCoordX+sizeX>64){
                        usable = false;
                    }
                    
                    for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                        for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                            if(connectedToRoad(i, j)){
                                connected = true;
                            }
                            if(!board[i][j].isUsable()){
                                usable = false;
                            }
                            if(board[i][j].getType() == "locked_grass"){
                                onLockedGrass = true;
                            }
                            
                        }
                    }
                    
                    if(connected && usable){
                        if(!onLockedGrass && gameModel.getNewBuilding().getItem().getType() != "grass"){
                            for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                                for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                                    selected.add(new Unit(new Point(j,i),true,"selected", Images.CORRECTPLACE));
                                }
                            }
                        } else{
                            for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                                for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                                    selected.add(new Unit(new Point(j,i),true,"selected", Images.INCORRECTPLACE));
                                    gameModel.setSelectedAreaClear(false);
                                }
                            }
                        }
                    } else if(onLockedGrass){
                        if(gameModel.getNewBuilding().getItem().getType() == "grass"){
                            for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                                for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                                    selected.add(new Unit(new Point(j,i),true,"selected", Images.CORRECTPLACE));
                                }
                            }
                        } else {
                            for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                                for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                                    selected.add(new Unit(new Point(j,i),true,"selected", Images.INCORRECTPLACE));
                                    gameModel.setSelectedAreaClear(false);
                                }
                            }
                        }
                    } else {
                        for(int i=MouseCoordY; i<MouseCoordY+sizeY && i<board.length;i++){
                            for(int j=MouseCoordX; j<MouseCoordX+sizeX && j<board[0].length; j++){
                                selected.add(new Unit(new Point(j,i),true,"selected", Images.INCORRECTPLACE));
                                gameModel.setSelectedAreaClear(false);
                            }
                        }
                    }
                }
                else{
                    gameModel.getGameField().setBuyingCancelBtn(false);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / 20;
                int y = e.getY() / 20;
                
                //játék letevéséhez
                gameModel.setChosenPoint(new Point(x, y));
                gameModel.drawNewBuilding();
                refresh(gameModel);

                //játék adatainak megvizsgálásához
                if(selected.isEmpty()){
                    for(int i=0; i<built.size(); i++){
                        Buildable b = built.get(i);
                        if(b.getPosition().y <= x && b.getPosition().y+b.getSizeX() > x && b.getPosition().x <= y && b.getPosition().x+b.getSizeY() > y){
                            String[] buttons = { "Fejlesztés", "Rombolás" };
                            if(gameModel.getCanChangeBuilding()){
                                int choice = JOptionPane.showOptionDialog(null, "Szint: " + b.getLevel() + "\n" + "Kapacitás: " + b.getCapacity() + "\n" + "Bevétel: " + b.getIncome() + "\n",
                                "Játék adatai",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);

                                switch(choice){
                                    case 0: 
                                        gameModel.upgradeBuilding(b);
                                        break;
                                    case 1:
                                        gameModel.destroyBuilding(b);
                                        break;
                                    default:
                                }
                            }
                            else{
                                JOptionPane.showOptionDialog(null, "Szint: " + b.getLevel() + "\n" + "Kapacitás: " + b.getCapacity() + "\n" + "Bevétel: " + b.getIncome() + "\n",
                                "Játék adatai", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                            }
                        }
                    }
                }
                
                selected.clear();
            }

            private boolean connectedToRoad(int i, int j) {
                boolean connect = false;
                if (i + 1 < 32 && board[i + 1][j].getType() == "path"
                        || i - 1 >= 0 && board[i - 1][j].getType() == "path"
                        || j + 1 < 64 && board[i][j + 1].getType() == "path"
                        || j - 1 >= 0 && board[i][j - 1].getType() == "path") {
                    connect = true;
                }
                return connect;
            }
        };
        addMouseMotionListener(adapter);
        addMouseListener(adapter);
    }
    
    public GameArea(Unit[][] board, List<Buildable> built){
        setPreferredSize(new java.awt.Dimension(1280,640));
        
        this.board = board;
        this.built = built;
    }
    
    /**
     * @param gameModel változó frissítése
     * Ez alapján frissül a board és built változó
     */
    public void refresh(GameModel gameModel){
        this.gameModel = gameModel;
        this.board = gameModel.getBoard();
        this.built = gameModel.getBuilt();
    }
    
    /**
     * paintComponent felülírása és testreszabása:
     * Végigmegy a boardon és kirjalzolja az adott Unit képét
     * Ha van selected lista, akkor hozzáveszi (kirajzolja) az új területet
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        
        
        super.paintComponent(g);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                g.drawImage(board[i][j].getImageID().getImage(), board[i][j].getPosition().y*20, board[i][j].getPosition().x*20, null);
            }
        }
        
        for(Unit u:selected){
            g.drawImage(u.getImageID().getImage(), u.getPosition().x*20, u.getPosition().y*20, null);
        }   
        repaint();
        
        if(currMin != prevMin ){
             //simulating visitor movement
            for(int i=0; i<gameModel.getVisitorSimulation().getVisitors().size(); i++){
                Visitor v = gameModel.getVisitorSimulation().getVisitors().get(i);
                if(v.getState() == VisitorState.ROAMING || v.getState() == VisitorState.WAITING){
                    g.drawImage(v.getImageID().getImage(), v.getRealPosition().y, v.getRealPosition().x, null);
                }
                v.setRealPosition();
            }
            //thief
            Employee thief = gameModel.getEmployeeSimulation().getThief();
            if(thief != null){
                g.drawImage(thief.getImageID().getImage(), thief.getRealPosition().y, thief.getRealPosition().x, null);
                thief.setRealPosition();
            }
            
            //chasing officer
            for(int i=0; i<gameModel.getEmployeeSimulation().getOfficers().size() && gameModel.getEmployeeSimulation().getOfficers().get(i) != null; i++){
                Employee e = gameModel.getEmployeeSimulation().getOfficers().get(i);
                if(e.getState() == EmployeeState.CATCHING){
                    g.drawImage(Images.OFFICER.getImage(), e.getRealPosition().y, e.getRealPosition().x, null);
                    e.setRealPosition();
                    e.setRealPosition();
                }
            }      
            
        } else {
            //simulating visitor movement
            for(int i=0; i<gameModel.getVisitorSimulation().getVisitors().size(); i++){
                Visitor v = gameModel.getVisitorSimulation().getVisitors().get(i);
                if(v.getState() == VisitorState.ROAMING || v.getState() == VisitorState.WAITING){
                    g.drawImage(v.getImageID().getImage(), v.getRealPosition().y, v.getRealPosition().x, null);
                }
            }
            
            Employee thief = gameModel.getEmployeeSimulation().getThief();
            if(thief != null){
                g.drawImage(thief.getImageID().getImage(), thief.getRealPosition().y, thief.getRealPosition().x, null);
                //thief.setRealPosition();
            }
            
            //chasing officer
            for(int i=0; i<gameModel.getEmployeeSimulation().getOfficers().size() && gameModel.getEmployeeSimulation().getOfficers().get(i) != null; i++){
                Employee e = gameModel.getEmployeeSimulation().getOfficers().get(i);
                if(e.getState() == EmployeeState.CATCHING){
                    g.drawImage(Images.OFFICER.getImage(), e.getRealPosition().y, e.getRealPosition().x, null);
                }
            } 
        }
        
        
        if(currMin != prevMin && currMin % 2 == 0){
            prevMin = currMin;
            currMin = Integer.parseInt(gameModel.getGameTime().getDate().split(":")[1]);
            
            for(int i=0; i<gameModel.getEmployeeSimulation().getJanitors().size() && gameModel.getEmployeeSimulation().getJanitors().get(i) != null; i++){
                Employee e = gameModel.getEmployeeSimulation().getJanitors().get(i);
                if(e.getState().equals(EmployeeState.CLEANING)){
                    g.drawImage(Images.JANITOR.getImage(), e.getRealPosition().y, e.getRealPosition().x, null);
                }
                e.setRealPosition();
            }

            for(int i=0; i<gameModel.getEmployeeSimulation().getOfficers().size() && gameModel.getEmployeeSimulation().getOfficers().get(i) != null; i++){
                Employee e = gameModel.getEmployeeSimulation().getOfficers().get(i);
                if(e.getState() == EmployeeState.PATROLLING){
                    g.drawImage(Images.OFFICER.getImage(), e.getRealPosition().y, e.getRealPosition().x, null);
                }
                e.setRealPosition();
            }
        } else {
            currMin = Integer.parseInt(gameModel.getGameTime().getDate().split(":")[1]);
            
            
            
            for(int i=0; i<gameModel.getEmployeeSimulation().getJanitors().size() && gameModel.getEmployeeSimulation().getJanitors().get(i) != null; i++){
                Employee e = gameModel.getEmployeeSimulation().getJanitors().get(i);
                if(e.getState().equals(EmployeeState.CLEANING)){
                    g.drawImage(Images.JANITOR.getImage(), e.getRealPosition().y, e.getRealPosition().x, null);
                }
                
                
            }

            for(int i=0; i<gameModel.getEmployeeSimulation().getOfficers().size() && gameModel.getEmployeeSimulation().getOfficers().get(i) != null; i++){
                Employee e = gameModel.getEmployeeSimulation().getOfficers().get(i);
                if(e.getState() == EmployeeState.PATROLLING){
                    g.drawImage(Images.OFFICER.getImage(), e.getRealPosition().y, e.getRealPosition().x, null);
                }
            }
        }

    }
}

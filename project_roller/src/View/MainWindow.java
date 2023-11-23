package View;

//own class imports
import Model.GameModel;
import Sources.DifficultyLevel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;

//java imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 * Fő ablak, amely váltogatja a megjelenítendő paneleket
 */
public class MainWindow extends JFrame{
    private final JFrame mainWindow;
    private Menu menuPanel;
    private NewGame newgamePanel;
    private Tutorial tutorialPanel;
    private HighScore highscorePanel;
    private GameMenu gamemenuPanel;
    private GameField gamefieldPanel;
    private Shop shopPanel;
    private DifficultyLevel dif;
    private String parkName;
    private GameModel gameModel;  
    /**
     * Teljes konstruktor
     */
public MainWindow(){ 
        mainWindow = new JFrame("Project Roller");
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainWindow.setSize(1280,720);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
        menuPanel = new Menu(this);
        mainWindow.getContentPane().add(menuPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
        
        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                     null, "Are You Sure to Close Application?", 
                     "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                     JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    JPanel p = new JPanel();
                    try {
                        switchToExit(p);
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        mainWindow.addWindowListener(exitListener);
        
        gameModel = new GameModel(75, 10000, 500, 64, 32);
    };
 
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToNewGame(JPanel p){
        mainWindow.remove(p);
        newgamePanel = new NewGame(this);
        mainWindow.getContentPane().add(newgamePanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToTutorial(JPanel p){
        mainWindow.remove(p);
        tutorialPanel = new Tutorial(this);
        mainWindow.getContentPane().add(tutorialPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToHighScore(JPanel p){
        mainWindow.remove(p);
        highscorePanel = new HighScore(this);
        mainWindow.getContentPane().add(highscorePanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToExit(JPanel p) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get("").toAbsolutePath().toString() +"/src/Highscore/highscores.txt",true));
        if(parkName == null)
        {
            System.exit(0);
        }
        String res = gameModel.getGameTime().getDate().split(",")[0] + ";" + parkName + ";" + gameModel.getMoney() + ";" + gameModel.getHappiness() + "\r\n";
        writer.write(res);
        writer.close();
        System.exit(0);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToMain(JPanel p){
        mainWindow.remove(p);
        menuPanel = new Menu(this);
        mainWindow.getContentPane().add(menuPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToGameMenu(JPanel p)
    {
        mainWindow.remove(p);
        gamemenuPanel = new GameMenu(this);
        mainWindow.getContentPane().add(gamemenuPanel);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToGameField(JPanel p){
        mainWindow.remove(p);
        gamefieldPanel = new GameField(this);
        gamefieldPanel.setDif(newgamePanel.getDif());
        dif = newgamePanel.getDif();
        gameModel.getGameTime().setGameField(gamefieldPanel);
        gamefieldPanel.setGameModel(gameModel);
        gameModel.setGameField(gamefieldPanel);
        mainWindow.getContentPane().add(gamefieldPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
    
    /**
     * Adott panelra váltás
     * @param p 
     */
    public void switchToShop(JPanel p){
        mainWindow.remove(p);
        shopPanel = new Shop(this);
        mainWindow.getContentPane().add(shopPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    public GameModel getGameModel() {
        return gameModel;
    }
    
    /**
     * gameModel alaphelyzetbe állítása
     */
    public void reset(){
        gameModel = new GameModel(75, 10000, 500, 64, 32);
    }

    public DifficultyLevel getDif() {
        return dif;
    }

    public void setDif(DifficultyLevel dif) {
        this.dif = dif;
    }
    
    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
}

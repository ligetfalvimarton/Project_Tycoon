package View;

import Model.GameModel;
import Model.Unit;
import Sources.DifficultyLevel;
import Sources.Images;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Játékfelület megvalósítása
 */
public class GameField extends JPanel {

    private final MainWindow window;
    private Model.GameModel gameModel;
    private int balance;
    private DifficultyLevel dif;

    public MainWindow getWindow() {
        return window;
    }
    
    /**
     * Alap konstuktor
     * @param window 
     */
    public GameField(final MainWindow window) {
        this.window = window;
        initComponents();
        setMoneyText();
        setHappinessText(window.getGameModel().getHappiness());
        buyingCancelBtn.setVisible(false);
    }

    public GameField(){
        this.window = null;
    }

    public DifficultyLevel getDif() {
        return dif;
    }

    public void setDif(DifficultyLevel dif) {
        this.dif = dif;
    }
    
    /**
     * Model beállítása.
     * @param gameModel 
     */
    public void setGameModel(GameModel gameModel){
        GameModel gm = initLockedGrass(gameModel, dif);
        this.gameModel = gm;
        balance = gameModel.getMoney();
        setMoneyText();
    }
    
    /**
     * Lezárt területek kigenerálása.
     * @param gm
     * @param dif
     * @return 
     */
    public GameModel initLockedGrass(GameModel gm, DifficultyLevel dif){
        GameModel initedGameModel = gm;
        Unit board[][] = gm.getBoard();
        
        if(dif == DifficultyLevel.NORMAL && !gm.isStarted()){
            for(int i =0; i<7;i++){
                for(int j = 0; j<board[0].length;j++){
                    board[i][j] = new Unit(new Point(i,j), false, "locked_grass", Images.LOCKED_GRASS);
                }
            }
            for(int i = 0; i<board.length;i++){
                for(int j = board[0].length-1; j>board[0].length-8;j--){
                    board[i][j] = new Unit(new Point(i,j), false, "locked_grass", Images.LOCKED_GRASS);
                }
            }
            gm.setStarted(true);
            
        }
        
        if(dif == DifficultyLevel.HARD && !gm.isStarted()){

            for(int i =0; i<7;i++){
                for(int j = 0; j<board[0].length;j++){
                    board[i][j] = new Unit(new Point(i,j), false, "locked_grass", Images.LOCKED_GRASS);
                }
            }
            
            for(int i = 0; i<board.length;i++){
                for(int j = 0; j<7;j++){
                    board[i][j] = new Unit(new Point(i,j), false, "locked_grass", Images.LOCKED_GRASS);
                }
            }
            
            for(int i = 0; i<board.length;i++){
                for(int j = board[0].length-1; j>board[0].length-8;j--){
                    board[i][j] = new Unit(new Point(i,j), false, "locked_grass", Images.LOCKED_GRASS);
                }
            }
            
            gm.setStarted(true);
        }
        if(gm.isStarted()){
            for(int i =0; i<7;i++){
                for(int j = 0; j<board[0].length;j++){
                    if(board[i][j].getType() == "grass"){
                        board[i][j].setType("empty");
                        board[i][j].setUsable(true);
                    } 
                }
            }
            for(int i = 0; i<board.length;i++){
                for(int j = 0; j<7;j++){
                    if(board[i][j].getType() == "grass"){
                        board[i][j].setType("empty");
                        board[i][j].setUsable(true);
                    } 
                }
            }
            
            for(int i = 0; i<board.length;i++){
                for(int j = board[0].length-1; j>board[0].length-8;j--){
                    if(board[i][j].getType() == "grass"){
                        board[i][j].setType("empty");
                        board[i][j].setUsable(true);
                    } 
                }
            }
        }
        
        initedGameModel.setBoard(board);
        
        return initedGameModel;
    }
    
    /**
     * Frissítés.
     */
    public void refresh(){
        removeAll();
        initComponents();
        setMoneyText();    
        setHappinessText(window.getGameModel().getHappiness());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shop = new javax.swing.JButton();
        Pause = new javax.swing.JButton();
        Forward = new javax.swing.JButton();
        dateText = new javax.swing.JLabel();
        happinessMeter = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        Backward = new javax.swing.JButton();
        gameArea1 = new View.GameArea();
        buyingCancelBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        shop.setText("Bolt");
        shop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopActionPerformed(evt);
            }
        });

        Pause.setText("||");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausePressed(evt);
            }
        });

        Forward.setText(">>");
        Forward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardPressed(evt);
            }
        });

        money.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        money.setText("Pénz : xxx");

        Backward.setText("<<");
        Backward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backwardPressed(evt);
            }
        });

        gameArea1.refresh(window.getGameModel());
        window.getGameModel().getVisitorSimulation().Simulate();

        javax.swing.GroupLayout gameArea1Layout = new javax.swing.GroupLayout(gameArea1);
        gameArea1.setLayout(gameArea1Layout);
        gameArea1Layout.setHorizontalGroup(
            gameArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        gameArea1Layout.setVerticalGroup(
            gameArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        buyingCancelBtn.setText("Vásárlás megszakítása");
        buyingCancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buyingCancelBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(happinessMeter))
                    .addComponent(shop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buyingCancelBtn)
                .addGap(155, 155, 155)
                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(Backward)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Forward)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(gameArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gameArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(shop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(happinessMeter)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Forward)
                                    .addComponent(Pause)
                                    .addComponent(Backward))
                                .addComponent(buyingCancelBtn, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void shopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopActionPerformed
        window.switchToShop(this);
    }//GEN-LAST:event_shopActionPerformed

    private void pausePressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausePressed

        if(Pause.getText() == "||"){
            gameModel.getGameTime().StopTime();
            Pause.setText(">");
            //add pause menu
        } else {
            gameModel.getGameTime().NormalTime();
            Pause.setText("||");
        }
        
        window.switchToGameMenu(this);
    }//GEN-LAST:event_pausePressed

    private void forwardPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardPressed
        gameModel.getGameTime().FasterTime();
    }//GEN-LAST:event_forwardPressed

    private void backwardPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backwardPressed
        gameModel.getGameTime().NormalTime();
    }//GEN-LAST:event_backwardPressed

    private void buyingCancelBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyingCancelBtnMousePressed
        gameModel.setNewBuildingToZero();
    }//GEN-LAST:event_buyingCancelBtnMousePressed

    /**
     * Különböző feladatok időnkénti meghívása.
     * @param date
     * @throws IOException 
     */
    public void setDateText(String date) throws IOException{
        if(Integer.parseInt(date.split(":")[1])%30 == 0) {
            window.getGameModel().getVisitorSimulation().Simulate();
        }
        if("08:00".equals(date.split("nap, ")[1])){
            window.getGameModel().getVisitorSimulation().generateDailyVisitors(window.getGameModel().getHappiness(),window.getGameModel().getBuilt());
            gameModel.setCanChangeBuilding(false);
            window.getGameModel().getEmployeeSimulation().createMess();
        }
        if("10:00".equals(date.split("nap, ")[1])){
            window.getGameModel().getEmployeeSimulation().createMess();
        }
        if("12:00".equals(date.split("nap, ")[1])){
            window.getGameModel().getEmployeeSimulation().createMess();
        }
        if("14:00".equals(date.split("nap, ")[1])){
            window.getGameModel().getEmployeeSimulation().createMess();
        }
        if("16:00".equals(date.split("nap, ")[1])){
            window.getGameModel().getEmployeeSimulation().createMess();
            window.getGameModel().getEmployeeSimulation().spawnThief();
        }
        if("22:00".equals(date.split("nap, ")[1])){
            window.getGameModel().getVisitorSimulation().emptyVisitors();
            endOfDayIncome();
            gameModel.setCanChangeBuilding(true);
            if(balance<0) gameOver();
        }
        
        dateText.setText(date);
    }
    
    public void moneyIncome(int m){
        balance += m;
    }
    
    public void moneyExpense(int m){
        balance -= m;
    }
    
    public void setMoneyText(){
        money.setText("Pénz: " + balance + "$");
    }

    public int getBalance() {
        return balance;
    }
      
    /**
     * Napvégi pénzérték.
     */
    public void endOfDayIncome(){
        int cost = 0;
        for(int i = 0;i< gameModel.getBuilt().size();i++)
        {
            cost += gameModel.getBuilt().get(i).getCost();
        }
        gameModel.setMoney(gameModel.getMoney() - cost);
        balance = gameModel.getMoney();
        setMoneyText();
        setHappinessText(window.getGameModel().getHappiness());
    }
    
    public GameArea getGameArea() {
        return gameArea1;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        if(balance < 0){
            try {
                gameOver();
            } catch (IOException ex) {
                Logger.getLogger(GameField.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setHappinessText(int happiness){
        this.happinessMeter.setText(happiness + "/100");
    }

    public void setBuyingCancelBtn(boolean b) {
        buyingCancelBtn.setVisible(b);
    }
    
    /**
     * Játék vége.
     * @throws IOException 
     */
    public void gameOver() throws IOException{
        window.getGameModel().getGameTime().StopTime();
        String[] exit = {"Kilépés"};
        int choice = JOptionPane.showOptionDialog(null, "A játék véget ért!", "Game Over",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, exit, exit[0]);
        if(choice == 0)
            window.switchToExit(this);
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backward;
    private javax.swing.JButton Forward;
    private javax.swing.JButton Pause;
    private javax.swing.JButton buyingCancelBtn;
    private javax.swing.JLabel dateText;
    private View.GameArea gameArea1;
    private javax.swing.JLabel happinessMeter;
    private javax.swing.JLabel money;
    private javax.swing.JButton shop;
    // End of variables declaration//GEN-END:variables
}

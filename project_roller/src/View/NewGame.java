package View;

import Sources.DifficultyLevel;
import javax.swing.JOptionPane;

/**
 * Új játék panel
 */
public class NewGame extends javax.swing.JPanel {

    private final MainWindow window;
    private DifficultyLevel dif;
    private String parkName;
    
    public NewGame(final MainWindow window) {
        this.window = window;
        initComponents();
    }
    
    private void setParkName(String s){
        parkName = s;
    }

    public DifficultyLevel getDif() {
        return dif;
    }

    public void setDif(DifficultyLevel dif) {
        this.dif = dif;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        beginnerBtn = new javax.swing.JButton();
        normalBtn = new javax.swing.JButton();
        hardBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nehézségi szint");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        beginnerBtn.setText("Kezdő");
        beginnerBtn.setPreferredSize(new java.awt.Dimension(100, 40));
        beginnerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginnerBtnActionPerformed(evt);
            }
        });

        normalBtn.setText("Normál");
        normalBtn.setPreferredSize(new java.awt.Dimension(100, 40));
        normalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalBtnActionPerformed(evt);
            }
        });

        hardBtn.setText("Haladó");
        hardBtn.setPreferredSize(new java.awt.Dimension(100, 40));
        hardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Vissza");
        backBtn.setPreferredSize(new java.awt.Dimension(80, 23));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(212, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(normalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beginnerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(beginnerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(normalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(hardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Park nevének meghatározása.
     * @param evt 
     */
    private void normalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalBtnActionPerformed
        dif = DifficultyLevel.NORMAL;
        String name = JOptionPane.showInputDialog("Park neve: ", "Park");
        if(name!=null){
            if (name.trim().length() == 0) {
            name = "Park";
            }
            parkName = name;
            window.setParkName(name);
            setDif(dif);
            window.switchToGameField(this);
            window.getGameModel().getGameTime().start();
        }
    }//GEN-LAST:event_normalBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        window.switchToMain(this);
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * Park nevének meghatározása.
     * @param evt 
     */
    private void beginnerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginnerBtnActionPerformed
        dif = DifficultyLevel.BEGINNER;
        String name = JOptionPane.showInputDialog("Park neve: ", "Park");
        if(name!=null){
            if (name.trim().length() == 0) {
            name = "Park";
            }
            parkName = name;
            window.setParkName(name);
            setDif(dif);
            window.switchToGameField(this);
            window.getGameModel().getGameTime().start();
        }

    }//GEN-LAST:event_beginnerBtnActionPerformed

    private void hardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardBtnActionPerformed
        dif = DifficultyLevel.HARD;
        String name = JOptionPane.showInputDialog("Park neve: ", "Park");
        if(name!=null){
            if (name.trim().length() == 0) {
            name = "Park";
            }
            parkName = name;
            window.setParkName(name);
            setDif(dif);
            window.switchToGameField(this);
            window.getGameModel().getGameTime().start();
        }

    }//GEN-LAST:event_hardBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton beginnerBtn;
    private javax.swing.JButton hardBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton normalBtn;
    // End of variables declaration//GEN-END:variables
}

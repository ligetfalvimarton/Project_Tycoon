package View;

import Sources.DifficultyLevel;
import Sources.ShopState;
import Sources.UnitType;
import java.awt.Color;

/**
 * A bolt felülete
 */
public class Shop extends javax.swing.JPanel {
    
    private ShopState shopState = ShopState.TOYS;;

    private final MainWindow window;
    public Shop(final MainWindow window) {
        this.window = window;
        initComponents();
        switchToToys();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shopCloseButton = new javax.swing.JButton();
        toysButton = new javax.swing.JButton();
        accessoriesButton = new javax.swing.JButton();
        employeesButton = new javax.swing.JButton();
        buildPic2 = new javax.swing.JLabel();
        buildPic1 = new javax.swing.JLabel();
        buildPic3 = new javax.swing.JLabel();
        buildPrice1 = new javax.swing.JLabel();
        buildCost1 = new javax.swing.JLabel();
        buildPrice2 = new javax.swing.JLabel();
        buildCost2 = new javax.swing.JLabel();
        buildPrice3 = new javax.swing.JLabel();
        buildCost3 = new javax.swing.JLabel();
        buildCost4 = new javax.swing.JLabel();
        buildPrice5 = new javax.swing.JLabel();
        buildCost5 = new javax.swing.JLabel();
        buildPrice6 = new javax.swing.JLabel();
        buildCost6 = new javax.swing.JLabel();
        buildPic5 = new javax.swing.JLabel();
        buildPic4 = new javax.swing.JLabel();
        buildPic6 = new javax.swing.JLabel();
        buildPrice4 = new javax.swing.JLabel();
        buildPic7 = new javax.swing.JLabel();
        buildPrice7 = new javax.swing.JLabel();
        buildCost7 = new javax.swing.JLabel();
        buildPic8 = new javax.swing.JLabel();
        buildPrice8 = new javax.swing.JLabel();
        buildCost8 = new javax.swing.JLabel();
        buildPic9 = new javax.swing.JLabel();
        buildPrice9 = new javax.swing.JLabel();
        buildCost9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        shopCloseButton.setText("Bezárás");
        shopCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopCloseButtonActionPerformed(evt);
            }
        });

        toysButton.setBackground(new java.awt.Color(255, 255, 0));
        toysButton.setText("Játékok");
        toysButton.setPreferredSize(new java.awt.Dimension(100, 50));
        toysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toysButtonActionPerformed(evt);
            }
        });

        accessoriesButton.setText("Kiegészítők");
        accessoriesButton.setPreferredSize(new java.awt.Dimension(100, 50));
        accessoriesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessoriesButtonActionPerformed(evt);
            }
        });

        employeesButton.setText("Alkalmazottak");
        employeesButton.setPreferredSize(new java.awt.Dimension(100, 50));
        employeesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesButtonActionPerformed(evt);
            }
        });

        buildPic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toy11.jpg"))); // NOI18N
        buildPic2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic2MousePressed(evt);
            }
        });

        buildPic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toy12.jpg"))); // NOI18N
        buildPic1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic1MousePressed(evt);
            }
        });

        buildPic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toy5.jpg"))); // NOI18N
        buildPic3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic3MousePressed(evt);
            }
        });

        buildPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice1.setText("1000 Ft");

        buildCost1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost1.setText("10 Ft");

        buildPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice2.setText("1000 Ft");

        buildCost2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost2.setText("10 Ft");

        buildPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice3.setText("1000 Ft");

        buildCost3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost3.setText("10 Ft");

        buildCost4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost4.setText("10 Ft");

        buildPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice5.setText("1000 Ft");

        buildCost5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost5.setText("10 Ft");

        buildPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice6.setText("1000 Ft");

        buildCost6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost6.setText("10 Ft");

        buildPic5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/mysteri.png"))); // NOI18N
        buildPic5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic5MousePressed(evt);
            }
        });

        buildPic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toy9.jpg"))); // NOI18N
        buildPic4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic4MousePressed(evt);
            }
        });

        buildPic6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/game3.png"))); // NOI18N
        buildPic6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic6MousePressed(evt);
            }
        });

        buildPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice4.setText("1000 Ft");

        buildPic7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/game2.png"))); // NOI18N
        buildPic7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic7MousePressed(evt);
            }
        });

        buildPrice7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice7.setText("1000 Ft");

        buildCost7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost7.setText("10 Ft");

        buildPic8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/tree.jpg"))); // NOI18N
        buildPic8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic8MousePressed(evt);
            }
        });

        buildPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice8.setText("1000 Ft");

        buildCost8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost8.setText("10 Ft");

        buildPic9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/grass.jpg"))); // NOI18N
        buildPic9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buildPic9MousePressed(evt);
            }
        });

        buildPrice9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildPrice9.setText("100 Ft");

        buildCost9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buildCost9.setText("0 Ft");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buildPrice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buildCost1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buildPrice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buildCost2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(211, 211, 211)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buildPrice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buildCost3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(shopCloseButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(toysButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(buildPic4)
                                                    .addComponent(buildPic1)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(buildPic7)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(buildPrice7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(buildCost7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(34, 34, 34))))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(accessoriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(120, 120, 120)
                                                        .addComponent(employeesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(buildPic2)
                                                        .addGap(141, 141, 141)
                                                        .addComponent(buildPic3))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(162, 162, 162)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(buildPrice8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buildCost8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(204, 204, 204)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(buildPrice9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buildCost9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(buildPrice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buildCost4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(206, 206, 206)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(buildPrice5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buildCost5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(201, 201, 201)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(buildPrice6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buildCost6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(230, 230, 230)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(buildPic8)
                                                    .addComponent(buildPic5))
                                                .addGap(141, 141, 141)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(buildPic6)
                                                    .addComponent(buildPic9))))
                                        .addGap(9, 9, 9)))
                                .addGap(0, 335, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shopCloseButton)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toysButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accessoriesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buildPic2)
                    .addComponent(buildPic3)
                    .addComponent(buildPic1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(buildPrice1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildCost1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(buildPrice2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildCost2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(buildPrice3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildCost3)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buildPic5)
                    .addComponent(buildPic6)
                    .addComponent(buildPic4))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buildPrice6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildCost6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buildPrice4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildCost4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buildPrice5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildCost5)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buildPic7)
                        .addGap(14, 14, 14)
                        .addComponent(buildPrice7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buildCost7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buildPic8)
                            .addComponent(buildPic9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(buildPrice8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buildCost8))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buildPrice9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buildCost9)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Kilép a boltból, vissza a játékmezőre
     */
    private void shopCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopCloseButtonActionPerformed
    window.switchToGameField(this);
    }//GEN-LAST:event_shopCloseButtonActionPerformed

    /**
     * Átvált a "játékok" oldalra a boltban
     */
    private void toysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toysButtonActionPerformed
        toysButton.setBackground(Color.YELLOW);
        accessoriesButton.setBackground(null);
        employeesButton.setBackground(null);
        
        shopState = ShopState.TOYS;
        
        switchToToys();
    }//GEN-LAST:event_toysButtonActionPerformed

    /**
     *Átvált a "kiegésítők" oldalra a boltban
     */
    private void accessoriesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessoriesButtonActionPerformed
        toysButton.setBackground(null);
        accessoriesButton.setBackground(Color.YELLOW);
        employeesButton.setBackground(null);
        
        shopState = ShopState.ACCESSORIES;
        
        switchToAccessories();
    }//GEN-LAST:event_accessoriesButtonActionPerformed

    /**
     * Átvált a "alkalmazottak" oldalra a boltban
     */
    private void employeesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesButtonActionPerformed
        toysButton.setBackground(null);
        accessoriesButton.setBackground(null);
        employeesButton.setBackground(Color.YELLOW);
        
        shopState = ShopState.EMPLOYEES;
        
        switchToEmployees();
    }//GEN-LAST:event_employeesButtonActionPerformed

    /**
     * Átadja megvett játék típusát és visszavált a játékmezőre
     */
    private void buildPic1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic1MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){window.getGameModel().setNewBuilding(UnitType.RAMEN);}
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.BIN);}
        else if(shopState == ShopState.EMPLOYEES){window.getGameModel().setNewBuilding(UnitType.JANITOR_STATION);}
    }//GEN-LAST:event_buildPic1MousePressed

    private void buildPic4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic4MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){window.getGameModel().setNewBuilding(UnitType.YURTA);}
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.BUSH3);}
        else if(shopState == ShopState.EMPLOYEES){ /*empty*/ }
    }//GEN-LAST:event_buildPic4MousePressed

    private void buildPic7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic7MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){window.getGameModel().setNewBuilding(UnitType.SCARY);}
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.TOITOI);}
        else if(shopState == ShopState.EMPLOYEES){ /*empty*/ }
    }//GEN-LAST:event_buildPic7MousePressed

    private void buildPic8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic8MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){ /*empty*/ }
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.TREE);}
        else if(shopState == ShopState.EMPLOYEES){ /*empty*/ }
    }//GEN-LAST:event_buildPic8MousePressed

    private void buildPic2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic2MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){window.getGameModel().setNewBuilding(UnitType.CASTLE);}
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.BUSH1);}
        else if(shopState == ShopState.EMPLOYEES){window.getGameModel().setNewBuilding(UnitType.POLICE_STATION);}
    }//GEN-LAST:event_buildPic2MousePressed

    private void buildPic3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic3MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){window.getGameModel().setNewBuilding(UnitType.UPDOWN);}
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.BUSH2);}
        else if(shopState == ShopState.EMPLOYEES){window.getGameModel().setNewBuilding(UnitType.RESTAURANT);}
        
    }//GEN-LAST:event_buildPic3MousePressed

    private void buildPic5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic5MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){window.getGameModel().setNewBuilding(UnitType.MYSTERI);}
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.FOUNTAIN);}
        else if(shopState == ShopState.EMPLOYEES){ /*empty*/ }
    }//GEN-LAST:event_buildPic5MousePressed

    private void buildPic6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic6MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){window.getGameModel().setNewBuilding(UnitType.POKE);}
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.PATH);}
        else if(shopState == ShopState.EMPLOYEES){ /*empty*/ }
    }//GEN-LAST:event_buildPic6MousePressed

    private void buildPic9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buildPic9MousePressed
        window.switchToGameField(this);
        if(shopState == ShopState.TOYS){ /*empty*/ }
        else if(shopState == ShopState.ACCESSORIES){window.getGameModel().setNewBuilding(UnitType.GRASS);}
        else if(shopState == ShopState.EMPLOYEES){ /*empty*/ }
    }//GEN-LAST:event_buildPic9MousePressed

    private void switchToAccessories(){
        
        buildPic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/bin.jpg")));
        buildPic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/bush1.jpg")));
        buildPic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/bush2.jpg")));
        buildPic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/bush3.jpg")));
        buildPic5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/fountain.jpg")));
        buildPic6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/path.jpg")));
        buildPic7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toitoi.jpg")));
        buildPic8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/tree.jpg")));
        buildPic9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/grass.jpg")));
        
        buildPrice1.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice1.setText("625 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice1.setText("750 $");
        else buildPrice1.setText("500 $");
        buildPic1.setVisible(true);
        buildCost1.setVisible(true);
        buildCost1.setText("0 $");
        
        buildPrice2.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice2.setText("225 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice2.setText("300 $");
        else buildPrice2.setText("200 $");
        buildPic2.setVisible(true);
        buildCost2.setVisible(true);
        buildCost2.setText("0 $");
        
        buildPrice3.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice3.setText("225 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice3.setText("300 $");
        else buildPrice3.setText("200 $");
        buildPic3.setVisible(true);
        buildCost3.setVisible(true);
        buildCost3.setText("0 $");
        
        buildPrice4.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice4.setText("225 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice4.setText("300 $");
        else buildPrice4.setText("200 $");
        buildPic4.setVisible(true);
        buildCost4.setVisible(true);
        buildCost4.setText("0 $");
        
        buildPrice5.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice5.setText("625 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice5.setText("750 $");
        else buildPrice5.setText("500 $");
        buildPic5.setVisible(true);
        buildCost5.setVisible(true);
        buildCost5.setText("0 $");
        
        buildPrice6.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice6.setText("125 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice6.setText("150 $");
        else buildPrice6.setText("100 $");
        buildPic6.setVisible(true);
        buildCost6.setVisible(true);
        buildCost6.setText("0 $");
        
        buildPrice7.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice7.setText("625 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice7.setText("750 $");
        else buildPrice7.setText("500 $");
        buildPic7.setVisible(true);
        buildCost7.setVisible(true);
        buildCost7.setText("0 $");
        
        buildPrice8.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice8.setText("375 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice8.setText("450 $");
        else buildPrice8.setText("300 $");
        buildPic8.setVisible(true);
        buildCost8.setVisible(true);
        buildCost8.setText("0 $");
        
        buildPrice9.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice9.setText("125 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice9.setText("150 $");
        else buildPrice9.setText("100 $");
        buildPic9.setVisible(true);
        buildCost9.setVisible(true);
        buildCost9.setText("0 $");
    }
    
    private void switchToToys(){
        
        buildPic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toy12.jpg")));
        buildPic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toy11.jpg")));
        buildPic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toy5.jpg")));
        buildPic4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/toy9.jpg")));
        buildPic5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/mysteri.png")));
        buildPic6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/game3.png")));
        buildPic7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/game2.png")));
        
        buildPrice1.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice1.setText("1875 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice1.setText("2250 $");
        else buildPrice1.setText("1500 $");
        buildPic1.setVisible(true);
        buildCost1.setVisible(true);
        buildCost1.setText("50 $");
        
        buildPrice2.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice2.setText("2500 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice2.setText("3000 $");
        else buildPrice2.setText("2000 $");
        buildPic2.setVisible(true);
        buildCost2.setVisible(true);
        buildCost2.setText("100 $");
        
        buildPrice3.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice3.setText("2250 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice3.setText("2700 $");
        else buildPrice3.setText("1800 $");
        buildPic3.setVisible(true);
        buildCost3.setVisible(true);
        buildCost3.setText("80 $");
        
        buildPrice4.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice4.setText("1250 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice4.setText("1500 $");
        else buildPrice4.setText("1000 $");
        buildPic4.setVisible(true);
        buildCost4.setVisible(true);
        buildCost4.setText("50 $");
        
        buildPrice5.setVisible(true);
        buildPrice5.setText("2000 $");
        buildPic5.setVisible(true);
        buildCost5.setVisible(true);
        buildCost5.setText("100 $");
        
        buildPrice6.setVisible(true);
        buildPrice6.setText("2000 $");
        buildPic6.setVisible(true);
        buildCost6.setVisible(true);
        buildCost6.setText("100 $");
        
        buildPrice7.setVisible(true);
        buildPrice7.setText("2000 $");
        buildPic7.setVisible(true);
        buildCost7.setVisible(true);
        buildCost7.setText("90 $");
        
        buildPrice8.setVisible(false);
        buildPic8.setVisible(false);
        buildCost8.setVisible(false);
        
        buildPrice9.setVisible(false);
        buildPic9.setVisible(false);
        buildCost9.setVisible(false);
    }
    
    private void switchToEmployees(){
        buildPic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/janitor_station.jpg")));
        buildPic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/police_station.jpg")));
        buildPic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shop/restaurant.jpg")));
        
        buildPrice1.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice1.setText("1250 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice1.setText("1500 $");
        else buildPrice1.setText("1000 $");
        buildPic1.setVisible(true);
        buildCost1.setVisible(true);
        buildCost1.setText("50 $");
        
        buildPrice2.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice2.setText("1250 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice2.setText("1500 $");
        else buildPrice2.setText("1000 $");
        buildPic2.setVisible(true);
        buildCost2.setVisible(true);
        buildCost2.setText("50 $");
        
        buildPrice3.setVisible(true);
        if(window.getDif() == DifficultyLevel.NORMAL) buildPrice3.setText("1250 $");
        else if(window.getDif() == DifficultyLevel.HARD) buildPrice3.setText("1500 $");
        else buildPrice3.setText("1000 $");
        buildPic3.setVisible(true);
        buildCost3.setVisible(true);
        buildCost3.setText("50 $");
        
        buildPrice4.setVisible(false);
        buildPic4.setVisible(false);
        buildCost4.setVisible(false);
        
        buildPrice5.setVisible(false);
        buildPic5.setVisible(false);
        buildCost5.setVisible(false);
        
        buildPrice6.setVisible(false);
        buildPic6.setVisible(false);
        buildCost6.setVisible(false);
        
        buildPrice7.setVisible(false);
        buildPic7.setVisible(false);
        buildCost7.setVisible(false);
        
        buildPrice8.setVisible(false);
        buildPic8.setVisible(false);
        buildCost8.setVisible(false);
        
        buildPrice9.setVisible(false);
        buildPic9.setVisible(false);
        buildCost9.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accessoriesButton;
    private javax.swing.JLabel buildCost1;
    private javax.swing.JLabel buildCost2;
    private javax.swing.JLabel buildCost3;
    private javax.swing.JLabel buildCost4;
    private javax.swing.JLabel buildCost5;
    private javax.swing.JLabel buildCost6;
    private javax.swing.JLabel buildCost7;
    private javax.swing.JLabel buildCost8;
    private javax.swing.JLabel buildCost9;
    private javax.swing.JLabel buildPic1;
    private javax.swing.JLabel buildPic2;
    private javax.swing.JLabel buildPic3;
    private javax.swing.JLabel buildPic4;
    private javax.swing.JLabel buildPic5;
    private javax.swing.JLabel buildPic6;
    private javax.swing.JLabel buildPic7;
    private javax.swing.JLabel buildPic8;
    private javax.swing.JLabel buildPic9;
    private javax.swing.JLabel buildPrice1;
    private javax.swing.JLabel buildPrice2;
    private javax.swing.JLabel buildPrice3;
    private javax.swing.JLabel buildPrice4;
    private javax.swing.JLabel buildPrice5;
    private javax.swing.JLabel buildPrice6;
    private javax.swing.JLabel buildPrice7;
    private javax.swing.JLabel buildPrice8;
    private javax.swing.JLabel buildPrice9;
    private javax.swing.JButton employeesButton;
    private javax.swing.JButton shopCloseButton;
    private javax.swing.JButton toysButton;
    // End of variables declaration//GEN-END:variables
}

package View;

/**
 * Tutorial panel
 */
public class Tutorial extends javax.swing.JPanel {

    private final MainWindow window;
    public Tutorial(final MainWindow window) {
        this.window = window;
        initComponents(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Útmutató");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 58));

        jButton1.setText("Vissza");
        jButton1.setPreferredSize(new java.awt.Dimension(80, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Új játék");
        jButton2.setPreferredSize(new java.awt.Dimension(80, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("<html>\n- A játék indítása előtt válassza ki a nehézségi szintet ( Kezdő, Normál, Haladó). <br>\n- Ha ez megvan, elnevezheti a parkját (ezen a néven fog bekerülni a toplistába). <br>\n- Ezt követően bekerül a fő játéktérre. Itt látható a játékmezőn kívül a bolt gombja, a park pénze, boldogsági szintje, az idő (nap, óra, perc), illetve az  <br>\n  utóbbit kezelő gombok (gyorsítás, lassítás, megállítás). <br>\n- A bolt gombra nyomva megnyílik egy ablak, ahol 3 kategória közül lehet választani (Játékok, Kiegészítők és Alkalmazottak). <br>\n- A képek alatt az adott tárgy/játék ára és a fentartásának kölcsége látható. Megvenni a képre való kattintással lehet. <br>\n- Lehelyezéskor a játék jelzi, hogy hova lehet lerakni (csak, ha zöld akkor tudjuk letenni). <br>\n- Minden csak utak méllé kerülhet le. <br>\n- Vannak olyan tárgyak (mint például az út), amikből egyszerre többet is le lehet rakni. <br>\n- Ha meg szeretnénk szakítani a vásárlást, az alsó sáv közepén lévő \"Vásárlás megszakítása\" gomb segítségével tehetjük ezt meg. <br>\n- A játékokra és az ott dolgozók épületeire rákattintva meg lehet nézni azok szintjét és bevételélt. Ha a park épp zárva van (22 és 8 óra között van), <br>\n  akkor lehetséges ezek fejlesztése (3-as szintig) és rombolása. <br>\n- A játéknak akkor van vége, ha a park pénze minuszba megy, vagy ha a játékos úgy dönt, hogy ő ki szeretne lépni. Ilyenkor minden mentődik és <br>\n  bekerül a toplistába, ha jobb eredményt ért el az előzőekhez képest. <br>\n</html>");
        jLabel2.setPreferredSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        window.switchToMain(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        window.switchToNewGame(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

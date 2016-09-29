package Frames;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPlay = new javax.swing.JButton();
        buttonAbout = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/play_button.png"))); // NOI18N
        buttonPlay.setPreferredSize(new java.awt.Dimension(300, 17));
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 290, 70));

        buttonAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/about.png"))); // NOI18N
        buttonAbout.setPreferredSize(new java.awt.Dimension(150, 61));
        buttonAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAboutActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 290, -1));

        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        getContentPane().add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 310, 80));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu.png"))); // NOI18N
        lblBackground.setText("jLabel1");
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        this.dispose();
        Settings settings = new Settings(); //creates a new settings window
        settings.setVisible(true);
    }//GEN-LAST:event_buttonPlayActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAboutActionPerformed
        HighScores high = new HighScores(); //creates a new highscores window
        high.setVisible(true);
    }//GEN-LAST:event_buttonAboutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbout;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JLabel lblBackground;
    // End of variables declaration//GEN-END:variables
}

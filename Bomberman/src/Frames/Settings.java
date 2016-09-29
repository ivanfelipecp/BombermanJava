package Frames;

import bomberman.Globals;
import javax.swing.JOptionPane;


public class Settings extends javax.swing.JFrame {

    int easyLevel = 15;
    int mediumLevel = 21;
    int hardLevel = 25;
    public Settings() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RBEasy = new javax.swing.JRadioButton();
        RBMedium = new javax.swing.JRadioButton();
        RBHard = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lblHard = new javax.swing.JLabel();
        lblEasy = new javax.swing.JLabel();
        lblMedium = new javax.swing.JLabel();
        buttonPlay = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RBEasy.setBackground(new java.awt.Color(102, 102, 102));
        RBEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBEasyActionPerformed(evt);
            }
        });
        getContentPane().add(RBEasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 191, 20, 20));

        RBMedium.setBackground(new java.awt.Color(51, 51, 51));
        RBMedium.setForeground(new java.awt.Color(51, 51, 51));
        RBMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBMediumActionPerformed(evt);
            }
        });
        getContentPane().add(RBMedium, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 20, 20));

        RBHard.setBackground(new java.awt.Color(102, 102, 102));
        RBHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBHardActionPerformed(evt);
            }
        });
        getContentPane().add(RBHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, 20));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select one option and click the \"Let's Bomb\" button");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 30));

        lblHard.setBackground(new java.awt.Color(204, 204, 204));
        lblHard.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblHard.setForeground(new java.awt.Color(204, 0, 0));
        lblHard.setText("Hard");
        getContentPane().add(lblHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 60, 40));

        lblEasy.setBackground(new java.awt.Color(255, 255, 255));
        lblEasy.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblEasy.setForeground(new java.awt.Color(255, 255, 153));
        lblEasy.setText("Easy");
        getContentPane().add(lblEasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 60, 40));

        lblMedium.setBackground(new java.awt.Color(204, 204, 204));
        lblMedium.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblMedium.setForeground(new java.awt.Color(255, 102, 0));
        lblMedium.setText("Medium");
        getContentPane().add(lblMedium, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 90, 40));

        buttonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/go.png"))); // NOI18N
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 310, 100));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RBEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBEasyActionPerformed
        this.RBHard.setSelected(false);
        this.RBMedium.setSelected(false);
    }//GEN-LAST:event_RBEasyActionPerformed

    private void RBMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBMediumActionPerformed
        this.RBHard.setSelected(false);
        this.RBEasy.setSelected(false);
    }//GEN-LAST:event_RBMediumActionPerformed

    private void RBHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBHardActionPerformed
        this.RBEasy.setSelected(false);
        this.RBMedium.setSelected(false);
    }//GEN-LAST:event_RBHardActionPerformed

    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        Globals.getGlobals().setWin(false);
        if((this.RBEasy.isSelected()==false) && (this.RBMedium.isSelected()==false) && (this.RBHard.isSelected()==false))
            //if there is no radiobutton select, show a message
            JOptionPane.showMessageDialog(this,"Please, select one mode");
        else{
            Game game = new Game(); //creates a new window
            if(this.RBEasy.isSelected()==true){ //if the easy radiobutton is selected creates a new
                game.start(Globals.getGlobals().getEasyMode());//game in easy mode
                game.setSize(466, 485);
            }
            else if (this.RBMedium.isSelected()==true){
                game.start(Globals.getGlobals().getMediumMode());//if the mediumradiobutton is selected creates a new
                game.setSize(646,670);                          //game in medium mode
            }
            else{
                game.start(Globals.getGlobals().getHardMode());//if the hard radiobutton is selected creates a new
                game.setSize(763,850);                        //game in medium mode
            }
            this.dispose();//it dispose
            game.setVisible(true);//set visible the game window
        }
    }//GEN-LAST:event_buttonPlayActionPerformed


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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBEasy;
    private javax.swing.JRadioButton RBHard;
    private javax.swing.JRadioButton RBMedium;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblEasy;
    private javax.swing.JLabel lblHard;
    private javax.swing.JLabel lblMedium;
    // End of variables declaration//GEN-END:variables
}

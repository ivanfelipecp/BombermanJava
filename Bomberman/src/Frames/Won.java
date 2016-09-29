package Frames;

import bomberman.HighScoresFiles;
import javax.swing.JOptionPane;

public class Won extends javax.swing.JFrame {

    int time;
    int difficult;
    public Won() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.panelWin.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        buttonSummit = new javax.swing.JButton();
        Background = new javax.swing.JLabel();
        panelWin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 255, 255));
        lblTitle.setText("Name:");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 70, 50));

        lblTitle1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 0, 0));
        lblTitle1.setText("New High Score!");
        getContentPane().add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 320, 50));

        lblTime.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 0));
        lblTime.setText("Time : 130");
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 220, 50));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 210, 30));

        buttonSummit.setBackground(new java.awt.Color(102, 102, 102));
        buttonSummit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/submit.png"))); // NOI18N
        buttonSummit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSummitActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSummit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 160, 70));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/black.png"))); // NOI18N
        Background.setText("jLabel1");
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        panelWin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("You Win!");
        panelWin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 160, 60));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MM.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelWin.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 160, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/black.png"))); // NOI18N
        panelWin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 410, 302));

        getContentPane().add(panelWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSummitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSummitActionPerformed
        if(this.txtUser.equals("")){//if the user dont write nothing
            JOptionPane.showMessageDialog(this,"Please, insert your name");
        }
        else{
            String userName = this.txtUser.getText();//get the written name 
            HighScoresFiles h = new HighScoresFiles();//class that help us to work with files
            h.newHighScore(difficult, time, userName);//set the new highscore
            this.dispose();//it dispose
            MainMenu menu = new MainMenu();//creates a new menu window
            menu.setVisible(true); //set the window visible
        }
    }//GEN-LAST:event_buttonSummitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenu menu = new MainMenu(); //create a new menu window
        menu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Won.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Won.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Won.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Won.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Won().setVisible(true);
            }
        });
    }
    
    public void normalWin(){
        this.panelWin.setVisible(true); //set visible the noral win panel
    }

    public int getTime() {
        return time; //return the time
    }

    public void setTime(int time,int difficult) {//set the attributes of the class to save the new record
        this.time = time;
        this.difficult = difficult;
        this.lblTime.setText("Time: "+Integer.toString(time));//set the label
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton buttonSummit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel panelWin;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

package Frames;

import bomberman.HighScoresFiles;

public class HighScores extends javax.swing.JFrame {

    public HighScores() {
        initComponents();
        this.setLocationRelativeTo(null);
        HighScoresFiles f = new HighScoresFiles();//class that help us to work with files
        String[] easyA = (f.getFile(15).split(" "));//get an array that contains the easy top players
        String[] mediumA = (f.getFile(21).split(" "));//get an array that contains the medium top players
        String[] hardA = (f.getFile(25).split(" "));//get an array that contains the hard top players
        String easy = "<html>"; //the "\n" in label doesnt work, so we use html code, PDA: JLabel supports HTML code
        String medium = "<html>";
        String hard = "<html>";
        for(int i = 1;i<easyA.length;i+=2){ //get the top players to easy string
            easy += easyA[i];
            easy +=" "+easyA[i-1];
            easy += "<br/>";//<br/> is equal to "\n"
            
        }
        easy+="</html>";
        this.lblEasyResults.setText(easy); //set the text of the "lblEasy"
        
        for(int i = 1;i<mediumA.length;i+=2){ //get the top players to medium string
            medium += mediumA[i];
            medium += " "+mediumA[i-1];
            medium += "<br/>"; //<br/> is equal to "\n"
        }
        medium+="</html>";
        this.lblMediumResults.setText(medium);//set the text of the "lblMedium"
        
        for(int i = 1;i<hardA.length;i+=2){//get the top players to hard string
            hard += hardA[i];
            hard += " "+hardA[i-1];
            hard += "<br/>";//<br/> is equal to "\n"
        }
        hard+="</html>";
        this.lblHardResults.setText(hard);//set the text of the "lblHard"
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHS = new javax.swing.JLabel();
        lblEasy = new javax.swing.JLabel();
        lblMedium = new javax.swing.JLabel();
        lblHard = new javax.swing.JLabel();
        lblMediumResults = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblEasyResults = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHardResults = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/HS.png"))); // NOI18N
        getContentPane().add(lblHS, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 31, 398, 96));

        lblEasy.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblEasy.setForeground(new java.awt.Color(255, 255, 51));
        lblEasy.setText("Easy");
        getContentPane().add(lblEasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 40));

        lblMedium.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblMedium.setForeground(new java.awt.Color(255, 102, 0));
        lblMedium.setText("Medium");
        getContentPane().add(lblMedium, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 150, 40));

        lblHard.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblHard.setForeground(new java.awt.Color(255, 0, 0));
        lblHard.setText("Hard");
        getContentPane().add(lblHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 100, 40));

        lblMediumResults.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblMediumResults.setForeground(new java.awt.Color(0, 255, 255));
        lblMediumResults.setText("jLabel1");
        getContentPane().add(lblMediumResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 130, 150));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Time   User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 120, 30));

        lblEasyResults.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblEasyResults.setForeground(new java.awt.Color(0, 255, 255));
        lblEasyResults.setText("jLabel1");
        getContentPane().add(lblEasyResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 130, 150));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Time   User");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 120, 30));

        lblHardResults.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblHardResults.setForeground(new java.awt.Color(0, 255, 255));
        lblHardResults.setText("jLabel1");
        getContentPane().add(lblHardResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 130, 150));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Time   User");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 120, 30));

        Background.setForeground(new java.awt.Color(255, 255, 255));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/black.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HighScores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HighScores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEasy;
    private javax.swing.JLabel lblEasyResults;
    private javax.swing.JLabel lblHS;
    private javax.swing.JLabel lblHard;
    private javax.swing.JLabel lblHardResults;
    private javax.swing.JLabel lblMedium;
    private javax.swing.JLabel lblMediumResults;
    // End of variables declaration//GEN-END:variables
}

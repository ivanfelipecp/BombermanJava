package Frames;

import bomberman.Globals;
import bomberman.HighScoresFiles;
import bomberman.Play;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

public class Game extends javax.swing.JFrame implements KeyListener{

    private Play play; //class where we get all the elements of the game
    private int time;  //the time
    private Timer timer; //the timer
    private Globals globals;
    public Game() {
        initComponents();
        this.setLocationRelativeTo(null);
        addKeyListener(this);
        this.panelLoose.setVisible(false); 
        globals = Globals.getGlobals();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLoose = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonRestart = new javax.swing.JButton();
        buttonMainMenu = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        panelLoose.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("You Loose!");

        buttonRestart.setText("Restart");
        buttonRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRestartActionPerformed(evt);
            }
        });

        buttonMainMenu.setText("Main Menu");
        buttonMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLooseLayout = new javax.swing.GroupLayout(panelLoose);
        panelLoose.setLayout(panelLooseLayout);
        panelLooseLayout.setHorizontalGroup(
            panelLooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLooseLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(panelLooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLooseLayout.createSequentialGroup()
                        .addComponent(buttonRestart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonMainMenu))
                    .addComponent(jLabel1))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        panelLooseLayout.setVerticalGroup(
            panelLooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLooseLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(panelLooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRestart)
                    .addComponent(buttonMainMenu))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        lblTimer.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panelLoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMainMenuActionPerformed
        MainMenu main = new MainMenu();
        this.dispose();
        main.setVisible(true);
    }//GEN-LAST:event_buttonMainMenuActionPerformed

    private void buttonRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRestartActionPerformed
        Game game = new Game();  //creates a new windows
        this.dispose(); //it dispose
        int size = this.play.getBounds(); //we get the difficult
        if(size==15){
            game.setSize(466, 485);
        }
        else if(size==21)
            game.setSize(646,670);
        else
            game.setSize(763,850);
        game.start(size);  //set the game, the difficult depend of the size
        game.setVisible(true);
    }//GEN-LAST:event_buttonRestartActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonMainMenu;
    private javax.swing.JButton buttonRestart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel panelLoose;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        this.play.move(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    public void start(int bounds){//the bounds are difficult of the game(15 easy,21 medium,25 hard)
        this.play = new Play(bounds); //creates a new play
        addLabels(); //
        Runnable game = new Runnable() {

            @Override
            public void run() {
                gameStart();
            }
        };
        Thread thread = new Thread(game);
        thread.start();
    }
    
    public void gameStart(){
        Clip music = globals.getUtils().getSound(globals.getSoundMusic());
        startTimer(); //Starts the stopwatch
        music.start(); //Starts the bomberman theme
        while((this.play.getBomberman().isAlive()==true) && (globals.isWin()==false) && (this.time>0)){
            //while bomberman is alive or bomberman get the victory
            for (int y=0;y<this.play.getBounds();y++){ //refresh the labels
                for(int x=0;x<this.play.getBounds();x++){
                    this.play.getVisualM()[y][x].setIcon(this.play.getLogicM()[y][x].getImage());
                }
            }
        }
        timer.stop();//stop the stopwatch
        music.stop();//stop the music
        if((this.play.getBomberman().isAlive()==false) || (this.time==0)){ //if bomberman dies
            this.panelLoose.setVisible(true); //show the "loose panel"
            Thread dead = Globals.getGlobals().getUtils().playSound(Globals.getGlobals().getSoundLose());
            dead.start(); //this is the "dead sound"
        }
        else{ //if bomberman won
            Thread win = Globals.getGlobals().getUtils().playSound(Globals.getGlobals().getSoundWin());
            win.start(); //start the "won sound"
            HighScoresFiles high = new HighScoresFiles(); //Class that help us to work with the files
            Won won = new Won(); //Creates a new window
            boolean isRecord = high.isGreater(this.play.getBounds(), time); //if the time is a not a record
            if(isRecord==false)
                won.normalWin();
            else//if the time is a new record
                won.setTime(time,this.play.getBounds());
            this.dispose();//it dispose
            won.setVisible(true);// set the "won window" visible    
        }
    }
    
    public void addLabels(){ //add labels to this window
        for (int y = 0;y<this.play.getBounds();y++){
            for(int x = 0;x<this.play.getBounds();x++)
                this.add(this.play.getVisualM()[y][x]);
        }
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
    
    public void setPanel(int y,int boundX,int boundY){
        this.panelLoose.setBounds(0, y, boundX, boundY);
    }
    
    public void startTimer(){
        if(this.play.getBounds()==15)
            this.time = 140;
        else if(this.play.getBounds()==21)
            this.time = 180;
        else
            this.time = 200;
        this.timer = new Timer(1000,new ActionListener() { //instance the timer with 1000(1 sec)

            @Override
            public void actionPerformed(ActionEvent ae) {
                 time--;
                 lblTimer.setText("Time: "+Integer.toString(time)); //set the label with the current time
            }
        });
        this.timer.start(); //starts the stopwatch
    }
        
}

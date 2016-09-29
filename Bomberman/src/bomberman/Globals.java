package bomberman;

import Frames.Game;
import javax.swing.ImageIcon;


public class Globals {
    public static Globals globals;
    private ImageIcon balloon;
    private ImageIcon barrel;
    private ImageIcon barrierBlock;
    private ImageIcon blank;
    private ImageIcon block;
    private ImageIcon bomb;
    private ImageIcon bomberman;
    private ImageIcon bombermanBomb;
    private ImageIcon explosion;
    private ImageIcon power;
    private ImageIcon door;
    private ImageIcon explosionMiddle;
    private ImageIcon explosionH;
    private ImageIcon explosionV;
    private int x;
    private int y;
    private Game window;
    private Hero hero;
    private int easyMode;
    private int mediumMode;
    private int hardMode;
    private boolean win;
    private Utils utils;
    private int lenMobs;
    private static int bounds;
    private String soundBomb;
    private String soundBarrel;
    private String soundExplosion;
    private String soundBalloon;
    private String soundMusic;
    private String soundWin;
    private String soundLose;
    private Globals() {
    }
    
    public static Globals getGlobals(){
        if (globals==null){
            globals = new Globals();
            Utils utils = new Utils();
            globals.bounds = 30;
            globals.balloon = utils.setIcon(bounds,"/Images/Balloon.png");
            globals.barrel = utils.setIcon(bounds,"/Images/Barrel.png");
            globals.barrierBlock = utils.setIcon(bounds,"/Images/BarrierBlock.png");
            globals.blank = utils.setIcon(bounds,"/Images/Blank.png");
            globals.block = utils.setIcon(bounds,"/Images/Block.png");
            globals.bomb = utils.setIcon(bounds,"/Images/Bomb.png");
            globals.bomberman = utils.setIcon(bounds,"/Images/Bomberman.png");
            globals.bombermanBomb = utils.setIcon(bounds,"/Images/BombermanBomb.png");
            globals.door = utils.setIcon(bounds,"/Images/Door.png");
            globals.explosion = utils.setIcon(bounds,"/Images/Explosion.png");
            globals.power = utils.setIcon(bounds,"/Images/Powerup.png");
            globals.explosionMiddle = utils.setIcon(bounds,"/Images/ExplosionMid.png");
            globals.explosionH = utils.setIcon(bounds,"/Images/ExplosionH.png");
            globals.explosionV = utils.setIcon(bounds,"/Images/explosionV.png");
            globals.soundBomb = "Sounds/bomb.wav";
            globals.soundBalloon = "Sounds/balloon.wav";
            globals.soundExplosion = "Sounds/explosion.wav";
            globals.soundBarrel = "Sounds/barrel.wav";
            globals.soundMusic = "Sounds/bombermanMusic.wav";
            globals.soundWin = "Sounds/winSound.wav";
            globals.soundLose = "Sounds/dieSound.wav";
            globals.easyMode = 15;
            globals.mediumMode = 21;
            globals.hardMode = 25;
            globals.win = false;           
            globals.utils = new Utils();
            globals.lenMobs = 0;
        }
        return globals;
    }

    public ImageIcon getExplosionMiddle() {
        return globals.explosionMiddle;
    }

    public ImageIcon getExplosionH() {
        return globals.explosionH;
    }

    public ImageIcon getExplosionV() {
        return globals.explosionV;
    }
   
    public String getSoundWin() {
        return globals.soundWin;
    }

    public void setSoundWin(String soundWin) {
        globals.soundWin = soundWin;
    }

    public String getSoundLose() {
        return globals.soundLose;
    }

    public void setSoundLose(String soundLose) {
        globals.soundLose = soundLose;
    }
    
    

    public String getSoundMusic() {
        return globals.soundMusic;
    }
   
    public String getSoundBomb() {
        return globals.soundBomb;
    }

    public String getSoundBarrel() {
        return globals.soundBarrel;
    }

    public String getSoundExplosion() {
        return globals.soundExplosion;
    }

    public String getSoundBalloon() {
        return globals.soundBalloon;
    }

    public int getEasyMode() {
        return globals.easyMode;
    }

    public int getMediumMode() {
        return globals.mediumMode;
    }

    public int getHardMode() {
        return globals.hardMode;
    }
    
    

    public static int getBounds() {
        return globals.bounds;
    }

    public static void setBounds(int bounds) {
        globals.bounds = bounds;
    }

    
    public boolean isWin() {
        return globals.win;
    }

    public void setWin(boolean win) {
        globals.win = win;
    }
    
    

    public int getLenMobs() {
        return globals.lenMobs;
    }

    public void setLenMobs(int lenMobs) {
        globals.lenMobs = lenMobs;
    }
    
    

    public Utils getUtils() {
        return globals.utils;
    }

    public void setUtils(Utils utils) {
        globals.utils = utils;
    }

    
    public Game getWindow() {
        return globals.window;
    }
        
    public void setGame(int bounds){
        globals.x = bounds;
        globals.y = bounds;
        globals.window = new Game();
        
    }
    
    public ImageIcon getBalloon() {
        return balloon;
    }

    public ImageIcon getBarrel() {
        return barrel;
    }

    public ImageIcon getBarrierBlock() {
        return barrierBlock;
    }

    public ImageIcon getBlank() {
        return blank;
    }

    public ImageIcon getBlock() {
        return block;
    }

    public ImageIcon getBomb() {
        return bomb;
    }

    public ImageIcon getBomberman() {
        return bomberman;
    }

    public ImageIcon getBombermanBomb() {
        return bombermanBomb;
    }

    public ImageIcon getExplosion() {
        return explosion;
    }

    public ImageIcon getPower() {
        return power;
    }

    public ImageIcon getDoor() {
        return door;
    }

    public Hero getHero() {
        return globals.hero;
    }

    public void setHero(Hero hero) {
        globals.hero = hero;
    }
        
}

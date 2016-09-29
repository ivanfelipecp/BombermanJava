package bomberman;

import java.util.ArrayList;
import javax.swing.JLabel;

public class Play {
    private Element[][] logicM;
    private JLabel[][] visualM;
    private Hero bomberman;
    private Globals globals;
    private BlockFactory factory;
    private int bounds;
    private ArrayList<Characters> mobList;
    
    public Play(int bounds) {
        this.globals = Globals.getGlobals();
        this.factory = new BlockFactory();
        this.bounds = bounds;
        this.logicM = new Element[bounds][bounds];
        this.visualM = new JLabel[bounds][bounds];
        this.bomberman = new Hero(1,logicM,1,1,globals.getBomberman());
        globals.setHero(bomberman);
        this.mobList = new ArrayList<>();
        Bomb bomb = new Bomb(0,0,globals.getBomb(),1);
        Bomb bomb1 = new Bomb(0,0,globals.getBomb(),1);
        Bomb bomb2 = new Bomb(0,0,globals.getBomb(),1);
        Bomb bomb3 = new Bomb(0,0,globals.getBomb(),1);
        bomberman.setBombs(bomb);
        bomberman.setBombs(bomb1);
        bomberman.setBombs(bomb2);
        bomberman.setBombs(bomb3);
        chargeMatrix();
        mobMovement();
    }
    
    public final void chargeMatrix(){ //charge and fill the matrix
        for(int y = 0;y<this.getBounds();y++){
            for(int x = 0;x<this.bounds;x++){
                factory.newBlock(x, y, this.getBounds(), this.getBounds(), this.logicM, this.visualM); 
            }
        }
        factory.fillMatrix(this.getBounds(),this.getLogicM(),this.getBomberman(),this.mobList);
    }
    
    public void move(int keycode){//get the keycode from the game frame
        boolean pass;
        if (keycode==39){//right arroz
            int right = bomberman.getPositionX()+1;
            if (right<this.getBounds()-1){
                pass = this.bomberman.move(right, bomberman.getPositionY(), bomberman.getPositionX(), bomberman.getPositionY());
                if (pass==true){
                    bomberman.setPositionX(right);
                }             
            }
        }
        
        else if (keycode==37){//left arrow
            int left = bomberman.getPositionX()-1;
            if(left>0){
                pass = this.bomberman.move(left, bomberman.getPositionY(), bomberman.getPositionX(), bomberman.getPositionY());
                if (pass==true)
                    bomberman.setPositionX(left);
                
            }
        }
        
        else if(keycode==40){//down arrow
            int down = bomberman.getPositionY()+1;
            if(down<this.getBounds()-1){
                pass = this.bomberman.move(bomberman.getPositionX(), down, bomberman.getPositionX(), bomberman.getPositionY());
                if (pass==true)
                    bomberman.setPositionY(down);
                
            }
        }
        
        else if (keycode==38){//up arrow
            int up = bomberman.getPositionY()-1;
            if(up>0){
                pass = this.bomberman.move( bomberman.getPositionX(), up,  bomberman.getPositionX(),bomberman.getPositionY());
                if (pass==true)
                     bomberman.setPositionY(up);              
            }
        }
        
        else if (keycode==32){ //space
            if (this.bomberman.getBombs()!=0){
                Thread bombSound = globals.getUtils().playSound(globals.getSoundBomb());
                bombSound.start(); //play an explosion
                Bomb bomb = this.bomberman.getBomb();//get the last bomb of the hero
                bomb.setImage(globals.getBombermanBomb());//set the image
                bomb.setPositionX(bomberman.getPositionX());//set the position x
                bomb.setPositionY(bomberman.getPositionY());//set the position y
                logicM[bomberman.getPositionY()][bomberman.getPositionX()] = bomb;//place the bomb in the matrix                              
                Explosion explosion = new Explosion(bomberman.getPositionX(),bomberman.getPositionY(),logicM,bomberman,true,globals.getExplosionMiddle());
                explosion.start();//starts a new explosion
                int power = this.bomberman.getPower();
                boolean explosionUp = isExplode(bomberman.getPositionX(),bomberman.getPositionY()-1);
                boolean explosionDown = isExplode(bomberman.getPositionX(),bomberman.getPositionY()+1);
                boolean explosionLeft = isExplode(bomberman.getPositionX()-1,bomberman.getPositionY());
                boolean explosionRight = isExplode(bomberman.getPositionX()+1,bomberman.getPositionY());
                int i = 0;
                while(power>0){//start explosions in every direccion                   
                    Explosion explosionD = new Explosion(bomberman.getPositionX(),bomberman.getPositionY()+power,logicM,this.bomberman,false,globals.getExplosionV());
                    Explosion explosionU = new Explosion(bomberman.getPositionX(),bomberman.getPositionY()-power,logicM,this.bomberman,false,globals.getExplosionV());
                    Explosion explosionR = new Explosion(bomberman.getPositionX()+power,bomberman.getPositionY(),logicM,this.bomberman,false,globals.getExplosionH());
                    Explosion explosionL = new Explosion(bomberman.getPositionX()-power,bomberman.getPositionY(),logicM,this.bomberman,false,globals.getExplosionH());
                    if(explosionDown==true)
                        explosionD.start();
                    if(explosionUp==true)
                        explosionU.start();
                    if(explosionRight==true)
                        explosionR.start();
                    if(explosionLeft==true)
                        explosionL.start();
                    power--;
                }
            }
        }   
    }
    
    public final void mobMovement(){//thread that executes the movement of the monsters
        Runnable mobs = new Runnable() {
            @Override
            public void run() {   
                try {
                    while((globals.isWin()==false) && (globals.getHero().isAlive()==true)){
                        for(Characters character : mobList){
                            character.run();
                            Thread.sleep(300);
                        }
                        globals.setLenMobs(mobList.size());
                        Thread.sleep(500);             
                    }  
                } 
                catch (Exception e) {
                    this.run();
                }
            }
        };
        Thread thread = new Thread(mobs);
        thread.start();
    }

    public Element[][] getLogicM() {
        return logicM;
    }

    public void setLogicM(Element[][] logicM) {
        this.logicM = logicM;
    }

    public JLabel[][] getVisualM() {
        return visualM;
    }

    public void setVisualM(JLabel[][] visualM) {
        this.visualM = visualM;
    }

    public Hero getBomberman() {
        return bomberman;
    }

    public void setBomberman(Hero bomberman) {
        this.bomberman = bomberman;
    }

    public int getBounds() {
        return bounds;
    }

    public void setBounds(int bounds) {
        this.bounds = bounds;
    }
    
    public boolean isExplode(int x,int y){
        if(this.logicM[y][x].isDestructible()==true)
            return true;
        else
            return false;
    }
    
              
}
    
    


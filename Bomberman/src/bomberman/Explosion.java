package bomberman;

import javax.swing.ImageIcon;

public class Explosion extends Thread{
    private Element[][] logicM;
    private Globals globals;
    private int x;
    private int y;
    private Hero bomberman;
    private boolean boom;
    private ImageIcon image;

    public Explosion(int x,int y, Element[][] logicM,Hero bomberman,boolean boom,ImageIcon image) {
        this.logicM = logicM;
        globals= Globals.getGlobals();
        this.x = x;
        this.y = y;
        this.bomberman = bomberman;
        this.boom = boom;
        this.image = image;
    }
   
    @Override
    public void run(){
        try{
            kBoom(this.x,this.y);
        }
        catch(Exception e){
        }
        
    }
    
    public boolean isExplosion(){
        if(this.logicM[this.y][this.x].isDestructible()==true)
            return true;
        else
            return false;
    }
    
    public void kBoom(int x,int y){
        if( ((x>=0) && (x<logicM.length)) && ((y>=0) && (y<logicM.length))){
            
            if((logicM[y][x].isDestructible()==true)){//If the positions given are destructible
                try{  
                    if((logicM[y][x].isSecret()==false) || (logicM[y][x].isPass()==true)){
                        Thread.sleep(3000);//wait 3 seconds
                        //creates a new blank space with danger in true
                        Blank blank = new Blank(true,false,false,globals.getExplosion(),globals.getDoor(),globals.getPower(),x,y,globals.getBlank());
                        blank.setImageDanger(image);//set a new image
                        if((this.x==this.bomberman.getPositionX()) && (this.y==this.bomberman.getPositionY())){
                            this.bomberman.setAlive(false);
                        }
                        logicM[y][x].setAlive(false);//kill the position before to place the new blank
                        if(this.boom==true){
                            Thread explosion = Globals.getGlobals().getUtils().playSound(Globals.getGlobals().getSoundExplosion());
                            explosion.start();
                        }
                        logicM[y][x] = blank;
                        Thread.sleep(1000);
                        blank.setDanger(false);
                        logicM[y][x] = blank;
                    }
                    else{//if the position to destroy has a secret
                        boolean door = logicM[y][x].isDoor();
                        boolean power = logicM[y][x].isPower();
                        Thread.sleep(3000);
                        //danger,door,power
                        Blank blank = new Blank(true,door,power,globals.getExplosion(),globals.getDoor(),globals.getPower(),x,y,globals.getBlank());
                        blank.setImageDanger(image);
                        if(door==true){
                            blank.setPass(false);
                            blank.setDestructible(false);
                        }
                        logicM[y][x].setAlive(false);
                        logicM[y][x] = blank;
                        Thread.sleep(1000);
                        blank.setDanger(false);
                        logicM[y][x] = blank;      
                    }
                if(this.boom==true){
                        //this boolean helps to add a bomb,after every explosion
                        Bomb bomb = new Bomb(0,0,globals.getBomb(),this.bomberman.getPower());
                        this.bomberman.setBombs(bomb);
                    }
                }
                catch(Exception e){
                }
            }
        }
    }
}
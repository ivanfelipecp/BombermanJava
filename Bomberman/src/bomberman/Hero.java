package bomberman;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Hero extends Characters{
    
    private ArrayList<Bomb> bombs;
    private int power;
    public Hero(int power,Element[][] matrix,int positionX, int positionY, ImageIcon image) {
        super(matrix, positionX, positionY, image);
        this.bombs = new ArrayList<>();
        this.power = power;
        this.setAlive(true);
    }
    
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
    public Bomb getBomb(){
        Bomb bomb = bombs.get(bombs.size()-1);
        bombs.remove(bomb);
        bomb.setPositionX(this.getPositionX());
        bomb.setPositionY(this.getPositionY());
        return bomb;
    }

    public int getBombs(){
        return this.bombs.size();
    }

    public void setBombs(Bomb bomb) {
        this.bombs.add(bomb);
    }
  
    @Override
    public boolean move(int X,int Y,int x, int y) {
        boolean access = false;
        if(this.getMatrix()[Y][X].isDanger()==true){//if the next positions is a explosion or a monster
            this.setAlive(false); //kill the hero
            return access;
        }
        if((this.getMatrix()[Y][X].isDoor()==true) && (this.getMatrix()[Y][X].isDestructible()==false)){
            if(Globals.getGlobals().getLenMobs()==0){//if the next position is the door and all the mobs are dead
                Globals.getGlobals().setWin(true);
                return access;
            }
        }
        if(this.getMatrix()[Y][X].isPass()==true){
            if(this.getMatrix()[Y][X].isPower()==true)
                this.setPower(this.getPower()+1); //if the next position is a powerup,increase the power of this
            
            this.getMatrix()[Y][X] = this; //move the hero
            if((this.getMatrix()[y][x].isPass()==true) || (this.getMatrix()[y][x].isAlive()==true))
                Globals.getGlobals().getUtils().setPast(x, y, this.getMatrix());//set the last position with a blankspace
            else{//if the hero puts a bomb, set the image of a bomb
                if(this.getMatrix()[y][x].isAlive()==false)
                    this.getMatrix()[y][x].setImage(Globals.getGlobals().getBomb());
            }  
            access = true;
        }
       
        return access;
    }
    
     

    @Override
    public boolean isDoor() {
        return false;
    }

    @Override
    public boolean isPower() {
        return false;
    }

    @Override
    public boolean isDanger() {
        return false;
    }
    
    @Override
    public void run(){
        
    }
   
}

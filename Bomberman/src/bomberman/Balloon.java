package bomberman;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Balloon extends Characters{
    
    private ArrayList<Characters> mobs;
    public Balloon(ArrayList<Characters> mobs, Element[][] matrix, int positionX, int positionY, ImageIcon image) {
        super(matrix, positionX, positionY, image);
        this.mobs = mobs;
        this.setDestructible(true);
    }
    
    @Override
    public void run() {
        if(this.isAlive()==false) //if this isn't alive, do nothing
            return;
        Random r = new Random(); //creates a new random
        boolean access; //boolean if is acces
        int random = r.nextInt(4); //creates a random
        if(random==0){//goes up
            int up = this.getPositionY()-1;//get the upper position of this
            access = move(this.getPositionX(),up,this.getPositionX(),this.getPositionY());
            if (access==true){ //if acces is true; set the new position
                this.setPositionY(up);
            }
        }
        else if(random==1){//goes down
            int down = this.getPositionY()+1;//get the down position of this
            access = move(this.getPositionX(),down,this.getPositionX(),this.getPositionY());
            if (access==true)//if acces is true; set the new position
                this.setPositionY(down);
        }
        else if(random==2){//goes left
            int left = this.getPositionX()-1;//get the left position of this
            access = move(left,this.getPositionY(),this.getPositionX(),this.getPositionY());
            if(access==true){ //if acces is true; set the new position
                this.setPositionX(left);
            }
        }
        else if(random==3){//goes right
            int right = this.getPositionX()+1;//get the right position of this
            access = move(right,this.getPositionY(),this.getPositionX(),this.getPositionY());
            if(access==true){//if acces is true; set the new position
                this.setPositionX(right);
            }
        }
    }
    
    @Override
    public boolean move(int X, int Y, int x, int y) {
        //X and Y are from the hero
        //x and x are from this class
        boolean access = false;//Value that lets us know whether we are going to modify the x or y
        try{
            if(this.getMatrix()[Y][X]==Globals.getGlobals().getHero()){//if the next position is the hero,kill him
                this.getMatrix()[Y][X].setAlive(false);
            }
            if(this.getMatrix()[Y][X].isPass()==false)//if the next position is a barrier block or a door, return
                return access;
            if((this.getMatrix()[Y][X].isDanger()==true) && (this.getMatrix()[Y][X].isPass()==true)){//if the next position is an explosion, kill this
                this.setAlive(false);
                return access;
            }
            if(this.getMatrix()[Y][X].isPass()==true){
                this.getMatrix()[Y][X] = this;
                if((this.getMatrix()[y][x].isPass()==true) || (this.getMatrix()[y][x].isAlive()==true))
                    Globals.getGlobals().getUtils().setPast(x, y, this.getMatrix());//set the last position with a blank space
                access = true;//it can move to the new position
            }
        }
        catch(Exception e){
            access = false;
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
        return true;
    }


    
    @Override
    public void setAlive(boolean bool){//starts a sound a remove this from an arrayList
        Thread dead = Globals.getGlobals().getUtils().playSound(Globals.getGlobals().getSoundBalloon());
        dead.start();
        this.mobs.remove(this);
    }
    
    
}

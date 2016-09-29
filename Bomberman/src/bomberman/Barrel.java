package bomberman;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Barrel extends Characters{
    private ArrayList<Characters> mobs;

    public Barrel(ArrayList<Characters> mobs, Element[][] matrix, int positionX, int positionY, ImageIcon image) {
        super(matrix, positionX, positionY, image);
        this.mobs = mobs;
        this.setDestructible(true);
    }
    
    @Override
    public boolean move(int X, int Y, int x, int y) {
        //X and Y are from the hero
        //x and y are from this
        boolean access = false;//Value that lets us know whether we are going to modify the x or y
        int[] movement = AI(X,Y);//return a array with the new positions
        if(this.getMatrix()[movement[1]][movement[0]]==Globals.getGlobals().getHero()){
            //if the new positions are the positions of the hero, we kill him :)
            Globals.getGlobals().getHero().setAlive(false);
        }

        if((this.getMatrix()[movement[1]][movement[0]].isDanger()==true) && (this.getMatrix()[movement[1]][movement[0]].isPass()==true)){
            //if the new positions are a explosion, kill this
            this.setAlive(false);
            return access;
        }
        
        if(this.getMatrix()[movement[1]][movement[0]].isPass()==true){
            //if the new positions are a blank space, move
            this.getMatrix()[movement[1]][movement[0]] = this;
            access=true;
        }
        if (access==true){
            //if acces is true, set the new positions(x and y) of this and set the past position with a blank space
            Globals.getGlobals().getUtils().setPast(x, y, this.getMatrix());
            this.setPositionX(movement[0]);
            this.setPositionY(movement[1]);
        }
        return access;
       
    }
    
    public int[] AI(int bombermanX,int bombermanY){
        int X = bombermanX;
        int Y = bombermanY;
        int x = this.getPositionX();
        int y = this.getPositionY();
        int kind = 0;
        //case 1
        if((Y<y) && (X<x))
            kind = 1;
        //case 2
        else if((Y>y) && (X<x)){
            kind = 2;
        }
        //case 3
        else if((Y>y) && (X>x))
            kind = 3;
        //case 4
        else if ((Y<y) && (X>x))
            kind = 4;
        
        int[] right = {X,Y,x+1,y};
        int[] left = {X,Y,x-1,y};
        int[] up = {X,Y,x,y-1};
        int[] down = {X,Y,x,y+1};
        
        int r = 0;
        int l = 0;
        int u = 0;
        int d = 0;
        //case 1
        //if bomberman is up and left from this
        if(kind==1){
            r = ((right[0]-right[2]) + (right[1]-right[3]));
            l = ((left[0]-left[2]) + (left[1]-left[3]));
            u = ((up[0]-up[2]) + (up[1]-up[3]));
            d = ((down[0]-down[2]) + (down[1]-down[3])); 
        }
        //case 2
        //if bomberman is down and left from this
        else if(kind==2){            
            r = (-(right[0]-right[2]) + (right[1]-right[3]));
            l = (-(left[0]-left[2]) + (left[1]-left[3]));
            u = (-(up[0]-up[2]) + (up[1]-up[3]));
            d = (-(down[0]-down[2]) + (down[1]-down[3]));
        }
        //case 3
        //if bomberman is down and right from this
        else if(kind==3){
            r = ((right[0]-right[2]) + (right[1]-right[3]));
            l = ((left[0]-left[2]) + (left[1]-left[3]));
            u = ((up[0]-up[2]) + (up[1]-up[3]));
            d = ((down[0]-down[2]) + (down[1]-down[3]));
        }
        //case 4
        //if bomberman is up and right from this
        else if(kind==4){
            r = (-(right[0]-right[2]) + (right[1]-right[3]));
            l = (-(left[0]-left[2]) + (left[1]-left[3]));
            u = (-(up[0]-up[2]) + (up[1]-up[3]));
            d = (-(down[0]-down[2]) + (down[1]-down[3]));
        }
        
        boolean repeat = false;//if there are two addresses
        int[] results = {r,l,u,d};
        int result = Integer.MIN_VALUE;
        int[] array = new int[2];
        for(int i = 0;i<results.length;i++){
            if ((results[i] > result) && (result<0) || (results[i]< result) && (result>0)){//get the value more closest to 0
                result = results[i];
            }
            if(results[i] == result){
                repeat = true;
            }
        }
        if(repeat==true){//if there is two results
            ArrayList<int[]> repeats = new ArrayList<>();
            for(int i = 0;i<results.length;i++){//get the 2 results
                if(results[i]==result){
                    if(i==0)
                        repeats.add(right);
                    else if(i==1)
                        repeats.add(left);
                    else if(i==2)
                        repeats.add(up);
                    else if (i==3)
                        repeats.add(down);
                }
            }
            int[] firstResult = {repeats.get(0)[2],repeats.get(0)[3]};
            int[] secondResult = {repeats.get(1)[2],repeats.get(1)[3]};
            Random random = new Random();
            if (random.nextInt(2)==1)
                return firstResult;
            else
                return secondResult;
            
        }
        else{//return only one direction
            if (result==r){
                array[0] = right[2];
                array[1] = right[3];
            }
            else if (result==l){
                array[0] = left[2];
                array[1] = left[3];
            }
            else if (result==u){
                array[0] = up[2];
                array[1] = up[3];
            }
            else if (result==d){
                array[0] = down[2];
                array[1] = down[3];
            }
            return array;
        }
    }

    @Override
    public void run() {
        if(this.isAlive()==false)//if this is dead, do nothing
            return;
        else{
            //get the positions required to move
            int X = Globals.getGlobals().getHero().getPositionX();
            int Y = Globals.getGlobals().getHero().getPositionY();
            int x = this.getPositionX();
            int y = this.getPositionY();
            move(X,Y,x,y);//move
        }
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
    public void setAlive(boolean bool){//kill this
        Thread dead = Globals.getGlobals().getUtils().playSound(Globals.getGlobals().getSoundBarrel());
        dead.start();
        this.mobs.remove(this);
    }
}

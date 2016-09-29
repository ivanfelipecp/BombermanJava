package bomberman;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

public class BlockFactory {
    Globals globals = Globals.getGlobals();
    public BlockFactory() {
    }
    
    public void newBlock(int x,int y,int X,int Y,Element logicM[][],JLabel visualM[][]){
        int bounds = globals.getBounds();
        if ((y==0) || (y==Y-1) || (x==0) || (x==X-1)){//if the positions are the border of the maze
            BarrierBlock barrier = new BarrierBlock(y,x,globals.getBarrierBlock());
            logicM[y][x] = barrier;
            JLabel lbl = new JLabel();
            lbl.setBounds(x*bounds,y*bounds,bounds,bounds);
            lbl.setIcon(globals.getBarrierBlock());
            visualM[y][x] = lbl;
        }
        else if (y%2==0){
            if(x%2==0){//put a barrierblock between
                BarrierBlock barrier = new BarrierBlock(y,x,globals.getBarrierBlock());
                logicM[y][x] = barrier;
                JLabel lbl = new JLabel();
                lbl.setBounds(x*bounds,y*bounds,bounds,bounds);
                lbl.setIcon(globals.getBarrierBlock());
                visualM[y][x] = lbl;
                //return lbl;
            }
            else{//put a blank space
                Blank blank = new Blank(false,false,false,globals.getExplosion(),globals.getDoor(),globals.getPower(),x,y,globals.getBlank());
                logicM[y][x] = blank;
                JLabel lbl = new JLabel();
                lbl.setBounds(x*bounds,y*bounds,bounds,bounds);
                lbl.setIcon(globals.getBlank()); 
                visualM[y][x] = lbl;
                //return lbl;
            }
        }
        else{//put a blank space
            Blank blank = new Blank(false,false,false,globals.getExplosion(),globals.getDoor(),globals.getPower(),x,y,globals.getBlank());
            logicM[y][x] = blank;
            JLabel lbl = new JLabel();
            lbl.setBounds(x*bounds,y*bounds,bounds,bounds);
            lbl.setIcon(globals.getBlank());  
            visualM[y][x] = lbl;
        }
        
        
    }
    
    public void fillMatrix(int bounds,Element[][] matrix,Hero bomberman,ArrayList<Characters> mobList){
        int totalBalloons = 0;
        int totalBarrels = 0;
        int totalBlocks = 0;
        int secrets = 0;
        int door = 1;
        //set the total of blocks,secrets,balloons and barrels depending on the difficult
        if(bounds==15){
            totalBlocks = 35;
            secrets = 3;    
            totalBalloons = 5;
            totalBarrels = 3;
        }
        if(bounds==21){
            totalBlocks = 75;
            secrets = 2;    
            totalBalloons = 8;
            totalBarrels = 5;
        }
        if(bounds==25){
            totalBlocks = 120;
            secrets = 1;    
            totalBalloons = 12;
            totalBarrels = 10;
        }
        Random random = new Random();//creates a new random, to set random positions to the elements
        while(totalBlocks>0){//creates x amount of blocks in the maze
            int x = random.nextInt(bounds-1);
            int y = random.nextInt(bounds-1);
            if((x!=0) && (y!=0)){
                if(y%2==0){
                    if(x%2!=0)
                        if(((x!=1) && (y!=2)) || ((x!=2) && (y!=1))){
                        boolean secret = false;
                        if(secrets>0){
                            secret=true;
                            secrets--;
                        }
                        Block block = new Block(secret,false,x,y,globals.getBlock());
                        matrix[y][x] = block;
                        totalBlocks--;
                    }
                }
                else{
                    if(((x!=1) && (y!=2)) || ((x!=2) && (y!=1))){
                    boolean dor = false;
                    if(door>0){
                        dor = true;
                        door--;
                    }
                    
                    Block block = new Block(false,dor,x,y,globals.getBlock());
                    matrix[y][x] = block;
                    totalBlocks--;
                    }
                }
            }  
        }
        
        while(totalBalloons>0){//creates x amount of ballons in the maze
            int x = random.nextInt(bounds-1);
            int y = random.nextInt(bounds-1);
            if((x!=0) && (y!=0)){
                if(y%2==0){
                    if(x%2!=0)
                        if(((x!=1) && (y!=2)) && ((x!=2) && (y!=1)))
                            if(matrix[y][x].isPass()==true){
                            //Balloon(mobs,matrix,positionX,positionY,image)
                            Balloon balloon = new Balloon(mobList,matrix,x,y,globals.getBalloon());
                            matrix[y][x] = balloon;
                            mobList.add(balloon);
                            totalBalloons--;
                    }
                }
                else{
                    if(((x!=1) && (y!=2)) && ((x!=2) && (y!=1))){
                    Balloon balloon = new Balloon(mobList,matrix,x,y,globals.getBalloon());
                    matrix[y][x] = balloon;
                    mobList.add(balloon);
                    totalBalloons--;
                    }
                }
            }  
        }
        while(totalBarrels>0){//creates x amount of barrels in the maze
            int x = random.nextInt(bounds-1);
            int y = random.nextInt(bounds-1);
            if((x!=0) && (y!=0)){
                if(y%2==0){
                    if(x%2!=0)
                        if(((x!=1) && (y!=2)) && ((x!=2) && (y!=1)))
                            if(matrix[y][x].isPass()==true){
                            //Balloon(mobs,matrix,positionX,positionY,image)
                                Barrel barrel = new Barrel(mobList,matrix,x,y,globals.getBarrel());
                                matrix[y][x] = barrel;
                                mobList.add(barrel);
                                totalBarrels--;
                            }
                }
                else{
                    if(((x!=1) && (y!=2)) && ((x!=2) && (y!=1))){
                        Barrel barrel = new Barrel(mobList,matrix,x,y,globals.getBarrel());
                        matrix[y][x] = barrel;
                        mobList.add(barrel);
                        totalBarrels--;
                    }
                }
            }  
        } 
        
        matrix[1][1] = bomberman;
        
        
    }
}    
        
    
 

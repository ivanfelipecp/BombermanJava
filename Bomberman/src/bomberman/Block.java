package bomberman;

import javax.swing.ImageIcon;

public class Block extends Element{

    private boolean power;
    private boolean door;
    private ImageIcon image;

    public Block(boolean power, boolean door, int positionX, int positionY, ImageIcon image) {
        super(true, false, positionX, positionY, image,true);
        this.power = power;
        this.door = door;
        
    }

    @Override
    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }
    
    @Override
    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    @Override
    public boolean isDanger() {
        return false;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void setAlive(boolean alive) {
            
    }
    
    


 
}

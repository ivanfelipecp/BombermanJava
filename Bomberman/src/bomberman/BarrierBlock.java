package bomberman;

import javax.swing.ImageIcon;


public class BarrierBlock extends Element{

    public BarrierBlock(int positionX, int positionY, ImageIcon image) {
        super(false, false, positionX, positionY, image,false);
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
    public boolean isAlive() {
        return false;
    }

    @Override
    public void setAlive(boolean alive) {
        
    }
   
}

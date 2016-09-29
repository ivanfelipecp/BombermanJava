package bomberman;

import javax.swing.ImageIcon;

public class Bomb extends Element{
    
    private int damage;
    
    public Bomb(int positionX, int positionY, ImageIcon image, int damage) {
        super(true, false, positionX, positionY, image,false);
        this.damage = damage;
    }
       

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
    

package bomberman;

import javax.swing.ImageIcon;

public abstract class Element {
    private boolean destructible; //if it is destructible
    private boolean pass; //if it is pass
    private int positionX; 
    private int positionY;
    private ImageIcon image; //image
    private boolean secret; //if it is secret

    public Element(boolean destructible, boolean pass, int positionX, int positionY, ImageIcon image,boolean secret) {
        this.destructible = destructible;
        this.pass = pass;
        this.positionX = positionX;
        this.positionY = positionY;
        this.image = image;
        this.secret = secret;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }
    

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public boolean isDestructible() {
        return destructible;
    }

    public void setDestructible(boolean destructible) {
        this.destructible = destructible;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public abstract boolean isDoor();
    
    public abstract boolean isPower();
    
    public abstract boolean isDanger();
    
    public abstract boolean isAlive();
    
    public abstract void setAlive(boolean alive);
}

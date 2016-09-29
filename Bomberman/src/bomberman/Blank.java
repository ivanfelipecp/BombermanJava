package bomberman;

import javax.swing.ImageIcon;

public class Blank extends Element{
    private boolean danger;
    private boolean door;
    private boolean power;
    private ImageIcon imageDanger;
    private ImageIcon imageDoor;
    private ImageIcon imagePower;

    public Blank(boolean danger, boolean door, boolean power, ImageIcon imageDanger, ImageIcon imageDoor, ImageIcon imagePower,int positionX, int positionY,ImageIcon image) {
        super(true, true, positionX, positionY, image,true);
        this.danger = danger;
        this.door = door;
        this.power = power;
        this.imageDanger = imageDanger;
        this.imageDoor = imageDoor;
        this.imagePower = imagePower;
    }

    @Override
    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    @Override
    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    } 

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }
    
    
    @Override
    public ImageIcon getImage() {
        ImageIcon temp;
        if (this.danger==true){
            return this.imageDanger;
        }
        else if (this.power==true){
            temp = this.imagePower;
        }
        else if (this.door == true){
            temp = this.imageDoor;
        }
        else
            temp = Globals.getGlobals().getBlank();
        
        return temp;
        
    }

    public void explode() {
        
        this.danger = true;
        this.power = false;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void setAlive(boolean alive) {
        
    }

    public ImageIcon getImageDanger() {
        return imageDanger;
    }

    public void setImageDanger(ImageIcon imageDanger) {
        this.imageDanger = imageDanger;
    }
    
    
    
    
    
    
    
}

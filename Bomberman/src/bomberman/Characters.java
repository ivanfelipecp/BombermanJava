package bomberman;

import javax.swing.ImageIcon;


public abstract class Characters extends Element{

    private Element[][] matrix;
    private boolean alive;

    public Characters(Element[][] matrix,int positionX, int positionY, ImageIcon image) {
        super(false, false, positionX, positionY, image,false);
        this.matrix = matrix;
        this.alive = true;
    }
    
    public void setMatrix(Element[][] matrix) {
        this.matrix = matrix;
    }

    public Element[][] getMatrix() {
        return matrix;
    }
    
    public abstract boolean move(int X,int Y,int c,int f);

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public abstract void run();
    
    
    
}

package bomberman;
import java.awt.Image;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
public class Utils {

    public Utils() {
    }
    
    public ImageIcon setIcon(int scale,String direction){ //return a new image with the scale of the parameter
        URL url = getClass().getResource(direction);
        ImageIcon icon = new ImageIcon(url);
        ImageIcon tempIcon = new ImageIcon(icon.getImage().getScaledInstance(scale, -1, Image.SCALE_DEFAULT));
        return tempIcon;
    }
    
    public void setPast(int X,int Y,Element matrix[][]){ //set a blank space in the matrix 
        Globals global = Globals.getGlobals();
        Blank blank = new Blank(false,false,false,global.getExplosion(),global.getDoor(),global.getPower(),X,Y,global.getBlank());
        matrix[Y][X] = blank;      
    }   
        
    public Thread playSound(final String sound){//return a thread that play a sound
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try{
                    URL url = this.getClass().getClassLoader().getResource(sound);
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
            
        }
                catch(Exception e){
            
                }
            }
        };
        Thread thread = new Thread(runnable);
        return thread;
    }
    
    public Clip getSound(String sound){//return a clip
        Clip clip = null;
        try{
            URL url = this.getClass().getClassLoader().getResource(sound);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        }
        catch(Exception e){
            
        }
        return clip;
    }
}

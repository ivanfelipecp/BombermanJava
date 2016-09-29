package bomberman;

public class MobException extends Exception{

    public MobException() {
        super("There is no mobs");
    }
    
    public MobException(String msg){
        super(msg);
    }
    
}

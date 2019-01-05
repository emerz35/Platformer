package exceptions;

/**
 *
 * @author Charlie Hands
 */
public class StorageFullException extends Exception{
    public StorageFullException(){
        super("This storage is full and cannot be added to.");
    }
    public StorageFullException(String msg){
        super(msg);
    }
}

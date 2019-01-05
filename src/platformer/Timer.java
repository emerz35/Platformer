package platformer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charlie
 */
public class Timer{
    private final float start,change,stop;
    private float timer = 0;
    public Timer(float start, float change, float stop){
        this.start = start;
        this.change = change;
        this.stop = stop;
    }
    public synchronized void start(){
        start(start);
    }
    public void start(float start){
        timer = start;
        new Thread(()->{
            while(!hasEnded()){
                try {
                    Thread.sleep((long)(1000*change));
                    timer-=change;
                    System.out.println(timer);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
    public synchronized float getTime(){
        return timer;
    }
    public synchronized boolean hasEnded(){
        return timer<=stop;
    }
    
}

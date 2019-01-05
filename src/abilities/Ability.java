package abilities;

import gameObjects.GameObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import platformer.Timer;

/**
 *
 * @author Charlie
 */
public abstract class Ability{
    protected Timer cooldown, timer;
    private int button;
    protected GameObject target;
    protected Ability(GameObject target,int button, Timer cooldown, Timer timer){
        this.target = target;
        this.cooldown = cooldown;
        this.timer= timer;
        this.button = button;
    }
    protected Ability(GameObject target,int button, float cooldown, float duration){
        this.target = target;
        this.cooldown = new Timer(cooldown,1,0);
        this.timer = new Timer(duration,0.1f,0);
        this.button = button;
    }
    abstract void beginning();
    abstract void run();
    abstract void end();
    public void start(){
        if(cooldown.hasEnded()) new Thread(()->{
            timer.start();
            beginning();
            while(!timer.hasEnded()){
                try {
                    Thread.sleep(1000/60);
                    run();
                    System.out.println(timer.getTime());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ability.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        end();
        cooldown.start();
        }).start();
    }
    public boolean hasPressed(int input){
        return input == button;
    }
    public void setButton(int button){
        this.button = button;
    }
    
}

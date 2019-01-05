package abilities;

import gameObjects.GameObject;
import java.awt.event.KeyEvent;

/**
 *
 * @author Charlie Hands
 */
public class DashAbility extends Ability{

    public DashAbility(GameObject target,int button) {
        super(target,button,4,0.2f);
    }
    public DashAbility(GameObject target){
        super(target,KeyEvent.VK_SHIFT,4,0.2f);
    }

    @Override
    void beginning() {
        target.setVelX(target.getVelX() * 3f);
    }

    @Override
    void run() {
    }

    @Override
    void end() {
        target.setVelX(target.getVelX() / 3f);
    }
    
}

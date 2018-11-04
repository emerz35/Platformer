package gameObjects.behaviours;

import gameObjects.GameObject;
import gameObjects.Platform;
import platformer.Platformer;

/**
 *
 * @author Charlie Hands
 */
public class OnPlatformMovementBehaviour implements MovementBehaviour{
    private final Platform platform;
    private final float velx;
    public OnPlatformMovementBehaviour(Platform platform,float velx){
        this.platform = platform;
        this.velx = velx;
    }
    @Override
    public void tick(GameObject o) {
        o.setX(Platformer.clamp(o.getX(),platform.getX(),platform.getX()+platform.getWidth()));
        if(o.getX() == platform.getX())o.setDirection("right");
        else if(o.getX()+o.getWidth() == platform.getX()+platform.getWidth())o.setDirection("left");
        if(o.getVelX()<=velx)o.setVelX(o.getVelX()*o.getDirection().getMultiplier());
        o.setVelX(speedup(o.getVelX(),(velx - Math.abs(o.getVelX()))));
        o.setVelY(o.getVelY() + Platformer.GRAVITY);
    }
    public float speedup(float vel, float deceleration){
            return vel < 0 ? vel - deceleration : vel + deceleration;
    }
    
}

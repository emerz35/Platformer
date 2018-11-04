package gameObjects.behaviours;

import gameObjects.GameObject;
import geometry.LineFunction;

/**
 *
 * @author Charlie Hands
 */
public class LineMovementBehaviour implements MovementBehaviour{
    private final LineFunction ln;
    private float velX;
    public LineMovementBehaviour(LineFunction ln, float velX){
        this.ln = ln;
        this.velX = velX;
    }
    @Override
    public void tick(GameObject o) {
        if(o.getX() <= ln.getXBounds()[0] || o.getX() >= ln.getXBounds()[1]||o.getY()<= ln.getYBounds()[0]||o.getY()>=ln.getYBounds()[1]) o.swapDirections();
        o.setVelX(velX*o.getDirection().getMultiplier());
        o.setVelY(0);
        o.setY(ln.f(o.getX()));
    }
    
}

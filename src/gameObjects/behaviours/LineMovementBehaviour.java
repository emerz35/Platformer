package gameObjects.behaviours;

import gameObjects.GameObject;
import geometry.LineFunction;

/**
 *
 * @author Charlie Hands
 */
public class LineMovementBehaviour implements MovementBehaviour{
    int add = 1;
    private LineFunction ln = new LineFunction(0,10,new float[]{0,50},new float[]{100,100});
    @Override
    public void tick(GameObject o) {
        o.setVelY(0);
        o.setY(ln.f(o.getX()));
    }
    
}

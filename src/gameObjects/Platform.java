package gameObjects;

import gameObjects.behaviours.NoMovementBehaviour;
import java.awt.Color;
import java.awt.Graphics;
import stages.Stage;

/**
 *
 * @author Charlie Hands
 */
public class Platform extends GameObject{

    public Platform(float x, float y, float width, float height, Stage stage) {
        super(x, y, width, height,0, Color.GRAY, new Collision(x,y+1,width,height), new NoMovementBehaviour(), stage);
    }

    @Override
    public void tick() {}
    
    @Override
    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect((int)x, (int) y, (int) width, (int) height - 1);
    }

    @Override
    public void collision(GameObject o) {
    }
}

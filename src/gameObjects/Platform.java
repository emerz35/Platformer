package gameObjects;

import gameObjects.behaviours.NoMovementBehaviour;
import java.awt.Color;
import stages.Stage;

/**
 *
 * @author Charlie Hands
 */
public class Platform extends GameObject{

    public Platform(float x, float y, float width, float height, Stage stage) {
        super(x, y, width, height,0f, Color.gray, new NoMovementBehaviour(), stage);
    }

    @Override
    public void tick() {
        x += velx;
        y += vely;
        movement.tick(this);
        collision.setX(x);
        collision.setY(y);
    }

    @Override
    public void collision(GameObject o) {
    }
}

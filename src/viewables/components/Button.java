package viewables.components;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Charlie Hands
 */
public class Button {
    private float x,y,width,height;
    private final Color colour, onHover;
    private String id;
    public Button(String id,float x, float y, float width, float height, Color colour, Color onHover){
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colour = colour;
        this.onHover = onHover;
    }
    public float getX(){
        return x;
    }
    public void setX(float x){
        this.x = x;
    }
    public float getY(){
        return y;
    }
    public void setY(float y){
        this.y = y;
    }
    public void render(Graphics g){
        g.setColor(colour);
    }
    public String getID(){
    return this.id;
    }
}

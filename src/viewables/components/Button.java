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
    private final Action onClick;
    public Button(float x, float y, float width, float height, Color colour, Color onHover, Action onClick){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colour = colour;
        this.onHover = onHover;
        this.onClick = onClick;
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
        g.fill3DRect((int)x, (int)y, (int)width, (int)height, true);
    }
    public void onClick(){
        onClick.action();
    }
    public boolean withinBounds(int mx, int my){
        return mx >= x - width && mx <=x + width && my >= y - height && my <= y + height;
    }
}

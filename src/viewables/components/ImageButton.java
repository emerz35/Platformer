package viewables.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 *
 * @author Charlie
 */
public class ImageButton extends Button{
    private BufferedImage image, onHover;
    public ImageButton(String name, float x, float y, float width, float height, Action onClick, BufferedImage image) {
        super(name, x, y, width, height, null, null, onClick);
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(image.getScaledInstance((int)width,(int)height,0),(int)x,(int)y,null);
    }
    
}

package viewables.components;

import java.awt.Graphics;

/**
 *
 * @author Charlie Hands
 */
public interface Component {
    public void render(Graphics g);
    public void action(int mx, int my);
   
}

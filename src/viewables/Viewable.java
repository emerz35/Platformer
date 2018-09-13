package viewables;

import java.awt.Graphics;
import java.util.LinkedList;
import viewables.components.Component;

/**
 *
 * @author Charlie Hands
 */
public interface Viewable {
    public void onClick();
    public void highlight();
    public void render(Graphics g);

}

package viewables;

import java.awt.Graphics;

/**
 *
 * @author Charlie Hands
 */
public interface Viewable {
    public void onClick(int mx, int my);
    public void highlight(int mx, int my);
    public void render(Graphics g);
    public void mouseDown(int mx, int my);
}

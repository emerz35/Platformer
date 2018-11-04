package platformer;

import java.awt.Button;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Charlie Hands
 */
public class Window{
    public Window(String title, int width, int height, Platformer game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}

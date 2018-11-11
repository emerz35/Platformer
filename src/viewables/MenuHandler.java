package viewables;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 *
 * @author Charlie Hands
 */
public class MenuHandler extends MouseAdapter{
    private final LinkedList<Viewable> currentViewables;
    public MenuHandler() {
        this.currentViewables = new LinkedList<>();
    }
    @Override
    public void mouseMoved(MouseEvent e){
        currentViewables.getLast().highlight(e.getX(),e.getY());
    }
    @Override
    public void mouseClicked(MouseEvent e){
        currentViewables.getLast().onClick(e.getX(),e.getY());
    }
    @Override
    public void mousePressed(MouseEvent e){
        currentViewables.getLast().mouseDown(e.getX(), e.getY());
    }
    public void addViewable(Viewable viewable){
        currentViewables.add(viewable);
    }
    public void removeCurrentViewable(){
        currentViewables.pollLast();
    }
    public void render(Graphics g){
        currentViewables.forEach(x -> x.render(g));
    }
    public Viewable getTopViewable(){
        return currentViewables.isEmpty() ? null:currentViewables.getLast();
    }
}

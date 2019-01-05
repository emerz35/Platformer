package stages;

import gameObjects.GameObject;
import java.awt.Image;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Charlie Hands
 */
public class SavedStage implements Serializable{
    private final Image image;
    private final List<GameObject> objects = new LinkedList<>();
    public SavedStage(Stage stage){
        objects.addAll(stage.getObjects());
        this.image = stage.getImage();
    }
    public List<GameObject> getObjects(){
        return objects;
    }
    public Image getImage(){
        return image;
    }
    
}

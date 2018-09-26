package platformer;

import items.Stackable;
import java.util.HashMap;

/**
 *
 * @author Charlie Hands
 */
public class Storage<T> extends HashMap<T,Integer>{

    public Integer add(T item){
        if(item instanceof Stackable) for(T i : keySet()){
            if(i instanceof Stackable) if(((Stackable) i).getID() == ((Stackable)item).getID()) return put(i,get(i) + 1);
        }
        return put(item,1);
        //if(containsKey(item)) put(item,get(item)+1);
        //else put(item,1);
    }
    @Override
    public Integer remove(Object o){
        if(o instanceof Stackable) for(T i : keySet()){
            if(i instanceof Stackable) if(((Stackable) i).getID() == ((Stackable)o).getID() && get(i) > 0) return put(i,get(i) - 1);
        }
        return super.remove(o);
    }
    public void removeAllOf(T o){
        super.remove(o);
    }
    public Integer getStackable(int ID){
        for(T i : keySet()){
            if(i instanceof Stackable) if(((Stackable) i).getID() == ID) return get(i);
        }
        return null;
    }
    
    @Override
    public Integer get(Object o){
        if(o instanceof Stackable) for(T i : keySet()){
            if(i instanceof Stackable) if(((Stackable) i).getID() == ((Stackable)o).getID()) return get(i);
        }
        return super.get(o);
    }
}

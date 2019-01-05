package platformer;

import exceptions.StorageFullException;
import items.Stackable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Charlie Hands
 * @param <T> The class to be stored
 */
public class Storage<T> extends HashMap<T,Integer>{
    private final int capacity;
    public Storage(int capacity){
        this.capacity = capacity;
    }
    public Integer add(T item) throws StorageFullException{
        if(item instanceof Stackable) for(T i : keySet()){
            if(i instanceof Stackable) if(((Stackable) i).getID() == ((Stackable)item).getID()) return put(i,get(i) + 1);
        }
        if(keySet().size() < capacity)return put(item,1);
        else throw new StorageFullException();
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
    public int getCapacity(){
        return capacity;
    }
    public List<T> getItems(){
        List<T> items = new LinkedList<>();
        keySet().forEach(x-> items.add(x));
        return items;
    }
}

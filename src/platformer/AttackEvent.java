package platformer;

import gameObjects.GameObject;

/**
 *
 * @author Charlie Hands
 */
public class AttackEvent {
    private GameObject defender;
    private GameObject attacker;
    
    public GameObject getAttacker(){
        return attacker;
    }
    public GameObject getDefender(){
        return defender;
    }
    public void attackEvent(){
        defender.defend(this,attacker.attack(this));
    }
}

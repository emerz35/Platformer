package platformer;

import gameObjects.GameObject;

/**
 *
 * @author Charlie Hands
 */
public class AttackEvent {
    private final GameObject defender;
    private final GameObject attacker;
    public AttackEvent(GameObject attacker, GameObject defender){
        this.attacker = attacker;
        this.defender = defender;
    }
    
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

import java.util.HashMap;
import java.util.Objects;


/**
 * This is a plain old java project (POJO) that represents an abstract base player, Monster,
 * which is used for a turn-based text game of...............
 * with attributes such as the Monster's health points, experience points, max health points, & item inventory.
 * This class is a parent class to Imp.java & Kobold.java
 * Link to GitHub Repo: <a href="https://github.com/CST-338/strategy-pattern-dfouch-csumb">...</a>
 * @author Dakota L. Fouch
 * @since 07/18/2024
 * CST 338 Software Design with Dr. C
 * HW3: Strategy Pattern (Monster.java)
 */
public abstract class Monster {

    private int hp; // the current amount of health points of the Monster
    private int xp = 10; // the current amount of experience points of the Monster
    private int maxHP; // the max amount of health points the Monster can have
    private HashMap<String, Integer> items; // the inventory of items of the Monster

    /**
     * Parameterized constructor to construct the Monster object with the provided maxHP, hp, & inventory of items.
     *
     * @param maxHP the max amount of health points the Monster can have, as an int
     * @param xp the current amount of experience points the Monster has, as an int
     * @param items the inventory of items the Monster has, as a HashMap
     *
     */
    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    /**
     * Returns the experience points (XP) of the Monster.
     *
     * @return the experience points (XP) of the Monster, as an int.
     */
    public int getXp() {
        return xp;
    }

    /**
     * Returns the maximum possible health points (HP) of the Monster.
     *
     * @return the maximum possible health points (HP) of the Monster, as an int.
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * Returns the health points (HP) of the Monster.
     *
     * @return the health points (HP) of the Monster, as an int.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the health points (HP) value of the Monster.
     *
     * @param hp the ID number for the Monster, as an int.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Returns the items in the inventory of the Monster.
     *
     * @return the items in the inventory of the Monster, as a HashMap of [] as the key and [] as the value
     */
    public HashMap<String, Integer> getItems() {
        return items;
    }

    /**
     * Sets the items in the inventory of the Monster.
     *
     * @param items the items to store in the inventory of the Monster, as a HashMap of [] as the key and [] as the value
     */
    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    /**
     * Compares the equality of two Monster objects based on the object's contents/fields/attributes.
     * (Determines if object's contents are equal).
     *
     * @return a boolean value of true if the contents of all fields of the Monster object equal the contents of the other Monster object, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monster monster = (Monster) o;
        return getHp() == monster.getHp() && getXp() == monster.getXp() && getMaxHP() == monster.getMaxHP() && Objects.equals(getItems(), monster.getItems());
    }

    /**
     * Generates a hashcode of a Monster object based on the hash produced by the object's contents/fields/attributes,
     * (Determine if objects are the exact same, as in located in the same place in memory).
     *
     * @return the hashcode produced by the all fields of the Monster object.
     */
    @Override
    public int hashCode() {
        int result = getHp();
        result = 31 * result + getXp();
        result = 31 * result + getMaxHP();
        result = 31 * result + Objects.hashCode(getItems());
        return result;
    }

    /**
     * Overrides the toString() function to return a concatenated & formatted string
     * of the Monster's current health points compared to their max health points.
     *
     * @return a concatenated & formatted string of the Monster's current health points compared to their max health points.
     */
    @Override
    public String toString() {
        return "hp=" + hp + "/" + maxHP;
    }
}

package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;


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

    private Integer hp; // the current amount of health points of the Monster
    private Integer xp = 10; // the current amount of experience points of the Monster
    private Integer maxHP; // the max amount of health points the Monster can have
    private HashMap<String, Integer> items; // the inventory of items of the Monster
    Integer str = 10; // the strength stat of the Monster
    Integer def = 10; // the defense stat of the Monster
    Integer agi = 10; // the agility stat of the Monster
    Attack attack; // the attack object of the Monster

    /**
     * Parameterized constructor to construct the Monster object with the provided maxHP, hp, & inventory of items.
     *
     * @param maxHP the max amount of health points the Monster can have, as an Integer
     * @param xp the current amount of experience points the Monster has, as an Integer
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
     * Returns a random number between the provided min and max numbers, inclusive
     *
     * @return a random number between the provided min and max numbers, as an Integer.
     */
    Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if (min > max) { // if true, swap to avoid negative values
            Integer temp = min;
            min = max;
            max = temp;
        }
        // returns a random number between min and max inclusive
        return rand.nextInt(max - min) + min;
    }

    /**
     * Calculates whether the Monster took damage or not.
     *
     * @return a boolean of true if the Monster took damage, otherwise false.
     */
    public boolean takeDamage(Integer damage) {

        // determine if the damage is affecting to the Monster
        if (damage > 0) {
            hp = hp - damage; // subtract the damage points from the Monster's health points
            System.out.println("The creature was hit for " + damage + " damage");
        }

        if (hp <= 0) { // determine if the Monster died
            System.out.println("Oh no! the creature has perished");
        }

        System.out.println(toString()); // display the Monster's toString()

        if (hp > 0) { // return true if Monster is still alive
            return true;
        }
        return false; // otherwise, false
    }

    /**
     * Initiates an attack on another Monster.
     *
     * @return the stats of the targets Monster?
     */
    public Integer attackTarget(Monster target) {

        return 0 ;
    }

    /**
     * Returns the experience points (XP) of the Monster.
     *
     * @return the experience points (XP) of the Monster, as an Integer.
     */
    public Integer getXp() {
        return xp;
    }

    /**
     * Returns the maximum possible health points (HP) of the Monster.
     *
     * @return the maximum possible health points (HP) of the Monster, as an Integer.
     */
    public Integer getMaxHP() {
        return maxHP;
    }

    /**
     * Returns the health points (HP) of the Monster.
     *
     * @return the health points (HP) of the Monster, as an Integer.
     */
    public Integer getHp() {
        return hp;
    }

    /**
     * Sets the health points (HP) value of the Monster.
     *
     * @param hp the ID number for the Monster, as an Integer.
     */
    public void setHp(Integer hp) {
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
     * Returns the strength stat of the Monster.
     *
     * @return the strength stat of the Monster, as an Integer.
     */
    public Integer getStr() {
        return str;
    }

    /**
     * Returns the defense stat of the Monster.
     *
     * @return the defense stat of the Monster, as an Integer.
     */
    public Integer getDef() {
        return def;
    }

    /**
     * Returns the agility stat of the Monster.
     *
     * @return the agility stat of the Monster, as an Integer.
     */
    public Integer getAgi() {
        return agi;
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
        return Objects.equals(getHp(), monster.getHp()) && Objects.equals(getXp(), monster.getXp()) && Objects.equals(getMaxHP(), monster.getMaxHP()) && Objects.equals(getItems(), monster.getItems()) && Objects.equals(getStr(), monster.getStr()) && Objects.equals(getDef(), monster.getDef()) && Objects.equals(getAgi(), monster.getAgi()) && Objects.equals(attack, monster.attack);
    }

    /**
     * Generates a hashcode of a Monster object based on the hash produced by the object's contents/fields/attributes,
     * (Determine if objects are the exact same, as in located in the same place in memory).
     *
     * @return the hashcode produced by the all fields of the Monster object.
     */
    @Override
    public int hashCode() {
        int result = Objects.hashCode(getHp());
        result = 31 * result + Objects.hashCode(getXp());
        result = 31 * result + Objects.hashCode(getMaxHP());
        result = 31 * result + Objects.hashCode(getItems());
        result = 31 * result + Objects.hashCode(getStr());
        result = 31 * result + Objects.hashCode(getDef());
        result = 31 * result + Objects.hashCode(getAgi());
        result = 31 * result + Objects.hashCode(attack);
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

package Monsters;

import java.util.HashMap;

/**
 * This is a plain old java project (POJO) that represents an Imp derived from abstract class, Monster,
 * which is used for a turn-based text game of a
 * with attributes from the parent class such as the Monster's health points, experience points, max health points, & item inventory.
 * This class is a child class to Monster.java and is a sibling class to Kobold.java.
 * Link to GitHub Repo: <a href="https://github.com/CST-338/strategy-pattern-dfouch-csumb">...</a>
 * @author Dakota L. Fouch
 * @since 07/18/2024
 * CST 338 Software Design with Dr. C
 * HW3: Strategy Pattern (Imp.java)
 */
public class Imp extends Monster {

    /**
     * Constructs the Imp object by passing the provided max health points, current experience points,
     * and inventory of items to the parent class's constructor,
     *
     * @param maxHP the max amount of health points the Imp can have, as an int
     * @param xp the current amount of experience points the Imp has, as an int
     * @param items the inventory of items the Imp has, as a HashMap
     *
     */
    public Imp(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        super(maxHP,xp,items); // pass the parameters to the parent class, Monster's, constructor
    }

    /**
     * Overrides the toString() function to return a concatenated & formatted string
     * of the Imp's current health points compared to their max health points.
     *
     * @return a concatenated & formatted string of the Imp's current health points compared to their max health points.
     */
    @Override
    public String toString() {
        return "Imp has : " + super.toString(); // display message specifying the Monster is an Imp & call the parent class's toString to display the health points
    }
}
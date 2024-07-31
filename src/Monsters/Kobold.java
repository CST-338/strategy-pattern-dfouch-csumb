package Monsters;

import Abilities.RangedAttack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This is a plain old java project (POJO) that represents a Kobold derived from abstract class, Monster,
 * which is used for a turn-based text game of a
 * with attributes from the parent class such as the Monster's health points, experience points, max health points, & item inventory.
 * This class is a child class to Monster.java and is a sibling class to Imp.java.
 * Link to GitHub Repo: <a href="https://github.com/CST-338/strategy-pattern-dfouch-csumb">...</a>
 * @author Dakota L. Fouch
 * @since 07/18/2024
 * CST 338 Software Design with Dr. C
 * HW3: Strategy Pattern (Monsters.Kobold.java)
 */
public class Kobold extends Monster {

    /**
     * Constructs the Kobold object by passing the provided max health points, current experience points,
     * and inventory of items to the parent class's constructor,
     *
     * @param maxHP the max amount of health points the Kobold can have, as an Integer
     * @param xp the current amount of experience points the Kobold has, as an Integer
     * @param items the inventory of items the Kobold has, as a HashMap
     *
     */
    public Kobold(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        super(maxHP,xp,items); // pass the parameters to the parent class, Monster's, constructor

        HashMap<String, List<Integer>> monsterStatsMax = new HashMap<>(); // create a HashMap to hold the Monster and Kobold stat values
        monsterStatsMax.put("str", Arrays.asList(str, 15)); // store the base Monster and Kobold strength stats in the HashMap
        monsterStatsMax.put("def", Arrays.asList(def, 6)); // store the base Monster and Kobold defense stats in the HashMap
        monsterStatsMax.put("agi", Arrays.asList(agi, 3)); // store the base Monster and Kobold agility stats in the HashMap

        attack = new RangedAttack(this); // initialize an RangedAttack object

        // iterate through each Monster stat in the HashMap, to find the final stat value
        for (String stat : monsterStatsMax.keySet()) {
            if (stat.equals("str")) {
                str = super.getAttribute(monsterStatsMax.get(stat).get(0), monsterStatsMax.get(stat).get(1)); // pass the base Monster and Kobold strength stats to return a final value
            } else if (stat.equals("def")) {
                def = super.getAttribute(monsterStatsMax.get(stat).get(0), monsterStatsMax.get(stat).get(1)); // pass the base Monster and Kobold defense stats to return a final value
            } else if (stat.equals("agi")) {
                agi = super.getAttribute(monsterStatsMax.get(stat).get(0), monsterStatsMax.get(stat).get(1)); // pass the base Monster and Kobold agility stats to return a final value
            }
        }
    }

    /**
     * Overrides the toString() function to return a concatenated & formatted string
     * of the Kobold's current health points compared to their max health points.
     *
     * @return a concatenated & formatted string of the Kobold's current health points compared to their max health points.
     */
    @Override
    public String toString() {
        return "Monsters.Kobold has : " + super.toString(); // display message specifying the Monster is a Kobold & call the parent class's toString to display the health points
    }
}
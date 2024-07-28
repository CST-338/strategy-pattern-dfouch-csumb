package Abilities;

import Monsters.Monster;

/**
 * This is a plain old java project (POJO) that represents a ranged attack ability based on an attack ability interface.
 * which is used for a turn-based text game of a
 * This class implements interfaces, Attack.java (which extends Ability.java), and is a sibling class MeleeAttack.java.
 * Link to GitHub Repo: <a href="https://github.com/CST-338/strategy-pattern-dfouch-csumb">...</a>
 * @author Dakota L. Fouch
 * @since 07/18/2024
 * CST 338 Software Design with Dr. C
 * HW3: Strategy Pattern (Abilities.RangedAttack.java)
 */
public class RangedAttack implements Attack {

    Monster attacker; // a Monster object representing the attacker

    /**
     * Constructs the RangedAttack object by setting the attacker who makes the attack.
     *
     * @param attacker a Monster object representing this attacker.
     *
     */
    public RangedAttack(Monster attacker) {
        this.attacker = attacker;
    }

    /**
     * Initiates an attack from this Monster to the target Monster.
     *
     * @param target a Monster object representing the target.
     *
     * @return the amount of damage points the Monster inflicted upon the target.
     */
    @Override
    public Integer attack(Monster target) {
        String message = attacker + " uses a ranged attack on " + target;
        System.out.println(message);
        return attacker.getAgi() - target.getAgi(); // return the amount of damage the target took
    }
}
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
 * HW3: Strategy Pattern (RangedAttack.java)
 */
public class RangedAttack implements Attack {

    Monster attacker;

    public RangedAttack(Monster attacker) {
        this.attacker = attacker;
    }

    @Override
    public Integer attack(Monster target) {
        String message = attacker + " uses a ranged attack on " + target;
        System.out.println(message);
        return null;
    }
}

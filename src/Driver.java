import Monsters.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        HashMap<String, Integer> items = new HashMap<>();
        items.put("gold", 5);
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Imp(15, 20, items));
        monsters.add(new Kobold(1, 5, items));

        for (Monster m : monsters) {
            System.out.println(m);
        }

        while ((monsters.get(0).getHp() > 0) && (monsters.get(1).getHp() > 0)) {
            System.out.println(monsters.get(0).attackTarget(monsters.get(1)));
            System.out.println(monsters.get(1).attackTarget(monsters.get(0)));
        }
    }
}

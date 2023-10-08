import Entities.Creature;
import Entities.Human;

import java.util.Random;

public class Game {
    public int damageModifierCalculation(int attack, int defence) {
        if (attack <= defence) {
            return 1;
        } else {
            return attack - defence + 1;
        }
    }

    public Boolean rollDice(int mod) {
        Random random = new Random();
        for (int i = 0; i < mod; i++) {
            int a = random.nextInt(6) + 1;
            if (a == 5 || a == 6) {
                return true;
            }
        }
        return false;
    }

    public void damage(Creature attacker, Creature defender) {
        if (attacker != null && defender != null) {
            defender.setHealth(defender.getHealth() - attacker.hit());
            if (defender.getHealth() <= 0 && defender.getClass().getName() == "Entities.Human") {
                Human human = (Human) defender;
                human.hill();
            }
            if (defender.getHealth() <= 0) {
                System.out.println("Сущеество " + defender.getName() + " убито");
                System.out.println(attacker.getName() + " победитель");
            }

        }
    }
}

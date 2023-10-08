import Entities.Human;
import Entities.Monster;

import java.time.temporal.ValueRange;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Monster monster = new Monster("monster", 1, 10, 100, ValueRange.of(1, 10));
        Human human = new Human("human", 2, 8, 3, ValueRange.of(1, 10));
        int i = 1;
        while (human.getHealth() > 0 && monster.getHealth() > 0) {
            if (i % 2 != 0) {
                if (game.rollDice(game.damageModifierCalculation(human.getAttack(), monster.getDefense())) == true) {
                    game.damage(human, monster);
                }
            } else {
                if (game.rollDice(game.damageModifierCalculation(monster.getAttack(), human.getDefense())) == true) {
                    game.damage(monster, human);
                }
            }
            i++;
        }

    }
}
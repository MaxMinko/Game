package Entities;

import lombok.Data;


import java.time.temporal.ValueRange;

@Data
public class Human extends Creature {
    private int maxHealth;
    private int recoveries = 4;

    public Human(String name, int attack, int defense, int health, ValueRange damage) {
        super(name, attack, defense, health, damage);
        maxHealth = getHealth();
    }

    public void hill() {
        if (recoveries > 0) {
            if (maxHealth > 3) {
                int health = maxHealth / 3;
                setHealth(health);
            } else {
                setHealth(1);
            }
            recoveries--;
        }
    }
}

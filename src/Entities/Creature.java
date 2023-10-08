package Entities;

import lombok.Data;
import lombok.NonNull;

import java.time.temporal.ValueRange;
import java.util.Random;

@Data
public class Creature {
    private String name;

    private int attack;

    private int defense;

    private int health;

    private ValueRange damage;

    public Creature() {
    }

    public Creature(@NonNull String name, int attack, int defense, int health, ValueRange damage) {
        this.name = name;
        this.attack = validatedCreatureParameter(attack);
        this.defense = validatedCreatureParameter(defense);
        this.health = validatedCreatureParameter(health);
        this.damage = validatedDamage(damage);
    }


    public int hit() {
        Random random = new Random();
        int a = (int) (random.nextInt((int) damage.getMaximum() - (int) damage.getMinimum() + 1)
                + damage.getMinimum());
        return a;
    }

    public ValueRange validatedDamage(ValueRange damage) {
        try {
            if (damage.getMinimum() <= 0) {
                throw new IllegalArgumentException("Минимальное значение урона должно быть больше 0");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ValueRange.of(1, damage.getMaximum());
        }
        return damage;
    }

    public int validatedCreatureParameter(int parameter) {
        try {
            if (parameter <= 0) {
                parameter = 1;
                throw new IllegalArgumentException("Параметр должен  быть больше 0");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return parameter;
    }
}

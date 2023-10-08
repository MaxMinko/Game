package Entities;

import lombok.*;

import java.time.temporal.ValueRange;

@Data
public class Monster extends Creature {
    public Monster(@NonNull String name, int attack, int defense, int health, ValueRange damage) {
        super(name, attack, defense, health, damage);
    }
}

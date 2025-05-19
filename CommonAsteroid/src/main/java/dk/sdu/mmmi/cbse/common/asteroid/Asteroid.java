package dk.sdu.mmmi.cbse.common.asteroid;

import dk.sdu.mmmi.cbse.common.EEntityTypes;
import dk.sdu.mmmi.cbse.common.Entity;

public class Asteroid extends Entity {
    private double health;
    private double spriteRotation;
    private EAsteroidStage asteroidStage;
    double damage;
    Entity damagedBy;

    public Entity getDamagedBy() {
        return damagedBy;
    }

    public void setDamagedBy(Entity damagedBy) {
        this.damagedBy = damagedBy;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public EAsteroidStage getAsteroidStage() {
        return asteroidStage;
    }

    public void setAsteroidStage(EAsteroidStage asteroidStage) {
        this.asteroidStage = asteroidStage;
    }

    public double getSpriteRotation() {
        return spriteRotation;
    }

    public void setSpriteRotation(double spriteRotation) {
        this.spriteRotation = spriteRotation;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void decreaseHealth(double damage) {
        health -= damage;
    }
}

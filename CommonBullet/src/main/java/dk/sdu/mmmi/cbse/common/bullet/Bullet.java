package dk.sdu.mmmi.cbse.common.bullet;
import dk.sdu.mmmi.cbse.common.Entity;

public class Bullet extends Entity {
    double damage;
    Entity owner;

    public Entity getOwner() {
        return owner;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setOwner(Entity e) {
        this.owner = e;
    }
}
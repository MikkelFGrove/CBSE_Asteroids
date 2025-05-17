package dk.sdu.mmmi.cbse.common.bullet;
import dk.sdu.mmmi.cbse.common.Entity;

public class Bullet extends Entity {
    double damage;

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
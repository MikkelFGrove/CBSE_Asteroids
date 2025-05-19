package dk.sdu.mmmi.cbse.common.player;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;

public class Player extends Entity {
    private double health;
    double damage;

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void decreaseHealth(double health) {
        this.health -= health;
    }

    private IWeaponSPI iweapon;

    public IWeaponSPI getIweapon() {
        return iweapon;
    }

    public void setIweapon(IWeaponSPI iweapon) {
        this.iweapon = iweapon;
    }
}

package dk.sdu.mmmi.cbse.common.spaceship;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;

public class Spaceship extends Entity {
    private long timeSinceMoved = 0;
    private double health;

    private IWeaponSPI iweapon;

    public IWeaponSPI getIweapon() {
        return iweapon;
    }

    public void setIweapon(IWeaponSPI iweapon) {
        this.iweapon = iweapon;
    }

    public long getTimeSinceMoved() {
        return timeSinceMoved;
    }

    public void setTimeSinceMoved(long timeSinceMoved) {
        this.timeSinceMoved = timeSinceMoved;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public double getHealth() {
        return health;
    }

    public void decreaseHealth(double damage) {
        health -= damage;
    }
}

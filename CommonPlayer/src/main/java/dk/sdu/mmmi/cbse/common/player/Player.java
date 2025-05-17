package dk.sdu.mmmi.cbse.common.player;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;

public class Player extends Entity {
    private double health;

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void decreaseHealth(double health) {
        System.out.println(health);
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

package dk.sdu.mmmi.cbse.common.player;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;

public class Player extends Entity {
    private IWeaponSPI iweapon;

    public IWeaponSPI getIweapon() {
        return iweapon;
    }

    public void setIweapon(IWeaponSPI iweapon) {
        this.iweapon = iweapon;
    }
}

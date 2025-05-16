import dk.sdu.mmmi.cbse.common.bullet.IBulletSPI;
import dk.sdu.mmmi.cbse.weapon.Rifle;

module Weapon {
    requires CommonBullet;
    requires CommonWeapon;
    requires Common;
    provides dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI with Rifle;

    uses IBulletSPI;
}
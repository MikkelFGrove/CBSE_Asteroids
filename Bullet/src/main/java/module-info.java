import dk.sdu.mmmi.cbse.bullet.BulletPlugin;
import dk.sdu.mmmi.cbse.bullet.BulletProcess;
import dk.sdu.mmmi.cbse.common.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.IGamePluginService;
import dk.sdu.mmmi.cbse.common.bullet.IBulletSPI;

module Bullet {
    requires CommonBullet;
    requires CommonWeapon;
    requires Common;

    provides IGamePluginService with BulletPlugin;
    provides IEntityProcessingService with BulletProcess;
    provides IBulletSPI with BulletPlugin;
}
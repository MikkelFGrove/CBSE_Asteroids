package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.Entity;

public interface IBulletSPI {
    Bullet createBullet(Entity e, double x, double y, double angle, double damage);
}

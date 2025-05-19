package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.IBulletSPI;

public class BulletPlugin implements IGamePluginService, IBulletSPI {
    @Override
    public void start(GameData gameData, World world) {
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity bullet : world.getEntities(Bullet.class)) {
            world.removeEntity(bullet);
        }
    }

    @Override
    public Bullet createBullet(Entity e, double x, double y, double angle, double damage) {
        Bullet bullet = new Bullet();
        bullet.setEntityType(EEntityTypes.BULLET);
        bullet.setSprite("bullet.png", 0.006);
        bullet.setRotation(angle);
        bullet.setDamage(damage);
        bullet.setSize(1);
        bullet.setOwner(e);

        double spawnOffset = 15;

        double offsetX = Math.sin(Math.toRadians(angle)) * spawnOffset;
        double offsetY = Math.cos(Math.toRadians(angle)) * spawnOffset;

        bullet.setX(x + offsetX - bullet.getWidth() / 2d);
        bullet.setY(y + offsetY - bullet.getHeight() / 2d);
        return bullet;
    }
}

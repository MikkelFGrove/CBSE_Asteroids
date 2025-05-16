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
    public Bullet createBullet(double x, double y, double angle) {
        Bullet bullet = new Bullet();
        bullet.setEntityType(EEntityTypes.BULLET);
        bullet.setSprite("bullet.png", 0.006);
        bullet.setRotation(angle);

        double spawnOffset = 15;

        double offsetX = Math.sin(Math.toRadians(angle)) * spawnOffset;
        double offsetY = Math.cos(Math.toRadians(angle)) * spawnOffset;

        bullet.setX(x + offsetX - bullet.getWidth() / 2d);
        bullet.setY(y + offsetY - bullet.getHeight() / 2d);
        System.out.println(x + offsetX - bullet.getWidth() / 2d);
        return bullet;
    }
}

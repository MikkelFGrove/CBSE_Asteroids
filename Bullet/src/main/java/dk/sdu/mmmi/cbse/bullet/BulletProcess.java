package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.World;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;

public class BulletProcess implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity bullet : world.getEntities(Bullet.class)){
            double changeX = Math.sin(Math.toRadians(bullet.getRotation()));
            double changeY = Math.cos(Math.toRadians(bullet.getRotation()));
            double speed = 2;
            bullet.setX(bullet.getX() + changeX * speed);
            bullet.setY(bullet.getY() + changeY * speed);

            if (world.isCoordOutsidePlayArea(bullet.getX(), bullet.getY(), gameData)){
                world.removeEntity(bullet);
            }
        }
    }
}

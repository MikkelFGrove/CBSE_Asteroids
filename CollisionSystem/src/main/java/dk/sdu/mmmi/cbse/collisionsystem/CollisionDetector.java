package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.player.Player;
import dk.sdu.mmmi.cbse.common.spaceship.Spaceship;

public class CollisionDetector implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity e : world.getEntities()) {
            for (Entity e2 : world.getEntities()) {



                if (e.getEntityType().equals(e2.getEntityType())) {
                    continue;
                }

                double xDistance = e.getX() - e2.getX();
                double yDistance = e.getY() - e2.getY();
                double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);

                if (distance < (e.getSize() + e2.getSize())) {
                    if (e.getEntityType().equals(EEntityTypes.PLAYER) && e2.getEntityType().equals(EEntityTypes.BULLET)) {
                        ((Player) e).decreaseHealth(((Bullet)e2).getDamage());
                        world.removeEntity(e2);
                    }
                    if (e.getEntityType().equals(EEntityTypes.SPACESHIP) && e2.getEntityType().equals(EEntityTypes.BULLET)) {
                        ((Spaceship) e).decreaseHealth(((Bullet)e2).getDamage());
                        world.removeEntity(e2);
                        System.out.println("Spaceship decreased");
                    }
                }
            }
        }
    }
}

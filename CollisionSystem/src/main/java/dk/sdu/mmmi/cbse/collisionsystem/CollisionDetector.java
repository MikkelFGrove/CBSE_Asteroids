package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.player.Player;
import dk.sdu.mmmi.cbse.common.spaceship.Spaceship;



public class CollisionDetector implements IPostEntityProcessorService {
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
                        continue;
                    }
                    if (e.getEntityType().equals(EEntityTypes.PLAYER) && e2.getEntityType().equals(EEntityTypes.ASTEROID)) {
                        ((Player) e).decreaseHealth(((Asteroid)e2).getDamage());
                        ((Asteroid) e2).decreaseHealth(((Player)e).getDamage());
                        ((Asteroid) e2).setDamagedBy(e);
                    }
                    if (e.getEntityType().equals(EEntityTypes.SPACESHIP) && e2.getEntityType().equals(EEntityTypes.BULLET)) {
                        ((Spaceship) e).decreaseHealth(((Bullet)e2).getDamage());
                        world.removeEntity(e2);
                    }
                    if (e.getEntityType().equals(EEntityTypes.ASTEROID) && e2.getEntityType().equals(EEntityTypes.BULLET)) {
                        ((Asteroid)e).decreaseHealth(((Bullet)e2).getDamage());
                        ((Asteroid) e).setDamagedBy(((Bullet) e2).getOwner());
                        world.removeEntity(e2);
                    }

                }
            }
        }
    }
}

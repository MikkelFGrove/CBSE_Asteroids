package dk.sdu.mmmi.cbse.spaceship;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.World;
import dk.sdu.mmmi.cbse.common.spaceship.Spaceship;

import java.util.Random;

public class SpaceshipProcess implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        Random rand = new Random();
        double moveSpeed = 0.6;
        for (Entity e : world.getEntities(Spaceship.class)) {
            if (e instanceof Spaceship spaceship) {
                if(((Spaceship) e).getHealth() <= 0) {
                    world.removeEntity(spaceship);
                }
                if (System.currentTimeMillis() - spaceship.getTimeSinceMoved() > 5000) {
                    if (rand.nextInt(100) == 0) {
                        float randomRotation = rand.nextFloat() * 360f;
                        spaceship.setRotation(randomRotation);
                        spaceship.setTimeSinceMoved(System.currentTimeMillis());
                    }
                }

                if (rand.nextInt(50) == 0){
                    spaceship.getIweapon().trigger(spaceship.getX(), spaceship.getY(), spaceship.getRotation(), gameData, world);
                }

                double changeX = Math.sin(Math.toRadians(e.getRotation())) * moveSpeed;
                double changeY = Math.cos(Math.toRadians(e.getRotation())) * moveSpeed;

                if (!world.isCoordOutsidePlayArea(e.getX() + changeX + 22, e.getY(), gameData) && !world.isCoordOutsidePlayArea(e.getX() + changeX, e.getY(), gameData)) {
                    e.setX(e.getX() + changeX);
                }

                if (!world.isCoordOutsidePlayArea(e.getX(), e.getY() + changeY + 22, gameData) && !world.isCoordOutsidePlayArea(e.getX(), e.getY() + changeY, gameData)) {
                    e.setY(e.getY() + changeY);
                }
                break;
            }
        }
    }
}

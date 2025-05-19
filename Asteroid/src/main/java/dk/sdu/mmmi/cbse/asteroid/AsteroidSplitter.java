package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroid.EAsteroidStage;

import java.util.Random;

public class AsteroidSplitter implements IPostEntityProcessorService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity e : world.getEntities(Asteroid.class)) {
            if (e instanceof Asteroid asteroid) {
                double health = asteroid.getHealth();
                EAsteroidStage stage = asteroid.getAsteroidStage();

                if ((stage == EAsteroidStage.XL && health < 81) ||
                        (stage == EAsteroidStage.L  && health < 61) ||
                        (stage == EAsteroidStage.M  && health < 41) ||
                        (stage == EAsteroidStage.S  && health < 21)) {

                    spawnSplitAsteroids(e.getX(), e.getY(), health, world);
                    world.removeEntity(asteroid);
                }
            }
        }
    }

    private void spawnSplitAsteroids(double originX, double originY, double health, World world) {
        AsteroidPlugin asteroidPlugin = new AsteroidPlugin();
        Random rand = new Random();

        for (int i = 0; i < 2; i++) {
            double rotation = rand.nextFloat() * 360f;
            double spriteRotation = rand.nextFloat() * 360f;
            double radians = Math.toRadians(rotation);
            double offsetX = Math.sin(radians) * 40f;
            double offsetY = Math.cos(radians) * 40f;

            asteroidPlugin.createAsteroid(originX + offsetX, originY + offsetY, rotation, spriteRotation, health, world
            );
        }
    }
}

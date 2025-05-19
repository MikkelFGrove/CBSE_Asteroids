package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;

import java.util.Random;

public class AsteroidProcess implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        double moveSpeed = 0.4;
        for (Entity e : world.getEntities(Asteroid.class)) {
            if (e instanceof Asteroid asteroid) {
                if (asteroid.getHealth() <= 0) {
                    if (((Asteroid) e).getDamagedBy() != null && ((Asteroid) e).getDamagedBy().getEntityType() == EEntityTypes.PLAYER) {
                        gameData.incrementAsteroidsKilled(1);
                    }
                    world.removeEntity(asteroid);
                }
                double changeX = Math.sin(Math.toRadians(asteroid.getRotation())) * moveSpeed;
                double changeY = Math.cos(Math.toRadians(asteroid.getRotation())) * moveSpeed;
                asteroid.setX(e.getX() + changeX);
                asteroid.setY(e.getY() + changeY);

                double left = asteroid.getX() - asteroid.getWidth() / 2.0;
                double right = asteroid.getX() + asteroid.getWidth() / 2.0;
                double top = asteroid.getY() - asteroid.getHeight() / 2.0;
                double bottom = asteroid.getY() + asteroid.getHeight() / 2.0;

                if (right < 0 || left > gameData.getWindowWidth() || bottom < 0 || top > gameData.getWindowHeight()) {
                    world.removeEntity(asteroid);
                }



                if (world.getEntities(Asteroid.class).size() < 15) {
                    Random rand = new Random();
                    double w = gameData.getWindowWidth(), h = gameData.getWindowHeight();
                    double cx = w / 2.0, cy = h / 2.0;
                    double x = 0, y = 0;
                    int edge = rand.nextInt(4);
                    if (edge == 0) { x = - 0; y = rand.nextDouble() * h; }
                    else if (edge == 1) { x = w + 0; y = rand.nextDouble() * h; }
                    else if (edge == 2) { x = rand.nextDouble() * w; y = -0; }
                    else { x = rand.nextDouble() * w; y = h + 0; }
                    double rotation = Math.toDegrees(Math.atan2(cx - x, cy - y)) + rand.nextDouble() * 100 - 50;
                    double health = rand.nextInt(100) + 1;
                    AsteroidPlugin asteroidPlugin = new AsteroidPlugin();
                    asteroidPlugin.createAsteroid(x, y, rotation, rand.nextDouble() * 360f, health, world);
                }
            }
        }
    }


}

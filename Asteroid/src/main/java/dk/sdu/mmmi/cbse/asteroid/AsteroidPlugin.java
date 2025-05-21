package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.EEntityTypes;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.IGamePluginService;
import dk.sdu.mmmi.cbse.common.World;
import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroid.EAsteroidStage;
import javafx.scene.image.Image;

import java.util.Objects;
import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {
    Image asteroidSprite = null;

    @Override
    public void start(GameData gameData, World world) {
        Random rand = new Random();

        asteroidSprite = new Image(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("asteroid.png"))
        );

        for (int i = 0; i <= 20; i++) {

            float entityRotation = rand.nextFloat() * 360f;
            float spriteRotation = rand.nextFloat() * 360f;

            double playerX = world.getPlayerXPos();
            double playerY = world.getPlayerYPos();

            double screenWidth = gameData.getWindowWidth();
            double screenHeight = gameData.getWindowHeight();
            double minDistance = 50.0;
            double x, y;

            do {
                x = rand.nextDouble() * screenWidth;
                y = rand.nextDouble() * screenHeight;
            } while (Math.hypot(x - playerX, y - playerY) < minDistance);
            double health = rand.nextInt(100) + 1;

            createAsteroid(x, y, entityRotation, spriteRotation, health, world);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
    }

    public void createAsteroid(double x, double y, double entityRotation, double spriteRotation, double health, World world) {
        Random rand = new Random();

        Asteroid asteroid = new Asteroid();
        asteroid.setEntityType(EEntityTypes.ASTEROID);

        asteroid.setRotation(entityRotation);
        asteroid.setSpriteRotation(spriteRotation);
        asteroid.setHealth(health);
        double minScale = 0.03f;
        double maxScale = 0.09f;
        double size = minScale + ((health - 1) / 99.0f) * (maxScale - minScale);

        if (asteroidSprite != null) {
            double scaledWidth = asteroidSprite.getWidth() * size;
            double scaledHeight = asteroidSprite.getHeight() * size;
            Image newAsteroidSprite = new Image("asteroid.png", scaledWidth, scaledHeight, true, false);
            asteroid.setSprite(newAsteroidSprite);
        } else {
            asteroid.setSprite("asteroid.png", size);
        }

        asteroid.setSize(size*400);

        if (health >= 81 && health <= 100) {
            asteroid.setAsteroidStage(EAsteroidStage.XL);
        } else if (health >= 61 && health <= 80) {
            asteroid.setAsteroidStage(EAsteroidStage.L);
        } else if (health >= 41 && health <= 60) {
            asteroid.setAsteroidStage(EAsteroidStage.M);
        } else if (health >= 21 && health <= 40) {
            asteroid.setAsteroidStage(EAsteroidStage.S);
        } else if (health <= 20) {
            asteroid.setAsteroidStage(EAsteroidStage.XS);
        }
        asteroid.setDamage(10);
        asteroid.setX(x);
        asteroid.setY(y);


        world.addEntity(asteroid);
    }
}


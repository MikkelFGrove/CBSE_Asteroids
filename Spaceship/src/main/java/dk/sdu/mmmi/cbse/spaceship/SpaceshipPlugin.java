package dk.sdu.mmmi.cbse.spaceship;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.spaceship.ISpaceship;
import dk.sdu.mmmi.cbse.common.spaceship.Spaceship;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class SpaceshipPlugin implements IGamePluginService, ISpaceship {
    @Override
    public void start(GameData gameData, World world) {
        System.out.println("Spaceship Plugin started");
        world.addEntity(createSpaceship(gameData, world));
    }

    @Override
    public void stop(GameData gameData, World world) {

    }

    @Override
    public Entity createSpaceship(GameData gameData, World world) {
        Spaceship spaceship = new Spaceship();
        spaceship.setEntityType(EEntityTypes.SPACESHIP);
        spaceship.setRotation(0);
        spaceship.setSprite("spaceship.png", 0.1);

        double playerX = world.getPlayerXPos();
        double playerY = world.getPlayerYPos();

        double screenWidth = gameData.getWindowWidth();
        double screenHeight = gameData.getWindowHeight();

        double minDistance = 100.0;
        Random rnd = new Random();
        double x, y;

        do {
            x = rnd.nextDouble() * screenWidth;
            y = rnd.nextDouble() * screenHeight;
        } while (Math.hypot(x - playerX, y - playerY) < minDistance);

        spaceship.setX(x);
        spaceship.setY(y);

        System.out.println(x + " " + y);
        getWeaponSPI().stream().findFirst().ifPresent(spaceship::setIweapon);

        return spaceship;
    }

    private Collection<? extends IWeaponSPI> getWeaponSPI() {
        return ServiceLoader.load(IWeaponSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}

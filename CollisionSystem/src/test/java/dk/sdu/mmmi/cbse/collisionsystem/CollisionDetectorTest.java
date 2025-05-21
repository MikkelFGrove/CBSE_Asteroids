package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.bullet.BulletPlugin;
import dk.sdu.mmmi.cbse.common.EEntityTypes;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.World;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.player.Player;
import dk.sdu.mmmi.cbse.common.spaceship.Spaceship;
import dk.sdu.mmmi.cbse.player.PlayerPlugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollisionDetectorTest {
    private static GameData gameData;
    private static World world;
    private static CollisionDetector collisionDetector;

    @BeforeAll
    public static void setup() {
        gameData = new GameData();
        world = new World();
        collisionDetector = new CollisionDetector();
    }

    @Test
    public void collisionDecreasesHealth() {
        BulletPlugin bulletPlugin = new BulletPlugin();
        Player player = new Player();
        player.setEntityType(EEntityTypes.PLAYER);
        player.setX(0);
        player.setY(0);
        player.setHealth(6);

        Bullet bullet = bulletPlugin.createBullet(new Spaceship(), player.getX(), player.getY(), 0, 5);

        bullet.setX(player.getX());
        bullet.setY(player.getY());
        world.addEntity(bullet);
        world.addEntity(player);

        assertTrue(world.getEntities().contains(player));
        assertTrue(world.getEntities().contains(bullet));

        collisionDetector.process(gameData, world);

        assertEquals(1,player.getHealth());
    }
}

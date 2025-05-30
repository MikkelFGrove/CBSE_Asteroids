package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.Entity;

public interface IBulletSPI {
    /**
     * Defines a contract for creating bullets in the game.
     * <p>
     * This method is called whenever a bullet needs to be spawned into the game world.
     *
     * @param e the entity that is firing the bullet
     * @param x the x-coordinate where the bullet should spawn
     * @param y the y-coordinate where the bullet should spawn
     * @param angle the direction in which the bullet should be fired
     * @param damage the amount of damage the bullet will deal upon impact
     *
     * @return a {@code Bullet} instance
     *
     * @precondition
     * <p>- The game is currently running.
     * <p>- None of the parameters are null.
     * <p>- The {@code e} parameter must represent a valid entity with a defined entity type.
     *
     * @postcondition
     * <p>- A {@code Bullet} instance is returned, initialized with the given parameters.
     */
    Bullet createBullet(Entity e, double x, double y, double angle, double damage);
}

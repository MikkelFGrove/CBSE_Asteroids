package dk.sdu.mmmi.cbse.common.weapon;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.World;

public interface IWeaponSPI {
    /**
     * Defines a contract for shooting a weapon
     * <p>
     * Method is called whenever something need to shoot from a weapon
     *
     * @param e the entity that is shooting
     * @param x the x-coordinate where gun is being shot from
     * @param y the y-coordinate where gun is being shot from
     * @param angle the direction in which the bullet should be fired
     *
     *
     * @precondition
     * <p>- The game is currently running
     * <p>- None of the parameters are null
     *
     * @postcondition
     * <p>- The trigger of the gun is being held down
     */
    void trigger(Entity e, double x, double y, double angle, World world);
}

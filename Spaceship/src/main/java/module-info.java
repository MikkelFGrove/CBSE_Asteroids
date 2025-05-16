import dk.sdu.mmmi.cbse.common.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.IGamePluginService;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;
import dk.sdu.mmmi.cbse.spaceship.SpaceshipPlugin;
import dk.sdu.mmmi.cbse.spaceship.SpaceshipProcess;

module Spaceship {
    requires CommonSpaceship;
    requires CommonWeapon;
    requires Common;

    provides IGamePluginService with SpaceshipPlugin;
    provides IEntityProcessingService with SpaceshipProcess;

    uses IWeaponSPI;
}
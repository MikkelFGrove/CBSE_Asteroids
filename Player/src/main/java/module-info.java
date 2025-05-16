import dk.sdu.mmmi.cbse.common.IGamePluginService;
import dk.sdu.mmmi.cbse.common.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;
import dk.sdu.mmmi.cbse.player.*;

module Player {
    requires CommonPlayer;
    requires CommonWeapon;
    requires Common;

    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with PlayerControlSystem;

    uses IWeaponSPI;
}
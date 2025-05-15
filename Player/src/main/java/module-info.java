import dk.sdu.mmmi.cbse.common.IGamePluginService;
import dk.sdu.mmmi.cbse.common.IEntityProcessingService;
import dk.sdu.mmmi.cbse.player.*;

module Player {
    requires Common;
    requires CommonPlayer;

    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with PlayerControlSystem;
}
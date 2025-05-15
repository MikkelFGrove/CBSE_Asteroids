import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;

module Core {
    requires javafx.graphics;
    requires Common;
    requires CommonPlayer;
    requires CommonInputSystem;
    opens dk.sdu.mmmi.cbse.main to javafx.graphics;

    uses dk.sdu.mmmi.cbse.common.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.IGamePluginService;
    uses IInputSPI;
}
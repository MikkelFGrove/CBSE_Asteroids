import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;

module Core {
    requires CommonPlayer;
    requires CommonInputSystem;
    requires CommonAsteroid;
    requires Common;
    requires javafx.controls;
    opens dk.sdu.mmmi.cbse.main to javafx.graphics;

    uses dk.sdu.mmmi.cbse.common.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.IGamePluginService;
    uses IInputSPI;
    uses dk.sdu.mmmi.cbse.common.IPostEntityProcessorService;
}
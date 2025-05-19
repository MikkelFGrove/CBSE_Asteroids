import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;

module Core {
    requires CommonPlayer;
    requires CommonInputSystem;
    requires CommonAsteroid;
    requires Common;
    requires javafx.controls;
    requires spring.context;
    requires javafx.graphics;
    requires spring.core;
    requires spring.beans;

    exports dk.sdu.mmmi.cbse.main;
    opens dk.sdu.mmmi.cbse.main to javafx.graphics,
            spring.context,
            spring.beans,
            spring.core;

    uses dk.sdu.mmmi.cbse.common.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.IGamePluginService;
    uses IInputSPI;
    uses dk.sdu.mmmi.cbse.common.IPostEntityProcessorService;
}
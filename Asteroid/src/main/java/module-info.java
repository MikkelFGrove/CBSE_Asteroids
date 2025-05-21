import dk.sdu.mmmi.cbse.asteroid.AsteroidPlugin;
import dk.sdu.mmmi.cbse.asteroid.AsteroidProcess;
import dk.sdu.mmmi.cbse.asteroid.AsteroidSplitter;
import dk.sdu.mmmi.cbse.common.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.IGamePluginService;
import dk.sdu.mmmi.cbse.common.IPostEntityProcessorService;

module Asteroid {
    requires CommonAsteroid;
    requires Common;
    requires javafx.graphics;

    provides IGamePluginService with AsteroidPlugin;
    provides IEntityProcessingService with AsteroidProcess;
    provides IPostEntityProcessorService with AsteroidSplitter;
}
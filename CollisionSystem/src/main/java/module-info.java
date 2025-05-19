import dk.sdu.mmmi.cbse.common.IPostEntityProcessorService;

module CollisionSystem {
    requires CommonBullet;
    requires CommonPlayer;
    requires CommonSpaceship;
    requires CommonAsteroid;
    requires Common;

    provides IPostEntityProcessorService with dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
}
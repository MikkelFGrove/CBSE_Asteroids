import dk.sdu.mmmi.cbse.common.IEntityProcessingService;

module CollisionSystem {
    requires CommonBullet;
    requires CommonPlayer;
    requires CommonSpaceship;
    requires Common;

    provides IEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;
}
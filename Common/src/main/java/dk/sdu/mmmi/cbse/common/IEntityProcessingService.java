package dk.sdu.mmmi.cbse.common;

public interface IEntityProcessingService {
    /**
     * Defines how entities are processed throughout the game and all their internal logic that controls the entity.
     * <p>
     * <p>This method is invoked once per frame before post-processing or rendering.
     *
     * @param gameData Includes data about the game that may be used by the processor
     * @param world Stores all the entities that are in the game
     *
     * @precondition
     * <p>- The game is running.
     * <p>- The {@code gameData} parameter must not be null and should contain current game state info.
     * <p>- The {@code world} parameter must not be null.
     * <p>- Entities to be processed must be started via its plugin-service.
     *
     * @postcondition
     * <p>- The state of the entity must have been updated according to the most recent changes to the game
     */
    void process(GameData gameData, World world);
}

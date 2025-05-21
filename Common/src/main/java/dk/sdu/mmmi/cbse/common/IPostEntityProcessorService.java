package dk.sdu.mmmi.cbse.common;

public interface IPostEntityProcessorService {
    /**
     * Defines all services which must be updated after each entity has been processed.
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
     * <p>- All which use a processing service must have already been processed
     *
     * @postcondition
     * <p>- The game is updated from the given states of GameData and World.
     */
    void process(GameData gameData, World world);
}

package dk.sdu.mmmi.cbse.common;

public interface IGamePluginService {
    /**
     * Starts the plugin service which prepares the plugin for the game.
     * <p>
     * <p>This method is called at the start of the game
     *
     * @param gameData Includes data about the game
     * @param world Stores all the entities that are in the game and has methods for adding and removing them
     *
     * @precondition
     * <p>- The plugin must have not been started or have been stopped before calling.
     * <p>- The {@code gameData} parameter must not be null and should contain current game state info.
     * <p>- The {@code world} parameter must not be null.
     *
     * @postcondition
     * <p>- The plugin must be started and ready to be used for the main game loop.
     */
    void start (GameData gameData, World world);

    /**
     * Stops the plugin service.
     * <p>
     * <p>This method is called when the game stops
     *
     * @param gameData Includes data about the game
     * @param world Stores all the entities that are in the game and has methods for adding and removing them
     *
     * @precondition
     * <p>- The game is running.
     * <p>- The plugin must already have been started.
     * <p>- The {@code gameData} parameter must not be null and should contain current game state info.
     * <p>- The {@code world} parameter must not be null.
     *
     * @postcondition
     * <p>- The plugin must be stopped and ready.
     */
    void stop (GameData gameData, World world);
}

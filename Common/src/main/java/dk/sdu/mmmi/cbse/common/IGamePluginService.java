package dk.sdu.mmmi.cbse.common;

public interface IGamePluginService {
    void start (GameData gameData, World world);
    void stop (GameData gameData, World world);
}

package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.player.Player;

public class PlayerPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        Entity player = new Player();
        player.setEntityType(EEntityTypes.PLAYER);
        player.setSprite("player.png", 0.07);
        player.setSpriteScale(1);
        player.setX(gameData.getWindowWidth()/2d);
        player.setY(gameData.getWindowHeight()/2d);
        world.addEntity(player);
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}

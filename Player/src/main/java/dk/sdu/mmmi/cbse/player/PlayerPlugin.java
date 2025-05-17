package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.player.Player;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class PlayerPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        Player player = new Player();
        player.setEntityType(EEntityTypes.PLAYER);
        player.setRotation(180);
        player.setSprite("player.png", 0.07);
        player.setSpriteScale(1);
        player.setSize(6);
        player.setX(gameData.getWindowWidth()/2d);
        player.setY(gameData.getWindowHeight()/2d);
        getWeaponSPI().stream().findFirst().ifPresent(player::setIweapon);
        player.setHealth(100);
        world.addEntity(player);
    }

    @Override
    public void stop(GameData gameData, World world) {

    }

    private Collection<? extends IWeaponSPI> getWeaponSPI() {
        return ServiceLoader.load(IWeaponSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}

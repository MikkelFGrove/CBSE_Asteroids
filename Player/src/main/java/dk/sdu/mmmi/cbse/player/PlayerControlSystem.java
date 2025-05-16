package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.player.Player;

public class PlayerControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity player : world.getEntities(Player.class)) {
            double moveSpeed = 1.1;
            EInputTypes[] directions = { EInputTypes.UP, EInputTypes.LEFT, EInputTypes.RIGHT, EInputTypes.SHOOT };
            for (EInputTypes input : directions) {
                if (gameData.getInputs().isDown(input)) {
                    switch (input) {
                        case UP:
                            double changeX = Math.sin(Math.toRadians(player.getRotation())) * moveSpeed;
                            double changeY = Math.cos(Math.toRadians(player.getRotation())) * moveSpeed;

                            if (!world.isCoordOutsidePlayArea(player.getX() + changeX + 22, player.getY(), gameData) && !world.isCoordOutsidePlayArea(player.getX() + changeX, player.getY(), gameData)) {
                                player.setX(player.getX() + changeX);
                            }

                            if (!world.isCoordOutsidePlayArea(player.getX(), player.getY() + changeY + 22, gameData) && !world.isCoordOutsidePlayArea(player.getX(), player.getY() + changeY, gameData)) {
                                player.setY(player.getY() + changeY);
                            }
                            break;
                        case LEFT:
                            player.setRotation(+ 1.3);
                            break;
                        case RIGHT:
                            player.setRotation( -1.3);
                            break;
                        case SHOOT:
                            Player playerEntity = (Player) player;
                            playerEntity.getIweapon().trigger(player.getX() + player.getWidth()/2d, player.getY()+player.getHeight()/2d, player.getRotation(), gameData, world);

                    }
                    world.setPlayerXPos(player.getX());
                    world.setPlayerYPos(player.getY());
                }
            }

        }
    }
}

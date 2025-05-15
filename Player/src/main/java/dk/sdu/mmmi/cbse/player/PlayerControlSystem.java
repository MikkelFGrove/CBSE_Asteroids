package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.player.Player;

public class PlayerControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity player : world.getEntities(Player.class)) {
            double moveSpeed = 0.6;
            EInputTypes[] directions = { EInputTypes.UP, EInputTypes.LEFT, EInputTypes.RIGHT };
            for (EInputTypes input : directions) {
                if (gameData.getInputs().isDown(input)) {
                    switch (input) {
                        case UP:
                            double changeX = Math.sin(Math.toRadians(player.getRotation())) * moveSpeed;
                            double changeY = Math.cos(Math.toRadians(player.getRotation())) * moveSpeed;
                            player.setX(player.getX() - changeX);
                            player.setY(player.getY() - changeY);
                            System.out.println("UP");
                            break;
                        case LEFT:
                            System.out.println("LEFT");
                            player.setRotation(+ 1);
                            break;
                        case RIGHT:
                            System.out.println("RIGHT");
                            player.setRotation( -1);
                            break;
                    }
                }
            }

        }
    }
}

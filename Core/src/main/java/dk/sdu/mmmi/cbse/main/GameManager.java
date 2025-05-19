package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class GameManager {
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Pane game = new Pane();
    private final Canvas canvas = new Canvas(gameData.getWindowWidth(), gameData.getWindowHeight());
    private final GraphicsContext gc = canvas.getGraphicsContext2D();
    private final Label asteroidKillLabel = new Label("Asteroids killed: 0");

    @Autowired
    private Collection<IEntityProcessingService> entityProcessingServices;
    @Autowired
    private Collection<IPostEntityProcessorService> postEntityProcessorServices;
    @Autowired
    private Collection<IGamePluginService> gamePluginServices;
    @Autowired
    private Collection<IInputSPI> inputSPIs;

    public Scene initGameScene() {
        for (IGamePluginService plugin : gamePluginServices) {
            plugin.start(gameData, world);
        }

        gc.setImageSmoothing(true);
        game.getChildren().add(canvas);

        asteroidKillLabel.setTextFill(Color.BLACK);
        asteroidKillLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        asteroidKillLabel.setTranslateX(10);
        asteroidKillLabel.setTranslateY(10);
        game.getChildren().add(asteroidKillLabel);

        startGameLoop();

        Scene scene = new Scene(game, gameData.getWindowHeight(), gameData.getWindowWidth());
        for (IInputSPI iInputSPI : inputSPIs) {
            scene.addEventHandler(iInputSPI.getInputEvent(), iInputSPI.getInputHandler(gameData));
        }
        return scene;
    }

    private void startGameLoop() {
        final double targetFPS = 120;
        final double interval = 1000 / targetFPS;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(interval), event -> {
            gameData.getInputs().update();

            for (IEntityProcessingService processor : entityProcessingServices) {
                processor.process(gameData, world);
            }
            for (IPostEntityProcessorService postProcessor : postEntityProcessorServices) {
                postProcessor.process(gameData, world);
            }

            asteroidKillLabel.setText("Asteroids killed: " + gameData.getAsteroidsKilled());
            render();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Entity entity : world.getEntities()) {
            gc.save();
            gc.translate(entity.getX(), entity.getY());
            if (entity.getEntityType() == EEntityTypes.PLAYER) {
                gc.rotate(-entity.getRotation());
            } else if (entity.getEntityType() == EEntityTypes.ASTEROID) {
                gc.rotate(((Asteroid) entity).getSpriteRotation());
            }
            gc.drawImage(entity.getImage(), -entity.getWidth() / 2.0, -entity.getHeight() / 2.0);
            gc.restore();
        }
    }
}
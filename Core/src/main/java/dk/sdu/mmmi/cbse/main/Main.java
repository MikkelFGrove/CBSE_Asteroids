package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private final Pane game = new Pane();
    private final GameData gameData = new GameData();
    private final World world = new World();
    Canvas canvas = new Canvas(gameData.getWindowWidth(), gameData.getWindowHeight());
    GraphicsContext gc = canvas.getGraphicsContext2D();
    private final Label asteroidKillLabel = new Label("Asteroids killed: 0");

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(game, gameData.getWindowHeight(), gameData.getWindowWidth());
        for (IGamePluginService iGamePlugin : ModuleConfig.getPlugins()) {
            iGamePlugin.start(gameData, world);
        }

        for (IInputSPI iInputSPI : ModuleConfig.getInputSystem()) {
            scene.addEventHandler(iInputSPI.getInputEvent(), iInputSPI.getInputHandler(gameData));
        }

        gc.setImageSmoothing(true);
        game.getChildren().add(canvas);

        asteroidKillLabel.setTextFill(Color.BLACK);
        asteroidKillLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        asteroidKillLabel.setTranslateX(10);
        asteroidKillLabel.setTranslateY(10);
        game.getChildren().add(asteroidKillLabel);

        startGame();
        stage.setScene(scene);
        stage.setTitle("ASTEROIDS!!!");
        stage.show();
    }

    private void startGame() {
        final double targetFPS = 120;
        final double interval = 1000 / targetFPS;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(interval), event -> {
            gameData.getInputs().update();

            for (IEntityProcessingService processingService : ModuleConfig.getEntityProcessingServices()) {
                processingService.process(gameData, world);
            }
            for (IPostEntityProcessorService postProcessingService : ModuleConfig.getIPostEntityProcessorService()) {
                postProcessingService.process(gameData, world);
            }

            asteroidKillLabel.setText("Asteroids killed: " + gameData.getAsteroidsKilled());
            renderGraphics();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void renderGraphics() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Entity entity : world.getEntities()) {
            double circleDiameter = 2 * entity.getSize();

            gc.save();
            double centerX = entity.getX();
            double centerY = entity.getY();
            gc.translate(centerX, centerY);
            if (entity.getEntityType() == EEntityTypes.PLAYER) {
                gc.rotate(-entity.getRotation());
            } else if (entity.getEntityType() == EEntityTypes.ASTEROID) {
                gc.rotate(((Asteroid) entity).getSpriteRotation());
            }
            gc.drawImage(
                    entity.getImage(),
                    -entity.getWidth() / 2.0,
                    -entity.getHeight() / 2.0
            );
            gc.restore();
        }
    }
}
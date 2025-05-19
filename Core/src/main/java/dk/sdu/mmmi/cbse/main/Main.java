package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.Collection;
import java.util.List;


public class Main extends Application {
    private final Pane game = new Pane();
    private final GameData gameData = new GameData();
    private final World world = new World();
    Canvas canvas = new Canvas(gameData.getWindowWidth(), gameData.getWindowHeight());
    GraphicsContext gc = canvas.getGraphicsContext2D();
    private final Label asteroidKillLabel = new Label("Asteroids killed: 0");

    private Collection<IEntityProcessingService> entityProcessingServices;
    private Collection<IPostEntityProcessorService> postEntityProcessorServices;
    private Collection<IGamePluginService> gamePluginServices;



    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        GameManager gameManager = ctx.getBean(GameManager.class);
        Scene scene = gameManager.initGameScene();

        stage.setScene(scene);
        stage.setTitle("ASTEROIDS!!!");
        stage.show();
    }

    private void startGame() {
        final double targetFPS = 120;
        final double interval = 1000 / targetFPS;

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(interval), event -> {
            gameData.getInputs().update();

            for (IEntityProcessingService processingService : entityProcessingServices) {
                processingService.process(gameData, world);
            }
            for (IPostEntityProcessorService postProcessingService : postEntityProcessorServices) {
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
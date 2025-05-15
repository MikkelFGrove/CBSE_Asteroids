package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.*;
import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private final Pane game = new Pane();
    private final GameData gameData = new GameData();
    private final World world = new World();
    Canvas canvas = new Canvas(gameData.getWindowWidth(), gameData.getWindowHeight());
    GraphicsContext gc = canvas.getGraphicsContext2D();


    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(game, gameData.getWindowHeight(), gameData.getWindowWidth());
        for (IGamePluginService iGamePlugin : ModuleConfig.getPlugins()) {
            iGamePlugin.start(gameData, world);
        }

        for (IInputSPI iInputSPI : ModuleConfig.getInputSystem()){
            scene.addEventHandler(iInputSPI.getInputEvent(), iInputSPI.getInputHandler(gameData));
        }
        gc.setImageSmoothing(true);
        game.getChildren().add(canvas);


        startGame();
        stage.setScene(scene);
        stage.setTitle("ASTEROIDS!!!");
        stage.show();
    }

    private void startGame() {
        renderCycle();
    }

    private void renderCycle() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameData.getInputs().update();
                for (IEntityProcessingService processingService : ModuleConfig.getEntityProcessingServices()) {
                    processingService.process(gameData, world);
                }
                renderGraphics();
            }
        }.start();
    }

    private void renderGraphics() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Entity entity : world.getEntities()) {
            gc.save();

            // Move origin to the center of the entity

            double centerX = entity.getX() + entity.getWidth()/2d;
            double centerY = entity.getY() + entity.getHeight()/2d;
            gc.translate(centerX, centerY);

            // Rotate around the new origin (which is now the entity center)
            gc.rotate(-entity.getRotation());

            // Draw image centered on the new origin
            gc.drawImage(
                    entity.getImage(),
                    -entity.getWidth() / 2.0,
                    -entity.getHeight() / 2.0
            );

            gc.restore();
        }
    }
}
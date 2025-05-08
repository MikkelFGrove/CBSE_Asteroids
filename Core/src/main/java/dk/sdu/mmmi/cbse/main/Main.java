package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.GameData;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private final Pane game = new Pane();
    private final GameData gameData = new GameData();

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(game, gameData.getWindowHeight(), gameData.getWindowWidth());

        startGame();
        stage.setScene(scene);
        stage.setTitle("Ratpocalypse");
        stage.show();
    }

    private void startGame() {
        renderCycle();
    }

    private void renderCycle() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        }.start();
    }
}
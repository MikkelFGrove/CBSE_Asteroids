package dk.sdu.mmmi.cbse.main;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;




public class Main extends Application {
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
}
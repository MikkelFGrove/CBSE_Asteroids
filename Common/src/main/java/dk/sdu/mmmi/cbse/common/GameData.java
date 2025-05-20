package dk.sdu.mmmi.cbse.common;

import java.util.Collection;
import java.util.ServiceLoader;
import dk.sdu.mmmi.cbse.common.IScore;
import org.springframework.web.client.RestTemplate;

import static java.util.stream.Collectors.toList;

public class GameData {
    private final int windowHeight = 1200;
    private final int windowWidth = 1200;
    private int score = 0;
    private final GameInputs inputs = new GameInputs();
    private double mouseX, mouseY;
    RestTemplate restTemplate = new RestTemplate();


    public int getAsteroidsKilled() {
        return asteroidsKilled;
    }

    private int asteroidsKilled = 0;

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public GameInputs getInputs() {
        return inputs;
    }

    public void setMousePosition(double mouseX, double sceneY) {
        this.mouseX = mouseX;
        this.mouseY = sceneY;
    }

    public void incrementAsteroidsKilled(int i) {
        asteroidsKilled += i;
        try {
            String response = restTemplate.getForObject(
                    "http://localhost:8080/score?score=" + asteroidsKilled,
                    String.class
            );
            System.out.println("Score: " + Integer.parseInt(response));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("FAILED" + e.getMessage());
        }
    }
}

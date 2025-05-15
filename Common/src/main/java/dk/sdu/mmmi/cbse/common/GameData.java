package dk.sdu.mmmi.cbse.common;

public class GameData {
    private final int windowHeight = 1200;
    private final int windowWidth = 1200;
    private int score = 0;
    private final GameInputs inputs = new GameInputs();
    private double mouseX, mouseY;

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

    public double getMouseX() {
        return mouseX;
    }
    public double getMouseY() {
        return mouseY;
    }


}

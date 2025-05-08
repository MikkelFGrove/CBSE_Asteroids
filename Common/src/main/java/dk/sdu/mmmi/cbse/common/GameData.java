package dk.sdu.mmmi.cbse.common;

public class GameData {
    private final int windowHeight = 1200;
    private final int windowWidth = 1200;
    private int score = 0;

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
}

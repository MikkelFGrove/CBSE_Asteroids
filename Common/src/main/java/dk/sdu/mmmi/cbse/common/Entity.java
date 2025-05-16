package dk.sdu.mmmi.cbse.common;

import javafx.scene.image.Image;

import java.util.Objects;
import java.util.UUID;

public class Entity {
    private final UUID uuid = UUID.randomUUID();
    private EEntityTypes entityType;
    private Image image;
    private double x, y;

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation += rotation;
    }

    private double rotation;



    private double spriteScale = 1;
    private int width, height;

    public String getUUID(){
        return uuid.toString();
    }

    public Object getEntityType() {
        return entityType;
    }

    public void setEntityType(EEntityTypes entityType) {
        this.entityType = entityType;
    }

    public void setSprite(String image, double spriteScale) {
        try {
            Image originalImage = new Image(
                    Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(image))
            );

            double scaledWidth = originalImage.getWidth() * spriteScale;
            double scaledHeight = originalImage.getHeight() * spriteScale;

            this.image = new Image(
                    Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(image)),
                    scaledWidth,
                    scaledHeight,
                    true,  // preserve ratio
                    false  // don't smooth if pixel-perfect style is needed
            );

            this.width = (int) this.image.getWidth();
            this.height = (int) this.image.getHeight();
            this.spriteScale = spriteScale;

        } catch (NullPointerException e) {
            System.out.println("Image not found: " + image);
        }
    }

    public Image getImage() {
        return image;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getSpriteScale() {
        return spriteScale;
    }

    public void setSpriteScale(double v) {
        this.spriteScale = v;
    }


}

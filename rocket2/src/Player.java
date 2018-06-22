import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {

    private BufferedImage image;
    private int x;
    private int y;
    private int velocityX;
    private int velocityY;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public Player(BufferedImage image, int x, int y, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public Player() {
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, 10, 10, null);
    }

}

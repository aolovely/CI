import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    private int x;
    private int y;
    private BufferedImage image;
    private int velocityX;
    private int velocityY;

    public Star(int x, int y, BufferedImage image, int velocityX, int velocityY) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public Star() {


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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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



    public void run() {
        this.x += this.velocityX;
        this.y += this.velocityY;

    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, 5, 5, null);
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;

    public Star(BufferedImage image, Vector2D position, Vector2D velocity) {
        this.image = image;
        this.position = new Vector2D(position.x, position.y);
        this.velocity = new Vector2D(velocity.x, velocity.y);
    }

    public Star() {

    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 5, 5, null);
    }
}

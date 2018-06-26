import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet {

    public  Vector2D position;
    public Vector2D velocity;
    BufferedImage image;



    public Bullet(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        try {
            this.image = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bullet(Vector2D position, Vector2D velocity) {
        this.position = new Vector2D(position.x, position.y);
        this.velocity = new Vector2D(velocity.x, velocity.y);
        try {
            this.image = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bullet(BufferedImage image, Vector2D position, Vector2D velocity){
        this.image = image;
        this.position = new Vector2D(position.x, position.y);
        this.velocity = new Vector2D(velocity.x, velocity.y);
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, 6,6, null);
    }

    public void render(Graphics graphics, int width, int height){
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, width, height, null);

    }

    public void run(){
        this.position.addUp(this.velocity);
        // this.position.set(this.position.x +4, this.position.y + 4);

    }
}

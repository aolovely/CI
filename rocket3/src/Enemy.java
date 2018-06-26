import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Enemy {

    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;
    private int countBullet = 0;

    List<Bullet> bullets = new ArrayList<>();

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }

    public Enemy(BufferedImage image, Vector2D position) {
        this.image = image;
        this.position = new Vector2D(position.x, position.y);
        this.velocity = new Vector2D();
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.creatBullets();
        this.bullets.forEach(bullet -> bullet.run());

    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 30, 30, null);
    }

    public Vector2D setupVelocity(Vector2D vector2D) {
        Vector2D velocity = vector2D
                .subtract(this.position)
                .normalize()
                .multiply(1.5f);
        this.velocity.set(velocity);
        return this.velocity;
    }

    public void creatBullets() {
        if (countBullet == 30) {
            try {
                BufferedImage bufferedImage = ImageIO.read(new File("resources/images/circle.png"));
                Bullet bullet = new Bullet(bufferedImage, this.position, this.velocity.multiplyBy(2f));
                this.bullets.add(bullet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            countBullet = 0;
        } else {
            countBullet += 1;
        }
    }

    public void renderBullet(Graphics graphics) {
        this.bullets.forEach(bullet -> bullet.render(graphics, 12, 12));
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends GameObject {

    public Vector2D velocity;
    private Attack attack;

    public Enemy(Attack attack) {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.attack = attack;
    }

    @Override
    public void run() {
        this.attack.run(this);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        attack.render(graphics);
    }
}

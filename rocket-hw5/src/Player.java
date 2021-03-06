import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    public Vector2D velocity;
    public double angle = 0.0;
    public Attack attack;
    private Random random = new Random();

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.velocity = new Vector2D(3.5f, 0);
        this.attack = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.attack.run(this);
        this.backtoScreen();
    }

    private void backtoScreen() {
        if (this.position.x < 0) this.position.set(1024, this.random.nextInt(600));

        if (this.position.x > 1024) this.position.set(0, this.random.nextInt(600));

        if (this.position.y < 0) this.position.set(this.random.nextInt(1024), 600);

        if (this.position.y > 600) this.position.set(this.random.nextInt(1024), 0);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
//        ((PlayerShoot) this.playerAttack)
//                .bulletPlayers
//                .forEach(bulletPlayer -> bulletPlayer.render(graphics));
        ((PlayerShoot)this.attack).render(graphics);
    }
}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    int countStar = 0;
    int countEnemy = 0;

    List<Star> stars;
    List<Enemy> enemies;

    Background background;
    private Random random = new Random();

    public Player player = new Player();
    public Enemy enemy = new Enemy();

    public EnemyRadiate enemyRadiate = new EnemyRadiate();

    public GameCanvas() {
        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();
        this.stars = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.setupPlayer();
        this.setupEnemy();
        this.setupEnemyRadiate();
    }

    private void setupPlayer() {
        this.player.position.set(100, 200);
    }

    private void setupEnemy() {
        this.enemy.position.set(600, 400);
        this.enemy.image = this.loadImage("resources/images/circle.png");
    }

    private void setupEnemyRadiate() {
        this.enemyRadiate.position.set(500, 400);
        this.enemyRadiate.image = this.loadImage("resources/images/Blue-Star-1.png");
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.enemy.render(this.graphics);
        this.enemy.renderBullet(graphics);

        this.enemyRadiate.render(graphics);
        this.enemyRadiate.renderBullet(graphics);

        this.player.renderBullet(this.graphics);
        this.enemies.forEach(enemy1 -> enemy1.render(graphics));

        this.enemies.forEach(enemy1 -> enemy1.renderBullet(graphics));

        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());

        this.runEnemy();
        this.player.run();

        this.runEnemyRadiate();

        this.createEnemys();
        this.enemies.forEach(enemy1 -> enemy1.setupVelocity(this.player.position));
        this.enemies.forEach(enemy1 -> enemy1.run());

    }

    private void createStar() {
        if (this.countStar == 20) {
            Star star = new Star(this.loadImage("resources/images/star.png"),
                    new Vector2D(1024, this.random.nextInt(600)),
                    new Vector2D(-this.random.nextInt(4) + 1, 0)
            );
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void createEnemys() {
        if (countEnemy == 120 && enemies.size() < 3) {
            Enemy enemy = new Enemy(
                    this.loadImage("resources/images/Love-Heart-15.png"),
                    new Vector2D(random.nextInt(1024), random.nextInt(600))
            );

            this.enemies.add(enemy);
            this.countEnemy = 0;

        } else {
            this.countEnemy += 1;
        }

    }

    private void runEnemy() {
        Vector2D velocity = this.player.position
                .subtract(this.enemy.position)
                .normalize()
                .multiply(1.5f);
        this.enemy.velocity.set(velocity);
        this.enemy.run();
    }

    private void runEnemyRadiate() {
        Vector2D velocity = this.player.position
                .subtract(this.enemyRadiate.position)
                .normalize()
                .multiply(1.5f);
        this.enemyRadiate.velocity.set(velocity);
        this.enemyRadiate.run();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
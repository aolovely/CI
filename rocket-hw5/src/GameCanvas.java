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


    CreatStar creatStar;

    Background background;

    public Player player = new Player();
    public Enemy enemyShoot = new Enemy(new EnemyShoot());
    public Enemy enemyRadiate = new Enemy(new EnemyRadiate());

    private Random random = new Random();


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
        this.creatStar = new CreatStar();
        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupPlayer() {
        this.player.position.set(100, 200);
    }

    private void setupEnemy() {
        this.enemyShoot.position.set(800, 400);
        this.enemyRadiate.position.set(500, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.creatStar.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.enemyShoot.render(this.graphics);
        this.enemyRadiate.render(this.graphics);
        this.repaint();
    }

    public void runAll() {
        this.creatStar.creat();
        this.creatStar.stars.forEach(star -> star.run());
        this.runEnemy();
        this.player.run();
    }


    private void runEnemy() {
        Vector2D velocity = this.player.position
                .subtract(this.enemyShoot.position)
                .normalize()
                .multiply(1.5f);
        this.enemyShoot.velocity.set(velocity);
        this.enemyShoot.run();

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

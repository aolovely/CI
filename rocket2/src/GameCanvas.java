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

    List<Star> stars;
    List<Enemy> enemies;
    private Random random = new Random();
    Player player;
    BufferedImage playerImage;

    BufferedImage backBuffered;
    Graphics graphics;
    int countStar;
    int countEnemy;

    PlayerPolygon playerPolygon;




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
        this.stars = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.player = new Player(this.loadImage("resources/images/circle.png"),
                this.random.nextInt(1024),
                this.random.nextInt(600),
                this.random.nextInt(5) + 1,
                0);
        this.playerPolygon = new PlayerPolygon();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(graphics);
        this.playerPolygon.render(graphics);
        this.repaint();
    }

    public void runAll() {
//        this.star.run();
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run());
        this.playerPolygon.run();


    }

    private void createStar() {
        if (countStar == 5) {
            Star star = new Star(
                    1024,
                    this.random.nextInt(600),
                    this.loadImage("resources/images/star.png"),
                    -this.random.nextInt(5) + 1, 0
            );
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }

    }

    private void createEnemy(){
        if (countEnemy == 30 && enemies.size() < 7){
            Enemy enemy = new Enemy(
                    this.loadImage("resources/images/circle.png"),
                    this.random.nextInt(1024),
                    this.random.nextInt(600),
                    this.random.nextInt(5) + 1,
                    this.random.nextInt(5) + 1
            );
            this.enemies.add(enemy);
            this.countEnemy = 0;
        }else{
            this.countEnemy += 1;
        }
    }

//    private void runEnemy() {
//        this.positionXEnemy += this.speedXEnemy;
//        this.positionYEnemy += this.speedYEnemy;
//
//        if (this.positionXEnemy < (0) || this.positionXEnemy > 1024 - 20)
//            this.speedXEnemy = -this.speedXEnemy;
//
//        if (this.positionYEnemy < (0) || this.positionYEnemy > 600 - 20)
//            this.speedYEnemy = -this.speedYEnemy;
//    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
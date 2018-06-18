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

    BufferedImage starImage;//tao bien de chua anh
    BufferedImage enemyImage;
    BufferedImage playerImage;

    List<Star> stars = new ArrayList<>();

    int countStar = 0;
    Random random = new Random();

    Enemy enemy;// khai bao enemy di chuyen cheo

    {
        try {
            enemy = new Enemy(this.enemyImage = ImageIO.read(new File("resources/images/circle.png")), random.nextInt(1024), random.nextInt(600), random.nextInt(3) + 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //BackBuffered
    BufferedImage backBuffered;
    Graphics graphics; // khai bao co ve

    public int positionXStart = 400;
    int positionYStart = 200;

    public int positionXEnemy = 400;
    int positionYEnemy = 200;


    public int positionXPlayer = 400;
    int positionYPlayer = 200;

    public GameCanvas() {
        this.setSize(1024, 600);

        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics(); //lay co ve tu backBuffered

        try {
            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.enemyImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.starImage = ImageIO.read(new File("resources/images/star.png"));//load buc anh

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);

    }

    //ve 1 so thu, tat ca moi thu ve o trong day
    @Override
    protected void paintComponent(Graphics g) {

//        g.setColor(Color.BLACK);//chon mau
//        g.fillRect(0,0,1024,600);
//
//        g.drawImage(this.starImage,this.positionXStart,this.positionYStart,5,5, null); //ve anh
//
//        g.drawImage(this.enemyImage, this.positionXEnemy, this.positionYEnemy, 10,10,null);
//
//        g.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 10,10,null);

        //ve backBuffered
        g.drawImage(this.backBuffered, 0, 0, null);

    }

    public void renderAll() {
        this.graphics.setColor(Color.BLACK);//chon mau
        this.graphics.fillRect(0, 0, 1024, 600);
        this.stars.forEach(star -> star.renderStar(graphics));
        this.enemy.render(graphics);
        this.graphics.drawImage(this.starImage, this.positionXStart, this.positionYStart, 5, 5, null); //ve anh

        this.graphics.drawImage(this.enemyImage, this.positionXEnemy, this.positionYEnemy, 10, 10, null);

        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 10, 10, null);

        this.repaint();
    }

    public void runAll() {
        creatStar();
        stars.forEach(start -> start.setPositionXStart(start.getPositionXStart() - start.getSpeed()));
        enemy.run();
    }

    public void creatStar() {
        if (countStar == 3) {
            Star star = new Star(starImage, random.nextInt(1024), random.nextInt(600), random.nextInt(4) + 1);
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }
}

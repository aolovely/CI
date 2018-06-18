import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {

    BufferedImage enemyImage;

    int positionXEnemy, positionYEnemy;
    int speed;

    public BufferedImage getEnemyImage() {
        return enemyImage;
    }

    public void setEnemyImage(BufferedImage enemyImage) {
        this.enemyImage = enemyImage;
    }

    public int getPositionXEnemy() {
        return positionXEnemy;
    }

    public void setPositionXEnemy(int positionXEnemy) {
        this.positionXEnemy = positionXEnemy;
    }

    public int getPositionYEnemy() {
        return positionYEnemy;
    }

    public void setPositionYEnemy(int positionYEnemy) {
        this.positionYEnemy = positionYEnemy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Enemy(){

    }

    public Enemy(BufferedImage enemyImage, int positionXEnemy, int positionYEnemy, int speed){

        this.enemyImage = enemyImage;
        this.positionXEnemy = positionXEnemy;
        this.positionYEnemy = positionYEnemy;
        this.speed = speed;

    }

    public void run(){

        if((this.positionXEnemy + this.speed) > 1024 || (this.positionXEnemy + this.speed) < 0)
            this.speed = -this.speed;
        this.positionXEnemy += this.speed;

        if((this.positionYEnemy + this.speed) > 600 || (this.positionYEnemy + this.speed) <0)
            this.speed = -this.speed;
        this.positionYEnemy += this.speed;
    }

    public void render(Graphics g){
        g.drawImage(this.enemyImage, this.positionXEnemy,this.positionYEnemy,10,10,null);
    }
}

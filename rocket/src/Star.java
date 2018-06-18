import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    BufferedImage starImage;
    int positionXStart, positionYStart;
    int speed;

    public BufferedImage getStarImage() {
        return starImage;
    }

    public void setStarImage(BufferedImage starImage) {
        this.starImage = starImage;
    }

    public int getPositionXStart() {
        return positionXStart;
    }

    public void setPositionXStart(int positionXStart) {
        this.positionXStart = positionXStart;
    }

    public int getPositionYStart() {
        return positionYStart;
    }

    public void setPositionYStart(int positionYStart) {
        this.positionYStart = positionYStart;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Star(){

    }

    public Star(BufferedImage starImage, int positionXStart, int positionYStart, int speed){
        this.starImage = starImage;
        this.positionXStart = positionXStart;
        this.positionYStart = positionYStart;
        this.speed = speed;
    }

    public void renderStar(Graphics g){
        g.drawImage(this.starImage,positionXStart,positionYStart,5,5,null);
    }
}

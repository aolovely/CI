import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerPolygon {

    private Vector position, velocticy;
    private Polygon polygon = new Polygon();
    private List<Vector> vectors = new ArrayList<>();//dung de chua 3 toa do ve tam giac
    private double radian = 0.0;
    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocticy() {
        return velocticy;
    }

    public void setVelocticy(Vector velocticy) {
        this.velocticy = velocticy;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public List<Vector> getVectors() {
        return vectors;
    }

    public void setVectors(List<Vector> vectors) {
        this.vectors = vectors;
    }

    public double getRadian() {
        return radian;
    }

    public void setRadian(double radian) {
        this.radian = radian;
    }

    public PlayerPolygon() {
        this.position = new Vector(20,30);
        this.velocticy = new Vector(4,0);
        this.vectors.add(new Vector(this.position.getX() - 10, this.position.getY() - 10));
        this.vectors.add(new  Vector(this.position.getX() - 10, this.position.getY() + 10));
        this.vectors.add(new Vector(this.position.getX(), this.position.getY()));
    }
        public void run(){

        Vector turning = this.velocticy.turning(radian);
        this.velocticy.setX(turning.getX());
        this.velocticy.setY(turning.getY());
        this.position.add(this.velocticy);
        this.radian = 0.0;
        this.updateVectors();

        if(this.position.getX() > 1024)
            this.position.setX(0);
        if(this.position.getX() < 0)
            this.position.setX(1024);
        if(this.position.getY() > 600)
            this.position.setY(0);
        if(this.position.getY() < 0)
            this.position.setY(600);
    }

    public void render(Graphics graphics){
        graphics.setColor(Color.RED);
        this.vectors.forEach(vector -> polygon.addPoint((int)vector.getX(),(int)vector.getY()));
        graphics.fillPolygon(this.polygon);
        this.polygon.reset();
    }

    public void updateVectors(){
        vectors.removeAll(vectors);
        this.vectors.add(new Vector(this.position.getX() - 10, this.position.getY() - 10));
        this.vectors.add(new  Vector(this.position.getX() - 10, this.position.getY() + 10));
        this.vectors.add(new Vector(this.position.getX(), this.position.getY()));
    }

}

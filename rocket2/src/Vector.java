public class Vector {

    private float x, y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector(){

    }
    public Vector add(Vector vector){
        this.x += vector.getX();
        this.y += vector.getY();
        return this;
    }

    public Vector turning(double radian){
        double radians = Math.toRadians(radian);
        float sin = (float)Math.sin(radians);
        float cos = (float)Math.cos(radians);
        Vector vector = new Vector(this.x*cos - this.y*sin,this.x*sin + this.y*cos);//tim toa do anh theo phep vi tu
        return vector;
    }
}

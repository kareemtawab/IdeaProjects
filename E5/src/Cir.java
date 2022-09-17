public class Cir extends Shape{

    private double radius;

    public Cir(double radius) {
        this.radius = Math.abs(radius);
    }

    public double calcArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
}

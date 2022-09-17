public class Rec extends Shape{

    private double width;

    public Rec(double length, double width) {
        this.width = Math.abs(width);
        this.setLength(Math.abs(length));
    }

    public double calcArea() {
        return this.getLength() * width;
    }
}

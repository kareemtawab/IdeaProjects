public class Squ extends Shape{

    public Squ(double length) {
        this.setLength(Math.abs(length));
    }

    public double calcArea() {
        return Math.pow(this.getLength(), 2);
    }

}

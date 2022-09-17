public class Tra extends Shape{

    private double secondLength;
    private double perpendicularHeight;

    public Tra(double firstLength, double secondLength, double perpendicularHeight) {
        this.secondLength = Math.abs(secondLength);
        this.perpendicularHeight = Math.abs(perpendicularHeight);
        this.setLength(Math.abs(firstLength));
    }

    public double calcArea() {
        return (this.getLength() + secondLength) / 2 * this.perpendicularHeight;
    }
}

public class Shape {

    private double length;

    public Shape() {
    }

    public Shape(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    public double calcArea(double l){
        return l * l;
    }
}

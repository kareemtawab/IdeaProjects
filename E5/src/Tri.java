public class Tri extends Shape{

    private double firstLength;
    private double secondLength;
    private double angleBetween;

    public Tri() {
    }

    public Tri(double firstLength, double secondLength, double angleBetween) {
        this.setFirstLength(firstLength); // to run checks in setter
        this.setSecondLength(secondLength); // to run checks in setter
        this.setAngleBetween(angleBetween); // to run checks in setter
    }

    public double getFirstLength() {
        return firstLength;
    }

    public void setFirstLength(double firstLength) {
        this.firstLength = Math.abs(firstLength);    // avoid setting of negative values
    }

    public double getSecondLength() {
        return secondLength;
    }

    public void setSecondLength(double secondLength) {
        this.secondLength = Math.abs(secondLength);    // avoid setting of negative values
    }

    public double getAngleBetween() {
        return angleBetween;
    }

    public void setAngleBetween(double angleBetween) {
        if (angleBetween < 180 && angleBetween > 0){    // check for a valid input angle from 0 deg to 180 deg
            this.angleBetween = angleBetween;
        }
        else {
            System.out.println("Invalid angle. Setting angle to 90deg.");
            setAngleBetween(90);
        }
    }

    public double calcArea() {
        return 0.5 * firstLength * secondLength * Math.sin(Math.toRadians(angleBetween));
    }
}

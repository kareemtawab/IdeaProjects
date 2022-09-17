import java.util.Scanner;

public class Main implements Runnable{
    public static void main(String[] args) {
        // ----------------------------------
        System.out.println("**ASSIGNMENT 5**");
        System.out.println("**CODE 1**");

        Vehicle v = new Vehicle() {
            @Override
            void brake() {
                System.out.println("brake() function called!\n");
            }
        };
        v.brake();

        // ----------------------------------
        System.out.println("**ASSIGNMENT 5**");
        System.out.println("**CODE 2**");

        System.out.println("Hello user!");
        Scanner s = new Scanner(System.in);
        System.out.println("Select shape:\n1-Trapezoid/Rectangle\n2-Triangle\n3-Circle\n4-Square\nANY KEY-Terminate program\n");
        switch (s.next().charAt(0)){
            case '1': {
                System.out.println("Please type 't' for a trapezoid and 'r' for a rectangle:");
                char sel = s.next().charAt(0);
                switch (sel){
                    case 't':{
                        System.out.println("Selected 'trapezoid'. Enter first length, second length and perpendicular height:");
                        double l, l_, h;
                        l = s.nextDouble();
                        System.out.println("First Length = " + l);
                        l_ = s.nextDouble();
                        System.out.println("Second Length = " + l_);
                        h = s.nextDouble();
                        System.out.println("Perpendicular height = " + h);
                        Tra tra = new Tra(l, l_, h);
                        System.out.println("Area of trapezoid = " + tra.calcArea());
                        break;
                    }
                    case 'r':{
                        System.out.println("Selected 'rectangle'. Enter length and width:");
                        double l, w;
                        l = s.nextDouble();
                        System.out.println("Length = " + l);
                        w = s.nextDouble();
                        System.out.println("Width = " + w);
                        Rec rec = new Rec(l, w);
                        System.out.println("Area of rectangle = " + rec.calcArea());
                        break;
                    }
                    default: {
                        System.out.println("Invalid selection! Shape program terminated!");
                        break;
                    }
                }
                break;
            }

            case '2': {
                Tri tri = new Tri();
                System.out.println("Enter first length, second length and angle in between:");
                tri.setFirstLength(s.nextDouble());
                System.out.println("First Length = " + tri.getFirstLength());
                tri.setSecondLength(s.nextDouble());
                System.out.println("Second Length = " + tri.getSecondLength());
                tri.setAngleBetween(s.nextDouble());
                System.out.println("Angle = " + tri.getAngleBetween());
                System.out.println("Area of triangle = " + tri.calcArea());
                break;
            }

            case '3': {
                double r;
                System.out.println("Enter radius:");
                r = s.nextDouble();
                System.out.println("Radius = " + r);
                Cir cir = new Cir(r);
                System.out.println("Area of rectangle = " + cir.calcArea());
                break;
            }

            case '4': {
                double ls;
                System.out.println("Enter length:");
                ls = s.nextDouble();
                System.out.println("Length = " + ls);
                Squ squ = new Squ(ls);
                System.out.println("Area of rectangle = " + squ.calcArea());
                break;
            }

            default: {
                System.out.println("Shape program terminated!");
                break;
            }
        }
        System.out.println("Thank you!\n");

        // ----------------------------------
        System.out.println("**ASSIGNMENT 5**");
        System.out.println("**CODE 3**");

        Thread t = new Thread(new Main());
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("Word count in thread: " + i);
        }
    }
}
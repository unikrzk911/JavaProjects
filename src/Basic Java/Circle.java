public class Circle implements Shape, TestInterface {

    double radius;

    //Parametrized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(2.5);
        double area = circle.findArea();
        System.out.println("Area is " + area);

    }
}

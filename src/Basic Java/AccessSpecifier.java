/*Access specifier
 * 1. Private -> within same class
 * 2. Default -> within same package
 * 3. Protected -> from different packages using subclasses
 *
 * */
class Test {
    int num = 40;

    void display() {
        System.out.println("Display function");
    }
}

public class AccessSpecifier {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.num);
        test.display();
    }
}

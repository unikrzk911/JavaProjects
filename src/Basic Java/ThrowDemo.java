public class ThrowDemo {
    public static void main(String[] args) {
        try {
            divide(5, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Invalid division, divided by zero");
        } else {
            System.out.println("Result is " + num1 / num2);
        }
    }
}

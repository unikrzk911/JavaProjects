public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println(sum(5, 7));
        System.out.println(sum(2.3, 7.1));
        System.out.println(sum(1, 2, 3));
    }


    //Method overloading by changing datatype and argument
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static double sum(double num1, double num2) {
        return num1 + num2;
    }

    public static double sum(double num1, double num2, double num3) {
        return num1 + num2 + num3;
    }
}

/*Two types of exception
 * 1. Checked Exception -> IOException, SQLException
 * 2. Unchecked Exception -> ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException
 *
 *   try {
 *   }
 *   catch(){
 *   }
 *   finally{
 *   }
 * */

public class ExceptionDemo {
    public static void main(String[] args) {
        int number[] = new int[3];
        System.out.println("Before exception");
        try {
            //System.out.println(6 / 0);
            System.out.println(number[5]);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Exception occured.");
        } finally {
            System.out.println("This is finally block.");
        }
        System.out.println("After exception");
    }
}

import java.util.Scanner;

class InvalidVoterException extends Exception {
    InvalidVoterException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age");
        double age = scanner.nextDouble();
        try {
            if (age < 18) {
                throw new InvalidVoterException("Invalid voter, you are too young to vote");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

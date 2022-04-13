import java.util.Scanner;

public class Member {
    int mid;
    String mName;

    public void getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id and name: ");
        mid = scanner.nextInt();
        mName = scanner.nextLine();
    }

    public void display() {
        System.out.println("ID is " + mid + " and name is " + mName);
    }
}

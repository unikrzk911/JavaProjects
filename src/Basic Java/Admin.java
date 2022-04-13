import java.util.Scanner;

public class Admin extends Member {
    String designation;

    void getDesignation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter designation");
        designation = scanner.nextLine();
    }

    void displayDesignation() {
        System.out.println("Designation is " + designation);
    }

    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.getData();
        admin.getDesignation();
        admin.display();
        admin.displayDesignation();
    }
}

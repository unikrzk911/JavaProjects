import java.util.Scanner;


public class Teacher extends Member {
    double salary;

    //Method overriding
    public void getData() {
        super.getData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter salary");
        salary = scanner.nextDouble();
    }

    //Method overriding
    public void display() {
        super.display();
        System.out.println("Salary is " + salary);
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.getData();
        //teacher.getSalary();
        teacher.display();
        //teacher.displaySalary();

    }
}


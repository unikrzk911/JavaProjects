public class Student {
    int rollNo;
    String name;
    double percentage;
    char section;
    static int count;

    public void displayDetail() {
        System.out.println("Roll no is " + rollNo);
        System.out.println("Name is " + name);
        System.out.println("Percentage is " + percentage);
        System.out.println("Section is " + section);
        System.out.println();
    }

    //Parametrized constructor
    Student(int rollNo, String name, double percentage, char section) {
        this.rollNo = rollNo;
        this.name = name;
        this.percentage = percentage;
        this.section = section;
        count++;
    }

    public static void totalStudent() {
        System.out.println("There are total " + count + " students");
    }

}

class StudentDemo {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Unique", 89.32, 'A');
        student1.displayDetail();
        Student student2 = new Student(2, "Ritesh", 99.32, 'B');
        student2.displayDetail();
        student1.totalStudent();
    }
}

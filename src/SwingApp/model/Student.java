package SwingApp.model;

public class Student {

    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private String course;
    private String hobbies;
    private String phone;
    private String remarks;
    private int studentId;

    public Student(String firstName, String lastName, String address, String gender, String course, String hobbies, String phone, String remarks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.course = course;
        this.hobbies = hobbies;
        this.phone = phone;
        this.remarks = remarks;
    }

    public Student(String firstName, String lastName, String address, String gender, String course, String hobbies, String phone, String remarks, int studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.course = course;
        this.hobbies = hobbies;
        this.phone = phone;
        this.remarks = remarks;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

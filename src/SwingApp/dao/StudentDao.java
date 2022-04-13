package SwingApp.dao;

import SwingApp.database.DbConnection;
import SwingApp.model.Student;
import SwingApp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    Connection connection = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;

    public boolean signupUser(User user) throws Exception {
        boolean isRegistered = false;
        connection = new DbConnection().getDbConnection();
        pstmt = connection.prepareStatement("INSERT INTO USERS(FULLNAME, EMAIL, USERNAME, PASSWORD)" +
                " VALUES(?,?,?,?)");
        pstmt.setString(1, user.getFullName());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getUsername());
        pstmt.setString(4, user.getPassword());
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            isRegistered = true;
        }
        pstmt.close();
        connection.close();
        return isRegistered;
    }

    public boolean checkValidUser(User user) throws Exception {
        boolean isValidUser = false;
        connection = new DbConnection().getDbConnection();
        pstmt = connection.prepareStatement("SELECT COUNT(1) FROM USERS WHERE USERNAME=? AND PASSWORD=?");
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            isValidUser = rs.getInt(1) > 0 ? true : false;
        }
        pstmt.close();
        connection.close();
        return isValidUser;
    }

    public boolean addStudent(Student student) throws Exception {
        boolean isAdded = false;
        connection = new DbConnection().getDbConnection();
        pstmt = connection.prepareStatement("INSERT INTO STUDENT(FIRSTNAME, LASTNAME, ADDRESS, GENDER,COURSE,HOBBIES,PHONE,REMARKS)" +
                " VALUES(?,?,?,?,?,?,?,?)");
        pstmt.setString(1, student.getFirstName());
        pstmt.setString(2, student.getLastName());
        pstmt.setString(3, student.getAddress());
        pstmt.setString(4, student.getGender());
        pstmt.setString(5, student.getCourse());
        pstmt.setString(6, student.getHobbies());
        pstmt.setString(7, student.getPhone());
        pstmt.setString(8, student.getRemarks());
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            isAdded = true;
        }
        pstmt.close();
        connection.close();
        return isAdded;
    }

    public boolean deleteStudent(int studentID) throws Exception {
        boolean isDeleted = false;
        connection = new DbConnection().getDbConnection();
        pstmt = connection.prepareStatement("DELETE FROM STUDENT WHERE STUDENTID=?");
        pstmt.setInt(1, studentID);
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            isDeleted = true;
        }
        pstmt.close();
        connection.close();
        return isDeleted;
    }

    public boolean updateStudent(Student student) throws Exception {
        boolean isUpdated = false;
        connection = new DbConnection().getDbConnection();
        pstmt = connection.prepareStatement("UPDATE STUDENT SET FIRSTNAME=?, LASTNAME=?, ADDRESS=?, GENDER=?,COURSE=?,HOBBIES=?,PHONE=?,REMARKS=? WHERE STUDENTID=?");
        pstmt.setString(1, student.getFirstName());
        pstmt.setString(2, student.getLastName());
        pstmt.setString(3, student.getAddress());
        pstmt.setString(4, student.getGender());
        pstmt.setString(5, student.getCourse());
        pstmt.setString(6, student.getHobbies());
        pstmt.setString(7, student.getPhone());
        pstmt.setString(8, student.getRemarks());
        pstmt.setInt(9, student.getStudentId());
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            isUpdated = true;
        }
        pstmt.close();
        connection.close();
        return isUpdated;
    }
}

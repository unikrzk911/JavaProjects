package SwingApp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrudOperations {
    static Connection connection = null;
    static PreparedStatement pstmt = null;
    static Statement stmt = null;

    public CrudOperations() {
        connection = new DbConnection().getDbConnection();
    }

    public static void insert() throws Exception {
        pstmt = connection.prepareStatement("INSERT INTO USERS(FULLNAME, EMAIL, USERNAME, PASSWORD)" +
                " VALUES(?,?,?,?)");
        pstmt.setString(1, "test");
        pstmt.setString(2, "test@gmail.com");
        pstmt.setString(3, "test");
        pstmt.setString(4, "test");
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("User added successfully!!");
        } else {
            System.out.println("User not added!");
        }
        pstmt.close();
        connection.close();
    }

    public static void delete() throws Exception {
        pstmt = connection.prepareStatement("DELETE FROM USERS WHERE USERNAME=?");
        pstmt.setString(1, "test");
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("User deleted successfully!!");
        } else {
            System.out.println("User not deleted!");
        }
        pstmt.close();
        connection.close();
    }

    public static void update() throws Exception {
        pstmt = connection.prepareStatement("UPDATE USERS SET PASSWORD=?, EMAIL=? WHERE USERNAME=?");
        pstmt.setString(1, "newpassword");
        pstmt.setString(2, "newemail@gmail.com");
        pstmt.setString(3, "rohitdahal");
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("User updated successfully!!");
        } else {
            System.out.println("User not updated!");
        }
        pstmt.close();
        connection.close();
    }

    public static void getUsers() throws Exception {
        stmt = connection.createStatement();
        String query = "SELECT FULLNAME, EMAIL, USERNAME, PASSWORD FROM USERS";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println("Full name is :::" + rs.getString(1));
            System.out.println("Email is :::" + rs.getString(2));
            System.out.println("Username is :::" + rs.getString(3));
            System.out.println("Password is :::" + rs.getString(4));
            System.out.println();
        }
    }


    public static void main(String[] args) throws Exception {
        new CrudOperations();
        //insert();
        //delete();
        //update();
        getUsers();
    }
}

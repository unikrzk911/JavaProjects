package SwingApp.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableUpdateTableDemo {
    public static void main(String[] args) {
        try {
            Connection connection = new DbConnection().getDbConnection();

            //Making result scrollable
            //Statement stmt= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            //Making result updatable
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT STUDENTID,FIRSTNAME,LASTNAME,ADDRESS,GENDER,COURSE,HOBBIES,PHONE,REMARKS FROM STUDENT");
            //rs.last();
            rs.absolute(2);
            System.out.println("Before update.........");
            System.out.println(rs.getInt("STUDENTID"));
            System.out.println(rs.getString("FIRSTNAME"));
            System.out.println(rs.getString("LASTNAME"));
            System.out.println(rs.getString("ADDRESS"));


            rs.updateString(2, "Ram");
            rs.updateRow();

            System.out.println("After update.........");
            System.out.println(rs.getInt("STUDENTID"));
            System.out.println(rs.getString("FIRSTNAME"));
            System.out.println(rs.getString("LASTNAME"));
            System.out.println(rs.getString("ADDRESS"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

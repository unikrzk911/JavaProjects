package SwingApp.database;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {
    public static void main(String[] args) {
        try {
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
            Class.forName("com.mysql.jdbc.Driver");
            rowSet.setUrl("jdbc:mysql://localhost:3306/primecsita");
            rowSet.setUsername("root");
            rowSet.setPassword("");
            rowSet.setCommand("SELECT STUDENTID, FIRSTNAME, LASTNAME, ADDRESS FROM STUDENT");
            rowSet.execute();

            rowSet.first();
            System.out.println("First Student");
            System.out.println(rowSet.getInt("STUDENTID"));
            System.out.println(rowSet.getString("FIRSTNAME"));
            System.out.println(rowSet.getString("LASTNAME"));
            System.out.println(rowSet.getString("ADDRESS"));

            rowSet.last();
            System.out.println("Last Student");
            System.out.println(rowSet.getInt("STUDENTID"));
            System.out.println(rowSet.getString("FIRSTNAME"));
            System.out.println(rowSet.getString("LASTNAME"));
            System.out.println(rowSet.getString("ADDRESS"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package SwingApp.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {


    public Connection getDbConnection() {
        Connection connection = null;
        //Steps to connect to the database in java
        //1.Register the driver class
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.Creating connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/primecsita", "root", "");
            //System.out.println("connection is "+connection);
            //3. Creating Statement
            //4. Executing queries
            //5. Closing connection
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}

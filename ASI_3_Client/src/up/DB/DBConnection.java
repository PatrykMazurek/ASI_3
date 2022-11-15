package up.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    private Connection conn;

    public DBConnection(){
        conn = null;
    }

    public Connection connectToSqlite(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
            System.out.println("Nawiązano połączenie");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createTable(){
        try {
            PreparedStatement preper = conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Person " +
                            "(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "Name TEXT," +
                            "LastName TEXT," +
                            "Age INTEGER)");
            preper.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            if (!conn.isClosed()){
                System.out.println("Zakończenie połączenia");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

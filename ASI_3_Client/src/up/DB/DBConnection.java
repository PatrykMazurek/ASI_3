package up.DB;

import java.sql.*;

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

    public Connection connectionToMySql(){
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/test",
                    "root",
                    "usbw"
            );
            System.out.println("Połączono z bazą danych");
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

    public Savepoint getPoint(){
        try {
            Savepoint s = conn.setSavepoint();
            conn.setAutoCommit(false);
            System.out.println("Utworzono punkt przywracania ");
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getRollback(Savepoint point){
        try {
            conn.rollback(point);
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

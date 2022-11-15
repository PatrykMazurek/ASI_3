package up.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation {

    private Connection conn;

    public DBOperation(Connection c){
        conn = c;
    }

    public void insertPerson(String name, String lastName, int age){
        PreparedStatement preper = null;
        try {
            preper = conn.prepareStatement(
                    "INSERT INTO Person (Name, LastName, Age) " +
                            "VALUES (?,?,?)");
            preper.setString(1, name);
            preper.setString(2, lastName);
            preper.setInt(3, age);
            int result = preper.executeUpdate();
            System.out.println("Wstawiono " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllRecord(){
        try {
            PreparedStatement preper = conn.prepareStatement(
                    "SELECT * FROM Person",
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY
            );

            ResultSet resultSet = preper.executeQuery();

            while (resultSet.next()){
                System.out.println(String.format("rekodr z bazy %d, %s, %s %d",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}

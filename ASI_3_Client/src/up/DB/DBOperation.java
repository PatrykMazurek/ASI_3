package up.DB;

import com.mysql.cj.MysqlType;

import java.sql.*;

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

    public void getCountPerson(){
        try {
            CallableStatement callStm = conn.prepareCall(
                    "{ call GetCountPerson(?) }");
            callStm.registerOutParameter(1, MysqlType.INT);
            callStm.executeUpdate();
            int number = callStm.getInt(1);
            System.out.println("liczba rekordów w bazie " + number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(String name, String lastName){
        try {
            PreparedStatement preper = conn.prepareStatement(
                    "update person set Name = ?, LastName = ? " +
                            "where Id = 3");
            preper.setString(1, name);
            preper.setString(2, lastName);
            preper.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void GetPersonProc(int id){
        try {
            CallableStatement callStm = conn.prepareCall(
                    "{ call GetPersons(?,?,?,?) }");
            callStm.setInt(1, id);
            callStm.registerOutParameter(2, MysqlType.FIELD_TYPE_VARCHAR);
            callStm.registerOutParameter(3, MysqlType.FIELD_TYPE_VARCHAR);
            callStm.registerOutParameter(4, MysqlType.INT);
            callStm.executeUpdate();

            String name = callStm.getString(2);
            String lastNam = callStm.getString(3);
            int age = callStm.getInt(4);
            System.out.printf("Rekord z bazy danych %s %s %d %n", name, lastNam, age);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllPersonProc(){
        try {
            CallableStatement callStm = conn.prepareCall(
                    "{ call GetAllPersons() }",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet result = callStm.executeQuery();

            result.afterLast();
            while (result.previous()){
                System.out.printf("%d) %s %s %d %n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString("LastName"),
                        result.getInt(4) );
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

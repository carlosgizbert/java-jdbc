import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
        System.out.println("Abrindo uma conexão com sucesso");
        connection.close();
    }
}

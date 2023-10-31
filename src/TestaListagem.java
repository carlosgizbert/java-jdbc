import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");

        Statement statement = connection.createStatement();
        boolean resultado = statement.execute("select * from Produto");
        System.out.println(resultado);

        connection.close();
    }
}

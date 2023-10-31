import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();

        Statement stmt = connection.createStatement();
        boolean resultado = stmt.execute(
                "delete from Produto where id=5",
                Statement.RETURN_GENERATED_KEYS);
        System.out.println(resultado);
        int count = stmt.getUpdateCount();

        System.out.println(count + " linhas atualizadas");

        connection.close();
    }
}

import java.sql.*;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();

        Statement statement = connection.createStatement();
        boolean resultado = statement.execute(
                "insert into Produto (nome, descricao) values('Notebook', 'Notebook i5')",
                Statement.RETURN_GENERATED_KEYS);
        System.out.println(resultado);

        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            System.out.println(id + " gerado");
        }

        connection.close();
    }


}

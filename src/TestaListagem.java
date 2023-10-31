import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();

        Statement statement = connection.createStatement();
        boolean resultado = statement.execute("select * from Produto");
        ResultSet resultset = statement.getResultSet();
        while(resultset.next()) {
            int id = resultset.getInt("id");
            String nome = resultset.getString("nome");
            String descricao = resultset.getString("descricao");
            System.out.println(id);
            System.out.println(nome);
            System.out.println(descricao);
        }
        resultset.close();
        connection.close();
    }
}

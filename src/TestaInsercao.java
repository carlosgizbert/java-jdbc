import java.sql.*;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = new Database().getConnection()) {
            connection.setAutoCommit(false);

            try {
                String sql = "insert into Produto (nome, descricao) values(?, ?)";
                PreparedStatement statement = connection.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                );

                adiciona(statement, "TV LCD", "55 polegadas");
                adiciona(statement, "Blueray", "HDMI");
                statement.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                connection.rollback();
                System.out.println("Rollback efetuado");
            }
        }
    }

    private static void adiciona(PreparedStatement statement, String nome, String descricao) throws SQLException {

        if (nome.equals("Blueray")) {
            throw new IllegalArgumentException("Problema ocorrido");
        }

        statement.setString(1, nome);
        statement.setString(2, descricao);

        boolean resultado = statement.execute();
        System.out.println(resultado);

        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            System.out.println(id + " gerado");
        }

        resultSet.close();
    }


}

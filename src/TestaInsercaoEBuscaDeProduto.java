import DAO.ProdutosDAO;
import Modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEBuscaDeProduto {
    public static void main(String[] args) throws SQLException {
        Produto mesa = new Produto("Mesa azul", "Mesa com 4 pés");
        try(Connection con = new ConnectionPool().getConnection()) {
            ProdutosDAO dao = new ProdutosDAO(con);
            dao.salva(mesa);
            List<Produto> produtos = dao.lista();
            for (Produto produto: produtos) {
                System.out.println("Existe o produto: " + produto);
            }
        }

        System.out.println("Inserido com sucesso: " + mesa);
    }
}

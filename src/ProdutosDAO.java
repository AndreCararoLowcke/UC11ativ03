
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {

        //conn = new conectaDAO().connectDB();
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }
    // Método para vender um produto

    public void venderProduto(int idProduto) {
        try {
            conn = new conectaDAO().connectDB();
            String sql = "UPDATE produtos SET status = ? WHERE id = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, "Vendido"); // Define o status como "Vendido"
            prep.setInt(2, idProduto); // Define o ID do produto
            int rowsAffected = prep.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Produto vendido com sucesso!");
            } else {
                System.out.println("Produto não encontrado ou já vendido.");
                JOptionPane.showMessageDialog(null, "Produto não encontrado ou já vendido.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
        } finally {
// Fechar as conexões
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

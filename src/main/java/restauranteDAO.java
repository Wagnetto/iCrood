import java.sql.*;

//Puro Chat GPT
public class restauranteDAO {
    //TODO:substituir "seu_banco_de_dados", "seu_usuario" e "sua_senha" com as informações corretas do banco de dados.
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";// SUBSTITUIR
    private static final String USUARIO = "seu_usuario";// SUBSTITUIR
    private static final String SENHA = "sua_senha";// SUBSTITUIR

    public void cadastrarRestaurante(Restaurante restaurante) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO restaurantes (nome, endereco, cep, identificador, dono) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, restaurante.getNome());
            statement.setString(2, restaurante.getEndereco());
            statement.setString(3, restaurante.getCep());
            statement.setInt(4, restaurante.getIdentificador());
            statement.setString(5, restaurante.getDono());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

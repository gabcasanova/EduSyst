package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Responsavel;
import util.DBUtil;

public class ResponsavelDao {

    public Responsavel logarResponsavel(String cpf, String email, String senha) {
        Responsavel responsavel = null; // Initialize responsavel as null

        // Query de login responsável.
        String sql = "SELECT * FROM responsaveis WHERE CPF = ? AND Email = ? AND Senha = ?";
        
        try (Connection conn = DBUtil.getConnection()) { // Tentar conexão com o banco de dados.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);         // definir os parametros da query com base
            stmt.setString(2, email);       // no que foi informado pelo login.
            stmt.setString(3, senha);

            ResultSet rs = stmt.executeQuery(); // executar a query MYSQL.
            
            // Criar objeto responsavel com base nas informações do banco de dados
            if (rs.next()) {
                responsavel = new Responsavel();
                responsavel.setId(rs.getInt("Id_Responsavel"));
                responsavel.setCpf(rs.getString("CPF"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setDataNasc(rs.getString("data_nasc"));
                responsavel.setEndereco(rs.getString("endereco"));
                responsavel.setTelefone(rs.getString("telefone"));
                responsavel.setGenero(rs.getString("genero"));
                responsavel.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Printar erro caso uma exception ocorra.
        }

        return responsavel; // Retornar o objeto responsavel (ou null, se nenhum objeto for encontrado...)
    }
    
    // Função para checar se o CPF do responsavel existe no
    // banco de dados.
    public boolean checarSeExiste(String cpf) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT 1 FROM responsaveis WHERE CPF = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

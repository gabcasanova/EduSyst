/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Professor;
import util.DBUtil;

/**
 *
 * @author Aluno
 */
public class ProfessorDao {
    public Professor logarProfessor(String cpf, String email, String senha) {
        Professor professor = null; // Initialize responsavel as null

        // Query de login responsável.
        String sql = "SELECT * FROM professores WHERE CPF = ? AND Email = ? AND Senha = ?";
        
        try (Connection conn = DBUtil.getConnection()) { // Tentar conexão com o banco de dados.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);         // definir os parametros da query com base
            stmt.setString(2, email);       // no que foi informado pelo login.
            stmt.setString(3, senha);

            ResultSet rs = stmt.executeQuery(); // executar a query MYSQL.
            
            // Criar objeto responsavel com base nas informações do banco de dados
            if (rs.next()) {
                professor = new Professor();
                professor.setId(rs.getInt("Id_Professor"));
                professor.setCpf(rs.getString("CPF"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setDataNasc(rs.getString("data_nasc"));
                professor.setEndereco(rs.getString("endereco"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setGenero(rs.getString("genero"));
                professor.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Printar erro caso uma exception ocorra.
        }

        return professor; // Retornar o objeto responsavel (ou null, se nenhum objeto for encontrado...)
    }
    
    // Função para checar se o CPF do responsavel existe no
    // banco de dados.
    public boolean checarSeExiste(String cpf) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT 1 FROM professores WHERE CPF = ?";
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

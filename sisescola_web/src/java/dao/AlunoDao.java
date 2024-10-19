package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import util.DBUtil;

public class AlunoDao {

    public Aluno logarAluno(String cpf, String email, String senha) {
        Aluno aluno = null; // Initialize Aluno as null

        // Query de login aluno.
        String sql = "SELECT * FROM alunos WHERE CPF = ? AND Email = ? AND Senha = ?";
        
        try (Connection conn = DBUtil.getConnection()) { // Tentar conexão com o banco de dados.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);         // definir os parametros da query com base
            stmt.setString(2, email);       // no que foi informado pelo login.
            stmt.setString(3, senha);

            ResultSet rs = stmt.executeQuery(); // executar a query MYSQL.
            
            // Criar objeto aluno com base nas informações do banco de dados
            if (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("Id_Aluno"));
                aluno.setIdResponsavel(rs.getInt("Responsavel_Id"));
                //aluno.setIdTurma(rs.getInt("Turma_Id"));
                aluno.setCpf(rs.getString("CPF"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setDataNasc(rs.getString("data_nasc"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setGenero(rs.getString("genero"));
                aluno.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Printar erro caso uma exception ocorra.
        }

        return aluno; // Retornar o objeto aluno (ou null, se nenhum objeto for encontrado...)
    }
    
    // Função para checar se o CPF do aluno existe no
    // banco de dados.
    public boolean checarSeExiste(String cpf) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT 1 FROM alunos WHERE CPF = ?";
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

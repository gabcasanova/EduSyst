/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;

/**
 *
 * @author Casanova
 * 15/09/24... não me orgulho muito desse código... mas já é tarde demais 03:10
 */
public class Select {
    // Obter nome do responsavel do aluno identificado.
    public String obterResponsavel (int alunoIdValor) {
        String alunoId = String.valueOf(alunoIdValor);
        String sql = "SELECT responsaveis.Nome FROM responsaveis INNER JOIN alunos ON responsaveis.Id_Responsavel = alunos.Responsavel_ID WHERE alunos.Id_Aluno = ?;";
        String nomeResponsavel = "";
        
        try (Connection conn = DBUtil.getConnection()) { // Tentar conexão com o banco de dados.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alunoId);         // definir os parametros da query com base
            ResultSet rs = stmt.executeQuery(); // executar a query MYSQL.
            
            if (rs.next()) {
                nomeResponsavel = rs.getString("nome");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Printar erro caso uma exception ocorra.
        }
        
        return nomeResponsavel;
    }
    
    // Obter classe da turma do aluno identificado.
    public String obterTurma (int alunoIdValor) { 
        String alunoId = String.valueOf(alunoIdValor);
        String sql = "select turmas.classe from turmas inner join turmas_alunos on turmas_alunos.turma_id = turmas.id_turma inner join alunos on alunos.id_aluno = turmas_alunos.aluno_id where alunos.id_aluno = ?;";
        String classe = "";
        
        try (Connection conn = DBUtil.getConnection()) { // Tentar conexão com o banco de dados.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alunoId);         // definir os parametros da query com base
            ResultSet rs = stmt.executeQuery(); // executar a query MYSQL.
            
            if (rs.next()) {
                classe = rs.getString("Classe");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Printar erro caso uma exception ocorra.
        }
        
        return classe;
    }
    
    // Obter classe da turma do aluno identificado.
    public String obterEtapa (int alunoIdValor) { 
        String alunoId = String.valueOf(alunoIdValor);
        String sql = "select turmas.etapa from turmas inner join turmas_alunos on turmas_alunos.turma_id = turmas.id_turma inner join alunos on alunos.id_aluno = turmas_alunos.aluno_id where alunos.id_aluno = ?;";
        String etapa = "";
        
        try (Connection conn = DBUtil.getConnection()) { // Tentar conexão com o banco de dados.
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alunoId);         // definir os parametros da query com base
            ResultSet rs = stmt.executeQuery(); // executar a query MYSQL.
            
            if (rs.next()) {
                etapa = rs.getString("Etapa");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Printar erro caso uma exception ocorra.
        }
        
        return etapa;
    }
}

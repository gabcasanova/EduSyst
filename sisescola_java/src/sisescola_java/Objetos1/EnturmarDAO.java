/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisescola_java.Objetos1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class EnturmarDAO {

    public void Enturmar(Enturmar en) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Turmas_Alunos (Aluno_ID, Turma_ID) VALUES (?, ?)");
            ps.setInt(1, en.getAluno_ID());
            ps.setInt(2, en.getTurma_ID());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Aluno enturmado com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public List<Aluno> buscarAlunosEnturmados(int turmaId) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluno> alunosEnturmados = new ArrayList<>();

        try {
            String sql = "SELECT a.Id_Aluno, a.NomeA FROM Alunos a "
                    + "JOIN Turmas_Alunos ta ON a.Id_Aluno = ta.Aluno_ID "
                    + "WHERE ta.Turma_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, turmaId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId_Aluno(rs.getInt("Id_Aluno"));
                aluno.setNomeA(rs.getString("NomeA"));
                alunosEnturmados.add(aluno);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar alunos enturmados: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }

        return alunosEnturmados;
    }

    public void desenturmarAlunogeral(int alunoId) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Turmas_Alunos WHERE Aluno_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, alunoId);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno desenturmado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado na turma.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desenturmar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void desenturmarDeTurma(int alunoId, int turmaId) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Turmas_Alunos WHERE Aluno_ID = ? AND Turma_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, alunoId);
            ps.setInt(2, turmaId);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno desenturmado da turma com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado na turma especificada.");
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public Turma buscarTurmaPorAlunoId(int alunoId) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        Turma turma = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT t.Id_Turma, t.Classe FROM Turmas t INNER JOIN Turmas_Alunos ta ON t.Id_Turma = ta.Turma_ID WHERE ta.Aluno_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, alunoId);
            rs = ps.executeQuery();
            if (rs.next()) {
                turma = new Turma();
                turma.setId_Turma(rs.getInt("Id_Turma"));
                turma.setClasse(rs.getInt("Classe"));
            }
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return turma;
    }

    public List<Turma> ConsultarTurmasAlunos(int alunoId) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Turma> turmas = new ArrayList<>();

        try {
            String sql = "SELECT t.Id_Turma, t.Classe FROM Turmas t "
                    + "JOIN Turmas_Alunos ta ON t.Id_Turma = ta.Turma_ID "
                    + "WHERE ta.Aluno_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, alunoId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Turma turma = new Turma();
                turma.setId_Turma(rs.getInt("Id_Turma"));
                turma.setClasse(rs.getInt("Classe"));
                turmas.add(turma);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar turmas: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return turmas;
    }

    public Aluno buscarAlunoPorCPFOuNome(String pesquisa) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Aluno aluno = null;

        try {
            // Verifica se a pesquisa é um ID (números apenas) ou um nome
            String sql;
            if (pesquisa.matches("\\d+")) {
                sql = "SELECT Id_Aluno, Nome FROM Alunos WHERE CPF = ?";
            } else {
                sql = "SELECT Id_Aluno, Nome FROM Alunos WHERE Nome LIKE ?";
                pesquisa = "%" + pesquisa + "%";
            }

            ps = con.prepareStatement(sql);
            ps.setString(1, pesquisa);
            rs = ps.executeQuery();

            // Armazena o resultado em um objeto Aluno, caso haja resultados
            if (rs.next()) {
                aluno = new Aluno();
                aluno.setId_Aluno(rs.getInt("Id_Aluno"));
                aluno.setNomeA(rs.getString("Nome"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar aluno: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return aluno;
    }
}

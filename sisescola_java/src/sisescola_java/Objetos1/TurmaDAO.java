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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class TurmaDAO {

    public void CadastrarTurma(Turma t) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Turmas (Id_Turma, Ano, Classe, Etapa)VALUES (?, ?, ?, ?)");
            ps.setInt(1, t.getId_Turma());
            ps.setInt(2, t.getAno());
            ps.setInt(3, t.getClasse());
            ps.setString(4, t.getEtapa());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar turma.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar turma: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public ResultSet listarTurmas() {
        Connection con;
        PreparedStatement ps = null;

        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT Id_Turma, Classe FROM Turmas ORDER BY Id_Turma ASC";
            try {
                ps = con.prepareStatement(sql);
                return ps.executeQuery();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na conexão");
                return null;
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada. ");
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta IdTurma. ");
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Turma> consultarPorTurma(int classe) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Turma> turmas = new ArrayList<>();
        try {
            String sql = "SELECT a.Nome, a.Email, t.Id_Turma, t.Classe, t.Ano, t.Etapa "
                    + "FROM Alunos AS a "
                    + "JOIN Turmas_Alunos AS at ON a.Id_Aluno = at.Aluno_ID "
                    + "JOIN Turmas AS t ON t.Id_Turma = at.Turma_ID "
                    + "WHERE t.Classe = ?"; 

            ps = con.prepareStatement(sql);
            ps.setInt(1, classe); 
            rs = ps.executeQuery();

            Map<Integer, Turma> mapaTurmas = new HashMap<>();

            while (rs.next()) {
                int id = rs.getInt("Id_Turma");
                int classeTurma = rs.getInt("Classe");
                int ano = rs.getInt("Ano");
                String etapa = rs.getString("Etapa");
                Turma t = mapaTurmas.get(classeTurma);
                if (t == null) {
                    t = new Turma();
                    t.setId_Turma(id);
                    t.setClasse(classeTurma);
                    t.setAno(ano);
                    t.setEtapa(etapa);
                    mapaTurmas.put(classeTurma, t);
                }
                Aluno aluno = new Aluno();
                aluno.setNomeA(rs.getString("Nome"));
                aluno.setEmailA(rs.getString("Email"));
                t.addAluno(aluno);
            }
            turmas.addAll(mapaTurmas.values());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return turmas; 
    }

    public List<Turma> consultar() throws ClassNotFoundException, SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Turma> turma = new ArrayList();
        try {
            ps = con.prepareStatement("SELECT * FROM Turmas");
            rs = ps.executeQuery();

            while (rs.next()) {
                Turma t = new Turma();
                t.setId_Turma(rs.getInt("Id_Turma"));
                t.setAno(rs.getInt("Ano"));
                t.setClasse(rs.getInt("Classe"));
                t.setEtapa(rs.getString("Etapa"));

                turma.add(t);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return turma;
    }

    public List<Turma> btconsultar(int Id_Turma) throws ClassNotFoundException, SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Turma> turma = new ArrayList();
        try {
            if (Id_Turma != 0) {
                ps = con.prepareStatement("SELECT * FROM Turmas WHERE classe = ?");
                ps.setInt(1, Id_Turma);
                rs = ps.executeQuery();
            }
            while (rs.next()) {
                Turma t = new Turma();
                t.setId_Turma(rs.getInt("Id_Turma"));
                t.setAno(rs.getInt("Ano"));
                t.setClasse(rs.getInt("Classe"));
                t.setEtapa(rs.getString("Etapa"));

                turma.add(t);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        rs.close();
        ps.close();
        con.close();
        return turma;
    }

    public void AtualizarTurma(Turma t) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza somente o aluno com o CPF fornecido
            String sql = "UPDATE Turmas SET Ano= ?, Classe = ?, Etapa = ? WHERE Classe = ?";
            ps = con.prepareStatement(sql);

            // Define os parâmetros da query
            ps.setInt(1, t.getAno());
            ps.setInt(2, t.getClasse());
            ps.setString(3, t.getEtapa());
            ps.setInt(4, t.getClasse()); // Usar Id para identificar a turma a ser atualizada
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma turma encontrado com a classe fornecida.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void Excluir(int Id_Turma, int Classe) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Corrigido para usar "=" ao invés de "LIKE" para o campo inteiro Id_Turma
            String sql = "DELETE FROM Turmas WHERE Id_Turma = ? OR Classe = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id_Turma);
            ps.setInt(2, Classe);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Turma deletada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma turma encontrada para deletar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

}

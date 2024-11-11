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
 * @author Matheus
 */
public class HorarioDAO {

    public void CadastrarHorario(Horario h) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Horarios (Id_Horario, Turno, Inicio, Fim, Dia_Semana)VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, h.getId_Horario());
            ps.setString(2, h.getTurno());
            ps.setString(3, h.getInicio());
            ps.setString(4, h.getFim());
            ps.setString(5, h.getDia_Semana());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Horário criado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao criar horário.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar horário: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public List<Horario> consultar() throws ClassNotFoundException, SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Horario> horario = new ArrayList();
        try {
            ps = con.prepareStatement("SELECT * FROM Horarios");
            rs = ps.executeQuery();

            while (rs.next()) {
                Horario h = new Horario();
                h.setId_Horario(rs.getInt("Id_Horario"));
                h.setTurno(rs.getString("Turno"));
                h.setInicio(rs.getString("Inicio"));
                h.setFim(rs.getString("Fim"));
                h.setDia_Semana(rs.getString("Dia_Semana"));

                horario.add(h);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return horario;
    }

    public List<Horario> consultarTodosHorarios() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Horario> horarios = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM Horarios");
            rs = ps.executeQuery();

            while (rs.next()) {
                Horario h = new Horario();
                h.setId_Horario(rs.getInt("Id_Horario"));
                h.setTurno(rs.getString("Turno"));
                h.setInicio(rs.getString("Inicio"));
                h.setFim(rs.getString("Fim"));
                h.setDia_Semana(rs.getString("Dia_Semana"));

                horarios.add(h);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar horários: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return horarios;
    }

    public Horario consultarHorarioPorId(int idHorario) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Horario horario = null;

        try {
            ps = con.prepareStatement("SELECT * FROM Horarios WHERE Id_Horario = ?");
            ps.setInt(1, idHorario);
            rs = ps.executeQuery();

            if (rs.next()) {
                horario = new Horario();
                horario.setId_Horario(rs.getInt("Id_Horario"));
                horario.setTurno(rs.getString("Turno"));
                horario.setInicio(rs.getString("Inicio"));
                horario.setFim(rs.getString("Fim"));
                horario.setDia_Semana(rs.getString("Dia_Semana"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return horario;
    }

    public void AtualizarHorario(Horario h) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza somente o aluno com o CPF fornecido
            String sql = "UPDATE Horarios SET Turno= ?, Inicio = ?, Fim = ?, Dia_Semana = ? WHERE Id_Horario = ?";
            ps = con.prepareStatement(sql);

            // Define os parâmetros da query
            ps.setString(1, h.getTurno());
            ps.setString(2, h.getInicio());
            ps.setString(3, h.getFim());
            ps.setString(4, h.getDia_Semana());
            ps.setInt(5, h.getId_Horario());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Horário atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum horário encontrado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void Excluir(int Id_Horario) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Corrigido para usar "=" ao invés de "LIKE" para o campo inteiro Id_Turma
            String sql = "DELETE FROM Horarios WHERE Id_Horario = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id_Horario);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Horário deletado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum horário encontrado para deletar");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
}

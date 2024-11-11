/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisescola_java.Objetos1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class EscalaDAO {

    public void Escalar(Escalas es) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Professores_Horarios (Horario_ID, Professor_ID) VALUES (?, ?)");
            ps.setInt(1, es.getHorario_ID());
            ps.setInt(2, es.getProfessor_ID());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Professor escalado com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escalar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void removerEscala(int professorId, int horarioId) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            // Prepara a query para excluir o professor e o horário da tabela Professores_Horarios
            ps = con.prepareStatement("DELETE FROM Professores_Horarios WHERE Professor_ID = ? AND Horario_ID = ?");
            ps.setInt(1, professorId);
            ps.setInt(2, horarioId);

            // Executa a query
            int rowsAffected = ps.executeUpdate();

            // Verifica se a exclusão foi bem-sucedida
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Escala removida com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma escala encontrada para o professor e horário especificados.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover escala: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

}

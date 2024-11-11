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
public class EscalarMateriaDAO {

    public void Escalar(EscalaMateria es) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Horarios_Materias (Horario_ID, Materia_ID, Turma_ID) VALUES (?, ?, ?)");
            ps.setInt(1, es.getHorario_ID());
            ps.setInt(2, es.getMateria_ID());
            ps.setInt(3, es.getTurma_ID());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Matéria escalada com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escalar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void removerAssociacao(int materiaId, int turmaId, int horarioId) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            // Prepara a query para excluir a associação
            ps = con.prepareStatement("DELETE FROM Horarios_Materias WHERE Materia_ID = ? AND Turma_ID = ? AND Horario_ID = ?");
            ps.setInt(1, materiaId);
            ps.setInt(2, turmaId);
            ps.setInt(3, horarioId);

            // Executa a query
            int rowsAffected = ps.executeUpdate();

            // Verifica se a exclusão foi bem-sucedida
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Associação removida com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma associação encontrada.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover associação: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
}

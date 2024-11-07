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
public class MateriasDAO {

    public void CriarMateria(Materias d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Materias (Id_Materia, Nome)VALUES (?, ?)");
            ps.setInt(1, d.getId_Materia());
            ps.setString(2, d.getNome());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Matéria cadastrada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar matéria.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar matéria: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public List<Materias> consultar() throws ClassNotFoundException, SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Materias> mat = new ArrayList();
        try {
            ps = con.prepareStatement("SELECT * FROM Materias");
            rs = ps.executeQuery();

            while (rs.next()) {
                Materias m = new Materias();
                m.setId_Materia(rs.getInt("Id_Materia"));
                m.setNome(rs.getString("Nome"));

                mat.add(m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return mat;
    }

    public List<Materias> btconsultar(String nome) throws ClassNotFoundException, SQLException {
        List<Materias> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();// Método para obter a conexão com o banco

        PreparedStatement stmt = null;
        if (nome != null) {
            stmt = con.prepareStatement("SELECT * FROM Materias WHERE Nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");
        }

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Materias t = new Materias();
            t.setId_Materia(rs.getInt("Id_Materia"));
            t.setNome(rs.getString("Nome"));
            lista.add(t);
        }

        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    public void AlterarMateria(String nomeAntigo, String nomeNovo) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza a matéria com o nome antigo fornecido para o novo nome
            String sql = "UPDATE Materias SET Nome = ? WHERE Nome = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nomeNovo); // Novo nome da matéria
            ps.setString(2, nomeAntigo); // Nome antigo da matéria

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Matéria atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma matéria encontrada com esse nome.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar matéria: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void Excluir(String Nome) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Materias WHERE Nome LIKE ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Nome + "%");
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Matéria deletada com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma matéria encontrada para deletar");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar matéria: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
}

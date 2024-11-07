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
 * @author Aluno
 */
public class ProfessorDAO {
    public void cadastrarResp(Professor P) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Professor (Id_Professor, CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, P.getId_Professor());
            ps.setString(2, P.getCPFp());
            ps.setString(3, P.getNomep());
            ps.setString(4, P.getEmailp());
            ps.setString(5, P.getSenhap());
            ps.setString(6, P.getData_Nascp());
            ps.setString(7, P.getEnderecop());
            ps.setString(8, P.getTelefonep());
            ps.setString(9, P.getGenerop());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
}

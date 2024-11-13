/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisescola_java.Objetos1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class AdmDAO {

    public void cadastrarAdm(Adm adm) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Administradores (CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero)VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, adm.getCPFAdm());
            ps.setString(2, adm.getNomeAdm());
            ps.setString(3, adm.getEmailAdm());
            ps.setString(4, adm.getSenhaAdm());
            ps.setString(5, adm.getData_NascAdm());
            ps.setString(6, adm.getEnderecoAdm());
            ps.setString(7, adm.getTelefoneAdm());
            ps.setString(8, adm.getGeneroAdm());
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public ResultSet Autenticaradm(Adm adm) {
        try {
            Connection con = ConnectionFactory.getConnection();

            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM Administradores WHERE CPF = ? and Senha = ?");
            ps.setString(1, adm.getCPFAdm());
            ps.setString(2, adm.getSenhaAdm());

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Este usuário não existe. " + ex);
        }
        return null;
    }
}

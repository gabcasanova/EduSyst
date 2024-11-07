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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Resp
 */
public class ResponsavelDAO {
    public List<Responsavel> consultar() throws ClassNotFoundException, SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Responsavel> resp = new ArrayList();
        try {
            ps = con.prepareStatement("SELECT * FROM Responsaveis");
            rs = ps.executeQuery();

            while (rs.next()) {
                Responsavel r = new Responsavel();
                r.setId_Resp(rs.getInt("Id_Responsavel"));
                r.setCPFResp(rs.getString("CPF"));
                r.setNomeResp(rs.getString("Nome"));
                r.setEmailResp(rs.getString("Email"));
                r.setData_NascResp(rs.getString("Data_Nasc"));
                r.setEnderecoResp(rs.getString("Endereco"));
                r.setTelefoneResp(rs.getString("Telefone"));
                r.setGeneroResp(rs.getString("Genero"));

                resp.add(r);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return resp;
    }
    public List<Responsavel> btconsultar(String nome, String cpf) throws ClassNotFoundException, SQLException {
        List<Responsavel> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();// Método para obter a conexão com o banco

        PreparedStatement stmt;
        if (cpf != null) {
            stmt = con.prepareStatement("SELECT * FROM Responsaveis WHERE CPF = ?");
            stmt.setString(1, cpf);
        } else {
            stmt = con.prepareStatement("SELECT * FROM Responsaveis WHERE Nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");
        }

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Responsavel r = new Responsavel();
            r.setId_Resp(rs.getInt("Id_Responsavel"));
            r.setCPFResp(rs.getString("CPF"));
            r.setNomeResp(rs.getString("Nome"));
            r.setEmailResp(rs.getString("Email"));
            r.setData_NascResp(rs.getString("Data_Nasc"));
            r.setEnderecoResp(rs.getString("Endereco"));
            r.setTelefoneResp(rs.getString("Telefone"));
            r.setGeneroResp(rs.getString("Genero"));
            lista.add(r);
        }

        rs.close();
        stmt.close();
        con.close();
        return lista;
    }
    public ResultSet listarGeneros() {
        Connection con;
        PreparedStatement ps = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT DISTINCT Genero FROM Responsaveis";
            try {
                ps = con.prepareStatement(sql);
                return ps.executeQuery();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na conexão");
                return null;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void Excluir(String Nome, String CPF) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Responsaveis WHERE Nome LIKE ? OR CPF = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Nome + "%");
            ps.setString(2, CPF);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Responsável deletado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum responsável encontrado para deletar");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void cadastrarResp(Responsavel r) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Responsaveis (Id_Responsavel, CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, r.getId_Resp());
            ps.setString(2, r.getCPFResp());
            ps.setString(3, r.getNomeResp());
            ps.setString(4, r.getEmailResp());
            ps.setString(5, r.getSenhaResp());
            ps.setString(6, r.getData_NascResp());
            ps.setString(7, r.getEnderecoResp());
            ps.setString(8, r.getTelefoneResp());
            ps.setString(9, r.getGeneroResp());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void AtualizarRespComSenha(Responsavel r) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza somente o aluno com o CPF fornecido
            String sql = "UPDATE Responsaveis SET CPF = ?, Nome = ?, Email = ?, Senha = ?, Data_Nasc = ?, Endereco = ?, Telefone = ?, Genero = ? WHERE CPF = ?";
            ps = con.prepareStatement(sql);

            // Define os parâmetros da query
            ps.setString(1, r.getCPFResp());
            ps.setString(2, r.getNomeResp());
            ps.setString(3, r.getEmailResp());
            ps.setString(4, r.getSenhaResp());
            ps.setString(5, r.getData_NascResp());
            ps.setString(6, r.getEnderecoResp());
            ps.setString(7, r.getTelefoneResp());
            ps.setString(8, r.getGeneroResp());
            ps.setString(9, r.getCPFResp());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Responsável atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum responsável encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
    public void AtualizarRespSemSenha(Responsavel r) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza somente o aluno com o CPF fornecido
            String sql = "UPDATE Responsaveis SET Nome = ?, Email = ?, Data_Nasc = ?, Endereco = ?, Telefone = ?, Genero = ? WHERE CPF = ?";
            ps = con.prepareStatement(sql);

            // Define os parâmetros da query
            
            ps.setString(1, r.getNomeResp());
            ps.setString(2, r.getEmailResp());
            ps.setString(3, r.getData_NascResp());
            ps.setString(4, r.getEnderecoResp());
            ps.setString(5, r.getTelefoneResp());
            ps.setString(6, r.getGeneroResp());
            ps.setString(7, r.getCPFResp());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Responsável atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum responsavel encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
}

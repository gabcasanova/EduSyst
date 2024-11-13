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
public class ProfessorDAO {

    public void cadastrarProf(Professor P) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Professores (Id_Professor, CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, P.getId_Professor());
            ps.setString(2, P.getCPFp());
            ps.setString(3, P.getNomep());
            ps.setString(4, P.getEmailp());
            ps.setString(5, P.getSenhap());
            ps.setString(6, P.getData_Nascp());
            ps.setString(7, P.getEnderecop());
            ps.setString(8, P.getTelefonep());
            ps.setString(9, P.getGenerop());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Professor criado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir professor.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public List<Professor> consultar() throws ClassNotFoundException, SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Professor> prof = new ArrayList();
        try {
            ps = con.prepareStatement("SELECT * FROM Professores");
            rs = ps.executeQuery();

            while (rs.next()) {
                Professor p = new Professor();
                p.setId_Professor(rs.getInt("Id_Professor"));
                p.setCPFp(rs.getString("CPF"));
                p.setNomep(rs.getString("Nome"));
                p.setEmailp(rs.getString("Email"));
                p.setData_Nascp(rs.getString("Data_Nasc"));
                p.setEnderecop(rs.getString("Endereco"));
                p.setTelefonep(rs.getString("Telefone"));
                p.setGenerop(rs.getString("Genero"));

                prof.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return prof;
    }

    public List<Professor> btconsultar(String nome, String cpf) throws ClassNotFoundException, SQLException {
        List<Professor> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();// Método para obter a conexão com o banco

        PreparedStatement stmt;
        if (cpf != null) {
            stmt = con.prepareStatement("SELECT * FROM Professores WHERE CPF = ?");
            stmt.setString(1, cpf);
        } else {
            stmt = con.prepareStatement("SELECT * FROM Professores WHERE Nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");
        }

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Professor p = new Professor();
            p.setId_Professor(rs.getInt("Id_Professor"));
            p.setCPFp(rs.getString("CPF"));
            p.setNomep(rs.getString("Nome"));
            p.setEmailp(rs.getString("Email"));
            p.setData_Nascp(rs.getString("Data_Nasc"));
            p.setEnderecop(rs.getString("Endereco"));
            p.setTelefonep(rs.getString("Telefone"));
            p.setGenerop(rs.getString("Genero"));
            lista.add(p);
        }

        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    public void AtualizarProfComSenha(Professor p) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza somente o aluno com o CPF fornecido
            String sql = "UPDATE Professores SET Nome = ?, Email = ?, Senha = ?, Data_Nasc = ?, Endereco = ?, Telefone = ?, Genero = ? = ? WHERE CPF = ?";
            ps = con.prepareStatement(sql);

            // Define os parâmetros da query
            ps.setString(1, p.getNomep());
            ps.setString(2, p.getEmailp());
            ps.setString(3, p.getSenhap());
            ps.setString(4, p.getData_Nascp());
            ps.setString(5, p.getEnderecop());
            ps.setString(6, p.getTelefonep());
            ps.setString(7, p.getGenerop());
            ps.setString(8, p.getCPFp()); // Usar CPF para identificar o aluno a ser atualizado// Executa a atualização
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum professor encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void AtualizarProfSemSenha(Professor p) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza somente o aluno com o CPF fornecido
            String sql = "UPDATE Professores SET Nome = ?, Email = ?, Data_Nasc = ?, Endereco = ?, Telefone = ?, Genero = ? WHERE CPF = ?";
            ps = con.prepareStatement(sql);

            // Define os parâmetros da query
            ps.setString(1, p.getNomep());
            ps.setString(2, p.getEmailp());
            ps.setString(3, p.getData_Nascp());
            ps.setString(4, p.getEnderecop());
            ps.setString(5, p.getTelefonep());
            ps.setString(6, p.getGenerop());
            ps.setString(7, p.getCPFp()); // Usar CPF para identificar o aluno a ser atualizado// Executa a atualização
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum professor encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void Excluir(String Nome, String CPF) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Professores WHERE Nome LIKE ? OR CPF = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Nome + "%");
            ps.setString(2, CPF);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Professor deletado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum professor encontrado para deletar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
}

package sisescola_java.Objetos1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sisescola_java.Objetos1.Aluno;
import sisescola_java.Objetos1.ConnectionFactory;

/**
 *
 * @author Matheus
 */
public class AlunoDAO {

    //Vetor do armazenamento do id do responsável pra combo box.
    public ResultSet listarResponsaveis() {
        Connection con;
        PreparedStatement ps = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT Id_Responsavel, Nome FROM Responsaveis ORDER BY Id_Responsavel ASC";
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

    

    public ResultSet listarGeneros() {
        Connection con;
        PreparedStatement ps = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SELECT DISTINCT Genero FROM Alunos";
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

    public List<Aluno> consultar() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();

        try {
            String sql = "SELECT a.*, t.Classe, r.Nome AS Nome_Responsavel "
                    + "FROM Alunos AS a "
                    + "JOIN Turmas_Alunos AS at ON a.Id_Aluno = at.Aluno_ID "
                    + "JOIN Turmas AS t ON t.Id_Turma = at.Turma_ID "
                    + "JOIN Responsaveis AS r ON a.Responsavel_ID = r.Id_Responsavel";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId_Aluno(rs.getInt("Id_Aluno"));
                aluno.setCPFAluno(rs.getString("CPF"));
                aluno.setNomeA(rs.getString("Nome"));
                aluno.setEmailA(rs.getString("Email"));
                aluno.setData_NascA(rs.getString("Data_Nasc"));
                aluno.setEnderecoA(rs.getString("Endereco"));
                aluno.setTelefoneA(rs.getString("Telefone"));
                aluno.setGeneroA(rs.getString("Genero"));
                // Adicionando a classe da turma e o nome do responsável diretamente
                aluno.setNomeResponsavel(rs.getString("Nome_Responsavel"));
                aluno.setClasseTurma(rs.getString("Classe")); // Se a classe for adicionada no modelo Aluno

                alunos.add(aluno);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        return alunos;
    }

    public String obterNomeResponsavel(int idResponsavel) throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT Nome FROM Responsaveis WHERE ID_Responsavel = ?");
        stmt.setInt(1, idResponsavel);
        ResultSet rs = stmt.executeQuery();
        String nome = null;
        if (rs.next()) {
            nome = rs.getString("Nome");
        }
        rs.close();
        stmt.close();
        con.close();
        return nome;
    }

    public String obterNomeTurma(int idTurma) throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT Classe FROM Turmas WHERE ID_Turma = ?");
        stmt.setInt(1, idTurma);
        ResultSet rs = stmt.executeQuery();
        String classe = null;
        if (rs.next()) {
            classe = rs.getString("Classe");
        }
        rs.close();
        stmt.close();
        con.close();
        return classe;
    }

    public List<Aluno> btconsultar(String nome, String cpf) throws ClassNotFoundException, SQLException {
        List<Aluno> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection(); // Método para obter a conexão com o banco

        PreparedStatement stmt;
        if (cpf != null && !cpf.isEmpty()) {
            stmt = con.prepareStatement(
                    "SELECT a.*, t.Classe, r.Nome AS Nome_Responsavel "
                    + "FROM Alunos a "
                    + "JOIN Turmas_Alunos ta ON a.Id_Aluno = ta.Aluno_ID "
                    + "JOIN Turmas t ON t.Id_Turma = ta.Turma_ID "
                    + "JOIN Responsaveis r ON a.Responsavel_ID = r.Id_Responsavel "
                    + "WHERE a.CPF = ?");
            stmt.setString(1, cpf);
        } else {
            stmt = con.prepareStatement(
                    "SELECT a.*, t.Classe, r.Nome AS Nome_Responsavel "
                    + "FROM Alunos a "
                    + "JOIN Turmas_Alunos ta ON a.Id_Aluno = ta.Aluno_ID "
                    + "JOIN Turmas t ON t.Id_Turma = ta.Turma_ID "
                    + "JOIN Responsaveis r ON a.Responsavel_ID = r.Id_Responsavel "
                    + "WHERE a.Nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");
        }

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setId_Aluno(rs.getInt("ID_Aluno"));
            a.setCPFAluno(rs.getString("CPF"));
            a.setNomeA(rs.getString("Nome"));
            a.setEmailA(rs.getString("Email"));
            a.setData_NascA(rs.getString("Data_Nasc"));
            a.setEnderecoA(rs.getString("Endereco"));
            a.setTelefoneA(rs.getString("Telefone"));
            a.setGeneroA(rs.getString("Genero"));

            // Agora adicionando as informações adicionais
            a.setClasseTurma(rs.getString("Classe")); // Classe da turma
            a.setNomeResponsavel(rs.getString("Nome_Responsavel")); // Nome do responsável

            lista.add(a);
        }

        rs.close();
        stmt.close();
        con.close();
        return lista;
    }

    public void Excluir(String Nome, String CPF) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Alunos WHERE Nome LIKE ? OR CPF = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Nome + "%");
            ps.setString(2, CPF);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado para deletar");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void cadastrarAluno(Aluno a) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO Alunos (Id_Aluno, CPF, Nome, Email, Senha, Data_Nasc, Endereco, Telefone, Genero, Responsavel_ID)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, a.getId_Aluno());
            ps.setString(2, a.getCPFAluno());
            ps.setString(3, a.getNomeA());
            ps.setString(4, a.getEmailA());
            ps.setString(5, a.getSenhaA());
            ps.setString(6, a.getDataA());
            ps.setString(7, a.getEnderecoA());
            ps.setString(8, a.getTelefoneA());
            ps.setString(9, a.getGeneroA());
            ps.setInt(10, a.getId_Responsavel());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void AtualizarAlunoComSenha(Aluno a) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza somente o aluno com o CPF fornecido
            String sql = "UPDATE Alunos SET Nome = ?, Email = ?, Senha = ?, Data_Nasc = ?, Endereco = ?, Telefone = ?, Genero = ?, Responsavel_ID = ? WHERE CPF = ?";
            ps = con.prepareStatement(sql);

            // Define os parâmetros da query
            ps.setString(1, a.getNomeA());
            ps.setString(2, a.getEmailA());
            ps.setString(3, a.getSenhaA());
            ps.setString(4, a.getDataA());
            ps.setString(5, a.getEnderecoA());
            ps.setString(6, a.getTelefoneA());
            ps.setString(7, a.getGeneroA());
            ps.setInt(8, a.getId_Responsavel());
            ps.setString(9, a.getCPFAluno()); // Usar CPF para identificar o aluno a ser atualizado// Executa a atualização
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void AtualizarAlunoSemSenha(Aluno a) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            // Atualiza somente o aluno com o CPF fornecido
            String sql = "UPDATE Alunos SET Nome = ?, Email = ?, Data_Nasc = ?, Endereco = ?, Telefone = ?, Genero = ?, Responsavel_ID = ? WHERE CPF = ?";
            ps = con.prepareStatement(sql);

            // Define os parâmetros da query
            ps.setString(1, a.getNomeA());
            ps.setString(2, a.getEmailA());
            ps.setString(3, a.getDataA());
            ps.setString(4, a.getEnderecoA());
            ps.setString(5, a.getTelefoneA());
            ps.setString(6, a.getGeneroA());
            ps.setInt(7, a.getId_Responsavel());
            ps.setString(8, a.getCPFAluno()); // Usar CPF para identificar o aluno a ser atualizado// Executa a atualização
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
}

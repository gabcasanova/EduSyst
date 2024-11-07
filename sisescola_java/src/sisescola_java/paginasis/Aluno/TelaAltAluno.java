/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sisescola_java.paginasis.Aluno;

import java.awt.Color;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sisescola_java.Objetos1.*;

/**
 *
 * @author Matheus
 */
public class TelaAltAluno extends javax.swing.JFrame {

    Vector<Integer> Id_Responsavel = new Vector<Integer>();

    private int getIdFromComboBox(JComboBox<String> comboBox, Vector<Integer> idList) {
        int index = comboBox.getSelectedIndex();
        if (index >= 0 && index < idList.size()) {
            return idList.get(index);
        }
        return -1; // Retorna -1 se não encontrar um ID válido
    }

    public void boxReps() {
        try {
            AlunoDAO ald = new AlunoDAO();
            ResultSet rs = ald.listarResponsaveis();

            if (rs == null) {
                JOptionPane.showMessageDialog(null, "Erro ao obter dados dos responsáveis.");
                return;
            }

            Id_Responsavel.clear(); // Limpa a lista existente
            boxRespAA.removeAllItems(); // Limpa a combobox

            while (rs.next()) {
                int idResponsavel = rs.getInt("Id_Responsavel");
                String nomeResponsavel = rs.getString("Nome");
                Id_Responsavel.addElement(idResponsavel);
                boxRespAA.addItem(nomeResponsavel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na combobox do responsável: " + e);
        }
    }

    public void selecionarResponsavel(int idResponsavel) {
        for (int i = 0; i < Id_Responsavel.size(); i++) {
            if (Id_Responsavel.get(i) == idResponsavel) {
                boxRespAA.setSelectedIndex(i);
                return;
            }
        }
        // Se não encontrar o ID, desmarcar a seleção
        boxRespAA.setSelectedIndex(-1);
    }

    

    public void boxGeneros() {
        try {
            AlunoDAO ald = new AlunoDAO();
            ResultSet rs = ald.listarGeneros();

            while (rs.next()) {
                String genero = rs.getString("Genero");
                if (boxGeneroAA.getItemCount() > 0 && !boxGeneroAA.getItemAt(0).equals(genero)) {
                    boxGeneroAA.addItem(genero);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na combobox do gênero: " + e);
        }
    }

    public void btconsulta(String pesquisa) {
        AlunoDAO adao = new AlunoDAO();
        try {
            // Verifica se a string de pesquisa é um CPF (números com 11 dígitos)
            if (pesquisa.matches("\\d{11}")) {
                // Consulta pelo CPF
                for (Aluno a : adao.btconsultar(null, pesquisa)) {

                    txtCPFAA.setText(a.getCPFAluno());
                    txtNomeAA.setText(a.getNomeA());
                    txtEmailAA.setText(a.getEmailA());
                    txtSenhaAA.setText("");
                    txtEnderecoAA.setText(a.getEnderecoA());
                    txtTelefoneAA.setText(a.getTelefoneA());
                    boxGeneroAA.setSelectedItem(String.valueOf(a.getGeneroA()));
                    String nomeResponsavel = adao.obterNomeResponsavel(a.getId_Responsavel());
                    boxRespAA.setSelectedItem(nomeResponsavel);
                }
            } else {
                // Consulta pelo Nome
                for (Aluno a : adao.btconsultar(pesquisa, null)) {

                    txtCPFAA.setText(a.getCPFAluno());
                    txtNomeAA.setText(a.getNomeA());
                    txtEmailAA.setText(a.getEmailA());
                    txtSenhaAA.setText("");
                    txtDiaAA.setText(String.valueOf(a.getDiaA()));
                    txtMesAA.setText(String.valueOf(a.getMesA()));
                    txtAnoAA.setText(String.valueOf(a.getAnoA()));
                    txtEnderecoAA.setText(a.getEnderecoA());
                    txtTelefoneAA.setText(a.getTelefoneA());
                    boxGeneroAA.setSelectedItem(String.valueOf(a.getGeneroA()));
                    String nomeResponsavel = adao.obterNomeResponsavel(a.getId_Responsavel());
                    boxRespAA.setSelectedItem(nomeResponsavel);

                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TelaConsAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form TelaAltAluno
     */
    public TelaAltAluno() {
        initComponents();
        boxReps();
        boxGeneros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipalC = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCPFAA = new javax.swing.JTextField();
        txtEmailAA = new javax.swing.JTextField();
        txtNomeAA = new javax.swing.JTextField();
        txtDiaAA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMesAA = new javax.swing.JTextField();
        txtAnoAA = new javax.swing.JTextField();
        txtEnderecoAA = new javax.swing.JTextField();
        txtTelefoneAA = new javax.swing.JTextField();
        boxGeneroAA = new javax.swing.JComboBox<>();
        boxRespAA = new javax.swing.JComboBox<>();
        btnVoltarAltA = new javax.swing.JButton();
        btAlterarA = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btLimparA = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSenhaAA = new javax.swing.JTextField();
        btPesquisaAlt = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtPesquisarAlt = new javax.swing.JTextField();
        pnlTopoC = new javax.swing.JPanel();
        lblTopoC = new javax.swing.JLabel();
        pnlBottomC = new javax.swing.JPanel();
        lblBottomC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlPrincipalC.setBackground(new java.awt.Color(142, 202, 230));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 48, 71));
        jLabel2.setText("Insira o Nome ou CPF do aluno:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 48, 71));
        jLabel3.setText("Gênero:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(2, 48, 71));
        jLabel4.setText("Endereço:");

        jLabel5.setBackground(new java.awt.Color(2, 48, 71));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 48, 71));
        jLabel5.setText("Nome:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(2, 48, 71));
        jLabel6.setText("Nascimento:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(2, 48, 71));
        jLabel7.setText("E-mail:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(2, 48, 71));
        jLabel8.setText("Responsável:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(2, 48, 71));
        jLabel9.setText("Telefone:");

        txtCPFAA.setEditable(false);
        txtCPFAA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCPFAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFAAActionPerformed(evt);
            }
        });

        txtNomeAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAAActionPerformed(evt);
            }
        });

        txtDiaAA.setForeground(new java.awt.Color(2, 48, 71));
        txtDiaAA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDiaAA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(2, 48, 71));
        jLabel10.setText("/");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 48, 71));
        jLabel11.setText("/");

        txtMesAA.setForeground(new java.awt.Color(2, 48, 71));
        txtMesAA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMesAA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMesAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesAAActionPerformed(evt);
            }
        });

        txtAnoAA.setForeground(new java.awt.Color(2, 48, 71));
        txtAnoAA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnoAA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAnoAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoAAActionPerformed(evt);
            }
        });

        boxGeneroAA.setForeground(new java.awt.Color(2, 48, 71));
        boxGeneroAA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Homem Trans", "Mulher Trans", "Não Binário", "Outro" }));
        boxGeneroAA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boxGeneroAA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boxGeneroAAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxGeneroAAMouseExited(evt);
            }
        });
        boxGeneroAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGeneroAAActionPerformed(evt);
            }
        });

        boxRespAA.setForeground(new java.awt.Color(2, 48, 71));
        boxRespAA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione" }));
        boxRespAA.setToolTipText("Selecione");
        boxRespAA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boxRespAA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boxRespAAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxRespAAMouseExited(evt);
            }
        });
        boxRespAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxRespAAActionPerformed(evt);
            }
        });

        btnVoltarAltA.setBackground(new java.awt.Color(142, 202, 230));
        btnVoltarAltA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/voltar.png"))); // NOI18N
        btnVoltarAltA.setToolTipText("Voltar");
        btnVoltarAltA.setBorder(null);
        btnVoltarAltA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarAltAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarAltAMouseExited(evt);
            }
        });
        btnVoltarAltA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarAltAActionPerformed(evt);
            }
        });

        btAlterarA.setBackground(new java.awt.Color(142, 202, 230));
        btAlterarA.setForeground(new java.awt.Color(2, 48, 71));
        btAlterarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Alterar.png"))); // NOI18N
        btAlterarA.setToolTipText("Alterar");
        btAlterarA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 5, true));
        btAlterarA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAlterarAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAlterarAMouseExited(evt);
            }
        });
        btAlterarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarAActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 48, 71));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ALTERAR ALUNO");

        btLimparA.setBackground(new java.awt.Color(142, 202, 230));
        btLimparA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Limpar.png"))); // NOI18N
        btLimparA.setToolTipText("Limpar");
        btLimparA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        btLimparA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btLimparAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btLimparAMouseExited(evt);
            }
        });
        btLimparA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparAActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(2, 48, 71));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("LIMPAR");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(2, 48, 71));
        jLabel14.setText("Senha:");

        btPesquisaAlt.setText("PESQUISAR");
        btPesquisaAlt.setToolTipText("Pesquisar");
        btPesquisaAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaAltActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(2, 48, 71));
        jLabel15.setText("CPF:");

        txtPesquisarAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarAltActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalCLayout = new javax.swing.GroupLayout(pnlPrincipalC);
        pnlPrincipalC.setLayout(pnlPrincipalCLayout);
        pnlPrincipalCLayout.setHorizontalGroup(
            pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltarAltA)
                .addGap(38, 38, 38)
                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailAA)
                                    .addComponent(txtNomeAA)))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDiaAA, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMesAA, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnoAA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCPFAA, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEnderecoAA, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefoneAA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxGeneroAA, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxRespAA, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtSenhaAA)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(btLimparA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAlterarA, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(56, 56, 56)))
                        .addGap(89, 89, 89))
                    .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisarAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisaAlt)
                        .addContainerGap(213, Short.MAX_VALUE))))
        );
        pnlPrincipalCLayout.setVerticalGroup(
            pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                        .addComponent(btnVoltarAltA)
                        .addContainerGap(451, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalCLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPesquisarAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPesquisaAlt))
                        .addGap(30, 30, 30)
                        .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtCPFAA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtNomeAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtEmailAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtSenhaAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtDiaAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(txtMesAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnoAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtEnderecoAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtTelefoneAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boxGeneroAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(boxRespAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAlterarA, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLimparA, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))))
        );

        pnlTopoC.setBackground(new java.awt.Color(2, 48, 71));
        pnlTopoC.setMinimumSize(new java.awt.Dimension(800, 100));

        lblTopoC.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTopoC.setForeground(new java.awt.Color(251, 133, 0));
        lblTopoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopoC.setText("Alterar");
        lblTopoC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlTopoCLayout = new javax.swing.GroupLayout(pnlTopoC);
        pnlTopoC.setLayout(pnlTopoCLayout);
        pnlTopoCLayout.setHorizontalGroup(
            pnlTopoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoCLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(lblTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        pnlTopoCLayout.setVerticalGroup(
            pnlTopoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoCLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlBottomC.setBackground(new java.awt.Color(2, 48, 71));
        pnlBottomC.setPreferredSize(new java.awt.Dimension(499, 100));

        lblBottomC.setBackground(new java.awt.Color(251, 133, 0));
        lblBottomC.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblBottomC.setForeground(new java.awt.Color(251, 133, 0));
        lblBottomC.setText("SYST");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 44)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(142, 202, 230));
        jLabel1.setText("edu");

        javax.swing.GroupLayout pnlBottomCLayout = new javax.swing.GroupLayout(pnlBottomC);
        pnlBottomC.setLayout(pnlBottomCLayout);
        pnlBottomCLayout.setHorizontalGroup(
            pnlBottomCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(lblBottomC)
                .addGap(352, 352, 352))
        );
        pnlBottomCLayout.setVerticalGroup(
            pnlBottomCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomCLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlBottomCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBottomC)
                    .addComponent(jLabel1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBottomC, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addComponent(pnlPrincipalC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlPrincipalC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlBottomC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAAActionPerformed

    private void boxGeneroAAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxGeneroAAMouseEntered
        boxGeneroAA.setForeground(new Color(251, 133, 0));
    }//GEN-LAST:event_boxGeneroAAMouseEntered

    private void boxGeneroAAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxGeneroAAMouseExited
        boxGeneroAA.setForeground(new Color(2, 48, 71));
    }//GEN-LAST:event_boxGeneroAAMouseExited

    private void boxRespAAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxRespAAMouseEntered
        boxRespAA.setForeground(new Color(251, 133, 0));
    }//GEN-LAST:event_boxRespAAMouseEntered

    private void boxRespAAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxRespAAMouseExited
        boxRespAA.setForeground(new Color(2, 48, 71));
    }//GEN-LAST:event_boxRespAAMouseExited

    private void btnVoltarAltAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarAltAMouseEntered
        btnVoltarAltA.setBackground(new Color(251, 133, 0));
    }//GEN-LAST:event_btnVoltarAltAMouseEntered

    private void btnVoltarAltAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarAltAMouseExited
        btnVoltarAltA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btnVoltarAltAMouseExited

    private void btnVoltarAltAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarAltAActionPerformed
        TelaAluno a = new TelaAluno();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarAltAActionPerformed

    private void btAlterarAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarAMouseEntered
        btAlterarA.setBackground(new Color(251, 133, 0));
    }//GEN-LAST:event_btAlterarAMouseEntered

    private void btAlterarAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarAMouseExited
        btAlterarA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btAlterarAMouseExited

    private void btAlterarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarAActionPerformed
        Aluno a = new Aluno();
        AlunoDAO dao = new AlunoDAO();
        if (txtCPFAA.getText().equals("")
                || txtNomeAA.getText().equals("")
                || txtEmailAA.getText().equals("")
                || txtDiaAA.getText().equals("")
                || txtMesAA.getText().equals("")
                || txtAnoAA.getText().equals("")
                || txtEnderecoAA.getText().equals("")
                || txtTelefoneAA.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
            return;
        } else if (!txtCPFAA.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "O campo do CPF deve conter apenas números.");
            return;
        } else if (!txtNomeAA.getText().matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(null, "O campo do nome deve conter apenas letras.");
            return;
        } else if (!txtDiaAA.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "O campo do dia deve conter apenas números.");
            return;
        } else if (!txtMesAA.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "O campo do mês deve conter apenas números.");
            return;
        } else if (!txtAnoAA.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "O campo do ano deve conter apenas números.");
            return;
        } else if (!txtTelefoneAA.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "O campo do telefone deve conter apenas números sem formatação.");
            return;
        } else if (txtCPFAA.getText().length() != 11) {
            JOptionPane.showMessageDialog(null, "O CPF deve conter 11 números.");
            return;
        } else if (txtNomeAA.getText().length() >= 80) {
            JOptionPane.showMessageDialog(null, "O Nome deve conter menos que 80 caracteres.");
            return;
        } else if (txtDiaAA.getText().length() != 2) {
            JOptionPane.showMessageDialog(null, "O dia deve conter 2 números.");
            return;
        } else if (txtMesAA.getText().length() != 2) {
            JOptionPane.showMessageDialog(null, "O mês deve conter 2 números.");
            return;
        } else if (txtAnoAA.getText().length() != 4) {
            JOptionPane.showMessageDialog(null, "O ano deve conter 4 números.");
            return;
        } else if (txtTelefoneAA.getText().length() != 11) {
            JOptionPane.showMessageDialog(null, "O telefone deve conter 11 números.");
            return;
        } else {
            a.setCPFAluno(txtCPFAA.getText());
        }

        a.setNomeA(txtNomeAA.getText());
        a.setEmailA(txtEmailAA.getText());
        a.setSenhaA(txtSenhaAA.getText());
        

        try {
            int dia = Integer.parseInt(txtDiaAA.getText());
            int mes = Integer.parseInt(txtMesAA.getText());
            int ano = Integer.parseInt(txtAnoAA.getText());
            if (dia > 31 || dia == 0) {
                JOptionPane.showMessageDialog(null, "Dia inválido");
                return;
            } else if (mes > 12 || mes == 0) {
                JOptionPane.showMessageDialog(null, "Mês inválido");
                return;
            } else if (ano < 1944 || ano > 2024) {
                JOptionPane.showMessageDialog(null, "Ano inválido");
                return;
            } else {
                LocalDate data = LocalDate.of(ano, mes, dia);
                String dataFormatada = data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                a.setDataA(dataFormatada);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Dia, mês e ano devem ser números válidos.");
            return;
        }
        a.setEnderecoA(txtEnderecoAA.getText());
        a.setTelefoneA(txtTelefoneAA.getText());
        a.setGeneroA(boxGeneroAA.getSelectedItem().toString());
        a.setId_Responsavel(getIdFromComboBox(boxRespAA, Id_Responsavel));
        try {
            if(txtSenhaAA.getText().isBlank() || txtSenhaAA.getText().isEmpty()){
            dao.AtualizarAlunoSemSenha(a);
            }else{
            dao.AtualizarAlunoComSenha(a);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadAluno.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno: Classe não encontrada.");
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadAluno.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno: SQL exception.");
        }
    }//GEN-LAST:event_btAlterarAActionPerformed

    private void btLimparAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLimparAMouseEntered
        btLimparA.setBackground(new Color(251, 133, 0));
    }//GEN-LAST:event_btLimparAMouseEntered

    private void btLimparAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLimparAMouseExited
        btLimparA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btLimparAMouseExited

    private void btLimparAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparAActionPerformed
        txtCPFAA.setText("");
        txtNomeAA.setText("");
        txtEmailAA.setText("");
        txtSenhaAA.setText("");
        txtDiaAA.setText("");
        txtMesAA.setText("");
        txtAnoAA.setText("");
        txtEnderecoAA.setText("");
        txtTelefoneAA.setText("");
        boxGeneroAA.setSelectedIndex(0);
        boxRespAA.setSelectedIndex(0);
        txtPesquisarAlt.setText("");

    }//GEN-LAST:event_btLimparAActionPerformed

    private void btPesquisaAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaAltActionPerformed
        btconsulta(txtPesquisarAlt.getText());
    }//GEN-LAST:event_btPesquisaAltActionPerformed

    private void txtAnoAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoAAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoAAActionPerformed

    private void txtMesAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesAAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesAAActionPerformed

    private void boxGeneroAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGeneroAAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxGeneroAAActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void txtPesquisarAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarAltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarAltActionPerformed

    private void txtCPFAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFAAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFAAActionPerformed

    private void boxRespAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxRespAAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxRespAAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAltAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAltAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAltAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAltAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAltAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxGeneroAA;
    private javax.swing.JComboBox<String> boxRespAA;
    private javax.swing.JButton btAlterarA;
    private javax.swing.JButton btLimparA;
    private javax.swing.JButton btPesquisaAlt;
    private javax.swing.JButton btnVoltarAltA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBottomC;
    private javax.swing.JLabel lblTopoC;
    private javax.swing.JPanel pnlBottomC;
    private javax.swing.JPanel pnlPrincipalC;
    private javax.swing.JPanel pnlTopoC;
    private javax.swing.JTextField txtAnoAA;
    private javax.swing.JTextField txtCPFAA;
    private javax.swing.JTextField txtDiaAA;
    private javax.swing.JTextField txtEmailAA;
    private javax.swing.JTextField txtEnderecoAA;
    private javax.swing.JTextField txtMesAA;
    private javax.swing.JTextField txtNomeAA;
    private javax.swing.JTextField txtPesquisarAlt;
    private javax.swing.JTextField txtSenhaAA;
    private javax.swing.JTextField txtTelefoneAA;
    // End of variables declaration//GEN-END:variables
}

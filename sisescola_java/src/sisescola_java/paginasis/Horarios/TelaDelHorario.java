/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sisescola_java.paginasis.Horarios;

import sisescola_java.paginasis.Turmas.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sisescola_java.Objetos1.*;
import sisescola_java.paginasis.Responsavel.TelaConsResp;

/**
 *
 * @author Aluno
 */
public class TelaDelHorario extends javax.swing.JFrame {

    public void btconsulta(int pesquisa) {
        HorarioDAO tdao = new HorarioDAO();
        try {
            if (pesquisa != 0) {
                // Consulta pelo CPF
                Horario horario = tdao.consultarHorarioPorId(pesquisa); // Agora, obtém um único objeto Horario
                if (horario != null) {
                    lblIDHora.setText(String.valueOf(horario.getId_Horario()));
                    lblTurno.setText(String.valueOf(horario.getTurno()));
                    lblInicio.setText(horario.getInicio());
                    lblFim.setText(horario.getFim());
                    lblDia.setText(horario.getDia_Semana());
                } else {
                    JOptionPane.showMessageDialog(null, "Horário não encontrado!");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaAltTurma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaAltTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form TelaDelTurma
     */
    public TelaDelHorario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTopoC = new javax.swing.JPanel();
        lblTopoC = new javax.swing.JLabel();
        pnlPrincipalC1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnVoltarExcTurma = new javax.swing.JButton();
        btDeletarResp = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblIDHora = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblFim = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        txtPesquisaClasse = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btpesquisadeResp = new javax.swing.JButton();
        pnlBottomC = new javax.swing.JPanel();
        lblBottomC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Excluir Horários");

        pnlTopoC.setBackground(new java.awt.Color(2, 48, 71));
        pnlTopoC.setMinimumSize(new java.awt.Dimension(800, 100));

        lblTopoC.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTopoC.setForeground(new java.awt.Color(251, 133, 0));
        lblTopoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopoC.setText("Excluir");
        lblTopoC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlTopoCLayout = new javax.swing.GroupLayout(pnlTopoC);
        pnlTopoC.setLayout(pnlTopoCLayout);
        pnlTopoCLayout.setHorizontalGroup(
            pnlTopoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoCLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lblTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTopoCLayout.setVerticalGroup(
            pnlTopoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoCLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlPrincipalC1.setBackground(new java.awt.Color(142, 202, 230));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(2, 48, 71));
        jLabel8.setText("ID:");

        jLabel12.setBackground(new java.awt.Color(2, 48, 71));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 48, 71));
        jLabel12.setText("Início:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(2, 48, 71));
        jLabel14.setText("Dia:");

        btnVoltarExcTurma.setBackground(new java.awt.Color(142, 202, 230));
        btnVoltarExcTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/voltar.png"))); // NOI18N
        btnVoltarExcTurma.setToolTipText("Voltar");
        btnVoltarExcTurma.setBorder(null);
        btnVoltarExcTurma.setName(""); // NOI18N
        btnVoltarExcTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarExcTurmaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarExcTurmaMouseExited(evt);
            }
        });
        btnVoltarExcTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarExcTurmaActionPerformed(evt);
            }
        });

        btDeletarResp.setBackground(new java.awt.Color(142, 202, 230));
        btDeletarResp.setForeground(new java.awt.Color(2, 48, 71));
        btDeletarResp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btDeletarResp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 5, true));
        btDeletarResp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDeletarRespMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDeletarRespMouseExited(evt);
            }
        });
        btDeletarResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarRespActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(2, 48, 71));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("EXCLUIR HORÁRIO");

        lblIDHora.setBackground(new java.awt.Color(2, 48, 71));
        lblIDHora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIDHora.setForeground(new java.awt.Color(2, 48, 71));
        lblIDHora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIDHora.setText("ID");
        lblIDHora.setToolTipText("");
        lblIDHora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblIDHora.setPreferredSize(new java.awt.Dimension(18, 16));
        lblIDHora.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblIDHoraInputMethodTextChanged(evt);
            }
        });

        lblInicio.setBackground(new java.awt.Color(2, 48, 71));
        lblInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(2, 48, 71));
        lblInicio.setText("Início");

        lblFim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFim.setForeground(new java.awt.Color(2, 48, 71));
        lblFim.setText("Fim");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(2, 48, 71));
        jLabel18.setText("Turno:");

        lblTurno.setBackground(new java.awt.Color(2, 48, 71));
        lblTurno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(2, 48, 71));
        lblTurno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTurno.setText("Turno");
        lblTurno.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblTurnoInputMethodTextChanged(evt);
            }
        });

        txtPesquisaClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaClasseActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(2, 48, 71));
        jLabel19.setText("Insira o ID do horário:");

        btpesquisadeResp.setText("Pesquisar");
        btpesquisadeResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpesquisadeRespActionPerformed(evt);
            }
        });

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
            .addGroup(pnlBottomCLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(lblBottomC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBottomCLayout.setVerticalGroup(
            pnlBottomCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomCLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlBottomCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBottomC)
                    .addComponent(jLabel1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblDia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDia.setForeground(new java.awt.Color(2, 48, 71));
        lblDia.setText("Dia da semana");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(2, 48, 71));
        jLabel15.setText("Fim:");

        javax.swing.GroupLayout pnlPrincipalC1Layout = new javax.swing.GroupLayout(pnlPrincipalC1);
        pnlPrincipalC1.setLayout(pnlPrincipalC1Layout);
        pnlPrincipalC1Layout.setHorizontalGroup(
            pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltarExcTurma)
                .addGap(45, 45, 45)
                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                        .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFim, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lblIDHora, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDeletarResp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(138, 138, 138))
                    .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btpesquisadeResp)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(pnlBottomC, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );
        pnlPrincipalC1Layout.setVerticalGroup(
            pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnVoltarExcTurma)
                        .addGap(338, 338, 338))
                    .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtPesquisaClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btpesquisadeResp))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btDeletarResp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalC1Layout.createSequentialGroup()
                                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblIDHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(lblTurno))
                                .addGap(21, 21, 21)
                                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(lblInicio))
                                .addGap(21, 21, 21)
                                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFim)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPrincipalC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDia)
                                    .addComponent(jLabel14))))
                        .addGap(128, 128, 128)))
                .addComponent(pnlBottomC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, 783, Short.MAX_VALUE)
            .addComponent(pnlPrincipalC1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlPrincipalC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarExcTurmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarExcTurmaMouseEntered
        btnVoltarExcTurma.setBackground(new Color(251, 133, 0));
    }//GEN-LAST:event_btnVoltarExcTurmaMouseEntered

    private void btnVoltarExcTurmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarExcTurmaMouseExited
        btnVoltarExcTurma.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btnVoltarExcTurmaMouseExited

    private void btnVoltarExcTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarExcTurmaActionPerformed
        TelaHorarios t = new TelaHorarios();
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarExcTurmaActionPerformed

    private void btDeletarRespMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletarRespMouseEntered
        btDeletarResp.setBackground(new Color(251, 133, 0));
    }//GEN-LAST:event_btDeletarRespMouseEntered

    private void btDeletarRespMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletarRespMouseExited
        btDeletarResp.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btDeletarRespMouseExited

    private void btDeletarRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarRespActionPerformed
        HorarioDAO t = new HorarioDAO();
        int classes = lblInicio.getText().isEmpty() ? 0 : Integer.parseInt(lblInicio.getText());
        int ID = lblTurno.getText().isEmpty() ? 0 : Integer.parseInt(lblTurno.getText());

        if (classes == 0 && ID == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um ID para exclusão.");
            return;
        }
        try {
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir esse horário? Essa ação é irreversível.");
            if (i == JOptionPane.YES_OPTION) {
                t.Excluir(ID);

                lblIDHora.setText("");
                lblTurno.setText("");
                lblInicio.setText("");
                lblFim.setText("");
                txtPesquisaClasse.setText("");

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TelaConsResp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao excluir horário: " + ex.getMessage());
        }
        TelaConHorario tct = new TelaConHorario();
        tct.setVisible(true);
        dispose();
    }//GEN-LAST:event_btDeletarRespActionPerformed

    private void lblIDHoraInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblIDHoraInputMethodTextChanged

    }//GEN-LAST:event_lblIDHoraInputMethodTextChanged

    private void lblTurnoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblTurnoInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTurnoInputMethodTextChanged

    private void txtPesquisaClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaClasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaClasseActionPerformed

    private void btpesquisadeRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpesquisadeRespActionPerformed
        btconsulta(Integer.parseInt(txtPesquisaClasse.getText()));
    }//GEN-LAST:event_btpesquisadeRespActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDelHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDelHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDelHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDelHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDelHorario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeletarResp;
    private javax.swing.JButton btnVoltarExcTurma;
    private javax.swing.JButton btpesquisadeResp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblBottomC;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFim;
    private javax.swing.JLabel lblIDHora;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblTopoC;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel pnlBottomC;
    private javax.swing.JPanel pnlPrincipalC1;
    private javax.swing.JPanel pnlTopoC;
    private javax.swing.JTextField txtPesquisaClasse;
    // End of variables declaration//GEN-END:variables
}

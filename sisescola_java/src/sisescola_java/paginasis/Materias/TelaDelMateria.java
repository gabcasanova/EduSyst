/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sisescola_java.paginasis.Materias;

import sisescola_java.paginasis.Responsavel.*;
import sisescola_java.paginasis.Aluno.*;
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
public class TelaDelMateria extends javax.swing.JFrame {

    public void btconsulta(String pesquisa) {
        MateriasDAO mdao = new MateriasDAO();
        try {
            // Consulta pelo CPF
            for (Materias m : mdao.btconsultar(pesquisa)) {

                lblNomeMa.setText(m.getNome());
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TelaConsResp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form TelaAltAluno
     */
    public TelaDelMateria() {
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

        pnlPrincipalC = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnVoltarAltResp = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btPesquisaAltResp = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtPesquisarAltResp = new javax.swing.JTextField();
        pnlBottomC = new javax.swing.JPanel();
        lblBottomC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNomeMa = new javax.swing.JLabel();
        btDeletarA = new javax.swing.JButton();
        pnlTopoC = new javax.swing.JPanel();
        lblTopoC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Excluir Matéria");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlPrincipalC.setBackground(new java.awt.Color(142, 202, 230));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 48, 71));
        jLabel2.setText("Insira o nome da Matéria");

        btnVoltarAltResp.setBackground(new java.awt.Color(142, 202, 230));
        btnVoltarAltResp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/voltar.png"))); // NOI18N
        btnVoltarAltResp.setToolTipText("Voltar");
        btnVoltarAltResp.setBorder(null);
        btnVoltarAltResp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarAltRespMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarAltRespMouseExited(evt);
            }
        });
        btnVoltarAltResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarAltRespActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 48, 71));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("EXCLUIR MATÉRIA");

        btPesquisaAltResp.setText("PESQUISAR");
        btPesquisaAltResp.setToolTipText("Pesquisar");
        btPesquisaAltResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaAltRespActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(2, 48, 71));
        jLabel15.setText("Nome:");

        txtPesquisarAltResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarAltRespActionPerformed(evt);
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

        lblNomeMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomeMa.setForeground(new java.awt.Color(2, 48, 71));
        lblNomeMa.setText("Matéria");

        btDeletarA.setBackground(new java.awt.Color(142, 202, 230));
        btDeletarA.setForeground(new java.awt.Color(2, 48, 71));
        btDeletarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btDeletarA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 5, true));
        btDeletarA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDeletarAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDeletarAMouseExited(evt);
            }
        });
        btDeletarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalCLayout = new javax.swing.GroupLayout(pnlPrincipalC);
        pnlPrincipalC.setLayout(pnlPrincipalCLayout);
        pnlPrincipalCLayout.setHorizontalGroup(
            pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltarAltResp)
                .addGap(38, 38, 38)
                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisarAltResp, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisaAltResp)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalCLayout.createSequentialGroup()
                        .addGap(575, 575, 575)
                        .addComponent(btDeletarA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(96, 96, 96))
                    .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeMa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(110, 110, 110))))
            .addComponent(pnlBottomC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        pnlPrincipalCLayout.setVerticalGroup(
            pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                        .addComponent(btnVoltarAltResp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalCLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPesquisarAltResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPesquisaAltResp))
                        .addGap(30, 30, 30)
                        .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(lblNomeMa))
                            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btDeletarA, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)))
                .addComponent(pnlBottomC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTopoCLayout.setVerticalGroup(
            pnlTopoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoCLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPrincipalC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlPrincipalC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void txtPesquisarAltRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarAltRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarAltRespActionPerformed

    private void btPesquisaAltRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaAltRespActionPerformed
        btconsulta(txtPesquisarAltResp.getText());
    }//GEN-LAST:event_btPesquisaAltRespActionPerformed

    private void btnVoltarAltRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarAltRespActionPerformed
        TelaMaterias tlm = new TelaMaterias();
        tlm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarAltRespActionPerformed

    private void btnVoltarAltRespMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarAltRespMouseExited
        btnVoltarAltResp.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btnVoltarAltRespMouseExited

    private void btnVoltarAltRespMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarAltRespMouseEntered
        btnVoltarAltResp.setBackground(new Color(251, 133, 0));
    }//GEN-LAST:event_btnVoltarAltRespMouseEntered

    private void btDeletarAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletarAMouseEntered
        btDeletarA.setBackground(new Color(251, 133, 0));
    }//GEN-LAST:event_btDeletarAMouseEntered

    private void btDeletarAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeletarAMouseExited
        btDeletarA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btDeletarAMouseExited

    private void btDeletarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarAActionPerformed
        MateriasDAO M = new MateriasDAO();
        String nome = lblNomeMa.getText();

        if ((nome.isEmpty() || nome.equals("Nome"))) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um nome para exclusão.");
            return;
        }
        try {
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir esta matéria? Essa ação é irreversível");
            if (i == JOptionPane.YES_OPTION) {
                M.Excluir(nome);
                M.btconsultar(""); // Atualiza a tabela após a exclusão
                lblNomeMa.setText("");
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TelaConsAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btDeletarAActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDelMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDelMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDelMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDelMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDelMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeletarA;
    private javax.swing.JButton btPesquisaAltResp;
    private javax.swing.JButton btnVoltarAltResp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBottomC;
    private javax.swing.JLabel lblNomeMa;
    private javax.swing.JLabel lblTopoC;
    private javax.swing.JPanel pnlBottomC;
    private javax.swing.JPanel pnlPrincipalC;
    private javax.swing.JPanel pnlTopoC;
    private javax.swing.JTextField txtPesquisarAltResp;
    // End of variables declaration//GEN-END:variables
}

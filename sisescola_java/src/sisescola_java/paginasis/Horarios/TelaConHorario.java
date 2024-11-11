/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sisescola_java.paginasis.Horarios;

import java.awt.BorderLayout;
import sisescola_java.paginasis.Turmas.*;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sisescola_java.Objetos1.*;

/**
 *
 * @author Aluno
 */
public class TelaConHorario extends javax.swing.JFrame {

    // Configuração da tabela
    private void carregarHorarios() {

        HorarioDAO horariosDAO = new HorarioDAO();
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblConsulta.getModel();
            modelo.setNumRows(0);
            // Adiciona cada horário à tabela
            for (Horario h : horariosDAO.consultarTodosHorarios()) {
                modelo.addRow(new Object[]{
                    h.getId_Horario(),
                    h.getTurno(),
                    h.getInicio(),
                    h.getFim(),
                    h.getDia_Semana()
                });
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar horários: " + ex.getMessage());
        }
    }

    public TelaConHorario() {
        setLocationRelativeTo(null);
        initComponents();
        carregarHorarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTopoC = new javax.swing.JPanel();
        lblTopoC = new javax.swing.JLabel();
        pnlBottomC = new javax.swing.JPanel();
        lblBottomC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlPrincipalC = new javax.swing.JPanel();
        btnVoltarConA = new javax.swing.JButton();
        lblIDTurma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar Horários");
        setLocation(new java.awt.Point(480, 270));

        pnlTopoC.setBackground(new java.awt.Color(2, 48, 71));
        pnlTopoC.setMinimumSize(new java.awt.Dimension(800, 100));

        lblTopoC.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTopoC.setForeground(new java.awt.Color(251, 133, 0));
        lblTopoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopoC.setText("Consultar");
        lblTopoC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlTopoCLayout = new javax.swing.GroupLayout(pnlTopoC);
        pnlTopoC.setLayout(pnlTopoCLayout);
        pnlTopoCLayout.setHorizontalGroup(
            pnlTopoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoCLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(lblTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
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
                .addGap(261, 261, 261))
        );
        pnlBottomCLayout.setVerticalGroup(
            pnlBottomCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomCLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlBottomCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBottomC)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15))
        );

        pnlPrincipalC.setBackground(new java.awt.Color(142, 202, 230));

        btnVoltarConA.setBackground(new java.awt.Color(142, 202, 230));
        btnVoltarConA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/voltar.png"))); // NOI18N
        btnVoltarConA.setToolTipText("Voltar");
        btnVoltarConA.setBorder(null);
        btnVoltarConA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarConAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarConAMouseExited(evt);
            }
        });
        btnVoltarConA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarConAActionPerformed(evt);
            }
        });

        lblIDTurma.setFont(new java.awt.Font("Segoe UI", 1, 2)); // NOI18N
        lblIDTurma.setForeground(new java.awt.Color(2, 48, 71));
        lblIDTurma.setText("IDTURMA");

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_Horario", "Turno", "Inicio", "Fim", "Dia_Semana"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblConsulta);

        javax.swing.GroupLayout pnlPrincipalCLayout = new javax.swing.GroupLayout(pnlPrincipalC);
        pnlPrincipalC.setLayout(pnlPrincipalCLayout);
        pnlPrincipalCLayout.setHorizontalGroup(
            pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltarConA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(lblIDTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPrincipalCLayout.setVerticalGroup(
            pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalCLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(btnVoltarConA)
                .addGap(356, 356, 356))
            .addGroup(pnlPrincipalCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPrincipalCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTopoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBottomC, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
            .addComponent(pnlPrincipalC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTopoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlPrincipalC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlBottomC, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarConAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarConAMouseEntered
        btnVoltarConA.setBackground(new Color(251, 133, 0));
    }//GEN-LAST:event_btnVoltarConAMouseEntered

    private void btnVoltarConAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarConAMouseExited
        btnVoltarConA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btnVoltarConAMouseExited

    private void btnVoltarConAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarConAActionPerformed
        TelaHorarios t = new TelaHorarios();
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarConAActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConHorario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltarConA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBottomC;
    private javax.swing.JLabel lblIDTurma;
    private javax.swing.JLabel lblTopoC;
    private javax.swing.JPanel pnlBottomC;
    private javax.swing.JPanel pnlPrincipalC;
    private javax.swing.JPanel pnlTopoC;
    private javax.swing.JTable tblConsulta;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sisescola_java.paginasis.Materias;

import sisescola_java.paginasis.Turmas.TelaEnturmar;
import java.awt.Color;
import sisescola_java.paginasis.TelaCRUDS;

/**
 *
 * @author Matheus
 */
public class TelaMaterias extends javax.swing.JFrame {

    /**
     * Creates new form TelaMaterias
     */
    public TelaMaterias() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTopoM = new javax.swing.JPanel();
        lblTopoM = new javax.swing.JLabel();
        pnlBottomM = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblBottomC = new javax.swing.JLabel();
        pnlPrincipalM = new javax.swing.JPanel();
        btCadastrarA = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btConsultarA = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btExcluirA = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btAlterarA = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btVoltarM = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlTopoM.setBackground(new java.awt.Color(2, 48, 71));

        lblTopoM.setBackground(new java.awt.Color(251, 133, 0));
        lblTopoM.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTopoM.setForeground(new java.awt.Color(251, 133, 0));
        lblTopoM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopoM.setText("Matérias");
        lblTopoM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlTopoMLayout = new javax.swing.GroupLayout(pnlTopoM);
        pnlTopoM.setLayout(pnlTopoMLayout);
        pnlTopoMLayout.setHorizontalGroup(
            pnlTopoMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoMLayout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(lblTopoM)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTopoMLayout.setVerticalGroup(
            pnlTopoMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopoMLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTopoM)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlBottomM.setBackground(new java.awt.Color(2, 48, 71));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 44)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(142, 202, 230));
        jLabel1.setText("edu");

        lblBottomC.setBackground(new java.awt.Color(251, 133, 0));
        lblBottomC.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblBottomC.setForeground(new java.awt.Color(251, 133, 0));
        lblBottomC.setText("SYST");

        javax.swing.GroupLayout pnlBottomMLayout = new javax.swing.GroupLayout(pnlBottomM);
        pnlBottomM.setLayout(pnlBottomMLayout);
        pnlBottomMLayout.setHorizontalGroup(
            pnlBottomMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomMLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(lblBottomC)
                .addGap(306, 306, 306))
        );
        pnlBottomMLayout.setVerticalGroup(
            pnlBottomMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomMLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlBottomMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBottomC)
                    .addComponent(jLabel1))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlPrincipalM.setBackground(new java.awt.Color(142, 202, 230));
        pnlPrincipalM.setForeground(new java.awt.Color(204, 204, 204));

        btCadastrarA.setBackground(new java.awt.Color(142, 202, 230));
        btCadastrarA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btCadastrarA.setForeground(new java.awt.Color(2, 48, 71));
        btCadastrarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/Cadastar.png"))); // NOI18N
        btCadastrarA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 3, true));
        btCadastrarA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCadastrarAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCadastrarAMouseExited(evt);
            }
        });
        btCadastrarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarAActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(2, 48, 71));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 48, 71));
        jLabel2.setText("Criar");

        btConsultarA.setBackground(new java.awt.Color(142, 202, 230));
        btConsultarA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btConsultarA.setForeground(new java.awt.Color(2, 48, 71));
        btConsultarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/Consultar.png"))); // NOI18N
        btConsultarA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 48, 71), 3));
        btConsultarA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btConsultarAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btConsultarAMouseExited(evt);
            }
        });
        btConsultarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarAActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 48, 71));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Consultar");

        btExcluirA.setBackground(new java.awt.Color(142, 202, 230));
        btExcluirA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btExcluirA.setForeground(new java.awt.Color(2, 48, 71));
        btExcluirA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/Excluir.png"))); // NOI18N
        btExcluirA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 48, 71), 3));
        btExcluirA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btExcluirAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btExcluirAMouseExited(evt);
            }
        });
        btExcluirA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirAActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 48, 71));
        jLabel5.setText("Excluir");

        btAlterarA.setBackground(new java.awt.Color(142, 202, 230));
        btAlterarA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btAlterarA.setForeground(new java.awt.Color(2, 48, 71));
        btAlterarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/Alterar.png"))); // NOI18N
        btAlterarA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 48, 71), 3));
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(2, 48, 71));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Alterar");

        btVoltarM.setBackground(new java.awt.Color(142, 202, 230));
        btVoltarM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btVoltarM.setForeground(new java.awt.Color(2, 48, 71));
        btVoltarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/voltar.png"))); // NOI18N
        btVoltarM.setToolTipText("Voltar");
        btVoltarM.setBorder(null);
        btVoltarM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btVoltarMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btVoltarMMouseExited(evt);
            }
        });
        btVoltarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarMActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(142, 202, 230));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagensbotãopequeno/Enturmar.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(2, 48, 71), 5));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(2, 48, 71));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(2, 48, 71));
        jLabel6.setText("Enturmar");

        javax.swing.GroupLayout pnlPrincipalMLayout = new javax.swing.GroupLayout(pnlPrincipalM);
        pnlPrincipalM.setLayout(pnlPrincipalMLayout);
        pnlPrincipalMLayout.setHorizontalGroup(
            pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltarM)
                .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27))
                    .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btAlterarA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btCadastrarA, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(71, 71, 71))
                            .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)))
                        .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalMLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(57, 57, 57))
                                    .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(74, 74, 74)))
                                .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btExcluirA)
                                    .addComponent(btConsultarA)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalMLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(11, 11, 11)))))
                .addGap(171, 171, 171))
        );
        pnlPrincipalMLayout.setVerticalGroup(
            pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalMLayout.createSequentialGroup()
                .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btConsultarA))
                                    .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btCadastrarA))))
                            .addGroup(pnlPrincipalMLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btVoltarM)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btExcluirA)
                    .addComponent(btAlterarA))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlPrincipalM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTopoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBottomM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlTopoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlPrincipalM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlBottomM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void btCadastrarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarAActionPerformed
        TelaCadMateria tcm = new TelaCadMateria();
        tcm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btCadastrarAActionPerformed

    private void btAlterarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarAActionPerformed
        TelaAltMateria tam = new TelaAltMateria();
        tam.setVisible(true);
        dispose();
    }//GEN-LAST:event_btAlterarAActionPerformed

    private void btVoltarMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMMouseEntered
        btVoltarM.setBackground(new Color(251,133,0));
    }//GEN-LAST:event_btVoltarMMouseEntered

    private void btVoltarMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMMouseExited
        btVoltarM.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btVoltarMMouseExited

    private void btVoltarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarMActionPerformed
        TelaCRUDS CRUD = new TelaCRUDS();
        CRUD.setVisible(true);
        dispose();
    }//GEN-LAST:event_btVoltarMActionPerformed

    private void btExcluirAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirAMouseEntered
        btExcluirA.setBackground(new Color(251,133,0));
    }//GEN-LAST:event_btExcluirAMouseEntered

    private void btExcluirAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirAMouseExited
        btExcluirA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btExcluirAMouseExited

    private void btConsultarAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConsultarAMouseEntered
        btConsultarA.setBackground(new Color(251,133,0));
    }//GEN-LAST:event_btConsultarAMouseEntered

    private void btConsultarAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConsultarAMouseExited
        btConsultarA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btConsultarAMouseExited

    private void btCadastrarAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCadastrarAMouseEntered
        btCadastrarA.setBackground(new Color(251,133,0));
    }//GEN-LAST:event_btCadastrarAMouseEntered

    private void btCadastrarAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCadastrarAMouseExited
        btCadastrarA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btCadastrarAMouseExited

    private void btAlterarAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarAMouseEntered
        btAlterarA.setBackground(new Color(251,133,0));
    }//GEN-LAST:event_btAlterarAMouseEntered

    private void btAlterarAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarAMouseExited
        btAlterarA.setBackground(new Color(142, 202, 230));
    }//GEN-LAST:event_btAlterarAMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaEnturmar te = new TelaEnturmar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btConsultarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarAActionPerformed
        TelaConsMateria tcom = new TelaConsMateria();
        tcom.setVisible(true);
        dispose();
    }//GEN-LAST:event_btConsultarAActionPerformed

    private void btExcluirAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirAActionPerformed
        TelaDelMateria tdm = new TelaDelMateria();
        tdm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btExcluirAActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMaterias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarA;
    private javax.swing.JButton btCadastrarA;
    private javax.swing.JButton btConsultarA;
    private javax.swing.JButton btExcluirA;
    private javax.swing.JButton btVoltarM;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblBottomC;
    private javax.swing.JLabel lblTopoM;
    private javax.swing.JPanel pnlBottomM;
    private javax.swing.JPanel pnlPrincipalM;
    private javax.swing.JPanel pnlTopoM;
    // End of variables declaration//GEN-END:variables
}
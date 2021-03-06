/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.OcorrenciaDAO;
import dao.SalvamentoDAO;
import dao.VeiculoDAO;
import database.Utilitarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Ocorrencia;
import model.Salvamento;
import model.Veiculo;

/**
 *
 * @author Talita vitoria, Felipe Tobias, Iara Oliveira e Vinicius Donschen
 */
public class JFrameCadastroSalvamento extends javax.swing.JFrame {

    /**
     * Creates new form JFrameCadastroSalvamento
     */
    public JFrameCadastroSalvamento() {
        initComponents();
        popularComponentes();
    }

    public JFrameCadastroSalvamento(Salvamento salvamento) {
        initComponents();
        popularComponentes();
        jLabelFKOcorrencia.setText(String.valueOf(salvamento.getFKOcorrencia().getIdOcorrencia()));
        if (salvamento.getIdSalvamento() > 0) {
            jLabelIdSalvamento.setText(String.valueOf(salvamento.getIdSalvamento()));
        }
        if (!jTextFieldDataSalvamento.getText().equals("")) {
            jTextFieldDataSalvamento.setText(Utilitarios.retornarPadraoBR(salvamento.getDataSalvamento()));
        }

        jTextFieldHoraSalvamento.setText(salvamento.getHoraSalvamento());
        jTextFieldLocalSalvamento.setText(salvamento.getLocalSalvamento());
        jTextFieldJesusSalvador.setText(salvamento.getJesusSalvador());
        jLabelDescricao.setText(salvamento.getFKOcorrencia().getDescricaoOcorrencia());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCodOcorrencia = new javax.swing.JLabel();
        jLabelCodSalvamento = new javax.swing.JLabel();
        jLabelDataSalvamento = new javax.swing.JLabel();
        jLabelHoraSalvamento = new javax.swing.JLabel();
        jLabelLocalSalvamento = new javax.swing.JLabel();
        jLabelJesusSalvador = new javax.swing.JLabel();
        jLabelVeiculoSalvamento = new javax.swing.JLabel();
        jTextFieldDataSalvamento = new javax.swing.JTextField();
        jTextFieldHoraSalvamento = new javax.swing.JTextField();
        jTextFieldLocalSalvamento = new javax.swing.JTextField();
        jTextFieldJesusSalvador = new javax.swing.JTextField();
        jComboBoxVeiculoSalvamento = new javax.swing.JComboBox();
        jButtonSalvarSalvamento = new javax.swing.JButton();
        jLabelFKOcorrencia = new javax.swing.JLabel();
        jLabelIdSalvamento = new javax.swing.JLabel();
        jLabelCadastroSalvamento = new javax.swing.JLabel();
        jButtonCancelarOcorrencia = new javax.swing.JButton();
        jLabelDescricaoOcorrencia = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCodOcorrencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCodOcorrencia.setForeground(new java.awt.Color(81, 81, 81));
        jLabelCodOcorrencia.setText("Cod. Ocorrencia");

        jLabelCodSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCodSalvamento.setForeground(new java.awt.Color(81, 81, 81));
        jLabelCodSalvamento.setText("Cod. Salvamento");

        jLabelDataSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDataSalvamento.setForeground(new java.awt.Color(81, 81, 81));
        jLabelDataSalvamento.setText("Data");

        jLabelHoraSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraSalvamento.setForeground(new java.awt.Color(81, 81, 81));
        jLabelHoraSalvamento.setText("Hora");

        jLabelLocalSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLocalSalvamento.setForeground(new java.awt.Color(81, 81, 81));
        jLabelLocalSalvamento.setText("Local");

        jLabelJesusSalvador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelJesusSalvador.setForeground(new java.awt.Color(81, 81, 81));
        jLabelJesusSalvador.setText("Nome do veterinário");

        jLabelVeiculoSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelVeiculoSalvamento.setForeground(new java.awt.Color(81, 81, 81));
        jLabelVeiculoSalvamento.setText("Veiculo utilizado");

        jTextFieldDataSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDataSalvamento.setForeground(new java.awt.Color(81, 81, 81));

        jTextFieldHoraSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldHoraSalvamento.setForeground(new java.awt.Color(81, 81, 81));

        jTextFieldLocalSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldLocalSalvamento.setForeground(new java.awt.Color(81, 81, 81));

        jTextFieldJesusSalvador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldJesusSalvador.setForeground(new java.awt.Color(81, 81, 81));

        jComboBoxVeiculoSalvamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxVeiculoSalvamento.setForeground(new java.awt.Color(81, 81, 81));

        jButtonSalvarSalvamento.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButtonSalvarSalvamento.setForeground(new java.awt.Color(81, 81, 81));
        jButtonSalvarSalvamento.setText("Salvar");
        jButtonSalvarSalvamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarSalvamentoActionPerformed(evt);
            }
        });

        jLabelCadastroSalvamento.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelCadastroSalvamento.setForeground(new java.awt.Color(81, 81, 81));
        jLabelCadastroSalvamento.setText("CADASTRO SALVAMENTO REALIZADO");

        jButtonCancelarOcorrencia.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButtonCancelarOcorrencia.setForeground(new java.awt.Color(81, 81, 81));
        jButtonCancelarOcorrencia.setText("Cancelar");
        jButtonCancelarOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarOcorrenciaActionPerformed(evt);
            }
        });

        jLabelDescricaoOcorrencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDescricaoOcorrencia.setForeground(new java.awt.Color(81, 81, 81));
        jLabelDescricaoOcorrencia.setText("Descrição da Ocorrência");

        jLabelDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDescricao.setForeground(new java.awt.Color(81, 81, 81));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSalvarSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelarOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIdSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelHoraSalvamento)
                                        .addComponent(jLabelDataSalvamento)
                                        .addComponent(jTextFieldHoraSalvamento, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                        .addComponent(jLabelFKOcorrencia)
                                        .addComponent(jLabelCodOcorrencia)
                                        .addComponent(jTextFieldDataSalvamento))
                                    .addComponent(jLabelCodSalvamento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelVeiculoSalvamento)
                                    .addComponent(jLabelJesusSalvador)
                                    .addComponent(jTextFieldJesusSalvador, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(jLabelLocalSalvamento)
                                    .addComponent(jTextFieldLocalSalvamento)
                                    .addComponent(jComboBoxVeiculoSalvamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(117, 117, 117))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDescricaoOcorrencia)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCadastroSalvamento)
                            .addComponent(jLabelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelCadastroSalvamento)
                .addGap(53, 53, 53)
                .addComponent(jLabelCodOcorrencia)
                .addGap(4, 4, 4)
                .addComponent(jLabelFKOcorrencia)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelLocalSalvamento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldLocalSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelCodSalvamento))
                            .addGap(152, 152, 152))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabelDataSalvamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDataSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabelHoraSalvamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldHoraSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabelJesusSalvador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldJesusSalvador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabelVeiculoSalvamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxVeiculoSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelDescricaoOcorrencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelarOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarSalvamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarSalvamentoActionPerformed
        if (jTextFieldDataSalvamento.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Data não pode ser vazio!!");
            jTextFieldDataSalvamento.requestFocus();
            return;
        }

        if (jTextFieldHoraSalvamento.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Hora não pode ser vazio!!");
            jTextFieldHoraSalvamento.requestFocus();
            return;
        }

        if (jTextFieldLocalSalvamento.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Local não pode ser vazio!!");
            jTextFieldLocalSalvamento.requestFocus();
            return;
        }

        if (jTextFieldJesusSalvador.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Veterinário não pode ser vazio!!");
            jTextFieldJesusSalvador.requestFocus();
            return;
        }

        Salvamento s = new Salvamento();
        s.setFKOcorrencia(new OcorrenciaDAO().buscarOcorrenciaPorId(
                Integer.parseInt(jLabelFKOcorrencia.getText())));
        s.setFKVeiculo((Veiculo) jComboBoxVeiculoSalvamento.getSelectedItem());

        s.setDataSalvamento(Utilitarios.retorarPadraoUS(jTextFieldDataSalvamento.getText()));
        s.setHoraSalvamento(jTextFieldHoraSalvamento.getText());
        s.setLocalSalvamento(jTextFieldLocalSalvamento.getText());
        s.setJesusSalvador(jTextFieldJesusSalvador.getText());

        if (jLabelIdSalvamento.getText().equals("")) {
            int codInserir = new SalvamentoDAO().inserir(s);
            if (codInserir == Utilitarios.NAO_FOI_POSSIVEL_INSERIR) {
                JOptionPane.showMessageDialog(null, "Não foi Possível Inserir");
            } else {
                s.setIdSalvamento(codInserir);
                jLabelIdSalvamento.setText(String.valueOf(codInserir));
                JOptionPane.showMessageDialog(null, "Salvamento Inserido com Sucesso");
            }
        } else {
            int id = Integer.parseInt(jLabelIdSalvamento.getText());
            s.setIdSalvamento(id);
            int codAlteracao = new SalvamentoDAO().alterar(s);
            if (codAlteracao == Utilitarios.NAO_FOI_POSSIVEL_ALTERAR) {
                JOptionPane.showMessageDialog(null, "Não foi Possível Alterar");
            } else {
                JOptionPane.showMessageDialog(null, "Salvamento Alterado com Sucesso");
            }
        }
        dispose();
    }//GEN-LAST:event_jButtonSalvarSalvamentoActionPerformed

    private void jButtonCancelarOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarOcorrenciaActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarOcorrenciaActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameCadastroSalvamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastroSalvamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastroSalvamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastroSalvamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCadastroSalvamento().setVisible(true);
            }
        });
    }

    private void popularComponentes() {
        ArrayList<Veiculo> veiculos = new VeiculoDAO().retornarListaVeiculo();
        for (Veiculo veiculo : veiculos) {

            jComboBoxVeiculoSalvamento.addItem(veiculo);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarOcorrencia;
    private javax.swing.JButton jButtonSalvarSalvamento;
    private javax.swing.JComboBox jComboBoxVeiculoSalvamento;
    private javax.swing.JLabel jLabelCadastroSalvamento;
    private javax.swing.JLabel jLabelCodOcorrencia;
    private javax.swing.JLabel jLabelCodSalvamento;
    private javax.swing.JLabel jLabelDataSalvamento;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelDescricaoOcorrencia;
    private javax.swing.JLabel jLabelFKOcorrencia;
    private javax.swing.JLabel jLabelHoraSalvamento;
    private javax.swing.JLabel jLabelIdSalvamento;
    private javax.swing.JLabel jLabelJesusSalvador;
    private javax.swing.JLabel jLabelLocalSalvamento;
    private javax.swing.JLabel jLabelVeiculoSalvamento;
    private javax.swing.JTextField jTextFieldDataSalvamento;
    private javax.swing.JTextField jTextFieldHoraSalvamento;
    private javax.swing.JTextField jTextFieldJesusSalvador;
    private javax.swing.JTextField jTextFieldLocalSalvamento;
    // End of variables declaration//GEN-END:variables
}

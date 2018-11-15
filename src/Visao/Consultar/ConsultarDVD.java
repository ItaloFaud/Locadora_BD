/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Consultar;

import DAO.ClassificacaoDAO;
import DAO.Conexao;
import DAO.DVDDAO;
import Modelo.Classificacao;
import Modelo.DVD;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoope
 */
public class ConsultarDVD extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarCategoria
     */
    public ConsultarDVD() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        setTitle("Vídeo Locadora");
        AtualizaTable();
    }
    
    public void AtualizaTable(){
        Connection con = Conexao.AbrirConexao();
        DVDDAO sql = new DVDDAO(con);
        
        List<DVD> lista = new ArrayList<>();
        lista = sql.Consulta();
        DefaultTableModel tbm = (DefaultTableModel) jTable2.getModel();
        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        int i = 0;
        for (DVD tab : lista) {
            //Object object = arr[j];
            tbm.addRow(new String[1]);
            jTable2.setValueAt(tab.getCodigo(), i, 0);
            jTable2.setValueAt(tab.getCod_filme(), i, 1);
            jTable2.setValueAt(tab.getPreco(), i, 2);
            jTable2.setValueAt(tab.getData_compra(),i,3);
            jTable2.setValueAt(tab.getSituacao(),i,4);
            i++; 
        }
        Conexao.FecharConexao(con);
    }
    
    public void AtualizaTable_Data(String data){
        Connection con = Conexao.AbrirConexao();
        DVDDAO sql = new DVDDAO(con);
        
        List<DVD> lista = new ArrayList<>();
        lista = sql.Consulta_Data(data);
        DefaultTableModel tbm = (DefaultTableModel) jTable2.getModel();
        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        int i = 0;
        for (DVD tab : lista) {
            //Object object = arr[j];
            tbm.addRow(new String[1]);
            jTable2.setValueAt(tab.getCodigo(), i, 0);
            jTable2.setValueAt(tab.getCod_filme(), i, 1);
            jTable2.setValueAt(tab.getPreco(), i, 2);
            jTable2.setValueAt(tab.getData_compra(),i,3);
            jTable2.setValueAt(tab.getSituacao(),i,4);
           
            i++;
            
            
        }
        Conexao.FecharConexao(con);
    }
    
    public void AtualizaTable_Cod(int cod){
        Connection con = Conexao.AbrirConexao();
        DVDDAO sql = new DVDDAO(con);
        
        List<DVD> lista = new ArrayList<>();
        lista = sql.Consulta_Cod(cod);
        DefaultTableModel tbm = (DefaultTableModel) jTable2.getModel();
        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        int i = 0;
        for (DVD tab : lista) {
            //Object object = arr[j];
            tbm.addRow(new String[1]);
           jTable2.setValueAt(tab.getCodigo(), i, 0);
            jTable2.setValueAt(tab.getCod_filme(), i, 1);
            jTable2.setValueAt(tab.getPreco(), i, 2);
            jTable2.setValueAt(tab.getData_compra(),i,3);
            jTable2.setValueAt(tab.getSituacao(),i,4);
            i++;
            
            
        }
        
        Conexao.FecharConexao(con);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        BtnCod = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JtfCod = new javax.swing.JTextField();
        BtnData = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JftfData11 = new javax.swing.JFormattedTextField();
        BtnTodos = new javax.swing.JButton();
        BtnCancelar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código do Filme", "Preço da Compra", "Data da Compra", "Situação"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        BtnCod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagens/lupa1.png"))); // NOI18N
        BtnCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCodActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel2.setText("Pesquisa por código:");

        JtfCod.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N

        BtnData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagens/lupa1.png"))); // NOI18N
        BtnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDataActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel3.setText("Pesquisa por Data:");

        try {
            JftfData11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JftfData11.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N

        BtnTodos.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BtnTodos.setText("TODOS");
        BtnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTodosActionPerformed(evt);
            }
        });

        BtnCancelar2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BtnCancelar2.setText("Fechar");
        BtnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCod)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JftfData11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnData, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnTodos)
                            .addComponent(BtnCancelar2))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCancelar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(JtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(JftfData11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnCod, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnData, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTodosActionPerformed
        // TODO add your handling code here:
        AtualizaTable();
    }//GEN-LAST:event_BtnTodosActionPerformed

    private void BtnCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCodActionPerformed
        // TODO add your handling code here:
        AtualizaTable_Cod(Integer.parseInt(JtfCod.getText()));
    }//GEN-LAST:event_BtnCodActionPerformed

    private void BtnDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDataActionPerformed
        // TODO add your handling code here:
        AtualizaTable_Data(JftfData11.getText());
    }//GEN-LAST:event_BtnDataActionPerformed

    private void BtnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelar2ActionPerformed
        // TODO add your handling code here:
        // new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnCancelar2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarDVD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar2;
    private javax.swing.JButton BtnCod;
    private javax.swing.JButton BtnData;
    private javax.swing.JButton BtnTodos;
    private javax.swing.JFormattedTextField JftfData11;
    private javax.swing.JTextField JtfCod;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

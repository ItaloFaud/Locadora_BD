/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locacao;

import DAO.AluguelDAO;
import DAO.ClienteDAO;
import DAO.Conexao;
import Modelo.Aluguel;
import Modelo.Cliente;
import Modelo.Listar;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoope
 */
public class ConsultarDevolucao extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarCategoria
     */
    public ConsultarDevolucao() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        setTitle("Vídeo Locadora");
        AtualizaCombo();
        AtualizaTable();
    }
    
    private void AtualizaCombo(){
        Connection con = Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO(con);
        List<Cliente> lista = new ArrayList<>();
        lista = sql.ListarComboCliente();
        //jComboBox1.addItem("");
        
        for(Cliente f : lista){
            jComboBox1.addItem(f.getNome());
        }
        
        Conexao.FecharConexao(con);
    }
    
    public void AtualizaTable(){
        Connection con = Conexao.AbrirConexao();
        AluguelDAO sql = new AluguelDAO(con);
        
        List<Aluguel> lista = new ArrayList<>();
        lista = sql.Consulta();
        DefaultTableModel tbm = (DefaultTableModel) jTable2.getModel();
        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        int i = 0;
        for (Aluguel tab : lista) {
            //Object object = arr[j];
            tbm.addRow(new String[1]);
            jTable2.setValueAt(tab.getCod(), i, 0);
            jTable2.setValueAt(tab.getCod_cliente(), i, 1);
            jTable2.setValueAt(tab.getCod_dvd(), i, 2);
            jTable2.setValueAt(tab.getHorario(),i,3);
            jTable2.setValueAt(tab.getData_aluguel(),i,4);
            jTable2.setValueAt(tab.getData_devolucao(),i,5);
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
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        BtnCancelar2 = new javax.swing.JButton();
        BtnTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "DVD", "Horário", "Locação", "Devolução"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        jComboBox1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        BtnCancelar2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BtnCancelar2.setText("Fechar");
        BtnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelar2ActionPerformed(evt);
            }
        });

        BtnTodos.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BtnTodos.setText("TODOS");
        BtnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnTodos)
                            .addComponent(BtnCancelar2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnCancelar2)
                        .addGap(11, 11, 11)
                        .addComponent(BtnTodos)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String nome = jComboBox1.getSelectedItem().toString();
        
        Connection con = Conexao.AbrirConexao();
        AluguelDAO sql = new AluguelDAO(con);
        
        List<Aluguel> lista = new ArrayList<>();
        lista = sql.ConsultaCliente(nome);
        
        DefaultTableModel tbm = (DefaultTableModel) jTable2.getModel();
        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        int i = 0;
        for (Aluguel tab : lista) {
            //Object object = arr[j];
            tbm.addRow(new String[1]);
            jTable2.setValueAt(tab.getCod(), i, 0);
            jTable2.setValueAt(tab.getCod_cliente(), i, 1);
            jTable2.setValueAt(tab.getCod_dvd(), i, 2);
            jTable2.setValueAt(tab.getHorario(),i,3);
            jTable2.setValueAt(tab.getData_aluguel(),i,4);
            jTable2.setValueAt(tab.getData_devolucao(),i,5);
            i++; 
        }
        Conexao.FecharConexao(con);
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int linha = jTable2.getSelectedRow();
        int idaluguel = (int) jTable2.getValueAt(linha, 0);
        int idcliente = (int) jTable2.getValueAt(linha, 1);
        int iddvd = (int) jTable2.getValueAt(linha, 2);
        
        Listar a = new Listar();
        a.setCoddvd(iddvd);
        a.setCodaluguel(idaluguel);
        a.setCodcliente(idcliente);
        dispose();
       // AtualizaTable();
        
        new EfetuarDevolucao().setVisible(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void BtnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelar2ActionPerformed
        // TODO add your handling code here:
        // new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnCancelar2ActionPerformed

    private void BtnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTodosActionPerformed
        // TODO add your handling code here:
        AtualizaTable();
    }//GEN-LAST:event_BtnTodosActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ConsultarDevolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar2;
    private javax.swing.JButton BtnTodos;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

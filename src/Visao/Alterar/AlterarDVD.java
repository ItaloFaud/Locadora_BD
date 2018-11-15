/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Alterar;

import DAO.CategoriaDAO;
import DAO.ClassificacaoDAO;
import DAO.Conexao;
import DAO.DVDDAO;
import DAO.FilmeDAO;
import Modelo.Categoria;
import Modelo.Classificacao;
import Modelo.DVD;
import Modelo.Filme;
import Visao.Cadastrar.*;
import Principal.Menu;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoope
 */
public class AlterarDVD extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarCategoria
     */
    public AlterarDVD() {
        initComponents();
        setTitle("Vídeo Locadora");
        setResizable(false);
        setLocationRelativeTo(this);
        AtualizaCombo();
        
    }
    
      private void AtualizaCombo(){
        
        Connection con = Conexao.AbrirConexao();
        FilmeDAO sql = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        lista = sql.ListarComboFilme();
      //  jComboBox1.addItem("");
        
        for(Filme f : lista){
            jComboBox1.addItem(f.getTitulo());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JtfID = new javax.swing.JTextField();
        JtfFilme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LbCapa = new javax.swing.JLabel();
        JtfSituacao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        JftfPreco = new javax.swing.JFormattedTextField();
        JftfHoje = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        BtnCadastrar = new javax.swing.JButton();
        BtnLimpar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnOK = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        JtfCod = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel1.setText("Alterar DVD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel3.setText("Filme:");

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel4.setText("Preço da compra");

        JtfID.setEditable(false);
        JtfID.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N

        JtfFilme.setEditable(false);
        JtfFilme.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel2.setText("Codigo:");

        LbCapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagens/DVD_VIDEO_logo.png"))); // NOI18N

        JtfSituacao.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        JtfSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfSituacaoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel6.setText("Situação:");

        jComboBox1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel8.setText("Data da compra:");

        try {
            JftfPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JftfPreco.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        JftfPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JftfPrecoActionPerformed(evt);
            }
        });

        try {
            JftfHoje.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JftfHoje.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(JtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(JtfSituacao))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(JtfFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbCapa)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JftfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JftfHoje, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JtfSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JtfFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(JftfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JftfHoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(LbCapa)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnCadastrar.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrarActionPerformed(evt);
            }
        });

        BtnLimpar.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BtnLimpar.setText("LIMPAR");
        BtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparActionPerformed(evt);
            }
        });

        BtnCancelar.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(BtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(BtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(BtnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        BtnOK.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        BtnOK.setText("OK");
        BtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOKActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel13.setText("Digite o código:");

        JtfCod.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        JtfCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfCodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(JtfCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnOK))
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
        // TODO add your handling code here:
        Connection con = Conexao.AbrirConexao();
        DVDDAO sql = new DVDDAO(con);
        
        if(JtfCod.getText().equalsIgnoreCase("") && JtfID.getText().equalsIgnoreCase("") && JtfSituacao.getText().equalsIgnoreCase("")
                ){
            JOptionPane.showMessageDialog(null,"Campos vazios","Video Locadora",JOptionPane.WARNING_MESSAGE);
        }else{
            DVD c = new DVD();
            c.setCodigo(Integer.parseInt(JtfID.getText()));
            c.setCod_filme(Integer.parseInt(JtfFilme.getText()));
            c.setSituacao(JtfSituacao.getText());
            c.setPreco(JftfPreco.getText());
            c.setData_compra(JftfHoje.getText());
           JOptionPane.showMessageDialog(null,sql.Alterar(c),"Video Locadora",JOptionPane.INFORMATION_MESSAGE);
        }
        JtfCod.setText("");
        JtfSituacao.setText("");
        JtfID.setText("");
        jComboBox1.setSelectedIndex(0);
        JftfHoje.setText("");
        JftfPreco.setText("");
        LbCapa.setIcon(new ImageIcon("/C:/Users/Hoope/Documents/Aulas/NetBeans/Locadora_BD/src/Imagens/Imagens/DVD_VIDEO_logo.png"));
    }//GEN-LAST:event_BtnCadastrarActionPerformed

    private void BtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparActionPerformed
        // TODO add your handling code here:
        JtfSituacao.setText("");
        JtfCod.setText("");
        JtfID.setText("");
        JtfFilme.setText("");
        JftfPreco.setText("");
        LbCapa.setIcon(new ImageIcon("/C:/Users/Hoope/Documents/Aulas/NetBeans/Locadora_BD/src/Imagens/Imagens/DVD_VIDEO_logo.png"));
        
    }//GEN-LAST:event_BtnLimparActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
        //new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void JtfSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtfSituacaoActionPerformed

    private void JftfPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JftfPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JftfPrecoActionPerformed

    private void BtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOKActionPerformed
        // TODO add your handling code here:
          Connection con = Conexao.AbrirConexao();
          DVDDAO sql = new DVDDAO(con);
          FilmeDAO sql2 = new FilmeDAO(con);
        
        int cod = Integer.parseInt(JtfCod.getText());
        
        if(JtfCod.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Campo vazio!","Video Locadora",JOptionPane.WARNING_MESSAGE);
        }else{
            DVD c = new DVD();
            Filme f = new Filme();
            c.setCodigo(cod);
            JOptionPane.showMessageDialog(null, sql.Conferir(c));
            JtfID.setText(""+c.getCodigo());
            JtfSituacao.setText(c.getSituacao());
            JtfFilme.setText(c.getCod_filme()+"");
            jComboBox1.setSelectedItem(sql2.PegaNome(c.getCod_filme(),f));
            JftfPreco.setText(c.getPreco()+"");
            JftfHoje.setText(c.getData_compra());
            LbCapa.setIcon(new ImageIcon("/C:/Users/Hoope/Documents/Aulas/NetBeans/Locadora_BD/src/Capas/"+f.getCapa()));
            //
            //Olhar ISSO
            //JtfData.setDate(c.getData_compra().);
            
        }
        
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_BtnOKActionPerformed

    private void JtfCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfCodActionPerformed
        // TODO add your handling code here:
          Connection con = Conexao.AbrirConexao();
          DVDDAO sql = new DVDDAO(con);
          FilmeDAO sql2 = new FilmeDAO(con);
        
        int cod = Integer.parseInt(JtfCod.getText());
        
        if(JtfCod.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Campo vazio!","Video Locadora",JOptionPane.WARNING_MESSAGE);
        }else{
            DVD c = new DVD();
            Filme f = new Filme();
            c.setCodigo(cod);
            JOptionPane.showMessageDialog(null, sql.Conferir(c));
            JtfID.setText(""+c.getCodigo());
            JtfSituacao.setText(c.getSituacao());
            JtfFilme.setText(c.getCod_filme()+"");
            jComboBox1.setSelectedItem(sql2.PegaNome(c.getCod_filme(),f));
            JftfPreco.setText(c.getPreco()+"");
            JftfHoje.setText(c.getData_compra());
            LbCapa.setIcon(new ImageIcon("/C:/Users/Hoope/Documents/Aulas/NetBeans/Locadora_BD/src/Capas/"+f.getCapa()));
            //
            //Olhar ISSO
            //JtfData.setDate(c.getData_compra().);
            
        }
        
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_JtfCodActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        Connection con = Conexao.AbrirConexao();
        FilmeDAO sql = new FilmeDAO(con);
        
        List<Filme> lista = new ArrayList<>();
        String nome = jComboBox1.getSelectedItem().toString();
        
        lista = sql.ConsultaCodigoFilme(nome);
        
        for(Filme f : lista){
            int cod = f.getCodigo();
            JtfFilme.setText(""+cod);
            LbCapa.setIcon(new ImageIcon("/C:/Users/Hoope/Documents/Aulas/NetBeans/Locadora_BD/src/Capas/"+f.getCapa()));
        }
        
        
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AlterarDVD().setVisible(true);
            }
        });
    }

    private void setRezizable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnLimpar;
    private javax.swing.JButton BtnOK;
    private javax.swing.JFormattedTextField JftfHoje;
    private javax.swing.JFormattedTextField JftfPreco;
    private javax.swing.JTextField JtfCod;
    private javax.swing.JTextField JtfFilme;
    private javax.swing.JTextField JtfID;
    private javax.swing.JTextField JtfSituacao;
    private javax.swing.JLabel LbCapa;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}

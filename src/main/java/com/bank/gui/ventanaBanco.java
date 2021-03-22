/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.gui;

import com.bank.dominio.Banco;
import com.bank.servicios.GestionBanco;
import com.bank.servicios.GestionCliente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ventanaBanco extends javax.swing.JFrame{

    /**
     * Creates new form Interfaz
     */
    private Banco banco;
    private final int ID_BANCO = 1;
    
    public ventanaBanco() {
        initComponents();
        inicializarBanco();
        if(banco != null){
            this.nameBank.setText(banco.getNombre());
            inicializarCliente();
        }
    }
    
    /**
     * MUESTRA SOLO EL TITULO DEL BANCO
     */
    public void inicializarBanco() {
        try{
           GestionBanco gb = new GestionBanco();
           banco = gb.getBancoPorId(ID_BANCO);
           this.nameBank.setText(banco.getNombre());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameBank = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        btnVCBancaria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THE BANK");

        nameBank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameBank.setForeground(new java.awt.Color(51, 51, 255));
        nameBank.setText("TITULO DE BANCO");

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableCliente);

        btnVCBancaria.setText("Ver Cuentas Bancarias");
        btnVCBancaria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVCBancaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVCBancaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVCBancariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(nameBank))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVCBancaria)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(nameBank)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnVCBancaria)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        nameBank.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVCBancariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVCBancariaActionPerformed
        // TODO add your handling code here:
        int row = jTableCliente.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this,"Selecciona un cliente");
        }
        else{
            //obtengo el valor de la columna 1
            int idCliente = (Integer) (jTableCliente.getModel().getValueAt(row, 0));
            System.out.println("id cliente " + idCliente);
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run() {
                    new ventanaCuentaBanco(idCliente).setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_btnVCBancariaActionPerformed

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
            java.util.logging.Logger.getLogger(ventanaBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaBanco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVCBancaria;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JLabel nameBank;
    // End of variables declaration//GEN-END:variables

    /**
     * DATOS DEL CLIENTE
     */
    private void inicializarCliente() {
        try{
            GestionCliente gc = new GestionCliente();
            List lista = gc.getClientesPorIdBanco(ID_BANCO);
            if(lista.isEmpty()){
                JOptionPane.showConfirmDialog(this, "No hay clientes.");
                btnVCBancaria.setEnabled(false);
            }
            else{
                jTableCliente.setModel(new ClientesDataModel(lista));
                btnVCBancaria.setEnabled(true);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

}
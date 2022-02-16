/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControleRelatorios;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * @author fabricio
 */
public class JanelaRelatorio extends javax.swing.JFrame {

    ControleRelatorios controle = new ControleRelatorios();

    /**
     * Recupera o parâmetro do usuário para criar um objeto Map que será usado
     * no relatório.
     */
    
    private Map constroiParametrosHeroi() {
        Map params = new HashMap();

        double forca = Integer.valueOf(JOptionPane.showInputDialog(
                this,
                "Selecione a força mínima dos herois que devem aparecer:",
                "Entrada de dados",
                JOptionPane.QUESTION_MESSAGE));

        params.put("forcaParam", forca);
        return params;
    }



    /**
     * Creates new form JanelaCliente
     */
    public JanelaRelatorio() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ehPdfCheck = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuHeroi = new javax.swing.JMenuItem();
        menuHeroiParametro = new javax.swing.JMenuItem();
        menuSalvamendoDia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Olá, você poderá operar o relatório no menu superior!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Configurações:");

        ehPdfCheck.setText("Gerar PDF para visualizar?");
        ehPdfCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ehPdfCheckActionPerformed(evt);
            }
        });

        jMenu1.setText("Aplicação");

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatórios");

        menuHeroi.setText("Visualiza Relatório Heroi");
        menuHeroi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHeroiActionPerformed(evt);
            }
        });
        jMenu2.add(menuHeroi);

        menuHeroiParametro.setText("Visualiza Relatório Heroi por forca/parametro");
        menuHeroiParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHeroiParametroActionPerformed(evt);
            }
        });
        jMenu2.add(menuHeroiParametro);

        menuSalvamendoDia.setText("Relatório de Salvamentos por Dia");
        menuSalvamendoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvamendoDiaActionPerformed(evt);
            }
        });
        jMenu2.add(menuSalvamendoDia);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ehPdfCheck)
                            .addComponent(jLabel2))
                        .addGap(200, 200, 200))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(ehPdfCheck)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(591, 425));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuHeroiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHeroiActionPerformed
       controle.RelatorioHeroi(!ehPdfCheck.isSelected());
    }//GEN-LAST:event_menuHeroiActionPerformed

    private void menuHeroiParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHeroiParametroActionPerformed
        controle.RelatorioHeroiParametro(constroiParametrosHeroi(), !ehPdfCheck.isSelected());//relatorio cliente com parametro
    }//GEN-LAST:event_menuHeroiParametroActionPerformed

    private void menuSalvamendoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvamendoDiaActionPerformed
        controle.RelatorioSalvamentoPorDia(!ehPdfCheck.isSelected());
    }//GEN-LAST:event_menuSalvamendoDiaActionPerformed

    private void ehPdfCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ehPdfCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ehPdfCheckActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaRelatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JanelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ehPdfCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuHeroi;
    private javax.swing.JMenuItem menuHeroiParametro;
    private javax.swing.JMenuItem menuSalvamendoDia;
    // End of variables declaration//GEN-END:variables
}
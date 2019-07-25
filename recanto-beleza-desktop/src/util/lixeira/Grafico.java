package util.lixeira;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/*@author Aluno*/
public class Grafico extends javax.swing.JDialog {

    /**
     * @param parent
     * @param modal
     * @param painel
     */
    public Grafico(java.awt.Frame parent, boolean modal, org.jfree.chart.ChartPanel painel) {
        super(parent, modal);
        initComponents();
        this.painelGrafico.setLayout(new java.awt.BorderLayout());
        this.painelGrafico.add(painel);
        alterarIcone();
    }

    private void alterarIcone() {
        URL url = this.getClass().getResource("/imagens/arquivo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        this.setLocationRelativeTo(null);
        util.JanelaComum.setAcessibilidade(this);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBotoes = new javax.swing.JPanel();
        botaoFechar = new javax.swing.JButton();
        botaoImprimir = new javax.swing.JButton();
        painelGrafico = new javax.swing.JPanel();
        painelTitulo = new javax.swing.JPanel();
        rotuloTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios");
        setMinimumSize(new java.awt.Dimension(900, 600));

        painelBotoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        botaoFechar.setBackground(new java.awt.Color(135, 206, 235));
        botaoFechar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoFechar.setMnemonic('f');
        botaoFechar.setText("Fechar");
        botaoFechar.setContentAreaFilled(false);
        botaoFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoFechar.setOpaque(true);
        botaoFechar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoFechar);
        botaoFechar.setOpaque(true);

        botaoImprimir.setBackground(new java.awt.Color(46, 139, 87));
        botaoImprimir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoImprimir.setMnemonic('s');
        botaoImprimir.setText("Salvar");
        botaoImprimir.setContentAreaFilled(false);
        botaoImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoImprimir.setMaximumSize(new java.awt.Dimension(89, 25));
        botaoImprimir.setMinimumSize(new java.awt.Dimension(89, 25));
        botaoImprimir.setOpaque(true);
        botaoImprimir.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImprimirActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoImprimir);
        botaoImprimir.setOpaque(true);

        getContentPane().add(painelBotoes, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout painelGraficoLayout = new javax.swing.GroupLayout(painelGrafico);
        painelGrafico.setLayout(painelGraficoLayout);
        painelGraficoLayout.setHorizontalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        painelGraficoLayout.setVerticalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        getContentPane().add(painelGrafico, java.awt.BorderLayout.CENTER);

        painelTitulo.setBackground(java.awt.Color.black);

        rotuloTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rotuloTitulo.setForeground(new java.awt.Color(255, 255, 255));
        rotuloTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rotuloTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorioGrafico.png"))); // NOI18N
        rotuloTitulo.setText("RELATÓRIO DE RENDIMENTOS POR PERÍODO");
        painelTitulo.add(rotuloTitulo);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImprimirActionPerformed
        
    }//GEN-LAST:event_botaoImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Grafico dialog = new Grafico(new javax.swing.JFrame(), true, null);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoImprimir;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelGrafico;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JLabel rotuloTitulo;
    // End of variables declaration//GEN-END:variables
}

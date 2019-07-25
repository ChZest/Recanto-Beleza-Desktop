package util.lixeira;

/**
 * @author BIC-Jr Guia de Estilo
 */
import interfaces.Principal;
import dados.DadosException;
import entidades.Cliente;
import java.awt.Color;
import java.text.ParseException;
import java.util.logging.Level;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.util.List;
import java.util.ArrayList;
import entidades.Servico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dados.ClienteDados;
import java.util.function.Consumer;
import util.DateParse;

public class AgendarAtendimento extends javax.swing.JDialog {

    List<Servico> servicos = new ArrayList<>();

    public AgendarAtendimento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarNome();

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
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendar Atendimento");
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout(15, 15));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/date.png"))); // NOI18N
        jLabel2.setText("Data*:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jFormattedTextField2.setForeground(java.awt.Color.gray);
        jFormattedTextField2.setText("dd/mm/aaaa");
        jFormattedTextField2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jFormattedTextField2.setPreferredSize(null);
        jFormattedTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField2FocusLost(evt);
            }
        });
        jPanel5.add(jFormattedTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, 30));

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel1.setText("Cliente*:");
        jLabel1.setToolTipText("");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 20));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 40, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel3.setText("Cliente*:");
        jLabel3.setToolTipText("");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 20));

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel4.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 290, 30));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 40, 30));

        jPanel1.add(jPanel4, java.awt.BorderLayout.WEST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Serviços Agendados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Serviço:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jPanel6.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Profissional:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roberta Junqueira", "Caio Gomes" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 190, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Horário:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Serviço", "Profissional", "Horário"
            }
        ));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 630, 320));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton3.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton3.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, 50));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        jButton6.setEnabled(false);
        jButton6.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, -1, 50));

        jFormattedTextField1.setForeground(java.awt.Color.gray);
        jFormattedTextField1.setText("hh:mm");
        jFormattedTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jFormattedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusLost(evt);
            }
        });
        jPanel6.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 190, 30));

        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 10));

        jButton1.setBackground(new java.awt.Color(135, 206, 235));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setMnemonic('c');
        jButton1.setText("Cancelar");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.setPreferredSize(new java.awt.Dimension(130, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setBackground(new java.awt.Color(46, 139, 87));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setMnemonic('s');
        jButton2.setText("Salvar");
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.setPreferredSize(new java.awt.Dimension(130, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jFormattedTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusGained
        jFormattedTextField1.setBorder(new LineBorder(Color.BLUE));
        if (jFormattedTextField1.getText().equals("hh:mm")) {
            jFormattedTextField1.setForeground(Color.BLACK);
            jFormattedTextField1.setText("");
            try {
                MaskFormatter mascaraHora = new MaskFormatter("##:##");
                mascaraHora.setPlaceholderCharacter('_');
                jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(
                        mascaraHora));
            } catch (ParseException e) {

            }
        }
    }//GEN-LAST:event_jFormattedTextField1FocusGained

    private void jFormattedTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusLost
        String data = jFormattedTextField1.getText();
        data = data.replace(":", "");
        data = data.replace("_", "");
        data = data.replace("h", "");
        data = data.replace("m", "");
        if (data.equals("")) {
            jFormattedTextField1.setForeground(Color.GRAY);
            jFormattedTextField1.setFormatterFactory(null);
            jFormattedTextField1.setText("hh:mm");
        }
        validaHora();
    }//GEN-LAST:event_jFormattedTextField1FocusLost

    private boolean validaHora() {
        return true;
    }

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        jTextField1.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost

    }//GEN-LAST:event_jTextField1FocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!jTextField1.getText().isEmpty() && !jFormattedTextField1.getText().isEmpty()) {
            String[] strPVet = new String[]{"Serviço", "Profissional", "Horário"};
            Servico s = new Servico();
            s.setNmServico(jTextField1.getText());
            s.setProfissional((String) jComboBox1.getSelectedItem());
            s.setHorario(jFormattedTextField1.getText());
            servicos.add(s);
            String[][] strPMat = new String[servicos.size()][3];
            for (int i = 0; i < servicos.size(); i++) {
                Servico ss = servicos.get(i);
                strPMat[i][0] = ss.getNmServico() + "";
                strPMat[i][1] = ss.getValor();
                strPMat[i][2] = ss.getHorario();
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    strPMat, strPVet
            ));
            jButton6.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jFormattedTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField2FocusGained
        jFormattedTextField2.setBorder(new LineBorder(Color.BLUE));
        if (jFormattedTextField2.getText().equals("dd/mm/aaaa")) {
            jFormattedTextField2.setForeground(Color.BLACK);
            jFormattedTextField2.setText("");
            try {
                MaskFormatter mascaraData = new MaskFormatter("##/##/####");
                mascaraData.setPlaceholderCharacter('_');
                jFormattedTextField2.setFormatterFactory(new DefaultFormatterFactory(
                        mascaraData));
            } catch (ParseException e) {

            }
        }
    }//GEN-LAST:event_jFormattedTextField2FocusGained

    private void jFormattedTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField2FocusLost
        String data = jFormattedTextField1.getText();
        data = data.replace("/", "");
        data = data.replace("_", "");
        data = data.replace("d", "");
        data = data.replace("m", "");
        data = data.replace("a", "");
        if (data.equals("")) {
            jFormattedTextField2.setForeground(Color.GRAY);
            jFormattedTextField2.setFormatterFactory(null);
            jFormattedTextField2.setText("dd/mm/aaaa");
        }
        validaData();
    }//GEN-LAST:event_jFormattedTextField2FocusLost

    private boolean validaData() {
        try {
            DateParse.parseDate(jFormattedTextField2.getText());
            jFormattedTextField2.setBorder(new LineBorder(Color.GRAY));
            return true;
        } catch (ParseException e) {
            jFormattedTextField2.setBorder(new LineBorder(Color.RED));
            return false;
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton6.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Object[] options = {"Sim", "Não"};
        int opt = JOptionPane.showOptionDialog(null,
                "Deseja realmente excluir este serviço?", "Exclusão",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (opt == JOptionPane.OK_OPTION) {

//            try {
//                Procedimento p = getProcedimentoFromTable();
//
//                ProcedimentoDao pDao = new ProcedimentoDao();
//                pDao.excluirProcedimento(p.getCdProcedimento());
//
            int linha = jTable1.getSelectedRow();
            servicos.remove(linha);
            DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
            m.removeRow(linha);
            jButton6.setEnabled(false);
//            } catch (DaoException ex) {
//                JOptionPane.showMessageDialog(this, ex.getMessage());
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "Erro ao excluir procedimento: " + e.getMessage());
//            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Principal l = new Principal(null);
        PacPesquisarAgenda pacPesquisar = new PacPesquisarAgenda(l, true);
        pacPesquisar.setVisible(true);

        Cliente c = pacPesquisar.getCliente();
        if (c != null) {

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Principal a = new Principal(null);
        ClienteNovo c = new ClienteNovo(a, true);
        c.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            AgendarAtendimento dialog = new AgendarAtendimento(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    private void carregarNome() {
        //este for é para carregar meu combo substitua pelo seu
        List<Cliente> clientes = new ArrayList<>();
        try {
            ClienteDados.consultarTodos();
        } catch (DadosException ex) {
            interfaces.Problema erroDeConexao = new interfaces.Problema(new javax.swing.JFrame(), true, ex.getMessage());
            erroDeConexao.setVisible(true);
        }
        clientes.stream().map((cliente) -> {
            jComboBox2.addItem(cliente.getNmCliente());
            return cliente;
        }).forEachOrdered(new ConsumerImpl());
        // aqui iremos transformar o combo em editavel e com popup
        util.lixeira.AutoCompletion.enable(jComboBox2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private class ConsumerImpl implements Consumer<Cliente> {

        public ConsumerImpl() {
        }

        @Override
        public void accept(Cliente _item) {
            // o selected null é para que o combo fique limpo depois de carregado para que possamos escrever nele
            jComboBox2.setSelectedItem(null);
        }
    }
}

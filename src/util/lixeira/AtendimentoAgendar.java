package util.lixeira;

import interfaces.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.table.JTableHeader;
import entidades.Cliente;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JList;

/**
 *
 * @author BIC-Jr Guia de Estilo
 */
public class AtendimentoAgendar extends javax.swing.JDialog {

    private final JList<String> wordList;
    private final util.lixeira.jlisttest.JListModel listModel;
    /**
     * Creates new form Agendar
     * @param parent
     * @param modal
     */
    public AtendimentoAgendar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.listModel = new util.lixeira.jlisttest.JListModel();
        this.wordList = new JList<>(listModel.getListModel(""));
        initComponents();
        alterarIcone();
    }
    
    private void alterarIcone() {
        URL url = this.getClass().getResource("/imagens/calendario.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        this.setLocationRelativeTo(null);
    }

    public class PrefixListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            String prefix = campoNome.getText() + e.getKeyChar();
            wordList.setModel(listModel.getListModel(prefix.trim()));
        }
        @Override
        public void keyPressed(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopo = new javax.swing.JPanel();
        painelDadosFora = new javax.swing.JPanel();
        painelTitulo = new javax.swing.JPanel();
        rotuloNovoAgendamento = new javax.swing.JLabel();
        painelRolavel = new javax.swing.JScrollPane();
        painelFormulario = new javax.swing.JPanel();
        painelDados = new javax.swing.JPanel();
        rotuloCliente = new javax.swing.JLabel();
        botaoPesquisar = new javax.swing.JButton();
        botaoAdicionarCliente = new javax.swing.JButton();
        rotuloData = new javax.swing.JLabel();
        seletorDeData = new com.toedter.calendar.JDateChooser();
        campoNome = new javax.swing.JTextField();
        painelNome = new javax.swing.JScrollPane(wordList);
        painelBotoes = new javax.swing.JPanel();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        painelServicos = new javax.swing.JPanel();
        rotuloServico = new javax.swing.JLabel();
        rotuloProfissional = new javax.swing.JLabel();
        rotuloHorario = new javax.swing.JLabel();
        comboBoxServico = new javax.swing.JComboBox<>();
        comboBoxProfissional = new javax.swing.JComboBox<>();
        comboBoxHorario = new javax.swing.JComboBox<>();
        painelTabela = new javax.swing.JScrollPane();
        tabelaSevicos = new javax.swing.JTable();
        botaoAdicionarServico = new javax.swing.JButton();
        botaoRemoverServico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Agendamentos");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(680, 540));
        setResizable(false);

        painelTopo.setLayout(new java.awt.BorderLayout());

        painelDadosFora.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        painelTopo.add(painelDadosFora, java.awt.BorderLayout.CENTER);

        painelTitulo.setBackground(java.awt.Color.black);

        rotuloNovoAgendamento.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rotuloNovoAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        rotuloNovoAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calendarioNovo.png"))); // NOI18N
        rotuloNovoAgendamento.setText("AGENDAR ATENDIMENTO");
        painelTitulo.add(rotuloNovoAgendamento);

        painelTopo.add(painelTitulo, java.awt.BorderLayout.NORTH);

        getContentPane().add(painelTopo, java.awt.BorderLayout.NORTH);

        painelFormulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        painelDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rotuloCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloCliente.setText("Cliente:*");
        painelDados.add(rotuloCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 25, -1, 25));

        botaoPesquisar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        botaoPesquisar.setToolTipText("Procurar cliente");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });
        painelDados.add(botaoPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 50, 35, -1));

        botaoAdicionarCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoAdicionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        botaoAdicionarCliente.setToolTipText("Novo cliente");
        botaoAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarClienteActionPerformed(evt);
            }
        });
        painelDados.add(botaoAdicionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 50, 37, -1));

        rotuloData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloData.setText("Data:*");
        painelDados.add(rotuloData, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, 25));

        seletorDeData.setToolTipText("Selecionar data");
        seletorDeData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        seletorDeData.setMinSelectableDate(new java.util.Date(-62135755095000L));
        seletorDeData.setMinimumSize(new java.awt.Dimension(27, 10));
        seletorDeData.setPreferredSize(new java.awt.Dimension(87, 15));
        painelDados.add(seletorDeData, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 149, 25));

        campoNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoNome.addKeyListener(new PrefixListener());
        campoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNomeFocusLost(evt);
            }
        });
        painelDados.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 260, 25));

        painelNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        painelDados.add(painelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 260, 80));
        painelNome.setVisible(false);

        painelFormulario.add(painelDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 90));

        painelBotoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        botaoCancelar.setBackground(new java.awt.Color(135, 206, 235));
        botaoCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoCancelar.setMnemonic('c');
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setContentAreaFilled(false);
        botaoCancelar.setOpaque(true);
        botaoCancelar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoCancelar);
        botaoCancelar.setOpaque(true);

        botaoSalvar.setBackground(new java.awt.Color(46, 139, 87));
        botaoSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoSalvar.setMnemonic('s');
        botaoSalvar.setText("Salvar");
        botaoSalvar.setContentAreaFilled(false);
        botaoSalvar.setMaximumSize(new java.awt.Dimension(89, 25));
        botaoSalvar.setMinimumSize(new java.awt.Dimension(89, 25));
        botaoSalvar.setOpaque(true);
        botaoSalvar.setPreferredSize(new java.awt.Dimension(130, 35));
        painelBotoes.add(botaoSalvar);
        botaoSalvar.setOpaque(true);

        painelFormulario.add(painelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 655, 50));

        painelServicos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Serviços Agendados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        painelServicos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelServicos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rotuloServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloServico.setText("Serviço:");
        painelServicos.add(rotuloServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 19, -1, -1));

        rotuloProfissional.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloProfissional.setText("Profissional:");
        painelServicos.add(rotuloProfissional, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        rotuloHorario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloHorario.setText("Horário:");
        painelServicos.add(rotuloHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 20, -1, -1));

        comboBoxServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboBoxServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        painelServicos.add(comboBoxServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 40, 219, -1));

        comboBoxProfissional.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboBoxProfissional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        painelServicos.add(comboBoxProfissional, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 219, -1));

        comboBoxHorario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboBoxHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        painelServicos.add(comboBoxHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 40, 107, -1));

        tabelaSevicos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaSevicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serviço", "Profissional", "Horário"
            }
        ));
        tabelaSevicos.setRowHeight(30);
        tabelaSevicos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaSevicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSevicosMouseClicked(evt);
            }
        });
        painelTabela.setViewportView(tabelaSevicos);
        JTableHeader cabecalho = tabelaSevicos.getTableHeader();
        cabecalho.setFont(new java.awt.Font("Arial", 0, 14));
        tabelaSevicos.getColumnModel().getColumn(0).setPreferredWidth(240);
        tabelaSevicos.getColumnModel().getColumn(1).setPreferredWidth(240);

        painelServicos.add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 80, 575, 190));

        botaoAdicionarServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoAdicionarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelaInserir.png"))); // NOI18N
        botaoAdicionarServico.setToolTipText("Adicionar serviço à tabela");
        painelServicos.add(botaoAdicionarServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 28, 35, 35));

        botaoRemoverServico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoRemoverServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelaRemover.png"))); // NOI18N
        botaoRemoverServico.setToolTipText("Remover serviço da tabela");
        botaoRemoverServico.setEnabled(false);
        painelServicos.add(botaoRemoverServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 35, 35));

        painelFormulario.add(painelServicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 650, 280));

        painelRolavel.setViewportView(painelFormulario);

        getContentPane().add(painelRolavel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void tabelaSevicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSevicosMouseClicked
        botaoRemoverServico.setEnabled(true);
    }//GEN-LAST:event_tabelaSevicosMouseClicked

    private void botaoAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarClienteActionPerformed
        ClienteNovo clienteCadastrar = new ClienteNovo(null, true);
        clienteCadastrar.setVisible(true);
        if(clienteCadastrar.getCliente()!= null) {
            String nome = clienteCadastrar.getCliente();
        }
    }//GEN-LAST:event_botaoAdicionarClienteActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        ClientePesquisar clientePesquisar = new ClientePesquisar(null, true);
        clientePesquisar.setVisible(true);
        if(clientePesquisar.getCliente()!= null) {
            Cliente cliente = clientePesquisar.getCliente();
        }
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void campoNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNomeFocusGained
        painelNome.setVisible(true);
        this.setComponentZOrder(painelNome, getComponentZOrder(painelServicos)+1);
    }//GEN-LAST:event_campoNomeFocusGained

    private void campoNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNomeFocusLost
        painelNome.setVisible(false);
    }//GEN-LAST:event_campoNomeFocusLost

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
            java.util.logging.Logger.getLogger(AtendimentoAgendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            AtendimentoAgendar dialog = new AtendimentoAgendar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botaoAdicionarCliente;
    private javax.swing.JButton botaoAdicionarServico;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoRemoverServico;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> comboBoxHorario;
    private javax.swing.JComboBox<String> comboBoxProfissional;
    private javax.swing.JComboBox<String> comboBoxServico;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelDadosFora;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JScrollPane painelNome;
    private javax.swing.JScrollPane painelRolavel;
    private javax.swing.JPanel painelServicos;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JPanel painelTopo;
    private javax.swing.JLabel rotuloCliente;
    private javax.swing.JLabel rotuloData;
    private javax.swing.JLabel rotuloHorario;
    private javax.swing.JLabel rotuloNovoAgendamento;
    private javax.swing.JLabel rotuloProfissional;
    private javax.swing.JLabel rotuloServico;
    private com.toedter.calendar.JDateChooser seletorDeData;
    private javax.swing.JTable tabelaSevicos;
    // End of variables declaration//GEN-END:variables
}

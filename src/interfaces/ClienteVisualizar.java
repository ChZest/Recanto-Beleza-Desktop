package interfaces;

import java.awt.Toolkit;
import java.awt.Image;
import java.net.URL;
import javax.swing.table.JTableHeader;
import entidades.Cliente;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author BIC-Jr Guia de Estilo
 */
public class ClienteVisualizar extends javax.swing.JDialog {

    public ClienteVisualizar(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        redimencionarTela();
        alterarIcone();
        preencherFormulario(cliente);
    }

    private void alterarIcone() {
        URL url = this.getClass().getResource("/imagens/usuario.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        this.setLocationRelativeTo(null);
        util.JanelaComum.setAcessibilidade(this);
        this.setLocationRelativeTo(null);
        painelRolavel.getVerticalScrollBar().setUnitIncrement(16);
    }

    @Override
    public void paint(java.awt.Graphics g) {
        java.awt.Dimension d = getSize();
        java.awt.Dimension m = getMaximumSize();
        boolean resize = d.width > m.width || d.height > m.height;
        d.width = Math.min(m.width, d.width);
        d.height = Math.min(m.height, d.height);
        if (resize) {
            java.awt.Point p = getLocation();
            setVisible(false);
            setSize(d);
            setLocation(p);
            setVisible(true);
        }
        super.paint(g);
    }

    private void redimencionarTela() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        java.awt.Dimension d = tk.getScreenSize();
        if (d.width >= 630 && d.height >= 910) {
            this.setMinimumSize(new java.awt.Dimension(610, 860));
            this.setSize(610, 860);
            this.setResizable(false);
        } else {
            this.setMinimumSize(new java.awt.Dimension(630, d.height - 50));
            this.setSize(630, d.height - 50);
//            this.setResizable(true);
        }
    }

    private void preencherFormulario(Cliente cliente) {
        campoNomeCompleto.setText(cliente.getNmCliente());
        if (cliente.getSexo().equals("m")) {
            campoSexo.setText("Masculino");
        }
        campoDataDeNascimento.setText(util.DateParse.dateToString(cliente.getDtNasc()));
        campoCPF.setText(cliente.getCpf());
        campoRG.setText(cliente.getRg());
        campoEmail.setText(cliente.getEmail());
        campoRua.setText(cliente.getRua());
        campoNumero.setText(cliente.getNumero() + "");
        campoComplemento.setText(cliente.getComplemento());
        campoBairro.setText(cliente.getBairro());
        campoCEP.setText(cliente.getCep());
        campoCidade.setText(cliente.getNmCidade());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelRolavel = new javax.swing.JScrollPane();
        painelFormulario = new javax.swing.JPanel();
        painelDadosPessoais = new javax.swing.JPanel();
        rotuloNomeCompleto = new javax.swing.JLabel();
        campoNomeCompleto = new javax.swing.JTextField();
        rotuloDataDeNascimento = new javax.swing.JLabel();
        campoDataDeNascimento = new javax.swing.JFormattedTextField();
        campoCPF = new javax.swing.JFormattedTextField();
        rotuloCPF = new javax.swing.JLabel();
        rotuloEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        rotuloNumero1 = new javax.swing.JLabel();
        campoSexo = new javax.swing.JTextField();
        campoRG = new javax.swing.JTextField();
        rotuloRG = new javax.swing.JLabel();
        painelEndereco = new javax.swing.JPanel();
        rotuloRua = new javax.swing.JLabel();
        campoRua = new javax.swing.JTextField();
        rotuloNumero = new javax.swing.JLabel();
        rotuloComplemento = new javax.swing.JLabel();
        campoComplemento = new javax.swing.JTextField();
        rotuloBairro = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        rotuloCEP = new javax.swing.JLabel();
        rotuloCidade = new javax.swing.JLabel();
        campoCEP = new javax.swing.JFormattedTextField();
        campoNumero = new javax.swing.JTextField();
        campoBairro = new javax.swing.JTextField();
        painelContato = new javax.swing.JPanel();
        painelTabela = new javax.swing.JScrollPane();
        tabelaContato = new javax.swing.JTable();
        painelBotoes = new javax.swing.JPanel();
        botaoVoltar = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        rotuloNovoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Cliente");
        setMaximumSize(new java.awt.Dimension(630, 1080));
        setMinimumSize(new java.awt.Dimension(610, 870));
        setPreferredSize(new java.awt.Dimension(610, 870));
        setResizable(false);

        painelRolavel.setBorder(null);

        painelFormulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        painelDadosPessoais.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        painelDadosPessoais.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rotuloNomeCompleto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloNomeCompleto.setText("Nome Completo:");
        painelDadosPessoais.add(rotuloNomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        campoNomeCompleto.setEditable(false);
        campoNomeCompleto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoNomeCompleto.setText("Regina Maria Souza Carvalho");
        campoNomeCompleto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoNomeCompleto.setFocusable(false);
        campoNomeCompleto.setOpaque(false);
        painelDadosPessoais.add(campoNomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 30));

        rotuloDataDeNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloDataDeNascimento.setText("Data de Nascimento:");
        painelDadosPessoais.add(rotuloDataDeNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        campoDataDeNascimento.setEditable(false);
        campoDataDeNascimento.setText("10/12/1992");
        campoDataDeNascimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoDataDeNascimento.setFocusable(false);
        campoDataDeNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoDataDeNascimento.setOpaque(false);
        painelDadosPessoais.add(campoDataDeNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 30));

        campoCPF.setEditable(false);
        campoCPF.setText("123.456.789-00");
        campoCPF.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoCPF.setFocusable(false);
        campoCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoCPF.setOpaque(false);
        campoCPF.setPreferredSize(null);
        painelDadosPessoais.add(campoCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 260, 30));

        rotuloCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloCPF.setText("CPF:");
        painelDadosPessoais.add(rotuloCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        rotuloEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloEmail.setText("E-mail:");
        painelDadosPessoais.add(rotuloEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        campoEmail.setEditable(false);
        campoEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoEmail.setText("regina.msc@negocios.com");
        campoEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoEmail.setFocusable(false);
        campoEmail.setOpaque(false);
        painelDadosPessoais.add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 260, 30));

        rotuloNumero1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloNumero1.setText("Sexo:");
        painelDadosPessoais.add(rotuloNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        campoSexo.setEditable(false);
        campoSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoSexo.setText("Feminino");
        campoSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoSexo.setFocusable(false);
        campoSexo.setOpaque(false);
        painelDadosPessoais.add(campoSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 180, 30));

        campoRG.setEditable(false);
        campoRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoRG.setText("12.12.123");
        campoRG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoRG.setFocusable(false);
        campoRG.setOpaque(false);
        painelDadosPessoais.add(campoRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 260, 30));

        rotuloRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloRG.setText("RG:");
        painelDadosPessoais.add(rotuloRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        painelFormulario.add(painelDadosPessoais, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 220));

        painelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        painelEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        painelEndereco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rotuloRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloRua.setText("Rua:");
        painelEndereco.add(rotuloRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        campoRua.setEditable(false);
        campoRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoRua.setText("Castanheira");
        campoRua.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoRua.setFocusable(false);
        campoRua.setOpaque(false);
        painelEndereco.add(campoRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 30));

        rotuloNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloNumero.setText("Número:");
        painelEndereco.add(rotuloNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        rotuloComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloComplemento.setText("Complemento:");
        painelEndereco.add(rotuloComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        campoComplemento.setEditable(false);
        campoComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoComplemento.setText("(vazio)");
        campoComplemento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoComplemento.setFocusable(false);
        campoComplemento.setOpaque(false);
        painelEndereco.add(campoComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 30));

        rotuloBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloBairro.setText("Bairro:");
        painelEndereco.add(rotuloBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        campoCidade.setEditable(false);
        campoCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoCidade.setText("Belo Horizonte");
        campoCidade.setToolTipText("");
        campoCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoCidade.setFocusable(false);
        campoCidade.setOpaque(false);
        painelEndereco.add(campoCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 260, 30));

        rotuloCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloCEP.setText("CEP:");
        painelEndereco.add(rotuloCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        rotuloCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloCidade.setText("Cidade:");
        painelEndereco.add(rotuloCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        campoCEP.setEditable(false);
        campoCEP.setText("35.172-000");
        campoCEP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoCEP.setFocusable(false);
        campoCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoCEP.setOpaque(false);
        painelEndereco.add(campoCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 30));

        campoNumero.setEditable(false);
        campoNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoNumero.setText("99");
        campoNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoNumero.setFocusable(false);
        campoNumero.setOpaque(false);
        painelEndereco.add(campoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 260, 30));

        campoBairro.setEditable(false);
        campoBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoBairro.setText("Floresta");
        campoBairro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoBairro.setFocusable(false);
        campoBairro.setOpaque(false);
        painelEndereco.add(campoBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 260, 30));

        painelFormulario.add(painelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 580, 230));

        painelContato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        painelContato.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelTabela.setBackground(new java.awt.Color(240, 240, 240));
        painelTabela.setForeground(new java.awt.Color(240, 240, 240));
        painelTabela.setPreferredSize(new java.awt.Dimension(300, 200));

        tabelaContato.setBackground(new java.awt.Color(240, 240, 240));
        tabelaContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaContato.setForeground(new java.awt.Color(0, 0, 0));
        tabelaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"(31)98765-4321", "Celular"},
                {"(31)90123-4567", "Comercial"},
                {"(31)3846-8080", "Casa"}
            },
            new String [] {
                "Telefone", "Observação"
            }
        ));
        tabelaContato.setEnabled(false);
        tabelaContato.setFocusable(false);
        tabelaContato.setRowHeight(30);
        tabelaContato.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaContato.setShowVerticalLines(false);
        painelTabela.setViewportView(tabelaContato);
        JTableHeader cabecalho = tabelaContato.getTableHeader();
        cabecalho.setFont(new java.awt.Font("Arial", 0, 14));
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new java.awt.Color(240, 240, 240));
        for (int i = 0; i < tabelaContato.getModel().getColumnCount(); i++) {
            tabelaContato.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        painelContato.add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 540, 190));

        painelFormulario.add(painelContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 580, 240));

        painelBotoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        botaoVoltar.setBackground(new java.awt.Color(135, 206, 235));
        botaoVoltar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoVoltar.setMnemonic('v');
        botaoVoltar.setText("Voltar");
        botaoVoltar.setToolTipText("Fechar esta janela (Alt+V)");
        botaoVoltar.setContentAreaFilled(false);
        botaoVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoVoltar.setMaximumSize(new java.awt.Dimension(89, 25));
        botaoVoltar.setMinimumSize(new java.awt.Dimension(89, 25));
        botaoVoltar.setOpaque(true);
        botaoVoltar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoVoltar);

        painelFormulario.add(painelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, 582, 50));

        painelRolavel.setViewportView(painelFormulario);

        getContentPane().add(painelRolavel, java.awt.BorderLayout.CENTER);

        painelTitulo.setBackground(new java.awt.Color(0, 0, 0));

        rotuloNovoCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rotuloNovoCliente.setForeground(new java.awt.Color(255, 255, 255));
        rotuloNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarioVisualizar.png"))); // NOI18N
        rotuloNovoCliente.setText("VISUALIZAR CLIENTE");
        painelTitulo.add(rotuloNovoCliente);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex1) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;

                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex2) {
                java.util.logging.Logger.getLogger(Login.class
                        .getName()).log(java.util.logging.Level.SEVERE, null, ex2);
            }
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ClienteVisualizar dialog = new ClienteVisualizar(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JFormattedTextField campoCEP;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoComplemento;
    private javax.swing.JFormattedTextField campoDataDeNascimento;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNomeCompleto;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoRG;
    private javax.swing.JTextField campoRua;
    private javax.swing.JTextField campoSexo;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelContato;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JScrollPane painelRolavel;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JLabel rotuloBairro;
    private javax.swing.JLabel rotuloCEP;
    private javax.swing.JLabel rotuloCPF;
    private javax.swing.JLabel rotuloCidade;
    private javax.swing.JLabel rotuloComplemento;
    private javax.swing.JLabel rotuloDataDeNascimento;
    private javax.swing.JLabel rotuloEmail;
    private javax.swing.JLabel rotuloNomeCompleto;
    private javax.swing.JLabel rotuloNovoCliente;
    private javax.swing.JLabel rotuloNumero;
    private javax.swing.JLabel rotuloNumero1;
    private javax.swing.JLabel rotuloRG;
    private javax.swing.JLabel rotuloRua;
    private javax.swing.JTable tabelaContato;
    // End of variables declaration//GEN-END:variables
}

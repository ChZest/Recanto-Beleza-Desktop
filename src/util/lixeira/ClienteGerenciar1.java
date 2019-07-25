package util.lixeira;

import java.awt.Color;
import javax.swing.table.JTableHeader;
import entidades.Cliente;
import dados.ClienteDados;
import dados.DadosException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.ClienteEditar;
import interfaces.ClienteExcluir;
import interfaces.ClienteNovo;
import interfaces.ClienteVisualizar;

/* @author BIC-Jr Guia de Estilo */
public class ClienteGerenciar1 extends javax.swing.JDialog {

    List<Cliente> clientes = new ArrayList<>();

    public ClienteGerenciar1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        alterarIcone();
        preencherTabela();
    }

    // <editor-fold defaultstate="collapsed" desc="Código de Criação">
    private void alterarIcone() {
        URL url = this.getClass().getResource("/imagens/usuario.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        this.setLocationRelativeTo(null);
    }

    private void preencherLista() {
        try {
            clientes = ClienteDados.consultarTodos();
        } catch (DadosException ex) {
            Logger.getLogger(ClienteGerenciar1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTabela() {
        preencherLista();
        if (clientes != null) {
            String[] titulo = new String[]{"Nome", "Telefone", "E-mail"};
            String[][] linhas = new String[clientes.size()][3];
            for (int posicao = 0; posicao < clientes.size(); posicao++) {
                Cliente cliente = clientes.get(posicao);
                linhas[posicao][0] = cliente.getNmCliente();
                linhas[posicao][1] = cliente.getTelefone();
                linhas[posicao][2] = cliente.getEmail();
            }
            tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(linhas, titulo) {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(200);
            desabilitarBotoes();
        }
    }

    private void preencherTabela(List<Cliente> clientes) {
        if (clientes != null) {
            this.clientes = clientes;
            String[] titulo = new String[]{"Nome", "Telefone", "E-mail"};
            String[][] linhas = new String[clientes.size()][3];
            for (int posicao = 0; posicao < clientes.size(); posicao++) {
                Cliente cliente = clientes.get(posicao);
                linhas[posicao][0] = cliente.getNmCliente();
                linhas[posicao][1] = cliente.getTelefone();
                linhas[posicao][2] = cliente.getEmail();
            }
            tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(linhas, titulo) {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(200);
            desabilitarBotoes();
        } else {
            preencherTabela();
        }
    }

    private void desabilitarBotoes() {
        botaoEditar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoVisualizar.setEnabled(false);
    }

    private void consultarPorNome() {
        try {
            List<Cliente> cliente = ClienteDados.consultarCampos(campoPesquisa.getText());
            preencherTabela(cliente);
        } catch (DadosException ex) {
            Logger.getLogger(ClienteGerenciar1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Cliente getClienteFromTable() {
        Cliente cliente;
        int linha = tabelaClientes.getSelectedRow();
        cliente = clientes.get(linha);
        return cliente;
    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTopoPrincipal = new javax.swing.JPanel();
        painelRotuloClientes = new javax.swing.JPanel();
        rotuloNovoCliente = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        botaoNovo = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoVisualizar = new javax.swing.JButton();
        painelPesquisa = new javax.swing.JPanel();
        painelPesquisaMeio = new javax.swing.JPanel();
        painelPesquisaComponentes = new javax.swing.JPanel();
        painelRotuloPesquisa = new javax.swing.JPanel();
        rotuloPesquisa = new javax.swing.JLabel();
        painelCampoBotaoPesquisa = new javax.swing.JPanel();
        campoPesquisa = new javax.swing.JTextField();
        botaoPesquisa = new javax.swing.JButton();
        painelPesquisaOeste = new javax.swing.JPanel();
        painelPesquisaLeste = new javax.swing.JPanel();
        painelTabela = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        painelLestePrincipal = new javax.swing.JPanel();
        painelOestePrincipal = new javax.swing.JPanel();
        painelInferiorPrincipal = new javax.swing.JPanel();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Clientes");
        setIconImage(null);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(560, 330));

        painelTopoPrincipal.setLayout(new java.awt.BorderLayout());

        painelRotuloClientes.setBackground(new java.awt.Color(0, 0, 0));

        rotuloNovoCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rotuloNovoCliente.setForeground(new java.awt.Color(255, 255, 255));
        rotuloNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuario.png"))); // NOI18N
        rotuloNovoCliente.setText("CLIENTES");
        painelRotuloClientes.add(rotuloNovoCliente);

        painelTopoPrincipal.add(painelRotuloClientes, java.awt.BorderLayout.NORTH);

        botaoNovo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        botaoNovo.setMnemonic('n');
        botaoNovo.setText("Novo");
        botaoNovo.setToolTipText("Criar novo cliente");
        botaoNovo.setFocusable(false);
        botaoNovo.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoNovo);

        botaoEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        botaoEditar.setMnemonic('d');
        botaoEditar.setText("Editar");
        botaoEditar.setToolTipText("Editar o cliente selecionado");
        botaoEditar.setEnabled(false);
        botaoEditar.setFocusable(false);
        botaoEditar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoEditar);

        botaoExcluir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/apagar.png"))); // NOI18N
        botaoExcluir.setMnemonic('x');
        botaoExcluir.setText("Excluir");
        botaoExcluir.setToolTipText("Excluir o cliente selecionado");
        botaoExcluir.setEnabled(false);
        botaoExcluir.setFocusable(false);
        botaoExcluir.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoExcluir);

        botaoVisualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/olho.png"))); // NOI18N
        botaoVisualizar.setMnemonic('v');
        botaoVisualizar.setText("Visualizar");
        botaoVisualizar.setToolTipText("Visualizar detalhes do cliente selecionado");
        botaoVisualizar.setEnabled(false);
        botaoVisualizar.setFocusable(false);
        botaoVisualizar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVisualizarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoVisualizar);

        painelTopoPrincipal.add(painelBotoes, java.awt.BorderLayout.CENTER);

        painelPesquisa.setPreferredSize(new java.awt.Dimension(733, 60));
        painelPesquisa.setLayout(new java.awt.BorderLayout());

        painelPesquisaMeio.setPreferredSize(new java.awt.Dimension(633, 60));
        painelPesquisaMeio.setLayout(new java.awt.BorderLayout());

        painelPesquisaComponentes.setPreferredSize(new java.awt.Dimension(100, 60));
        painelPesquisaComponentes.setLayout(new java.awt.BorderLayout());

        painelRotuloPesquisa.setPreferredSize(new java.awt.Dimension(100, 25));
        painelRotuloPesquisa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        rotuloPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloPesquisa.setText("Pesquisar:");
        painelRotuloPesquisa.add(rotuloPesquisa);

        painelPesquisaComponentes.add(painelRotuloPesquisa, java.awt.BorderLayout.NORTH);

        painelCampoBotaoPesquisa.setPreferredSize(new java.awt.Dimension(100, 35));
        painelCampoBotaoPesquisa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        campoPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoPesquisa.setForeground(java.awt.Color.gray);
        campoPesquisa.setText("Digite aqui para pesquisar");
        campoPesquisa.setPreferredSize(new java.awt.Dimension(250, 30));
        campoPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPesquisaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPesquisaFocusLost(evt);
            }
        });
        campoPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoPesquisaKeyPressed(evt);
            }
        });
        painelCampoBotaoPesquisa.add(campoPesquisa);

        botaoPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        botaoPesquisa.setToolTipText("Pesquisar cliente");
        botaoPesquisa.setPreferredSize(new java.awt.Dimension(40, 32));
        botaoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisaActionPerformed(evt);
            }
        });
        painelCampoBotaoPesquisa.add(botaoPesquisa);

        painelPesquisaComponentes.add(painelCampoBotaoPesquisa, java.awt.BorderLayout.CENTER);

        painelPesquisaMeio.add(painelPesquisaComponentes, java.awt.BorderLayout.CENTER);

        painelPesquisa.add(painelPesquisaMeio, java.awt.BorderLayout.CENTER);

        painelPesquisaOeste.setPreferredSize(new java.awt.Dimension(50, 60));

        javax.swing.GroupLayout painelPesquisaOesteLayout = new javax.swing.GroupLayout(painelPesquisaOeste);
        painelPesquisaOeste.setLayout(painelPesquisaOesteLayout);
        painelPesquisaOesteLayout.setHorizontalGroup(
            painelPesquisaOesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        painelPesquisaOesteLayout.setVerticalGroup(
            painelPesquisaOesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        painelPesquisa.add(painelPesquisaOeste, java.awt.BorderLayout.WEST);

        painelPesquisaLeste.setPreferredSize(new java.awt.Dimension(50, 60));

        javax.swing.GroupLayout painelPesquisaLesteLayout = new javax.swing.GroupLayout(painelPesquisaLeste);
        painelPesquisaLeste.setLayout(painelPesquisaLesteLayout);
        painelPesquisaLesteLayout.setHorizontalGroup(
            painelPesquisaLesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        painelPesquisaLesteLayout.setVerticalGroup(
            painelPesquisaLesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        painelPesquisa.add(painelPesquisaLeste, java.awt.BorderLayout.EAST);

        painelTopoPrincipal.add(painelPesquisa, java.awt.BorderLayout.SOUTH);

        getContentPane().add(painelTopoPrincipal, java.awt.BorderLayout.NORTH);

        tabelaClientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Aline Maria Machado", "(31)94569-5123", "aline@cefetmg.br"},
                {"Breno Ribeiro Fernandes", "(32)98746-3211", "breno@cefetmg.br"},
                {"Cíntia Souza Ferreira", "(33)90123-6458", "cintia@cefetmg.br"},
                {"Diego Araújo Oliveira", "(31)83645-5231", "diego@cefetmg.br"},
                {"Emily Castro Gomes", "(32)90321-4756", "emily@cefetmg.br"}
            },
            new String [] {
                "Nome", "Telefone", "E-mail"
            }
        ));
        tabelaClientes.setRowHeight(30);
        tabelaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaClientes.setShowVerticalLines(false);
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        painelTabela.setViewportView(tabelaClientes);
        JTableHeader cabecalho = tabelaClientes.getTableHeader();
        cabecalho.setFont(new java.awt.Font("Arial", 0, 14));
        tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(200);

        getContentPane().add(painelTabela, java.awt.BorderLayout.CENTER);

        painelLestePrincipal.setPreferredSize(new java.awt.Dimension(50, 401));

        javax.swing.GroupLayout painelLestePrincipalLayout = new javax.swing.GroupLayout(painelLestePrincipal);
        painelLestePrincipal.setLayout(painelLestePrincipalLayout);
        painelLestePrincipalLayout.setHorizontalGroup(
            painelLestePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        painelLestePrincipalLayout.setVerticalGroup(
            painelLestePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        getContentPane().add(painelLestePrincipal, java.awt.BorderLayout.EAST);

        painelOestePrincipal.setPreferredSize(new java.awt.Dimension(50, 401));

        javax.swing.GroupLayout painelOestePrincipalLayout = new javax.swing.GroupLayout(painelOestePrincipal);
        painelOestePrincipal.setLayout(painelOestePrincipalLayout);
        painelOestePrincipalLayout.setHorizontalGroup(
            painelOestePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        painelOestePrincipalLayout.setVerticalGroup(
            painelOestePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        getContentPane().add(painelOestePrincipal, java.awt.BorderLayout.WEST);

        painelInferiorPrincipal.setPreferredSize(new java.awt.Dimension(733, 50));
        painelInferiorPrincipal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 50, 10));

        botaoVoltar.setBackground(new java.awt.Color(135, 206, 235));
        botaoVoltar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoVoltar.setMnemonic('v');
        botaoVoltar.setText("Voltar");
        botaoVoltar.setContentAreaFilled(false);
        botaoVoltar.setMaximumSize(new java.awt.Dimension(89, 25));
        botaoVoltar.setMinimumSize(new java.awt.Dimension(89, 25));
        botaoVoltar.setOpaque(true);
        botaoVoltar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        painelInferiorPrincipal.add(botaoVoltar);

        getContentPane().add(painelInferiorPrincipal, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Eventos">
    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        botaoEditar.setEnabled(true);
        botaoExcluir.setEnabled(true);
        botaoVisualizar.setEnabled(true);
        if (evt.getClickCount() == 2) {
            Cliente cliente = getClienteFromTable();
            ClienteVisualizar clienteVisualizar = new ClienteVisualizar(null, true, cliente);
            clienteVisualizar.setVisible(true);
        }
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void campoPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisaFocusGained
        if (campoPesquisa.getText().equals("Digite aqui para pesquisar")) {
            campoPesquisa.setText("");
            campoPesquisa.setForeground(Color.black);
        }
    }//GEN-LAST:event_campoPesquisaFocusGained

    private void campoPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPesquisaFocusLost
        if (campoPesquisa.getText().equals("")) {
            campoPesquisa.setText("Digite aqui para pesquisar");
            campoPesquisa.setForeground(Color.gray);
        }
    }//GEN-LAST:event_campoPesquisaFocusLost

    private void botaoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisaActionPerformed
        if (campoPesquisa.getText().equals("Digite aqui para pesquisar")) {
            preencherTabela();
        } else {
            consultarPorNome();
        }
    }//GEN-LAST:event_botaoPesquisaActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        ClienteNovo clienteNovo = new ClienteNovo(null, true);
        clienteNovo.setVisible(true);

        Cliente cliente = clienteNovo.getCliente();
        if (cliente != null) {
            preencherTabela();
        }
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        Cliente cliente = getClienteFromTable();
        ClienteEditar clienteEditar = new ClienteEditar(null, true, cliente);
        clienteEditar.setVisible(true);

        cliente = clienteEditar.getCliente();
        if (cliente != null) {
            int linha = tabelaClientes.getSelectedRow();
            preencherTabela();
            tabelaClientes.setRowSelectionInterval(linha, linha);
            tabelaClientes.setValueAt(cliente.getNmCliente(), linha, 0);
            tabelaClientes.setValueAt(cliente.getTelefone(), linha, 1);
            tabelaClientes.setValueAt(cliente.getEmail(), linha, 2);
            botaoEditar.setEnabled(true);
            botaoExcluir.setEnabled(true);
            botaoVisualizar.setEnabled(true);
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizarActionPerformed
        Cliente cliente = getClienteFromTable();
        ClienteVisualizar clienteVisualizar = new ClienteVisualizar(null, true, cliente);
        clienteVisualizar.setVisible(true);
    }//GEN-LAST:event_botaoVisualizarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        Cliente cliente = getClienteFromTable();
        ClienteExcluir clienteExcluir = new ClienteExcluir(null, true, cliente);
        clienteExcluir.setVisible(true);

        if (clienteExcluir.getOpcao()) {
            preencherTabela();
            desabilitarBotoes();
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void campoPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisaKeyPressed
        if (evt.getKeyCode() == 10) {
            consultarPorNome();
        }
    }//GEN-LAST:event_campoPesquisaKeyPressed
// </editor-fold>

    /* @param args the command line arguments */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Código Look and Feel (optional) ">
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
            java.util.logging.Logger.getLogger(ClienteGerenciar1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ClienteGerenciar1 dialog = new ClienteGerenciar1(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoPesquisa;
    private javax.swing.JButton botaoVisualizar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelCampoBotaoPesquisa;
    private javax.swing.JPanel painelInferiorPrincipal;
    private javax.swing.JPanel painelLestePrincipal;
    private javax.swing.JPanel painelOestePrincipal;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JPanel painelPesquisaComponentes;
    private javax.swing.JPanel painelPesquisaLeste;
    private javax.swing.JPanel painelPesquisaMeio;
    private javax.swing.JPanel painelPesquisaOeste;
    private javax.swing.JPanel painelRotuloClientes;
    private javax.swing.JPanel painelRotuloPesquisa;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTopoPrincipal;
    private javax.swing.JLabel rotuloNovoCliente;
    private javax.swing.JLabel rotuloPesquisa;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}

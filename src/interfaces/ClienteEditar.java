package interfaces;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Image;
import java.net.URL;
import java.text.ParseException;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import util.DateParse;
import entidades.Contato;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import entidades.Cliente;
import dados.ClienteDados;
import dados.DadosException;
import entidades.Cidade;
import javax.swing.DefaultListModel;

/**
 * @author BIC-Jr Guia de Estilo
 */
public class ClienteEditar extends javax.swing.JDialog {

    public ClienteEditar(java.awt.Frame parent, boolean modal, Cliente clienteAntigo) {
        super(parent, modal);
        initComponents();
        redimencionarTela();
        alterarIcone();
        preencherFormulario(clienteAntigo);
        preencherCidades(clienteAntigo);
        preencherContatos();
    }

    public Cliente getCliente() {
        return clienteNovo;
    }

    private void alterarIcone() {
        URL url = this.getClass().getResource("/imagens/usuario.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        this.setLocationRelativeTo(null);
        util.JanelaComum.setAcessibilidade(this);
        this.setLocationRelativeTo(null);
        painelRolavel.getVerticalScrollBar().setUnitIncrement(16);
//        try {
//            seletorDeData.setDate(util.DateParse.parseDate(campoDataDeNascimento.getText()));
//        } catch (ParseException e) {
//
//        }
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
        if (d.width >= 630 && d.height >= 860) {
            this.setMinimumSize(new java.awt.Dimension(610, 810));
            this.setSize(610, 840);
            this.setResizable(false);
        } else {
            this.setMinimumSize(new java.awt.Dimension(630, d.height - 50));
            this.setSize(630, d.height - 50);
//            this.setResizable(true);
        }
    }

    private void preencherFormulario(Cliente cliente) {
        codigo = cliente.getCdCliente();
        campoNomeCompleto.setText(cliente.getNmCliente());
        if (cliente.getSexo().equals("m")) {
            radioMasculino.setSelected(true);
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
        preencherTabelaContato();
    }

    private void preencherCidades(Cliente cliente) {
        cities = new ArrayList<>();
        cities.add(new entidades.Cidade(1, "Fabriciano"));
        cities.add(new entidades.Cidade(2, "Ipatinga"));
        cities.add(new entidades.Cidade(3, "Timóteo"));
        cidades = new ArrayList<>();
        cidades.add("Fabriciano");
        cidades.add("Ipatinga");
        cidades.add("Timóteo");
        modeloCidade = new DefaultListModel();
        listaCidade.setModel(modeloCidade);
        cidades.forEach((cidade) -> {
            modeloCidade.addElement(cidade);
        });
        cidades.stream().filter((cidade) -> (cidade.equals(cliente.getNmCidade()))).map((cidade) -> {
            campoCidade.setText(cidade);
            return cidade;
        }).forEachOrdered((_item) -> {
            selecaoCidade = true;
        });
    }

    private void pesquisarCidade() {
        modeloCidade.removeAllElements();
        int contador = 0;
        for (int i = 0; i < cidades.size(); i++) {
            if (cidades.get(i).toLowerCase().startsWith(campoCidade.getText().toLowerCase())) {
                modeloCidade.addElement(cidades.get(i));
                contador++;
            }
        }
        if (contador <= 3) {
            painelListaCidade.setBounds(310, 460, 260, contador * 20 + 1);
        } else {
            painelListaCidade.setBounds(310, 460, 260, 131);
        }
        painelListaCidade.setVisible(true);
    }

    private void preencherContatos() {
        contatos.add(new Contato("(31)98765-4321", "Celular"));
        contatos.add(new Contato("(31)90123-4567", "Comercial"));
        contatos.add(new Contato("(31)3846-0808", "Fixo"));
        preencherTabelaContato();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDeBotoesSexo = new javax.swing.ButtonGroup();
        painelRolavel = new javax.swing.JScrollPane();
        painelFormulario = new javax.swing.JPanel();
        painelCamadas = new javax.swing.JLayeredPane();
        campoDataDeNascimento = new javax.swing.JFormattedTextField();
        painelDadosPessoais = new javax.swing.JPanel();
        rotuloNomeCompleto = new javax.swing.JLabel();
        campoNomeCompleto = new javax.swing.JTextField();
        rotuloDataDeNascimento = new javax.swing.JLabel();
        painelSexo = new javax.swing.JPanel();
        radioFeminino = new javax.swing.JRadioButton();
        radioMasculino = new javax.swing.JRadioButton();
        campoCPF = new javax.swing.JFormattedTextField();
        rotuloCPF = new javax.swing.JLabel();
        rotuloEmail = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        campoRG = new javax.swing.JTextField();
        rotuloRG = new javax.swing.JLabel();
        rotuloNomeObrigatorio = new javax.swing.JLabel();
        rotuloSexoObrigatorio = new javax.swing.JLabel();
        rotuloDataObrigatorio = new javax.swing.JLabel();
        rotuloCPFObrigatorio = new javax.swing.JLabel();
        rotuloRGObrigatorio = new javax.swing.JLabel();
        rotuloEmailObrigatorio = new javax.swing.JLabel();
        painelContato = new javax.swing.JPanel();
        painelTabela = new javax.swing.JScrollPane();
        tabelaContato = new javax.swing.JTable();
        rotuloTelefone = new javax.swing.JLabel();
        rotuloObservacao = new javax.swing.JLabel();
        campoObservacao = new javax.swing.JTextField();
        campoTelefone = new javax.swing.JFormattedTextField();
        botaoRemoverContato = new javax.swing.JButton();
        botaoAdicionarContato = new javax.swing.JButton();
        rotuloTelefoneObrigatorio = new javax.swing.JLabel();
        rotuloObservacaoObrigatorio = new javax.swing.JLabel();
        rotuloContatoObrigatorio = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        rotuloObrigatorios = new javax.swing.JLabel();
        rotuloAsterisco = new javax.swing.JLabel();
        rotuloDados = new javax.swing.JLabel();
        bordaOci = new javax.swing.JSeparator();
        bordaMer = new javax.swing.JSeparator();
        bordaOri = new javax.swing.JSeparator();
        bordaSet = new javax.swing.JSeparator();
        bordaCen = new javax.swing.JSeparator();
        rotuloCidade = new javax.swing.JLabel();
        botaoComboCidade = new javax.swing.JButton();
        campoCidade = new javax.swing.JTextField();
        painelListaCidade = new javax.swing.JScrollPane();
        listaCidade = new javax.swing.JList<>();
        rotuloCidadeObrigatorio = new javax.swing.JLabel();
        campoCEP = new javax.swing.JFormattedTextField();
        rotuloCEPObrigatorio = new javax.swing.JLabel();
        rotuloCEP = new javax.swing.JLabel();
        campoComplemento = new javax.swing.JTextField();
        rotuloComplemento = new javax.swing.JLabel();
        rotuloRuaObrigatorio = new javax.swing.JLabel();
        campoRua = new javax.swing.JTextField();
        rotuloRua = new javax.swing.JLabel();
        rotuloBairroObrigatorio = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        rotuloBairro = new javax.swing.JLabel();
        rotuloNumeroObrigatorio = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        rotuloNumero = new javax.swing.JLabel();
        painelTitulo = new javax.swing.JPanel();
        rotuloNovoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Clientes");
        setMaximumSize(new java.awt.Dimension(630, 860));
        setMinimumSize(new java.awt.Dimension(630, 500));
        setPreferredSize(new java.awt.Dimension(630, 500));
        setResizable(false);

        painelRolavel.setBorder(null);

        painelFormulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelCamadas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoDataDeNascimento.setText("10/12/1992");
        campoDataDeNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoDataDeNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoDataDeNascimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoDataDeNascimentoFocusLost(evt);
            }
        });
        painelCamadas.add(campoDataDeNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 260, 30));
        try {
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
            campoDataDeNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
        } catch (ParseException e) {}

        painelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        painelDadosPessoais.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        painelDadosPessoais.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rotuloNomeCompleto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloNomeCompleto.setText("Nome Completo:*");
        painelDadosPessoais.add(rotuloNomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        campoNomeCompleto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoNomeCompleto.setText("Regina Maria Souza Carvalho");
        campoNomeCompleto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNomeCompletoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNomeCompletoFocusLost(evt);
            }
        });
        campoNomeCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNomeCompletoKeyTyped(evt);
            }
        });
        painelDadosPessoais.add(campoNomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 30));

        rotuloDataDeNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloDataDeNascimento.setText("Data de Nascimento:*");
        painelDadosPessoais.add(rotuloDataDeNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        painelSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sexo*", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        painelSexo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoDeBotoesSexo.add(radioFeminino);
        radioFeminino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radioFeminino.setSelected(true);
        radioFeminino.setText("Feminino");
        radioFeminino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelSexo.add(radioFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        grupoDeBotoesSexo.add(radioMasculino);
        radioMasculino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        radioMasculino.setText("Masculino");
        radioMasculino.setToolTipText("");
        radioMasculino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelSexo.add(radioMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        painelDadosPessoais.add(painelSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 190, 50));

        campoCPF.setText("123.456.789-00");
        campoCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoCPF.setPreferredSize(null);
        campoCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCPFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCPFFocusLost(evt);
            }
        });
        painelDadosPessoais.add(campoCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 260, 30));
        try {
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholderCharacter('_');
            campoCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        } catch (ParseException e) {}

        rotuloCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloCPF.setText("CPF:*");
        painelDadosPessoais.add(rotuloCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        rotuloEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloEmail.setText("E-mail:*");
        painelDadosPessoais.add(rotuloEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        campoEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoEmail.setText("regina.msc@negocios.com");
        campoEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoEmailFocusLost(evt);
            }
        });
        painelDadosPessoais.add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 260, 30));

        campoRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoRG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoRGFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRGFocusLost(evt);
            }
        });
        painelDadosPessoais.add(campoRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 30));

        rotuloRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloRG.setText("RG:*");
        painelDadosPessoais.add(rotuloRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        rotuloNomeObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloNomeObrigatorio.setText("Preencha este campo");
        painelDadosPessoais.add(rotuloNomeObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 340, -1));
        rotuloNomeObrigatorio.setVisible(false);

        rotuloSexoObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloSexoObrigatorio.setText("Selecione uma opção");
        painelDadosPessoais.add(rotuloSexoObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 70, 190, -1));
        rotuloSexoObrigatorio.setVisible(false);

        rotuloDataObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloDataObrigatorio.setText("Preencha com uma data válida");
        painelDadosPessoais.add(rotuloDataObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 260, -1));
        rotuloDataObrigatorio.setVisible(false);

        rotuloCPFObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloCPFObrigatorio.setText("Preencha com um CPF válido");
        painelDadosPessoais.add(rotuloCPFObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 260, -1));
        rotuloCPFObrigatorio.setVisible(false);

        rotuloRGObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloRGObrigatorio.setText("Preencha este campo");
        painelDadosPessoais.add(rotuloRGObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 260, -1));
        rotuloRGObrigatorio.setVisible(false);

        rotuloEmailObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloEmailObrigatorio.setText("Preencha este campo");
        painelDadosPessoais.add(rotuloEmailObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 260, -1));
        rotuloEmailObrigatorio.setVisible(false);

        painelCamadas.add(painelDadosPessoais, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 580, 230));

        painelContato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        painelContato.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelTabela.setPreferredSize(new java.awt.Dimension(300, 200));

        tabelaContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tabelaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"(31)98765-4321", "Celular"},
                {"(31)90123-4567", "Comercial"},
                {"(31)3846-0808", "Casa"}
            },
            new String [] {
                "Telefone", "Observação"
            }
        ));
        tabelaContato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelaContato.setRowHeight(30);
        tabelaContato.setShowVerticalLines(false);
        tabelaContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContatoMouseClicked(evt);
            }
        });
        painelTabela.setViewportView(tabelaContato);
        tabelaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"(31)98765-4321", "Celular"},
                {"(31)90123-4567", "Comercial"},
                {"(31)3846-0808", "Casa"}
            },
            new String [] {
                "Telefone", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });

        JTableHeader cabecalho = tabelaContato.getTableHeader();
        cabecalho.setFont(new java.awt.Font("Arial", 0, 14));

        painelContato.add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 320, 165));

        rotuloTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloTelefone.setText("Telefone*:");
        painelContato.add(rotuloTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, -1, -1));

        rotuloObservacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloObservacao.setText("Observação*:");
        painelContato.add(rotuloObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        campoObservacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoObservacao.setPreferredSize(new java.awt.Dimension(109, 23));
        campoObservacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoObservacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoObservacaoFocusLost(evt);
            }
        });
        painelContato.add(campoObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 170, 30));

        campoTelefone.setForeground(java.awt.Color.gray);
        campoTelefone.setText("(00)0000-00000");
        campoTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoTelefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTelefoneFocusLost(evt);
            }
        });
        painelContato.add(campoTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 45, 170, 30));

        botaoRemoverContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoRemoverContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelaRemover.png"))); // NOI18N
        botaoRemoverContato.setMnemonic('r');
        botaoRemoverContato.setToolTipText("Remover contato selecionado (Alt+R)");
        botaoRemoverContato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoRemoverContato.setEnabled(false);
        botaoRemoverContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverContatoActionPerformed(evt);
            }
        });
        painelContato.add(botaoRemoverContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 35, 35));

        botaoAdicionarContato.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoAdicionarContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tabelaInserir.png"))); // NOI18N
        botaoAdicionarContato.setMnemonic('a');
        botaoAdicionarContato.setToolTipText("Adicionar contato à tabela (Alt+A)");
        botaoAdicionarContato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoAdicionarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarContatoActionPerformed(evt);
            }
        });
        painelContato.add(botaoAdicionarContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 150, 35, 35));

        rotuloTelefoneObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloTelefoneObrigatorio.setText("Preencha com um telefone válido");
        painelContato.add(rotuloTelefoneObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, 170, -1));
        rotuloTelefoneObrigatorio.setVisible(false);

        rotuloObservacaoObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloObservacaoObrigatorio.setText("Preencha este campo");
        painelContato.add(rotuloObservacaoObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, -1));
        rotuloObservacaoObrigatorio.setVisible(false);

        rotuloContatoObrigatorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloContatoObrigatorio.setText("Insira pelo menos um contato na tabela");
        painelContato.add(rotuloContatoObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 320, -1));
        rotuloContatoObrigatorio.setVisible(false);

        painelCamadas.add(painelContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 580, 220));

        painelBotoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        botaoCancelar.setBackground(new java.awt.Color(135, 206, 235));
        botaoCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoCancelar.setMnemonic('c');
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setToolTipText("Cancelar esta edição (Alt+C)");
        botaoCancelar.setContentAreaFilled(false);
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.setOpaque(true);
        botaoCancelar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoCancelar);

        botaoSalvar.setBackground(new java.awt.Color(46, 139, 87));
        botaoSalvar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoSalvar.setMnemonic('s');
        botaoSalvar.setText("Salvar");
        botaoSalvar.setToolTipText("Salvar esta edição (Alt+S)");
        botaoSalvar.setContentAreaFilled(false);
        botaoSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSalvar.setMaximumSize(new java.awt.Dimension(89, 25));
        botaoSalvar.setMinimumSize(new java.awt.Dimension(89, 25));
        botaoSalvar.setOpaque(true);
        botaoSalvar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });
        painelBotoes.add(botaoSalvar);

        painelCamadas.add(painelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 582, 50));

        rotuloObrigatorios.setText(" indica campos obrigatórios");
        painelCamadas.add(rotuloObrigatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 5, -1, -1));

        rotuloAsterisco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloAsterisco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rotuloAsterisco.setText("*");
        painelCamadas.add(rotuloAsterisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 0, 20, 30));

        rotuloDados.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloDados.setText("Endereço");
        painelCamadas.add(rotuloDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 252, -1, -1));

        bordaOci.setForeground(new java.awt.Color(0, 0, 0));
        bordaOci.setOrientation(javax.swing.SwingConstants.VERTICAL);
        painelCamadas.add(bordaOci, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1, 215));

        bordaMer.setForeground(new java.awt.Color(0, 0, 0));
        bordaMer.setPreferredSize(new java.awt.Dimension(40, 1));
        painelCamadas.add(bordaMer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 475, 579, -1));

        bordaOri.setForeground(new java.awt.Color(0, 0, 0));
        bordaOri.setOrientation(javax.swing.SwingConstants.VERTICAL);
        painelCamadas.add(bordaOri, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 260, 1, 215));

        bordaSet.setForeground(new java.awt.Color(0, 0, 0));
        bordaSet.setPreferredSize(new java.awt.Dimension(40, 1));
        painelCamadas.add(bordaSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 260, 505, -1));

        bordaCen.setForeground(new java.awt.Color(0, 0, 0));
        bordaCen.setPreferredSize(new java.awt.Dimension(40, 1));
        painelCamadas.add(bordaCen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 5, -1));

        rotuloCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloCidade.setText("Cidade*:");
        painelCamadas.add(rotuloCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        botaoComboCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/seta.png"))); // NOI18N
        botaoComboCidade.setContentAreaFilled(false);
        botaoComboCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoComboCidade.setFocusable(false);
        botaoComboCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComboCidadeActionPerformed(evt);
            }
        });
        painelCamadas.add(botaoComboCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 430, 35, 31));

        campoCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCidadeFocusLost(evt);
            }
        });
        campoCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCidadeMouseClicked(evt);
            }
        });
        campoCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoCidadeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCidadeKeyTyped(evt);
            }
        });
        painelCamadas.add(campoCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 260, 30));

        listaCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listaCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listaCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaCidadeMousePressed(evt);
            }
        });
        painelListaCidade.setViewportView(listaCidade);

        painelCamadas.setLayer(painelListaCidade, javax.swing.JLayeredPane.POPUP_LAYER);
        painelCamadas.add(painelListaCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 260, 40));
        painelListaCidade.setVisible(false);

        rotuloCidadeObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloCidadeObrigatorio.setText("Selecione uma cidade");
        painelCamadas.add(rotuloCidadeObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 230, -1));
        rotuloCidadeObrigatorio.setVisible(false);

        campoCEP.setText("11.111-111");
        campoCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoCEPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCEPFocusLost(evt);
            }
        });
        painelCamadas.add(campoCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 260, 30));
        try {
            MaskFormatter mascaraCep = new MaskFormatter("##.###-###");
            mascaraCep.setPlaceholderCharacter('_');
            campoCEP.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
        } catch (ParseException e) {}

        rotuloCEPObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloCEPObrigatorio.setText("Preencha com um CEP válido");
        painelCamadas.add(rotuloCEPObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 260, -1));
        rotuloCEPObrigatorio.setVisible(false);

        rotuloCEP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloCEP.setText("CEP:*");
        painelCamadas.add(rotuloCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        campoComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoComplemento.setText("Casa");
        campoComplemento.setToolTipText("");
        campoComplemento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoComplementoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoComplementoFocusLost(evt);
            }
        });
        painelCamadas.add(campoComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 260, 30));

        rotuloComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloComplemento.setText("Complemento:");
        painelCamadas.add(rotuloComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        rotuloRuaObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloRuaObrigatorio.setText("Preencha este campo");
        painelCamadas.add(rotuloRuaObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 260, -1));
        rotuloRuaObrigatorio.setVisible(false);

        campoRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoRua.setText("Castanheira");
        campoRua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoRuaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRuaFocusLost(evt);
            }
        });
        campoRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoRuaKeyTyped(evt);
            }
        });
        painelCamadas.add(campoRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 260, 30));

        rotuloRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloRua.setText("Rua:*");
        painelCamadas.add(rotuloRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        rotuloBairroObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloBairroObrigatorio.setText("Preencha este campo");
        painelCamadas.add(rotuloBairroObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 260, -1));
        rotuloBairroObrigatorio.setVisible(false);

        campoBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoBairro.setText("Floresta");
        campoBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoBairroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoBairroFocusLost(evt);
            }
        });
        campoBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBairroKeyTyped(evt);
            }
        });
        painelCamadas.add(campoBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 260, 30));

        rotuloBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloBairro.setText("Bairro:*");
        painelCamadas.add(rotuloBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        rotuloNumeroObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        rotuloNumeroObrigatorio.setText("Preencha este campo");
        painelCamadas.add(rotuloNumeroObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 260, -1));
        rotuloNumeroObrigatorio.setVisible(false);

        campoNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoNumero.setText("99");
        campoNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNumeroFocusLost(evt);
            }
        });
        campoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumeroKeyTyped(evt);
            }
        });
        painelCamadas.add(campoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 260, 30));

        rotuloNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloNumero.setText("Número:*");
        painelCamadas.add(rotuloNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        painelFormulario.add(painelCamadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, -1, -1));

        painelRolavel.setViewportView(painelFormulario);

        getContentPane().add(painelRolavel, java.awt.BorderLayout.CENTER);

        painelTitulo.setBackground(new java.awt.Color(0, 0, 0));

        rotuloNovoCliente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rotuloNovoCliente.setForeground(new java.awt.Color(255, 255, 255));
        rotuloNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarioEditar.png"))); // NOI18N
        rotuloNovoCliente.setText("EDITAR CLIENTE");
        painelTitulo.add(rotuloNovoCliente);

        getContentPane().add(painelTitulo, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeCompletoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNomeCompletoFocusLost
        validaNome();
    }//GEN-LAST:event_campoNomeCompletoFocusLost

    private void campoDataDeNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDataDeNascimentoFocusLost
        String data = campoDataDeNascimento.getText();
        data = data.replace("/", "");
        data = data.replace("_", "");
        data = data.replace("d", "");
        data = data.replace("m", "");
        data = data.replace("a", "");
        if (data.equals("")) {
            campoDataDeNascimento.setForeground(Color.GRAY);
            campoDataDeNascimento.setFormatterFactory(null);
            campoDataDeNascimento.setText("dd/mm/aaaa");
        }
        validaData();
    }//GEN-LAST:event_campoDataDeNascimentoFocusLost

    private void campoCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCPFFocusLost
        String cpf = campoCPF.getText();
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        cpf = cpf.replace("_", "");
        if (cpf.equals("")) {
            campoCPF.setForeground(Color.GRAY);
            campoCPF.setFormatterFactory(null);
            campoCPF.setText("000.000.000-00");
        }
        validaCpf();
    }//GEN-LAST:event_campoCPFFocusLost

    private void campoEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoEmailFocusLost
        validaEmail();
    }//GEN-LAST:event_campoEmailFocusLost

    private void campoRuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoRuaFocusLost
        validaRua();
    }//GEN-LAST:event_campoRuaFocusLost

    private void campoBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBairroFocusLost
        validaBairro();
    }//GEN-LAST:event_campoBairroFocusLost

    private void campoCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCEPFocusLost
        String cep = campoCEP.getText();
        cep = cep.replace("-", "");
        cep = cep.replace(".", "");
        cep = cep.replace("_", "");
        if (cep.equals("") || cep.equals("00000000")) {
            campoCEP.setForeground(Color.GRAY);
            campoCEP.setFormatterFactory(null);
            campoCEP.setText("00.000-000");
        }
        validaCep();
    }//GEN-LAST:event_campoCEPFocusLost

    private void campoDataDeNascimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoDataDeNascimentoFocusGained
        focoData();
    }//GEN-LAST:event_campoDataDeNascimentoFocusGained

    private void campoCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCPFFocusGained
        campoCPF.setBorder(new LineBorder(Color.BLUE));
        if (campoCPF.getText().equals("000.000.000-00")) {
            campoCPF.setForeground(Color.BLACK);
            campoCPF.setText("");
            try {
                MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
                mascaraCpf.setPlaceholderCharacter('_');
                campoCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
                campoCPF.setText("");
            } catch (ParseException e) {

            }
        }
    }//GEN-LAST:event_campoCPFFocusGained

    private void campoCEPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCEPFocusGained
        if (campoCEP.getText().equals("00.000-000")) {
            campoCEP.setForeground(Color.BLACK);
            campoCEP.setBorder(new LineBorder(Color.BLUE));
            campoCEP.setText("");
            try {
                MaskFormatter mascaraCep = new MaskFormatter("##.###-###");
                mascaraCep.setPlaceholderCharacter('_');
                campoCEP.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
                campoCEP.setText("");
            } catch (ParseException e) {

            }
        }
    }//GEN-LAST:event_campoCEPFocusGained

    private void campoNomeCompletoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNomeCompletoFocusGained
        campoNomeCompleto.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoNomeCompletoFocusGained

    private void campoEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoEmailFocusGained
        if (campoEmail.getText().equals("nome@exemplo.com")) {
            campoEmail.setForeground(Color.BLACK);
            campoEmail.setText("");
            campoEmail.setBorder(new LineBorder(Color.BLUE));
        }
    }//GEN-LAST:event_campoEmailFocusGained

    private void campoNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroFocusLost
        validaNumero();
    }//GEN-LAST:event_campoNumeroFocusLost

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        boolean nome = validaNome();
        boolean data = validaData();
        boolean cpf = validaCpf();
        boolean email = validaEmail();
        boolean rua = validaRua();
        boolean numero = validaNumero();
        boolean bairro = validaBairro();
        boolean cep = validaCep();
        boolean sexo = validaSexo();
        boolean contato = validaContato();
        boolean cidade = validaCidade();
        if (nome && data && cpf && email && rua && numero && bairro && cep && sexo && contato && cidade) {
            String s = "f";
            if (radioMasculino.isSelected()) {
                s = "m";
            }
            java.util.Date dtNasc = new java.util.Date();
            try {
                dtNasc = DateParse.parseDate(campoDataDeNascimento.getText());
            } catch (ParseException ex) {
            }
            Cidade city = new Cidade();
            if (modeloCidade.getSize() < 4) {
                String c = listaCidade.getSelectedValue();
                for (int i = 0; i < cities.size(); i++) {
                    if (c.equals(cities.get(i).getNmCidade())) {
                        city = cities.get(i);
                    }
                }
            } else {
                city = cities.get(0);
            }
            clienteNovo = new Cliente(codigo,
                    campoNomeCompleto.getText(),
                    s,
                    dtNasc,
                    campoCPF.getText(),
                    campoRG.getText(),
                    campoEmail.getText(),
                    campoRua.getText(),
                    Integer.parseInt(campoNumero.getText()),
                    campoComplemento.getText(),
                    campoBairro.getText(),
                    campoCEP.getText(),
                    city.getCdCidade(),
                    tabelaContato.getModel().getValueAt(0, 0).toString(),
                    tabelaContato.getModel().getValueAt(0, 1).toString()
            );
            try {
                ClienteDados.alterar(clienteNovo);
                clienteNovo = ClienteDados.consultarPorCodigo(codigo);
            } catch (DadosException ex) {
                Problema erroDeConexao = new Problema(new javax.swing.JFrame(), true, ex.getMessage());
                erroDeConexao.setVisible(true);
            }
            dispose();
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void campoTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTelefoneFocusGained
        campoTelefone.setBorder(new LineBorder(Color.BLUE));
        if (campoTelefone.getText().equals("(00)0000-00000")) {
            campoTelefone.setForeground(Color.BLACK);
            campoTelefone.setText("");
            try {
                MaskFormatter mascaraTelefone = new MaskFormatter("(##)####-#####");
                mascaraTelefone.setPlaceholderCharacter('_');
                campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
                campoTelefone.setText("");
            } catch (ParseException e) {
            }
        }
    }//GEN-LAST:event_campoTelefoneFocusGained

    private void campoTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTelefoneFocusLost
        String telefone = campoTelefone.getText();
        telefone = telefone.replace("-", "");
        telefone = telefone.replace("(", "");
        telefone = telefone.replace(")", "");
        telefone = telefone.replace("_", "");
        if (telefone.equals("")) {
            campoTelefone.setForeground(Color.GRAY);
            campoTelefone.setFormatterFactory(null);
            campoTelefone.setText("(00)0000-00000");
        }
        validaTelefone();
    }//GEN-LAST:event_campoTelefoneFocusLost

    private void botaoAdicionarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarContatoActionPerformed
        adt = true;
        boolean telefone = validaTelefone();
        boolean observacao = validaObservacao();
        if (telefone && observacao) {
            adt = false;
            contatos.add(new Contato(campoTelefone.getText(), campoObservacao.getText()));
            preencherTabelaContato();
            campoTelefone.setForeground(Color.GRAY);
            campoTelefone.setFormatterFactory(null);
            campoTelefone.setText(null);
            campoTelefone.setText("(00)0000-00000");
            campoObservacao.setText("");
            campoTelefone.setBorder(new LineBorder(Color.GRAY));
            campoObservacao.setBorder(new LineBorder(Color.GRAY));
            rotuloContatoObrigatorio.setVisible(false);
        }
    }//GEN-LAST:event_botaoAdicionarContatoActionPerformed

    private void campoObservacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoObservacaoFocusGained
        campoObservacao.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoObservacaoFocusGained

    private void campoObservacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoObservacaoFocusLost
        validaObservacao();
    }//GEN-LAST:event_campoObservacaoFocusLost

    private void tabelaContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContatoMouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            botaoRemoverContato.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaContatoMouseClicked

    private void botaoRemoverContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverContatoActionPerformed
        int linha = tabelaContato.getSelectedRow();
        DefaultTableModel m = (DefaultTableModel) tabelaContato.getModel();
        m.removeRow(linha);
        contatos = getContatoFromTable();
        preencherTabelaContato();
        if (tabelaContato.getRowCount() == 0) {
            rotuloContatoObrigatorio.setVisible(true);
        }
    }//GEN-LAST:event_botaoRemoverContatoActionPerformed

    private void campoRGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoRGFocusLost
        validaRg();
    }//GEN-LAST:event_campoRGFocusLost

    private void campoRGFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoRGFocusGained
        campoRG.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoRGFocusGained

    private void campoRuaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoRuaFocusGained
        campoRua.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoRuaFocusGained

    private void campoNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNumeroFocusGained
        campoNumero.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoNumeroFocusGained

    private void campoComplementoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoComplementoFocusGained
        campoComplemento.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoComplementoFocusGained

    private void campoComplementoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoComplementoFocusLost
        campoComplemento.setBorder(new LineBorder(Color.GRAY));
    }//GEN-LAST:event_campoComplementoFocusLost

    private void campoBairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBairroFocusGained
        campoBairro.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoBairroFocusGained

    private void campoCidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCidadeFocusGained
        campoCidade.setBorder(new LineBorder(Color.BLUE));
        //        if (!selecaoServico) {
        //            painelListaServico.setVisible(true);
        //        } else {
        //            painelListaServico.setVisible(false);
        //        }
    }//GEN-LAST:event_campoCidadeFocusGained

    private void campoCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCidadeFocusLost
        painelListaCidade.setVisible(false);
        if (selecaoCidade) {
            campoCidade.setBorder(new LineBorder(Color.GRAY));
            rotuloCidadeObrigatorio.setVisible(false);
        } else {
            campoCidade.setBorder(new LineBorder(Color.RED));
            rotuloCidadeObrigatorio.setVisible(true);
        }
    }//GEN-LAST:event_campoCidadeFocusLost

    private void campoCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCidadeMouseClicked
        painelListaCidade.setVisible(true);
        pesquisarCidade();
    }//GEN-LAST:event_campoCidadeMouseClicked

    private void campoCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadeKeyReleased
        selecaoCidade = false;
        pesquisarCidade();
    }//GEN-LAST:event_campoCidadeKeyReleased

    private void botaoComboCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComboCidadeActionPerformed
        if (!painelListaCidade.isVisible()) {
            painelListaCidade.setVisible(true);
            campoCidade.requestFocusInWindow();
            pesquisarCidade();
        } else {
            painelListaCidade.setVisible(false);
        }
    }//GEN-LAST:event_botaoComboCidadeActionPerformed

    private void listaCidadeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCidadeMousePressed
        campoCidade.setText(listaCidade.getSelectedValue());
        selecaoCidade = true;
    }//GEN-LAST:event_listaCidadeMousePressed

    private void campoNomeCompletoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeCompletoKeyTyped
        util.JanelaComum.campoTexto(evt);
    }//GEN-LAST:event_campoNomeCompletoKeyTyped

    private void campoRuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoRuaKeyTyped
        util.JanelaComum.campoTexto(evt);
    }//GEN-LAST:event_campoRuaKeyTyped

    private void campoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumeroKeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_campoNumeroKeyTyped

    private void campoBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBairroKeyTyped
        util.JanelaComum.campoTexto(evt);
    }//GEN-LAST:event_campoBairroKeyTyped

    private void campoCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCidadeKeyTyped
        util.JanelaComum.campoTexto(evt);
    }//GEN-LAST:event_campoCidadeKeyTyped

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ClienteEditar dialog = new ClienteEditar(new javax.swing.JFrame(), true, null);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    private void preencherTabelaContato() {
        if (contatos != null) {
            String[] titulo = new String[]{"Telefone", "Observação"};

            String[][] linhas = new String[contatos.size()][2];

            contatos.forEach((contato) -> {
                int posicao = contatos.indexOf(contato);
                linhas[posicao][0] = contato.getTelefone();
                linhas[posicao][1] = contato.getObservacao();
            });

            tabelaContato.setModel(new javax.swing.table.DefaultTableModel(linhas, titulo) {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });

            botaoRemoverContato.setEnabled(false);
        }
    }

    private List<Contato> getContatoFromTable() {
        contatos = new ArrayList<>();
        for (int linha = 0; linha < tabelaContato.getRowCount(); linha++) {
            TableModel modelo = tabelaContato.getModel();
            String telefone = modelo.getValueAt(linha, 0).toString();
            String observacao = modelo.getValueAt(linha, 1).toString();
            contatos.add(new Contato(telefone, observacao));
        }
        return contatos;
    }

    private boolean validaNome() {
        if (campoNomeCompleto.getText().length() < 1) {
            campoNomeCompleto.setBorder(new LineBorder(Color.RED));
            rotuloNomeObrigatorio.setVisible(true);
            return false;
        } else {
            campoNomeCompleto.setBorder(new LineBorder(Color.GRAY));
            rotuloNomeObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaData() {
        try {
            DateParse.parseDate(campoDataDeNascimento.getText());
            campoDataDeNascimento.setBorder(new LineBorder(Color.GRAY));
            rotuloDataObrigatorio.setVisible(false);
            return true;
        } catch (ParseException e) {
            campoDataDeNascimento.setBorder(new LineBorder(Color.RED));
            rotuloDataObrigatorio.setVisible(true);
            return false;
        }
    }

    private void focoData() {
        campoDataDeNascimento.setBorder(new LineBorder(Color.BLUE));
        if (campoDataDeNascimento.getText().equals("dd/mm/aaaa")) {
            campoDataDeNascimento.setForeground(Color.BLACK);
            campoDataDeNascimento.setText("");
            try {
                MaskFormatter mascaraData = new MaskFormatter("##/##/####");
                mascaraData.setPlaceholderCharacter('_');
                campoDataDeNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
                campoDataDeNascimento.setText("");
            } catch (ParseException e) {

            }
        }
    }

    private boolean validaCpf() {
        String cpf = campoCPF.getText();
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        cpf = cpf.replace("_", "");
        if (cpf.trim().length() != 11 || cpf.equals("00000000000")) {
            campoCPF.setBorder(new LineBorder(Color.RED));
            rotuloCPFObrigatorio.setVisible(true);
            return false;
        } else {
            campoCPF.setBorder(new LineBorder(Color.GRAY));
            rotuloCPFObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaRg() {
        if (campoRG.getText().length() < 1) {
            campoRG.setBorder(new LineBorder(Color.RED));
            rotuloRGObrigatorio.setVisible(true);
            return false;
        } else {
            campoRG.setBorder(new LineBorder(Color.GRAY));
            rotuloRGObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaEmail() {
        if (campoEmail.getText().length() < 1 || campoEmail.getText().equals("nome@exemplo.com")) {
            campoEmail.setBorder(new LineBorder(Color.RED));
            campoEmail.setForeground(Color.GRAY);
            campoEmail.setText("nome@exemplo.com");
            rotuloEmailObrigatorio.setVisible(true);
            return false;
        } else {
            campoEmail.setBorder(new LineBorder(Color.GRAY));
            rotuloEmailObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaRua() {
        if (campoRua.getText().length() < 1) {
            campoRua.setBorder(new LineBorder(Color.RED));
            rotuloRuaObrigatorio.setVisible(true);
            return false;
        } else {
            campoRua.setBorder(new LineBorder(Color.GRAY));
            rotuloRuaObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaNumero() {
        try {
            Integer.parseInt(campoNumero.getText());
            campoNumero.setBorder(new LineBorder(Color.GRAY));
            rotuloNumeroObrigatorio.setVisible(false);
            return true;
        } catch (NumberFormatException e) {
            campoNumero.setBorder(new LineBorder(Color.RED));
            rotuloNumeroObrigatorio.setVisible(true);
            return false;
        }
    }

    private boolean validaBairro() {
        if (campoBairro.getText().length() < 1) {
            campoBairro.setBorder(new LineBorder(Color.RED));
            rotuloBairroObrigatorio.setVisible(true);
            return false;
        } else {
            campoBairro.setBorder(new LineBorder(Color.GRAY));
            rotuloBairroObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaCep() {
        String cep = campoCEP.getText();
        cep = cep.replace(".", "");
        cep = cep.replace("-", "");
        cep = cep.replace("_", "");
        if (cep.trim().length() != 8 || cep.equals("00000000")) {
            campoCEP.setBorder(new LineBorder(Color.RED));
            return false;
        } else {
            campoCEP.setBorder(new LineBorder(Color.GRAY));
            return true;
        }
    }

    private boolean validaTelefone() {
        String telefone = campoTelefone.getText();
        telefone = telefone.replace(")", "");
        telefone = telefone.replace("(", "");
        telefone = telefone.replace("-", "");
        telefone = telefone.replace("_", "");
        if (telefone.trim().length() < 10 || telefone.equals("00000000000")) {
            if (adt || tabelaContato.getRowCount() == 0) {
                campoTelefone.setBorder(new LineBorder(Color.RED));
                rotuloTelefoneObrigatorio.setVisible(true);
            } else {
                campoTelefone.setBorder(new LineBorder(Color.GRAY));
                rotuloTelefoneObrigatorio.setVisible(false);
            }
            return false;
        } else {
            campoTelefone.setBorder(new LineBorder(Color.GRAY));
            rotuloTelefoneObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaObservacao() {
        String observacao = campoObservacao.getText();
        if (observacao.trim().length() < 1) {
            if (adt || tabelaContato.getRowCount() == 0) {
                campoObservacao.setBorder(new LineBorder(Color.RED));
                rotuloObservacaoObrigatorio.setVisible(true);
            } else {
                campoObservacao.setBorder(new LineBorder(Color.GRAY));
                rotuloObservacaoObrigatorio.setVisible(false);
            }
            return false;
        } else {
            campoObservacao.setBorder(new LineBorder(Color.GRAY));
            rotuloObservacaoObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaContato() {
        if (tabelaContato.getRowCount() == 0) {
            campoTelefone.setBorder(new LineBorder(Color.RED));
            rotuloTelefoneObrigatorio.setVisible(true);
            campoObservacao.setBorder(new LineBorder(Color.RED));
            rotuloObservacaoObrigatorio.setVisible(true);
            rotuloContatoObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
            return false;
        } else {
            rotuloContatoObrigatorio.setForeground(new java.awt.Color(0, 0, 0));
            return true;
        }
    }

    private boolean validaSexo() {
        if (radioFeminino.isSelected() || radioMasculino.isSelected()) {
            painelSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sexo*",
                    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(0, 0, 0)));
            rotuloSexoObrigatorio.setVisible(false);
            return true;
        } else {
            painelSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), "Sexo*",
                    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(255, 0, 0)));
            rotuloSexoObrigatorio.setVisible(true);
            return false;
        }
    }

    private boolean validaCidade() {
        return selecaoCidade;
    }

    private Cliente clienteNovo = null;
    private List<Contato> contatos = new ArrayList<>();
    private int codigo = 0;
    private boolean adt = false;
    private List<String> cidades;
    private List<entidades.Cidade> cities;
    private DefaultListModel modeloCidade;
    private boolean selecaoCidade = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator bordaCen;
    private javax.swing.JSeparator bordaMer;
    private javax.swing.JSeparator bordaOci;
    private javax.swing.JSeparator bordaOri;
    private javax.swing.JSeparator bordaSet;
    private javax.swing.JButton botaoAdicionarContato;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoComboCidade;
    private javax.swing.JButton botaoRemoverContato;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JFormattedTextField campoCEP;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoComplemento;
    private javax.swing.JFormattedTextField campoDataDeNascimento;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNomeCompleto;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoObservacao;
    private javax.swing.JTextField campoRG;
    private javax.swing.JTextField campoRua;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.ButtonGroup grupoDeBotoesSexo;
    private javax.swing.JList<String> listaCidade;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JLayeredPane painelCamadas;
    private javax.swing.JPanel painelContato;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JScrollPane painelListaCidade;
    private javax.swing.JScrollPane painelRolavel;
    private javax.swing.JPanel painelSexo;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JRadioButton radioFeminino;
    private javax.swing.JRadioButton radioMasculino;
    private javax.swing.JLabel rotuloAsterisco;
    private javax.swing.JLabel rotuloBairro;
    private javax.swing.JLabel rotuloBairroObrigatorio;
    private javax.swing.JLabel rotuloCEP;
    private javax.swing.JLabel rotuloCEPObrigatorio;
    private javax.swing.JLabel rotuloCPF;
    private javax.swing.JLabel rotuloCPFObrigatorio;
    private javax.swing.JLabel rotuloCidade;
    private javax.swing.JLabel rotuloCidadeObrigatorio;
    private javax.swing.JLabel rotuloComplemento;
    private javax.swing.JLabel rotuloContatoObrigatorio;
    private javax.swing.JLabel rotuloDados;
    private javax.swing.JLabel rotuloDataDeNascimento;
    private javax.swing.JLabel rotuloDataObrigatorio;
    private javax.swing.JLabel rotuloEmail;
    private javax.swing.JLabel rotuloEmailObrigatorio;
    private javax.swing.JLabel rotuloNomeCompleto;
    private javax.swing.JLabel rotuloNomeObrigatorio;
    private javax.swing.JLabel rotuloNovoCliente;
    private javax.swing.JLabel rotuloNumero;
    private javax.swing.JLabel rotuloNumeroObrigatorio;
    private javax.swing.JLabel rotuloObrigatorios;
    private javax.swing.JLabel rotuloObservacao;
    private javax.swing.JLabel rotuloObservacaoObrigatorio;
    private javax.swing.JLabel rotuloRG;
    private javax.swing.JLabel rotuloRGObrigatorio;
    private javax.swing.JLabel rotuloRua;
    private javax.swing.JLabel rotuloRuaObrigatorio;
    private javax.swing.JLabel rotuloSexoObrigatorio;
    private javax.swing.JLabel rotuloTelefone;
    private javax.swing.JLabel rotuloTelefoneObrigatorio;
    private javax.swing.JTable tabelaContato;
    // End of variables declaration//GEN-END:variables
}

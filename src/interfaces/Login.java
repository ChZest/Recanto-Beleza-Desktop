package interfaces;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import dados.LoginDados;
import dados.DadosException;
import entidades.Usuario;
import java.awt.Color;
import javax.swing.border.LineBorder;

/* @author BIC-Jr Guia de Estilo  */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        alterarIcone();
    }

    private void alterarIcone() {
        URL url = this.getClass().getResource("/imagens/logoSalao.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        this.setLocationRelativeTo(null);
    }

    private void entrar() {
        try {
            Usuario usuario = LoginDados.logar(campoLogin.getText());
            if (campoSenha.getText().equals(usuario.getSenha())) {
                this.dispose();
                java.awt.EventQueue.invokeLater(() -> {
                    new Principal(usuario).setVisible(true);
                });
                campoLogin.setText("");
                campoSenha.setText("");
            } else {
                campoLogin.setBorder(new LineBorder(Color.RED));
                campoSenha.setBorder(new LineBorder(Color.RED));
                rotuloAviso.setVisible(true);
            }
        } catch (NullPointerException e1) {
            campoLogin.setBorder(new LineBorder(Color.RED));
            campoSenha.setBorder(new LineBorder(Color.RED));
            rotuloAviso.setVisible(true);
        } catch (DadosException e2) {
            Problema erroDeConexao = new Problema(this, true, e2.getMessage());
            erroDeConexao.setVisible(true);
        }
    }

    private boolean validaLogin() {
        if (campoLogin.getText().length() <= 0) {
            campoLogin.setBorder(new LineBorder(Color.RED));
            usuarioObrigatorio.setVisible(true);
            return false;
        } else {
            campoLogin.setBorder(new LineBorder(Color.GRAY));
            usuarioObrigatorio.setVisible(false);
            return true;
        }
    }

    private boolean validaSenha() {
        if (campoSenha.getText().length() <= 0) {
            campoSenha.setBorder(new LineBorder(Color.RED));
            senhaObrigatorio.setVisible(true);
            return false;
        } else {
            campoSenha.setBorder(new LineBorder(Color.GRAY));
            senhaObrigatorio.setVisible(false);
            return true;
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

        painelNorte = new javax.swing.JPanel();
        rotuloTitulo = new javax.swing.JLabel();
        painelFormulario = new javax.swing.JPanel();
        rotuloLogin = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        rotuloSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        botaoEntrar = new javax.swing.JButton();
        rotuloAviso = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        senhaObrigatorio = new javax.swing.JLabel();
        usuarioObrigatorio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMaximumSize(new java.awt.Dimension(481, 320));
        setMinimumSize(new java.awt.Dimension(481, 320));
        setPreferredSize(new java.awt.Dimension(481, 320));
        setResizable(false);

        painelNorte.setBackground(new java.awt.Color(0, 0, 0));

        rotuloTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rotuloTitulo.setForeground(new java.awt.Color(255, 255, 255));
        rotuloTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logoSalao.png"))); // NOI18N
        rotuloTitulo.setText("RECANTO BELEZA");
        painelNorte.add(rotuloTitulo);

        getContentPane().add(painelNorte, java.awt.BorderLayout.NORTH);

        painelFormulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rotuloLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloLogin.setText("Nome de Usuário:");
        painelFormulario.add(rotuloLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        campoLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoLoginFocusLost(evt);
            }
        });
        campoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoLoginKeyPressed(evt);
            }
        });
        painelFormulario.add(campoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 340, 30));

        rotuloSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloSenha.setText("Senha:");
        painelFormulario.add(rotuloSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        campoSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoSenhaFocusLost(evt);
            }
        });
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });
        painelFormulario.add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 340, 30));

        botaoEntrar.setBackground(new java.awt.Color(46, 139, 87));
        botaoEntrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoEntrar.setMnemonic('e');
        botaoEntrar.setText("Entrar");
        botaoEntrar.setToolTipText("Realizar login no sistema (Alt+E)");
        botaoEntrar.setContentAreaFilled(false);
        botaoEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEntrar.setOpaque(true);
        botaoEntrar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        painelFormulario.add(botaoEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        rotuloAviso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotuloAviso.setForeground(new java.awt.Color(255, 0, 51));
        rotuloAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rotuloAviso.setText("Usuário ou senha incorretos");
        painelFormulario.add(rotuloAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 340, -1));
        rotuloAviso.setVisible(false);

        botaoCancelar.setBackground(new java.awt.Color(135, 206, 235));
        botaoCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        botaoCancelar.setMnemonic('c');
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setToolTipText("Fechar o sistema (Alt+C)");
        botaoCancelar.setContentAreaFilled(false);
        botaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCancelar.setOpaque(true);
        botaoCancelar.setPreferredSize(new java.awt.Dimension(130, 35));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        painelFormulario.add(botaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        senhaObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        senhaObrigatorio.setText("Preencha este campo");
        painelFormulario.add(senhaObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 340, -1));
        senhaObrigatorio.setVisible(false);

        usuarioObrigatorio.setForeground(new java.awt.Color(204, 0, 0));
        usuarioObrigatorio.setText("Preencha este campo");
        painelFormulario.add(usuarioObrigatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 340, -1));
        usuarioObrigatorio.setVisible(false);

        getContentPane().add(painelFormulario, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        boolean login = validaLogin();
        boolean senha = validaSenha();
        if (login && senha) {
            entrar();
        }
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void campoLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoLoginKeyPressed
        if (evt.getKeyCode() == 10) {
            entrar();
        }
    }//GEN-LAST:event_campoLoginKeyPressed

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
        if (evt.getKeyCode() == 10) {
            entrar();
        }
    }//GEN-LAST:event_campoSenhaKeyPressed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void campoLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoLoginFocusLost
        validaLogin();
    }//GEN-LAST:event_campoLoginFocusLost

    private void campoSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoSenhaFocusLost
        validaSenha();
    }//GEN-LAST:event_campoSenhaFocusLost

    private void campoLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoLoginFocusGained
        campoLogin.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoLoginFocusGained

    private void campoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoSenhaFocusGained
        campoSenha.setBorder(new LineBorder(Color.BLUE));
    }//GEN-LAST:event_campoSenhaFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JPanel painelFormulario;
    private javax.swing.JPanel painelNorte;
    private javax.swing.JLabel rotuloAviso;
    private javax.swing.JLabel rotuloLogin;
    private javax.swing.JLabel rotuloSenha;
    private javax.swing.JLabel rotuloTitulo;
    private javax.swing.JLabel senhaObrigatorio;
    private javax.swing.JLabel usuarioObrigatorio;
    // End of variables declaration//GEN-END:variables
}
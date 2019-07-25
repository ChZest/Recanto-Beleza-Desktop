package util;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/* @author BIC-Jr Guia de Estilo */
public abstract class JanelaComum {
    
    public static void setAcessibilidade(javax.swing.JDialog janela) {
        JRootPane meurootpane = janela.getRootPane();
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
            }
        });
    }    
    public static void setAcessibilidade(javax.swing.JFrame janela) {
        JRootPane meurootpane = janela.getRootPane();
        meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
            }
        });
    }
    
    public static void campoTexto(java.awt.event.KeyEvent evt) {
        Character c = (Character) evt.getKeyChar();
        if (!Character.isAlphabetic(c.hashCode()) && c.hashCode()!=32) {
            evt.consume();
        }
    }
}

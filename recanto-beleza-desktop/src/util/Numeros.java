package util;

/* @author BIC-Jr Guia de Estilo */
public class Numeros extends javax.swing.text.PlainDocument {

    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet atr) 
        throws javax.swing.text.BadLocationException {
            super.insertString(offset, str.replaceAll("[^0-9]", ""), atr);
    }
    
    public void replace(int offset, String str, javax.swing.text.AttributeSet atr)
            throws javax.swing.text.BadLocationException {
        super.insertString(offset, str.replaceAll("[^0-9]", ""), atr);
    }
}

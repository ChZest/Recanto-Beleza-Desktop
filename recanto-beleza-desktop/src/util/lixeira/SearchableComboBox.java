package util.lixeira;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.Format.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

/**
 *
 * @author BIC-Jr Guia de Estilo
 */
public class SearchableComboBox extends PlainDocument {

    JComboBox comboBox;
    ComboBoxModel model;
    JTextComponent editor;
    List<String> itens;
    // flag to indicate if setSelectedItem has been called
    // subsequent calls to remove/insertString should be ignored
    boolean selecting = false;
    boolean hidePopupOnFocusLoss;
    boolean hitBackspace = false;
    boolean hitBackspaceOnSelection;

    public SearchableComboBox(final JComboBox comboBox) {
        itens = new ArrayList<>();
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            itens.add(comboBox.getItemAt(i).toString());
        }
        this.comboBox = comboBox;
        model = comboBox.getModel();
        editor = (JTextComponent) comboBox.getEditor().getEditorComponent();
        editor.setDocument(this);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        editor.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (comboBox.isDisplayable()) {
                    comboBox.setPopupVisible(true);
                }
                hitBackspace = false;
            }
        });
        // Bug 5100422 on Java 1.5: Editable JComboBox won't hide popup when tabbing out
        hidePopupOnFocusLoss = System.getProperty("java.version").startsWith("1.5");
        // Highlight whole text when gaining focus
        editor.addFocusListener(new FocusAdapter() {

            public void focusLost(FocusEvent e) {
                // Workaround for Bug 5100422 - Hide Popup on focus loss
                if (hidePopupOnFocusLoss) {
                    comboBox.setPopupVisible(false);
                }
            }
        });

        // Handle initially selected object
        Object selected = comboBox.getSelectedItem();
        if (selected != null) {
            setText(selected.toString());
        }

    }

    void setPrototypeValue(Object value, JList list) {
        comboBox.setPrototypeDisplayValue(value);
        list.setPrototypeCellValue(value);
    }

    public void remove(int offs, int len) throws BadLocationException {
        // return immediately when selecting an item
        if (selecting) {
            return;
        }
        if (hitBackspace) {
            // user hit backspace => move the selection backwards
            // old item keeps being selected
            if (offs > 0) {
                if (hitBackspaceOnSelection) {
                    offs--;
                }
            } else {
                // User hit backspace with the cursor positioned on the start => beep
                comboBox.getToolkit().beep(); // when available use: UIManager.getLookAndFeel().provideErrorFeedback(comboBox);
            }

        } else {
            super.remove(offs, len);
        }
    }

    private void setText(String text) {
        try {
            super.remove(0, getLength());
            super.insertString(0, text, null);
        } catch (BadLocationException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // return immediately when selecting an item
        if (selecting) {
            return;
        }
        // insert the string into the document
        super.insertString(offs, str, a);
        // lookup and select a matching item
        Object item = lookupItem(getText(0, getLength()));
        if (item != null) {
            setSelectedItem(item);
        }
    }

    private void setSelectedItem(Object item) {
        selecting = true;
        model.setSelectedItem(item);
        selecting = false;
    }

    private Object findStringWithin(String pattern) {

        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i).toString().toLowerCase().indexOf(pattern.toLowerCase()) != -1) {
                return model.getElementAt(i);
            }
        }

        return null;
    }

    private Object sfindStringWithin(String pattern) {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < model.getSize(); i++) {
//          if(model.getElementAt(i).toString().toLowerCase().startsWith(pattern.toLowerCase())) {
//              lista.add(model.getElementAt(i).toString());
//          }
            if (model.getElementAt(i).toString().toLowerCase().startsWith(pattern.toLowerCase())) {
                return model.getElementAt(i);
            }

        }
//        return lista;
        return null;
    }

    private List<String> rfindStringWithin(String pattern) {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i).toString().toLowerCase().startsWith(pattern.toLowerCase())) {
                lista.add(model.getElementAt(i).toString());
            }

        }
        return lista;
    }

    private Object lookupItem(String pattern) {
        return this.sfindStringWithin(pattern);
    }

}

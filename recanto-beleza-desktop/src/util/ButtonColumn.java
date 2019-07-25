package util;

import interfaces.ServicoVisualizar;

/* @author BIC-Jr Guia de Estilo */
public class ButtonColumn extends javax.swing.AbstractCellEditor
        implements javax.swing.table.TableCellRenderer, javax.swing.table.TableCellEditor, java.awt.event.ActionListener {

    javax.swing.JTable table;
    javax.swing.JButton renderButton;
    javax.swing.JButton editButton;
    String text;

    public ButtonColumn(javax.swing.JTable table, int column) {
        super();
        this.table = table;
        renderButton = new javax.swing.JButton();
        renderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/eye.png"))); // NOI18N
        renderButton.setToolTipText("Ver detalhes");
        editButton = new javax.swing.JButton();
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/eye.png"))); // NOI18N
        editButton.setToolTipText("Ver detalhes");
        editButton.setFocusPainted(false);
        editButton.addActionListener(this);
        javax.swing.table.TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
    }

    private void botaoActionPerformed(java.awt.event.ActionEvent evt) {
        ServicoVisualizar servicoVisualizar = new ServicoVisualizar(new javax.swing.JFrame(), true, "Lorem ipsum");
        servicoVisualizar.setVisible(true);
    }

    @Override
    public java.awt.Component getTableCellRendererComponent(
            javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (hasFocus) {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(javax.swing.UIManager.getColor("Button.background"));
        } else if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(javax.swing.UIManager.getColor("Button.background"));
        }
        renderButton.setText((value == null) ? "" : value.toString());
        return renderButton;
    }

    @Override
    public java.awt.Component getTableCellEditorComponent(
            javax.swing.JTable table, Object value, boolean isSelected, int row, int column) {
        text = (value == null) ? "" : value.toString();
        editButton.setText(text);
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return text;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        ServicoVisualizar servicoVisualizar = new ServicoVisualizar(new javax.swing.JFrame(), true, "Lorem ipsum");
        servicoVisualizar.setVisible(true);
        fireEditingStopped();
    }
}

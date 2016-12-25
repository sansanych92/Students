package Client.ui.cellEditors;


import Client.ui.frames.EditingCellsStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *@author Arsenii
 */

public class StudentCellEditor extends DefaultCellEditor implements ItemListener {

    private JRadioButton radio;
    private JTable table;

    public StudentCellEditor(JCheckBox checkBox, JTable table) {

        super(checkBox);
        this.table = table;
    }


    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        radio = (JRadioButton) value;
        radio.addItemListener(this);
        return (JComponent) value;
    }


    @Override
    public Object getCellEditorValue() {
        radio.removeItemListener(this);
        return radio;
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        EditingCellsStudent.setRow(table.getEditingRow());
        EditingCellsStudent.setCol(table.getEditingColumn());
        super.fireEditingStopped();
    }

}
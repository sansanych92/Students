package Client.ui.cellEditors;


import Client.ui.frames.EditingCellsStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class StudentCellEditor extends DefaultCellEditor implements ItemListener {

    JRadioButton radio;
    JTable table;

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
        EditingCellsStudent.row = table.getEditingRow();
        EditingCellsStudent.col = table.getEditingColumn();
        super.fireEditingStopped();
    }

}
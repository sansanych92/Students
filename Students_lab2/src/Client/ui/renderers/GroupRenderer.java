package Client.ui.renderers;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 *@author Arsenii
 */
public class GroupRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return (JComponent) value;
    }
}
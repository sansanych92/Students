package Client.ui.listeners;

import Client.ui.frames.EdditionFrame;
import Client.ui.frames.EditingCellsGroup;
import Client.ui.frames.EditingCellsStudent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class EdditionButtonListener implements ActionListener {

    JTable table;

    public EdditionButtonListener(JTable table){
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getColumnCount()>3) {
            new EdditionFrame(table, EditingCellsStudent.row);
        } else{
            new EdditionFrame(table, EditingCellsGroup.row);
        }
    }
}

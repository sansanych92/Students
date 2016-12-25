package Client.ui.listeners;

import Client.ui.frames.EdditionFrame;
import Client.ui.frames.EditingCellsGroup;
import Client.ui.frames.EditingCellsStudent;
import Server.Model.GroupModel;
import Server.Model.StudentModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.util.List;

/**
 *@author Arsenii
 */
public class EdditionButtonListener implements ActionListener {

    private JTable table;
    private DataOutputStream out;
    private List<StudentModel> studList;
    private List<GroupModel> groupList;

    public EdditionButtonListener(JTable table, DataOutputStream out, List<StudentModel> studList, List<GroupModel> groupList){
        this.table = table;
        this.out = out;
        this.groupList = groupList;
        this.studList = studList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getColumnCount()>3) {
            new EdditionFrame(table, EditingCellsStudent.getRow(), studList, groupList, out);
        } else{
            new EdditionFrame(table, EditingCellsGroup.getRow(), studList, groupList, out);
        }
    }
}

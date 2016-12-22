package Client.ui.listeners;

import Client.ui.frames.EditingCellsGroup;
import Client.ui.frames.EditingCellsStudent;
import Server.Model.GroupModel;
import Server.Model.StudentModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class DeleteButtonListener implements ActionListener {

    JTable students;
    JTable groups;
    List<StudentModel> studList;
    List<GroupModel> groupList;
    DataOutputStream out;

    public DeleteButtonListener(JTable students, JTable groups, List<StudentModel> studList, List<GroupModel> groupList, DataOutputStream out){
        this.studList = studList;
        this.groupList = groupList;
        this.students = students;
        this.groups = groups;
        this.out = out;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (Objects.equals(button.getText(), "Delete student")) {

            if (EditingCellsStudent.row!=-1&&EditingCellsStudent.col!=-1){

                String sur = (String) students.getValueAt(EditingCellsStudent.row, 0);
                String name = (String) students.getValueAt(EditingCellsStudent.row, 1);
                String patro = (String) students.getValueAt(EditingCellsStudent.row, 2);
                int numberOfGroup = (int) students.getValueAt(EditingCellsStudent.row, 3);

                int idNeedToDelete = studList.stream().filter(studentModel -> Objects.equals(studentModel.getName(), name) && Objects.equals(studentModel.getSurname(), sur) && Objects.equals(studentModel.getPatronymic(), patro)&&studentModel.getGroupId()==groupList.stream().filter(groupModel -> groupModel.getNumberOfGroup()==numberOfGroup).findFirst().get().getIdOfGroup()).findFirst().get().getId();

                try {
                    out.writeUTF("<deleteStudent>"+idNeedToDelete+"</deleteStudent>");
                    out.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (Objects.equals(button.getText(), "Delete group")) {

            if (EditingCellsGroup.row!=-1&&EditingCellsGroup.col!=-1){
                int name = (int) groups.getValueAt(EditingCellsGroup.row, 0);
                String faculty = (String) groups.getValueAt(EditingCellsGroup.row, 1);
                int idNeedToDelete = groupList.stream().filter(groupModel -> groupModel.getNumberOfGroup()==name && Objects.equals(groupModel.getNameOfFaculty(), faculty)).findFirst().get().getIdOfGroup();
                try {
                    out.writeUTF("<deleteGroup>"+idNeedToDelete+"</deleteGroup>");
                    out.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}

package Client.ui.listeners;

import Client.ui.frames.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class OkButtonListener implements ActionListener {

    JFrame frame;
    DataOutputStream out;
    String export;

   public OkButtonListener(JFrame frame, DataOutputStream out){
        this.frame = frame;
        this.out = out;
        export = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame instanceof AdditionFrame){
            if (((AdditionFrame) frame).text5 == null){
                export = "<addGroup>";
               export = export+"<name>"+((AdditionFrame) frame).text1.getText()+"</name>"+"<faculty>"+((AdditionFrame) frame).text2.getText()+"</faculty>";
               export = export+"</addGroup>";
                try {
                    out.writeUTF(export);
                    out.flush();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else{
                export = "<addStudent>";
                export = export+"<surname>"+((AdditionFrame) frame).text1.getText()+"</surname>"+"<name>"+((AdditionFrame) frame).text2.getText()+"</name>"+"<patronymic>"+((AdditionFrame) frame).text3.getText()+"</patronymic>"+"<idOfGroup>"+((AdditionFrame) frame).text4.getSelectedItem().toString()+"</idOfGroup>"+"<dateOfEnvironment>"+((AdditionFrame) frame).text5.getText()+"</dateOfEnvironment>";
                export = export+"</addStudent>";
                try {
                    out.writeUTF(export);
                    out.flush();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (frame instanceof EdditionFrame){

            if (((EdditionFrame) frame).text5 == null){
                int name = (int)((EdditionFrame) frame).thisTable.getValueAt(EditingCellsGroup.row, 0);
                String faculty = (String) ((EdditionFrame) frame).thisTable.getValueAt(EditingCellsGroup.row, 1);
                int idNeedToEdit = ((EdditionFrame) frame).groupList.stream().filter(groupModel -> groupModel.getNumberOfGroup()==name && Objects.equals(groupModel.getNameOfFaculty(), faculty)).findFirst().get().getIdOfGroup();
                export = "<editGroup>";
                export = export+"<id>"+idNeedToEdit+"</id>";
                export = export+"<name>"+((EdditionFrame) frame).text1.getText()+"</name>"+"<faculty>"+((EdditionFrame) frame).text2.getText()+"</faculty>";
                export = export+"</editGroup>";
                try {
                    out.writeUTF(export);
                    out.flush();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else{
                String sur = (String) ((EdditionFrame) frame).thisTable.getValueAt(EditingCellsStudent.row, 0);
                String name = (String) ((EdditionFrame) frame).thisTable.getValueAt(EditingCellsStudent.row, 1);
                String patro = (String) ((EdditionFrame) frame).thisTable.getValueAt(EditingCellsStudent.row, 2);
                int numberOfGroup = (int) ((EdditionFrame) frame).thisTable.getValueAt(EditingCellsStudent.row, 3);

                int idNeedToEdit = ((EdditionFrame) frame).studList.stream().filter(studentModel -> Objects.equals(studentModel.getName(), name) && Objects.equals(studentModel.getSurname(), sur) && Objects.equals(studentModel.getPatronymic(), patro)&&studentModel.getGroupId()==((EdditionFrame) frame).groupList.stream().filter(groupModel -> groupModel.getNumberOfGroup()==numberOfGroup).findFirst().get().getIdOfGroup()).findFirst().get().getId();
                export = "<editStudent>";
                export = export+"<id>"+idNeedToEdit+"</id>";
                export = export+"<surname>"+((EdditionFrame) frame).text1.getText()+"</surname>"+"<name>"+((EdditionFrame) frame).text2.getText()+"</name>"+"<patronymic>"+((EdditionFrame) frame).text3.getText()+"</patronymic>"+"<idOfGroup>"+((EdditionFrame) frame).text4.getSelectedItem().toString()+"</idOfGroup>"+"<dateOfEnvironment>"+((EdditionFrame) frame).text5.getText()+"</dateOfEnvironment>";
                export = export+"</editStudent>";
                try {
                    out.writeUTF(export);
                    out.flush();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
       frame.setVisible(false);
    }
}

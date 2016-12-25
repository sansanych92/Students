package Client.ui.listeners;

import Client.ui.frames.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 *@author Arsenii
 */
public class OkButtonListener implements ActionListener {

    private JFrame frame;
    private DataOutputStream out;
    private String export;

   public OkButtonListener(JFrame frame, DataOutputStream out){
        this.frame = frame;
        this.out = out;
        export = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame instanceof AdditionFrame){
            if (((AdditionFrame) frame).getText5() == null){
                export = "<addGroup>";
               export = export+"<name>"+((AdditionFrame) frame).getText1().getText()+"</name>"+"<faculty>"+((AdditionFrame) frame).getText2().getText()+"</faculty>";
               export = export+"</addGroup>";
                try {
                    out.writeUTF(export);
                    out.flush();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else{
                export = "<addStudent>";
                export = export+"<surname>"+((AdditionFrame) frame).getText1().getText()+"</surname>"+"<name>"+((AdditionFrame) frame).getText2().getText()+"</name>"+"<patronymic>"+((AdditionFrame) frame).getText3().getText()+"</patronymic>"+"<idOfGroup>"+((AdditionFrame) frame).getText4().getSelectedItem().toString()+"</idOfGroup>"+"<dateOfEnvironment>"+((AdditionFrame) frame).getText5().getText()+"</dateOfEnvironment>";
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

            if (((EdditionFrame) frame).getText5() == null){
                int name = (int)((EdditionFrame) frame).getThisTable().getValueAt(EditingCellsGroup.getRow(), 0);
                String faculty = (String) ((EdditionFrame) frame).getThisTable().getValueAt(EditingCellsGroup.getRow(), 1);
                int idNeedToEdit = ((EdditionFrame) frame).getGroupList().stream().filter(groupModel -> groupModel.getNumberOfGroup()==name && Objects.equals(groupModel.getNameOfFaculty(), faculty)).findFirst().get().getIdOfGroup();
                export = "<editGroup>";
                export = export+"<id>"+idNeedToEdit+"</id>";
                export = export+"<name>"+((EdditionFrame) frame).getText1().getText()+"</name>"+"<faculty>"+((EdditionFrame) frame).getText2().getText()+"</faculty>";
                export = export+"</editGroup>";
                try {
                    out.writeUTF(export);
                    out.flush();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else{
                String sur = (String) ((EdditionFrame) frame).getThisTable().getValueAt(EditingCellsStudent.getRow(), 0);
                String name = (String) ((EdditionFrame) frame).getThisTable().getValueAt(EditingCellsStudent.getRow(), 1);
                String patro = (String) ((EdditionFrame) frame).getThisTable().getValueAt(EditingCellsStudent.getRow(), 2);
                int numberOfGroup = (int) ((EdditionFrame) frame).getThisTable().getValueAt(EditingCellsStudent.getRow(), 3);

                int idNeedToEdit = ((EdditionFrame) frame).getStudList().stream().filter(studentModel -> Objects.equals(studentModel.getName(), name) && Objects.equals(studentModel.getSurname(), sur) && Objects.equals(studentModel.getPatronymic(), patro)&&studentModel.getGroupId()==((EdditionFrame) frame).getGroupList().stream().filter(groupModel -> groupModel.getNumberOfGroup()==numberOfGroup).findFirst().get().getIdOfGroup()).findFirst().get().getId();
                export = "<editStudent>";
                export = export+"<id>"+idNeedToEdit+"</id>";
                export = export+"<surname>"+((EdditionFrame) frame).getText1().getText()+"</surname>"+"<name>"+((EdditionFrame) frame).getText2().getText()+"</name>"+"<patronymic>"+((EdditionFrame) frame).getText3().getText()+"</patronymic>"+"<idOfGroup>"+((EdditionFrame) frame).getText4().getSelectedItem().toString()+"</idOfGroup>"+"<dateOfEnvironment>"+((EdditionFrame) frame).getText5().getText()+"</dateOfEnvironment>";
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

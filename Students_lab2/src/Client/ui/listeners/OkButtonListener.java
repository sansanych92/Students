package Client.ui.listeners;

import Client.ui.frames.AdditionFrame;
import Client.ui.frames.EdditionFrame;
import Client.ui.frames.ExceptionFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
               export = export+"<name>"+((AdditionFrame) frame).text1.getText()+"</name>"+"<number>"+((AdditionFrame) frame).text2.getText()+"</number>";
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

        }
       frame.setVisible(false);
    }
}

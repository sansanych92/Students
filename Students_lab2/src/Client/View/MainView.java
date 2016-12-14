package Client.View;

import Server.Model.StudentModel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by artur_v on 04.12.16.
 */
public class MainView {

    List<StudentModel> studentModelList;

    public MainView(List<StudentModel> studentModelList){
        this.studentModelList = studentModelList;
    }

    public void beginWork(){
        JPanel panel1 = new JPanel();
        JFrame frame = new JFrame("Система управления данными университета - клиент");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500,500);

        JLabel label = new JLabel("Начать работу");
       // frame.getContentPane().add(label);

        JTable table = new JTable(studentModelList.size(),5);

        for (int i = 0; i < 5; i++) {
            table.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()));
        }

        for (int i = 0; i <studentModelList.size(); i++) {

            for (int j = 0; j <5; j++) {
                table.setValueAt(studentModelList.get(i).getField(j),i,j);
            }
        }

        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel1.setLayout(new GridLayout());
        panel1.add(scrollPane);
        frame.add(panel1);

        frame.setPreferredSize(new Dimension(500, 400));

       // frame.pack();
        frame.setVisible(true);
    }
}

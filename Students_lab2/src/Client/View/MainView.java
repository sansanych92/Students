package Client.View;

import Server.Model.Root;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by artur_v on 04.12.16.
 */
public class MainView {

    private class CheckBoxListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (table.getEditingRow()!=-1&&table.getEditingColumn()!=-1){
                JComboBox box = (JComboBox)e.getSource();
                String item = (String)box.getSelectedItem();

                if (Objects.equals(item, "edit")){
                    JFrame additionFrame = new JFrame("Addition of student");
                    JTextField surname = new JTextField();
                    surname.setText((String) table.getValueAt(table.getEditingRow(),0));
                    JTextField name = new JTextField();
                    name.setText((String) table.getValueAt(table.getEditingRow(),1));
                    JTextField patro = new JTextField();
                    patro.setText((String) table.getValueAt(table.getEditingRow(),2));
                    JTextField group = new JTextField();
                    group.setText(String.valueOf(table.getValueAt(table.getEditingRow(),3)));
                    JTextField date = new JTextField();
                    date.setText((String) table.getValueAt(table.getEditingRow(),4));
                    additionFrame.setLayout(new GridBagLayout());
                    additionFrame.add(surname);
                    additionFrame.add(name);
                    additionFrame.add(patro);
                    additionFrame.add(group);
                    additionFrame.add(date);
                    additionFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                    additionFrame.setSize(400,100);
                    additionFrame.setVisible(true);
                }
            }

        }
    }

    Root root;
    JComboBox checkbox;
    JTable table;

    public MainView(Root root){
        this.root = root;
    }

    public void beginWork(){
        checkbox = new  JComboBox(new String[]{"delete", "edit"});
        JPanel panel1 = new JPanel();
        table = new JTable(root.getStudentModelList().size(),6);

        for (int i = 0; i < 5; i++) {
            table.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()));
        }

        table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(checkbox));
        checkbox.addActionListener(new CheckBoxListener());

        for (int i = 0; i <root.getStudentModelList().size(); i++) {

            table.setValueAt(root.getStudentModelList().get(i).getSurname(),i,0);
            table.setValueAt(root.getStudentModelList().get(i).getName(),i,1);
            table.setValueAt(root.getStudentModelList().get(i).getPatronymic(),i,2);
            final int j=i;
            table.setValueAt((root.getGroupModelList().stream().filter(groupModel -> groupModel.getIdOfGroup()==root.getStudentModelList().get(j).getGroupId()).findFirst().get().getNumberOfGroup()),i,3);
            table.setValueAt(root.getStudentModelList().get(i).getDateOfEnrollment().get(Calendar.YEAR)+"."+(root.getStudentModelList().get(i).getDateOfEnrollment().get(Calendar.MONTH)+1)+"."+root.getStudentModelList().get(i).getDateOfEnrollment().get(Calendar.DAY_OF_MONTH),i,4);
        }

        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel1.setLayout(new GridLayout());
        panel1.add(scrollPane);

        JFrame frame = new JFrame("Система управления данными университета - клиент");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.add(panel1,BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.setVisible(true);
    }
}

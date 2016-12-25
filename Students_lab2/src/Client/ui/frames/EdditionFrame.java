package Client.ui.frames;


import Client.ui.listeners.OkButtonListener;
import Server.Model.GroupModel;
import Server.Model.StudentModel;
import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.util.List;

/**
 *@author Arsenii
 */
public class EdditionFrame extends JFrame {

    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JComboBox<String> text4;
    private JTextField text5;
    private List<StudentModel> studList;
    private List<GroupModel> groupList;
    private JTable thisTable;

    public EdditionFrame(JTable table, int row, List<StudentModel> studList, List<GroupModel> groupList, DataOutputStream out){

        super();
        thisTable = table;
        this.groupList = groupList;
        this.studList = studList;
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new OkButtonListener(this, out));
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        if (row>=0) {
            if (table.getColumnModel().getColumnCount() == 3) {
                text1 = new JTextField();
                text1.setText(table.getValueAt(row, 0).toString());
                text2 = new JTextField();
                text2.setText((String) table.getValueAt(row, 1));
                panel.add(text1);
                panel.add(text2);
                panel.add(okButton);
            } else {
                text1 = new JTextField();
                text1.setText((String) table.getValueAt(row, 0));
                text2 = new JTextField();
                text2.setText((String) table.getValueAt(row, 1));
                text3 = new JTextField();
                text3.setText((String) table.getValueAt(row, 2));
                String[] grs = new String [groupList.size()];
                for (int i = 0; i <groupList.size(); i++) {
                    grs[i] = String.valueOf(groupList.get(i).getNumberOfGroup());
                }
                text4 = new JComboBox<>(grs);
                text5 = new JTextField();
                text5.setText((String) table.getValueAt(row, 4));
                panel.add(text1);
                panel.add(text2);
                panel.add(text3);
                panel.add(text4);
                panel.add(text5);
                panel.add(okButton);
            }

            this.add(panel);
            setDefaultCloseOperation(HIDE_ON_CLOSE);
            setSize(400,200);
            setVisible(true);
        }
    }

    public JTextField getText1() {
        return text1;
    }

    public JTextField getText2() {
        return text2;
    }

    public JTextField getText3() {
        return text3;
    }

    public JComboBox<String> getText4() {
        return text4;
    }

    public JTextField getText5() {
        return text5;
    }

    public List<StudentModel> getStudList() {
        return studList;
    }

    public List<GroupModel> getGroupList() {
        return groupList;
    }

    public JTable getThisTable() {
        return thisTable;
    }
}

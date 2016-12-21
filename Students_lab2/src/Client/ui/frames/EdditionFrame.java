package Client.ui.frames;


import Client.ui.listeners.OkButtonListener;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class EdditionFrame extends JFrame {

    public JTextField text1;
    public JTextField text2;
    public JTextField text3;
    public JTextField text4;
    public JTextField text5;
    JButton okButton;
    DataOutputStream out;
    final int MY_FRAME_CONSTANT = 2;

    public EdditionFrame(JTable table, int row, DataOutputStream out){

        super();
        this.out = out;
        okButton = new JButton("OK");
        okButton.addActionListener(new OkButtonListener(this, out));
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        if (row>=0) {
            if (table.getColumnModel().getColumnCount() == 3) {
                text1 = new JTextField();
                text1.setText((String) table.getValueAt(row, 0).toString());
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
                text4 = new JTextField();
                text4.setText((String) table.getValueAt(row, 3).toString());
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
}

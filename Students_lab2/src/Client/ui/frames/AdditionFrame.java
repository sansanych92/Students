package Client.ui.frames;


import Client.ui.listeners.MyFocusListener;
import Client.ui.listeners.OkButtonListener;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class AdditionFrame extends JFrame {

    public JTextField text1;
    public JTextField text2;
    public JTextField text3;
    public JTextField text4;
    public JTextField text5;
    JButton okButton;
    DataOutputStream out;
    final int MY_FRAME_CONSTANT = 1;

    public AdditionFrame(JTable table, DataOutputStream out){

        super();
        this.out = out;
        okButton = new JButton("OK");
        okButton.addActionListener(new OkButtonListener(this, out));
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

            if (table.getColumnModel().getColumnCount() == 3) {
                text1 = new JTextField();
                text1.addFocusListener(new MyFocusListener(text1));
                text1.setText((String) table.getTableHeader().getColumnModel().getColumn(0).getIdentifier());
                text2 = new JTextField();
                text2.addFocusListener(new MyFocusListener(text2));
                text2.setText((String) table.getTableHeader().getColumnModel().getColumn(1).getIdentifier());
                panel.add(text1);
                panel.add(text2);
                panel.add(okButton);
            } else {
                text1 = new JTextField();
                text1.addFocusListener(new MyFocusListener(text1));
                text1.setText((String) table.getTableHeader().getColumnModel().getColumn(0).getIdentifier());
                text2 = new JTextField();
                text2.addFocusListener(new MyFocusListener(text2));
                text2.setText((String) table.getTableHeader().getColumnModel().getColumn(1).getIdentifier());
                text3 = new JTextField();
                text3.addFocusListener(new MyFocusListener(text3));
                text3.setText((String) table.getTableHeader().getColumnModel().getColumn(2).getIdentifier());
                text4 = new JTextField();
                text4.addFocusListener(new MyFocusListener(text4));
                text4.setText((String) table.getTableHeader().getColumnModel().getColumn(3).getIdentifier());
                text5 = new JTextField();
                text5.addFocusListener(new MyFocusListener(text5));
                text5.setText((String) table.getTableHeader().getColumnModel().getColumn(4).getIdentifier());
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

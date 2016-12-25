package Client.ui.frames;


import Client.ui.listeners.OkButtonListener;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;

/**
 *@author Arsenii
 */
public class SearchFrame extends JFrame{

    public SearchFrame(String parameter, DataOutputStream out){

        super(parameter);
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new OkButtonListener(this, out));
        JTextField field = new JTextField(parameter.split(" ")[parameter.split(" ").length - 1] + " pattern");
        setLayout(new GridBagLayout());
        add(field);
        add(okButton);
        setSize(400,200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
    }
}

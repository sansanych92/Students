package Client.ui.frames;


import Client.ui.listeners.OkButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class SearchFrame extends JFrame{

    JTextField field;
    JButton okButton;

    public SearchFrame(String parameter){

        super(parameter);
        okButton = new JButton("OK");
        okButton.addActionListener(new OkButtonListener(this));
        field = new JTextField(20);
        setLayout(new GridBagLayout());
        add(field);
        add(okButton);
        setSize(400,200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
    }
}

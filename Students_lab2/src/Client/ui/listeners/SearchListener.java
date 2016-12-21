package Client.ui.listeners;


import Client.ui.frames.SearchFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class SearchListener implements ActionListener {

    DataOutputStream out;

    public SearchListener(DataOutputStream out){
        this.out = out;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        new SearchFrame(button.getText(), out);
    }
}

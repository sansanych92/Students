package Client.ui.listeners;


import Client.ui.frames.SearchFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;

/**
 *@author Arsenii
 */
public class SearchListener implements ActionListener {

    private DataOutputStream out;

    public SearchListener(DataOutputStream out){
        this.out = out;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        new SearchFrame(button.getText(), out);
    }
}

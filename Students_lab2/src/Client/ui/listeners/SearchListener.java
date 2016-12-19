package Client.ui.listeners;


import Client.ui.frames.SearchFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class SearchListener implements ActionListener {

    public SearchListener(){}

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        new SearchFrame(button.getText());
    }
}

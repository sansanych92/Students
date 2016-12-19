package Client.ui.listeners;


import Client.ui.frames.AdditionFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class AddButtonListener implements ActionListener {

    JTable table;

    public AddButtonListener(JTable table){
        this.table = table;
    }

  @Override
  public void actionPerformed(ActionEvent e) {
          new AdditionFrame(table);
  }
}

package Client.ui.listeners;


import Client.ui.frames.AdditionFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class AddButtonListener implements ActionListener {

    JTable table;
    public DataOutputStream out;

    public AddButtonListener(JTable table, DataOutputStream out){
        this.table = table;
        this.out = out;
    }

  @Override
  public void actionPerformed(ActionEvent e) {
          new AdditionFrame(table , out);
  }
}

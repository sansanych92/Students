package Client.ui.listeners;


import Client.ui.frames.AdditionFrame;
import Server.Model.GroupModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class AddButtonListener implements ActionListener {

    JTable table;
    public DataOutputStream out;
    List<GroupModel> groups;

    public AddButtonListener(JTable table, DataOutputStream out, List<GroupModel> groups){
        this.table = table;
        this.out = out;
        this.groups = groups;
    }

  @Override
  public void actionPerformed(ActionEvent e) {
          new AdditionFrame(table, groups, out);
  }
}

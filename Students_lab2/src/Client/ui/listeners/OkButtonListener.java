package Client.ui.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class OkButtonListener implements ActionListener {

    JFrame frame;

   public OkButtonListener(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        frame.setVisible(false);
    }
}

package Client.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *@author Arsenii
 */
public class RefreshListener implements ActionListener {

    private DataOutputStream out;

    public RefreshListener(DataOutputStream out){
        this.out = out;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            out.writeUTF("<refresh></refresh>");
            out.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

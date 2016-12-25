package Client.ui.frames;

import javax.swing.*;

/**
 *@author Arsenii
 */
public class ExceptionFrame extends JFrame {

    public ExceptionFrame(String message){
        super();
        JOptionPane.showMessageDialog(this,message);
    }
}

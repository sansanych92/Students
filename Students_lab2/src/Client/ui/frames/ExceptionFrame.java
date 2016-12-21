package Client.ui.frames;

import javax.swing.*;

/**
 * Created by Arsenii on 21.12.2016.
 */
public class ExceptionFrame extends JFrame {

    JTextArea message;
    public ExceptionFrame(String message){
        super();
        JOptionPane.showMessageDialog(this,message);
    }
}

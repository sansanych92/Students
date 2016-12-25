package Client.ui.listeners;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *@author Arsenii
 */
public class MyFocusListener implements FocusListener{

    private JTextField field;
    private String buffStr;

    public MyFocusListener(JTextField field){
        this.field = field;
    }

    @Override
    public void focusGained(FocusEvent e) {
        buffStr = field.getText();
        field.setText("");

    }

    @Override
    public void focusLost(FocusEvent e) {
        buffStr = field.getText();
        field.setText(buffStr);
    }
}

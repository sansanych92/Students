package Client.ui.listeners;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Arsenii on 18.12.2016.
 */
public class MyFocusListener implements FocusListener{

    JTextField field;
    String buffStr;

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

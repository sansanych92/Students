package Client.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by artur_v on 04.12.16.
 */
public class MainView {
    public MainView(){
    }

    public void beginWork(){
        JFrame frame = new JFrame("Система управления данными университета - клиент");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Начать работу");
        frame.getContentPane().add(label);

        frame.setPreferredSize(new Dimension(500, 400));

        frame.pack();
        frame.setVisible(true);
    }
}

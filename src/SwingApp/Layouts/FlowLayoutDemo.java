package SwingApp.Layouts;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo {

    JButton b1, b2, b3, b4, b5;
    JFrame frame;

    public FlowLayoutDemo() {
        frame = new JFrame("FLow Layout Demo");
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        b3 = new JButton("Button3");
        b4 = new JButton("Button4");
        b5 = new JButton("Button5");

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FlowLayoutDemo();
    }
}

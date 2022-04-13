package SwingApp.Layouts;


import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {

    JButton b1, b2, b3, b4, b5;
    JFrame frame;

    public BorderLayoutDemo() {
        frame = new JFrame("Border Layout Demo");
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());

        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        b3 = new JButton("Button3");
        b4 = new JButton("Button4");
        b5 = new JButton("Button5");

        frame.add(b1, BorderLayout.SOUTH);
        frame.add(b2, BorderLayout.NORTH);
        frame.add(b3, BorderLayout.EAST);
        frame.add(b4, BorderLayout.WEST);
        frame.add(b5, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BorderLayoutDemo();
    }
}
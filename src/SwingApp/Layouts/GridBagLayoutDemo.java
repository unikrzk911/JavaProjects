package SwingApp.Layouts;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo {
    JButton b1, b2, b3, b4, b5, b6, b7;
    JFrame frame;

    public GridBagLayoutDemo() {
        frame = new JFrame("GridBag Layout Demo");
        frame.setSize(300, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        b1 = new JButton("Button1");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(b1, gbc);

        b2 = new JButton("Button2");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(b2, gbc);

        b3 = new JButton("Button3");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        frame.add(b3, gbc);

        b4 = new JButton("Button4");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(b4, gbc);

        b5 = new JButton("Button5");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(b5, gbc);

        b7 = new JButton("Button7");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(b7, gbc);

        b6 = new JButton("Button6");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        frame.add(b6, gbc);


        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GridBagLayoutDemo();
    }
}

//gridbag layout
//group Layout

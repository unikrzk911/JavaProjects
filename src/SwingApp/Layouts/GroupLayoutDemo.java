package SwingApp.Layouts;

import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.*;

public class GroupLayoutDemo {
    JButton b1, b2, b3;
    JFrame frame;

    public GroupLayoutDemo() {
        frame = new JFrame("Group Layout Demo");
        frame.setSize(300, 300);

        Container myPanel = frame.getContentPane();

        GroupLayout groupLayout = new GroupLayout(myPanel);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        myPanel.setLayout(groupLayout);

        b1 = new JButton("Button One");
        b2 = new JButton("Button Two");
        b3 = new JButton("Button Three");

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(b1).addComponent(b3))
                .addGroup(groupLayout.createParallelGroup(TRAILING).addComponent(b2)));

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b1).addComponent(b2))
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b3)));

        frame.pack();
        frame.setVisible(true);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GroupLayoutDemo();
    }
}
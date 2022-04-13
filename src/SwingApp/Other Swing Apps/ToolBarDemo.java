package SwingApp;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarDemo implements ActionListener {

    JFrame frame;
    JButton btn1, btn2;
    JComboBox comboBox;
    JToolBar toolBar;
    JPanel panel;

    public ToolBarDemo() {
        frame = new JFrame("Toolbar demo");
        frame.setLayout(new BorderLayout());

        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        btn1 = new JButton("Button1");
        btn1.setActionCommand("btn1");
        btn1.addActionListener(this);
        btn2 = new JButton("Button2");
        btn2.setActionCommand("btn2");
        btn2.addActionListener(this);
        comboBox = new JComboBox(new String[]{"Item1", "Item2", "Item3"});

        panel = new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder());
        panel.add(btn1);
        panel.add(btn2);
        panel.add(comboBox);

        toolBar.add(panel);
        frame.add(toolBar, BorderLayout.NORTH);


        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ToolBarDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btn1")) {
            System.out.println("Button1 clicked");
        } else if (e.getActionCommand().equals("btn2")) {
            System.out.println("Button2 clicked");
        }
    }
}

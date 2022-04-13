package SwingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarDemo implements ActionListener {

    JFrame frame;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, viewMenu, navigateMenu, newItem;
    JMenuItem openItem, openRecentItem, undoTypingItem, toolWindowsItem, backItem, projectItem, moduleItem;


    public MenuBarDemo() {
        frame = new JFrame("Menu Bar Demo");

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        navigateMenu = new JMenu("Navigate");

        newItem = new JMenu("New");
        openItem = new JMenuItem("Open");
        openRecentItem = new JMenuItem("Open Recent");
        undoTypingItem = new JMenuItem("Undo Typing");
        toolWindowsItem = new JMenuItem("Tool Windows");
        toolWindowsItem.setActionCommand("toolswindows");
        toolWindowsItem.addActionListener(this);
        backItem = new JMenuItem("Back");
        projectItem = new JMenuItem("Project");
        projectItem.setActionCommand("projectwindows");
        projectItem.addActionListener(this);
        moduleItem = new JMenuItem("Module");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(navigateMenu);

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(openRecentItem);
        editMenu.add(undoTypingItem);
        viewMenu.add(toolWindowsItem);
        navigateMenu.add(backItem);

        newItem.add(projectItem);
        newItem.add(moduleItem);

        frame.setJMenuBar(menuBar);


        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuBarDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("projectwindows")) {
            System.out.println("Project clicked");
        } else if (e.getActionCommand().equals("toolswindows")) {
            System.out.println("tools window clicked");
        }
    }
}

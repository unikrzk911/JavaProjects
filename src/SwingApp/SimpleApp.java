package SwingApp;


import SwingApp.dao.StudentDao;
import SwingApp.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleApp implements ActionListener, MouseListener, WindowListener, KeyListener {

    JFrame frame;
    JLabel usernameLabel, passwordLabel, showLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, signupButton;

    public SimpleApp() {
        frame = new JFrame("Login Page");
        frame.addWindowListener(this);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(80, 80, 120, 30);

        usernameField = new JTextField();
        usernameField.setBounds(180, 80, 120, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(80, 120, 120, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 120, 120, 30);
        passwordField.setEchoChar('*');

        showLabel = new JLabel("Show");
        showLabel.setBounds(300, 120, 120, 30);
        showLabel.addMouseListener(this);


        loginButton = new JButton("Login");
        loginButton.setBounds(80, 170, 80, 30);
        loginButton.setActionCommand("login");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);

        signupButton = new JButton("Signup");
        signupButton.setBounds(180, 170, 80, 30);
        signupButton.setActionCommand("signup");
        signupButton.setBackground(Color.GREEN);
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(this);


        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(showLabel);
        frame.add(passwordField);
        frame.add(signupButton);
        frame.add(loginButton);


        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login")) {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            if (username.isEmpty() && !password.isEmpty()) {
                JOptionPane.showMessageDialog(this.frame, "Please provide username", "Missing credentials", JOptionPane.ERROR_MESSAGE);
            } else if (!username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this.frame, "Please provide password", "Missing credentials", JOptionPane.ERROR_MESSAGE);
            } else if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this.frame, "Please provide username and password", "Missing credentials", JOptionPane.ERROR_MESSAGE);
            }
            try {
                User user = new User(username, password);
                if (new StudentDao().checkValidUser(user)) {
                    this.frame.dispose();
                    new StudentDetails();
                } else {
                    JOptionPane.showMessageDialog(this.frame, "Invalid username or password", "Invalid credentials", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (e.getActionCommand().equals("signup")) {
            this.frame.dispose();
            new Signup();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        passwordField.setEchoChar((char) 0);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        passwordField.setEchoChar('*');
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int option = JOptionPane.showOptionDialog(this.frame, "Are you sure you want to exit?", "Exit confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (option == 0) {
            System.exit(0);
        } else {
            this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar()=='i'){
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            if (username.isEmpty() && !password.isEmpty()) {
                JOptionPane.showMessageDialog(this.frame, "Please provide username", "Missing credentials", JOptionPane.ERROR_MESSAGE);
            } else if (!username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this.frame, "Please provide password", "Missing credentials", JOptionPane.ERROR_MESSAGE);
            } else if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this.frame, "Please provide username and password", "Missing credentials", JOptionPane.ERROR_MESSAGE);
            }
            try {
                User user = new User(username, password);
                if (new StudentDao().checkValidUser(user)) {
                    this.frame.dispose();
                    new StudentDetails();
                } else {
                    JOptionPane.showMessageDialog(this.frame, "Invalid username or password", "Invalid credentials", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        else if (e.getKeyChar()=='c'){
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocus();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

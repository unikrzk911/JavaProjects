package SwingApp;

import SwingApp.dao.StudentDao;
import SwingApp.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup implements ActionListener {
    JFrame frame;
    JLabel fullNameLabel, emailLabel, userNameLabel, passwordLabel, rePasswordLabel;
    JTextField fullNameField, emailField, userNameField;
    JPasswordField passwordField, rePasswordField;
    JButton register;

    public Signup() {
        frame = new JFrame("Signup Page");


        fullNameLabel = new JLabel("Full Name");
        fullNameLabel.setBounds(80, 80, 120, 30);

        fullNameField = new JTextField();
        fullNameField.setBounds(190, 80, 120, 30);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(80, 120, 120, 30);

        emailField = new JTextField();
        emailField.setBounds(190, 120, 120, 30);

        userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(80, 160, 120, 30);

        userNameField = new JTextField();
        userNameField.setBounds(190, 160, 120, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(80, 200, 120, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 200, 120, 30);

        rePasswordLabel = new JLabel("Retype password");
        rePasswordLabel.setBounds(80, 240, 120, 30);

        rePasswordField = new JPasswordField();
        rePasswordField.setBounds(190, 240, 120, 30);

        register = new JButton("Register");
        register.setBounds(150, 290, 100, 30);
        register.setBackground(Color.BLUE);
        register.setForeground(Color.WHITE);
        register.setToolTipText("Register new user");
        register.addActionListener(this);


        frame.add(fullNameLabel);
        frame.add(emailLabel);
        frame.add(userNameLabel);
        frame.add(passwordLabel);
        frame.add(rePasswordLabel);
        frame.add(fullNameField);
        frame.add(emailField);
        frame.add(userNameField);
        frame.add(passwordField);
        frame.add(rePasswordField);
        frame.add(register);

        frame.setSize(420, 450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fullName = fullNameField.getText().trim();
        String email = emailField.getText().trim();
        String username = userNameField.getText().trim();
        String password = passwordField.getText().trim();
        String rePassword = rePasswordField.getText().trim();

        if (fullName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            JOptionPane.showMessageDialog(this.frame, "Please fill all the fields", "Incomplete details", JOptionPane.INFORMATION_MESSAGE);
        } else if (!password.equals(rePassword)) {
            JOptionPane.showMessageDialog(this.frame, "Two passwords don't match!", "Invalid passwords", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                User user = new User(fullName, email, username, password);
                if (new StudentDao().signupUser(user)) {
                    JOptionPane.showMessageDialog(this.frame, "User registered successfully!!", "User registration", JOptionPane.INFORMATION_MESSAGE);
                    fullNameField.setText("");
                    emailField.setText("");
                    userNameField.setText("");
                    passwordField.setText("");
                    rePasswordField.setText("");
                    this.frame.dispose();
                    new SimpleApp();
                } else {
                    JOptionPane.showMessageDialog(this.frame, "User not registered", "User registration", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

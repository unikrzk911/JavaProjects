package SwingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeightConvert implements ActionListener {
    JFrame frame;
    JLabel inputLabel, outputLabel, passwordLabel, ageLabel;
    JTextField inputTextField, outputTextField;
    JPasswordField passwordField;
    JSlider ageSlider;
    JButton convertButton;

    public  HeightConvert(){
        frame = new JFrame("Height Converter");
        frame.setSize(400,400);

        inputLabel = new JLabel("In meters");
        inputLabel.setBounds(80, 80, 120, 30);
        inputTextField = new JTextField("input height in meters");
        inputTextField.setBounds(180,80,120,30);



        outputLabel = new JLabel("In centimeters");
        outputLabel.setBounds(80,120,120,30);
        outputTextField = new JTextField(2);
        outputTextField.setBounds(180,120,120,30);

        convertButton = new JButton("Convert");
        convertButton.setBounds(80,160,80,30);
        convertButton.setActionCommand("convert");
        convertButton.addActionListener(this);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(80, 200, 120, 30);
        passwordField= new JPasswordField();
        passwordField.setBounds(180,200,120,30);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(80, 240, 120, 30);
        ageSlider = new JSlider(0,80,20);
        ageSlider.setBounds(180,240,120,50);
        ageSlider.setPaintTicks(true);
        ageSlider.setPaintLabels(true);
        ageSlider.setPaintTrack(true);
        ageSlider.setMajorTickSpacing(20);
        ageSlider.setMinorTickSpacing(10);


        frame.add(inputLabel);
        frame.add(outputLabel);
        frame.add(inputTextField);
        frame.add(outputTextField);
        frame.add(convertButton);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(ageLabel);
        frame.add(ageSlider);



        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new HeightConvert();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("convert")){
            int meter = Integer.parseInt(inputTextField.getText());
            int centimeter = meter * 100;
            outputTextField.setText(String.valueOf(centimeter));
        }
    }
}

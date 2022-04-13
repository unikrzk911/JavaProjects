package SwingApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleInterest implements ActionListener {
    JFrame frame;
    JLabel principalLabel, timeLabel, interestLabel, amountLabel;
    JTextField principalField, timeField, interestField, amountField;
    JButton calculateButton;
    public SimpleInterest(){


        frame = new JFrame("Simple Interest");

        principalLabel= new JLabel("Principal");
        principalLabel.setBounds(80,80,120,30);

        principalField= new JTextField();
        principalField.setBounds(180,80,120,30);

        timeLabel= new JLabel("Time");
        timeLabel.setBounds(80,120,120,30);

        timeField= new JTextField();
        timeField.setBounds(180,120,120,30);

        interestLabel= new JLabel("Interest");
        interestLabel.setBounds(80,160,120,30);

        interestField= new JTextField();
        interestField.setBounds(180,160,120,30);

        amountLabel= new JLabel("Amount");
        amountLabel.setBounds(80,200,120,30);

        amountField= new JTextField();
        amountField.setBounds(180,200,120,30);

        calculateButton= new JButton("Calculate");
        calculateButton.setBounds(80,240,120,30);
        calculateButton.setActionCommand("calculate");
        calculateButton.addActionListener(this);

        frame.add(principalLabel);
        frame.add(timeLabel);
        frame.add(interestLabel);
        frame.add(amountLabel);
        frame.add(calculateButton);

        frame.add(principalField);
        frame.add(timeField);
        frame.add(interestField);
        frame.add(amountField);

        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        new SimpleInterest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int p= Integer.parseInt(principalField.getText());
        int t= Integer.parseInt(timeField.getText());
        int r= Integer.parseInt(interestField.getText());
        int a=(p*t*r)/100;
        amountField.setText(String.valueOf(a));
    }
}

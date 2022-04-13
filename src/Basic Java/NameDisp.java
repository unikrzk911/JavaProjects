import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameDisp implements ActionListener {
    JFrame frame;
    JButton btn;
    JLabel firstNameLabel, midNameLabel,lastnameLabel, fullNameLabel;
    JTextField firstNameField, midNameField,lastnameField, fullNameField;

    public NameDisp(){
        frame=new JFrame("NameDisp");

        firstNameLabel =new JLabel("First Name");
        firstNameLabel.setBounds(60,60,120,30);

        midNameLabel =new JLabel("Middle Name");
        midNameLabel.setBounds(60,100,120,30);

        lastnameLabel=new JLabel("Last Name");
        lastnameLabel.setBounds(60,140,120,30);

        fullNameLabel =new JLabel("Full Name");
        fullNameLabel.setBounds(60,240,120,30);

        firstNameField =new JTextField();
        firstNameField.setBounds(160,60,200,30);

        midNameField = new JTextField();
        midNameField.setBounds(160,100,200,30);

        lastnameField=new JTextField();
        lastnameField.setBounds(160,140,200,30);

        btn=new JButton("Show Full Name");
        btn.setBounds(150,200,150,30);
        btn.setActionCommand("show");
        btn.addActionListener(this);

        frame.add(firstNameLabel);
        frame.add(midNameLabel);
        frame.add(lastnameLabel);
        frame.add(fullNameLabel);
        frame.add(firstNameField);
        frame.add(midNameField);
        frame.add(lastnameField);
        frame.add(btn);

        frame.setSize(430,390);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
       new NameDisp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("show")){
            String firstname= firstNameField.getText();
            String middleName= midNameField.getText();
            String lastName = lastnameField.getText();

            fullNameField = new JTextField();
            fullNameField.setBounds(160,240,200,30);

            frame.add(fullNameField);
            fullNameField.setText(firstname+" "+middleName+" "+lastName);
        }
    }
}

package SwingApp;

import SwingApp.dao.StudentDao;
import SwingApp.database.DbConnection;
import SwingApp.model.Student;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDetails implements ActionListener, KeyListener, WindowListener {
    JFrame frame;
    JLabel label;
    JLabel firstNameLabel, lastNameLabel, addressLabel, genderLabel, courseLabel, hobbiesLabel, phoneLabel, remarksLabel;
    JTextField firstnameField, lastNameField, addressField, phoneField, remarksField, studentIdField;
    JCheckBox playingCheckboxField, readingCheckboxField;
    JRadioButton maleRadioField, femaleRadioField;
    ButtonGroup genderGroup;
    String courses[] = {"CSIT", "BCA", "BIM", "BBA", "BBS", "BBM"};
    JComboBox courseField;
    JButton resumeButton, saveButton, editButton, deleteButton;
    JFileChooser resumeChooser;
    JTable studentListTable;
    DefaultTableModel model;
    String columns[] = {"STUDENT ID", "FIRST NAME", "LAST NAME", "ADDRESS", "GENDER", "COURSE", "HOBBIES", "PHONE", "REMARKS"};
    JScrollPane scrollPane;

    public StudentDetails() {
        frame = new JFrame("Student Details");
        frame.addWindowListener(this);

        Font font = new Font("Courier", Font.BOLD, 12);
        frame = new JFrame();
        label = new JLabel("Student Details:");
        label.setBounds(50, 50, 200, 30);
        label.setFont(font);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        studentListTable = new JTable();
        studentListTable.setModel(model);
        scrollPane = new JScrollPane(studentListTable);
        scrollPane.setBounds(400, 80, 800, 200);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(80, 80, 120, 30);
        firstnameField = new JTextField();
        firstnameField.setBounds(190, 80, 150, 30);
        studentIdField = new JTextField();

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(80, 120, 120, 30);
        lastNameField = new JTextField();
        lastNameField.setBounds(190, 120, 150, 30);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(80, 160, 120, 30);
        addressField = new JTextField();
        addressField.setBounds(190, 160, 150, 30);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(80, 200, 120, 30);

        maleRadioField = new JRadioButton("Male");
        maleRadioField.setBounds(190, 200, 80, 30);
        femaleRadioField = new JRadioButton("Female");
        femaleRadioField.setBounds(280, 200, 70, 30);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioField);
        genderGroup.add(femaleRadioField);

        courseLabel = new JLabel("Course");
        courseLabel.setBounds(80, 240, 150, 30);
        courseField = new JComboBox(courses);
        courseField.setBounds(190, 240, 120, 30);

        hobbiesLabel = new JLabel("Hobbies");
        hobbiesLabel.setBounds(80, 280, 120, 30);

        readingCheckboxField = new JCheckBox("Reading");
        readingCheckboxField.setBounds(190, 280, 80, 30);

        playingCheckboxField = new JCheckBox("Playing");
        playingCheckboxField.setBounds(280, 280, 70, 30);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(80, 320, 120, 30);
        phoneField = new JTextField();
        phoneField.setBounds(190, 320, 150, 30);
        phoneField.addKeyListener(this);

        remarksLabel = new JLabel("Remarks");
        remarksLabel.setBounds(80, 360, 120, 30);
        remarksField = new JTextField();
        remarksField.setBounds(190, 360, 150, 30);


        resumeButton = new JButton("Resume");
        resumeButton.setBounds(80, 410, 100, 30);
        resumeButton.setActionCommand("resume");
        resumeButton.addActionListener(this);

        saveButton = new JButton("Save");
        saveButton.setBounds(210, 410, 100, 30);
        saveButton.setBackground(Color.darkGray);
        saveButton.setForeground(Color.white);
        saveButton.setActionCommand("save");
        saveButton.addActionListener(this);

        editButton = new JButton("Edit");
        editButton.setBounds(1000, 280, 100, 30);
        editButton.setBackground(Color.darkGray);
        editButton.setForeground(Color.white);
        editButton.setActionCommand("edit");
        editButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(1100, 280, 100, 30);
        deleteButton.setBackground(Color.darkGray);
        deleteButton.setForeground(Color.white);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(this);


        frame.add(label);
        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(addressLabel);
        frame.add(genderLabel);
        frame.add(courseLabel);
        frame.add(hobbiesLabel);
        frame.add(phoneLabel);
        frame.add(remarksLabel);

        frame.add(firstnameField);
        frame.add(lastNameField);
        frame.add(addressField);
        frame.add(phoneField);
        frame.add(remarksField);
        frame.add(maleRadioField);
        frame.add(femaleRadioField);
        frame.add(playingCheckboxField);
        frame.add(readingCheckboxField);
        frame.add(courseField);

        frame.add(resumeButton);
        frame.add(saveButton);
        frame.add(editButton);
        frame.add(deleteButton);

        frame.add(scrollPane);


        frame.setSize(1300, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        getStudentList();

    }

    public static void main(String[] args) {
        new StudentDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("save")) {
            String fname = firstnameField.getText();
            String lname = lastNameField.getText();
            String address = addressField.getText();
            String gender = maleRadioField.isSelected() ? "Male" : "Female";
            String course = (String) courseField.getSelectedItem();
            List<String> hobbies = new ArrayList<>();
            if (playingCheckboxField.isSelected()) {
                hobbies.add("playing");
            }
            if (readingCheckboxField.isSelected()) {
                hobbies.add("reading");
            }
            StringBuilder sb = new StringBuilder();
            for (String hobby : hobbies) {
                sb.append(hobby);
                sb.append(",");
            }
            String finalHobbies = sb.toString();
            String phone = phoneField.getText();
            String remarks = remarksField.getText();
            try {
                if (studentIdField.getText().isEmpty()) {
                    Student student = new Student(fname, lname, address, gender, course, finalHobbies, phone, remarks);
                    if (new StudentDao().addStudent(student)) {
                        JOptionPane.showMessageDialog(this.frame, "Student added successfully!!", "Student registration", JOptionPane.INFORMATION_MESSAGE);
                        refreshStudentList();
                    } else {
                        JOptionPane.showMessageDialog(this.frame, "Student not added!!", "Student registration", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    Student student = new Student(fname, lname, address, gender, course, finalHobbies, phone, remarks, Integer.parseInt(studentIdField.getText()));
                    if (new StudentDao().updateStudent(student)) {
                        JOptionPane.showMessageDialog(this.frame, "Student updated successfully!!", "Update Student ", JOptionPane.INFORMATION_MESSAGE);
                        refreshStudentList();
                        saveButton.setText("Save");
                    } else {
                        JOptionPane.showMessageDialog(this.frame, "Student not updated!!", "Update Student ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (e.getActionCommand().equals("resume")) {
            resumeChooser = new JFileChooser("D:\\CSIT");
            resumeChooser.setFileFilter(new FileNameExtensionFilter("pdf files only", new String[]{"pdf"}));
            resumeChooser.setMultiSelectionEnabled(true);
            int option = resumeChooser.showOpenDialog(this.frame);
            if (option == 0) {
                //System.out.println(resumeChooser.getSelectedFile().getAbsolutePath());
                for (File file : resumeChooser.getSelectedFiles()) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        } else if (e.getActionCommand().equals("edit")) {
            if (studentListTable.getSelectedRowCount() < 1) {
                JOptionPane.showMessageDialog(this.frame,"Please Select a row to edit","Error",JOptionPane.ERROR_MESSAGE);
            } else if (studentListTable.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(this.frame, "You cannot update more than one row at a time", "Update Confirmation", JOptionPane.ERROR_MESSAGE);
            } else {
                studentIdField.setText(studentListTable.getValueAt(studentListTable.getSelectedRow(), 0).toString());
                saveButton.setText("Update");
                firstnameField.setText((String) studentListTable.getValueAt(studentListTable.getSelectedRow(), 1));
                lastNameField.setText((String) studentListTable.getValueAt(studentListTable.getSelectedRow(), 2));
                addressField.setText((String) studentListTable.getValueAt(studentListTable.getSelectedRow(), 3));
                phoneField.setText((String) studentListTable.getValueAt(studentListTable.getSelectedRow(), 7));
                remarksField.setText((String) studentListTable.getValueAt(studentListTable.getSelectedRow(), 8));
                String gender = ((String) studentListTable.getValueAt(studentListTable.getSelectedRow(), 4));
                if (gender.equals("Male")) {
                    maleRadioField.setSelected(true);
                } else {
                    femaleRadioField.setSelected(true);
                }
                courseField.setSelectedItem((String) studentListTable.getValueAt(studentListTable.getSelectedRow(), 5));
                readingCheckboxField.setSelected(false);
                playingCheckboxField.setSelected(false);
                String hobbies = ((String) studentListTable.getValueAt(studentListTable.getSelectedRow(), 6));
                String[] hobbyArray = hobbies.split(",");
                for (String hobby : hobbyArray) {
                    if (hobby.equals("reading")) {
                        readingCheckboxField.setSelected(true);
                    } else if (hobby.equals("playing")) {
                        playingCheckboxField.setSelected(true);
                    }
                }
            }
        } else if (e.getActionCommand().equals("delete")) {
            if (studentListTable.getSelectedRowCount() < 1) {
                JOptionPane.showMessageDialog(this.frame, "Please select at least one row!", "Delete Confirmation", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if (new StudentDao().deleteStudent(Integer.parseInt(studentListTable.getValueAt(studentListTable.getSelectedRow(), 0).toString()))) {
                        JOptionPane.showMessageDialog(this.frame, "Student deleted successfully!!", "Delete Confirmation", JOptionPane.INFORMATION_MESSAGE);
                        getStudentList();
                    } else {
                        JOptionPane.showMessageDialog(this.frame, "Student not deleted!", "Delete Confirmation", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char input = e.getKeyChar();
        if (phoneField.getText().length() < 10) {
            if (!Character.isDigit(input)) {
                if (input != KeyEvent.VK_BACK_SPACE) {
                    Toolkit.getDefaultToolkit().beep();
                }
                Toolkit.getDefaultToolkit().beep();
                e.consume();
            }
        } else {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

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

    public void getStudentList() {
        if (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        try {
            Connection connection = new DbConnection().getDbConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT STUDENTID,FIRSTNAME,LASTNAME,ADDRESS,GENDER,COURSE,HOBBIES,PHONE,REMARKS FROM STUDENT");
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("STUDENTID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("ADDRESS"),
                        rs.getString("GENDER"),
                        rs.getString("COURSE"),
                        rs.getString("HOBBIES"),
                        rs.getString("PHONE"),
                        rs.getString("REMARKS"),
                });
            }
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshStudentList() {
        getStudentList();
        firstnameField.setText("");
        lastNameField.setText("");
        addressField.setText("");
        phoneField.setText("");
        remarksField.setText("");
        femaleRadioField.setSelected(false);
        genderGroup.clearSelection();
        maleRadioField.setSelected(false);
        courseField.setSelectedItem("CSIT");
        readingCheckboxField.setSelected(false);
        playingCheckboxField.setSelected(false);
    }
}

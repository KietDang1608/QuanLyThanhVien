package GUI;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TKTTSDGUI extends JFrame {
    private JPanel contentPane;
    public TKTTSDGUI() {
        // Setting JFrame properties
        setTitle("Thống kê thành viên vào khu học tập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,950, 595);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        // Creating and adding labels
        JLabel titleLabel = new JLabel("Thống kê thành viên vào khu học tập");
        titleLabel.setBounds(10, 10, 300, 20); // Setting bounds (x, y, width, height)
        contentPane.add(titleLabel);

        JLabel filterLabel = new JLabel("Lọc theo");
        filterLabel.setBounds(10, 40, 100, 20);
        contentPane.add(filterLabel);

        JLabel startDateLabel = new JLabel("Ngày bắt đầu:");
        startDateLabel.setBounds(10, 70, 100, 20);
        contentPane.add(startDateLabel);

        JTextField txtStartDate = new JTextField();
        txtStartDate.setBounds(120, 70, 150, 20);
        contentPane.add(txtStartDate);
        txtStartDate.setEditable(false);

        JButton startDateButton = new JButton("...");
        startDateButton.setBounds(270, 70, 20, 20);
        contentPane.add(startDateButton);



        JLabel lb1 = new JLabel("Time: ");
        contentPane.add(lb1);
        lb1.setBounds(300,70,50,20);
        JLabel lb2 = new JLabel("Time: ");
        contentPane.add(lb2);
        lb2.setBounds(300,100,50,20);

        TimePanel startTime=new TimePanel();
        contentPane.add(startTime);
        startTime.setBounds(300,65,200,25);

        TimePanel endTime=new TimePanel();
        contentPane.add(endTime);
        endTime.setBounds(300,95,200,25);

        JLabel endDateLabel = new JLabel("Ngày kết thúc:");
        endDateLabel.setBounds(10, 100, 100, 20);
        contentPane.add(endDateLabel);

        JTextField txtEndDate = new JTextField();
        txtEndDate.setBounds(120, 100, 150, 20);
        contentPane.add(txtEndDate);
        txtEndDate.setEditable(false);

        JButton endDateButton = new JButton("Time");
        endDateButton.setBounds(270, 100, 20, 20);
        contentPane.add(endDateButton);

        JLabel facultyLabel = new JLabel("Khoa:");
        facultyLabel.setBounds(10, 130, 100, 20);
        contentPane.add(facultyLabel);

        String[] faculties = {"Faculty 1", "Faculty 2", "Faculty 3"}; // Sample data
        JComboBox<String> facultyComboBox = new JComboBox<>(faculties);
        facultyComboBox.setBounds(120, 130, 200, 20);
        contentPane.add(facultyComboBox);

        JLabel departmentLabel = new JLabel("Ngành:");
        departmentLabel.setBounds(10, 160, 100, 20);
        contentPane.add(departmentLabel);

        String[] departments = {"Department 1", "Department 2", "Department 3"}; // Sample data
        JComboBox<String> departmentComboBox = new JComboBox<>(departments);
        departmentComboBox.setBounds(120, 160, 200, 20);
        contentPane.add(departmentComboBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TKTTSDGUI gui = new TKTTSDGUI();
            gui.setVisible(true);
        });
    }
}

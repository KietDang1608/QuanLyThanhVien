package GUI;
import BUS.ThanhVienBUS;
import DTO.ThanhVien;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;


public class TKTTSDGUI extends JFrame {
    private JPanel contentPane;
    private String startDate;
    private String ennDate;
    private String startTime;
    private String endTime;
    private JTextField txtStartDate;
    private JTextField txtEndDate;
    private TimePanel pnStartTime;
    private TimePanel pnEndTime;
    private JComboBox<String> khoaCB;
    private JComboBox<String> nganhCB;
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

        txtStartDate = new JTextField();
        txtStartDate.setBounds(120, 70, 150, 20);
        contentPane.add(txtStartDate);
        txtStartDate.setEditable(false);

        JButton btnStartDate = new JButton("...");
        btnStartDate.setBounds(270, 70, 20, 20);
        contentPane.add(btnStartDate);



        JLabel lb1 = new JLabel("Time: ");
        contentPane.add(lb1);
        lb1.setBounds(300,70,50,20);
        JLabel lb2 = new JLabel("Time: ");
        contentPane.add(lb2);
        lb2.setBounds(300,100,50,20);

        pnStartTime=new TimePanel();
        contentPane.add(pnStartTime);
        pnStartTime.setBounds(300,65,200,25);

        pnEndTime=new TimePanel();
        contentPane.add(pnEndTime);
        pnEndTime.setBounds(300,95,200,25);

        JLabel endDateLabel = new JLabel("Ngày kết thúc:");
        endDateLabel.setBounds(10, 100, 100, 20);
        contentPane.add(endDateLabel);

        txtEndDate = new JTextField();
        txtEndDate.setBounds(120, 100, 150, 20);
        contentPane.add(txtEndDate);
        txtEndDate.setEditable(false);

        JButton btnEndDate = new JButton("Time");
        btnEndDate.setBounds(270, 100, 20, 20);
        contentPane.add(btnEndDate);

        JLabel facultyLabel = new JLabel("Khoa:");
        facultyLabel.setBounds(10, 130, 100, 20);
        contentPane.add(facultyLabel);

        khoaCB = new JComboBox<>();
        khoaCB.setBounds(120, 130, 200, 20);
        contentPane.add(khoaCB);

        JLabel departmentLabel = new JLabel("Ngành:");
        departmentLabel.setBounds(10, 160, 100, 20);
        contentPane.add(departmentLabel);

        nganhCB = new JComboBox<>();
        nganhCB.setBounds(120, 160, 200, 20);
        contentPane.add(nganhCB);

        addDataToCB();

        JButton btnALl = new JButton("All");
        JButton btnLoc = new JButton("Lọc");
        contentPane.add(btnALl);
        contentPane.add(btnLoc);
        btnALl.setBounds(10,190,50,20);
        btnLoc.setBounds(100,190,100,20);
        btnStartDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCalendar calendar = new JCalendar();
                JDialog dialog = new JDialog(TKTTSDGUI.this,"Chọn ngày bắt đầu",true);
                dialog.getContentPane().add(calendar);
                dialog.setSize(300,200);
                dialog.setVisible(true);

                dialog.setModal(true);

                dialog.setLocationRelativeTo(contentPane);
                int y = calendar.getCalendar().get(Calendar.YEAR);
                int m = calendar.getCalendar().get(Calendar.MONTH) + 1;
                int d = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
                String date = formatDate(y,m,d);
                txtStartDate.setText(date);

            }
        });
        btnEndDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCalendar calendar = new JCalendar();
                JDialog dialog = new JDialog(TKTTSDGUI.this,"Chọn ngày kết thúc",true);
                dialog.getContentPane().add(calendar);
                dialog.setSize(300,200);
                dialog.setVisible(true);

                dialog.setModal(true);

                dialog.setLocationRelativeTo(contentPane);
                int y = calendar.getCalendar().get(Calendar.YEAR);
                int m = calendar.getCalendar().get(Calendar.MONTH) + 1;
                int d = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
                String date = formatDate(y,m,d);
                txtEndDate.setText(date);
            }
        });
        setDefaultFilter();

    }
    private void setDefaultFilter(){
        txtEndDate.setText("All");
        txtStartDate.setText("All");
        pnEndTime.setDefault();
        pnStartTime.setDefault();

    }
    private void addDataToCB(){
        ThanhVienBUS tvBUS = new ThanhVienBUS();
        khoaCB.addItem("All");
        nganhCB.addItem("All");
        for (String khoa : tvBUS.getDSKhoa()){
            khoaCB.addItem(khoa);
        }
        for (String nganh : tvBUS.getDSNganh()){
            nganhCB.addItem(nganh);
        }
    }
    private String formatDate(int y, int m, int d){
        String date = "";
        date += String.valueOf(y) + "-";
        if (m < 10){
            date += "0" + String.valueOf(m) + "-";
        }
        else date += String.valueOf(m) + "-";
        if (d < 10){
            date += "0" + String.valueOf(d);
        }
        else date += String.valueOf(d);
        return date;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TKTTSDGUI gui = new TKTTSDGUI();
            gui.setVisible(true);
        });
    }
}

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


    public ArrayList<ThongTinSD> layPhanGiao(ArrayList<ThongTinSD>... lists) {
        // Khởi tạo một HashSet để chứa các phần tử chung
        HashSet<ThongTinSD> commonElementsSet = new HashSet<>(lists[0]);
        // Duyệt qua từng ArrayList trong danh sách đầu vào
        for (int i = 1; i < lists.length; i++) {
            // Tạo một HashSet tạm thời chứa phần tử của ArrayList hiện tại
            HashSet<ThongTinSD> currentListSet = new HashSet<>(lists[i]);
            // Giữ lại các phần tử chung với commonElementsSet
            commonElementsSet.retainAll(currentListSet);
        }
        // Chuyển đổi HashSet thành ArrayList và trả về
        return new ArrayList<>(commonElementsSet);
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
    public void addDataToTable(ArrayList<ThongTinSD> ttsdLIST){
        DefaultTableModel nmodel = new DefaultTableModel();
        nmodel.addColumn("STT");
        nmodel.addColumn("Mã TV");
        nmodel.addColumn("Tên TV");
        nmodel.addColumn("Khoa");
        nmodel.addColumn("Ngành");
//        nmodel.addColumn("maTB",new Object[] {"Mã TB"});
//        nmodel.addColumn("tenTB",new Object[] {"Tên TB"});
        nmodel.addColumn("Thời gian vào");

//        nmodel.addColumn("tgm",new Object[] {"TG mượn"});
//        nmodel.addColumn("tgt",new Object[] {"TG trả"});
        ThanhVienBUS tvBUS = new ThanhVienBUS();
        int i = 1;
        for (ThongTinSD tt : ttsdLIST){
            Vector vt = new Vector<>();
            vt.add(i++);
            vt.add(tt.getMaTV());
            vt.add(tvBUS.getTenByID(tt.getMaTV()));
            vt.add(tvBUS.getKhoaByID(tt.getMaTV()));
            vt.add(tvBUS.getNganhByID(tt.getMaTV()));
            vt.add(tt.getTgVao());
            nmodel.addRow(vt);
        }
        tb.setModel(nmodel);
    }
    
}

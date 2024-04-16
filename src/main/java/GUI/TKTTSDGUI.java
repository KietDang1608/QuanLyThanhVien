package GUI;
import BUS.ThanhVienBUS;
import BUS.ThongKeBUS;
import BUS.ThongTinSDBUS;
import DTO.ThongTinSD;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Vector;


public class TKTTSDGUI extends JFrame {
    private JPanel contentPane;
    private JComboBox<String> khoaCB;
    private JTable tb = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tb);
    private JComboBox<String> nganhCB;
    private JTextField txtNgayBD;
    private JTextField txtNgayKT;
    private TimePanel startTime;
    private TimePanel endTime;

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

        txtNgayBD = new JTextField();
        txtNgayBD.setBounds(120, 70, 150, 20);
        contentPane.add(txtNgayBD);
        txtNgayBD.setEditable(false);

        JButton startDateButton = new JButton("...");
        startDateButton.setBounds(270, 70, 20, 20);
        contentPane.add(startDateButton);

        JLabel lb1 = new JLabel("Time: ");
        contentPane.add(lb1);
        lb1.setBounds(300,70,50,20);
        JLabel lb2 = new JLabel("Time: ");
        contentPane.add(lb2);
        lb2.setBounds(300,100,50,20);

        startTime =new TimePanel();
        contentPane.add(startTime);
        startTime.setBounds(300,65,200,25);

        endTime=new TimePanel();
        contentPane.add(endTime);
        endTime.setBounds(300,95,200,25);

        JLabel endDateLabel = new JLabel("Ngày kết thúc:");
        endDateLabel.setBounds(10, 100, 100, 20);
        contentPane.add(endDateLabel);

        txtNgayKT = new JTextField();
        txtNgayKT.setBounds(120, 100, 150, 20);
        contentPane.add(txtNgayKT);
        txtNgayKT.setEditable(false);

        JButton endDateButton = new JButton("Time");
        endDateButton.setBounds(270, 100, 20, 20);
        contentPane.add(endDateButton);

        JLabel facultyLabel = new JLabel("Khoa:");
        facultyLabel.setBounds(10, 130, 100, 20);
        contentPane.add(facultyLabel);

        khoaCB = new JComboBox<String>();
        khoaCB.setBounds(120, 130, 200, 20);
        contentPane.add(khoaCB);

        JLabel departmentLabel = new JLabel("Ngành:");
        departmentLabel.setBounds(10, 160, 100, 20);
        contentPane.add(departmentLabel);

        nganhCB = new JComboBox<String>();
        nganhCB.setBounds(120, 160, 200, 20);
        contentPane.add(nganhCB);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10,220,910,300);
        contentPane.add(scrollPane);
        ThongTinSDBUS bus = new ThongTinSDBUS();
        addDataToTable(bus.getListThongTinSD());

        JButton btnALl = new JButton("All");
        JButton btnLoc = new JButton("Lọc");
        contentPane.add(btnALl);
        contentPane.add(btnLoc);
        btnALl.setBounds(10,190,50,20);
        btnLoc.setBounds(100,190,100,20);
        setDefaultFilter();
        addDataToCB();

        startDateButton.addActionListener(new ActionListener() {
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
                txtNgayBD.setText(date);
            }
        });
        endDateButton.addActionListener(new ActionListener() {
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
                txtNgayKT.setText(date);
            }
        });
        btnLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loc();
            }
        });
        btnALl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDataToTable(bus.getListThongTinSD());
            }
        });
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
    public void setDefaultFilter(){
        ThongTinSDBUS  bus = new ThongTinSDBUS();

        txtNgayBD.setText("All");
        txtNgayKT.setText("All");
        startTime.setDefault();
        endTime.setDefault();

        addDataToTable(bus.getListThongTinSD());
    }
    public void loc(){
        ThongTinSDBUS bus = new ThongTinSDBUS();
        ThongKeBUS tkBus = new ThongKeBUS();
        ArrayList<ThongTinSD> theoNgayBD = bus.getListThongTinSD();
        ArrayList<ThongTinSD> theoNgayKT = bus.getListThongTinSD();
        ArrayList<ThongTinSD> theoKhoa = bus.getListThongTinSD();
        ArrayList<ThongTinSD> theoNganh = bus.getListThongTinSD();

        if (!txtNgayBD.getText().equals("All")){
            theoNgayBD = new ArrayList<>();
            theoNgayBD = tkBus.getDSTVByStart(txtNgayBD.getText(),startTime.getSelectedTime());
        }
        if (!txtNgayKT.getText().equals("All")){
            theoNgayKT = new ArrayList<>();
            theoNgayKT = tkBus.getDSTVByEnd(txtNgayKT.getText(),endTime.getSelectedTime());
        }
        if (khoaCB.getSelectedIndex() != 0){
            theoKhoa = new ArrayList<>();
            theoKhoa = tkBus.getDSThanhVienByKhoa(String.valueOf(khoaCB.getSelectedItem()));
        }
        if (nganhCB.getSelectedIndex() != 0){
            theoNganh = new ArrayList<>();
            theoNganh = tkBus.getDSTVBYNganh(String.valueOf(nganhCB.getSelectedItem()));
        }
        for (ThongTinSD tt : theoNganh) System.out.println(tt.toString());
        addDataToTable(layPhanGiao(theoNgayBD,theoNgayKT,theoKhoa,theoNganh));
    }
}

package GUI;

import BUS.ThanhVienBUS;
import BUS.ThietBiBUS;
import BUS.ThongTinSDBUS;
import DTO.ThietBi;
import DTO.ThongTinSD;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Vector;

public class TKTBGUI extends JFrame {
    private JPanel contentPane;
    private JTextField txtStartDate;
    private JTextField txtEndDate;
    private TimePanel pnStartTime;
    private TimePanel pnEndTime;
    private JTextField txtTenTB ;
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    public TKTBGUI(){
        setBounds(0,0,950, 595);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Thống kê thiết bị được mượn");
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

        JLabel facultyLabel = new JLabel("Tên thiết bị:");
        facultyLabel.setBounds(10, 130, 100, 20);
        contentPane.add(facultyLabel);


        txtTenTB = new JTextField();
        txtTenTB.setBounds(120, 130, 200, 20);
        contentPane.add(txtTenTB);

        JButton btnALl = new JButton("All");
        JButton btnLoc = new JButton("Lọc");
        contentPane.add(btnALl);
        contentPane.add(btnLoc);
        btnALl.setBounds(10,190,50,20);
        btnLoc.setBounds(100,190,100,20);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10,220,910,300);
        contentPane.add(scrollPane);

        btnStartDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCalendar calendar = new JCalendar();
                JDialog dialog = new JDialog(TKTBGUI.this,"Chọn ngày bắt đầu",true);
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
                JDialog dialog = new JDialog(TKTBGUI.this,"Chọn ngày kết thúc",true);
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
        setDefault();
        btnALl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefault();
            }
        });
        btnLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loc();
            }
        });
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
    public void addDataToTable(ArrayList<ThongTinSD> lstSuDung){

        DefaultTableModel nmodel = new DefaultTableModel();
        nmodel.addColumn("STT");
        nmodel.addColumn("Mã TB");
        nmodel.addColumn("Tên TB");
        nmodel.addColumn("TG Mượn");

//        nmodel.addColumn("tgm",new Object[] {"TG mượn"});
//        nmodel.addColumn("tgt",new Object[] {"TG trả"});
        ThietBiBUS tbBUS = new ThietBiBUS();
        int i = 1;
        for (ThongTinSD tt : lstSuDung){
            Vector vt = new Vector<>();
            vt.add(i++);
            vt.add(tt.getMaTB());
            vt.add(tbBUS.getNameByID(tt.getMaTB()));
            vt.add(tt.getTgMuon());
            nmodel.addRow(vt);
        }
        table.setModel(nmodel);

    }
    public void setDefault(){
        txtTenTB.setText("");
        txtStartDate.setText("All");
        txtEndDate.setText("All");
        pnStartTime.setDefault();
        pnEndTime.setDefault();
        ThietBiBUS thietBiBUS = new ThietBiBUS();
        addDataToTable(thietBiBUS.ThongKeDangMuon());
    }
    public void loc(){
        ThietBiBUS thietBiBUS = new ThietBiBUS();
        ArrayList<ThongTinSD> theoNgayBD = thietBiBUS.ThongKeDangMuon();
        ArrayList<ThongTinSD> theoNgayKT = thietBiBUS.ThongKeDangMuon();
        ArrayList<ThongTinSD> theoTen = thietBiBUS.ThongKeDangMuon();
        if (!txtStartDate.getText().equals("All")){
            theoNgayBD = thietBiBUS.ThongKeByStartDate(txtStartDate.getText() + " " + pnStartTime.getSelectedTime());
        }
        if (!txtEndDate.getText().equals("All")){
            theoNgayKT = thietBiBUS.ThongKeByEndDate(txtEndDate.getText() + " " + pnEndTime.getSelectedTime());
        }
        if (txtTenTB.getText().length()!=0){
            theoTen = thietBiBUS.ThongKeByName(txtTenTB.getText());
        }
        addDataToTable(layPhanGiao(theoNgayBD,theoNgayKT,theoTen));
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
}

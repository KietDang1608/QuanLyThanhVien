package GUI;

import BUS.ThanhVienBUS;
import DTO.ThongTinSD;
import DTO.XuLy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class TKXLGUI extends JFrame {
    private JPanel contentPane;
    private JRadioButton btnDaXuLy;
    private JRadioButton btnDangXuLy;
    private JRadioButton btnALL;
    private JTextField txtTien;
    private JTable table =  new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    public TKXLGUI(){
        setBounds(0,0,950, 595);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Thống kê xử lý vi phạm");
        titleLabel.setBounds(10, 10, 300, 20); // Setting bounds (x, y, width, height)
        contentPane.add(titleLabel);

        JLabel filterLabel = new JLabel("Lọc theo");
        filterLabel.setBounds(10, 40, 100, 20);
        contentPane.add(filterLabel);

        ButtonGroup gr = new ButtonGroup();
        btnDaXuLy = new JRadioButton("Đã xử lý");
        btnDangXuLy = new JRadioButton("Đang xử lý");
        btnALL = new JRadioButton("All");
        gr.add(btnDangXuLy);
        gr.add(btnDaXuLy);

        btnDangXuLy.setBounds(10,70,100,30);
        btnDaXuLy.setBounds(120,70,100,30);
        btnALL.setBounds(230,70,100,30);
        contentPane.add(btnDangXuLy);
        contentPane.add(btnDaXuLy);
        contentPane.add(btnALL);

        btnALL.setSelected(true);

        JLabel lb = new JLabel("Tổng tiền: ");
        contentPane.add(lb);
        lb.setBounds(10,110,100,30);
        txtTien = new JTextField();
        txtTien.setEditable(false);
        txtTien.setBounds(130,110,110,30);
        contentPane.add(txtTien);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10,220,910,300);
        contentPane.add(scrollPane);

    }
    public void addDataToTable(ArrayList<XuLy> lstXuLy){
        DefaultTableModel nmodel = new DefaultTableModel();
        nmodel.addColumn("Mã xử lý");
        nmodel.addColumn("Mã TV");
        nmodel.addColumn("Hình thức xử lý");
        nmodel.addColumn("Số tiền");
        nmodel.addColumn("Ngày xử lý");
        nmodel.addColumn("Trạng thái xử lý");

        for (XuLy xl : lstXuLy){
            Vector vt = new Vector<>();
            vt.add(xl.getMaXL());
            vt.add(xl.getMaTV());
            vt.add(xl.getHinhThucXL());
            vt.add(xl.getSoTien());
            vt.add(xl.getNgayXL());
            vt.add(xl.getTrangThaiXL()==0?"Đang xử lý":"Đã xử lý");
            nmodel.addRow(vt);
        }
        table.setModel(nmodel);
    }
}

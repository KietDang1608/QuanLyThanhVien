package GUI;

import BUS.ThanhVienBUS;
import BUS.ThietBiBUS;
import BUS.ThongTinSDBUS;
import BUS.XuLyBUS;
import DTO.ThongTinSD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ThongTinGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaTV;
	private JTextField maTBMuon;
	private JTextField maTBTra;
	private JButton btnMuon;
	private JButton btnTra;
	private JLabel lb;
 	private JLabel lbtbTra;
	 private JTable table = new JTable();
	 private JScrollPane scrollPane = new JScrollPane(table);


	public ThongTinGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(192, 46, 1092, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBounds(0, 0, 1092, 72);
		panelTop.setBackground(new Color(168, 205, 159));
		contentPane.add(panelTop);
		panelTop.setLayout(null);
		
		JLabel LabelHead = new JLabel("THÔNG TIN RA VÀO KHU VỰC HỌC TẬP");
		LabelHead.setForeground(new Color(255, 255, 255));
		LabelHead.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelHead.setBounds(462-100, 11, 400, 53);
		panelTop.add(LabelHead);
		
		JLabel lbmatv = new JLabel("Nhập mã thành viên: ");
		contentPane.add(lbmatv);
		lbmatv.setBounds(10,100,150,20);

		txtMaTV = new JTextField();
		contentPane.add(txtMaTV);
		txtMaTV.setBounds(160,100,100,20);

		JButton btnCheck = new JButton("Xác nhận vào");
		contentPane.add(btnCheck);
		btnCheck.setBounds(270,100,150,20);
		btnMuon = new JButton("Mượn thiết bị");
		btnTra = new JButton("Trả thiết bị");

		contentPane.add(btnMuon);
		contentPane.add(btnTra);
		btnMuon.setBounds(10,150,150,20);
		btnTra.setBounds(200,150,150,20);

		JButton btnReload = new JButton("Reload");
		btnReload.setBounds(400,150,100,20);
		contentPane.add(btnReload);
		btnReload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ThongTinSDBUS thongTinSDBUS = new ThongTinSDBUS();
				addDataToTable(thongTinSDBUS.getListThongTinSD());
			}
		});
		btnTra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormTra f = new FormTra();
				f.setVisible(true);
			}
		});
		btnMuon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormMuon f = new FormMuon();
				f.setVisible(true);
			}
		});
		ThongTinSDBUS thongTinSDBUS = new ThongTinSDBUS();

		addDataToTable(thongTinSDBUS.getListThongTinSD());
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0,220,1100,400);
		contentPane.add(scrollPane);

		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkMaTV();
				txtMaTV.setText("");
				txtMaTV.requestFocus();
			}
		});
		txtMaTV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Xử lý sự kiện khi nhấn phím Enter
				checkMaTV();

				// Xóa nội dung của JTextField sau khi nhấn Enter (tùy chọn)
				txtMaTV.setText("");
				txtMaTV.requestFocus();
			}
		});

	}

	private void addDataToTable(ArrayList<ThongTinSD> lstSD){
		DefaultTableModel nmodel = new DefaultTableModel();
		nmodel.addColumn("Mã TV");
		nmodel.addColumn("Tên TV");
		nmodel.addColumn("Khoa");
		nmodel.addColumn("Ngành");
        nmodel.addColumn("Mã thiết bị");
        nmodel.addColumn("Tên thiết bị");
		nmodel.addColumn("Thời gian vào");
		nmodel.addColumn("Thời gian mượn");
		nmodel.addColumn("Thời gian trả");

//        nmodel.addColumn("tgm",new Object[] {"TG mượn"});
//        nmodel.addColumn("tgt",new Object[] {"TG trả"});
		ThanhVienBUS tvBUS = new ThanhVienBUS();
		ThietBiBUS tbBUS = new ThietBiBUS();
		int i = 1;
		for (ThongTinSD tt : lstSD){
			Vector vt = new Vector<>();
			vt.add(tt.getMaTV());
			vt.add(tvBUS.getNameByID(tt.getMaTV()));
			vt.add(tvBUS.getKhoaByID(tt.getMaTV()));
			vt.add(tvBUS.getNganhByID(tt.getMaTV()));
			vt.add(tt.getMaTB()==-1?"":tt.getMaTB());
			vt.add(tbBUS.getNameByID(tt.getMaTB()));
			vt.add(tt.getTgVao());
			vt.add(tt.getTgMuon());
			vt.add(tt.getTgTra());

			nmodel.addRow(vt);
		}
		table.setModel(nmodel);
	}
	private void showMessage(String thongbao){
		JOptionPane.showMessageDialog(null,thongbao);
	}
	private void checkMaTV(){
		ThanhVienBUS tvBUS = new ThanhVienBUS();
		XuLyBUS xlbus = new XuLyBUS();

		if (txtMaTV.getText().isEmpty()){
			showMessage("Vui lòng nhập mã thành viên!");
			return;
		}
		else if (tvBUS.checkThanhVien(Integer.valueOf(txtMaTV.getText()))==false ){
			showMessage("Không phải thành viên!");
			return;
		}
		else if (xlbus.checkTVViPham(Integer.valueOf(txtMaTV.getText()) )== true){
			showMessage("Thành viên đang vi phạm!");
			return;
		}
		LocalDateTime currentDateTime = LocalDateTime.now();

		// Định dạng theo yyyy-mm-dd hh:mm:ss
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Áp dụng định dạng cho ngày và giờ hiện tại
		String formattedDateTime = currentDateTime.format(formatter);
		ThongTinSD tt = new ThongTinSD(Integer.valueOf(txtMaTV.getText()),null,formattedDateTime,null,null,null);
		ThongTinSDBUS ttBUS = new ThongTinSDBUS();
		ttBUS.addData(tt);
		addDataToTable(ttBUS.getData());
	}

}

package GUI;

import BUS.ThanhVienBUS;
import DTO.ThongTinSD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ThongTinGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaTV;
	private JTextField maTBMuon;
	private JTextField maTBTra;
	private JRadioButton radMuon;
	private JRadioButton radTra;
	private JLabel lb;
 	private JLabel lbtbTra;
	 private JTable table = new JTable();
	 private JScrollPane scrollPane = new JScrollPane(table);
	 private ArrayList<ThongTinSD> lstVao = new ArrayList<>();

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
		ButtonGroup gr = new ButtonGroup();
		gr.add(radMuon);
		gr.add(radTra);

		radMuon = new JRadioButton("Mượn thiết bị");
		radTra = new JRadioButton("Trả thiết bị");
		contentPane.add(radMuon);
		contentPane.add(radTra);
		radMuon.setBounds(10,150,150,20);
		radTra.setBounds(200,150,150,20);

		maTBMuon = new JTextField();
		lb = new JLabel("Nhập mã thiết bị mượn: ");
		contentPane.add(lb);
		maTBMuon.setBounds(320,200,100,20);

		maTBTra  = new JTextField();
		contentPane.add(maTBMuon);
		contentPane.add(maTBTra);

		lb.setVisible(false);
		maTBMuon.setVisible(false);
		lb.setBounds(10,200,300,20);
		lbtbTra = new JLabel("Nhập mã thiết bị trả: ");
		contentPane.add(lbtbTra);

		maTBTra.setBounds(320,200,100,20);
		maTBTra.setVisible(false);
		lbtbTra.setVisible(false);

		radMuon.setSelected(true);
		setDefault();

		radTra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toTra();
			}
		});
		radMuon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefault();
			}
		});
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10,220,1000,400);
		contentPane.add(scrollPane);
	}
	private void setDefault(){

		lb.setVisible(true);
		maTBMuon.setVisible(true);

		lbtbTra.setVisible(false);
		maTBTra.setVisible(false);

	}
	private void toTra(){
		lb.setVisible(false);
		maTBMuon.setVisible(false);

		lbtbTra.setVisible(true);
		maTBTra.setVisible(true);
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
		int i = 1;
		for (ThongTinSD tt : lstSD)
		table.setModel(nmodel);
	}

}

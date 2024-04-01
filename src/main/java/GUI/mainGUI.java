package GUI;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class mainGUI extends JFrame {

	private JPanel contentPane;
	private ThanhVienGUI tvGui = new ThanhVienGUI();
	private ThietBiGUI tbGui = new ThietBiGUI();
	private ThongTinGUI ttGui = new ThongTinGUI();
	private XuLyGUI xlGui = new XuLyGUI();
	private ThongKeGUI tkGui = new ThongKeGUI();
 JFrame[] frames = {tvGui, tbGui, ttGui, xlGui, tkGui};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI frame = new mainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 244, 197));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		for (JFrame frame:frames){
			contentPane.add(frame.getContentPane());
			frame.getContentPane().setBounds(192, 46, 1092, 665);
		}
		tatMenu();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(73, 105, 137));
		panelMenu.setBounds(0, 0, 193, 711);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JButton btnThanhvien = new JButton("Thành Viên");
		btnThanhvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThanhvien.setForeground(new Color(255, 255, 255));
		btnThanhvien.setHorizontalAlignment(SwingConstants.LEFT);
		btnThanhvien.setBackground(new Color(73, 105, 137));
		btnThanhvien.setBounds(20, 212, 147, 54);
		panelMenu.add(btnThanhvien);
		btnThanhvien.setIcon(new ImageIcon("src\\main\\java\\IMG\\group.png"));
		btnThanhvien.setBorder(null);
		
		btnThanhvien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub)
				tatMenu();
				tvGui.getContentPane().setVisible(true);

			}
			
		});
		
		
		JButton btnThongtinsd = new JButton("Thông Tin SD");
		btnThongtinsd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThongtinsd.setForeground(new Color(255, 255, 255));
		btnThongtinsd.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongtinsd.setBackground(new Color(73, 105, 137));
		btnThongtinsd.setBounds(20, 376, 147, 54);
		panelMenu.add(btnThongtinsd);
		btnThongtinsd.setIcon(new ImageIcon("src\\main\\java\\IMG\\parchment.png"));
		btnThongtinsd.setBorder(null);
		btnThongtinsd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tatMenu();
				ttGui.getContentPane().setVisible(true);
			}
		});
		
		
		

		
		JButton btnThietbi = new JButton("Thiết Bị");
		btnThietbi.setIcon(new ImageIcon("src\\main\\java\\IMG\\device.png"));
		btnThietbi.setHorizontalAlignment(SwingConstants.LEFT);
		btnThietbi.setForeground(Color.WHITE);
		btnThietbi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThietbi.setBorder(null);
		btnThietbi.setBackground(new Color(73, 105, 137));
		btnThietbi.setBounds(20, 294, 147, 54);
		panelMenu.add(btnThietbi);
		btnThietbi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tatMenu();
				tbGui.getContentPane().setVisible(true);
			}
		});
		
		JButton btnXuly = new JButton("Xử Lý");
		btnXuly.setIcon(new ImageIcon("src\\main\\java\\IMG\\crisis-management.png"));
		btnXuly.setHorizontalAlignment(SwingConstants.LEFT);
		btnXuly.setForeground(Color.WHITE);
		btnXuly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXuly.setBorder(null);
		btnXuly.setBackground(new Color(73, 105, 137));
		btnXuly.setBounds(20, 458, 147, 54);
		panelMenu.add(btnXuly);
		btnXuly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tatMenu();
				xlGui.getContentPane().setVisible(true);
			}
		});
		
		JLabel logo = new JLabel("");
		logo.setBounds(10, 11, 173, 173);
		panelMenu.add(logo);
		logo.setIcon(new ImageIcon("src\\main\\java\\IMG\\logo (1).jpg"));
		
		JButton btnThongke = new JButton("Thống Kê");
		btnThongke.setIcon(new ImageIcon("src\\main\\java\\IMG\\description.png"));
		btnThongke.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongke.setForeground(Color.WHITE);
		btnThongke.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThongke.setBorder(null);
		btnThongke.setBackground(new Color(73, 105, 137));
		btnThongke.setBounds(20, 540, 147, 54);
		panelMenu.add(btnThongke);
		btnThongke.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tatMenu();
				tkGui.getContentPane().setVisible(true);
			}
		});
		
		JPanel header = new JPanel();
		header.setBackground(new Color(88, 163, 153));
		header.setBounds(192, 0, 1300, 46);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel lbNameUser = new JLabel("Hello guys");
		lbNameUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNameUser.setForeground(new Color(255, 255, 255));
		lbNameUser.setBounds(992, 11, 100, 24);
		
		header.add(lbNameUser);
		
		

	}
	public void tatMenu(){
		for (JFrame frame:frames){
			frame.getContentPane().setVisible(false);
		}
	}
}

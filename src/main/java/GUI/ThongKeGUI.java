package GUI;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ThongKeGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeGUI frame = new ThongKeGUI();
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
	public ThongKeGUI() {
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
		
		JLabel LabelHead = new JLabel("THỐNG KÊ");
		LabelHead.setForeground(new Color(255, 255, 255));
		LabelHead.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelHead.setBounds(462, 11, 219, 53);
		panelTop.add(LabelHead);
		
		JPanel leftMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
		leftMenu.setBounds(0,70,150,665-70);
		contentPane.add(leftMenu);
		leftMenu.setBackground(new Color(254, 251, 246));

		JButton btnTTSD = new JButton("Thống kê TT sử dụng");
		leftMenu.add(btnTTSD);

		JButton btnThietBi = new JButton("Thống kê thiết bị");
		leftMenu.add(btnThietBi);

		JButton btnXuLi = new JButton("Thống kê xử lý");
		leftMenu.add(btnXuLi);
	}

}

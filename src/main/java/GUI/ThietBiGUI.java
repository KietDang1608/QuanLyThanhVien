package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.ThietBiBUS;
import DTO.ThietBi;

public class ThietBiGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_qltb;
	private JTextField text_tenTB;
	private JTextField text_maTB;
	ThietBiBUS bus = new ThietBiBUS();

    String relativeExcel = "C:\\Users\\MINH HUU\\Documents\\GitHub\\QuanLyThanhVien\\src\\main\\java\\IMG\\excel.png";
    String relativeDeletes = "C:\\Users\\MINH HUU\\Documents\\GitHub\\QuanLyThanhVien\\src\\main\\java\\IMG\\bin.png";
    String relativeDelete = "C:\\Users\\MINH HUU\\Documents\\GitHub\\QuanLyThanhVien\\src\\main\\java\\IMG\\clear.png";
    String relativeAdd = "C:\\Users\\MINH HUU\\Documents\\GitHub\\QuanLyThanhVien\\src\\main\\java\\IMG\\plus.png";
    String relativeUpdate = "C:\\Users\\MINH HUU\\Documents\\GitHub\\QuanLyThanhVien\\src\\main\\java\\IMG\\update.png";
    String excel = new File(relativeExcel).getAbsolutePath();
    String deletes = new File(relativeDeletes).getAbsolutePath();
    String delete = new File(relativeDelete).getAbsolutePath();
    String add = new File(relativeAdd).getAbsolutePath();
    String update = new File(relativeUpdate).getAbsolutePath();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThietBiGUI frame = new ThietBiGUI();
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
	public ThietBiGUI() {
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
		
		JLabel LabelHead = new JLabel("THIẾT BỊ");
		LabelHead.setForeground(new Color(255, 255, 255));
		LabelHead.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelHead.setBounds(462, 11, 219, 53);
		panelTop.add(LabelHead);
		
		table_qltb = new JTable();
		table_qltb.setBounds(10, 82, 1068, 360);
		contentPane.add(table_qltb);
		
		text_tenTB = new JTextField();
		text_tenTB.setBounds(111, 553, 96, 19);
		contentPane.add(text_tenTB);
		text_tenTB.setColumns(10);
		
		text_maTB = new JTextField();
		text_maTB.setBounds(111, 472, 96, 19);
		text_maTB.setEditable(false);
		contentPane.add(text_maTB);
		text_maTB.setColumns(10);
		
		JLabel lblMThitB = new JLabel("Mã Thiết Bị :");
		lblMThitB.setBounds(21, 475, 80, 13);
		contentPane.add(lblMThitB);
		
		JLabel label_tenTB = new JLabel("Tên Thiết Bị :");
		label_tenTB.setBounds(21, 553, 80, 13);
		contentPane.add(label_tenTB);
		
		JLabel lblMTThit = new JLabel("Mô Tả Thiết Bị :");
		lblMTThit.setBounds(228, 475, 96, 13);
		contentPane.add(lblMTThit);
		
		JTextArea textArea_motaTB = new JTextArea();
		textArea_motaTB.setBounds(327, 469, 282, 112);
		contentPane.add(textArea_motaTB);
		
		JButton btn_themTB = new JButton("Thêm Thiết Bị");

		btn_themTB.setBounds(916, 466, 152, 31);
		btn_themTB.setBackground(new Color(68,238,187));
//		btn_themTB.setForeground(Color.white);
		btn_themTB.setIcon(new ImageIcon(add));
		contentPane.add(btn_themTB);
		
		JButton btn_suaTB = new JButton("Sửa Thiết Bị");
		btn_suaTB.setBounds(916, 518, 152, 31);
		btn_suaTB.setBackground(new Color(250,224,199));
//		btn_suaTB.setForeground(Color.white);
		btn_suaTB.setIcon(new ImageIcon(update));
		contentPane.add(btn_suaTB);
		
		JButton btn_xoaTB = new JButton("Xóa Thiết Bị");
		btn_xoaTB.setBounds(916, 570, 152, 31);
		btn_xoaTB.setBackground(new Color(242,128,118));
//		btn_xoaTB.setForeground(Color.white);
		btn_xoaTB.setIcon(new ImageIcon(delete));
		contentPane.add(btn_xoaTB);
		
		JButton btn_xoaTBByDK = new JButton("Xóa Nhiều Thiết Bị");
		btn_xoaTBByDK.setBounds(751, 466, 142, 31);
		btn_xoaTBByDK.setBackground(new Color(242,128,118));
		btn_xoaTBByDK.setForeground(Color.white);
		btn_xoaTBByDK.setIcon(new ImageIcon(deletes));
		contentPane.add(btn_xoaTBByDK);
		
		JButton btn_themTBEX = new JButton("Excel");

		btn_themTBEX.setBounds(629, 466, 101, 31);
		btn_themTBEX.setIcon(new ImageIcon(excel));
		btn_themTBEX.setBackground(new Color(68,238,187));
		btn_themTBEX.setForeground(Color.white);
		contentPane.add(btn_themTBEX);
		
		btn_themTB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tenTB = text_tenTB.getText();
				String motaTB = textArea_motaTB.getText();
				ThietBi tb = new ThietBi(tenTB,motaTB);
				if(text_tenTB.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập Tên Thiết Bị!", "Thông báo", JOptionPane.WARNING_MESSAGE);
				}else {
					bus.addThietBi(tb);
					reloadTable();
				}
			}
		});
		btn_suaTB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int maTB = Integer.parseInt(text_maTB.getText());
				String tenTB = text_tenTB.getText();
				String motaTB = textArea_motaTB.getText();
				ThietBi tb = new ThietBi(tenTB,motaTB);
				if(text_tenTB.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập Tên Thiết Bị!", "Thông báo", JOptionPane.WARNING_MESSAGE);
				}else {
					bus.updateThietBi(maTB, tb);
					reloadTable();
				}
			}
		});
		btn_xoaTB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int maTB = Integer.parseInt(text_maTB.getText());
					bus.delThietBi(maTB);
					reloadTable();
			}
		});
		btn_xoaTBByDK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDelDeviceForm();
			}
		});
		btn_themTBEX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					chooseExcelFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		table_qltb.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        int i=table_qltb.getSelectedRow();
		        text_maTB.setText(String.valueOf(table_qltb.getValueAt(i, 0)));
		        text_tenTB.setText(String.valueOf(table_qltb.getValueAt(i, 1)));
		        textArea_motaTB.setText(String.valueOf(table_qltb.getValueAt(i, 2)));
		    }
		});
		
		// Tạo JScrollPane
		JScrollPane scrollPane = new JScrollPane(table_qltb);
		scrollPane.setBounds(10, 82, 1068, 360);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);

		// Thêm bảng vào JScrollPane
		scrollPane.setViewportView(table_qltb);

		// Tạo JScrollBar cho JScrollPane
		JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		scrollBar.setBounds(0, 0, scrollPane.getWidth(), 17);
		contentPane.add(scrollBar, BorderLayout.EAST);

		// Thêm sự kiện AdjustmentListener cho thanh cuộn
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
		    @Override
		    public void adjustmentValueChanged(AdjustmentEvent e) {
		        // Cập nhật vị trí của bảng khi thanh cuộn di chuyển
		        table_qltb.scrollRectToVisible(new Rectangle(0, e.getValue(), table_qltb.getWidth(), table_qltb.getHeight()));
		    }
		});
        reloadTable();
        
		
	}
	public void reloadTable()
	{
		addDBToTable(bus.getData());
	}
	public void addDBToTable(ArrayList <ThietBi> lst)
	{
		DefaultTableModel nmodel = new DefaultTableModel();
		nmodel.addColumn("MaTB",new Object[] {"Mã Thiết Bị"});
		nmodel.addColumn("TenTB",new Object[] {"Tên Thiết Bị"});
		nmodel.addColumn("MoTaTB",new Object[] {"Mô Tả Thiết Bị"});	
		for(ThietBi tb : lst)
		{
			Vector vt = new Vector();
			vt.add(tb.getMaTB());
			vt.add(tb.getTenTB());
			vt.add(tb.getMoTa());
			nmodel.addRow(vt);
		}
		table_qltb.setModel(nmodel);
	}
	 private void showDelDeviceForm() {
			String[] option ={"TenTB","MoTaTB"};
			JComboBox cb = new JComboBox(option);
	        // Tạo cửa sổ mới để chứa form thêm thiết bị
	        JFrame addDeviceFrame = new JFrame("Thêm Thiết Bị");

	        // Khởi tạo các thành phần của form

	        JLabel lbl_dk = new JLabel("Điều Kiện :");
	        JTextArea txt_modkTB = new JTextArea(5, 20);
	        JButton btn_xoa = new JButton("Xóa");
	        btn_xoa.setBackground(new Color(242,128,118));
	        btn_xoa.setForeground(Color.white);
	        btn_xoa.setIcon(new ImageIcon(delete));

	        // Xử lý sự kiện khi nhấn nút "Lưu"


	        // Thêm các thành phần vào form
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(3, 2));
	        panel.add(cb);
	        panel.add(lbl_dk);
	        panel.add(txt_modkTB);

	        JPanel buttonPanel = new JPanel();
	        buttonPanel.add(btn_xoa);

	        addDeviceFrame.getContentPane().setLayout(new BorderLayout());
	        addDeviceFrame.getContentPane().add(panel, BorderLayout.CENTER);
	        addDeviceFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	        btn_xoa.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(cb.getSelectedItem().equals("TenTB")) {
						String fileName=cb.getSelectedItem().toString();
						String dk = txt_modkTB.getText().toLowerCase();
						bus.delThietBiByField(fileName, dk);
						reloadTable();
					}
					if(cb.getSelectedItem().equals("MoTaTB")) {
						String fileName=cb.getSelectedItem().toString();
						String dk = txt_modkTB.getText();
						bus.delThietBiByField(fileName, dk);
						reloadTable();
					}
				}
			});
	        // Thiết lập kích thước và hiển thị cửa sổ form thêm thiết bị
	        addDeviceFrame.setSize(700, 500);
	        addDeviceFrame.setVisible(true);
	    }
	 private void chooseExcelFile() throws FileNotFoundException, IOException {
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setDialogTitle("Chọn Tệp Excel"); // Thiết lập tiêu đề của hộp thoại
	        // Chỉ hiển thị các tệp có định dạng Excel
	        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files", "xls", "xlsx"));

	        // Hiển thị hộp thoại chọn tệp và xử lý khi người dùng chọn một tệp

	        int result = fileChooser.showOpenDialog(this.getContentPane());
	        if (result == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            String excelFilePath = selectedFile.getAbsolutePath();
	            // Gọi phương thức để xử lý tệp Excel đã chọn
	            processExcelFile(excelFilePath);
	        }
	    }
	 private void processExcelFile(String excelFilePath) throws FileNotFoundException, IOException {
	        // Xử lý tệp Excel đã chọn ở đây
	    	ArrayList<ThietBi> listTBNew = bus.ExcelReader(excelFilePath);
	    	for(ThietBi lst : listTBNew) {
				String tenTB = lst.getTenTB();
				String motaTB = lst.getMoTa();
				ThietBi tb = new ThietBi(tenTB,motaTB);
				bus.addThietBi(tb);
	    	}
	    	reloadTable();
	    }
}
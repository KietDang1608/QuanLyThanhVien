package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JCalendar;

import BUS.ThanhVienBUS;
import BUS.XuLyBUS;
import DTO.ThanhVien;
import DTO.XuLy;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JRadioButton;

public class XuLyGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txMaXL;
	private JTextField txMaTV;
	private JTextField txSoTien;
	private JTextField txHinhThucXL;
	private JTextField txTenTV;
	private JTextField txNgayXL;
	private JTable table;
	private JRadioButton rdbY, rdbN;
	private JComboBox  cbHinhThucXL;
	private JLabel lb_Error;

	/**
	 * Launch the application.
	 */
	XuLyBUS bus = new XuLyBUS();
	ThanhVienBUS tvBus = new ThanhVienBUS();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XuLyGUI frame = new XuLyGUI();
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
	public XuLyGUI() {
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

		JLabel LabelHead = new JLabel("XỬ LÝ");
		LabelHead.setForeground(new Color(255, 255, 255));
		LabelHead.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LabelHead.setBounds(462, 11, 219, 53);
		panelTop.add(LabelHead);

		JLabel lbMaXL = new JLabel("Mã Xử Lý");
		lbMaXL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbMaXL.setBounds(29, 83, 82, 40);
		contentPane.add(lbMaXL);

		JLabel lblMaTV = new JLabel("Mã TV");
		lblMaTV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaTV.setBounds(29, 134, 82, 40);
		contentPane.add(lblMaTV);

		JLabel lbSoTien = new JLabel("Số Tiền");
		lbSoTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbSoTien.setBounds(29, 185, 82, 40);
		contentPane.add(lbSoTien);

		JLabel lbHinhThucXL = new JLabel("Hình Thức XL");
		lbHinhThucXL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbHinhThucXL.setBounds(284, 83, 100, 40);
		contentPane.add(lbHinhThucXL);

		JLabel lbTenTV = new JLabel("Tên TV");
		lbTenTV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbTenTV.setBounds(284, 134, 100, 40);
		contentPane.add(lbTenTV);

		JLabel lbNgayXL = new JLabel("Ngày Xử Lý");
		lbNgayXL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbNgayXL.setBounds(284, 185, 100, 40);
		contentPane.add(lbNgayXL);
		
		lb_Error = new JLabel("");
		lb_Error.setForeground(new Color(204, 0, 0));
		lb_Error.setBounds(113, 172, 214, 11);
		contentPane.add(lb_Error);

		txMaXL = new JTextField();
		txMaXL.setBounds(113, 83, 130, 40);
		contentPane.add(txMaXL);
		txMaXL.setColumns(10);
		txMaXL.setEditable(false);

		txMaTV = new JTextField();
		txMaTV.setColumns(10);
		txMaTV.setBounds(113, 134, 130, 40);
		contentPane.add(txMaTV);
		txMaTV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
		        try{
	            String s = txMaTV.getText();
	            if(!s.isEmpty() && s.matches("\\d+" )){
	                int id = Integer.parseInt(s);
	                ThanhVien tv = new ThanhVienBUS().getThanhVienByID(id);
	                    if(tv== null){
	                        lb_Error.setText("Không tìm thấy thành viên !!");
	
	                        txTenTV.setText("");
	                        return;
	                    }else{
	                        txTenTV.setText(tv.getHoTen());
	                        lb_Error.setText("");
	                    }
	            }
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
			}
		});
		txMaTV.getDocument().addDocumentListener(new DocumentListener() {
                    
                
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
//				for(ThanhVien tx : tvBus.getData()) {
//					if(Integer.parseInt(txMaTV.getText())==(tx.getMaTV())) {
//						txTenTV.setText(tx.getHoTen());
//					}
//				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				for(ThanhVien tx : tvBus.getData()) {
					if(Integer.parseInt(txMaTV.getText())==(tx.getMaTV())) {
						txTenTV.setText(tx.getHoTen());
					}
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
//				System.out.print(txMaTV.getText());
//				// TODO Auto-generated method stub
				for(ThanhVien tx : tvBus.getData()) {
					if(Integer.parseInt(txMaTV.getText())==(tx.getMaTV())) {
						txTenTV.setText(tx.getHoTen());
					}
				}
			}
		});

		txSoTien = new JTextField();
		txSoTien.setColumns(10);
		txSoTien.setBounds(113, 185, 130, 40);
		contentPane.add(txSoTien);

		cbHinhThucXL = new JComboBox();
		cbHinhThucXL.setBounds(394, 83, 210, 40);
		contentPane.add(cbHinhThucXL);
                cbHinhThucXL.addItem("Mời chọn hình thức XL");
		cbHinhThucXL.addItem("Bồi thường");
		cbHinhThucXL.addItem("Khóa thẻ 1 tháng");
                cbHinhThucXL.addItem("Khóa thẻ 2 tháng");
                cbHinhThucXL.addItem("Khóa thẻ vĩnh viễn");
                cbHinhThucXL.addItem("Khóa thẻ 1 tháng và bồi thường");

		cbHinhThucXL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbHinhThucXL.getSelectedItem().equals("Bồi thường") || cbHinhThucXL.getSelectedItem().equals("Khóa thẻ 1 tháng và bồi thường")) {
					txSoTien.setEditable(true);
				}
				else {
					txSoTien.setEditable(false);
                                        txSoTien.setEnabled(true);
                                        txSoTien.setText("");
				}
			}
		});


		txTenTV = new JTextField();
		txTenTV.setColumns(10);
		txTenTV.setBounds(394, 136, 210, 40);
		contentPane.add(txTenTV);
		txTenTV.setEditable(false);

		txNgayXL = new JTextField();
		txNgayXL.setColumns(10);
		txNgayXL.setBounds(394, 185, 210, 40);
		contentPane.add(txNgayXL);
		txNgayXL.setEditable(false);

		JLabel lbTrangThaiXL = new JLabel("Trạng Thái XL");
		lbTrangThaiXL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbTrangThaiXL.setBounds(642, 83, 109, 40);
		contentPane.add(lbTrangThaiXL);

		rdbY = new JRadioButton("Đã Xử Lý");
		rdbY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbY.setBounds(767, 79, 109, 44);
		contentPane.add(rdbY);

		rdbN = new JRadioButton("Chưa Xử lý");
		rdbN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbN.setBounds(895, 79, 109, 44);
		contentPane.add(rdbN);

		rdbN.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbY);
		group.add(rdbN);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBackground(new Color(128, 128, 128));
		btnClear.setBounds(614, 185, 89, 40);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearInput();
			}
		});

		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(732, 185, 89, 40);
		contentPane.add(btnThem);
		btnThem.addActionListener(new ActionListener() {

			@Override
                        public void actionPerformed(ActionEvent e) {
                            // TODO Auto-generated method stub
                            XuLy xl = new XuLy();
                            LocalDate date = LocalDate.now();
                            xl.setMaXL(bus.getData().size()+1);
                            xl.setMaTV(Integer.parseInt(txMaTV.getText()));
                            xl.setHinhThucXL(cbHinhThucXL.getSelectedItem().toString());
                            xl.setNgayXL(date.toString());
                            
                            if(txTenTV.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thành viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                            // Kiểm tra nếu combobox cbHinhThucXL đang chọn item "Mời chọn hình thức XL"
                            if(cbHinhThucXL.getSelectedItem().equals("Mời chọn hình thức XL")) {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn hình thức xử lý!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            // Kiểm tra hình thức xử lý là "Phạt tiền"
                            if(cbHinhThucXL.getSelectedItem().equals("Phạt tiền")) {
                                try {
                                    int soTien = Integer.parseInt(txSoTien.getText());
                                    if(soTien <= 0) {
                                        JOptionPane.showMessageDialog(null, "Số tiền phạt không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                    xl.setSoTien(soTien);
                                } catch(NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Số tiền phạt không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            } else {
                                xl.setSoTien(0);
                            }

                            // Kiểm tra trạng thái xử lý
                            if(rdbY.isSelected()) {
                                JOptionPane.showMessageDialog(null, "Lỗi vi phạm mới phải ở trạng thái CHƯA ĐƯỢC XỬ LÝ!!!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                return;
                            } else {
                                xl.setTrangThaiXL(1);
                            }

                            // Thêm xu ly vào cơ sở dữ liệu
                            boolean success = bus.addXuLy(xl);
                            if(success) {
                                JOptionPane.showMessageDialog(null, "Dữ liệu đã được thêm thành công");
                            } else {
                                JOptionPane.showMessageDialog(null, "Dữ liệu không được thêm");
                            }
                            loadData();
                            clearInput();
                        }


		});

		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(223, 223, 0));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(847, 185, 89, 40);
		contentPane.add(btnSua);
		btnSua.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
                            if(table.getSelectedRow() == -1){
                                JOptionPane.showMessageDialog(null, "Mời chọn xử lý cần sửa");
                            }
				// TODO Auto-generated method stub
				XuLy xl = new XuLy();
				LocalDate date = LocalDate.now();
				xl.setMaXL(Integer.parseInt(txMaXL.getText()));
				xl.setMaTV(Integer.parseInt(txMaTV.getText()));
                                txMaTV.setEditable(false);
                                
                                 // Kiểm tra xem combobox đã được chọn chưa trước khi gán giá trị
                                if (txMaTV.getText() != null) {
                                    xl.setMaTV(Integer.parseInt(txMaTV.getText()));
                                    txMaTV.setEditable(false);
                                }
				xl.setHinhThucXL((String) cbHinhThucXL.getSelectedItem());
                                
                                cbHinhThucXL.setEditable(false);

				xl.setSoTien(Integer.parseInt(txSoTien.getText()));
//				xl.setNgayXL((table.getValueAt(table.getSelectedRow(), 5).toString()));
				if(rdbY.isSelected()) {
					xl.setTrangThaiXL(0);
					xl.setNgayXL(date.toString());
				}
				else {
					xl.setTrangThaiXL(1);
					xl.setNgayXL(null);
				}
                                System.out.println(xl);
				boolean success=bus.updateXuLy(xl.getMaXL(),xl);
				if(success) {
					JOptionPane.showMessageDialog(null, "Dữ liệu đã được sửa thành công");
                                        clearInput();
                                } else {
					JOptionPane.showMessageDialog(null, "Dữ liệu không được sửa");
				}
				
				loadData();
                                clearInput();
			}
		});

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(204, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(960, 185, 89, 40);
		contentPane.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {

			@Override
                        
                        
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                                if(table.getSelectedRow() == -1){
                                JOptionPane.showMessageDialog(null, "Mời chọn xử lý cần xóa");
                            }
				XuLy xl = new XuLy();
				xl.setMaXL(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
				boolean success=bus.delXuLy(xl.getMaXL());
				if(success) {
					JOptionPane.showMessageDialog(null, "Dữ liệu đã được xóa thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Dữ liệu không được xóa");
				}
				loadData();
                                clearInput();
			}
		});

		table = new JTable();
		table.setBounds(0, 256, 1076, 370);//1238 449
		table.setRowHeight(30);
		table.setAutoscrolls(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setData();
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 256, 1076, 370);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Thêm JScrollPane vào frame
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// Tạo thanh cuộn bên phải
		JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		scrollBar.setBounds(0, 0, contentPane.getWidth(), 17);
		contentPane.add(scrollBar, BorderLayout.EAST);

		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// Cập nhật vị trí của jtable
				table.scrollRectToVisible(new Rectangle(0, e.getValue(), table.getWidth(), table.getHeight()));
			}
		});





		loadData();
	}
	public void loadData() {
            
            ArrayList <XuLy> xl = (ArrayList<XuLy>) bus.getData();
            int idNew = xl.get(xl.size() -1).getMaXL();
            txMaXL.setText(String.valueOf(idNew +1));
            txMaXL.setEditable(false);
            
            
		DefaultTableModel nModel = new DefaultTableModel();
		nModel.addColumn("MaXL");
		nModel.addColumn("HinhThucXL");
		nModel.addColumn("MaTV");
		nModel.addColumn("TenTV");
		nModel.addColumn("SoTien");
		nModel.addColumn("NgayXL");
		nModel.addColumn("TrangThai");
		table.setModel(nModel);


		for(XuLy xuly : bus.getData() )
		{
			Vector data = new Vector();
			data.add(xuly.getMaXL());
			data.add(xuly.getHinhThucXL());
			data.add(xuly.getMaTV());
			data.add(tvBus.getNameByID(xuly.getMaTV()));
			data.add(xuly.getSoTien());
			data.add(xuly.getNgayXL());
			data.add(xuly.getTrangThaiXL());
			nModel.addRow(data);
		}

		table.setModel(nModel);
	}
	private void setData() {
		int row = table.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		txMaXL.setText(model.getValueAt(row, 0).toString());
		cbHinhThucXL.setSelectedItem(model.getValueAt(row, 1));
//                cbHinhThucXL.setEditable(false);
		txMaTV.setText(model.getValueAt(row, 2).toString());
//                cbMaTV.setEditable(false);
		txTenTV.setText(model.getValueAt(row, 3).toString());
		txSoTien.setText(model.getValueAt(row, 4).toString());
		if(!Objects.isNull(model.getValueAt(row, 5))){
                        
			txNgayXL.setText(model.getValueAt(row, 5).toString());

		}
		else {
			txNgayXL.setText("");
		}
		if(Integer.parseInt(model.getValueAt(row, 6).toString()) == 0) {
                   
			rdbY.setSelected(true);
//			txSoTien.setEditable(false);
		}
		else {
			rdbN.setSelected(true);
//			txSoTien.setEditable(true);
		}

	}
        
        

        public void clearInput(){
//            txMaXL.setText("");
            txMaTV.setText("");
            txTenTV.setText("");
            cbHinhThucXL.setSelectedItem("Mời chọn hình thức XL");
            txSoTien.setText("");
            rdbN.setSelected(true);
            txNgayXL.setText("");
        }
             
}
// ĐÂY LÀ CODE MỚI
        
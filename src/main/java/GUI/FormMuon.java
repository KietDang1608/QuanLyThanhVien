package GUI;

import BUS.ThanhVienBUS;
import BUS.ThietBiBUS;
import BUS.ThongTinSDBUS;
import BUS.XuLyBUS;
import DTO.ThongTinSD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormMuon extends JFrame {
    private JTextField txtMaTV;
    private JTextField txtMaTB;
    private JPanel contentPane;
    public FormMuon(){
        setBounds(500,100,350,200);
        contentPane = new JPanel();
        contentPane.setLayout(null);

        setContentPane(contentPane);

        JLabel lb1  = new JLabel("Nhập mã thành viên: ");
        JLabel lb2 = new JLabel("Nhập mã thiết bị cần mượn: ");

        txtMaTB = new JTextField();
        txtMaTV = new JTextField();

        JButton btnMuon = new JButton("Xác nhận mượn");

        contentPane.add(lb1);
        contentPane.add(lb2);
        contentPane.add(txtMaTB);
        contentPane.add(txtMaTV);
        contentPane.add(btnMuon);
        lb1.setBounds(10,10,200,30);
        lb2.setBounds(10,50,200,30);
        btnMuon.setBounds(10,100,300,30);
        txtMaTV.setBounds(220,10,100,30);
        txtMaTB.setBounds(220,50,100,30);

        btnMuon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkMuon();
            }
        });
    }
    private void showMessage(String thongbao){
        JOptionPane.showMessageDialog(null,thongbao);
    }

    private void checkMuon(){
        ThanhVienBUS tvBUS = new ThanhVienBUS();
        XuLyBUS xlbus = new XuLyBUS();
        ThietBiBUS thietBiBUS = new ThietBiBUS();
        ThongTinSDBUS thongTinSDBUS = new ThongTinSDBUS();
        if (txtMaTV.getText().isEmpty()){
            showMessage("Vui lòng nhập mã thành viên!");
            return;
        }
        else if (!tvBUS.checkThanhVien(Integer.parseInt(txtMaTV.getText()))){
            showMessage("Không phải thành viên!");
            return;
        }
        else if (xlbus.checkTVViPham(Integer.parseInt(txtMaTV.getText()))){
            showMessage("Thành viên đang vi phạm!");
            return;
        }

        if (txtMaTB.getText().isEmpty()){
            showMessage("Vui lòng nhập mã thiết bị!");
            return;
        }
        else if(!thietBiBUS.checkThietBi(Integer.parseInt(txtMaTB.getText()))){
            showMessage("Không tồn tại thiết bị này");
            return;
        }
        else if (!thongTinSDBUS.checkDangMuon(Integer.parseInt(txtMaTB.getText()))){
            showMessage("Thiết bị đang được mượn");
            return;
        }

        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng theo yyyy-mm-dd hh:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Áp dụng định dạng cho ngày và giờ hiện tại
        String formattedDateTime = currentDateTime.format(formatter);
        ThongTinSD tt = new ThongTinSD(Integer.valueOf(txtMaTV.getText()),Integer.valueOf(txtMaTB.getText()),null,formattedDateTime,null,null);
        thongTinSDBUS.addData(tt);
        showMessage("Cho mượn thành công!");
        txtMaTB.setText("");
        txtMaTV.setText("");

    }
}

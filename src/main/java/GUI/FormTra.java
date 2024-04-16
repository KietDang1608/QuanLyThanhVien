package GUI;

import BUS.ThietBiBUS;
import BUS.ThongTinSDBUS;
import DTO.ThongTinSD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormTra extends JFrame {
    private JTextField txtMaTB;
    private JPanel contentPane;
    public FormTra(){
        setBounds(500,100,350,200);
        contentPane = new JPanel();
        contentPane.setLayout(null);

        setContentPane(contentPane);

        JLabel lb2 = new JLabel("Nhập mã thiết bị cần trả: ");

        txtMaTB = new JTextField();

        JButton btnTra = new JButton("Xác nhận trả");

        contentPane.add(lb2);
        contentPane.add(txtMaTB);
        contentPane.add(btnTra);
        lb2.setBounds(10,50,200,30);
        btnTra.setBounds(10,100,300,30);
        txtMaTB.setBounds(220,50,100,30);
        btnTra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkTra();
            }
        });
    }
    private void showMessage(String thongbao){
        JOptionPane.showMessageDialog(null,thongbao);
    }
    private void checkTra(){
        ThongTinSDBUS thongTinSDBUS = new ThongTinSDBUS();
        ThietBiBUS thietBiBUS = new ThietBiBUS();
        if (txtMaTB.getText().isEmpty()){
            showMessage("Vui lòng nhập mã thiết bị!");
            return;
        }
        else if(!thietBiBUS.checkThietBi(Integer.parseInt(txtMaTB.getText()))){
            showMessage("Không tồn tại thiết bị này");
            return;
        }
        else if (thongTinSDBUS.checkDangMuon(Integer.parseInt(txtMaTB.getText()))){
            showMessage("Không phải thiết bị đang được mượn");
            return;
        }

        ThongTinSD tt = thongTinSDBUS.getTTChuaMuonByMaTB(Integer.parseInt(txtMaTB.getText()));
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng theo yyyy-mm-dd hh:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Áp dụng định dạng cho ngày và giờ hiện tại
        String formattedDateTime = currentDateTime.format(formatter);
        tt.setTgTra(formattedDateTime);
        System.out.println(tt.toString());
        thongTinSDBUS.updateData(tt);
        showMessage("Trả thành công!");

        txtMaTB.setText("");
    }

}

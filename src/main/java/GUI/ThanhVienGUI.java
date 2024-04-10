package GUI;

import BUS.ThanhVienBUS;
import BUS.ThongTinSDBUS;
import BUS.XuLyBUS;
import DTO.ThanhVien;
import DTO.ThongTinSD;
import DTO.XuLy;
import java.awt.Color;
import java.awt.Component;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;

public class ThanhVienGUI extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private final ArrayList<ThanhVien> selected;

    ThanhVienBUS tvBus = new ThanhVienBUS();
    ThongTinSDBUS ttBus = new ThongTinSDBUS();
    XuLyBUS xlBus = new XuLyBUS();

    DefaultTableModel model = new DefaultTableModel();

    //Constructor
    public ThanhVienGUI() {
        this.selected = new ArrayList();

        initComponents();
        setBounds(192, 46, 1092, 665);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        panelTop.setLayout(null);
        LabelHead.setBounds(462, 11, 219, 53);
        tableDisplay();

        filterCB.addItem("Được đánh dấu");
        filterCB.addItem("Mã Thành Viên");
        filterCB.addItem("Họ Tên");
        filterCB.addItem("Khoa");
        filterCB.addItem("Ngành");
        filterCB.addItem("Số điện thoại");
        filterCB.addItem("Email");
        filterCB.addItem("Đang bị xử lý");
        this.setVisible(true);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    //Table display is an exception for not using [Add element to model] since it loads the whole array at one time
    public void tableDisplay() {
        ThanhVienBUS.listTV = tvBus.getData();
        model.setRowCount(0);

        if (!ThanhVienBUS.listTV.isEmpty()) {
            model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Họ và tên");
            model.addColumn("Khoa");
            model.addColumn("Ngành");
            model.addColumn("SĐT");
            model.addColumn("Email");
            model.addColumn("Password");
            model.addColumn("Tình trạng");

            int i = 0;
            for (; i < ThanhVienBUS.listTV.size(); i++) {
                Vector vt = new Vector();
                ThanhVien temp = ThanhVienBUS.listTV.get(i);
                vt.add(temp.getMaTV());
                vt.add(temp.getHoTen());
                vt.add(temp.getKhoa());
                vt.add(temp.getNganh());
                vt.add(temp.getSdt());
                vt.add(temp.getEmail());
                vt.add(temp.getPassword());
                if (checkViPham(temp.getMaTV())) {
                    vt.add("Đang bị xử lý");
                } else {
                    vt.add("");
                }

                model.addRow(vt);
            }
            memberTbl.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "Something went wrong...");
        }
    }

    public boolean checkViPham(int id) {
        for (XuLy e : xlBus.getData()) {
            if (e.getMaTV() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMarked(int id) {
        if (selected.isEmpty()) {
            return false;
        }
        for (ThanhVien tv : selected) {
            if (tv.getMaTV() == id) {
                return true;
            }
        }
        return false;
    }

    public ArrayList getListMaXL(int id) {
        ArrayList<Integer> list = new ArrayList<>();
        for (XuLy xl : xlBus.getData()) {
            if (xl.getMaTV() == id) {
                list.add(xl.getMaXL());
            }
        }
        return list;
    }

    public ArrayList getListObjTT(int id) {
        ArrayList<ThongTinSD> list = new ArrayList<>();
        for (ThongTinSD tt : ttBus.getListThongTinSD()) {
            if (tt.getMaTV() == id) {
                list.add(tt);
            }
        }
        return list;
    }

    public boolean deleteMember(int idMember) {
        //Delete a member including delete them in ThanhVien, ThongTinSD and XuLy table
        if (!tvBus.delThanhVien(idMember)) {
            return false;
        }

        ArrayList<Integer> xuLy = getListMaXL(idMember);
        if (!xuLy.isEmpty()) {
            for (int idXL : xuLy) {
                if (!xlBus.delXuLy(idXL)) {
                    return false;
                }
            }
        }

        //potentially error since ttBus.deleteData does not return function status
        ArrayList<ThongTinSD> ttSD = getListObjTT(idMember);
        if (!ttSD.isEmpty()) {
            for (ThongTinSD tt : ttSD) {
                ttBus.deleleData(tt);
            }
        }

        return true;
    }

    public boolean checkOverlapID(int id) {
        for (ThanhVien tv : tvBus.getData()) {
            if (tv.getMaTV() == id) {
                return true;
            }
        }
        return false;
    }

    public int getNewId() {
        int id = tvBus.getData().get(0).getMaTV();
        while (checkOverlapID(id)) {
            id++;
        }
        return id;
    }

    public boolean checkForBlank() {
        return txName.getText().isBlank()
                || txKhoa.getText().isBlank()
                || txNganh.getText().isBlank()
                || txSDT.getText().isBlank()
                || txEmail.getText().isBlank()
                || txPsw.getText().isBlank();
    }

    //This function is only used to add more element to a given model, it does not check for repeatition inside
    public void addElementToModel(ThanhVien tv, DefaultTableModel tempModel) {
        Vector line = new Vector();
        line.add(tv.getMaTV());
        line.add(tv.getHoTen());
        line.add(tv.getKhoa());
        line.add(tv.getNganh());
        line.add(tv.getSdt());
        line.add(tv.getEmail());
        line.add(tv.getPassword());
        if (checkViPham(tv.getMaTV())) {
            line.add("Đang bị xử lý");
        } else {
            line.add("");
        }
        tempModel.addRow(line);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        contentPane = new javax.swing.JPanel();
        panelTop = new javax.swing.JPanel();
        LabelHead = new javax.swing.JLabel();

        mainFunctionPane = new javax.swing.JPanel();
        txSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        filterCB = new javax.swing.JComboBox<>();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        infoPane = new javax.swing.JPanel();
        txId = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        tenLabel = new javax.swing.JLabel();
        txName = new javax.swing.JTextField();
        khoaLabel = new javax.swing.JLabel();
        nganhLabel = new javax.swing.JLabel();
        SDTlabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        txSDT = new javax.swing.JTextField();
        txEmail = new javax.swing.JTextField();
        txKhoa = new javax.swing.JTextField();
        txNganh = new javax.swing.JTextField();
        clearSelectedBtn = new javax.swing.JButton();
        SDTlabel1 = new javax.swing.JLabel();
        txPsw = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTbl = new javax.swing.JTable();
        markingBtn = new javax.swing.JButton();
        reloadBtn = new javax.swing.JButton();
        exBtn = new javax.swing.JButton();
        readExBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1092, 665));
        setResizable(false);

        contentPane.setBackground(new java.awt.Color(255, 255, 255));
        contentPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setMaximumSize(new java.awt.Dimension(1092, 665));
        contentPane.setMinimumSize(new java.awt.Dimension(1092, 665));
        contentPane.setPreferredSize(new java.awt.Dimension(1092, 665));

        panelTop.setBackground(new java.awt.Color(168, 205, 159));
        panelTop.setMaximumSize(new java.awt.Dimension(1072, 72));
        panelTop.setMinimumSize(new java.awt.Dimension(1072, 72));
        panelTop.setPreferredSize(new java.awt.Dimension(1072, 72));

        LabelHead.setBackground(new java.awt.Color(255, 255, 255));
        LabelHead.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelHead.setForeground(new java.awt.Color(255, 255, 255));
        LabelHead.setText("THÀNH VIÊN");
        LabelHead.setMaximumSize(new java.awt.Dimension(219, 53));
        LabelHead.setMinimumSize(new java.awt.Dimension(219, 53));
        LabelHead.setPreferredSize(new java.awt.Dimension(219, 53));

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addComponent(LabelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopLayout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(LabelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainFunctionPane.setBackground(new java.awt.Color(255, 255, 255));
        mainFunctionPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 1, true));
        mainFunctionPane.setMaximumSize(new java.awt.Dimension(1082, 50));
        mainFunctionPane.setMinimumSize(new java.awt.Dimension(1082, 50));
        mainFunctionPane.setPreferredSize(new java.awt.Dimension(1072, 50));

        txSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 1, true));
        txSearch.setPreferredSize(new java.awt.Dimension(500, 20));
        txSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearchActionPerformed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(168, 205, 159));
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Tìm kiếm");
        searchBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 205, 159)));
        searchBtn.setFocusable(false);
        searchBtn.setMaximumSize(new java.awt.Dimension(100, 20));
        searchBtn.setMinimumSize(new java.awt.Dimension(100, 20));
        searchBtn.setPreferredSize(new java.awt.Dimension(100, 20));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        filterCB.setForeground(new java.awt.Color(102, 102, 102));
        filterCB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 1, true));
        filterCB.setFocusable(false);
        filterCB.setLightWeightPopupEnabled(false);
        filterCB.setMaximumSize(new java.awt.Dimension(75, 20));
        filterCB.setMinimumSize(new java.awt.Dimension(75, 20));
        filterCB.setPreferredSize(new java.awt.Dimension(75, 20));
        filterCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainFunctionPaneLayout = new javax.swing.GroupLayout(mainFunctionPane);
        mainFunctionPane.setLayout(mainFunctionPaneLayout);
        mainFunctionPaneLayout.setHorizontalGroup(
            mainFunctionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFunctionPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        mainFunctionPaneLayout.setVerticalGroup(
            mainFunctionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFunctionPaneLayout.createSequentialGroup()
                .addGroup(mainFunctionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFunctionPaneLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(mainFunctionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(txSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mainFunctionPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        deleteBtn.setBackground(new java.awt.Color(168, 205, 159));
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("XÓA");
        deleteBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 3, true));
        deleteBtn.setFocusable(false);
        deleteBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(168, 205, 159));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("SỬA");
        editBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 3, true));
        editBtn.setFocusable(false);
        editBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(168, 205, 159));
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("THÊM");
        addBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 3, true));
        addBtn.setFocusable(false);
        addBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        infoPane.setBackground(new java.awt.Color(255, 255, 255));
        infoPane.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        infoPane.setMaximumSize(new java.awt.Dimension(1082, 100));
        infoPane.setMinimumSize(new java.awt.Dimension(1082, 100));
        infoPane.setPreferredSize(new java.awt.Dimension(1082, 100));

        txId.setEnabled(false);
        txId.setMaximumSize(new java.awt.Dimension(125, 25));
        txId.setMinimumSize(new java.awt.Dimension(125, 25));
        txId.setPreferredSize(new java.awt.Dimension(125, 25));
        txId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIdActionPerformed(evt);
            }
        });

        idLabel.setForeground(new java.awt.Color(102, 102, 102));
        idLabel.setText("- Mã thành viên:");

        tenLabel.setForeground(new java.awt.Color(102, 102, 102));
        tenLabel.setText("- Họ và tên:");

        txName.setPreferredSize(new java.awt.Dimension(125, 25));

        khoaLabel.setForeground(new java.awt.Color(102, 102, 102));
        khoaLabel.setText("- Khoa:");

        nganhLabel.setForeground(new java.awt.Color(102, 102, 102));
        nganhLabel.setText("- Ngành:");

        SDTlabel.setForeground(new java.awt.Color(102, 102, 102));
        SDTlabel.setText("- Số điện thoại:");

        emailLabel.setForeground(new java.awt.Color(102, 102, 102));
        emailLabel.setText("- Email:");

        txSDT.setMaximumSize(new java.awt.Dimension(125, 25));
        txSDT.setMinimumSize(new java.awt.Dimension(125, 25));
        txSDT.setPreferredSize(new java.awt.Dimension(125, 25));
        txSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSDTActionPerformed(evt);
            }
        });

        txEmail.setMaximumSize(new java.awt.Dimension(125, 25));
        txEmail.setMinimumSize(new java.awt.Dimension(125, 25));
        txEmail.setPreferredSize(new java.awt.Dimension(125, 25));
        txEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailActionPerformed(evt);
            }
        });

        txKhoa.setMaximumSize(new java.awt.Dimension(125, 25));
        txKhoa.setMinimumSize(new java.awt.Dimension(125, 25));
        txKhoa.setPreferredSize(new java.awt.Dimension(125, 25));
        txKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKhoaActionPerformed(evt);
            }
        });

        txNganh.setMaximumSize(new java.awt.Dimension(125, 25));
        txNganh.setMinimumSize(new java.awt.Dimension(125, 25));
        txNganh.setPreferredSize(new java.awt.Dimension(125, 25));
        txNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNganhActionPerformed(evt);
            }
        });

        clearSelectedBtn.setText("Hủy danh sách đã chọn");
        clearSelectedBtn.setFocusable(false);
        clearSelectedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSelectedBtnActionPerformed(evt);
            }
        });

        SDTlabel1.setForeground(new java.awt.Color(102, 102, 102));
        SDTlabel1.setText("- Password:");

        txPsw.setMaximumSize(new java.awt.Dimension(125, 25));
        txPsw.setMinimumSize(new java.awt.Dimension(125, 25));
        txPsw.setPreferredSize(new java.awt.Dimension(125, 25));
        txPsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPswActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPaneLayout = new javax.swing.GroupLayout(infoPane);
        infoPane.setLayout(infoPaneLayout);
        infoPaneLayout.setHorizontalGroup(
            infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addComponent(tenLabel))
                .addGap(18, 18, 18)
                .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(khoaLabel)
                    .addComponent(nganhLabel))
                .addGap(18, 18, 18)
                .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txNganh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPaneLayout.createSequentialGroup()
                        .addComponent(SDTlabel)
                        .addGap(18, 18, 18)
                        .addComponent(txSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(infoPaneLayout.createSequentialGroup()
                        .addComponent(emailLabel)
                        .addGap(58, 58, 58)
                        .addComponent(txEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(infoPaneLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(clearSelectedBtn))
                    .addGroup(infoPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SDTlabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txPsw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        infoPaneLayout.setVerticalGroup(
            infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoPaneLayout.createSequentialGroup()
                        .addComponent(txKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPaneLayout.createSequentialGroup()
                        .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SDTlabel1)
                                .addComponent(txPsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idLabel)
                                .addComponent(khoaLabel)
                                .addComponent(SDTlabel)
                                .addComponent(txSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenLabel)
                            .addComponent(nganhLabel)
                            .addComponent(emailLabel)
                            .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearSelectedBtn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thông tin chi tiết");

        memberTbl.setForeground(new java.awt.Color(102, 102, 102));
        memberTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        memberTbl.setGridColor(new java.awt.Color(168, 205, 159));
        memberTbl.setMaximumSize(new java.awt.Dimension(1067, 360));
        memberTbl.setMinimumSize(new java.awt.Dimension(1067, 360));
        memberTbl.setPreferredSize(new java.awt.Dimension(1067, 360));
        memberTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        memberTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        memberTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memberTbl);

        markingBtn.setForeground(new java.awt.Color(102, 102, 102));
        markingBtn.setText("ĐÁNH DẤU");
        markingBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 1, true));
        markingBtn.setFocusable(false);
        markingBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        markingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markingBtnActionPerformed(evt);
            }
        });

        reloadBtn.setBackground(new java.awt.Color(168, 205, 159));
        reloadBtn.setForeground(new java.awt.Color(255, 255, 255));
        reloadBtn.setText("RELOAD");
        reloadBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 3, true));
        reloadBtn.setFocusable(false);
        reloadBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        reloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadBtnActionPerformed(evt);
            }
        });

        exBtn.setBackground(new java.awt.Color(168, 205, 159));
        exBtn.setForeground(new java.awt.Color(255, 255, 255));
        exBtn.setText("Xuất excel");
        exBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 3, true));
        exBtn.setFocusable(false);
        exBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        exBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exBtnActionPerformed(evt);
            }
        });

        readExBtn.setBackground(new java.awt.Color(168, 205, 159));
        readExBtn.setForeground(new java.awt.Color(255, 255, 255));
        readExBtn.setText("Đọc excel");
        readExBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 3, true));
        readExBtn.setFocusable(false);
        readExBtn.setPreferredSize(new java.awt.Dimension(90, 30));
        readExBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readExBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, Short.MAX_VALUE)
                    .addComponent(mainFunctionPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(readExBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(exBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(reloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(markingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(infoPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainFunctionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(markingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(readExBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPane, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Xác nhận thao tác?");
        if (option == JOptionPane.NO_OPTION) {
            return;
        }

        String SUCCESS_NOTIF = "Dữ liệu đã được cập nhật.";
        String FAILED_NOTIF = "Xuất hiện lỗi trong quá trình thực hiện, vui lòng kiếm tra lại";

        //Xử lý xóa đơn đối tượng
        if (selected.isEmpty()) {
            int index = memberTbl.getSelectedRow();
            int index_id = Integer.parseInt(memberTbl.getValueAt(index, 0).toString());

            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một đối tượng để tiến hành thao tác.");
                return;
            }

            if (checkViPham(index_id)) {
                int option2 = JOptionPane.showConfirmDialog(this, "Thành viên này đang bị xử lý vi phạm, bạn có chắc muốn tiếp tục?");
                if (option2 == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            if (deleteMember(index_id)) {
                JOptionPane.showMessageDialog(this, SUCCESS_NOTIF);
            } else {
                JOptionPane.showMessageDialog(this, FAILED_NOTIF);
            }
        } else //Xử lý xóa theo danh sách
        {
            //Kiểm tra danh sách có tồn tại thành viên đang bị xử lý vi phạm hay không
            for (ThanhVien tv : selected) {
                if (checkViPham(tv.getMaTV())) {
                    int option2 = JOptionPane.showConfirmDialog(this, "Trong danh sách đã chọn có thành viên đang bị xử lý vi phạm, bạn có chắc muốn tiếp tục?");
                    if (option2 == JOptionPane.NO_OPTION) {
                        return;
                    }
                    break;
                }
            }

            //Tiến hành xóa theo danh sách
            int index_id;
            boolean success = true;
            for (ThanhVien tv2 : selected) {
                index_id = tv2.getMaTV();
                if (!deleteMember(index_id)) {
                    success = false;
                    break;
                }
            }
            if (!success) {
                JOptionPane.showMessageDialog(this, FAILED_NOTIF);
            } else {
                JOptionPane.showMessageDialog(this, SUCCESS_NOTIF);
                selected.clear();
            }

            tableDisplay();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void txIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIdActionPerformed

    private void filterCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCBActionPerformed

    }//GEN-LAST:event_filterCBActionPerformed

    private void txSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSDTActionPerformed

    private void txEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailActionPerformed

    private void memberTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberTblMouseClicked
        int index = memberTbl.getSelectedRow();
        txId.setText(model.getValueAt(index, 0).toString());
        txName.setText(model.getValueAt(index, 1).toString());
        txKhoa.setText(model.getValueAt(index, 2).toString());
        txNganh.setText(model.getValueAt(index, 3).toString());
        txSDT.setText(model.getValueAt(index, 4).toString());
        txEmail.setText((model.getValueAt(index, 5) == null) ? "" : model.getValueAt(index, 5).toString());
        txPsw.setText(model.getValueAt(index, 6).toString());
    }//GEN-LAST:event_memberTblMouseClicked

    private void txKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txKhoaActionPerformed

    private void txNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNganhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNganhActionPerformed

    private void markingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markingBtnActionPerformed
        DefaultTableModel tempModel = (DefaultTableModel) memberTbl.getModel();
        int index = memberTbl.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một đối tượng để tiến hành thực hiện thao tác.");
            return;
        }

        int indexID = Integer.parseInt(tempModel.getValueAt(index, 0).toString());
        if (!checkMarked(indexID)) {
            ThanhVien e = new ThanhVien();
            e.setMaTV(indexID);
            e.setHoTen(model.getValueAt(index, 1).toString());
            e.setKhoa(model.getValueAt(index, 2).toString());
            e.setNganh(model.getValueAt(index, 3).toString());
            e.setSdt(model.getValueAt(index, 4).toString());
            e.setEmail((model.getValueAt(index, 5) == null) ? "" : model.getValueAt(index, 1).toString());
            selected.add(e);
        } else {
            for (ThanhVien tv : selected) {
                if (tv.getMaTV() == indexID) {
                    selected.remove(tv);
                    break;
                }
            }
        }

        //Reload Colored
        memberTbl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int maTV = Integer.parseInt(model.getValueAt(row, 0).toString());
                Color clr = new Color(168, 205, 159);
                for (ThanhVien temp : selected) {
                    if (temp.getMaTV() == maTV) {
                        c.setBackground(clr);
                        return c;
                    }
                }
                c.setBackground(table.getBackground()); // Set the background color to default
                return c;
            }
        });

        memberTbl.repaint();
        JOptionPane.showMessageDialog(this, "Selected: " + selected.size());
    }//GEN-LAST:event_markingBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int selectedIndex = memberTbl.getSelectedRow();

// Kiểm tra xem có hàng nào được chọn không
        if (selectedIndex != -1) {
            // Lấy dữ liệu từ các JTextField
            String hoTen = txName.getText();
            String khoa = txKhoa.getText();
            String nganh = txNganh.getText();
            String sdt = txSDT.getText();
            String password = txPsw.getText();
            String email = txEmail.getText();

            // Lấy mã thành viên từ bảng
            //DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int maTV = (int) model.getValueAt(selectedIndex, 0); // Chỉ số 0 là cột chứa mã thành viên

            // Gọi phương thức updateThanhVien của BUS và truyền các thông tin cần thiết
            boolean success = tvBus.updateThanhVien(maTV, hoTen, khoa, nganh, sdt, password, email);

            if (success) {
                // Cập nhật dữ liệu trong bảng nếu cập nhật trong cơ sở dữ liệu thành công
                model.setValueAt(hoTen, selectedIndex, 1); // Cột 1 là cột chứa họ tên
                model.setValueAt(khoa, selectedIndex, 2); // Cột 2 là cột chứa khoa
                model.setValueAt(nganh, selectedIndex, 3); // Cột 3 là cột chứa ngành
                model.setValueAt(sdt, selectedIndex, 4); // Cột 4 là cột chứa số điện thoại
                model.setValueAt(password, selectedIndex, 5); // Cột 4 là cột chứa số điện thoại
                model.setValueAt(email, selectedIndex, 6); // Cột 4 là cột chứa số điện thoại

                JOptionPane.showMessageDialog(this, "Đã cập nhật thành viên thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thành viên không thành công. Vui lòng thử lại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để sửa!");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void txSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearchActionPerformed
        //Not used
    }//GEN-LAST:event_txSearchActionPerformed

    private void clearSelectedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSelectedBtnActionPerformed
        if (selected.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Thử thêm đối tượng vào danh sách trước đã...");
            return;
        }
        int option = JOptionPane.showConfirmDialog(this, "Xác nhận xóa danh sách đã đánh dấu?");
        if (option == JOptionPane.YES_OPTION) {
            selected.clear();
            memberTbl.setDefaultRenderer(Object.class, memberTbl.getDefaultRenderer(Object.class));
            memberTbl.repaint();
            JOptionPane.showMessageDialog(this, "Danh sách đã được làm trống.");
        }
    }//GEN-LAST:event_clearSelectedBtnActionPerformed

    private void reloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadBtnActionPerformed
        tableDisplay();
        txId.setText("");
        txName.setText("");
        txKhoa.setText("");
        txNganh.setText("");
        txKhoa.setText("");
        txSDT.setText("");
        txEmail.setText("");
        txPsw.setText("");
    }//GEN-LAST:event_reloadBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String searchLog;
        if (txSearch.getText().trim().isEmpty()) {
            if (!filterCB.getSelectedItem().toString().equals("Được đánh dấu") && !filterCB.getSelectedItem().toString().equals("Đang bị xử lý")) {
                JOptionPane.showMessageDialog(this, "Thử gõ gì đó vào thanh tìm kiếm trước đã...");
                return;
            }
            searchLog = "";
        } else {
            searchLog = txSearch.getText();
        }
        model.setRowCount(0);
        memberTbl.setModel(model);

        boolean found = false;
        String notif = "Không tìm thấy đối tượng có chứa '" + searchLog + "' trong ";

        switch (filterCB.getSelectedItem().toString()) {
            case "Mã Thành Viên": {
                notif += "[mã thành viên]";
                for (ThanhVien tv : ThanhVienBUS.listTV) {
                    if (String.valueOf(tv.getMaTV()).contains(searchLog)) {
                        addElementToModel(tv, model);
                        if (!found) {
                            found = true;
                        }
                    }
                }
                break;
            }
            case "Họ Tên": {
                notif += "[Họ tên]";
                for (ThanhVien tv : ThanhVienBUS.listTV) {
                    if (tv.getHoTen().contains(searchLog)) {
                        addElementToModel(tv, model);
                        if (!found) {
                            found = true;
                        }
                    }
                }
                break;
            }
            case "Khoa": {
                notif += "[Khoa]";
                for (ThanhVien tv : ThanhVienBUS.listTV) {
                    if (tv.getKhoa().contains(searchLog)) {
                        addElementToModel(tv, model);
                        if (!found) {
                            found = true;
                        }
                    }
                }
                break;
            }
            case "Ngành": {
                notif += "[Ngành]";
                for (ThanhVien tv : ThanhVienBUS.listTV) {
                    if (tv.getNganh().contains(searchLog)) {
                        addElementToModel(tv, model);
                        if (!found) {
                            found = true;
                        }
                    }
                }
                break;
            }
            case "Số điện thoại": {
                notif += "[Số điện thoại]";
                for (ThanhVien tv : ThanhVienBUS.listTV) {
                    if (tv.getSdt().contains(searchLog)) {
                        addElementToModel(tv, model);
                        if (!found) {
                            found = true;
                        }
                    }
                }
                break;
            }
            case "Email": {
                notif += "[Email]";
                for (ThanhVien tv : ThanhVienBUS.listTV) {
                    if (tv.getEmail().contains(searchLog)) {
                        addElementToModel(tv, model);
                        if (!found) {
                            found = true;
                        }
                    }
                }
                break;
            }

            case "Đang bị xử lý": {
                txSearch.setText("");
                for (ThanhVien tv : ThanhVienBUS.listTV) {
                    if (checkViPham(tv.getMaTV())) {
                        addElementToModel(tv, model);
                        if (!found) {
                            found = true;
                        }
                    }
                }
                if (!found) {
                    notif = "Hiện không có tài khoản nào đang bị xử lý.";
                }
                break;
            }
            case "Được đánh dấu": {
                txSearch.setText("");
                if (selected.isEmpty()) {
                    notif = "Hiện chưa có đối tượng nào được chọn, thử [Đánh dấu] vài đối tượng trước khi thực hiện thao tác.";
                } else {
                    for (ThanhVien tv : selected) {
                        addElementToModel(tv, model);
                        if (!found) {
                            found = true;
                        }
                    }
                }
                break;
            }
            default:
                tableDisplay();
        }
        if (!found) {
            JOptionPane.showMessageDialog(this, notif);
            tableDisplay();
        } else
            memberTbl.setModel(model);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        addThanhVien add = new addThanhVien();
        
        int size = tvBus.getData().size();

        add.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                if (tvBus.getData().size() != size) {
                    tableDisplay();
                }
            }
        });
        add.setVisible(true);
        add.setLocationRelativeTo(null);
    }//GEN-LAST:event_addBtnActionPerformed

    private void txPswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPswActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPswActionPerformed

    private void exBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exBtnActionPerformed
        ArrayList<ThanhVien> listTV = tvBus.getData();

        // Chọn đường dẫn và tên file Excel
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/netBeans/QuanLyThanhVien"));
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String excelFilePath = fileToSave.getAbsolutePath() + ".xls";

            try {
                tvBus.writeExcel(listTV, excelFilePath);
                JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xuất file Excel: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_exBtnActionPerformed

    private void readExBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readExBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/netBeans/QuanLyThanhVien"));
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String excelFilePath = selectedFile.getAbsolutePath();

            try {
                // Lấy danh sách thành viên hiện tại
                ArrayList<ThanhVien> listTVExisting = tvBus.getData();

                // Đọc dữ liệu từ tệp Excel và thêm các bản ghi mới vào
                ArrayList<ThanhVien> listTVNew = tvBus.ExcelReader(excelFilePath);

                // Cập nhật dữ liệu vào model của bảng
                for (ThanhVien tv : listTVNew) {
                    boolean exists = false;
                    for (ThanhVien existingTV : listTVExisting) {
                        if (existingTV.getMaTV() == tv.getMaTV()) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        Vector<Object> row = new Vector<>();
                        row.add(tv.getMaTV());
                        row.add(tv.getHoTen());
                        row.add(tv.getKhoa());
                        row.add(tv.getNganh());
                        row.add(tv.getSdt());
                        row.add(tv.getEmail());
                        row.add(tv.getPassword());
                        model.addRow(row);
                    }
                }
                memberTbl.setModel(model);

                JOptionPane.showMessageDialog(this, "Đọc dữ liệu từ tệp Excel thành công!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi đọc tệp Excel: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_readExBtnActionPerformed

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                ThanhVienGUI frame = new ThanhVienGUI();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelHead;
    private javax.swing.JLabel SDTlabel;
    private javax.swing.JLabel SDTlabel1;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearSelectedBtn;
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton exBtn;
    private javax.swing.JComboBox<String> filterCB;
    private javax.swing.JLabel idLabel;
    private javax.swing.JPanel infoPane;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel khoaLabel;
    private javax.swing.JPanel mainFunctionPane;
    private javax.swing.JButton markingBtn;
    private javax.swing.JTable memberTbl;
    private javax.swing.JLabel nganhLabel;
    private javax.swing.JPanel panelTop;
    private javax.swing.JButton readExBtn;
    private javax.swing.JButton reloadBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel tenLabel;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txKhoa;
    private javax.swing.JTextField txName;
    private javax.swing.JTextField txNganh;
    private javax.swing.JTextField txPsw;
    private javax.swing.JTextField txSDT;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}

//Display member list
//Search members (idk how to use copilot's recommended method)
//Marking members into list
//Show chosen member's detailed info
//Edit member (Unverified)
//Clear section/reload
//Delete member as singular - as list

package GUI;

import java.awt.EventQueue;

public class ThanhVienGUI extends javax.swing.JFrame {
    
     private static final long serialVersionUID = 1L;
            
    public ThanhVienGUI() {
        initComponents();
        setBounds(192, 46, 1092, 665);

        setContentPane(contentPane);
        contentPane.setLayout(null);
        panelTop.setLayout(null);
		
        LabelHead.setBounds(462, 11, 219, 53);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(665, 1092));
        setPreferredSize(new java.awt.Dimension(1092, 665));
        setResizable(false);

        contentPane.setBackground(new java.awt.Color(255, 255, 255));
        contentPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setPreferredSize(new java.awt.Dimension(1092, 72));

        panelTop.setBackground(new java.awt.Color(168, 205, 159));
        panelTop.setMaximumSize(new java.awt.Dimension(1082, 72));
        panelTop.setPreferredSize(new java.awt.Dimension(1082, 72));

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

        txSearch.setBackground(new java.awt.Color(255, 255, 255));
        txSearch.setText("jTextField1");
        txSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 1, true));

        searchBtn.setBackground(new java.awt.Color(168, 205, 159));
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Tìm kiếm");
        searchBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 205, 159)));

        filterCB.setBackground(new java.awt.Color(255, 255, 255));
        filterCB.setForeground(new java.awt.Color(102, 102, 102));
        filterCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bộ lọc" }));
        filterCB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 1, true));
        filterCB.setLightWeightPopupEnabled(false);
        filterCB.setMaximumSize(new java.awt.Dimension(75, 22));
        filterCB.setMinimumSize(new java.awt.Dimension(75, 22));
        filterCB.setPreferredSize(new java.awt.Dimension(75, 22));

        javax.swing.GroupLayout mainFunctionPaneLayout = new javax.swing.GroupLayout(mainFunctionPane);
        mainFunctionPane.setLayout(mainFunctionPaneLayout);
        mainFunctionPaneLayout.setHorizontalGroup(
            mainFunctionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFunctionPaneLayout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(searchBtn)
                .addGap(18, 18, 18)
                .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        mainFunctionPaneLayout.setVerticalGroup(
            mainFunctionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFunctionPaneLayout.createSequentialGroup()
                .addGroup(mainFunctionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFunctionPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn))
                    .addGroup(mainFunctionPaneLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(mainFunctionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(txSearch))))
                .addContainerGap())
        );

        deleteBtn.setBackground(new java.awt.Color(168, 205, 159));
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("XÓA");
        deleteBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 3, true));
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
        editBtn.setPreferredSize(new java.awt.Dimension(90, 30));

        addBtn.setBackground(new java.awt.Color(168, 205, 159));
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("THÊM");
        addBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 205, 159), 3, true));
        addBtn.setPreferredSize(new java.awt.Dimension(90, 30));

        infoPane.setBackground(new java.awt.Color(255, 255, 255));
        infoPane.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        infoPane.setMaximumSize(new java.awt.Dimension(1082, 100));
        infoPane.setMinimumSize(new java.awt.Dimension(1082, 100));

        javax.swing.GroupLayout infoPaneLayout = new javax.swing.GroupLayout(infoPane);
        infoPane.setLayout(infoPaneLayout);
        infoPaneLayout.setHorizontalGroup(
            infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        infoPaneLayout.setVerticalGroup(
            infoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Thông tin chi tiết");

        memberTbl.setBackground(new java.awt.Color(255, 255, 255));
        memberTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        memberTbl.setGridColor(new java.awt.Color(168, 205, 159));
        jScrollPane1.setViewportView(memberTbl);

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainFunctionPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(infoPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
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
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         
    

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                ThanhVienGUI frame = new ThanhVienGUI();
                frame.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel LabelHead;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JComboBox<String> filterCB;
    private javax.swing.JPanel infoPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainFunctionPane;
    private javax.swing.JTable memberTbl;
    private javax.swing.JPanel panelTop;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField txSearch;
    // End of variables declaration                   
}

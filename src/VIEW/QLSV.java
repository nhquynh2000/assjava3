package VIEW;

import MODEL.ShareHelper;
import MODEL.sinhvien;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLSV extends javax.swing.JFrame {

    protected ArrayList<sinhvien> listSinhVien;
    protected String user, password;

    public QLSV(String urname) {
        initComponents();
        setLocationRelativeTo(null);
        this.listSinhVien = new ArrayList<>();
        this.user = "sa";
        this.password = "12345";
        this.listSinhVien = this.fetchList();
        renderTable(listSinhVien);
    }

    public void renderTable(ArrayList<sinhvien> data) {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < data.size(); i++) {
            sinhvien sv = data.get(i);
            model.addRow(new Object[]{
                sv.getMasv(),
                sv.getHoten(),
                sv.getEmail(),
                sv.getSđt(),
                sv.getGioitinh(),
                sv.getDiachi(),
                sv.getHinh()
            });
        }
    }

    protected ArrayList<sinhvien> fetchList() {
        ArrayList<sinhvien> data = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV31";
            Connection con = DriverManager.getConnection(url, user, password);
            String query1 = "select*from STUDENTS";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            while (rs.next()) {
                String masv = rs.getString("MASV");
                String hoten = rs.getString("Hoten");
                String email = rs.getString("Email");
                String sdt = rs.getString("SoDT");
                String giotinh = rs.getString("gioitinh");
                String diachi = rs.getString("Diachi");
                String hinh = rs.getString("Hinh");
                data.add(new sinhvien(masv, hoten, email, sdt, diachi, giotinh, hinh));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "khong tim thay CSDL",
                    "Co loi xay ra", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        txtmasv = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdiachi = new javax.swing.JTextArea();
        rdoNu = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblanh = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản lý sinh viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("MASV:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Họ Tên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("SĐT:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Giới Tính:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Địa Chỉ:");

        txthoten.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtmasv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtsdt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtdiachi.setColumns(20);
        txtdiachi.setRows(5);
        jScrollPane1.setViewportView(txtdiachi);

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdoNu.setText("Nữ");

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdoNam.setText("Name");

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save.png"))); // NOI18N
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit.png"))); // NOI18N
        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete.png"))); // NOI18N
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MASV", "Họ Tên", "Email", "SĐT", "Giới Tính", "Địa chỉ", "Hình"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        lblanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblanhMouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jButton2.setText("THoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(182, 182, 182))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(txthoten)
                        .addComponent(txtmail, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(txtmasv, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNu)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton5)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 55, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        txtmasv.setText(table.getValueAt(row, 0).toString());
        txtmasv.setEditable(false);
        txthoten.setText(table.getValueAt(row, 1).toString());
        txtmail.setText(table.getValueAt(row, 2).toString());
        txtsdt.setText(table.getValueAt(row, 3).toString());
        if (table.getValueAt(row, 4).toString().equalsIgnoreCase("Nữ")) {
            rdoNu.setSelected(true);
        } else if (table.getValueAt(row, 4).toString().equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        }
        txtdiachi.setText(table.getValueAt(row, 5).toString());
        lblanh.setToolTipText((String) table.getValueAt(row, 6));
        if ((String) table.getValueAt(row, 6) != null) {
            lblanh.setIcon(ShareHelper.readLogo((String) table.getValueAt(row, 6)));
        }
        table.setRowSelectionInterval(row, row);
    }//GEN-LAST:event_tableMouseClicked

    private void lblanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblanhMouseClicked
        JFileChooser chon = new JFileChooser();
        int chonanh = chon.showOpenDialog(this);
        if (chonanh == JFileChooser.APPROVE_OPTION) {
            File file = chon.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                lblanh.setIcon(ShareHelper.readLogo(file.getName()));
                lblanh.setToolTipText(file.getName());
            }
        }
    }//GEN-LAST:event_lblanhMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtmasv.setText(null);
        txtmasv.setEditable(true);
        txthoten.setText(null);
        txtmail.setText(null);
        txtsdt.setText(null);
        buttonGroup1.clearSelection();
        txtdiachi.setText(null);
        lblanh.setIcon(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String masv = this.txtmasv.getText();//lay gt
        String hoten = this.txthoten.getText();
        String email = this.txtmail.getText();
        String sđt = this.txtsdt.getText();
        String diachi = this.txtdiachi.getText();
        String hinh = this.lblanh.getToolTipText();
        if (masv.length() == 0
                || hoten.length() == 0
                || email.length() == 0
                || sđt.length() == 0
                || diachi.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        try {
            if (rdoNam.isSelected() == false && rdoNu.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn giới tính");
                return;
            }
            if (lblanh.getIcon() == null) {
                JOptionPane.showMessageDialog(this, "Bạn chưa cập nhập ảnh");
                return;
            }
            if (!txtmail.getText().matches("^[\\w-]+@([\\w- ]+\\.)+[\\w-]+$")) {
                JOptionPane.showMessageDialog(this, "Emil chưa đúng định dạng");
                return;
            }
            if (!txtsdt.getText().matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "sđt chưa đúng định dạng");
                return;
            }
            for (sinhvien e : listSinhVien) {
                if (txtmasv.getText().equals(e.getMasv())) {
                    JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại ");
                    txtmasv.requestFocus();
                    return;
                }
            };
        } catch (Exception e) {
            e.printStackTrace();

            return;
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//load drive
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV31";
            Connection con = DriverManager.getConnection(url, this.user, this.password);
            String query = "insert into STUDENTS (MASV,Hoten,Email ,SoDT ,gioitinh ,Diachi ,Hinh ) OUTPUT INSERTED.MASV values(?,?,?,?,?,?,?)";//tao cau lenh truy van output inserted.id
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, masv);//gan
            ps.setString(2, hoten);
            ps.setString(3, email);
            ps.setString(4, sđt);
            if (rdoNam.isSelected()) {
                ps.setString(5, "Nam");
            } else {
                ps.setString(5, "Nữ");
            }
            ps.setString(6, diachi);
            ps.setString(7, hinh);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Lưu thành công");
            ResultSet rs = ps.getResultSet();
            rs.next();
            this.listSinhVien.add(new sinhvien(masv, hoten, email, sđt, diachi, hinh, hinh));
            this.renderTable(this.listSinhVien);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        try {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//load drive
                String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV31";
                Connection con = DriverManager.getConnection(url, this.user, this.password);
                PreparedStatement conv = con.prepareStatement("Delete Grade  Where MASV=?");
                
                conv.setString(1, txtmasv.getText());
                conv.executeLargeUpdate();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//load drive
                String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV31";
                Connection con = DriverManager.getConnection(url, this.user, this.password);
                PreparedStatement conv = con.prepareStatement("Delete STUDENTS  Where MASV=?");
                conv.setString(1, txtmasv.getText());
                conv.executeUpdate();
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Delete thành công");
            this.listSinhVien = this.fetchList();
            this.renderTable(this.listSinhVien);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String masv = this.txtmasv.getText();//lay gt
        String hoten = this.txthoten.getText();
        String email = this.txtmail.getText();
        String sđt = this.txtsdt.getText();
        String diachi = this.txtdiachi.getText();
        String hinh = this.lblanh.getToolTipText();
        if (masv.length() == 0
                || hoten.length() == 0
                || email.length() == 0
                || sđt.length() == 0
                || diachi.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        try {
            if (rdoNam.isSelected() == false && rdoNu.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn giới tính");
                return;
            }
            if (lblanh.getIcon() == null) {
                JOptionPane.showMessageDialog(this, "Bạn chưa cập nhập ảnh");
                return;
            }
            if (!txtmail.getText().matches("^[\\w-]+@([\\w- ]+\\.)+[\\w-]+$")) {
                JOptionPane.showMessageDialog(this, "Emil chưa đúng định dạng");
                return;
            }
            if (!txtsdt.getText().matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "sđt chưa đúng định dạng");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//load drive
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV31";
            Connection con = DriverManager.getConnection(url, this.user, this.password);
            String query = "update  STUDENTS set Hoten=?,Email=? ,SoDT=? ,gioitinh=? ,Diachi=? ,Hinh=?  where MASV=?";//tao cau lenh truy van output inserted.id
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(7, masv);//gan
            ps.setString(1, hoten);
            ps.setString(2, email);
            ps.setString(3, sđt);
            if (rdoNam.isSelected()) {
                ps.setString(4, "Nam");
            } else {
                ps.setString(4, "Nữ");
            }
            ps.setString(5, diachi);
            ps.setString(6, lblanh.getToolTipText());
            ps.execute();
            JOptionPane.showMessageDialog(this, "sửa thành công");
            this.listSinhVien = this.fetchList();
            this.renderTable(this.listSinhVien);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, "Bạn có muốn thoát k ");
        this.dispose();
        new Dangnhap().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSV("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblanh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtdiachi;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}

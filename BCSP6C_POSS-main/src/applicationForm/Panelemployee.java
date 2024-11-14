package applicationForm;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import connect_database.MysqlConnect;
import includeClass.Validation;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Panelemployee extends javax.swing.JPanel {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Panelemployee() {
        initComponents();
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ຄົ້ນຫາ");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("image/search1.svg"));
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "example@gmail.com");
        txtTelephone.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "021 123xxxxx");
        

        //ປ່ຽນສີພື້ນຫົວຕາຕະລາງ
        JTableHeader header = jTable1.getTableHeader();
        header.setFont(new Font("Lao_SomVang", Font.PLAIN, 14));
        header.setOpaque(false);
        header.setBackground(new Color(108, 117, 125));
        header.setForeground(new Color(243, 243, 243));

        //ສະແດງຜົນຢູ່ກາງຖັນ
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        
        //ສະແດງຜົນຢູ່ດ້ານຂວາຂອງຖັນ
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

        //ເສັ້ນຕາຕະລາງ
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setGridColor(new Color(139, 138, 137));

        //ເຊື່ອມຕໍ່ ຖານຂໍ້ມູນ
        conn = MysqlConnect.connectDB();
        tableUpdate();
        autoID();

        //ໃຫ້ປຸ່ມແກ້ໄຂ ແລະ ລືບກົດບໍ່ໄດ້
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

    }

    //ສ້າງເມັດເຈັນເຍີເລດ ລະະຫັດ
    private void autoID() {
        try {
            String sql = "SELECT max(sup_id) FROM supplier";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1).substring(4, 6));
                id++;
                txtSup_id.setText("SUP" + String.format("%03d", id));
            } else {
                txtSup_id.setText("SUP001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //ຂຽນເມັດທອດສະແດງຄ່າໃນຕາຕະລາງ
    private void tableUpdate() {
        try {
            String sql = "SELECT *FROM supplier ORDER BY sup_id DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            jTable1.setRowHeight(30);
            d.setRowCount(0);
            while (rs.next()) {
                d.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //ລືບຂໍ້ມູນໃນຟອມ
    private void clearForm() {
        autoID();
        txtSup_name.setText("");
        txtContract_name.setText("");
        txtEmail.setText("");
        txtTelephone.setText("");
        
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        jTable1.clearSelection();
    }

    private boolean checkInput(){
        return txtSup_name.getText().isEmpty()
        || txtContract_name.getText().isEmpty()
        || txtEmail.getText().isEmpty()
        || txtTelephone.getText().isEmpty();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSup_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSup_id = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtContract_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ລະຫັດຜູ້ສະໜອງ", "ຊື່ບໍລິສັດຜູ້ສະໜອງ", "ຜູ້ປະສານງານ", "ອີເມວ", "ເບີໂທລະສັບ", "ທີ່ຢູ່"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(150);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(2).setMinWidth(250);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(3).setMinWidth(250);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(4).setMinWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        txtSearch.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ຈັດການຂໍ້ມູນຜູ້ສະໜອງ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao_SomVang", 0, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel2.setText("ຊື່ບໍລິສັດຜູ້ສະໜອງ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txtSup_name.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtSup_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 310, -1));

        jLabel3.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel3.setText("ລະຫັດຜູ້ສະໜອງ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 40, 80, -1));

        txtSup_id.setEditable(false);
        txtSup_id.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtSup_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 310, -1));

        btnCancel.setBackground(new java.awt.Color(21, 115, 71));
        btnCancel.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(253, 254, 254));
        btnCancel.setText("ຍົກເລີກ");
        btnCancel.setMargin(new java.awt.Insets(2, 3, 3, 3));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 70, -1));

        btnAdd.setBackground(new java.awt.Color(11, 94, 215));
        btnAdd.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(251, 238, 230));
        btnAdd.setText("ເພີ່ມ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 70, -1));

        btnEdit.setBackground(new java.awt.Color(255, 201, 12));
        btnEdit.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(28, 31, 35));
        btnEdit.setText("ແກ້ໄຂ");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 70, -1));

        btnDelete.setBackground(new java.awt.Color(187, 45, 59));
        btnDelete.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(253, 254, 254));
        btnDelete.setText("ລືບ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 70, -1));

        jLabel4.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel4.setText("ຜູ້ປະສານງານ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        txtContract_name.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtContract_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 310, -1));

        jLabel5.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel5.setText("ອີເມວ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        txtEmail.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 310, -1));

        jLabel6.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel6.setText("ທີ່ຢູ່");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

        txtTelephone.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 310, -1));

        jLabel7.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel7.setText("ເບີໂທລະສັບ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(checkInput()){
            JOptionPane.showMessageDialog(this,"pleace put your full data","ຫວ່າງເປົາ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(Validation.emailValidation(txtEmail.getText())){
            JOptionPane.showMessageDialog(this,"pleace put your email correctly","ຜຶດພາດ",JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            txtEmail.setSelectionStart(0);
            txtEmail.setSelectionEnd(txtEmail.getText().length());
            return;
        }
        if(Validation.telephoneValidation(txtTelephone.getText())){
            JOptionPane.showMessageDialog(this,"pleace put your phone number correctly","ຜຶດພາດ",JOptionPane.ERROR_MESSAGE);
            txtTelephone.requestFocus();
            txtTelephone.setSelectionStart(0);
            txtTelephone.setSelectionEnd(txtTelephone.getText().length());
            return;
        }
         try {
            String sql = "INSERT INTO supplier VALUES(?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtSup_id.getText());
            pst.setString(2, txtSup_name.getText());
            pst.setString(3, txtContract_name.getText());
            pst.setString(4, txtEmail.getText());
            pst.setString(5, txtTelephone.getText());
            
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "ຂໍ້ມູນຖືກບັນທຶກລົງໃນຖານຂໍ້ມູນສໍາເລັດ", "ສໍາເລັດ", JOptionPane.WIDTH,
                        new FlatSVGIcon("image_svg/check.svg"));
                clearForm();
                tableUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        //ຖ້າກົດເມົ້າໃສ່ບໍ່ຖືກແຖວ
        if (selectIndex == -1) {
            return;
        }

        txtSup_id.setText(d.getValueAt(selectIndex, 0).toString());
        txtSup_name.setText(d.getValueAt(selectIndex, 1).toString());
        txtContract_name.setText(d.getValueAt(selectIndex, 2).toString());
        txtEmail.setText(d.getValueAt(selectIndex, 3).toString());
        txtTelephone.setText(d.getValueAt(selectIndex, 4).toString());
        

        //ໃຫ້ປຸ່ມເພີ່ມໃຊ້ງານບໍ່ໄດ້
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       if(checkInput()){
            JOptionPane.showMessageDialog(this,"pleace put your full data","ຫວ່າງເປົາ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(Validation.emailValidation(txtEmail.getText())){
            JOptionPane.showMessageDialog(this,"pleace put your email correctly","ຜຶດພາດ",JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            txtEmail.setSelectionStart(0);
            txtEmail.setSelectionEnd(txtEmail.getText().length());
            return;
        }
        if(Validation.telephoneValidation(txtTelephone.getText())){
            JOptionPane.showMessageDialog(this,"pleace put your phone number correctly","ຜຶດພາດ",JOptionPane.ERROR_MESSAGE);
            txtTelephone.requestFocus();
            txtTelephone.setSelectionStart(0);
            txtTelephone.setSelectionEnd(txtTelephone.getText().length());
            return;  
        }
         try {
            String sql = "UPDATE supplier set sup_name=?,contract_name=?,email=?,telephone=?,address=?"
                    + " WHERE sup_id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(6, txtSup_id.getText());
            pst.setString(1, txtSup_name.getText());
            pst.setString(2, txtContract_name.getText());
            pst.setString(3, txtEmail.getText());
            pst.setString(4, txtTelephone.getText());
            
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "ຂໍ້ມູນຖືກແກ້ໄຂລົງໃນຖານຂໍ້ມູນສໍາເລັດ", "ສໍາເລັດ", JOptionPane.WIDTH,
                        new FlatSVGIcon("image_svg/check.svg"));
                clearForm();
                tableUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       int data;
        data = JOptionPane.showConfirmDialog(null, "ທ່ານຕ້ອງການລົບຂໍ້ມູນນີ້ແທ້ ຫຼື ບໍ່?","ຢືນຢັັນ",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(data != 0){
            clearForm();
            return;
        }
        try{
            String sql = "DELETE FROM supplier WHERE sup_id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtSup_id.getText());
            pst.executeUpdate();
            clearForm();
            tableUpdate();
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtContract_name;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSup_id;
    private javax.swing.JTextField txtSup_name;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}

package applicationForm;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import connect_database.MysqlConnect;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PanelCategory extends javax.swing.JPanel {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public PanelCategory() {
        initComponents();
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ຄົ້ນຫາ");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("image/search1.svg"));

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

        //ເສັ້ນຕາຕະລາງ
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setGridColor(new Color(139, 138, 137));

        conn = MysqlConnect.connectDB();
        tableUpdate();
        autoID();
        clearForm();
        
       
    }
    
    //ສ້າງເມັດເຈັນເຍີເລດ ລະະຫັດ
    private void autoID() {
        try {
            String sql = "SELECT max(category_id) FROM category";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                int id = Integer.parseInt(rs.getString(1).substring(1, 4));
                id++;
                txtCategory_id.setText("C" + String.format("%03d", id));
            } else {
                txtCategory_id.setText("C001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //ຂຽນເມັດທອດສະແດງຄ່າໃນຕາຕະລາງ
    private void tableUpdate() {
        try {
            String sql = "SELECT *FROM category ORDER BY category_id DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            jTable1.setRowHeight(30);
            d.setRowCount(0);
            int num_row = 0;
            while (rs.next()) {
                Vector v = new Vector();
                v.add(++num_row);
                v.add(rs.getString(1));
                v.add(rs.getString(2));

                d.addRow(v);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void clearForm(){
        autoID();
        txtCategory_name.setText("");
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        jTable1.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCategory_id = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCategory_name = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();

        jTable1.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ລຳດັບ", "ລະຫັດ", "ປະເພດສິນຄ້າ"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(100);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(1).setMinWidth(150);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ຈັດການຂໍ້ມູນປະເພດ\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao_SomVang", 0, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel1.setText("ລະຫັດ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txtCategory_id.setEditable(false);
        txtCategory_id.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtCategory_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 370, 30));

        btnCancel.setBackground(new java.awt.Color(0, 153, 0));
        btnCancel.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("ຍົກເລິກ");
        btnCancel.setMargin(new java.awt.Insets(2, 3, 3, 3));
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 90, 40));

        btnAdd.setBackground(new java.awt.Color(0, 153, 255));
        btnAdd.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ເພີ່ມ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, 40));

        btnEdit.setBackground(new java.awt.Color(204, 204, 0));
        btnEdit.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("ແກ້ໄຂ");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 90, 40));

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("ລຶບ");
        btnDelete.setMargin(new java.awt.Insets(2, 3, 3, 3));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 90, 40));

        jLabel2.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel2.setText("ປະເພດ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtCategory_name.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtCategory_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 370, 30));

        txtSearch.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(157, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtCategory_name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນປະເພດສິນຄ້າດ້ວຍ", "ຫວ່າງເປົ່າ", JOptionPane.WARNING_MESSAGE);
            txtCategory_name.requestFocus();
            return;
        }
        try {
            String sql = "INSERT INTO category VALUES(?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtCategory_id.getText());
            pst.setString(2, txtCategory_name.getText());
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

        txtCategory_id.setText(d.getValueAt(selectIndex, 1).toString());
        txtCategory_name.setText(d.getValueAt(selectIndex, 2).toString());

        //ໃຫ້ປຸ່ມເພີ່ມໃຊ້ງານບໍ່ໄດ້
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int data;
        data = JOptionPane.showConfirmDialog(null, "ທ່ານຕ້ອງການລົບຂໍ້ມູນນີ້ແທ້ ຫຼື ບໍ່?","ຢືນຢັັນ",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(data != 0){
            clearForm();
            return;
        }
        try{
            String sql = "DELETE FROM category WHERE category_id=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtCategory_id.getText());
            pst.executeUpdate();
            clearForm();
            tableUpdate();
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String sql = "SELECT *FROM category where concat(category_id,category_name)"
                    +"LIKE'%"+txtSearch.getText()+"%'ORDER BY category_id DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            jTable1.setRowHeight(30);
            d.setRowCount(0);
            int num_row = 0;
            while (rs.next()) {
                Vector v = new Vector();
                v.add(++num_row);
                v.add(rs.getString(1));
                v.add(rs.getString(2));

                d.addRow(v);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCategory_id;
    private javax.swing.JTextField txtCategory_name;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

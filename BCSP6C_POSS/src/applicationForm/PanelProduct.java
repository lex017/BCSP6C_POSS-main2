package applicationForm;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import connect_database.MysqlConnect;
import includeClass.BrandItem;
import includeClass.CategoryItem;
import includeClass.NumberComma;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PanelProduct extends javax.swing.JPanel {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public PanelProduct() {
        initComponents();

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ຄົ້ນຫາ");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, new FlatSVGIcon("image/search1.svg"));

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
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);

        //ສະແດງຜົນຢູ່ດ້ານຂວາຂອງຖັນ
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);

        //ເສັ້ນຕາຕະລາງ
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setGridColor(new Color(139, 138, 137));
        
         conn = MysqlConnect.connectDB();
         brand();
         category();
         tableUpdate();
         clearForm();
         checkInputs();
         
         //
         btnEdit.setEnabled(false);
         btnDelete.setEnabled(false);
    }
    
    private void brand(){
        try {
            String sql = "SELECT * FROM brand ORDER BY brand_name ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                txtBrand.addItem(new BrandItem(rs.getString(1),rs.getString(2)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void category(){
        try {
            String sql = "SELECT * FROM category ORDER BY category_name ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                txtCategory.addItem(new CategoryItem(rs.getString(1),rs.getString(2)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //ສ້າງເມັດທອດສະແດງຂໍ້ມູນໃນຕາຕະລາງ
    private void tableUpdate() {
        try {

            String sql = "SELECT p.barcode, p.product_name, p.unit,  p.quantity, p.quantity_min,  p.cost_price, p.retail_price, b.brand_name, c.category_name, p.status  "
                    + " FROM product p JOIN brand b ON p.brand_id=b.brand_id "
                    + " JOIN category c ON p.category_id=c.category_id ";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            jTable1.setRowHeight(30);
            //ລືບຂໍ້ມູນໃນຕາຕະລາງ
            d.setRowCount(0);
            DecimalFormat df = new DecimalFormat("#,##0");
            while (rs.next()) {
                d.addRow(new Object[]{
                    rs.getString("barcode"),
                    rs.getString("product_name"),
                    rs.getString("unit"),
                    df.format(rs.getInt("quantity")),
                    df.format(rs.getInt("quantity_min")),
                    df.format(rs.getDouble("cost_price")),
                    df.format(rs.getDouble("retail_price")),
                    rs.getString("brand_name"),
                    rs.getString("category_name"),
                    rs.getString("status")
                });

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //ລືບຂໍ້ມູນໃນຟອມ
    private void clearForm() {
        txtBarcode.setText("");
        txtProduct_name.setText("");
        txtUnit.setText("");
        txtQuantity.setText("");
        txtQuantity_min.setText("");
        txtCost_price.setText("");
        txtRetail_price.setText("");
        txtBrand.setSelectedIndex(0);
        txtCategory.setSelectedIndex(0);
        txtStatus.setSelectedIndex(0);

        txtBarcode.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);

        jTable1.clearSelection();
    }

    //ກວດສອບທຸກຊ່ອງຂອງຟອມໄດ້ຖືກເລືອກຫຼືບໍ່
    private boolean checkInputs() {
        return txtBarcode.getText().isEmpty() || txtProduct_name.getText().isEmpty() || txtUnit.getText().isEmpty()
                || txtQuantity.getText().isEmpty() || txtQuantity_min.getText().isEmpty()
                || txtCost_price.getText().isEmpty() || txtRetail_price.getText().isEmpty();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBarcode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProduct_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity_min = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCost_price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRetail_price = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JComboBox<>();
        txtBrand = new javax.swing.JComboBox();
        txtCategory = new javax.swing.JComboBox();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ລະຫັດສິນຄ້າ", "ລາຍການສິນຄ້າ", "ຫົວໜ່ວຍ", "ຈໍານວນ", "ຈໍານວນຕໍ່າສຸດ", "ລາຄາຕົ້ນທືນ", "ລາຄາຂາຍ", "ຍີ່ຫໍ້", "ປະເພດ", "ສະຖານະ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtSearch.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ຈັດການຂໍ້ມູນສິນຄ້າ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao_SomVang", 0, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBarcode.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 236, -1));

        jLabel1.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel1.setText("ລະຫັດສິນຄ້າ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel2.setText("ລາຍການສິນຄ້າ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        txtProduct_name.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtProduct_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 236, -1));

        jLabel3.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel3.setText("ຫົວໜ່ວຍ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        txtUnit.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 236, -1));

        jLabel4.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel4.setText("ຈໍານວນ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        txtQuantity.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 236, -1));

        jLabel5.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel5.setText("ຈໍານວນຕໍ່າສຸດ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        txtQuantity_min.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtQuantity_min.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantity_minKeyReleased(evt);
            }
        });
        jPanel1.add(txtQuantity_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 236, -1));

        jLabel6.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel6.setText("ລາຄາຕົ້ນທືນ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        txtCost_price.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtCost_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCost_priceKeyReleased(evt);
            }
        });
        jPanel1.add(txtCost_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 236, -1));

        jLabel7.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel7.setText("ລາຄາຂາຍ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        txtRetail_price.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtRetail_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRetail_priceKeyReleased(evt);
            }
        });
        jPanel1.add(txtRetail_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 236, -1));

        jLabel8.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel8.setText("ປະເພດສິນຄ້າ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel9.setText("ຍີ່ຫໍ້ສິນຄ້າ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jLabel10.setText("ສະຖານະ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        txtStatus.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ມີ", "ບໍ່ມີ" }));
        jPanel1.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 236, -1));

        txtBrand.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 236, -1));

        txtCategory.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel1.add(txtCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 236, -1));

        btnCancel.setBackground(new java.awt.Color(21, 115, 71));
        btnCancel.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("ຍົກເລີກ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 100, 30));

        btnAdd.setBackground(new java.awt.Color(11, 94, 215));
        btnAdd.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ເພີ່ມ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 100, 30));

        btnEdit.setBackground(new java.awt.Color(255, 201, 12));
        btnEdit.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnEdit.setText("ແກ້ໄຂ");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 100, 30));

        btnDelete.setBackground(new java.awt.Color(187, 45, 59));
        btnDelete.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("ລືບ");
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 100, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
       NumberComma.doubleThousandSeparator(txtQuantity);
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtQuantity_minKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantity_minKeyReleased
       NumberComma.doubleThousandSeparator(txtQuantity_min);
    }//GEN-LAST:event_txtQuantity_minKeyReleased

    private void txtCost_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCost_priceKeyReleased
        NumberComma.doubleThousandSeparator(txtCost_price);
    }//GEN-LAST:event_txtCost_priceKeyReleased

    private void txtRetail_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRetail_priceKeyReleased
        NumberComma.doubleThousandSeparator(txtRetail_price);
    }//GEN-LAST:event_txtRetail_priceKeyReleased

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(checkInputs()){
            JOptionPane.showMessageDialog(this, "pleace your id properly","",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JComboBox txtBrand;
    private javax.swing.JComboBox txtCategory;
    private javax.swing.JTextField txtCost_price;
    private javax.swing.JTextField txtProduct_name;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtQuantity_min;
    private javax.swing.JTextField txtRetail_price;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JComboBox<String> txtStatus;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables

   
}

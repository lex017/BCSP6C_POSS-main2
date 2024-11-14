package applicationForm;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Main extends javax.swing.JFrame {

    String emp_id, name, status;

    public Main() {
        initComponents();
    }

    public Main(String i, String n, String s) {
        initComponents();
        emp_id = i;
        name = n;
        status = s;
        this.setTitle(name);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../image/database.png")));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_SHOW_ICON, false);
        //ປຽນສີແຖບ Title bar ດ້ານເທິງ
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(204, 209, 209));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(23, 32, 42));
        
        if(!status.equals("Admin")){
            jMenuData.setVisible(false);
            jMenuOrder.setVisible(false);
            jMenuReport.setVisible(false);
        }
        showpanel(new PanelHome());
 
    }
    
    //convert 
    private  void showpanel (JPanel panel){
        jPanel2.removeAll();
        jPanel2.add(panel);
        jPanel2.validate();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jMenuData = new javax.swing.JMenu();
        jMenuEmployee = new javax.swing.JMenuItem();
        jMenuitemProduct = new javax.swing.JMenuItem();
        jMenuCategory = new javax.swing.JMenuItem();
        jMenuitemBrand = new javax.swing.JMenuItem();
        jMenuExchange = new javax.swing.JMenuItem();
        jMenuSuplier = new javax.swing.JMenuItem();
        jMenuOrder = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuCustomer = new javax.swing.JMenu();
        jMenuSale = new javax.swing.JMenu();
        jMenuSearch = new javax.swing.JMenu();
        jMenuReport = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuProfile = new javax.swing.JMenu();
        jMenuTheme = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuLogout = new javax.swing.JMenu();

        jMenu11.setText("File");
        jMenuBar2.add(jMenu11);

        jMenu12.setText("Edit");
        jMenuBar2.add(jMenu12);

        jMenuItem9.setText("jMenuItem9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jMenuBar1.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N

        jMenuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home_Page.png"))); // NOI18N
        jMenuHome.setText("ໜ້າລັກ");
        jMenuHome.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHomeMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuHome);

        jMenuData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_Database.png"))); // NOI18N
        jMenuData.setText("ຈັດການຂໍ້ມູນ");
        jMenuData.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuData.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuEmployee.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuEmployee.setText("ຈັດການຂໍ້ມູນພະນັກງານ");
        jMenuEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEmployeeActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuEmployee);

        jMenuitemProduct.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuitemProduct.setText("ຈັດການຂໍ້ມູນສິນຄ້າ");
        jMenuitemProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuitemProductActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuitemProduct);

        jMenuCategory.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuCategory.setText("ຈັດການຂໍ້ມູນປະເພດ");
        jMenuCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCategoryActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuCategory);

        jMenuitemBrand.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuitemBrand.setText("ຈັດການຂໍ້ມູນຍີ່ຫໍ້");
        jMenuitemBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuitemBrandActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuitemBrand);

        jMenuExchange.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuExchange.setText("ຈັດການຂໍ້ມູນອັດຕາແລກປ່ຽນ");
        jMenuExchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExchangeActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuExchange);

        jMenuSuplier.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuSuplier.setText("ຈັດການຂໍ້ມູນຜູ້ສະໜອງ");
        jMenuSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSuplierActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuSuplier);

        jMenuBar1.add(jMenuData);

        jMenuOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/order_Import.png"))); // NOI18N
        jMenuOrder.setText("ສັ່ງຊື້-ນຳເຂົ້າ");
        jMenuOrder.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuOrder.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem7.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem7.setText("ຈັດການຂໍ້ມູນສັ່ງຊື້ສິນຄ້າ");
        jMenuOrder.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem8.setText("ຈັດການຂໍ້ມູນນຳເຂົ້າສິນຄ້າ");
        jMenuOrder.add(jMenuItem8);

        jMenuBar1.add(jMenuOrder);

        jMenuCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/customer.png"))); // NOI18N
        jMenuCustomer.setText("ລູກຄ້າ");
        jMenuCustomer.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(jMenuCustomer);

        jMenuSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sale_Product.png"))); // NOI18N
        jMenuSale.setText("ຂາຍສິນຄ້າ");
        jMenuSale.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuSale.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuSale.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(jMenuSale);

        jMenuSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_Property.png"))); // NOI18N
        jMenuSearch.setText("ຄົ້ນຫາສິນຄ້າ");
        jMenuSearch.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuSearch.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(jMenuSearch);

        jMenuReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/report_Card.png"))); // NOI18N
        jMenuReport.setText("ລາຍງານ");
        jMenuReport.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuReport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuReport.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem17.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem17.setText("ລາຍງານຂໍ້ມູນສິນຄ້າໃນຮ້ານ");
        jMenuReport.add(jMenuItem17);

        jMenuItem18.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem18.setText("ລາຍງານຂໍ້ມູນສິນຄ້າໃກ້ໝົດ");
        jMenuReport.add(jMenuItem18);

        jMenuItem19.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem19.setText("ໃບບິນ");
        jMenuReport.add(jMenuItem19);

        jMenuItem20.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem20.setText("ລາຍງານຂໍ້ມູນສັ່ງຊື້ສິນຄ້າ");
        jMenuReport.add(jMenuItem20);

        jMenuItem21.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem21.setText("ລາຍງານຂໍ້ມູນນຳເຂົ້າສິນຄ້າ");
        jMenuReport.add(jMenuItem21);

        jMenuItem22.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem22.setText("ລາຍງານຂໍ້ມູນລູກຄ້າ");
        jMenuReport.add(jMenuItem22);

        jMenuItem23.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem23.setText("ລາຍງານຂໍ້ມູນພະນັກງານ");
        jMenuReport.add(jMenuItem23);

        jMenuBar1.add(jMenuReport);

        jMenuProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_login.png"))); // NOI18N
        jMenuProfile.setText("ໂປຣໄຟລ໌");
        jMenuProfile.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuProfile.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(jMenuProfile);

        jMenuTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change_Theme.png"))); // NOI18N
        jMenuTheme.setText("ພື້ນຫຼັງ");
        jMenuTheme.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuTheme.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuTheme.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem10.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem10.setText("Light");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuTheme.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem11.setText("Dark");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenuTheme.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuItem12.setText("MacOSX");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenuTheme.add(jMenuItem12);

        jMenuBar1.add(jMenuTheme);

        jMenuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shutdown.png"))); // NOI18N
        jMenuLogout.setText("ອອກລະບົບ");
        jMenuLogout.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        jMenuLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuLogout.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuLogoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuLogoutMouseClicked
       int data = JOptionPane.showConfirmDialog(rootPane, "ທ່ານຕ້ອງການອອກຈາກລະບົບແທ້ ຫຼື ບໍ່?", "ຢືນຢັນ",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(data == 0) {
            Login log = new Login();
            log.saveuserpass("", "");
            log.txtUsername.setText("");
            log.txtPassword.setText("");
            log.checkremember.setSelected(false);
            log.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jMenuLogoutMouseClicked

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(204, 209, 209));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(23, 32, 42));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(33, 47, 61));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(253, 254, 254));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(28, 40, 51));
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_FOREGROUND, new Color(253, 254, 254));
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        });
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuHomeMouseClicked
       showpanel(new PanelHome());
    }//GEN-LAST:event_jMenuHomeMouseClicked

    private void jMenuEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEmployeeActionPerformed
       showpanel(new Panelemployee());
    }//GEN-LAST:event_jMenuEmployeeActionPerformed

    private void jMenuitemProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuitemProductActionPerformed
        showpanel(new PanelProduct());
    }//GEN-LAST:event_jMenuitemProductActionPerformed

    private void jMenuCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCategoryActionPerformed
        showpanel(new PanelCategory());
    }//GEN-LAST:event_jMenuCategoryActionPerformed

    private void jMenuitemBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuitemBrandActionPerformed
        showpanel(new PanelBrand());
    }//GEN-LAST:event_jMenuitemBrandActionPerformed

    private void jMenuExchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExchangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuExchangeActionPerformed

    private void jMenuSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSuplierActionPerformed
        showpanel(new PanelSuplier());
    }//GEN-LAST:event_jMenuSuplierActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuCategory;
    private javax.swing.JMenu jMenuCustomer;
    private javax.swing.JMenu jMenuData;
    private javax.swing.JMenuItem jMenuEmployee;
    private javax.swing.JMenuItem jMenuExchange;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jMenuLogout;
    private javax.swing.JMenu jMenuOrder;
    private javax.swing.JMenu jMenuProfile;
    private javax.swing.JMenu jMenuReport;
    private javax.swing.JMenu jMenuSale;
    private javax.swing.JMenu jMenuSearch;
    private javax.swing.JMenuItem jMenuSuplier;
    private javax.swing.JMenu jMenuTheme;
    private javax.swing.JMenuItem jMenuitemBrand;
    private javax.swing.JMenuItem jMenuitemProduct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

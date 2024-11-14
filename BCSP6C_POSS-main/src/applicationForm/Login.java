package applicationForm;

import includeClass.PasswordHashing;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import connect_database.MysqlConnect;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.sql.*;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Preferences pref = Preferences.userRoot().node("RemembermeBCS6C");

    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);

        this.setTitle("ໂປແກຣມຂາຍເຄື່ອງໜ້າຮ້ານ POS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../image/database.png")));
        this.setResizable(false); //ບໍ່ໃຫ້ຂະຫຍາຍຟອມ
        //PlaceHolder
        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ບັນຊີເຂົ້າໃຊ້");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ລະຫັດຜ່ານ");

        //clear button
        txtUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtPassword.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);

        //ສະແດງລະຫັດຜ່ານ
        txtPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");

        //ໃສ່ຮູບໃນ txtUsername ແລະ txtPassword
        FlatSVGIcon icon1 = new FlatSVGIcon("image_svg/user.svg");
        FlatSVGIcon icon2 = new FlatSVGIcon("image_svg/password.svg");
        //txtUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, icon1);
        txtUsername.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, icon1);
        txtPassword.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, icon2);

        //ໃສຮູບທີ່ປຸ່ມ ເຂົ້າໃຊ້ລະບົບ ແລະ ຍົກເລີກ
        btnLogin.setIcon(new FlatSVGIcon("image_svg/login_1.svg"));
        btnCancel.setIcon(new FlatSVGIcon("image_svg/cancel.svg"));

        inti_remember();
    }

    //ຈື່ບັນຊີເຂົ້າໃຊ້ ແລະ ລະຫັດຜ່ານ
    private void inti_remember() {
        String usr = "";
        usr = pref.get("User", usr);
        txtUsername.setText(usr);

        String pss = "";
        pss = pref.get("Password", pss);
        txtPassword.setText(pss);

        if (!(usr.equals("") && pss.equals(""))) {
            checkremember.setSelected(true);
        }
    }

    public void saveuserpass(String user, String pass) {
        pref.put("User", user);
        pref.put("Password", pass);
    }

    public final void checked(boolean remember) {
        if (remember == true) {
            saveuserpass(txtUsername.getText(), txtPassword.getText());
        } else {
            saveuserpass("", "");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        checkremember = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lao_SomVang", 0, 18)); // NOI18N
        jLabel1.setText("ຟອມເຂົ້າໃຊ້ລະບົບ");

        txtUsername.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(34, 153, 84));
        btnLogin.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(253, 254, 254));
        btnLogin.setText("ເຂົ້າໃຊ້");
        btnLogin.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(243, 156, 18));
        btnCancel.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(23, 32, 42));
        btnCancel.setText("ຍົກເລີກ");
        btnCancel.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        checkremember.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        checkremember.setText("Remember Me");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(checkremember, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(37, 37, 37)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(71, 71, 71))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(172, 172, 172))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(checkremember)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (txtUsername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "ກະລຸນາປ້ອນບັນຊີເຂົ້າໃຊ້ດ້ວຍ", "ຫວ່າງເປົ່່າ", JOptionPane.WARNING_MESSAGE);
            txtUsername.requestFocus();
            return;
        } else if (txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "ກະລຸນາປ້ອນລະຫັດຜ່ານດ້ວຍ", "ຫວ່າງເປົ່່າ", JOptionPane.WARNING_MESSAGE);
            txtPassword.requestFocus();
            return;
        }

//ພີມ trycatch ແລ້ວກົດຄືບອດ tab
        try {
            conn = MysqlConnect.connectDB();
            String sql = "SELECT emp_id, CONCAT(emp_name, ' ', emp_lname) AS name, status FROM employee WHERE username=? AND password=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtUsername.getText().trim());
            pst.setString(2, PasswordHashing.doHashing(txtPassword.getText().trim()));
            rs = pst.executeQuery();
            if (rs.next()) {
                //ກວດສອບວ່າເລືອກເອົາ Remember me ຫຼື ບໍ່
                if (checkremember.isSelected()) {
                    checked(true);
                } else {
                    checked(false);
                }
                //Main m = new Main();
                Main m = new Main(rs.getString("emp_id"), rs.getString("name"), rs.getString("status"));
                m.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "ບັນຊີເຂົ້າໃຊ້ ແລະ ລະຫັດຜ່ານບໍ່ຖືກຕ້ອງ!", "ຜິດພາດ", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        btnLogin.doClick();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtUsername.setText("");
        txtPassword.setText("");
        checkremember.setSelected(false);
        saveuserpass("", "");
    }//GEN-LAST:event_btnCancelActionPerformed

    public static void main(String args[]) {

        FlatLightLaf.setup();
        UIManager.put("defaultFont", new Font("Lao_Somvang", Font.PLAIN, 16));
        UIManager.put("OptionPane.messageFont", new Font("Lao_Somvang", Font.PLAIN, 14));
        UIManager.put("OptionPane.okButtonText", "ຕົກລົງ");
        UIManager.put("OptionPane.cancelButtonText", "ຍົກເລີກ");

        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("TextComponent.arc", 999);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    public javax.swing.JCheckBox checkremember;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

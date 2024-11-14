package includeClass;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

//ສ້າງຄລາດເພື່ອສະແດງຮູບໃນຕາຕະ
public class ImageRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel jlabel = new JLabel();
        byte[] bytes = (byte[]) value;
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH));
        jlabel.setIcon(imageIcon);
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        jlabel.setVerticalAlignment(JLabel.CENTER);

        return jlabel;
    }
}

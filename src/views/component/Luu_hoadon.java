package views.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Luu_hoadon extends JPanel {
    private JTextField tf_tenkhachhang;
    private JTextField tf_sdt;
    private JButton bt_xacnhan;
    private JDialog dialog;

    public Luu_hoadon(JDialog dialog) {
        this.dialog = dialog;
        setBackground(new Color(24, 71, 133));
        setSize(579, 350);
        setLayout(null);

        JLabel lbTenkhachhang = new JLabel("Tên khách hàng");
        lbTenkhachhang.setForeground(new Color(255, 204, 0));
        lbTenkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbTenkhachhang.setBounds(53, 106, 174, 30);
        add(lbTenkhachhang);

        tf_tenkhachhang = new JTextField();
        tf_tenkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
        tf_tenkhachhang.setColumns(10);
        tf_tenkhachhang.setBounds(237, 107, 268, 29);
        add(tf_tenkhachhang);

        JLabel lbsdt = new JLabel("SĐT");
        lbsdt.setForeground(new Color(255, 204, 0));
        lbsdt.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbsdt.setBounds(53, 159, 154, 30);
        add(lbsdt);

        tf_sdt = new JTextField();
        tf_sdt.setFont(new Font("Tahoma", Font.BOLD, 20));
        tf_sdt.setColumns(10);
        tf_sdt.setBounds(237, 160, 268, 29);
        add(tf_sdt);

        JLabel lblNewLabel_1 = new JLabel("THÊM HÓA ĐƠN");
        lblNewLabel_1.setForeground(new Color(255, 204, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(56, 11, 449, 46);
        add(lblNewLabel_1);

        bt_xacnhan = new JButton("XÁC NHẬN");
        bt_xacnhan.setBackground(new Color(255, 204, 0));
        bt_xacnhan.setFont(new Font("Tahoma", Font.BOLD, 30));
        bt_xacnhan.setBounds(158, 248, 268, 46);
        add(bt_xacnhan);
    }

    public JTextField getTfTenkhachhang() {
        return tf_tenkhachhang;
    }

    public JTextField getTfSdt() {
        return tf_sdt;
    }

    public JButton getBt_xacnhan() {
        return bt_xacnhan; // Đảm bảo trả về nút xác nhận đã khởi tạo
    }
}


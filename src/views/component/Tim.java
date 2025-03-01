package views.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import dao.DBNhanViens;
import dao.DB_Khachhangs;
import models.Models_Khachhang;
import models.Models_Nhanvien;
import pages.QL_khachhang;
import swings.PlaceholderTextFields;
import javax.swing.SwingConstants;

public class Tim extends JPanel {
    private DefaultTableModel table_model;
    private QL_khachhang ql_khachhang;
    private JTextField tf_timkiem;

    public Tim() {
    	setBackground(new Color(24, 71,133));
        setLayout(null);
       setSize(543, 83);
        
        
        JLabel lblNewLabel = new JLabel("Tìm kiếm :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 204, 0));
        lblNewLabel.setBounds(20, 22, 127, 39);
        add(lblNewLabel);
        
        tf_timkiem = new PlaceholderTextFields("Nhập tên thành viên...");
        tf_timkiem.setForeground(new Color(0, 0, 51));
        tf_timkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
        tf_timkiem.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                timkiem();
            }
            public void removeUpdate(DocumentEvent e) {
                timkiem();
            }
            public void changedUpdate(DocumentEvent e) {
                timkiem();
            }
        });
        tf_timkiem.setBounds(157, 22, 353, 39);
        add(tf_timkiem);
        tf_timkiem.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(24, 71,133));
        panel.setBounds(0, 0, 543, 83);
        add(panel);
    }
    
    public void setTableModel(DefaultTableModel tableModel) {
        this.table_model = tableModel;
    }

    public void timkiem() {
        String name = tf_timkiem.getText();
        if (name.isEmpty() || name.equals("Nhập tên thành viên...")) {
            if (ql_khachhang == null) {
                ql_khachhang = new QL_khachhang();
            }
            ql_khachhang.loadThanhVien(); // Tải tất cả thành viên nếu không có tên tìm kiếm
        } else {
            ArrayList<Models_Khachhang> list = DB_Khachhangs.getInstance().timkiem("%" + name + "%");
            if (table_model == null) {
                table_model = new DefaultTableModel();
            }
            table_model.setRowCount(0); // Xóa tất cả các dòng cũ trong bảng
            for (Models_Khachhang thanhvienmoi : list) {
                Object[] newRow = {
                    thanhvienmoi.getMakh(),
                    thanhvienmoi.getTenkh(),
                    thanhvienmoi.getSdt(),
                    thanhvienmoi.getTongchi(),
                    thanhvienmoi.getDiemtichluy(),
                    thanhvienmoi.getHang()
                };
                table_model.addRow(newRow); // Thêm dòng mới vào bảng
            }
        }

        if (ql_khachhang != null) {
            ql_khachhang.reset(); // Đảm bảo rằng ql_khachhang không phải là null khi gọi phương thức này
        }
    }
}

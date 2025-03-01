package pages;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Outcode.ImageUtils;
import dao.DBDoanhthus;
import models.Models_Doanhthu;


public class QL_doanhthu extends JPanel {
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField tf_tongthu;

	public QL_doanhthu() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);	
		setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("VNĐ");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(989, 615, 97, 29);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("TÔNG THU:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(255, 204, 0));
		lblNewLabel_3.setBounds(875, 615, 115, 29);
		add(lblNewLabel_3);
		
		tf_tongthu = new JTextField();
		tf_tongthu.setBounds(885, 660, 190, 41);
		add(tf_tongthu);
		tf_tongthu.setColumns(10);
		
		JLabel lb_title_nhanvien = new JLabel("");
		lb_title_nhanvien.setIcon(new ImageIcon(QL_doanhthu.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_nhanvien.setBounds(350, 10, 445, 64);
		add(lb_title_nhanvien);
		
		JLabel bt_load = new JLabel("LOAD");
		bt_load.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_load.setBackground(new Color(204,138,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_load.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				 loadData();
			}
		});
		bt_load.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_load.setHorizontalAlignment(SwingConstants.CENTER);
		bt_load.setBackground(new Color(255,212,58));
		bt_load.setOpaque(true);
		bt_load.setBounds(908, 124, 137, 54);
		add(bt_load);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(255, 204, 0));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(875, 650, 211, 64);
		add(lblNewLabel_2);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 124, 787, 591);
		add(scrollPane);
		
	    tableModel = new DefaultTableModel(
	    		new Object[][] {},
	    		new String[] {
	    				"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Số tiền đã nạp"
	    	  });
		
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		table.getColumnModel().getColumn(3).setPreferredWidth(170);
		
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 30));
		table.setRowHeight(40);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(16, 54, 103));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(48, 90, 1049, 681);
		add(lblNewLabel);
		
  }
	
	 private void loadData() {
	        // Lấy dữ liệu từ cơ sở dữ liệu
	        ArrayList<Models_Doanhthu> list = DBDoanhthus.getInstance().loadKhachHangData();
	        tableModel.setRowCount(0);
	        long total = 0;

	        // Đổ dữ liệu vào bảng và tính tổng
	        for (Models_Doanhthu khachhang : list) {
	            tableModel.addRow(new Object[] {
	                khachhang.getId(),
	                khachhang.getTenkh(),
	                khachhang.getSdtkh(),
	                khachhang.getTongchi()
	            });
	            total += khachhang.getTongchi();
	        }

	        // Hiển thị tổng tiền nạp
	        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	        tf_tongthu.setText(String.format("%,d VNĐ", total));
	    }
}

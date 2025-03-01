package views.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import models.Models_Nhanvien;
import services.Services;

public class ThemNV extends JPanel{
	private JTextField tf_tennhanvien;
	private JTextField tf_cccd;
	private JTextField tf_luong;
	private JTextField tf_sdt;
	private JTextField tf_ngaySinh;
	private JDialog dialog;
	private JDateChooser date_ngaysinh;
	
	public ThemNV(JDialog dialog) {
		this.dialog = dialog;
		setBackground(new Color(24, 71,133));
		setSize(1000, 400);
		setLayout(null);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setForeground(new Color(255, 204, 0));
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTnNhnVin.setBounds(53, 106, 154, 30);
		add(lblTnNhnVin);
		
		tf_tennhanvien = new JTextField();
		tf_tennhanvien.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf_tennhanvien.setColumns(10);
		tf_tennhanvien.setBounds(217, 106, 268, 29);
		add(tf_tennhanvien);
		
		JLabel lblCccd = new JLabel("CCCD");
		lblCccd.setForeground(new Color(255, 204, 0));
		lblCccd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCccd.setBounds(53, 161, 154, 30);
		add(lblCccd);
		
		tf_cccd = new JTextField();
		tf_cccd.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf_cccd.setColumns(10);
		tf_cccd.setBounds(217, 161, 268, 29);
		add(tf_cccd);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setForeground(new Color(255, 204, 0));
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGiiTnh.setBounds(53, 221, 154, 30);
		add(lblGiiTnh);
		
		String[] itemGioiTinh = { "Nam", "Nữ" };
		JComboBox<String> cbb_gioitinh = new JComboBox<String>(itemGioiTinh);
		cbb_gioitinh.setForeground(new Color(0, 0, 51));
		cbb_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbb_gioitinh.setBounds(217, 221, 268, 30);
		add(cbb_gioitinh);
		
		JLabel lblLng = new JLabel("Lương");
		lblLng.setForeground(new Color(255, 204, 0));
		lblLng.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLng.setBounds(563, 258, 154, 30);
		add(lblLng);
		
		tf_luong = new JTextField();
		tf_luong.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf_luong.setColumns(10);
		tf_luong.setBounds(682, 258, 268, 29);
		add(tf_luong);
		
		String[] itemChucVu = { "Quản lý", "Nhân viên", "Bảo vệ" };
		JComboBox<String> cbb_vaitro = new JComboBox<String>(itemChucVu);
		cbb_vaitro.setForeground(new Color(0, 0, 51));
		cbb_vaitro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbb_vaitro.setBounds(682, 198, 268, 30);
		add(cbb_vaitro);
		
		JLabel lblChcV = new JLabel("Chức vụ");
		lblChcV.setForeground(new Color(255, 204, 0));
		lblChcV.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChcV.setBounds(563, 198, 154, 30);
		add(lblChcV);
		
		JLabel lblSt = new JLabel("SĐT");
		lblSt.setForeground(new Color(255, 204, 0));
		lblSt.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSt.setBounds(563, 143, 154, 30);
		add(lblSt);
		
		tf_sdt = new JTextField();
		tf_sdt.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(682, 143, 268, 29);
		add(tf_sdt);
				
		date_ngaysinh = new JDateChooser();
		date_ngaysinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		date_ngaysinh.setBounds(682, 84, 268, 29);
		add(date_ngaysinh);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setForeground(new Color(255, 204, 0));
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgySinh.setBounds(563, 84, 154, 30);
		add(lblNgySinh);
		
		JLabel lblNewLabel_1 = new JLabel("THÊM NHÂN VIÊN");
		lblNewLabel_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(268, 10, 449, 46);
		add(lblNewLabel_1);
		
		JButton bt_them = new JButton("THÊM");
		bt_them.setBackground(new Color(255, 204, 0));
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tennv = tf_tennhanvien.getText();
				String cccd = tf_cccd.getText();
				String gioitinh = cbb_gioitinh.getSelectedItem().toString();
				
				java.util.Date selectedDate = date_ngaysinh.getDate();
				java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
				
				String sdt = tf_sdt.getText();
				String vaitro = cbb_vaitro.getSelectedItem().toString();
				int luong = Integer.parseInt(tf_luong.getText());
				
				Models_Nhanvien nhanVien = new Models_Nhanvien(0, tennv, cccd, gioitinh, sqlDate, sdt, vaitro, luong);
				
				Services.getInstance().getMain().getBody().getNhanvien().themnhanvien(nhanVien);
				dialog.dispose();			
			}
		});
		bt_them.setFont(new Font("Tahoma", Font.BOLD, 30));
		bt_them.setBounds(363, 332, 268, 46);
		add(bt_them);
	}
}

package pages;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QL_nhanvien extends JPanel{
	private JTextField tf_manhanvien;
	private JTextField tf_tennhanvien;
	private JTextField tf_cccd;
	private JTextField tf_ngaysinh;
	private JTextField tf_sdt;
	private JTextField tf_luong;
	private JTable table;
	private JComboBox cbb_gioitinh;
	private JComboBox cbb_vaitro;
	private DefaultTableModel tableModel;
	private JLabel bt_timkiem;
	

	public QL_nhanvien() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);	
		setLayout(null);
		
		JLabel lb_title_nhanvien = new JLabel("");
		lb_title_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_nhanvien.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_nhanvien.setBounds(350, 10, 445, 64);
		add(lb_title_nhanvien);
		
		JLabel lb_manv = new JLabel("Mã nhân viên");
		lb_manv.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_manv.setBounds(20, 103, 154, 30);
		add(lb_manv);
		
		tf_manhanvien = new JTextField();
		tf_manhanvien.setBounds(184, 103, 268, 29);
		add(tf_manhanvien);
		tf_manhanvien.setColumns(10);
		
		JLabel lb_tennhanvien = new JLabel("Tên nhân viên");
		lb_tennhanvien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_tennhanvien.setBounds(20, 162, 154, 30);
		add(lb_tennhanvien);
		
		tf_tennhanvien = new JTextField();
		tf_tennhanvien.setColumns(10);
		tf_tennhanvien.setBounds(184, 162, 268, 29);
		add(tf_tennhanvien);
		
		JLabel lb_cccd = new JLabel("CCCD");
		lb_cccd.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_cccd.setBounds(20, 218, 154, 30);
		add(lb_cccd);
		
		tf_cccd = new JTextField();
		tf_cccd.setColumns(10);
		tf_cccd.setBounds(184, 218, 268, 29);
		add(tf_cccd);
		
		JLabel lb_gioitinh = new JLabel("Giới tính");
		lb_gioitinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_gioitinh.setBounds(20, 278, 154, 30);
		add(lb_gioitinh);
		
		String[] itemGioiTinh = { "Nam", "Nữ" };
		cbb_gioitinh = new JComboBox<>(itemGioiTinh);
		cbb_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_gioitinh.setBounds(184, 278, 268, 30);
		add(cbb_gioitinh);
		
		JLabel lb_ngaysinh = new JLabel("Ngày sinh");
		lb_ngaysinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_ngaysinh.setBounds(499, 103, 136, 30);
		add(lb_ngaysinh);
		
		tf_ngaysinh = new JTextField();
		tf_ngaysinh.setColumns(10);
		tf_ngaysinh.setBounds(645, 103, 268, 29);
		add(tf_ngaysinh);
		
		JLabel lb_sdt = new JLabel("Số điện thoại");
		lb_sdt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_sdt.setBounds(499, 162, 136, 30);
		add(lb_sdt);
		
		tf_sdt = new JTextField();
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(645, 162, 268, 29);
		add(tf_sdt);
		
		JLabel lb_luong = new JLabel("Lương");
		lb_luong.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_luong.setBounds(499, 218, 136, 30);
		add(lb_luong);
		
		tf_luong = new JTextField();
		tf_luong.setColumns(10);
		tf_luong.setBounds(645, 218, 268, 29);
		add(tf_luong);
		
		JLabel lb_vaitro = new JLabel("Vai trò");
		lb_vaitro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_vaitro.setBounds(499, 278, 136, 30);
		add(lb_vaitro);
		
		String[] itemvaitro = {"Quản lý", "Nhân viên", "Bảo vệ" }; 
		cbb_vaitro = new JComboBox<>(itemvaitro);
		cbb_vaitro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_vaitro.setBounds(645, 278, 268, 30);
		add(cbb_vaitro);
		
		bt_timkiem = new JLabel("Tìm kiếm");
		bt_timkiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_timkiem.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_timkiem.setBackground(new Color(255,212,58));
			}
		});
		bt_timkiem.setForeground(new Color(0,28,65));
		bt_timkiem.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/icons/icons8-search-property-27.png")));
		bt_timkiem.setBackground(new Color(255,212,58));
		bt_timkiem.setOpaque(true);
		bt_timkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_timkiem.setHorizontalAlignment(SwingConstants.CENTER);
		bt_timkiem.setBounds(20, 348, 160, 40);
		add(bt_timkiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 405, 1113, 411);
		add(scrollPane);
		
		tableModel = new DefaultTableModel(
				new Object[][] {},
		        new String[] {
		          		 "Mã nhân viên", "Tên nhân viên", "CCCD", "Giới tính", "Ngày sinh", "Số điện thoại", "Vai trò", "Lương"
		           });
       		
		table = new JTable();
		table.setModel(tableModel);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(133);
		table.getColumnModel().getColumn(5).setPreferredWidth(170);
		table.getColumnModel().getColumn(6).setPreferredWidth(133);
		table.getColumnModel().getColumn(7).setPreferredWidth(171);
		scrollPane.setViewportView(table);		

		
		
		
		JLabel bt_themnhanvien = new JLabel("THÊM NHÂN VIÊN");
		bt_themnhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_themnhanvien.setBackground(new Color(197,222,253));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_themnhanvien.setBackground(new Color(0,28,65));
			}
		});
		bt_themnhanvien.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/icons/icons8-add-35.png")));
		bt_themnhanvien.setForeground(new Color(255,212,58));
		bt_themnhanvien.setBackground(new Color(0,28,65));
		bt_themnhanvien.setOpaque(true);
		bt_themnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_themnhanvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_themnhanvien.setBounds(941, 89, 196, 50);
		add(bt_themnhanvien);
		
		JLabel bt_suathongtin = new JLabel("SỬA THÔNG TIN");
		bt_suathongtin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_suathongtin.setBackground(new Color(197,222,253));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_suathongtin.setBackground(new Color(0,28,65));
			}
		});
		bt_suathongtin.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/icons/icons8-edit-text-file-35.png")));
		bt_suathongtin.setOpaque(true);
		bt_suathongtin.setHorizontalAlignment(SwingConstants.CENTER);
		bt_suathongtin.setForeground(new Color(255, 212, 58));
		bt_suathongtin.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_suathongtin.setBackground(new Color(0, 28, 65));
		bt_suathongtin.setBounds(941, 150, 196, 50);
		add(bt_suathongtin);
		
		JLabel bt_xoanhanvien = new JLabel("XÓA NHÂN VIÊN");
		bt_xoanhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_xoanhanvien.setBackground(new Color(197,222,253));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_xoanhanvien.setBackground(new Color(0,28,65));
			}
		});
		bt_xoanhanvien.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/icons/icons8-delete-35.png")));
		bt_xoanhanvien.setOpaque(true);
		bt_xoanhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_xoanhanvien.setForeground(new Color(255, 212, 58));
		bt_xoanhanvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_xoanhanvien.setBackground(new Color(0, 28, 65));
		bt_xoanhanvien.setBounds(941, 211, 196, 50);
		add(bt_xoanhanvien);
		
		JLabel bt_hienthi = new JLabel("HIỂN THỊ");
		bt_hienthi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_hienthi.setBackground(new Color(197,222,253));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_hienthi.setBackground(new Color(0,28,65));
			}
		});
		bt_hienthi.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/icons/icons8-show-property-35.png")));
		bt_hienthi.setOpaque(true);
		bt_hienthi.setHorizontalAlignment(SwingConstants.CENTER);
		bt_hienthi.setForeground(new Color(255, 212, 58));
		bt_hienthi.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_hienthi.setBackground(new Color(0, 28, 65));
		bt_hienthi.setBounds(941, 271, 196, 50);
		add(bt_hienthi);
		
		
	}
	
}

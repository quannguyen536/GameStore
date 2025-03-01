package pages;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class QL_khachhang extends JPanel{
	private JTextField tf_makhachhang;
	private JTextField tf_tenkhachhang;
	private JTextField tf_sdt;
	private JTextField tf_sotiendanap;
	private JTextField tf_diemtichluy;
	private JTable table;
	private JComboBox cbb_hang;
	private JLabel bt_luu;
	private JLabel bt_naptien;
	private JLabel bt_20_000vnd;
	private JLabel bt_50_000vnd;
	private JLabel bt_100_000vdn;
	private JLabel bt_200_000vnd;
	private JLabel bt_500_000vnd;
	private JLabel bt_1trvnd;
	private JLabel bt_2trvnd;
	private JLabel bt_5trvnd;
	private JLabel bt_8trvnd;
	private DefaultTableModel tableModel;
	

	public QL_khachhang() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);	
		setLayout(null);
		
		JLabel lb_title_khachhang = new JLabel("");
		lb_title_khachhang.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_khachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_khachhang.setBounds(350, 10, 445, 64);
		add(lb_title_khachhang);
		
		JLabel lb_makhachhang = new JLabel("Mã khách hàng");
		lb_makhachhang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_makhachhang.setBounds(10, 105, 154, 30);
		add(lb_makhachhang);
		
		tf_makhachhang = new JTextField();
		tf_makhachhang.setBounds(178, 105, 283, 30);
		add(tf_makhachhang);
		tf_makhachhang.setColumns(10);
		
		JLabel lb_tenkhachhang = new JLabel("Tên khách hàng");
		lb_tenkhachhang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_tenkhachhang.setBounds(10, 146, 154, 30);
		add(lb_tenkhachhang);
		
		tf_tenkhachhang = new JTextField();
		tf_tenkhachhang.setColumns(10);
		tf_tenkhachhang.setBounds(178, 146, 283, 30);
		add(tf_tenkhachhang);
		
		JLabel lb_sdt = new JLabel("Số điện thoại");
		lb_sdt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_sdt.setBounds(10, 187, 154, 30);
		add(lb_sdt);
		
		tf_sdt = new JTextField();
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(178, 187, 283, 30);
		add(tf_sdt);
		
		JLabel lb_sotiennap = new JLabel("Số tiền đã nạp");
		lb_sotiennap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_sotiennap.setBounds(10, 228, 154, 30);
		add(lb_sotiennap);
		
		tf_sotiendanap = new JTextField();
		tf_sotiendanap.setColumns(10);
		tf_sotiendanap.setBounds(178, 228, 283, 30);
		add(tf_sotiendanap);
		
		JLabel lb_diemtichluy = new JLabel("Điểm tích lũy");
		lb_diemtichluy.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_diemtichluy.setBounds(10, 269, 154, 30);
		add(lb_diemtichluy);
		
		tf_diemtichluy = new JTextField();
		tf_diemtichluy.setColumns(10);
		tf_diemtichluy.setBounds(178, 269, 283, 30);
		add(tf_diemtichluy);
		
		JLabel lb_hang = new JLabel("Hạng");
		lb_hang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_hang.setBounds(10, 314, 154, 30);
		add(lb_hang);
		
		String[] iteamhang = {"Đồng", "Bạc", "Vàng", "Bạch kim", "Kim cương"};
		cbb_hang = new JComboBox<>(iteamhang);
		cbb_hang.setForeground(new Color(0, 28, 65));
		cbb_hang.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbb_hang.setBounds(178, 317, 283, 30);
		add(cbb_hang);
		
		bt_luu = new JLabel("Lưu");
		bt_luu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_luu.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_luu.setBackground(new Color(255,212,58));
			}
		});
		bt_luu.setOpaque(true);
		bt_luu.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-save-27.png")));
		bt_luu.setHorizontalAlignment(SwingConstants.CENTER);
		bt_luu.setForeground(new Color(0, 28, 65));
		bt_luu.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_luu.setBackground(new Color(255, 212, 58));
		bt_luu.setBounds(122, 355, 100, 40);
		add(bt_luu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 414, 1113, 379);
		add(scrollPane);
		
	    tableModel = new DefaultTableModel(
	    		new Object[][] {},
	    		new String[] {
	    				"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Số tiền đã nạp", "Điểm tích lũy", "Hạng"
	    	  });
		
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		table.getColumnModel().getColumn(3).setPreferredWidth(170);
		table.getColumnModel().getColumn(4).setPreferredWidth(170);
		table.getColumnModel().getColumn(5).setPreferredWidth(113);

		
		
		JLabel bt_themnhanvien = new JLabel("THÊM NHÂN VIÊN");
		bt_themnhanvien.setOpaque(true);
		bt_themnhanvien.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-add-35.png")));
		bt_themnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_themnhanvien.setForeground(new Color(255, 212, 58));
		bt_themnhanvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_themnhanvien.setBackground(new Color(0, 28, 65));
		bt_themnhanvien.setBounds(942, 88, 191, 50);
		add(bt_themnhanvien);
		
		JLabel bt_suathongtin = new JLabel("SỬA THÔNG TIN");
		bt_suathongtin.setOpaque(true);
		bt_suathongtin.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-edit-text-file-35.png")));
		bt_suathongtin.setHorizontalAlignment(SwingConstants.CENTER);
		bt_suathongtin.setForeground(new Color(255, 212, 58));
		bt_suathongtin.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_suathongtin.setBackground(new Color(0, 28, 65));
		bt_suathongtin.setBounds(942, 149, 191, 50);
		add(bt_suathongtin);
		
		JLabel bt_xoanhanvien = new JLabel("XÓA NHÂN VIÊN");
		bt_xoanhanvien.setOpaque(true);
		bt_xoanhanvien.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-delete-35.png")));
		bt_xoanhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_xoanhanvien.setForeground(new Color(255, 212, 58));
		bt_xoanhanvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_xoanhanvien.setBackground(new Color(0, 28, 65));
		bt_xoanhanvien.setBounds(942, 210, 191, 50);
		add(bt_xoanhanvien);
		
		JLabel bt_hienthi = new JLabel("HIỂN THỊ");
		bt_hienthi.setOpaque(true);
		bt_hienthi.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-show-property-35.png")));
		bt_hienthi.setHorizontalAlignment(SwingConstants.CENTER);
		bt_hienthi.setForeground(new Color(255, 212, 58));
		bt_hienthi.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_hienthi.setBackground(new Color(0, 28, 65));
		bt_hienthi.setBounds(942, 270, 191, 50);
		add(bt_hienthi);
		
		JLabel lblNewLabel = new JLabel("Mệnh giá:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255,212,58));
		lblNewLabel.setBounds(482, 96, 70, 14);
		add(lblNewLabel);
		
		bt_20_000vnd = new JLabel("20.000 VNĐ");
		bt_20_000vnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_20_000vnd.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_20_000vnd.setBackground(new Color(255,212,58));
			}
		});
		bt_20_000vnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_20_000vnd.setHorizontalAlignment(SwingConstants.CENTER);
		bt_20_000vnd.setBackground(new Color(255,212,58));
		bt_20_000vnd.setOpaque(true);
		bt_20_000vnd.setForeground(new Color(0, 28, 65));
		bt_20_000vnd.setBounds(492, 125, 124, 40);
		add(bt_20_000vnd);
		
		bt_200_000vnd = new JLabel("200.000 VNĐ");
		bt_200_000vnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_200_000vnd.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_200_000vnd.setBackground(new Color(255,212,58));
			}
		});
		bt_200_000vnd.setOpaque(true);
		bt_200_000vnd.setHorizontalAlignment(SwingConstants.CENTER);
		bt_200_000vnd.setForeground(new Color(0, 28, 65));
		bt_200_000vnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_200_000vnd.setBackground(new Color(255, 212, 58));
		bt_200_000vnd.setBounds(492, 198, 124, 40);
		add(bt_200_000vnd);
		
		bt_50_000vnd = new JLabel("50.000 VNĐ");
		bt_50_000vnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_50_000vnd.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_50_000vnd.setBackground(new Color(255,212,58));
			}
		});
		bt_50_000vnd.setOpaque(true);
		bt_50_000vnd.setHorizontalAlignment(SwingConstants.CENTER);
		bt_50_000vnd.setForeground(new Color(0, 28, 65));
		bt_50_000vnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_50_000vnd.setBackground(new Color(255, 212, 58));
		bt_50_000vnd.setBounds(644, 125, 124, 40);
		add(bt_50_000vnd);
		
		bt_500_000vnd = new JLabel("500.000 VNĐ");
		bt_500_000vnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_500_000vnd.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_500_000vnd.setBackground(new Color(255,212,58));
			}
		});
		bt_500_000vnd.setOpaque(true);
		bt_500_000vnd.setHorizontalAlignment(SwingConstants.CENTER);
		bt_500_000vnd.setForeground(new Color(0, 28, 65));
		bt_500_000vnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_500_000vnd.setBackground(new Color(255, 212, 58));
		bt_500_000vnd.setBounds(644, 198, 124, 40);
		add(bt_500_000vnd);
		
		bt_100_000vdn = new JLabel("100.000 VNĐ");
		bt_100_000vdn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_100_000vdn.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_100_000vdn.setBackground(new Color(255,212,58));
			}
		});
		bt_100_000vdn.setOpaque(true);
		bt_100_000vdn.setHorizontalAlignment(SwingConstants.CENTER);
		bt_100_000vdn.setForeground(new Color(0, 28, 65));
		bt_100_000vdn.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_100_000vdn.setBackground(new Color(255, 212, 58));
		bt_100_000vdn.setBounds(795, 125, 124, 40);
		add(bt_100_000vdn);
		
		bt_1trvnd = new JLabel("1.000.000 VNĐ");
		bt_1trvnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_1trvnd.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_1trvnd.setBackground(new Color(255,212,58));
			}
		});
		bt_1trvnd.setOpaque(true);
		bt_1trvnd.setHorizontalAlignment(SwingConstants.CENTER);
		bt_1trvnd.setForeground(new Color(0, 28, 65));
		bt_1trvnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_1trvnd.setBackground(new Color(255, 212, 58));
		bt_1trvnd.setBounds(795, 198, 124, 40);
		add(bt_1trvnd);
		
		bt_2trvnd = new JLabel("2.000.000 VNĐ");
		bt_2trvnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_2trvnd.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_2trvnd.setBackground(new Color(255,212,58));
			}
		});
		bt_2trvnd.setOpaque(true);
		bt_2trvnd.setHorizontalAlignment(SwingConstants.CENTER);
		bt_2trvnd.setForeground(new Color(0, 28, 65));
		bt_2trvnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_2trvnd.setBackground(new Color(255, 212, 58));
		bt_2trvnd.setBounds(492, 269, 124, 40);
		add(bt_2trvnd);
		
		bt_5trvnd = new JLabel("5.000.000 VNĐ");
		bt_5trvnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_5trvnd.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_5trvnd.setBackground(new Color(255,212,58));
			}
		});
		bt_5trvnd.setOpaque(true);
		bt_5trvnd.setHorizontalAlignment(SwingConstants.CENTER);
		bt_5trvnd.setForeground(new Color(0, 28, 65));
		bt_5trvnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_5trvnd.setBackground(new Color(255, 212, 58));
		bt_5trvnd.setBounds(644, 269, 124, 40);
		add(bt_5trvnd);
		
		bt_8trvnd = new JLabel("8.000.000 VNĐ");
		bt_8trvnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_8trvnd.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_8trvnd.setBackground(new Color(255,212,58));
			}
		});
		bt_8trvnd.setOpaque(true);
		bt_8trvnd.setHorizontalAlignment(SwingConstants.CENTER);
		bt_8trvnd.setForeground(new Color(0, 28, 65));
		bt_8trvnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_8trvnd.setBackground(new Color(255, 212, 58));
		bt_8trvnd.setBounds(795, 269, 124, 40);
		add(bt_8trvnd);
		
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		label.setBackground(new Color(0, 28, 65));
		label.setOpaque(true);
		label.setBounds(471, 85, 461, 259);
		add(label);
		
		bt_naptien = new JLabel("Nạp tiền");
		bt_naptien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_naptien.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_naptien.setBackground(new Color(255,212,58));
			}
		});
		bt_naptien.setOpaque(true);
		bt_naptien.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-magnetic-card-27.png")));
		bt_naptien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_naptien.setForeground(new Color(0, 28, 65));
		bt_naptien.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_naptien.setBackground(new Color(255, 212, 58));
		bt_naptien.setBounds(644, 355, 100, 40);
		add(bt_naptien);


	}
}

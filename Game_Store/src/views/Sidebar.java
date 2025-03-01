package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import pages.QL_doanhthu;
import pages.QL_khachhang;
import pages.QL_maytinh;
import pages.QL_monan;
import pages.QL_nhanvien;
import pages.QL_quannet;
import pages.QL_thongke;
import pages.QL_uudai;
import services.Services;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sidebar extends JPanel {
	private JLabel lb_ql_quannet;
	private JLabel lb_ql_nhanvien;
	private JLabel lb_khachhang;
	private JLabel lb_ql_monan;
	private JLabel lb_quanlimaytinh;
	private JLabel lb_uudai;
	private JLabel lb_doanhthu;
	private JLabel lb_thongke;

	public Sidebar() {
		setBackground(new Color(0,28,65));
		setSize(280, 900);
		setLayout(null);
		
		lb_ql_quannet = new JLabel("QUẢN LÍ QUÁN NET");
		lb_ql_quannet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_ql_quannet.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_ql_quannet.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Services.getInstance().getMain().getBody().getCardLayout().show(Services.getInstance().getMain().getBody(), "quannet");
				reset();
				lb_ql_quannet.setBackground(new Color(204,138,0));
			}
		});
		lb_ql_quannet.setIcon(new ImageIcon(Sidebar.class.getResource("/images/icons/icons8-store-35.png")));
		lb_ql_quannet.setBackground(new Color(255,212,58));
		lb_ql_quannet.setOpaque(true);
		lb_ql_quannet.setForeground(new Color(0, 0, 0));
		lb_ql_quannet.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_ql_quannet.setHorizontalAlignment(SwingConstants.CENTER);
		lb_ql_quannet.setBounds(0, 218, 280, 49);
		add(lb_ql_quannet);
		
		lb_ql_nhanvien = new JLabel("QUẢN LÍ NHÂN VIÊN");
		lb_ql_nhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_ql_nhanvien.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_ql_nhanvien.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Services.getInstance().getMain().getBody().getCardLayout().show(Services.getInstance().getMain().getBody(), "nhanvien");
				reset();
				lb_ql_nhanvien.setBackground(new Color(204,138,0));	
			}
		});
		lb_ql_nhanvien.setIcon(new ImageIcon(Sidebar.class.getResource("/images/icons/icons8-employee-35.png")));
		lb_ql_nhanvien.setOpaque(true);
		lb_ql_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_ql_nhanvien.setForeground(Color.BLACK);
		lb_ql_nhanvien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_ql_nhanvien.setBackground(new Color(255, 212, 58));
		lb_ql_nhanvien.setBounds(0, 278, 280, 49);
		add(lb_ql_nhanvien);
		
		lb_khachhang = new JLabel("KHÁCH HÀNG");
		lb_khachhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_khachhang.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_khachhang.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Services.getInstance().getMain().getBody().getCardLayout().show(Services.getInstance().getMain().getBody(), "khachhang");
				reset();
				lb_khachhang.setBackground(new Color(204,138,0));
			}
		});
		lb_khachhang.setIcon(new ImageIcon(Sidebar.class.getResource("/images/icons/icons8-customer-35.png")));
		lb_khachhang.setOpaque(true);
		lb_khachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lb_khachhang.setForeground(Color.BLACK);
		lb_khachhang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_khachhang.setBackground(new Color(255, 212, 58));
		lb_khachhang.setBounds(0, 338, 280, 49);
		add(lb_khachhang);
		
		lb_ql_monan = new JLabel("QUẢN LÍ MÓN ĂN");
		lb_ql_monan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_ql_monan.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_ql_monan.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Services.getInstance().getMain().getBody().getCardLayout().show(Services.getInstance().getMain().getBody(), "monan");
				reset();
				lb_ql_monan.setBackground(new Color(204,138,0));
			}
		});
		lb_ql_monan.setIcon(new ImageIcon(Sidebar.class.getResource("/images/icons/icons8-food-bar-35.png")));
		lb_ql_monan.setOpaque(true);
		lb_ql_monan.setHorizontalAlignment(SwingConstants.CENTER);
		lb_ql_monan.setForeground(Color.BLACK);
		lb_ql_monan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_ql_monan.setBackground(new Color(255, 212, 58));
		lb_ql_monan.setBounds(0, 398, 280, 49);
		add(lb_ql_monan);
		
		lb_quanlimaytinh = new JLabel("QUẢN LÍ MÁY TÍNH");
		lb_quanlimaytinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_quanlimaytinh.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_quanlimaytinh.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Services.getInstance().getMain().getBody().getCardLayout().show(Services.getInstance().getMain().getBody(), "maytinh");
				reset();
				lb_quanlimaytinh.setBackground(new Color(204,138,0));
			}
		});
		lb_quanlimaytinh.setIcon(new ImageIcon(Sidebar.class.getResource("/images/icons/icons8-computer-35.png")));
		lb_quanlimaytinh.setOpaque(true);
		lb_quanlimaytinh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_quanlimaytinh.setForeground(Color.BLACK);
		lb_quanlimaytinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_quanlimaytinh.setBackground(new Color(255, 212, 58));
		lb_quanlimaytinh.setBounds(0, 458, 280, 49);
		add(lb_quanlimaytinh);
		
		lb_uudai = new JLabel("ƯU ĐÃI");
		lb_uudai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_uudai.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_uudai.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Services.getInstance().getMain().getBody().getCardLayout().show(Services.getInstance().getMain().getBody(), "uudai");
				reset();
				lb_uudai.setBackground(new Color(204,138,0));	
			}
		});
		lb_uudai.setIcon(new ImageIcon(Sidebar.class.getResource("/images/icons/icons8-discount-35.png")));
		lb_uudai.setOpaque(true);
		lb_uudai.setHorizontalAlignment(SwingConstants.CENTER);
		lb_uudai.setForeground(Color.BLACK);
		lb_uudai.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_uudai.setBackground(new Color(255, 212, 58));
		lb_uudai.setBounds(0, 518, 280, 49);
		add(lb_uudai);
		
		lb_doanhthu = new JLabel("DOANH THU");
		lb_doanhthu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_doanhthu.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_doanhthu.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Services.getInstance().getMain().getBody().getCardLayout().show(Services.getInstance().getMain().getBody(), "doanhthu");
				reset();
				lb_doanhthu.setBackground(new Color(204,138,0));	
			}
		});
		lb_doanhthu.setIcon(new ImageIcon(Sidebar.class.getResource("/images/icons/icons8-revenue-35.png")));
		lb_doanhthu.setOpaque(true);
		lb_doanhthu.setHorizontalAlignment(SwingConstants.CENTER);
		lb_doanhthu.setForeground(Color.BLACK);
		lb_doanhthu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_doanhthu.setBackground(new Color(255, 212, 58));
		lb_doanhthu.setBounds(0, 578, 280, 49);
		add(lb_doanhthu);
		
		lb_thongke = new JLabel("THỐNG KÊ");
		lb_thongke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_thongke.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_thongke.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Services.getInstance().getMain().getBody().getCardLayout().show(Services.getInstance().getMain().getBody(), "thongke");
				reset();
				lb_thongke.setBackground(new Color(204,138,0));	
			}
		});
		lb_thongke.setIcon(new ImageIcon(Sidebar.class.getResource("/images/icons/icons8-analytics-35.png")));
		lb_thongke.setOpaque(true);
		lb_thongke.setHorizontalAlignment(SwingConstants.CENTER);
		lb_thongke.setForeground(Color.BLACK);
		lb_thongke.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_thongke.setBackground(new Color(255, 212, 58));
		lb_thongke.setBounds(0, 638, 280, 49);
		add(lb_thongke);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sidebar.class.getResource("/images/logos/Freelogodesign-Gamestore-155.png")));
		lblNewLabel.setBounds(62, 22, 155, 155);
		add(lblNewLabel);
		
	}
	
	public void reset() {
		lb_ql_quannet.setBackground(new Color(255,212,58));
		lb_ql_nhanvien.setBackground(new Color(255,212,58));
		lb_khachhang.setBackground(new Color(255,212,58));
		lb_ql_monan.setBackground(new Color(255,212,58));
		lb_quanlimaytinh.setBackground(new Color(255,212,58));
		lb_uudai.setBackground(new Color(255,212,58));
		lb_doanhthu.setBackground(new Color(255,212,58));
		lb_thongke.setBackground(new Color(255,212,58));
	}
}

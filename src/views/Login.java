package views;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Outcode.MD5s;
import dao.DBTaikhoan_Admin;
import models.Models_Dangki;
import models.Models_Dangnhap;
import services.Services;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JPanel{
	private CardLayout cardLayout;
	private JTextField tf_tendangnhap;
	private JPasswordField tf_matkhaudangnhap;
	private JTextField tf_tendangnhap_dangki;
	private JPasswordField tf_mkdangki;
	private JPasswordField tf_nhaplaimkdangki;
	private Sidebar sidebar;
	private JLabel lb_dangnhap_message;
	private JLabel lb_dangki_message;

	public Login() {
		setSize(1450, 900);
		setBackground(new Color(0,28,65));
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(980, 174, 361, 434);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		cardLayout = new CardLayout(0, 0);
		panel.setLayout(cardLayout);
		
		
		
		Panel pn_dangnhap = new Panel();
		panel.add(pn_dangnhap, "pn_dangnhap");
		pn_dangnhap.setLayout(null);
		
		
		JLabel lbtitle_dangnhap = new JLabel("ĐĂNG NHẬP");
		lbtitle_dangnhap.setForeground(new Color(0,28,65));
		lbtitle_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbtitle_dangnhap.setHorizontalAlignment(SwingConstants.CENTER);
		lbtitle_dangnhap.setBounds(66, 11, 223, 52);
		pn_dangnhap.add(lbtitle_dangnhap);
		
		JLabel lbtitle_tendangnhap = new JLabel("Tên đăng nhập");
		lbtitle_tendangnhap.setForeground(new Color(0,28,65));
		lbtitle_tendangnhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbtitle_tendangnhap.setBounds(29, 105, 151, 27);
		pn_dangnhap.add(lbtitle_tendangnhap);
		
		tf_tendangnhap = new JTextField();
		tf_tendangnhap.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_tendangnhap.setBounds(29, 133, 308, 39);
		pn_dangnhap.add(tf_tendangnhap);
		tf_tendangnhap.setColumns(10);
		
		JLabel lbtitle_matkhau = new JLabel("Mật khẩu");
		lbtitle_matkhau.setForeground(new Color(0,28,65));
		lbtitle_matkhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbtitle_matkhau.setBounds(29, 201, 151, 27);
		pn_dangnhap.add(lbtitle_matkhau);
		
		tf_matkhaudangnhap = new JPasswordField();
		tf_matkhaudangnhap.setBounds(29, 229, 308, 39);
		pn_dangnhap.add(tf_matkhaudangnhap);
		
		JLabel bt_dangnhap = new JLabel("ĐĂNG NHẬP");
		bt_dangnhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_dangnhap.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_dangnhap.setBackground(new Color(255,212,58));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tf_tendangnhap.getText().isEmpty()) {
					tf_tendangnhap.grabFocus();
				}
				else if(tf_matkhaudangnhap.getText().isEmpty()) {
					tf_matkhaudangnhap.grabFocus();
				}
				else {
					Models_Dangnhap dangnhap = new Models_Dangnhap(tf_tendangnhap.getText(), MD5s.getMd5(tf_matkhaudangnhap.getText()));
					boolean check = DBTaikhoan_Admin.getInstance().dangnhap(dangnhap);
					if(check) {
						Services.getInstance().getMain().display();
					}
					else {
						lb_dangnhap_message.setText("TÀI KHOẢN HOẶC MẬT KHẨU SAI");
						lb_dangnhap_message.setForeground(Color.red);
					}
				}
			}
		});
		
		bt_dangnhap.setForeground(new Color(0,28,65));
		bt_dangnhap.setBackground(new Color(255, 212, 58));
		bt_dangnhap.setOpaque(true);
		bt_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		bt_dangnhap.setHorizontalAlignment(SwingConstants.CENTER);
		bt_dangnhap.setBounds(29, 314, 308, 37);
		pn_dangnhap.add(bt_dangnhap);
		
		lb_dangnhap_message = new JLabel("");
		lb_dangnhap_message.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_dangnhap_message.setHorizontalAlignment(SwingConstants.CENTER);
		lb_dangnhap_message.setBounds(25, 386, 315, 27);
		pn_dangnhap.add(lb_dangnhap_message);
		
		JLabel bt_chuyenformdangki = new JLabel("ĐĂNG KÍ");
		bt_chuyenformdangki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_chuyenformdangki.setBackground(new Color(0,77,141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_chuyenformdangki.setBackground(new Color(0,28,65));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panel, "pn_dangki");
			}
		});
		bt_chuyenformdangki.setForeground(new Color(255, 212, 58));
		bt_chuyenformdangki.setBackground(new Color(0,28,65));
		bt_chuyenformdangki.setOpaque(true);
		bt_chuyenformdangki.setHorizontalAlignment(SwingConstants.CENTER);
		bt_chuyenformdangki.setBounds(124, 362, 120, 20);
		pn_dangnhap.add(bt_chuyenformdangki);
		
		
		
		Panel pn_dangki = new Panel();
		panel.add(pn_dangki, "pn_dangki");
		pn_dangki.setLayout(null);
		

		lb_dangki_message = new JLabel("");
		lb_dangki_message.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb_dangki_message.setHorizontalAlignment(SwingConstants.CENTER);
		lb_dangki_message.setBounds(22, 386, 315, 27);
		pn_dangki.add(lb_dangki_message);
		
		JLabel lbtitle_dangki = new JLabel("ĐĂNG KÍ");
		lbtitle_dangki.setHorizontalAlignment(SwingConstants.CENTER);
		lbtitle_dangki.setForeground(new Color(0, 28, 65));
		lbtitle_dangki.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbtitle_dangki.setBounds(74, 11, 223, 52);
		pn_dangki.add(lbtitle_dangki);
		
		JLabel lbtitle_tendangnhap_1 = new JLabel("Tên đăng nhập");
		lbtitle_tendangnhap_1.setForeground(new Color(0, 28, 65));
		lbtitle_tendangnhap_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbtitle_tendangnhap_1.setBounds(25, 63, 151, 27);
		pn_dangki.add(lbtitle_tendangnhap_1);
		
		tf_tendangnhap_dangki = new JTextField();
		tf_tendangnhap_dangki.setFont(new Font("Tahoma", Font.BOLD, 13));
		tf_tendangnhap_dangki.setColumns(10);
		tf_tendangnhap_dangki.setBounds(25, 91, 308, 39);
		pn_dangki.add(tf_tendangnhap_dangki);
		
		JLabel lbtitle_matkhau_1 = new JLabel("Mật khẩu");
		lbtitle_matkhau_1.setForeground(new Color(0, 28, 65));
		lbtitle_matkhau_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbtitle_matkhau_1.setBounds(25, 155, 151, 27);
		pn_dangki.add(lbtitle_matkhau_1);
		
		tf_mkdangki = new JPasswordField();
		tf_mkdangki.setBounds(25, 183, 308, 39);
		pn_dangki.add(tf_mkdangki);
		
		JLabel lbtitle_nhaplaimatkhau = new JLabel("Nhập lại mật khẩu");
		lbtitle_nhaplaimatkhau.setForeground(new Color(0, 28, 65));
		lbtitle_nhaplaimatkhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbtitle_nhaplaimatkhau.setBounds(25, 233, 151, 27);
		pn_dangki.add(lbtitle_nhaplaimatkhau);
		
		tf_nhaplaimkdangki = new JPasswordField();
		tf_nhaplaimkdangki.setBounds(25, 261, 308, 39);
		pn_dangki.add(tf_nhaplaimkdangki);
		
		JLabel bt_dangki_1 = new JLabel("ĐĂNG KÍ");
		bt_dangki_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_dangki_1.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_dangki_1.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tf_tendangnhap_dangki.getText().isEmpty()) {
					tf_tendangnhap.grabFocus();
				}
				else if(tf_mkdangki.getText().isEmpty()) {
					tf_matkhaudangnhap.grabFocus();
				}
				else if(!tf_mkdangki.getText().equals(tf_nhaplaimkdangki.getText())) {
					lb_dangki_message.setText("Xác nhận mật khẩu chưa chính xác!");
					lb_dangki_message.setForeground(Color.red);
				}
				else {
					Models_Dangki dangki = new Models_Dangki(tf_tendangnhap_dangki.getText(), MD5s.getMd5(tf_mkdangki.getText()));
					boolean check = DBTaikhoan_Admin.getInstance().dangki(dangki);
					
					if(check) {
						lb_dangki_message.setText("ĐĂNG KÝ THÀNH CÔNG");
						lb_dangki_message.setForeground(Color.GREEN);
					}
					else {
						lb_dangki_message.setText("TÀI KHOẢN ĐÃ TỒN TẠI");
						lb_dangki_message.setForeground(Color.red);
					}
				}
			}
		});
		bt_dangki_1.setOpaque(true);
		bt_dangki_1.setHorizontalAlignment(SwingConstants.CENTER);
		bt_dangki_1.setForeground(new Color(0, 28, 65));
		bt_dangki_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		bt_dangki_1.setBackground(new Color(255, 212, 58));
		bt_dangki_1.setBounds(25, 311, 308, 37);
		pn_dangki.add(bt_dangki_1);
		
		JLabel bt_chuyenformdangnhap_1 = new JLabel("ĐĂNG NHẬP");
		bt_chuyenformdangnhap_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_chuyenformdangnhap_1.setBackground(new Color(0,77,141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_chuyenformdangnhap_1.setBackground(new Color(0,28,65));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panel, "pn_dangnhap");
			}
		});
		bt_chuyenformdangnhap_1.setOpaque(true);
		bt_chuyenformdangnhap_1.setHorizontalAlignment(SwingConstants.CENTER);
		bt_chuyenformdangnhap_1.setForeground(new Color(255, 212, 58));
		bt_chuyenformdangnhap_1.setBackground(new Color(0, 28, 65));
		bt_chuyenformdangnhap_1.setBounds(117, 359, 120, 20);
		pn_dangki.add(bt_chuyenformdangnhap_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/icons/Freelogodesign-Gamestore-290.png")));
		lblNewLabel_1.setBackground(new Color(0,28,65));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(314, 183, 290, 290);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(305, 174, 310, 310);
		lblNewLabel.setBackground(new Color(255, 212, 58));
		lblNewLabel.setOpaque(true);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CHÀO MỪNG");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel_2.setBounds(290, 495, 334, 51);
		add(lblNewLabel_2);
	}
}

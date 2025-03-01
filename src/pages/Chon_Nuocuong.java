package pages;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Chon_Nuocuong extends JPanel{
	private QL_monan ql_monan;

	public Chon_Nuocuong(QL_monan ql_monan1) {
		this.ql_monan = ql_monan1;
		
		setBackground(new Color(27, 79, 147));
		setBounds(10, 226, 802, 575);
		setLayout(null);
		
		JLabel bt_tradao = new JLabel("25.000 VNĐ");
		bt_tradao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_tradao.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_tradao.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("13", "Trà đào", 25000, ql_monan);
			}
		});
		bt_tradao.setOpaque(true);
		bt_tradao.setHorizontalAlignment(SwingConstants.CENTER);
		bt_tradao.setForeground(Color.BLACK);
		bt_tradao.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_tradao.setBackground(new Color(255, 212, 58));
		bt_tradao.setBounds(63, 154, 137, 25);
		add(bt_tradao);
		
		JLabel anh_tradao = new JLabel("");
		anh_tradao.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/tradao137.jpg")));
		anh_tradao.setBounds(63, 10, 137, 137);
		add(anh_tradao);
		
		JLabel lb_tradao = new JLabel("");
		lb_tradao.setOpaque(true);
		lb_tradao.setBackground(new Color(0, 28, 65));
		lb_tradao.setBounds(53, 0, 157, 182);
		add(lb_tradao);
		
		JLabel bt_travai = new JLabel("25.000 VNĐ");
		bt_travai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_travai.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_travai.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("14", "Trà vải", 25000, ql_monan);
			}
		});
		bt_travai.setOpaque(true);
		bt_travai.setHorizontalAlignment(SwingConstants.CENTER);
		bt_travai.setForeground(Color.BLACK);
		bt_travai.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_travai.setBackground(new Color(255, 212, 58));
		bt_travai.setBounds(243, 154, 137, 25);
		add(bt_travai);
		
		JLabel anh_travai = new JLabel("");
		anh_travai.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/travai137.jpg")));
		anh_travai.setBounds(243, 10, 137, 137);
		add(anh_travai);
		
		JLabel lb_travai = new JLabel("");
		lb_travai.setOpaque(true);
		lb_travai.setBackground(new Color(0, 28, 65));
		lb_travai.setBounds(233, 0, 157, 182);
		add(lb_travai);
		
		JLabel bt_travietquat = new JLabel("25.000 VNĐ");
		bt_travietquat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_travietquat.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_travietquat.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("15", "Trà việt quất", 25000, ql_monan);
			}
		});
		bt_travietquat.setOpaque(true);
		bt_travietquat.setHorizontalAlignment(SwingConstants.CENTER);
		bt_travietquat.setForeground(Color.BLACK);
		bt_travietquat.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_travietquat.setBackground(new Color(255, 212, 58));
		bt_travietquat.setBounds(422, 154, 137, 25);
		add(bt_travietquat);
		
		JLabel anh_travietquat = new JLabel("");
		anh_travietquat.setBackground(new Color(255, 255, 255));
		anh_travietquat.setOpaque(true);
		anh_travietquat.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/travietquat137.png")));
		anh_travietquat.setBounds(422, 10, 137, 137);
		add(anh_travietquat);
		
		JLabel lb_traviettquat = new JLabel("");
		lb_traviettquat.setOpaque(true);
		lb_traviettquat.setBackground(new Color(0, 28, 65));
		lb_traviettquat.setBounds(412, 0, 157, 182);
		add(lb_traviettquat);
		
		JLabel bt_trachanh = new JLabel("20.000 VNĐ");
		bt_trachanh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_trachanh.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_trachanh.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("16", "Trà chanh", 20000, ql_monan);
			}
		});
		bt_trachanh.setOpaque(true);
		bt_trachanh.setHorizontalAlignment(SwingConstants.CENTER);
		bt_trachanh.setForeground(Color.BLACK);
		bt_trachanh.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_trachanh.setBackground(new Color(255, 212, 58));
		bt_trachanh.setBounds(603, 154, 137, 25);
		add(bt_trachanh);
		
		JLabel anh_trachanh = new JLabel("");
		anh_trachanh.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/reachanh137.jpg")));
		anh_trachanh.setBounds(603, 10, 137, 137);
		add(anh_trachanh);
		
		JLabel lb_trachanh = new JLabel("");
		lb_trachanh.setOpaque(true);
		lb_trachanh.setBackground(new Color(0, 28, 65));
		lb_trachanh.setBounds(593, 0, 157, 182);
		add(lb_trachanh);
		
		JLabel bt_tradau = new JLabel("25.000 VNĐ");
		bt_tradau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_tradau.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_tradau.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("17", "Trà dâu", 25000, ql_monan);
			}
		});
		bt_tradau.setOpaque(true);
		bt_tradau.setHorizontalAlignment(SwingConstants.CENTER);
		bt_tradau.setForeground(Color.BLACK);
		bt_tradau.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_tradau.setBackground(new Color(255, 212, 58));
		bt_tradau.setBounds(63, 344, 137, 25);
		add(bt_tradau);
		
		JLabel anh_tradau = new JLabel("");
		anh_tradau.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/readau137.png")));
		anh_tradau.setBounds(63, 200, 137, 137);
		add(anh_tradau);
		
		JLabel lb_tradau = new JLabel("");
		lb_tradau.setOpaque(true);
		lb_tradau.setBackground(new Color(0, 28, 65));
		lb_tradau.setBounds(53, 190, 157, 182);
		add(lb_tradau);
		
		JLabel bt_trasua = new JLabel("25.000 VNĐ");
		bt_trasua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_trasua.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_trasua.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("18", "Trà sữa", 25000, ql_monan);
			}
		});
		bt_trasua.setOpaque(true);
		bt_trasua.setHorizontalAlignment(SwingConstants.CENTER);
		bt_trasua.setForeground(Color.BLACK);
		bt_trasua.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_trasua.setBackground(new Color(255, 212, 58));
		bt_trasua.setBounds(243, 344, 137, 25);
		add(bt_trasua);
		
		JLabel anh_trasua = new JLabel("");
		anh_trasua.setBackground(new Color(255, 255, 255));
		anh_trasua.setOpaque(true);
		anh_trasua.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/trasua137.png")));
		anh_trasua.setBounds(243, 200, 137, 137);
		add(anh_trasua);
		
		JLabel lb_trasua = new JLabel("");
		lb_trasua.setOpaque(true);
		lb_trasua.setBackground(new Color(0, 28, 65));
		lb_trasua.setBounds(233, 190, 157, 182);
		add(lb_trasua);
		
		JLabel bt_0do = new JLabel("15.000 VNĐ");
		bt_0do.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_0do.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_0do.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("19", "0 độ", 15000, ql_monan);
			}
		});
		bt_0do.setOpaque(true);
		bt_0do.setHorizontalAlignment(SwingConstants.CENTER);
		bt_0do.setForeground(Color.BLACK);
		bt_0do.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_0do.setBackground(new Color(255, 212, 58));
		bt_0do.setBounds(422, 344, 137, 25);
		add(bt_0do);
		
		JLabel anh_0do = new JLabel("");
		anh_0do.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/0do137.jpg")));
		anh_0do.setBounds(422, 200, 137, 137);
		add(anh_0do);
		
		JLabel lb_0do = new JLabel("");
		lb_0do.setOpaque(true);
		lb_0do.setBackground(new Color(0, 28, 65));
		lb_0do.setBounds(412, 190, 157, 182);
		add(lb_0do);
		
		JLabel bt_247 = new JLabel("15.000 VNĐ");
		bt_247.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_247.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_247.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("20", "247", 15000, ql_monan);
			}
		});
		bt_247.setOpaque(true);
		bt_247.setHorizontalAlignment(SwingConstants.CENTER);
		bt_247.setForeground(Color.BLACK);
		bt_247.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_247.setBackground(new Color(255, 212, 58));
		bt_247.setBounds(603, 344, 137, 25);
		add(bt_247);
		
		JLabel anh_247 = new JLabel("");
		anh_247.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/247_137.jpg")));
		anh_247.setBounds(603, 200, 137, 137);
		add(anh_247);
		
		JLabel lb_247 = new JLabel("");
		lb_247.setOpaque(true);
		lb_247.setBackground(new Color(0, 28, 65));
		lb_247.setBounds(593, 190, 157, 182);
		add(lb_247);
		
		JLabel bt_coca = new JLabel("10.000 VNĐ");
		bt_coca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_coca.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_coca.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("21", "Coca", 10000, ql_monan);
			}
		});
		bt_coca.setOpaque(true);
		bt_coca.setHorizontalAlignment(SwingConstants.CENTER);
		bt_coca.setForeground(Color.BLACK);
		bt_coca.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_coca.setBackground(new Color(255, 212, 58));
		bt_coca.setBounds(63, 534, 137, 25);
		add(bt_coca);
		
		JLabel anh_coca = new JLabel("");
		anh_coca.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/coca137.jpg")));
		anh_coca.setBounds(63, 390, 137, 137);
		add(anh_coca);
		
		JLabel lb_coca = new JLabel("");
		lb_coca.setOpaque(true);
		lb_coca.setBackground(new Color(0, 28, 65));
		lb_coca.setBounds(53, 380, 157, 184);
		add(lb_coca);
		
		JLabel bt_numberone = new JLabel("15.000 VNĐ");
		bt_numberone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_numberone.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_numberone.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("22", "Numberone", 15000, ql_monan);
			}
		});
		bt_numberone.setOpaque(true);
		bt_numberone.setHorizontalAlignment(SwingConstants.CENTER);
		bt_numberone.setForeground(Color.BLACK);
		bt_numberone.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_numberone.setBackground(new Color(255, 212, 58));
		bt_numberone.setBounds(243, 534, 137, 25);
		add(bt_numberone);
		
		JLabel anh_numberone = new JLabel("");
		anh_numberone.setBackground(new Color(255, 255, 255));
		anh_numberone.setOpaque(true);
		anh_numberone.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/numberone137.png")));
		anh_numberone.setBounds(243, 390, 137, 137);
		add(anh_numberone);
		
		JLabel lb_numberone = new JLabel("");
		lb_numberone.setOpaque(true);
		lb_numberone.setBackground(new Color(0, 28, 65));
		lb_numberone.setBounds(233, 380, 157, 184);
		add(lb_numberone);
		
		JLabel bt_pepsi = new JLabel("10.000 VNĐ");
		bt_pepsi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_pepsi.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_pepsi.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("23", "Pepsi", 10000, ql_monan);
			}
		});
		bt_pepsi.setOpaque(true);
		bt_pepsi.setHorizontalAlignment(SwingConstants.CENTER);
		bt_pepsi.setForeground(Color.BLACK);
		bt_pepsi.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_pepsi.setBackground(new Color(255, 212, 58));
		bt_pepsi.setBounds(422, 534, 137, 25);
		add(bt_pepsi);
		
		JLabel anh_pepsi = new JLabel("");
		anh_pepsi.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/pepsi137.jpg")));
		anh_pepsi.setBounds(422, 390, 137, 137);
		add(anh_pepsi);
		
		JLabel lb_pepsi = new JLabel("");
		lb_pepsi.setOpaque(true);
		lb_pepsi.setBackground(new Color(0, 28, 65));
		lb_pepsi.setBounds(412, 380, 157, 184);
		add(lb_pepsi);
		
		JLabel bt_sting = new JLabel("15.000 VNĐ");
		bt_sting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_sting.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_sting.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("24", "Sting", 15000, ql_monan);
			}
		});
		bt_sting.setOpaque(true);
		bt_sting.setHorizontalAlignment(SwingConstants.CENTER);
		bt_sting.setForeground(Color.BLACK);
		bt_sting.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_sting.setBackground(new Color(255, 212, 58));
		bt_sting.setBounds(603, 534, 137, 25);
		add(bt_sting);
		
		JLabel anh_sting = new JLabel("");
		anh_sting.setIcon(new ImageIcon(Chon_Nuocuong.class.getResource("/images/drinks/sting137.jpeg")));
		anh_sting.setBounds(603, 390, 137, 137);
		add(anh_sting);
		
		JLabel lb_sting = new JLabel("");
		lb_sting.setOpaque(true);
		lb_sting.setBackground(new Color(0, 28, 65));
		lb_sting.setBounds(593, 380, 157, 184);
		add(lb_sting);
		
	}
	
	private void addToOrder(String id, String ten, int gia, QL_monan ql_monan) {
	    DefaultTableModel tableModel = (DefaultTableModel) ql_monan.bangmonan.getModel();
	    boolean found = false;

	    for (int i = 0; i < tableModel.getRowCount(); i++) {
	        if (tableModel.getValueAt(i, 0).toString().equals(id)) {
	            int currentQuantity = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
	            tableModel.setValueAt(currentQuantity + 1, i, 3);
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        tableModel.addRow(new Object[]{id, ten, gia, 1});
	    }

	    ql_monan.updateTotalAmount();
	}

}

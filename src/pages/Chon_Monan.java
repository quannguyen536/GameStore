package pages;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Chon_Monan extends JPanel{
	private JLabel bt_banhtrangtron;
	private JLabel bt_cavienchien;
	private JLabel bt_comchay;
	private JLabel bt_comtam;
	private JLabel bt_hamburger;
	private JLabel bt_phomaique;
	private JLabel bt_mitomtrung;
	private JLabel bt_mitomxao;
	private JLabel bt_sushi;
	private JLabel bt_theoleo;
	private JLabel bt_tokboki;
	private JLabel bt_xucxich;
	private QL_monan ql_monan;

	public Chon_Monan(QL_monan ql_monan) {	
		this.ql_monan = ql_monan;
		
		setBackground(new Color(27, 79, 147));
		setBounds(10, 226, 802, 575);
		setLayout(null);
		
		
		
		JLabel anh_banhtrangtron = new JLabel("");
		anh_banhtrangtron.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/banhtrangtron137.jpg")));
		anh_banhtrangtron.setBounds(61, 10, 137, 137);
		add(anh_banhtrangtron);
		
		bt_banhtrangtron = new JLabel("25.000 VNĐ");
		bt_banhtrangtron.addMouseListener(new MouseAdapter() {
			private Object qlMonAn;
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_banhtrangtron.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_banhtrangtron.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("1", "Bánh Tráng Trộn", 25000, ql_monan);
			
			}
		});
		bt_banhtrangtron.setHorizontalAlignment(SwingConstants.CENTER);
		bt_banhtrangtron.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_banhtrangtron.setForeground(new Color(0, 0, 0));
		bt_banhtrangtron.setBackground(new Color(255,212,58));
		bt_banhtrangtron.setOpaque(true);
		bt_banhtrangtron.setBounds(61, 154, 137, 25);
		add(bt_banhtrangtron);
		
		
		JLabel lb_banhtrangtron = new JLabel("");
		lb_banhtrangtron.setBackground(new Color(0,28,65));
		lb_banhtrangtron.setOpaque(true);
		lb_banhtrangtron.setBounds(51, 0, 157, 182);
		add(lb_banhtrangtron);
		
		bt_cavienchien = new JLabel("35.000 VNĐ");
		bt_cavienchien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_cavienchien.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_cavienchien.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("2", "Cá viên chiên", 35000, ql_monan);
			}
		});
		bt_cavienchien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_cavienchien.setForeground(new Color(0, 0, 0));
		bt_cavienchien.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_cavienchien.setBackground(new Color(255,212,58));
		bt_cavienchien.setOpaque(true);
		bt_cavienchien.setBounds(241, 154, 137, 25);
		add(bt_cavienchien);
		
		JLabel anh_cavienchien = new JLabel("");
		anh_cavienchien.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/cavienchien137.jpg")));
		anh_cavienchien.setBounds(241, 10, 137, 137);
		add(anh_cavienchien);
		
		JLabel lb_cavienchien = new JLabel("");
		lb_cavienchien.setOpaque(true);
		lb_cavienchien.setBackground(new Color(0, 28, 65));
		lb_cavienchien.setBounds(231, 0, 157, 182);
		add(lb_cavienchien);
		
		bt_comchay = new JLabel("20.000 VNĐ");
		bt_comchay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_comchay.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_comchay.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("3", "Cơm cháy", 20000, ql_monan);
			}
		});
		bt_comchay.setHorizontalAlignment(SwingConstants.CENTER);
		bt_comchay.setForeground(new Color(0, 0, 0));
		bt_comchay.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_comchay.setBackground(new Color(255,212,58));
		bt_comchay.setOpaque(true);
		bt_comchay.setBounds(420, 154, 137, 25);
		add(bt_comchay);
		
		JLabel anh_comchay = new JLabel("");
		anh_comchay.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/comchay137.jpg")));
		anh_comchay.setBounds(420, 10, 137, 137);
		add(anh_comchay);
		
		JLabel lb_comchay = new JLabel("");
		lb_comchay.setOpaque(true);
		lb_comchay.setBackground(new Color(0, 28, 65));
		lb_comchay.setBounds(410, 0, 157, 182);
		add(lb_comchay);
		
		bt_comtam = new JLabel("25.000 VNĐ");
		bt_comtam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_comtam.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_comtam.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("4", "Cơm tấm", 25000, ql_monan);
			}
		});
		bt_comtam.setHorizontalAlignment(SwingConstants.CENTER);
		bt_comtam.setForeground(new Color(0, 0, 0));
		bt_comtam.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_comtam.setBackground(new Color(255,212,58));
		bt_comtam.setOpaque(true);
		bt_comtam.setBounds(601, 154, 137, 25);
		add(bt_comtam);
		
		JLabel anh_comtam = new JLabel("");
		anh_comtam.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/comtam137.jpg")));
		anh_comtam.setBounds(601, 10, 137, 137);
		add(anh_comtam);
		
		JLabel lb_comtam = new JLabel("");
		lb_comtam.setOpaque(true);
		lb_comtam.setBackground(new Color(0, 28, 65));
		lb_comtam.setBounds(591, 0, 157, 182);
		add(lb_comtam);
		
		bt_hamburger = new JLabel("20.000 VNĐ");
		bt_hamburger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_hamburger.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_hamburger.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("5", "Hamburger", 20000, ql_monan);
			}
		});
		bt_hamburger.setHorizontalAlignment(SwingConstants.CENTER);
		bt_hamburger.setForeground(new Color(0, 0, 0));
		bt_hamburger.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_hamburger.setBackground(new Color(255,212,58));
		bt_hamburger.setOpaque(true);
		bt_hamburger.setBounds(61, 344, 137, 25);
		add(bt_hamburger);
		
		JLabel anh_hamburger = new JLabel("");
		anh_hamburger.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/hamburger137.jpg")));
		anh_hamburger.setBounds(61, 200, 137, 137);
		add(anh_hamburger);
		
		JLabel lb_hamburger = new JLabel("");
		lb_hamburger.setOpaque(true);
		lb_hamburger.setBackground(new Color(0, 28, 65));
		lb_hamburger.setBounds(51, 190, 157, 182);
		add(lb_hamburger);
		
		bt_phomaique = new JLabel("35.000 VNĐ");
		bt_phomaique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_phomaique.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_phomaique.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("6", "Phô mai que", 35000, ql_monan);
			}
		});
		bt_phomaique.setHorizontalAlignment(SwingConstants.CENTER);
		bt_phomaique.setForeground(new Color(0, 0, 0));
		bt_phomaique.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_phomaique.setBackground(new Color(255,212,58));
		bt_phomaique.setOpaque(true);
		bt_phomaique.setBounds(601, 344, 137, 25);
		add(bt_phomaique);
		
		JLabel anh_phomaique = new JLabel("");
		anh_phomaique.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/phomaique137.jpg")));
		anh_phomaique.setBounds(601, 200, 137, 137);
		add(anh_phomaique);
		
		JLabel lb_phomaique = new JLabel("");
		lb_phomaique.setOpaque(true);
		lb_phomaique.setBackground(new Color(0, 28, 65));
		lb_phomaique.setBounds(591, 190, 157, 182);
		add(lb_phomaique);
		
		bt_mitomtrung = new JLabel("15.000 VNĐ");
		bt_mitomtrung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_mitomtrung.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_mitomtrung.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("7", "Mì tôm trứng", 15000, ql_monan);
			}
		});
		bt_mitomtrung.setHorizontalAlignment(SwingConstants.CENTER);
		bt_mitomtrung.setForeground(new Color(0, 0, 0));
		bt_mitomtrung.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_mitomtrung.setBackground(new Color(255,212,58));
		bt_mitomtrung.setOpaque(true);
		bt_mitomtrung.setBounds(241, 344, 137, 25);
		add(bt_mitomtrung);
		
		JLabel anh_mitomtrung = new JLabel("");
		anh_mitomtrung.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/mitomtrung137.jpg")));
		anh_mitomtrung.setBounds(241, 200, 137, 137);
		add(anh_mitomtrung);
		
		JLabel lb_mitomtrung = new JLabel("");
		lb_mitomtrung.setOpaque(true);
		lb_mitomtrung.setBackground(new Color(0, 28, 65));
		lb_mitomtrung.setBounds(231, 190, 157, 182);
		add(lb_mitomtrung);
		
		bt_mitomxao = new JLabel("15.000 VNĐ");
		bt_mitomxao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_mitomxao.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_mitomxao.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("8", "Mì tôm xào", 15000, ql_monan);
			}
		});
		bt_mitomxao.setHorizontalAlignment(SwingConstants.CENTER);
		bt_mitomxao.setForeground(new Color(0, 0, 0));
		bt_mitomxao.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_mitomxao.setBackground(new Color(255,212,58));
		bt_mitomxao.setOpaque(true);
		bt_mitomxao.setBounds(420, 344, 137, 25);
		add(bt_mitomxao);
		
		JLabel anh_mitomxao = new JLabel("");
		anh_mitomxao.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/mitomxao137.jpg")));
		anh_mitomxao.setBounds(420, 200, 137, 137);
		add(anh_mitomxao);
		
		JLabel lb_mitomxao = new JLabel("");
		lb_mitomxao.setOpaque(true);
		lb_mitomxao.setBackground(new Color(0, 28, 65));
		lb_mitomxao.setBounds(410, 190, 157, 182);
		add(lb_mitomxao);
		
		bt_sushi = new JLabel("40.000 VNĐ");
		bt_sushi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_sushi.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_sushi.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("9", "Sushi", 40000, ql_monan);
			}
		});
		bt_sushi.setHorizontalAlignment(SwingConstants.CENTER);
		bt_sushi.setForeground(new Color(0, 0, 0));
		bt_sushi.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_sushi.setBackground(new Color(255,212,58));
		bt_sushi.setOpaque(true);
		bt_sushi.setBounds(61, 534, 137, 25);
		add(bt_sushi);
		
		JLabel anh_sushi = new JLabel("");
		anh_sushi.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/sushi137.jpg")));
		anh_sushi.setBounds(61, 390, 137, 137);
		add(anh_sushi);
		
		JLabel lb_sushi = new JLabel("");
		lb_sushi.setOpaque(true);
		lb_sushi.setBackground(new Color(0, 28, 65));
		lb_sushi.setBounds(51, 380, 157, 184);
		add(lb_sushi);
		
		bt_theoleo = new JLabel("15.000 VNĐ");
		bt_theoleo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_theoleo.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_theoleo.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("10", "Thèo lèo", 15000, ql_monan);
			}
		});
		bt_theoleo.setHorizontalAlignment(SwingConstants.CENTER);
		bt_theoleo.setForeground(new Color(0, 0, 0));
		bt_theoleo.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_theoleo.setBackground(new Color(255,212,58));
		bt_theoleo.setOpaque(true);
		bt_theoleo.setBounds(241, 534, 137, 25);
		add(bt_theoleo);
		
		JLabel anh_theoleo = new JLabel("");
		anh_theoleo.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/theoleo137.jpg")));
		anh_theoleo.setBounds(241, 390, 137, 137);
		add(anh_theoleo);
		
		JLabel lb_theoleo = new JLabel("");
		lb_theoleo.setOpaque(true);
		lb_theoleo.setBackground(new Color(0, 28, 65));
		lb_theoleo.setBounds(231, 380, 157, 184);
		add(lb_theoleo);
		
		bt_tokboki = new JLabel("25.000 VNĐ");
		bt_tokboki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_tokboki.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_tokboki.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("11", "Tokboki", 25000, ql_monan);
			}
		});
		bt_tokboki.setHorizontalAlignment(SwingConstants.CENTER);
		bt_tokboki.setForeground(new Color(0, 0, 0));
		bt_tokboki.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_tokboki.setBackground(new Color(255,212,58));
		bt_tokboki.setOpaque(true);
		bt_tokboki.setBounds(420, 534, 137, 25);
		add(bt_tokboki);
		
		JLabel anh_tokboki = new JLabel("");
		anh_tokboki.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/toboki137.jpg")));
		anh_tokboki.setBounds(420, 390, 137, 137);
		add(anh_tokboki);
		
		JLabel lb_tokboki = new JLabel("");
		lb_tokboki.setOpaque(true);
		lb_tokboki.setBackground(new Color(0, 28, 65));
		lb_tokboki.setBounds(410, 380, 157, 184);
		add(lb_tokboki);
		
		bt_xucxich = new JLabel("15.000 VNĐ");
		bt_xucxich.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_xucxich.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_xucxich.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addToOrder("12", "Xúc xích", 15000, ql_monan);
			}
		});
		bt_xucxich.setHorizontalAlignment(SwingConstants.CENTER);
		bt_xucxich.setForeground(new Color(0, 0, 0));
		bt_xucxich.setFont(new Font("Tahoma", Font.BOLD, 11));
		bt_xucxich.setBackground(new Color(255,212,58));
		bt_xucxich.setOpaque(true);
		bt_xucxich.setBounds(601, 534, 137, 25);
		add(bt_xucxich);
		
		JLabel anh_xucxich = new JLabel("");
		anh_xucxich.setIcon(new ImageIcon(Chon_Monan.class.getResource("/images/foods/xucxich137.jpg")));
		anh_xucxich.setBounds(601, 390, 137, 137);
		add(anh_xucxich);
		
		JLabel lb_xucxich = new JLabel("");
		lb_xucxich.setOpaque(true);
		lb_xucxich.setBackground(new Color(0, 28, 65));
		lb_xucxich.setBounds(591, 380, 157, 184);
		add(lb_xucxich);
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

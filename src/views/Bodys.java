package views;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

import pages.QL_doanhthu;
import pages.QL_khachhang;
import pages.QL_maytinh;
import pages.QL_monan;
import pages.QL_nhanvien;

public class Bodys extends JPanel{
	private CardLayout cardLayout;
	private QL_nhanvien nhanvien;
	private QL_khachhang khachhang;
	private QL_monan monan;
	private QL_maytinh maytinh;
	private QL_doanhthu doanhthu;
	public Bodys() {
		setSize(1170, 900);		
		cardLayout = new CardLayout(0, 0);
		setLayout(cardLayout);
		
	  
		
		nhanvien = new QL_nhanvien();
		add(nhanvien, "nhanvien");
		
		khachhang = new QL_khachhang();
		add(khachhang, "khachhang");
		
		monan = new QL_monan();
		add(monan, "monan");
		
		maytinh = new QL_maytinh(khachhang);
		add(maytinh, "maytinh");
		
		
		doanhthu = new QL_doanhthu();
		add(doanhthu, "doanhthu");
		
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	
	public QL_nhanvien getNhanvien() {
		return nhanvien;
	}

	public QL_khachhang getKhachhang() {
		return khachhang;
	}	

	public QL_monan getMonan() {
		return monan;
	}
	
	public QL_maytinh getMaytinh() {
		return maytinh;
	}
	

	public QL_doanhthu getDoanhthu() {
		return doanhthu;
	}

	
}

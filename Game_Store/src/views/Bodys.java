package views;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

import pages.QL_doanhthu;
import pages.QL_khachhang;
import pages.QL_maytinh;
import pages.QL_monan;
import pages.QL_nhanvien;
import pages.QL_quannet;
import pages.QL_thongke;
import pages.QL_uudai;

public class Bodys extends JPanel{
	private CardLayout cardLayout;
	private QL_quannet quannet;
	private QL_nhanvien nhanvien;
	private QL_khachhang khachhang;
	private QL_monan monan;
	private QL_maytinh maytinh;
	private QL_uudai uudai;
	private QL_doanhthu doanhthu;
	private QL_thongke thongke;

	public Bodys() {
		setSize(1170, 900);		
		cardLayout = new CardLayout(0, 0);
		setLayout(cardLayout);
		
	    quannet = new QL_quannet();
		add(quannet, "quannet");
		
		nhanvien = new QL_nhanvien();
		add(nhanvien, "nhanvien");
		
		khachhang = new QL_khachhang();
		add(khachhang, "khachhang");
		
		monan = new QL_monan();
		add(monan, "monan");
		
		maytinh = new QL_maytinh();
		add(maytinh, "maytinh");
		
		uudai = new QL_uudai();
		add(uudai, "uudai");
		
		doanhthu = new QL_doanhthu();
		add(doanhthu, "doanhthu");
		
		thongke = new QL_thongke();
		add(thongke, "thongke");
		
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public QL_quannet getQuannet() {
		return quannet;
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
	
	public QL_uudai getUudai() {
		return uudai;
	}	

	public QL_doanhthu getDoanhthu() {
		return doanhthu;
	}

	public QL_thongke getThongke() {
		return thongke;
	}
	
}

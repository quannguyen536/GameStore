package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import models.Models_BangHoadon;
import models.Models_Hoadon_monan;

public class DB_Xulihoadons {
	
	private final Connection conn;
	private static DB_Monans instance;
	
	public static DB_Monans getInstance() {
		if(instance == null) {
			instance = new DB_Monans();
		}
		return instance;
	}
	
	public DB_Xulihoadons() {
        this.conn = DatabaseConnection.getInstance().getConn();
	}
	
	private void saveInvoiceToDatabase(Models_BangHoadon hoadon) {
	    try (Connection conn = DatabaseConnection.getConnected()) {
	        // Lưu hóa đơn
	        String sqlInvoice = "INSERT INTO hoadon (MaKhachHang, tongtien, ngaytao) VALUES (?, ?, ?)";
	        PreparedStatement pstmtInvoice = conn.prepareStatement(sqlInvoice, Statement.RETURN_GENERATED_KEYS);

	        pstmtInvoice.setInt(1, hoadon.getKhachhang().getMakh());
	        pstmtInvoice.setDouble(2, hoadon.getTongtien());
	        pstmtInvoice.setTimestamp(3, new java.sql.Timestamp(hoadon.getNgaytao().getTime()));
	        pstmtInvoice.executeUpdate();

	        ResultSet rs = pstmtInvoice.getGeneratedKeys();
	        int invoiceId = 0;
	        if (rs.next()) {
	            invoiceId = rs.getInt(1);
	        }

	        // Lưu các món trong hóa đơn
	        String sqlItem = "INSERT INTO hoadon_monan (idhoadon, tenmonan, soluong, gia) VALUES (?, ?, ?, ?)";
	        PreparedStatement pstmtItem = conn.prepareStatement(sqlItem);
	        for (Models_Hoadon_monan monan : hoadon.getMonan()) {
	            pstmtItem.setInt(1, invoiceId);
	            pstmtItem.setString(2, monan.getTenmonan());
	            pstmtItem.setInt(3, monan.getSoluong());
	            pstmtItem.setDouble(4, monan.getGia());
	            pstmtItem.addBatch();
	        }
	        pstmtItem.executeBatch();

	        JOptionPane.showMessageDialog(null, "Hóa đơn đã được lưu vào cơ sở dữ liệu!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Lỗi khi lưu hóa đơn vào cơ sở dữ liệu!");
	    }
	}
	
	public boolean capnhatmonansaukhiorder(int idMonAn, int soLuongDat) {
	    String sql = "UPDATE monan SET sltonkho = sltonkho - ?, sldaban = sldaban + ? WHERE id = ? AND sltonkho >= ?";

	    try (Connection conn = DatabaseConnection.getConnected();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, soLuongDat);
	        pstmt.setInt(2, soLuongDat);
	        pstmt.setInt(3, idMonAn);
	        pstmt.setInt(4, soLuongDat);

	        int rowsUpdated = pstmt.executeUpdate();
	        return rowsUpdated > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	private void luuthongtinordermonan(int idhoadon, List<Models_Hoadon_monan> hoadon_monan) {
	    String sql = "INSERT INTO hoadon_monan (idhoadon, tenmonan, soluong, gia) VALUES (?, ?, ?, ?)";

	    try (Connection conn = DatabaseConnection.getConnected();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        for (Models_Hoadon_monan item : hoadon_monan) {
	            pstmt.setInt(1, idhoadon);
	            pstmt.setString(2, item.getTenmonan());
	            pstmt.setInt(3, item.getSoluong());
	            pstmt.setDouble(4, item.getGia());
	            pstmt.addBatch();
	        }

	        pstmt.executeBatch();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}

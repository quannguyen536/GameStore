package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Models_Doanhthu;
import models.Models_Donmua;


public class DBDoanhthus {
	private final Connection conn;
	private static DBDoanhthus instance;
	
	private final String SELECT_DONMUA = "SELECT donmua.id, monan.hinhanh, monan.tenmonan, khachhang.Ten, donmua.soluong, donmua.ngaymua\r\n"
			+ "FROM donmua JOIN khachhang ON donmua.makh = khachhang.MaKhachHang\r\n"
			+ "JOIN monan ON donmua.idmonan = monan.id ORDER BY donmua.id ASC";
	private final String SELECT_TIMKIEM_DONMUA = "SELECT donmua.id, monan.hinhanh, monan.tenmonan, khachhang.Ten, donmua.soluong, donmua.ngaymua\r\n"
			+ "FROM donmua JOIN khachhang ON donmua.makh = khachhang.MaKhachHang\r\n"
			+ "JOIN monan ON donmua.idmonan = monan.id "
			+ "WHERE donmua.ngaymua BETWEEN ? AND ?";
	private final String SELECT_GIAMONAN = "SELECT monan.gia FROM monan JOIN donmua ON donmua.idmonan =idmonan WHERE donmua.id = ?";
	private final String SELECT_THONGKE_DONMUA = "SELECT monan.dongia,  donmua.soluong \r\n"
			+ "FROM donmua JOIN monan ON donmua.idmonan = idmonan "
			+ "WHERE donmua.ngaymua BETWEEN ? AND ?";
	private final String INSERT_DONMUA = "INSERT INTO donmua (makh, idmonan, soluong, ngaymua) VALUES (?, ?, ?, ?)";
	
	public static DBDoanhthus getInstance() {
		if(instance == null) {
			instance = new DBDoanhthus();
		}
		return instance;
	}
	
	public DBDoanhthus() {
        this.conn = DatabaseConnection.getInstance().getConn();
	}
	
	public ArrayList<Models_Doanhthu> loadDonMua() {
		ArrayList<Models_Doanhthu> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_DONMUA);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int id = r.getInt(1);
            	Blob blob = r.getBlob(2);
                byte[] image =  blob.getBytes(1, (int) blob.length());
                String tenmonan = r.getString(3);
                String tenkh = r.getString(4);
                int soluong = r.getInt(5);
                Date ngaymua = r.getDate(6);
            	
//                Models_Doanhthu sach = new Models_Doanhthu(id, image, tenmonan, tenkh, soluong, ngaymua);
//            	list.add(sach);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public ArrayList<Models_Doanhthu> timkiem(Date from, Date to) {
		ArrayList<Models_Doanhthu> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_TIMKIEM_DONMUA);
            p.setDate(1, from);
            p.setDate(2, to);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int id = r.getInt(1);
            	Blob blob = r.getBlob(2);
                byte[] image =  blob.getBytes(1, (int) blob.length());
                String tenmonan = r.getString(3);
                String tenkh = r.getString(4);
                int soluong = r.getInt(5);
                Date ngaymua = r.getDate(6);
            	
//                Models_Doanhthu sach = new Models_Doanhthu(id, image, tenmonan, tenkh, soluong, ngaymua);
//            	list.add(sach);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public int thongkeDoanhThu(Date from, Date to) {
		int doanhthu = 0;
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_THONGKE_DONMUA);
            p.setDate(1, from);
            p.setDate(2, to);
            
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int dongia = r.getInt(1);
            	int soluong = r.getInt(2);
            	
            	doanhthu += dongia * soluong;
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return doanhthu;
	}
	
	public int thongkeSoLuong(Date from, Date to) {
		int soluong = 0;
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_THONGKE_DONMUA);
            p.setDate(1, from);
            p.setDate(2, to);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int sl = r.getInt(2);
            	
            	soluong += sl;
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return soluong;
	}
	
	public int giaSach(int maDonMua) {
		int gia = 0;
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_GIAMONAN);
            p.setInt(1, maDonMua);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	gia = r.getInt(1);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return gia;
	}
	
	public void themDonMua(Models_Donmua donmua) {
        try {
            PreparedStatement p = conn.prepareStatement(INSERT_DONMUA);
            p.setInt(1, donmua.getIdkh());
            p.setInt(2, donmua.getIdmonan());
            p.setInt(3, donmua.getSoluong());
            p.setDate(4, donmua.getNgaymua());
            p.execute();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Models_Doanhthu> loadKhachHangData() {
	    ArrayList<Models_Doanhthu> list = new ArrayList<>();
	    String query = "SELECT MaKhachHang, Ten, SDT, TongChi FROM khachhang";

	    try (Connection conn = DatabaseConnection.getConnected();
	         PreparedStatement ps = conn.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            list.add(new Models_Doanhthu(
	                rs.getInt("MaKhachHang"),
	                rs.getString("Ten"),
	                rs.getString("SDT"),
	                rs.getInt("TongChi")
	            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}

}

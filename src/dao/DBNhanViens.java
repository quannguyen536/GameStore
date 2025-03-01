package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.DBNhanViens;
import models.Models_Nhanvien;

public class DBNhanViens {
	 private final Connection conn;
	 private static DBNhanViens instance;
	 private final String INSERT_NHANVIEN = "INSERT INTO nhanvien (Ten, CCCD, GioiTinh, NgaySinh, SDT, ChucVu, Luong) VALUES (?,?,?,?,?,?,?)";
	 private final String SELECT_NHANVIEN = "SELECT MaNhanVien, Ten, CCCD, GioiTinh, NgaySinh, SDT, ChucVu, Luong FROM nhanvien";
		private final String UPDATE_THONGTIN = "UPDATE nhanvien SET Ten=?, CCCD=?, GioiTinh=?, NgaySinh=?, SDT=?, ChucVu=?, Luong=? WHERE MaNhanVien=?";
		private final String DELETE_NHANVIEN = "DELETE FROM nhanvien WHERE MaNhanVien=?";
		private final String SELECT_TIMKIEM_NHANVIEN = "SELECT MaNhanVien, Ten, CCCD, GioiTinh, NgaySinh, SDT, ChucVu, Luong FROM nhanvien WHERE Ten LIKE ?";
		
		public static DBNhanViens getInstance() {
			if(instance == null) {
				instance = new DBNhanViens();
			}
			return instance;
		}
		
		public DBNhanViens() {
	        this.conn = DatabaseConnection.getInstance().getConn();
		}
		
		public ArrayList<Models_Nhanvien> loadNhanVien() {
			ArrayList<Models_Nhanvien> list = new ArrayList<>();
	        try {
	            PreparedStatement p = conn.prepareStatement(SELECT_NHANVIEN);
	            ResultSet r = p.executeQuery();
	            while (r.next()) {
	            	int manv = r.getInt(1);
					String ten = r.getString(2);
					String cccd = r.getString(3);
					String gioitinh = r.getString(4);
					java.sql.Date ngaysinh = r.getDate(5);		
					String sdt = r.getString(6);
					String chucvu = r.getString(7);
					int luong = r.getInt(8);
	            	
					Models_Nhanvien nv = new Models_Nhanvien(manv, ten, cccd, gioitinh, ngaysinh, sdt, chucvu, luong);
	            	list.add(nv);
	            }
	            r.close();
	            p.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return list;
		}
		
		public Models_Nhanvien themNhanVien(Models_Nhanvien nhanVien) {
	        try {
	            PreparedStatement p = conn.prepareStatement(INSERT_NHANVIEN, PreparedStatement.RETURN_GENERATED_KEYS);
	            p.setString(1, nhanVien.getTennv());
	            p.setString(2, nhanVien.getCccd());
	            p.setString(3, nhanVien.getGioitinh());
	            p.setDate(4, nhanVien.getNgaysinh());
	            p.setString(5, nhanVien.getSdt());
	            p.setString(6, nhanVien.getChucvu());
	            p.setInt(7, nhanVien.getLuong());
	                        
	            p.execute();
	            ResultSet r = p.getGeneratedKeys();
	            r.first();
	            int manv = r.getInt(1);
	            nhanVien.setManv(manv);
	            p.close();
	            r.close();
	            
	            JOptionPane.showMessageDialog(null, "Đã thêm nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	          } catch (SQLException e) {
	          	e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	          }
	        return nhanVien;
		}
		
		public Models_Nhanvien themNhanVien2(Models_Nhanvien nhanVien) {
	        try {
	            PreparedStatement p = conn.prepareStatement(INSERT_NHANVIEN, PreparedStatement.RETURN_GENERATED_KEYS);
	            p.setString(1, nhanVien.getTennv());
	            p.setString(2, nhanVien.getCccd());
	            p.setString(3, nhanVien.getGioitinh());
	            p.setDate(4, nhanVien.getNgaysinh());
	            p.setString(5, nhanVien.getSdt());
	            p.setString(6, nhanVien.getChucvu());
	            p.setInt(7, nhanVien.getLuong());
	                        
	            p.execute();
	            ResultSet r = p.getGeneratedKeys();
	            r.first();
	            int manv = r.getInt(1);
	            nhanVien.setManv(manv);
//	            DBTaikhoan.getInstance().updateMaNhanVien(manv);
	            p.close();
	            r.close();
	            
	          } catch (SQLException e) {
	          	e.printStackTrace();
	          }
	        return nhanVien;
		}
		
		public Models_Nhanvien suaThongTin(Models_Nhanvien nhanVien) {
	        try {
	            PreparedStatement p = conn.prepareStatement(UPDATE_THONGTIN);
	            p.setString(1, nhanVien.getTennv());
	            p.setString(2, nhanVien.getCccd());
	            p.setString(3, nhanVien.getGioitinh());
	            p.setDate(4, nhanVien.getNgaysinh());
	            p.setString(5, nhanVien.getSdt());
	            p.setString(6, nhanVien.getChucvu());
	            p.setInt(7, nhanVien.getLuong());
	            p.setInt(8, nhanVien.getManv());
	                        
	            p.execute();
	            p.close();
	            
	            JOptionPane.showMessageDialog(null, "Đã cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	          } catch (SQLException e) {
	          	e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Cập nhật thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	          }
	        return nhanVien;
		}
		
		public void xoaNhanVien(int maNhanVien) {
	        try {
	            PreparedStatement p = conn.prepareStatement(DELETE_NHANVIEN);
	            p.setInt(1, maNhanVien);
	                        
	            p.execute();
	            p.close();
	            
	            JOptionPane.showMessageDialog(null, "Đã xóa nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	          } catch (SQLException e) {
	          	e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Xóa nhân viên thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	          }
		}
		
		public ArrayList<Models_Nhanvien> timkiem(String name) {
			ArrayList<Models_Nhanvien> list = new ArrayList<>();
	        try {
	            PreparedStatement p = conn.prepareStatement(SELECT_TIMKIEM_NHANVIEN);
	            p.setString(1, name);
	            ResultSet r = p.executeQuery();
	            while (r.next()) {
	            	int manv = r.getInt(1);
					String ten = r.getString(2);
					String cccd = r.getString(3);
					String gioitinh = r.getString(4);
					java.sql.Date ngaysinh = r.getDate(5);		
					String sdt = r.getString(6);
					String chucvu = r.getString(7);
					int luong = r.getInt(8);
	            	
					Models_Nhanvien nv = new Models_Nhanvien(manv, ten, cccd, gioitinh, ngaysinh, sdt, chucvu, luong);
	            	list.add(nv);
	            }
	            r.close();
	            p.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return list;
		}
}

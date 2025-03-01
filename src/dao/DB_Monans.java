package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Models_BangHoadon;
import models.Models_Hoadon_monan;
import models.Models_Monan;


public class DB_Monans {
	private final Connection conn;
	private static DB_Monans instance;
	
	private final String INSERT_FOOD= "INSERT INTO monan (tenmonan, loaimonan, sltonkho, sldaban, dongia, hinhanh) VALUES (?,?,?,?,?,?)";
	private final String SELECT_FOOD = "SELECT id, tenmonan, loaimonan, sltonkho, sldaban, dongia, hinhanh FROM monan";
	private final String UPDATE_THONGTIN = "UPDATE monan SET tenmonan=?, loaimonan=?, sltonkho=?, sldaban=?, dongia=?, hinhanh=? WHERE id=?";
	private final String DELETE_FOOD = "DELETE FROM monan WHERE id=?";
	private final String SELECT_IMAGE = "SELECT hinhanh FROM monan WHERE id=?";
	private final String SELECT_TIMKIEM_FOOD = "SELECT id, tenmonan, loaimonan, sltonkho, sldaban, dongia FROM monan WHERE tenmonan LIKE ?";
	private final String UPDATE_SOLUONG = "UPDATE monan SET sltonkho=?, sldaban=? WHERE id=?";
	private final String SELECT_TIMKIEM_MAFOOD = "SELECT id, tenmonan, loaimonan, sltonkho, sldaban, dongia FROM monan WHERE id=?";
	
	public static DB_Monans getInstance() {
		if(instance == null) {
			instance = new DB_Monans();
		}
		return instance;
	}
	
	public DB_Monans() {
        this.conn = DatabaseConnection.getInstance().getConn();
	}
	
	public ArrayList<Models_Monan> loadfood() {
		ArrayList<Models_Monan> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_FOOD);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int id = r.getInt(1);
            	String tenmonan = r.getString(2);
            	String loaimonan = r.getString(3);
            	int sltonkho = r.getInt(4);
            	int sldaban = r.getInt(5);
            	int dongia = r.getInt(6);
                Blob blob = r.getBlob(7);
                byte[] hinhanh = blob.getBytes(1, (int) blob.length());
            	
                Models_Monan food = new Models_Monan(id, tenmonan, loaimonan, sltonkho, sldaban, dongia, hinhanh) ;
            	list.add(food);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public Models_Monan themfood(Models_Monan food) {
        try {
            PreparedStatement p = conn.prepareStatement(INSERT_FOOD, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setString(1, food.getTenmonan());
            p.setString(2, food.getLoaimonan());
            p.setInt(3, food.getSltonkho());
            p.setInt(4, food.getSldaban());
            p.setInt(5, food.getGia());
            p.setBytes(6, food.getHinhanh());
                        
            p.execute();
            ResultSet r = p.getGeneratedKeys();
            r.first();
            int id = r.getInt(1);
            food.setId(id);
            p.close();
            r.close();
            
            JOptionPane.showMessageDialog(null, "Đã thêm sản phẩm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          } catch (SQLException e) {
          	e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm sản phẩm thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          }
        return food;
	}
	
	public Models_Monan suaThongTin(Models_Monan food) {
        try {
            PreparedStatement p = conn.prepareStatement(UPDATE_THONGTIN);
            p.setString(1, food.getTenmonan());
            p.setString(2, food.getLoaimonan());
            p.setInt(3, food.getSltonkho());
            p.setInt(4, food.getSldaban());
            p.setInt(5, food.getGia());
            p.setInt(6, food.getId());
                        
            p.execute();
            p.close();
            
            JOptionPane.showMessageDialog(null, "Đã cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          } catch (SQLException e) {
          	e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          }
        return food;
	}
	
	public void xoafood(int id) {
        try {
            PreparedStatement p = conn.prepareStatement(DELETE_FOOD);
            p.setInt(1, id);
                        
            p.execute();
            p.close();
            
            JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          } catch (SQLException e) {
          	e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa sản phẩm thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          }
	}
	
	public byte[] getImage(int id) {
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_IMAGE);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Blob blob = r.getBlob(1);
                return blob.getBytes(1, (int) blob.length());
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
	public ArrayList<Models_Monan> locPhone(String dieukien) {
		ArrayList<Models_Monan> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_FOOD + " WHERE " + dieukien);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int id = r.getInt(1);
            	String tenmonan = r.getString(2);
            	String loaimonan = r.getString(3);
            	int sltonkho = r.getInt(4);
            	int sldaban = r.getInt(5);
            	int dongia = r.getInt(6);
            	
            	Models_Monan food = new Models_Monan(id, tenmonan, loaimonan, sltonkho, sldaban, dongia, null);
            	list.add(food);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public ArrayList<Models_Monan> timkiem(String ten) {
		ArrayList<Models_Monan> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_TIMKIEM_FOOD);
            p.setString(1, ten);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int id = r.getInt(1);
            	String tenmonan = r.getString(2);
            	String loaimonan = r.getString(3);
            	int sltonkho = r.getInt(4);
            	int sldaban = r.getInt(5);
            	int dongia = r.getInt(6);
            	
            	Models_Monan food = new Models_Monan(id, tenmonan, loaimonan, sltonkho, sldaban, dongia, null);
            	list.add(food);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public Models_Monan timkiemMaSP(int id) {
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_TIMKIEM_MAFOOD);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int id1 = r.getInt(1);
            	String tenmonan = r.getString(2);
            	String loaimonan = r.getString(3);
            	int sltonkho = r.getInt(4);
            	int sldaban = r.getInt(5);
            	int dongia = r.getInt(6);
            	
            	Models_Monan food = new Models_Monan(id1, tenmonan, loaimonan, sltonkho, sldaban, dongia, null);
				return food;
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}
	
	public Models_Monan updateSoLuong(int ma, int soluong) {
		Models_Monan food = timkiemMaSP(ma);
		int sltonkho = food.getSltonkho();
		int sldaban = food.getSldaban();
        try {
            PreparedStatement p = conn.prepareStatement(UPDATE_SOLUONG);
            p.setInt(1, sltonkho-soluong);
            p.setInt(2, sldaban+soluong);
            p.setInt(3, ma);
                        
            p.execute();
            p.close();
         } catch (SQLException e) {
          	e.printStackTrace();
          }
        return food;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import models.Models_Khachhang;
import models.Models_Nhanvien;





public class DB_Khachhangs {
	private final Connection conn;
	private static DB_Khachhangs instance;
	
	private final String INSERT_THANHVIEN = "INSERT INTO khachhang (Ten, SDT, TongChi, DiemTichLuy, HangThanhVien) VALUES (?,?,?,?,?)";
	private final String SELECT_THANHVIEN = "SELECT MaKhachHang, Ten, SDT, TongChi, DiemTichLuy, HangThanhVien FROM khachhang";
	private final String UPDATE_THONGTIN = "UPDATE khachhang SET Ten=?, SDT=?, TongChi=?, DiemTichLuy=?, HangThanhVien=? WHERE MaKhachHang=?";
	private final String DELETE_THANHVIEN = "DELETE FROM khachhang WHERE MaKhachHang=?";
	private final String SELECT_TIMKIEM_MAKH = "SELECT MaKhachHang, Ten, SDT, TongChi, DiemTichLuy, HangThanhVien FROM khachhang WHERE MaKhachHang=?";
	private final String SELECT_TIMKIEM_SDT = "SELECT MaKhachHang, Ten, SDT, TongChi, DiemTichLuy, HangThanhVien FROM khachhang  WHERE SDT LIKE ?";
	private final String SELECT_TRACUU_SDT = "SELECT MaKhachHang, Ten, SDT, TongChi, DiemTichLuy, HangThanhVien FROM khachhang  WHERE SDT=?";
	private final String SELECT_TIMKIEM_KH = "SELECT MaKhachHang, Ten, SDT, TongChi, DiemTichLuy, HangThanhVien FROM khachhang WHERE Ten LIKE ?";
	
	public static DB_Khachhangs getInstance() {
		if(instance == null) {
			instance = new DB_Khachhangs();
		}
		return instance;
	}
	
	public DB_Khachhangs() {
        this.conn = DatabaseConnection.getInstance().getConn();
	}
	
	public ArrayList<Models_Khachhang> loadThanhVien() {
		ArrayList<Models_Khachhang> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_THANHVIEN);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int makh = r.getInt(1);
            	String ten = r.getString(2);
            	String sdt = r.getString(3);
            	int tongchi = r.getInt(4);
            	int diem = r.getInt(5);
            	String hang = r.getString(6);
            	
            	Models_Khachhang tv = new Models_Khachhang(makh, ten, sdt, tongchi, diem, hang);
            	list.add(tv);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public Models_Khachhang themThanhVien(Models_Khachhang thanhVien) {
        try {
            PreparedStatement p = conn.prepareStatement(INSERT_THANHVIEN, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setString(1, thanhVien.getTenkh());
            p.setString(2, thanhVien.getSdt());
            p.setInt(3, thanhVien.getTongchi());
            p.setInt(4, thanhVien.getDiemtichluy());
            p.setString(5, thanhVien.getHang());
                        
            p.execute();
            ResultSet r = p.getGeneratedKeys();
            r.first();
            int makh = r.getInt(1);
            thanhVien.setMakh(makh);
            p.close();
            r.close();
            
            JOptionPane.showMessageDialog(null, "Đã thêm thành viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          } catch (SQLException e) {
          	e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Thêm thành viên thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          }
        return thanhVien;
	}
	
	public Models_Khachhang themThanhVien2(Models_Khachhang thanhVien) {
        try {
            PreparedStatement p = conn.prepareStatement(INSERT_THANHVIEN, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setString(1, thanhVien.getTenkh());
            p.setString(2, thanhVien.getSdt());
            p.setInt(3, thanhVien.getTongchi());
            p.setInt(4, thanhVien.getDiemtichluy());
            p.setString(5, thanhVien.getHang());
                        
            p.execute();
            ResultSet r = p.getGeneratedKeys();
            r.first();
            int makh = r.getInt(1);
            thanhVien.setMakh(makh);
            p.close();
            r.close();
            
          } catch (SQLException e) {
          	e.printStackTrace();
          }
        return thanhVien;
	}
	
	public Models_Khachhang suaThongTin(Models_Khachhang khachHang) {
        try {
            PreparedStatement p = conn.prepareStatement(UPDATE_THONGTIN);
            p.setString(1, khachHang.getTenkh());
            p.setString(2, khachHang.getSdt());
            p.setInt(3, khachHang.getTongchi());
            p.setInt(4, khachHang.getDiemtichluy());
            p.setString(5, khachHang.getHang());
            p.setInt(6, khachHang.getMakh());
                        
            p.execute();
            p.close();
            
            JOptionPane.showMessageDialog(null, "Đã cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          } catch (SQLException e) {
          	e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          }
        return khachHang;
	}
	
	public Models_Khachhang suaThongTin2(Models_Khachhang khachHang) {
        try {
            PreparedStatement p = conn.prepareStatement(UPDATE_THONGTIN);
            p.setString(1, khachHang.getTenkh());
            p.setString(2, khachHang.getSdt());
            p.setInt(3, khachHang.getTongchi());
            p.setInt(4, khachHang.getDiemtichluy());
            p.setString(5, khachHang.getHang());
            p.setInt(6, khachHang.getMakh());
                        
            p.execute();
            p.close();
            
          } catch (SQLException e) {
          	e.printStackTrace();
          }
        return khachHang;
	}
	
	public void xoaThanhVien(int maKhachHang) {
        try {
            PreparedStatement p = conn.prepareStatement(DELETE_THANHVIEN);
            p.setInt(1, maKhachHang);
                        
            p.execute();
            p.close();
            
            JOptionPane.showMessageDialog(null, "Đã xóa thành viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          } catch (SQLException e) {
          	e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa thành viên thất bại XXX", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
          }
	}
	
	public ArrayList<Models_Khachhang> locThanhVien(String dieukien) {
		ArrayList<Models_Khachhang> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_THANHVIEN + " WHERE " + dieukien);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int makh = r.getInt(1);
            	String ten = r.getString(2);
            	String sdt = r.getString(3);
            	int tongchi = r.getInt(4);
            	int diem = r.getInt(5);
            	String hang = r.getString(6);
            	
            	Models_Khachhang tv = new Models_Khachhang(makh, ten, sdt, tongchi, diem, hang);
            	list.add(tv);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public ArrayList<Models_Khachhang> timkiemMaKH(int ma) {
		ArrayList<Models_Khachhang> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_TIMKIEM_MAKH);
            p.setInt(1, ma);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int makh = r.getInt(1);
            	String ten = r.getString(2);
            	String sdt = r.getString(3);
            	int tongchi = r.getInt(4);
            	int diem = r.getInt(5);
            	String hang = r.getString(6);
            	
            	Models_Khachhang tv = new Models_Khachhang(makh, ten, sdt, tongchi, diem, hang);
            	list.add(tv);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public ArrayList<Models_Khachhang> timkiemSdt(String sodienthoai) {
		ArrayList<Models_Khachhang> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_TIMKIEM_SDT);
            p.setString(1, sodienthoai);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int makh = r.getInt(1);
            	String ten = r.getString(2);
            	String sdt = r.getString(3);
            	int tongchi = r.getInt(4);
            	int diem = r.getInt(5);
            	String hang = r.getString(6);
            	
            	Models_Khachhang tv = new Models_Khachhang(makh, ten, sdt, tongchi, diem, hang);
            	list.add(tv);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public Models_Khachhang tracuu(String sodienthoai) {
		Models_Khachhang khachhang = null;
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_TRACUU_SDT);
            p.setString(1, sodienthoai);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int makh = r.getInt(1);
            	String ten = r.getString(2);
            	String sdt = r.getString(3);
            	int tongchi = r.getInt(4);
            	int diem = r.getInt(5);
            	String hang = r.getString(6);
            	
				khachhang = new Models_Khachhang(makh, ten, sdt, tongchi, diem, hang);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return khachhang;
	}
	
	public ArrayList<Models_Khachhang> timkiem(String name) {
		ArrayList<Models_Khachhang> list = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement(SELECT_TIMKIEM_KH);
            p.setString(1, name);
            ResultSet r = p.executeQuery();
            while (r.next()) {
            	int makh = r.getInt(1);
				String tenkh = r.getString(2);
				String sdt = r.getString(3);
				int tongchi = r.getInt(4);	
				int diemtichluy = r.getInt(5);
				String hang = r.getString(6);
            	
				Models_Khachhang nv = new Models_Khachhang(makh, tenkh, sdt, tongchi, diemtichluy, hang);
            	list.add(nv);
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
	}
	
	public void updateCustomerDeposit(String phone, int amount) {
	    String query = "UPDATE khachhang SET TongChi = TongChi + ? WHERE SDT = ?";
	    try (PreparedStatement p = conn.prepareStatement(query)) {
	        p.setInt(1, amount);
	        p.setString(2, phone);
	        int rowsAffected = p.executeUpdate();
	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Nạp tiền thành công!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Nạp tiền thất bại, số điện thoại không tồn tại.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public Models_Khachhang tracuu1(String sodienthoai) {
	    Models_Khachhang khachhang = null;
	    try {
	        PreparedStatement p = conn.prepareStatement("SELECT * FROM khachhang WHERE SDT = ?");
	        p.setString(1, sodienthoai);
	        ResultSet r = p.executeQuery();
	        if (r.next()) {
	            int makh = r.getInt("MaKhachHang");
	            String ten = r.getString("Ten");
	            String sdt = r.getString("SDT");
	            int tongchi = r.getInt("TongChi");
	            int diem = r.getInt("DiemTichLuy");
	            String hang = r.getString("HangThanhVien");

	            khachhang = new Models_Khachhang(makh, ten, sdt, tongchi, diem, hang);
	        }
	        r.close();
	        p.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return khachhang;
	}

	public Models_Khachhang suaThongTin3(Models_Khachhang khachHang) {
	    try {
	        PreparedStatement p = conn.prepareStatement(
	            "UPDATE khachhang SET Ten = ?, SDT = ?, TongChi = ?, DiemTichLuy = ?, HangThanhVien = ? WHERE MaKhachHang = ?"
	        );
	        p.setString(1, khachHang.getTenkh());
	        p.setString(2, khachHang.getSdt());
	        p.setInt(3, khachHang.getTongchi());
	        p.setInt(4, khachHang.getDiemtichluy());
	        p.setString(5, khachHang.getHang());
	        p.setInt(6, khachHang.getMakh());

	        p.executeUpdate();
	        p.close();

	        JOptionPane.showMessageDialog(null, "Nạp tiền thành công!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Nạp tiền thất bại!");
	    }
	    return khachHang;
	}
	
	 public boolean isCustomerExist(String sdt) {
	        try (Connection conn = DatabaseConnection.getConnected()) {
	            String sql = "SELECT * FROM khachhang WHERE SDT = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, sdt);
	            ResultSet rs = ps.executeQuery();
	            return rs.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public void updateCustomerDeposit1(String sdt, int amount) {
	        try (Connection conn = DatabaseConnection.getConnected()) {
	            String sql = "UPDATE khachhang SET TongChi = TongChi + ?, DiemTichLuy = DiemTichLuy + ? WHERE SDT = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, amount);
	            ps.setInt(2, amount / 1000); // Quy đổi điểm tích lũy
	            ps.setString(3, sdt);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public boolean kiemTraKhachHang(String sdt) {
	        try {
	            Connection conn = DatabaseConnection.getConnected();
	            String query = "SELECT * FROM khachhang WHERE SDT = ?";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setString(1, sdt);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next(); // Trả về true nếu tồn tại
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public void capNhatTongTienKhachHang(String sdt, int soTien) {
	        try {
	            Connection conn = DatabaseConnection.getConnected();
	            String query = "UPDATE khachhang SET TongChi = TongChi + ? WHERE SDT = ?";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setInt(1, soTien);
	            stmt.setString(2, sdt);
	            stmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public Models_Khachhang findCustomerById(int maKhachHang) {
	        Models_Khachhang khachhang = null;
	        try {
	            // Truy vấn SELECT theo MaKhachHang
	            PreparedStatement p = conn.prepareStatement(
	                "SELECT MaKhachHang, Ten, SDT, TongChi, DiemTichLuy, HangThanhVien FROM khachhang WHERE MaKhachHang = ?"
	            );
	            p.setInt(1, maKhachHang);
	            ResultSet r = p.executeQuery();

	            // Nếu tìm thấy bản ghi
	            if (r.next()) {
	                int makh    = r.getInt("MaKhachHang");
	                String ten  = r.getString("Ten");
	                String sdt  = r.getString("SDT");
	                int tongchi = r.getInt("TongChi");
	                int diem    = r.getInt("DiemTichLuy");
	                String hang = r.getString("HangThanhVien");

	                // Tạo Models_Khachhang và gán giá trị
	                khachhang = new Models_Khachhang(makh, ten, sdt, tongchi, diem, hang);
	            }
	            r.close();
	            p.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return khachhang; // Nếu không có, hàm trả về null
	    }



}

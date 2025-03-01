package models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.JSONObject;

public class Models_BangHoadon {
	
	private int id; // ID hóa đơn, tự tăng
    private Models_Khachhang khachhang; // Thông tin khách hàng
    private List<Models_Hoadon_monan> monan; // Danh sách món
    private double tongtien; // Tổng tiền
    private Date ngaytao; // Ngày tạo hóa đơn
	

	public Models_BangHoadon(int id, Models_Khachhang khachhang, List<Models_Hoadon_monan> monan, double tongtien,
			Date ngaytao) {
		super();
		this.id = id;
		this.khachhang = khachhang;
		this.monan = monan;
		this.tongtien = tongtien;
		this.ngaytao = ngaytao;
	}

//	public Models_BangHoadon(Object json) {
//        JSONObject obj = (JSONObject) json;
//        try {
//        	id = obj.getInt("mabanghoadon");
//        	khachhang = obj.getInt("maKhachHang");
//        	tongtien = obj.getDouble("tongtien");
//        	ngaytao = convertToSqlDate(obj.getString("ngaytao"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//	
//    public JSONObject toJsonObject(String type) {
//    	try {
//			JSONObject json = new JSONObject();
//			json.put("type", type);
//			json.put("mabanghoadon", id);
//			json.put("maKhachHang", makh);
//			json.put("tongtien", tongtien);
//			json.put("ngayMua", formatDate(ngaytao));
//			return json;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//    }
//	
	
	private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    
    private Date convertToSqlDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(dateString);
            return new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public String toString() {
		return "Models_BangHoadon [id=" + id + ", khachhang=" + khachhang + ", monan=" + monan + ", tongtien="
				+ tongtien + ", ngaytao=" + ngaytao + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Models_Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Models_Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public List<Models_Hoadon_monan> getMonan() {
		return monan;
	}

	public void setMonan(List<Models_Hoadon_monan> monan) {
		this.monan = monan;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	

}

package models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;

public class Models_Donmua {
	private int id;
	private int idkh;
	private int idmonan;
	private String tenmonan;
	private int soluong;
	private int gia;
	private Date ngaymua;
	
	public Models_Donmua(int id, int idkh, int idmonan, String tenmonan, int soluong, int gia, Date ngaymua) {
		this.id = id;
		this.idkh = idkh;
		this.idmonan = idmonan;
		this.tenmonan = tenmonan;
		this.soluong = soluong;
		this.gia = gia;
		this.ngaymua = ngaymua;
	}
	
	public Models_Donmua(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
        	id = obj.getInt("maDonMua");
        	idkh = obj.getInt("maKhachHang");
        	idmonan = obj.getInt("maMonan");
        	tenmonan = obj.getString("tenMonan");
        	gia = obj.getInt("gia");
        	soluong = obj.getInt("soluong");
        	ngaymua = convertToSqlDate(obj.getString("ngayMua"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public JSONObject toJsonObject(String type) {
    	try {
			JSONObject json = new JSONObject();
			json.put("type", type);
			json.put("maDonMua", id);
			json.put("maKhachHang", idkh);
			json.put("maMonan", idmonan);
			json.put("tenMonan", tenmonan);
			json.put("gia", gia);
			json.put("soluong", soluong);
			json.put("ngayMua", formatDate(ngaymua));
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public int getIdmonan() {
		return idmonan;
	}

	public void setIdmonan(int idmonan) {
		this.idmonan = idmonan;
	}

	public String getTenmonan() {
		return tenmonan;
	}

	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
}

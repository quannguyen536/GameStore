package models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;

public class Models_Nhanvien {
	private int manv;
	private String tennv;
	private String cccd;
	private String gioitinh;
	private Date ngaysinh;
	private String sdt;
	private String chucvu;
	private int luong;
	
	
	public Models_Nhanvien(int manv, String tennv, String cccd, String gioitinh, Date ngaysinh, String sdt, String chucvu, int luong) {
		this.manv = manv;
		this.tennv = tennv;
		this.cccd = cccd;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.sdt = sdt;
		this.chucvu = chucvu;
		this.luong = luong;
	}
	
    public JSONObject toJsonObject(String type) {
    	try {
			JSONObject json = new JSONObject();
			json.put("type", type);
			json.put("manv", manv);
			json.put("tennv", tennv);
			json.put("cccd", cccd);
			json.put("", gioitinh);
			json.put("ngaysinh", formatDate(ngaysinh));
			json.put("sdt", sdt);
			json.put("chucvu", chucvu);
			json.put("luong", luong);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
	public Models_Nhanvien(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
        	manv = obj.getInt("manv");
        	tennv = obj.getString("tennv");
        	cccd = obj.getString("cccd");
        	gioitinh = obj.getString("gioitinh");
        	sdt = obj.getString("sdt");
        	chucvu = obj.getString("chucvu");
        	luong = obj.getInt("luong");
        	ngaysinh = convertToSqlDate(obj.getString("ngaysinh"));
        } catch (Exception e) {
            e.printStackTrace();
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



	public int getManv() {
		return manv;
	}

	public void setManv(int manv) {
		this.manv = manv;
	}

	public String getTennv() {
		return tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}



	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getChucvu() {
		return chucvu;
	}

	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}
}

package models;

import org.json.JSONObject;

public class Models_Hoadon_monan {
	
	private int id;
	private String tenmonan;
	private int soluong;
	private double gia;
	
	public Models_Hoadon_monan(int id, String tenmonan, int soluong, double gia) {
		this.id = id;
		this.tenmonan = tenmonan;
		this.soluong = soluong;
		this.gia = gia;
	}
	
	
	public Models_Hoadon_monan(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
        	id = obj.getInt("mahoadon");
        	tenmonan = obj.getString("tenMonan");
        	soluong = obj.getInt("soluong");
        	gia = obj.getDouble("gia");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public JSONObject toJsonObject(String type) {
    	try {
			JSONObject json = new JSONObject();
			json.put("type", type);
			json.put("mahoadon", id);
			json.put("tenmonan", tenmonan);
			json.put("soluong", soluong);
			json.put("gia", gia);
			return json;
		} catch (Exception e) {
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


	public double getGia() {
		return gia;
	}


	public void setGia(double gia) {
		this.gia = gia;
	}

}

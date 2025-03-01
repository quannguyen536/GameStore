package models;

import org.json.JSONObject;

public class Models_Khachhang {
	private int makh;
	private String tenkh;
	private String sdt;
	private int tongchi;
	private int diemtichluy;
	private String hang;
	
	public Models_Khachhang(int makh, String tenkh, String sdt, int sotiennap, int diemtichluy,String hang) {
		this.makh = makh;
		this.tenkh = tenkh;
		this.sdt = sdt;
		this.tongchi = sotiennap;
		this.diemtichluy = diemtichluy;
		this.hang = hang;
	}
	
    public JSONObject toJsonObject(String type) {
    	try {
			JSONObject json = new JSONObject();
			json.put("type", type);
			json.put("makh", makh);
			json.put("tenkh", tenkh);
			json.put("sdt", sdt);
			json.put("sotiennap", tongchi);
			json.put("diemtichluy", diemtichluy);
			json.put("hang", hang);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
	public Models_Khachhang(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
        	makh = obj.getInt("makh");
        	tenkh = obj.getString("tenkh");
        	sdt = obj.getString("sdt");
        	tongchi = obj.getInt("sotiennap");
        	diemtichluy = obj.getInt("diemtichluy");
        	hang = obj.getString("hang");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




	public int getMakh() {
		return makh;
	}

	public void setMakh(int makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public int getTongchi() {
		return tongchi;
	}

	public void setTongchi(int tongchi) {
		this.tongchi = tongchi;
	}

	public int getDiemtichluy() {
		return diemtichluy;
	}

	public void setDiemtichluy(int diemtichluy) {
		this.diemtichluy = diemtichluy;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}
}

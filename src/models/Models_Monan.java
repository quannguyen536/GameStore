package models;

import org.json.JSONObject;

public class Models_Monan {
	private int id;
	private String tenmonan;
	private String loaimonan;
	private int sltonkho;
	private int sldaban;
	private int gia;
	private byte[] hinhanh;
	



	public Models_Monan(int id, String tenmonan, String loaimonan, int sltonkho, int sldaban, int gia, byte[] hinhanh) {
		this.id = id;
		this.tenmonan = tenmonan;
		this.loaimonan = loaimonan;
		this.sltonkho = sltonkho;
		this.sldaban = sldaban;
		this.gia = gia;
		this.hinhanh = hinhanh;
	}

	public Models_Monan(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
        	id = obj.getInt("id");
        	tenmonan = obj.getString("tenmonan");
        	gia = obj.getInt("gia");
        	loaimonan = obj.getString("loaimonan");
        	sldaban = obj.getInt("sldaban");
        	sltonkho = obj.getInt("sltonkho");
        	hinhanh = convertHexStringToByteArray(obj.getString("hinhanh"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public JSONObject toJsonObject(String type) {
    	try {
			JSONObject json = new JSONObject();
			json.put("type", type);
			json.put("id", id);
			json.put("tenmonan", tenmonan);
			json.put("gia", gia);
			json.put("loaimonan", loaimonan);
			json.put("sldaban", sldaban);
			json.put("sltonkho", sltonkho);
			json.put("hinhAnh", convertByteArrayToHexString(hinhanh));
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    private String convertByteArrayToHexString(byte[] array) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : array) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    private byte[] convertHexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                                 + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
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

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getLoaimonan() {
		return loaimonan;
	}

	public void setLoaimonan(String loaimonan) {
		this.loaimonan = loaimonan;
	}

	public int getSldaban() {
		return sldaban;
	}

	public void setSldaban(int sldaban) {
		this.sldaban = sldaban;
	}
	
	public int getSltonkho() {
		return sltonkho;
	}

	public void setSltonkho(int sltonkho) {
		this.sltonkho = sltonkho;
	}

	public byte[] getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(byte[] hinhanh) {
		this.hinhanh = hinhanh;
	}
}

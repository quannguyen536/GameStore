package models;

import org.json.JSONObject;

public class Models_Dangnhap {
	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Models_Dangnhap(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Models_Dangnhap() {
    }

    private String userName;
    private String password;

    public JSONObject toJsonObject() {
    	try {
			JSONObject json = new JSONObject();
			json.put("type", "login");
			json.put("userName", userName);
			json.put("password", password);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
	public Models_Dangnhap(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
        	userName = obj.getString("userName");
        	password = obj.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

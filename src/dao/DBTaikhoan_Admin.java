package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Models_Dangki;
import models.Models_Dangnhap;


public class DBTaikhoan_Admin {

	private final Connection conn;
	private static DBTaikhoan_Admin instance;
	
	private final String CHECK_REGISTER = "SELECT username FROM taikhoan_admin WHERE username=?";
	private final String INSERT_USER = "INSERT INTO taikhoan_admin (username, `password`) VALUES (?, ?)";
	private final String CHECK_lOGIN = "SELECT username FROM taikhoan_admin WHERE username=? AND `password`=?";
	
	public static DBTaikhoan_Admin getInstance() {
		if(instance == null) {
			instance = new DBTaikhoan_Admin();
		}
		return instance;
	}
	
	public DBTaikhoan_Admin() {
        this.conn = DatabaseConnection.getInstance().getConn();
	}
	
	public boolean dangki(Models_Dangki register) {
		boolean check = false;
        try {
            PreparedStatement p = conn.prepareStatement(CHECK_REGISTER , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            p.setString(1, register.getUserName());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                check = false;
            } else {
                r.close();
                p.close();
                
                p = conn.prepareStatement(INSERT_USER);
                p.setString(1, register.getUserName());
                p.setString(2, register.getPassword());
                p.execute();
                check = true;
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return check;
	}
	
	public boolean dangnhap(Models_Dangnhap login) {
		boolean check = false;
        try {
            PreparedStatement p = conn.prepareStatement(CHECK_lOGIN , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            p.setString(1, login.getUserName());
            p.setString(2, login.getPassword());
            ResultSet r = p.executeQuery();
            if (r.first()) {
                check = true;
            } else {
                check = false;
            }
            r.close();
            p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return check;
	}
}

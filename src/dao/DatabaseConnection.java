package dao;


import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {

	private Connection conn = null;
	private static DatabaseConnection instance = null;

	private DatabaseConnection() {
		try{ 
			   String userName = "root";
			   String password = "";
			   String DatabaseName = "game_store";
			   String url = "jdbc:mysql://localhost/" + DatabaseName;
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   this.conn = DriverManager.getConnection(url, userName, password);
			   System.out.println("Kết nối thành công!");
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public static Connection getConnected() {
		instance = getInstance();
		return instance.getConn();
	}
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}	
}


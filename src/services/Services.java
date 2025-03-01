package services;

import java.awt.Panel;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.DBDoanhthus;
//import dao.DBTaikhoan;
import dao.DB_Khachhangs;
import dao.DB_Monans;
import models.Models_Dangki;
import models.Models_Dangnhap;
import models.Models_Donmua;
import models.Models_Khachhang;
import models.Models_Monan;
import models.Models_Nhanvien;
import pages.QL_monan;
import views.Main;


public class Services {
	 private static Services instance;
	 private Main main;
	 private Panel panel;
	    private ServerSocket serverSocket;
	    private final int PORT_NUMBER = 8081;
		private ArrayList<ClientHandlers> clients = new ArrayList<>();
		private static int id = 1000000;
		 private SecretKey aesKey;

		 
		 
	 
	 public static Services getInstance(Main main) {
	        if (instance == null) {
	            instance = new Services(main);
	        }
	        return instance;
	    }
	 public static Services getInstance() {
	        return instance;
	    }	
	 
	 private Services(Main main) {
		this.main = main;
		main.getBody().getNhanvien();
        main.getBody().getKhachhang();
        main.getBody().getMonan();
        main.getBody().getMaytinh();
        main.getBody().getDoanhthu();
        
        // Tạo khóa AES khi khởi động server
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // Khóa AES-256
            aesKey = keyGen.generateKey();
            System.out.println("Generated AES Key: " + Base64.getEncoder().encodeToString(aesKey.getEncoded()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	} 
	 
	    public void startServer() {
	        new Thread(() -> {
	            try {
	            	serverSocket = new ServerSocket(PORT_NUMBER);
	            	System.out.println("START SERVER ON PORT " + PORT_NUMBER);
	                while (true) {
	                    Socket clientSocket = serverSocket.accept();
	                    System.out.println("ONE CLIENT CONNECT");
	                    try {
	                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream() , StandardCharsets.UTF_8));
	                        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
	                        
	                        // Gửi khóa AES tới client khi kết nối
	                        sendAesKeyToClient(out);
	                        
	                        ClientHandlers clientHandler = new ClientHandlers(++id,this, in, out, clients, clientSocket, aesKey);
	                    }
	                    catch (Exception e) {
	                    	clientSocket.close();
	                    }
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }).start();
	    }
	 
	    private void sendAesKeyToClient(DataOutputStream out) throws IOException {
	    	try {
	    		String encodedKey = Base64.getEncoder().encodeToString(aesKey.getEncoded());
	            OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
	            writer.write(encodedKey + "\n");
	            writer.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void listen(ClientHandlers client, String newdata) {
	    	
	    	String data = new String(newdata);
			new Thread(()->{
	    		try {
	    			JSONObject jsonData = new JSONObject(data);
	    			
	    	    	if(jsonData.getString("type").equals("dangki")) {
	    	            Models_Dangki register = new Models_Dangki(jsonData);
//	    	            boolean message = DBTaikhoan.getInstance().register(register);
	    	            
	    	        	JSONObject json = new JSONObject();
	    	    		try {
	    	    			json.put("type", "dangki");
//	    	    			json.put("check", message);
	    	    		} catch (Exception e) {
	    	    			e.printStackTrace();
	    	    		}    	            
	    	            broadcast(client.getUserId(), json);
	    	    	}
	    	    	else if(jsonData.getString("type").equals("themNhanVien")) {
	    	            Models_Nhanvien nhanvien = new Models_Nhanvien(jsonData);
	    	            main.getBody().getNhanvien().themnhanvien2(nhanvien);
	    	    	}
	    			else if(jsonData.getString("type").equals("dangnhap")) {
	    	            Models_Dangnhap login = new Models_Dangnhap(jsonData);
//	    	            boolean message = DBTaikhoan.getInstance().login(login);
	    	        	JSONObject json = new JSONObject();
	    	    		try {
	    	    			json.put("type", "dangnhap");
//	    	    			json.put("check", message);
	    	    		} catch (Exception e) {
	    	    			e.printStackTrace();
	    	    		}    	                 	            
	    	            broadcast(client.getUserId(), json);    	            
//	    	            if(message) {
////	    	            	int quay = jsonData.getInt("quay");
////	    	            	Models_Nhanvien nhanvien = DBTaikhoan.getInstance().getNhanVien(login.getUserName());
////	    	            	client.setUserId(quay);
////	    	            	main.getBody().getQuannet().online(nhanvien, quay);
//	    	            	
////	        	            JSONObject json3 = new JSONObject();
////	        	            json3.put("type", "update");
////	        	            json3.put("nhanvien", nhanvien.getTennv());
////	        	            json3.put("quay", quay);
////	        	            broadcast(client.getUserId(), json3);
//	    	            	
//	        	            List<Models_Monan> list = DB_Monans.getInstance().loadfood();
//	        	            JSONArray jsonArray = new JSONArray();
//	        	            for(Models_Monan sach : list) {    	    
//	        	            	jsonArray.put(sach.toJsonObject("listSach"));
//	        	            }
//	        	            JSONObject json2 = new JSONObject();
//	        	            json2.put("type", "listSach");
//	        	            json2.put("jsonArray", jsonArray);
//	    	            	broadcast(client.getUserId(), json2);
//	    	            }    	            
	    	    	}
	    	    	else if(jsonData.getString("type").equals("tracuu")) {
	    	            String sdt = jsonData.getString("sdt");
	    	            Models_Khachhang khachhang = DB_Khachhangs.getInstance().tracuu(sdt);
	    	            if(khachhang != null) {
	    	            	broadcast(client.getUserId(), khachhang.toJsonObject("tracuu_true"));
	    	            }
	    	            else {
	        	            JSONObject json = new JSONObject();
	        	            json.put("type", "tracuu_false");
	    	            	broadcast(client.getUserId(), json) ;
	    	            }
	    	    	}
	    	    	else if(jsonData.getString("type").equals("themThanhVien")) {
	    	    		Models_Khachhang khachhang = new Models_Khachhang(jsonData);
	    	    		Models_Khachhang khachHangMoi = DB_Khachhangs.getInstance().themThanhVien2(khachhang);
	    	            broadcast(client.getUserId(), khachHangMoi.toJsonObject("themThanhVien")) ;
	    	            main.getBody().getKhachhang().loadThanhVien();
	    	    	}
	    	    	else if(jsonData.getString("type").equals("xuatHoaDonKhachHang")) {
	    	    		Models_Khachhang khachhang = new Models_Khachhang(jsonData);
	    	    		DB_Khachhangs.getInstance().suaThongTin2(khachhang);
	    	            main.getBody().getKhachhang().loadThanhVien();
	    	    	}
	    	    	else if(jsonData.getString("type").equals("xuatHoaDonSach")) {
	    	    		JSONArray jsonArray = jsonData.getJSONArray("jsonArray");
	    	    		List<Models_Donmua> list = new ArrayList<>();
	    	            for (int i = 0; i < jsonArray.length(); i++) {
	    	                JSONObject json = jsonArray.getJSONObject(i);
	    	                Models_Donmua donmua = new Models_Donmua(json);
	    	                DBDoanhthus.getInstance().themDonMua(donmua);
	    	                DB_Monans.getInstance().updateSoLuong(donmua.getIdmonan(), donmua.getSoluong());
	    	            }
//	    	            main.getBody().getDoanhthu().loadDonMua();
//	    	            main.getBody().getKhosach().loadPhone();
	    	            
	    	            
	    	            List<Models_Monan> list2 = DB_Monans.getInstance().loadfood();
	    	            JSONArray jsonArray2 = new JSONArray();
	    	            for(Models_Monan sach : list2) {    	    
	    	            	jsonArray2.put(sach.toJsonObject("listSach"));
	    	            }
	    	            JSONObject json2 = new JSONObject();
	    	            json2.put("type", "listSach");
	    	            json2.put("jsonArray", jsonArray2);
		            	broadcast(client.getUserId(), json2);
	    	    	}

	    		} catch (JSONException e) {
	    			e.printStackTrace();
	    			e.printStackTrace();
	    		}
	    	}).start();
	    }
	    
	    public synchronized void broadcast(int userId, JSONObject jsonData) {
	        for (ClientHandlers client : clients) {
	            if(client.getUserId() == userId) {
	            	client.sendMessage(jsonData);
	            }
	        }
	    }

	 public Main getMain() {
			return main;
		}

}

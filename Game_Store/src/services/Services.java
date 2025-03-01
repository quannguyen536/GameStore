package services;

import views.Main;

public class Services {
	 private static Services instance;
	 private Main main;
	 
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
        main.getBody().getUudai();
        main.getBody().getDoanhthu();
        main.getBody().getThongke();
        
	}
	 
	 public Main getMain() {
			return main;
		}
}

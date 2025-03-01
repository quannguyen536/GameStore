package pages;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class QL_quannet extends JPanel{

	public QL_quannet() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);	
		setLayout(null);
		
		JLabel lb_title_nhanvien = new JLabel("");
		lb_title_nhanvien.setIcon(new ImageIcon(QL_quannet.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_nhanvien.setBounds(350, 10, 445, 64);
		add(lb_title_nhanvien);
	}
	
}

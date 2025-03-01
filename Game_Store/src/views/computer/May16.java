package views.computer;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class May16 extends JPanel{
	private JLabel lb_trangthai;
	
	public May16() {
		setSize(141,212 );
		setBackground(Color.WHITE);
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 141, 212);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(May16.class.getResource("/images/icons/icons8-computer-105.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 121, 109);
		panel.add(lblNewLabel);
		
		JLabel lb_somay = new JLabel("Máy 16");
		lb_somay.setForeground(new Color(0,28,65));
		lb_somay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb_somay.setHorizontalAlignment(SwingConstants.CENTER);
		lb_somay.setBounds(10, 122, 123, 28);
		panel.add(lb_somay);
		
		lb_trangthai = new JLabel("Máy trống");
		lb_trangthai.setForeground(new Color(0,28,65));
		lb_trangthai.setIcon(new ImageIcon(May16.class.getResource("/images/icons/icons8-wi-fi-27.png")));
		lb_trangthai.setHorizontalAlignment(SwingConstants.CENTER);
		lb_trangthai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb_trangthai.setBounds(10, 161, 123, 39);
		panel.add(lb_trangthai);
		
		
	}

	public JLabel getLb_trangthai() {
		return lb_trangthai;
	}

	public void setLb_trangthai(JLabel lb_trangthai) {
		this.lb_trangthai = lb_trangthai;
	}
}

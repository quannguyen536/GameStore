package pages;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//import swing.chart.Chart;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class QL_thongke extends JPanel{
	private JPanel panel_soluong;
	private JPanel panel_doanhthu;
	private JLabel bt_refresh;
//	private Chart chart_soluong;
//	private Chart chart_doanhthu;

	public QL_thongke() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);	
		setLayout(null);
		
		JLabel lb_title_nhanvien = new JLabel("");
		lb_title_nhanvien.setIcon(new ImageIcon(QL_thongke.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_nhanvien.setBounds(352, 0, 445, 64);
		add(lb_title_nhanvien);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(66, 54, 1047, 697);
		add(tabbedPane);
		
		panel_soluong = new JPanel();
		tabbedPane.addTab("Số lượng", panel_soluong);
		panel_soluong.setLayout(null);
		
		panel_doanhthu = new JPanel();
		tabbedPane.addTab("Doanh thu", panel_doanhthu);
		panel_doanhthu.setLayout(null);
		
		bt_refresh = new JLabel("");

		bt_refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_refresh.setBackground(new Color(197,222,253));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_refresh.setBackground(new Color(0,28,65));
			}
		});
		bt_refresh.setOpaque(true);
		bt_refresh.setIcon(new ImageIcon(QL_thongke.class.getResource("/images/icons/icons8-convert-35.png")));
		bt_refresh.setHorizontalAlignment(SwingConstants.CENTER);
		bt_refresh.setBackground(new Color(0, 28, 65));
		bt_refresh.setBounds(587, 762, 92, 35);
		add(bt_refresh);
		
//		chart_doanhthu = new Chart();
//		chart_doanhthu.setLocation(0, 0);
//		chart_doanhthu.setSize(1102, 637);
//		panel_doanhthu.add(chart_doanhthu);
		
//		chart_doanhthu.addLegend("Doanh thu", new Color(38, 190, 51));
//			
//		chart_soluong = new Chart();
//		chart_soluong.setLocation(0, 0);
//		chart_soluong.setSize(1102, 627);
//		panel_soluong.add(chart_soluong);
	}
}

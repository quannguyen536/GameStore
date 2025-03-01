package pages;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

//import swing.ImageRenderer;

public class QL_doanhthu extends JPanel {
	private JTable table;
	private JTextField tf_soluong;
	private JTextField tf_tongthu;
	private JLabel bt_doi;
	private JLabel bt_tim;
	private JDateChooser date_from;
	private JDateChooser date_to;
	private DefaultTableModel tableModel;

	public QL_doanhthu() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);	
		setLayout(null);
		
		JLabel lb_title_nhanvien = new JLabel("");
		lb_title_nhanvien.setIcon(new ImageIcon(QL_doanhthu.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_nhanvien.setBounds(350, 10, 445, 64);
		add(lb_title_nhanvien);
		
		JLabel bt_homnay = new JLabel("Hôm nay");
		bt_homnay.setForeground(new Color(255,212,58));
		bt_homnay.setOpaque(true);
		bt_homnay.setHorizontalAlignment(SwingConstants.CENTER);
		bt_homnay.setFont(new Font("Tahoma", Font.BOLD, 20));
		bt_homnay.setBackground(new Color(27,79,147));
		bt_homnay.setBounds(54, 124, 124, 48);
		add(bt_homnay);
		
		JLabel bt_thangnay = new JLabel("Tháng nay");
		bt_thangnay.setForeground(new Color(255,212,58));
		bt_thangnay.setOpaque(true);
		bt_thangnay.setHorizontalAlignment(SwingConstants.CENTER);
		bt_thangnay.setFont(new Font("Tahoma", Font.BOLD, 20));
		bt_thangnay.setBackground(new Color(24, 71,133));
		bt_thangnay.setBounds(177, 124, 124, 48);
		add(bt_thangnay);
		
		JLabel bt_namnay = new JLabel("Năm nay");
		bt_namnay.setForeground(new Color(255,212,58));
		bt_namnay.setOpaque(true);
		bt_namnay.setHorizontalAlignment(SwingConstants.CENTER);
		bt_namnay.setFont(new Font("Tahoma", Font.BOLD, 20));
		bt_namnay.setBackground(new Color(16, 54, 103));
		bt_namnay.setBounds(300, 124, 124, 48);
		add(bt_namnay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 172, 1078, 528);
		add(scrollPane);
		
		tableModel = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Mã", "Tên loại đồ chi tiêu", "Tên khách hàng", "Số lượng", "Ngày mua"
				});
		
		table = new JTable();
		table.setModel(tableModel);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(220);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
//		table.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderer());
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("SỐ LƯỢNG");
		lblNewLabel_1.setForeground(new Color(255,212,58));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(65, 731, 159, 33);
		add(lblNewLabel_1);
		
		tf_soluong = new JTextField();
		tf_soluong.setForeground(new Color(0,28,65));
		tf_soluong.setBackground(new Color(255,212,58));
		tf_soluong.setFont(new Font("Tahoma", Font.BOLD, 25));
		tf_soluong.setColumns(10);
		tf_soluong.setBounds(230, 731, 139, 33);
		add(tf_soluong);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0,28,65));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(53, 711, 331, 74);
		add(lblNewLabel);
		
		date_from = new JDateChooser();
		date_from.setFont(new Font("Tahoma", Font.BOLD, 20));
		date_from.setBackground(new Color(254,212,61));
		date_from.setBounds(575, 124, 200, 37);
		add(date_from);
		
		date_to = new JDateChooser();
		date_to.setFont(new Font("Tahoma", Font.BOLD, 20));
		date_to.setBackground(new Color(135, 206, 235));
		date_to.setBounds(831, 124, 200, 37);
		add(date_to);
		
		JLabel lblNewLabel_2 = new JLabel("đến");
		lblNewLabel_2.setBackground(new Color(0,28,65));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setForeground(new Color(254,212,61));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(779, 124, 48, 37);
		add(lblNewLabel_2);
		
		bt_tim = new JLabel("");
		bt_tim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_tim.setBackground(new Color(197,222,253));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_tim.setBackground(new Color(0,28,65));
			}
		});
		bt_tim.setHorizontalAlignment(SwingConstants.CENTER);
		bt_tim.setIcon(new ImageIcon(QL_doanhthu.class.getResource("/images/icons/icons8-search-35.png")));
		bt_tim.setBackground(new Color(0,28,65));
		bt_tim.setOpaque(true);
		bt_tim.setBounds(1035, 124, 97, 37);
		add(bt_tim);
		
		bt_doi = new JLabel("");
		bt_doi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_doi.setBackground(new Color(197,222,253));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_doi.setBackground(new Color(0,28,65));
			}
		});
		bt_doi.setIcon(new ImageIcon(QL_doanhthu.class.getResource("/images/icons/icons8-convert-35.png")));
		bt_doi.setHorizontalAlignment(SwingConstants.CENTER);
		bt_doi.setBackground(new Color(0,28,65));
		bt_doi.setOpaque(true);
		bt_doi.setBounds(509, 124, 56, 35);
		add(bt_doi);
		

		JLabel lblNewLabel_1_1 = new JLabel("TỔNG THU");
		lblNewLabel_1_1.setForeground(new Color(255, 212, 58));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(813, 731, 159, 33);
		add(lblNewLabel_1_1);
		
		tf_tongthu = new JTextField();
		tf_tongthu.setForeground(new Color(0, 28, 65));
		tf_tongthu.setFont(new Font("Tahoma", Font.BOLD, 25));
		tf_tongthu.setColumns(10);
		tf_tongthu.setBackground(new Color(255, 212, 58));
		tf_tongthu.setBounds(978, 731, 139, 33);
		add(tf_tongthu);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(0, 28, 65));
		lblNewLabel_4.setBounds(801, 711, 331, 74);
		add(lblNewLabel_4);
		
		
	}
}

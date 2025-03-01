package pages;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DB_Khachhangs;
import net.miginfocom.swing.MigLayout;
import services.Services;
import views.Food_choice;
import views.component.Luu_hoadon;
import views.component.ThemNV;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pages.Chon_Monan;
import pages.Chon_Nuocuong;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class QL_monan extends JPanel{
	private DefaultTableModel tableModel;
	private Food_choice food_choice;
	public JPanel panel;
	private JTextField tf_tongtien;
	JTable bangmonan;

	public QL_monan() {
		
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);

		// Khởi tạo `Chon_Monan` với tham chiếu `this`
	    Chon_Monan chonMonAn = new Chon_Monan(this);
	    Chon_Nuocuong chonNuocUong = new Chon_Nuocuong(this);
	    
	    
		JLabel bt_doan = new JLabel("ĐỒ ĂN");
		bt_doan.setBounds(19, 180, 118, 35);
		bt_doan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_doan.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_doan.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				food_choice.getCardLayout().show(food_choice, "Monan");
			}
		});
		setLayout(null);
		bt_doan.setIcon(new ImageIcon(QL_monan.class.getResource("/images/icons/icons8-rice-24.png")));
		bt_doan.setOpaque(true);
		bt_doan.setHorizontalAlignment(SwingConstants.CENTER);
		bt_doan.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_doan.setBackground(new Color(255, 204, 0));
		add(bt_doan);
		
		JLabel bt_tru = new JLabel("TRỪ");
		bt_tru.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_tru.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_tru.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = bangmonan.getSelectedRow(); // Lấy dòng được chọn
		        if (selectedRow != -1) { // Kiểm tra nếu có dòng được chọn
		            int soLuong = (int) tableModel.getValueAt(selectedRow, 3); // Lấy số lượng hiện tại
		            if (soLuong > 1) {
		                tableModel.setValueAt(soLuong - 1, selectedRow, 3); // Giảm số lượng
		                tf_tongtien.setText(String.valueOf(tinhTongTien())); // Cập nhật tổng tiền
		            } else {
		                JOptionPane.showMessageDialog(null, "Số lượng đã ở mức nhỏ nhất!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để trừ số lượng!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
		bt_tru.setOpaque(true);
		bt_tru.setHorizontalAlignment(SwingConstants.CENTER);
		bt_tru.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_tru.setBackground(new Color(255, 204, 0));
		bt_tru.setBounds(993, 257, 118, 46);
		add(bt_tru);
		
		JLabel bt_xoa = new JLabel("XÓA");
		bt_xoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_xoa.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_xoa.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				 int selectedRow = bangmonan.getSelectedRow(); // Lấy dòng được chọn
			        if (selectedRow != -1) { // Kiểm tra nếu có dòng được chọn
			            tableModel.removeRow(selectedRow); // Xóa dòng khỏi bảng
			            tf_tongtien.setText(String.valueOf(tinhTongTien())); // Cập nhật tổng tiền
			        } else {
			            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			        }
			}
		});
		bt_xoa.setBackground(new Color(255, 204, 0));
		bt_xoa.setOpaque(true);
		bt_xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_xoa.setHorizontalAlignment(SwingConstants.CENTER);
		bt_xoa.setBounds(842, 257, 118, 46);
		add(bt_xoa);
		
		JLabel bt_nuocuong = new JLabel("NƯỚC UỐNG");
		bt_nuocuong.setBounds(147, 180, 118, 35);
		bt_nuocuong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_nuocuong.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_nuocuong.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				food_choice.getCardLayout().show(food_choice, "Nuocuong");
			}
		});
		bt_nuocuong.setIcon(new ImageIcon(QL_monan.class.getResource("/images/icons/icons8-drink-24.png")));
		bt_nuocuong.setOpaque(true);
		bt_nuocuong.setHorizontalAlignment(SwingConstants.CENTER);
		bt_nuocuong.setFont(new Font("Tahoma", Font.BOLD, 13));
		bt_nuocuong.setBackground(new Color(255, 204, 0));
		add(bt_nuocuong);

		JLabel lb_leftbar = new JLabel("");
		lb_leftbar.setBounds(10, 175, 264, 46);
		lb_leftbar.setBackground(new Color(0,28,65));
		lb_leftbar.setOpaque(true);
		add(lb_leftbar);

		
		JLabel lblNewLabel_2 = new JLabel("Nóng hổi vừa thổi vừa chơi!");
		lblNewLabel_2.setBounds(24, 97, 258, 28);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblNewLabel_2);

		
		JLabel lblNewLabel = new JLabel("Dịch Vụ Ăn Uống");
		lblNewLabel.setBounds(24, 58, 206, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 34, 802, 130);
		label.setIcon(new ImageIcon(QL_monan.class.getResource("/images/logos/nghe-thuat-trinh-bay-va-chup-anh-mon-an-802.jpg")));
		add(label);
		
		
		JLabel bt_dathang = new JLabel("ĐẶT HÀNG");
		bt_dathang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_dathang.setBackground(new Color(204,138,0));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_dathang.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialog dialog = new JDialog();
		        Luu_hoadon them = new Luu_hoadon(dialog);

		        // Thêm action listener cho nút XÁC NHẬN
		        them.getBt_xacnhan().addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent event) {
		                String tenKhachHang = them.getTfTenkhachhang().getText().trim();
		                String sdt = them.getTfSdt().getText().trim();

		                if (tenKhachHang.isEmpty() || sdt.isEmpty()) {
		                    JOptionPane.showMessageDialog(dialog, "Vui lòng nhập đầy đủ thông tin!");
		                    return;
		                }

		                // Kiểm tra khách hàng trong cơ sở dữ liệu
		                if (DB_Khachhangs.getInstance().kiemTraKhachHang(sdt)) {
		                    JOptionPane.showMessageDialog(dialog, "Đặt hàng thành công");
		                    // Cập nhật tổng tiền khách hàng
		                    DB_Khachhangs.getInstance().capNhatTongTienKhachHang(sdt, tinhTongTien());
		                } else {
		                    JOptionPane.showMessageDialog(dialog, "Khách hàng chưa tồn tại. Hãy thêm khách hàng.");
		                }

		                dialog.dispose();
		                tableModel.setRowCount(0); // Xóa toàn bộ dữ liệu
		                tf_tongtien.setText("");
		            }
		        });

		        dialog.getContentPane().setLayout(new GridLayout(1, 1));
		        dialog.setSize(579, 350);
		        dialog.setLocationRelativeTo(null);
		        dialog.getContentPane().add(them);
		        dialog.setVisible(true);
			}
		});
		bt_dathang.setHorizontalAlignment(SwingConstants.CENTER);
		bt_dathang.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_dathang.setBackground(new Color(255, 204, 0));
		bt_dathang.setOpaque(true);
		bt_dathang.setBounds(825, 755, 305, 46);
		add(bt_dathang);
		
		tf_tongtien = new JTextField("");
		tf_tongtien.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_tongtien.setForeground(new Color(255, 204, 0));
		tf_tongtien.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf_tongtien.setBackground(new Color(16, 54, 103));
		tf_tongtien.setBounds(902, 696, 163, 35);
		add(tf_tongtien);
		tf_tongtien.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("VNĐ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setForeground(new Color(255, 204, 0));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(1061, 692, 63, 46);
		add(lblNewLabel_5);
		

		
		JLabel lb_thanhtien = new JLabel("Thành tiền:");
		lb_thanhtien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb_thanhtien.setForeground(new Color(255, 204, 0));
		lb_thanhtien.setOpaque(true);
		lb_thanhtien.setBackground(new Color(16, 54, 103));
		lb_thanhtien.setBounds(825, 677, 305, 74);
		add(lb_thanhtien);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon(QL_monan.class.getResource("/images/logos/logo1-243-222.png")));
		lblNewLabel_6.setBounds(877, 76, 206, 170);
		add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(825, 325, 305, 348);
		add(scrollPane);
		
		tableModel = new DefaultTableModel(
				new Object[][] {},
		        new String[] {
		          		 "ID", "Tên món ăn", "Giá món ăn", "Số lượng"
		           });
		
		
		bangmonan = new JTable();
		bangmonan.setModel(tableModel);
		bangmonan.getColumnModel().getColumn(0).setPreferredWidth(50);
		bangmonan.getColumnModel().getColumn(1).setPreferredWidth(150);
		bangmonan.getColumnModel().getColumn(2).setPreferredWidth(180);
		bangmonan.getColumnModel().getColumn(3).setPreferredWidth(90);
		scrollPane.setViewportView(bangmonan);
		

		JLabel lb_bangphu = new JLabel("");
		lb_bangphu.setHorizontalAlignment(SwingConstants.LEFT);
		lb_bangphu.setForeground(new Color(255, 204, 0));
		lb_bangphu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_bangphu.setBounds(825, 66, 305, 742);
		lb_bangphu.setBackground(new Color(27,79,147));
		lb_bangphu.setOpaque(true);
		add(lb_bangphu);
		
		panel = new JPanel();
		   panel.setBounds(10, 226, 802, 575);
		   panel.setBackground(new Color(27, 79, 147));
		   panel.setOpaque(true);
		   add(panel);		   
		   panel.setLayout(new BorderLayout());
			
		   food_choice = new Food_choice(this);
		   panel.add(food_choice, BorderLayout.CENTER);
		   
		   
		
		JLabel lb_bangchinh = new JLabel("");
		lb_bangchinh.setBounds(0, 21, 825, 787);
		lb_bangchinh.setBackground(new Color(16, 54, 103));
		lb_bangchinh.setOpaque(true);
		add(lb_bangchinh);
		
		JLabel lb_maunen = new JLabel("");
		lb_maunen.setBounds(0, 0, 1170, 900);
		lb_maunen.setBackground(new Color(24, 71,133));
		lb_maunen.setOpaque(true);
		add(lb_maunen);	
		
		JLabel lblNewLabel_1 = new JLabel("DỊCH VỤ ĂN UỐNG");
		lblNewLabel_1.setBounds(24, 88, 206, 28);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblNewLabel_1);
		
	
		
		
	}
	
	
	public Food_choice getFood_choice() {
		return food_choice;
	}
	
	public void updateTotalAmount() {
	    int total = 0;
	    for (int i = 0; i < tableModel.getRowCount(); i++) {
	        int price = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
	        int quantity = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
	        total += price * quantity;
	    }
	    tf_tongtien.setText(String.valueOf(total));
	}
	
	public int tinhTongTien() {
	    int tongTien = 0;

	    // Lặp qua từng dòng trong bảng "bangmonan" để tính tổng tiền
	    for (int i = 0; i < tableModel.getRowCount(); i++) {
	        int donGia = (int) tableModel.getValueAt(i, 2); // Lấy giá món ăn ở cột "Giá món ăn"
	        int soLuong = (int) tableModel.getValueAt(i, 3); // Lấy số lượng ở cột "Số lượng"
	        tongTien += donGia * soLuong; // Tính tổng tiền
	    }

	    return tongTien; // Trả về tổng tiền
	}


}


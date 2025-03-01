package pages;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import Outcode.XMLExporters;
import dao.DBNhanViens;
import dao.DB_Khachhangs;
import models.Models_Khachhang;
import models.Models_Nhanvien;
import views.component.ThemKH;
import views.component.Tim;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class QL_khachhang extends JPanel{
	private JTextField tf_makhachhang;
	private JTextField tf_tenkhachhang;
	private JTextField tf_sdt;
	private JTextField tf_sotiendanap;
	private JTextField tf_diemtichluy;
	private JTable table;
	private JComboBox cbb_hang;
	private JLabel bt_tim;
	private JLabel bt_luu;
	private DefaultTableModel tableModel;
	private ArrayList<Models_Khachhang> customerList = new ArrayList<>();
	

	public QL_khachhang() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);	
		setLayout(null);
		
		JLabel lb_title_khachhang = new JLabel("");
		lb_title_khachhang.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_khachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_khachhang.setBounds(350, 10, 445, 64);
		add(lb_title_khachhang);
		
		JLabel lb_makhachhang = new JLabel("Mã khách hàng");
		lb_makhachhang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_makhachhang.setBounds(10, 105, 154, 30);
		add(lb_makhachhang);
		
		tf_makhachhang = new JTextField();
		tf_makhachhang.setBounds(178, 105, 283, 30);
		add(tf_makhachhang);
		tf_makhachhang.setColumns(10);
		
		JLabel lb_tenkhachhang = new JLabel("Tên khách hàng");
		lb_tenkhachhang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_tenkhachhang.setBounds(10, 146, 154, 30);
		add(lb_tenkhachhang);
		
		tf_tenkhachhang = new JTextField();
		tf_tenkhachhang.setColumns(10);
		tf_tenkhachhang.setBounds(178, 146, 283, 30);
		add(tf_tenkhachhang);
		
		JLabel lb_sdt = new JLabel("Số điện thoại");
		lb_sdt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_sdt.setBounds(10, 187, 154, 30);
		add(lb_sdt);
		
		tf_sdt = new JTextField();
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(178, 187, 283, 30);
		add(tf_sdt);
		
		JLabel lb_sotiennap = new JLabel("Số tiền đã nạp");
		lb_sotiennap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_sotiennap.setBounds(10, 228, 154, 30);
		add(lb_sotiennap);
		
		tf_sotiendanap = new JTextField();
		tf_sotiendanap.setColumns(10);
		tf_sotiendanap.setBounds(178, 228, 283, 30);
		add(tf_sotiendanap);
		
		JLabel lb_diemtichluy = new JLabel("Điểm tích lũy");
		lb_diemtichluy.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_diemtichluy.setBounds(10, 269, 154, 30);
		add(lb_diemtichluy);
		
		tf_diemtichluy = new JTextField();
		tf_diemtichluy.setColumns(10);
		tf_diemtichluy.setBounds(178, 269, 283, 30);
		add(tf_diemtichluy);
		
		JLabel lb_hang = new JLabel("Hạng");
		lb_hang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_hang.setBounds(10, 314, 154, 30);
		add(lb_hang);
		
		String[] iteamhang = {"Đồng", "Bạc", "Vàng", "Kim cương"};
		cbb_hang = new JComboBox<>(iteamhang);
		cbb_hang.setForeground(new Color(0, 28, 65));
		cbb_hang.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbb_hang.setBounds(178, 317, 283, 30);
		add(cbb_hang);
		
		bt_tim = new JLabel("Tìm");
		bt_tim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_tim.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_tim.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Tim tim = new Tim();
		        tim.setTableModel(tableModel);  // Truyền table_model vào Tim
		        tim.setBounds(0, 0, 543, 83);
		        add(tim);
		        JDialog timDialog = new JDialog();
		        timDialog.setTitle("Tìm kiếm khách hàng");
		        timDialog.setSize(543, 120);
		        timDialog.setModal(true);
		        timDialog.getContentPane().add(tim);
		        timDialog.setLocation(500, 300);
		        timDialog.setVisible(true);
		        
			}
		});
		bt_tim.setOpaque(true);
		bt_tim.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-find-27.png")));
		bt_tim.setHorizontalAlignment(SwingConstants.CENTER);
		bt_tim.setForeground(new Color(0, 28, 65));
		bt_tim.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_tim.setBackground(new Color(255, 212, 58));
		bt_tim.setBounds(49, 363, 100, 40);
		add(bt_tim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 414, 1113, 379);
		add(scrollPane);
		
	    tableModel = new DefaultTableModel(
	    		new Object[][] {},
	    		new String[] {
	    				"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Số tiền đã nạp", "Điểm tích lũy", "Hạng"
	    	  });
		
		table = new JTable();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		table.getColumnModel().getColumn(3).setPreferredWidth(170);
		table.getColumnModel().getColumn(4).setPreferredWidth(170);
		table.getColumnModel().getColumn(5).setPreferredWidth(113);
		
//		Font headerFont = new Font("Arial", Font.BOLD, 20);
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 30));
//		table.getTableHeader().setFont(headerFont);
		table.setRowHeight(40);
		
		
		
		JLabel bt_themnhanvien = new JLabel("THÊM KHÁCH HÀNG");
		bt_themnhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_themnhanvien.setBackground(new Color(0,77,141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_themnhanvien.setBackground(new Color(0,28,65));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				reset();
	        	JDialog dialog = new JDialog();
	        	ThemKH them = new ThemKH(dialog);
	    		dialog.getContentPane().setLayout(new GridLayout(1,1));
	    		dialog.setSize(650, 450);
	    		dialog.setLocationRelativeTo(null);
	        	dialog.getContentPane().add(them);
	        	dialog.setVisible(true);
			}
		});
		bt_themnhanvien.setOpaque(true);
		bt_themnhanvien.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-add-35.png")));
		bt_themnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_themnhanvien.setForeground(new Color(255, 212, 58));
		bt_themnhanvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_themnhanvien.setBackground(new Color(0, 28, 65));
		bt_themnhanvien.setBounds(521, 126, 213, 50);
		add(bt_themnhanvien);
		
		JLabel bt_suathongtin = new JLabel("SỬA THÔNG TIN");
		bt_suathongtin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_suathongtin.setBackground(new Color(0,77,141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_suathongtin.setBackground(new Color(0,28,65));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tf_makhachhang.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					unreset();
					bt_luu.setVisible(true);
				}
			}
		});
		bt_suathongtin.setOpaque(true);
		bt_suathongtin.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-edit-text-file-35.png")));
		bt_suathongtin.setHorizontalAlignment(SwingConstants.CENTER);
		bt_suathongtin.setForeground(new Color(255, 212, 58));
		bt_suathongtin.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_suathongtin.setBackground(new Color(0, 28, 65));
		bt_suathongtin.setBounds(785, 126, 213, 50);
		add(bt_suathongtin);
		
		JLabel bt_xoanhanvien = new JLabel("XÓA KHÁCH HÀNG");
		bt_xoanhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_xoanhanvien.setBackground(new Color(0,77,141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_xoanhanvien.setBackground(new Color(0,28,65));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tf_makhachhang.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					xoaThanhVien(Integer.parseInt(tf_makhachhang.getText()));
					reset();
					loadThanhVien();
				}

			}
		});
		bt_xoanhanvien.setOpaque(true);
		bt_xoanhanvien.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-delete-35.png")));
		bt_xoanhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_xoanhanvien.setForeground(new Color(255, 212, 58));
		bt_xoanhanvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_xoanhanvien.setBackground(new Color(0, 28, 65));
		bt_xoanhanvien.setBounds(521, 219, 213, 50);
		add(bt_xoanhanvien);
		
		bt_luu = new JLabel("Lưu");
		bt_luu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_luu.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_luu.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				suaThongTin();
        		reset();
        		bt_luu.setVisible(false);
        		loadThanhVien();
			}
		});
		bt_luu.setOpaque(true);
		bt_luu.setIcon(new ImageIcon(QL_khachhang.class.getResource("/images/icons/icons8-save-27.png")));
		bt_luu.setHorizontalAlignment(SwingConstants.CENTER);
		bt_luu.setForeground(new Color(0, 28, 65));
		bt_luu.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_luu.setBackground(new Color(255, 212, 58));
		bt_luu.setBounds(785, 219, 213, 50);
		add(bt_luu);
		
		JLabel bt_load = new JLabel("LOAD");
		bt_load.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt_load.setBackground(new Color(204,138,0));	
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bt_load.setBackground(new Color(255,212,58));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null,
		                    "Bạn chưa chọn dòng muốn LOAD lại!",
		                    "Thông báo",
		                    JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            try {
		                // Lấy ra mã KH từ cột 0
		                int maKH = Integer.parseInt(
		                    tableModel.getValueAt(selectedRow, 0).toString()
		                );

		                // Gọi hàm tìm KH theo mã
		                Models_Khachhang updatedKH = DB_Khachhangs.getInstance().findCustomerById(maKH);

		                if (updatedKH != null) {
		                    // Cập nhật lại row đang chọn trong tableModel
		                    tableModel.setValueAt(updatedKH.getTenkh(),       selectedRow, 1);
		                    tableModel.setValueAt(updatedKH.getSdt(),         selectedRow, 2);
		                    tableModel.setValueAt(updatedKH.getTongchi(),     selectedRow, 3);
		                    tableModel.setValueAt(updatedKH.getDiemtichluy(), selectedRow, 4);
		                    tableModel.setValueAt(updatedKH.getHang(),        selectedRow, 5);

		                    // Cập nhật luôn lên các textField
		                    tf_makhachhang.setText(String.valueOf(updatedKH.getMakh()));
		                    tf_tenkhachhang.setText(updatedKH.getTenkh());
		                    tf_sdt.setText(updatedKH.getSdt());
		                    tf_sotiendanap.setText(String.valueOf(updatedKH.getTongchi()));
		                    tf_diemtichluy.setText(String.valueOf(updatedKH.getDiemtichluy()));
		                    cbb_hang.setSelectedItem(updatedKH.getHang());
		                } else {
		                    JOptionPane.showMessageDialog(null,
		                            "Không tìm thấy khách hàng trong DB!",
		                            "Thông báo",
		                            JOptionPane.WARNING_MESSAGE);
		                }
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null,
		                        "Mã khách hàng không hợp lệ!",
		                        "Lỗi",
		                        JOptionPane.ERROR_MESSAGE);
		            }
		        }
			}
		});
		bt_load.setOpaque(true);
		bt_load.setHorizontalAlignment(SwingConstants.CENTER);
		bt_load.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_load.setBackground(new Color(255, 204, 0));
		bt_load.setBounds(704, 307, 118, 46);
		add(bt_load);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        tf_makhachhang.setText(table.getValueAt(selectedRow, 0).toString());
                        tf_tenkhachhang.setText(table.getValueAt(selectedRow, 1).toString());
                        tf_sdt.setText(table.getValueAt(selectedRow, 2).toString());
                        tf_sotiendanap.setText(table.getValueAt(selectedRow, 3).toString());
                        tf_diemtichluy.setText(table.getValueAt(selectedRow, 4).toString());
                        cbb_hang.setSelectedItem(table.getValueAt(selectedRow, 5).toString());
                    }
                }
            }
        });
		reset();

	}
	
	public void loadThanhVien() {
		ArrayList<Models_Khachhang> list = DB_Khachhangs.getInstance().loadThanhVien();
		tableModel.setRowCount(0);
		for(Models_Khachhang khachHangMoi : list) {
	        Object[] newRow = {khachHangMoi.getMakh(), khachHangMoi.getTenkh(), khachHangMoi.getSdt(), khachHangMoi.getTongchi(), khachHangMoi.getDiemtichluy(), khachHangMoi.getHang()};
	        tableModel.addRow(newRow);
		}
	}
	
	public void themThanhVien(Models_Khachhang khachhang) {
		Models_Khachhang khachHangMoi = DB_Khachhangs.getInstance().themThanhVien(khachhang);
        Object[] newRow = {khachHangMoi.getMakh(), khachHangMoi.getTenkh(), khachHangMoi.getSdt(), khachHangMoi.getTongchi(), khachHangMoi.getDiemtichluy(), khachHangMoi.getHang()};
        tableModel.addRow(newRow);
	}
	
	
	public void suaThongTin() {
		int makh = Integer.parseInt(tf_makhachhang.getText());
		String tenkh = tf_tenkhachhang.getText();
		String sdt = tf_sdt.getText();
		int diemtichluy = Integer.parseInt(tf_diemtichluy.getText());
		int tongchi = Integer.parseInt(tf_sotiendanap.getText());
		String hang = cbb_hang.getSelectedItem().toString();
		
		Models_Khachhang khachHang = new Models_Khachhang(makh, tenkh, sdt, tongchi, diemtichluy, hang);		
		
		DB_Khachhangs.getInstance().suaThongTin(khachHang);
	}
	
	public void xoaThanhVien(int maKhachHang) {
		DB_Khachhangs.getInstance().xoaThanhVien(maKhachHang);
	}
	
	public void reset() {
		tf_diemtichluy.setText("");
		tf_makhachhang.setText("");
		tf_sdt.setText("");
		tf_tenkhachhang.setText("");
		tf_sotiendanap.setText("");
		cbb_hang.setSelectedIndex(0);
		
		tf_diemtichluy.setEditable(false);
		tf_makhachhang.setEditable(false);
		tf_sdt.setEditable(false);
		tf_tenkhachhang.setEditable(false);
		tf_sotiendanap.setEditable(false);
		cbb_hang.setEnabled(false);
	}
	
	public void unreset() {
		tf_diemtichluy.setEditable(true);
		tf_makhachhang.setEditable(true);
		tf_sdt.setEditable(true);
		tf_tenkhachhang.setEditable(true);
		tf_sotiendanap.setEditable(true);
		cbb_hang.setEnabled(true);
	}
	
	public void loadThanhVien2() {
	    customerList = DB_Khachhangs.getInstance().loadThanhVien(); // Lưu danh sách vào customerList
	    tableModel.setRowCount(0); // Làm mới bảng
	    for (Models_Khachhang khachHangMoi : customerList) {
	        Object[] newRow = {
	            khachHangMoi.getMakh(),
	            khachHangMoi.getTenkh(),
	            khachHangMoi.getSdt(),
	            khachHangMoi.getTongchi(),
	            khachHangMoi.getDiemtichluy(),
	            khachHangMoi.getHang()
	        };
	        tableModel.addRow(newRow); // Cập nhật vào bảng
	    }
	}

	
	public Models_Khachhang findCustomerByPhone(String phone) {
	    for (Models_Khachhang customer : customerList) { // customerList là danh sách khách hàng
	        if (customer.getSdt().equals(phone)) {
	            return customer;
	        }
	    }
	    return null; // Khách hàng không tồn tại
	}



	public void updateCustomerTotalSpent(String phone, int amount) {
	    for (Models_Khachhang customer : customerList) {
	        if (customer.getSdt().equals(phone)) {
	            customer.setTongchi(customer.getTongchi() + amount); // Cộng thêm tiền vào tổng chi
	            System.out.println("Cập nhật thành công cho khách hàng: " + customer.getTenkh());
	            break;
	        }
	    }
	}
	
	public void updateComputerStatus(int computerId, String status) {
	    // Ví dụ cập nhật trạng thái trên bảng giao diện hoặc danh sách máy tính
	    System.out.println("Máy tính " + computerId + ": " + status);
	}


	public void updateCustomerDeposit(String phone, int amount) {
	    Models_Khachhang customer = findCustomerByPhone(phone);
	    if (customer != null) {
	        DB_Khachhangs.getInstance().updateCustomerDeposit(phone, amount);
	        customer.setTongchi(customer.getTongchi() + amount);
	        loadThanhVien2(); // Làm mới bảng hiển thị
	    } else {
	        JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại. Vui lòng thêm khách hàng trước.");
	    }
	}
}

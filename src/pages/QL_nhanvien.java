package pages;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Outcode.XMLExporters;
import dao.DBNhanViens;
import models.Models_Nhanvien;
import swings.PlaceholderTextFields;
import views.component.ThemNV;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class QL_nhanvien extends JPanel{
	private JTextField tf_manhanvien;
	private JTextField tf_tennhanvien;
	private JTextField tf_cccd;
	private JTextField tf_ngaysinh;
	private JTextField tf_sdt;
	private JTextField tf_luong;
	private JTable table;
	private JComboBox cbb_gioitinh;
	private JComboBox cbb_vaitro;
	private DefaultTableModel tableModel;
	private JTextField tf_timKiem;
	private JButton bt_luu;
	

	public QL_nhanvien() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 900);	
		setLayout(null);
		
		JLabel lb_title_nhanvien = new JLabel("");
		lb_title_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_nhanvien.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_nhanvien.setBounds(350, 10, 445, 64);
		add(lb_title_nhanvien);
		
		JLabel lb_manv = new JLabel("Mã nhân viên");
		lb_manv.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_manv.setBounds(20, 103, 154, 30);
		add(lb_manv);
		
		tf_manhanvien = new JTextField();
		tf_manhanvien.setBounds(184, 103, 268, 29);
		add(tf_manhanvien);
		tf_manhanvien.setColumns(10);
		
		JLabel lb_tennhanvien = new JLabel("Tên nhân viên");
		lb_tennhanvien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_tennhanvien.setBounds(20, 162, 154, 30);
		add(lb_tennhanvien);
		
		tf_tennhanvien = new JTextField();
		tf_tennhanvien.setColumns(10);
		tf_tennhanvien.setBounds(184, 162, 268, 29);
		add(tf_tennhanvien);
		
		JLabel lb_cccd = new JLabel("CCCD");
		lb_cccd.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_cccd.setBounds(20, 218, 154, 30);
		add(lb_cccd);
		
		tf_cccd = new JTextField();
		tf_cccd.setColumns(10);
		tf_cccd.setBounds(184, 218, 268, 29);
		add(tf_cccd);
		
		JLabel lb_gioitinh = new JLabel("Giới tính");
		lb_gioitinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_gioitinh.setBounds(20, 278, 154, 30);
		add(lb_gioitinh);
		
		String[] itemGioiTinh = { "Nam", "Nữ" };
		cbb_gioitinh = new JComboBox<>(itemGioiTinh);
		cbb_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_gioitinh.setBounds(184, 278, 268, 30);
		add(cbb_gioitinh);
		
		JLabel lb_ngaysinh = new JLabel("Ngày sinh");
		lb_ngaysinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_ngaysinh.setBounds(499, 103, 136, 30);
		add(lb_ngaysinh);
		
		tf_ngaysinh = new JTextField();
		tf_ngaysinh.setColumns(10);
		tf_ngaysinh.setBounds(645, 103, 268, 29);
		add(tf_ngaysinh);
		
		JLabel lb_sdt = new JLabel("Số điện thoại");
		lb_sdt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_sdt.setBounds(499, 162, 136, 30);
		add(lb_sdt);
		
		tf_sdt = new JTextField();
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(645, 162, 268, 29);
		add(tf_sdt);
		
		JLabel lb_luong = new JLabel("Lương");
		lb_luong.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_luong.setBounds(499, 218, 136, 30);
		add(lb_luong);
		
		tf_luong = new JTextField();
		tf_luong.setColumns(10);
		tf_luong.setBounds(645, 218, 268, 29);
		add(tf_luong);
		
		JLabel lb_vaitro = new JLabel("Vai trò");
		lb_vaitro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_vaitro.setBounds(499, 278, 136, 30);
		add(lb_vaitro);
		
		String[] itemvaitro = {"Quản lý", "Nhân viên", "Bảo vệ" }; 
		cbb_vaitro = new JComboBox<>(itemvaitro);
		cbb_vaitro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_vaitro.setBounds(645, 278, 268, 30);
		add(cbb_vaitro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 405, 1113, 411);
		add(scrollPane);
		
		tableModel = new DefaultTableModel(
				new Object[][] {},
		        new String[] {
		          		 "Mã nhân viên", "Tên nhân viên", "CCCD", "Giới tính", "Ngày sinh", "Số điện thoại", "Chức vụ", "Lương"
		           });
       		
		table = new JTable();
		table.setModel(tableModel);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(240);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(133);
		table.getColumnModel().getColumn(5).setPreferredWidth(170);
		table.getColumnModel().getColumn(6).setPreferredWidth(133);
		table.getColumnModel().getColumn(7).setPreferredWidth(171);
		scrollPane.setViewportView(table);		
		
//		Font headerFont = new Font("Arial", Font.BOLD, 20);
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 30));
//		table.getTableHeader().setFont(headerFont);
		table.setRowHeight(40);

		
		
		
		JLabel bt_themnhanvien = new JLabel("THÊM NHÂN VIÊN");
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
	        	ThemNV them = new ThemNV(dialog);
	    		dialog.getContentPane().setLayout(new GridLayout(1,1));
	    		dialog.setSize(1000, 500);
	    		dialog.setLocationRelativeTo(null);
	        	dialog.getContentPane().add(them);
	        	dialog.setVisible(true);
			}
		});
		bt_themnhanvien.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/icons/icons8-add-35.png")));
		bt_themnhanvien.setForeground(new Color(255,212,58));
		bt_themnhanvien.setBackground(new Color(0,28,65));
		bt_themnhanvien.setOpaque(true);
		bt_themnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_themnhanvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_themnhanvien.setBounds(942, 118, 196, 50);
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
				if(tf_manhanvien.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng muốn sửa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					unreset();
					bt_luu.setVisible(true);
				}
			}
		});
		bt_suathongtin.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/icons/icons8-edit-text-file-35.png")));
		bt_suathongtin.setOpaque(true);
		bt_suathongtin.setHorizontalAlignment(SwingConstants.CENTER);
		bt_suathongtin.setForeground(new Color(255, 212, 58));
		bt_suathongtin.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_suathongtin.setBackground(new Color(0, 28, 65));
		bt_suathongtin.setBounds(942, 179, 196, 50);
		add(bt_suathongtin);
		
		JLabel bt_xoanhanvien = new JLabel("XÓA NHÂN VIÊN");
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
				if(tf_manhanvien.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng muốn xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					xoaNhanVien(Integer.parseInt(tf_manhanvien.getText()));
					reset();
					loadNhanVien();
				}
			}
		});
		bt_xoanhanvien.setIcon(new ImageIcon(QL_nhanvien.class.getResource("/images/icons/icons8-delete-35.png")));
		bt_xoanhanvien.setOpaque(true);
		bt_xoanhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		bt_xoanhanvien.setForeground(new Color(255, 212, 58));
		bt_xoanhanvien.setFont(new Font("Tahoma", Font.BOLD, 16));
		bt_xoanhanvien.setBackground(new Color(0, 28, 65));
		bt_xoanhanvien.setBounds(942, 240, 196, 50);
		add(bt_xoanhanvien);
		
		tf_timKiem = new PlaceholderTextFields("Nhập tên nhân viên...");
		tf_timKiem.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                timkiem();
            }
            public void removeUpdate(DocumentEvent e) {
                timkiem();
            }
            public void changedUpdate(DocumentEvent e) {
                timkiem();
            }
        });
		tf_timKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		tf_timKiem.setBounds(20, 353, 341, 37);
		add(tf_timKiem);
		tf_timKiem.setColumns(10);
		
		// KHI KICK CHỌN 1 DÒNG
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	       bt_luu = new JButton("LƯU");
	        bt_luu.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		suaThongTin();
	        		reset();
	        		bt_luu.setVisible(false);
	        		loadNhanVien();
	        	}
	        });
	        bt_luu.setFont(new Font("Tahoma", Font.BOLD, 20));
	        bt_luu.setBounds(814, 332, 105, 37);
	        bt_luu.setVisible(false);
	        add(bt_luu);
	        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    int selectedRow = table.getSelectedRow();
	                    if (selectedRow != -1) {
	                        tf_manhanvien.setText(table.getValueAt(selectedRow, 0).toString());
	                        tf_tennhanvien.setText(table.getValueAt(selectedRow, 1).toString());
	                        tf_cccd.setText(table.getValueAt(selectedRow, 2).toString());
	                        cbb_gioitinh.setSelectedItem(table.getValueAt(selectedRow, 3).toString());
	                        tf_ngaysinh.setText(table.getValueAt(selectedRow, 4).toString());
	                        tf_sdt.setText(table.getValueAt(selectedRow, 5).toString());
	                        cbb_vaitro.setSelectedItem(table.getValueAt(selectedRow, 6).toString());
	                        tf_luong.setText(table.getValueAt(selectedRow, 7).toString());
	                    }
	                }
	            }
	        });
	        reset();
		
	}
	
	public void loadNhanVien() {
		ArrayList<Models_Nhanvien> list = DBNhanViens.getInstance().loadNhanVien();
		tableModel.setRowCount(0);
		for(Models_Nhanvien nhanVienMoi : list) {
	        Object[] newRow = {nhanVienMoi.getManv(), nhanVienMoi.getTennv(), nhanVienMoi.getCccd(), nhanVienMoi.getGioitinh(), nhanVienMoi.getNgaysinh(), nhanVienMoi.getSdt(), nhanVienMoi.getChucvu(), nhanVienMoi.getLuong()};
	        tableModel.addRow(newRow);
		}
	}
	
	public void themnhanvien(Models_Nhanvien nhanvien) {
		Models_Nhanvien nhanVienMoi = DBNhanViens.getInstance().themNhanVien(nhanvien);
        Object[] newRow = {nhanVienMoi.getManv(), nhanVienMoi.getTennv(), nhanVienMoi.getCccd(), nhanVienMoi.getGioitinh(), nhanVienMoi.getNgaysinh(), nhanVienMoi.getSdt(), nhanVienMoi.getChucvu(), nhanVienMoi.getLuong()};
        tableModel.addRow(newRow);
	}
	
	public void themnhanvien2(Models_Nhanvien nhanvien) {
		Models_Nhanvien nhanVienMoi = DBNhanViens.getInstance().themNhanVien2(nhanvien);
        Object[] newRow = {nhanVienMoi.getManv(), nhanVienMoi.getTennv(), nhanVienMoi.getCccd(), nhanVienMoi.getGioitinh(), nhanVienMoi.getNgaysinh(), nhanVienMoi.getSdt(), nhanVienMoi.getChucvu(), nhanVienMoi.getLuong()};
        tableModel.addRow(newRow);
	}
	
	public void suaThongTin() {
		int maNhanVien = Integer.parseInt(tf_manhanvien.getText());
		String tennv = tf_tennhanvien.getText();
		String cccd = tf_cccd.getText();
		String gioitinh = cbb_gioitinh.getSelectedItem().toString();
		java.sql.Date dateSql = null;	
		try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateUtil = sdf.parse(tf_ngaysinh.getText());
            dateSql = new java.sql.Date(dateUtil.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sdt = tf_sdt.getText();
		String vaitro = cbb_vaitro.getSelectedItem().toString();
		int luong = Integer.parseInt(tf_luong.getText());
		
		Models_Nhanvien nhanVien = new Models_Nhanvien(maNhanVien, tennv, cccd, gioitinh, dateSql, sdt, vaitro, luong);
		DBNhanViens.getInstance().suaThongTin(nhanVien);
	}
	
	public void xoaNhanVien(int maNhanVien) {
		DBNhanViens.getInstance().xoaNhanVien(maNhanVien);
	}
	
	public void timkiem() {
		String name = tf_timKiem.getText();
		if(name.isEmpty() || name.equals("Nhập tên nhân viên...")) {
			loadNhanVien();
		}
		else {
			ArrayList<Models_Nhanvien> list = DBNhanViens.getInstance().timkiem("%" + name + "%");
			tableModel.setRowCount(0);
			for(Models_Nhanvien nhanVienMoi : list) {
		        Object[] newRow = {nhanVienMoi.getManv(), nhanVienMoi.getTennv(), nhanVienMoi.getCccd(), nhanVienMoi.getGioitinh(), nhanVienMoi.getNgaysinh(), nhanVienMoi.getSdt(), nhanVienMoi.getChucvu(), nhanVienMoi.getLuong()};
		        tableModel.addRow(newRow);
			}
		}	
		
		reset();
	}
	
	public void reset() {
		tf_manhanvien.setText("");
		tf_tennhanvien.setText("");
		tf_ngaysinh.setText("");
		tf_cccd.setText("");
		tf_sdt.setText("");
		tf_luong.setText("");
		cbb_gioitinh.setSelectedIndex(0);
		cbb_vaitro.setSelectedIndex(0);
		
		tf_manhanvien.setEditable(false);
		tf_tennhanvien.setEditable(false);
		tf_ngaysinh.setEditable(false);
		tf_cccd.setEditable(false);
		tf_sdt.setEditable(false);
		tf_luong.setEditable(false);
		cbb_gioitinh.setEnabled(false);
		cbb_vaitro.setEnabled(false);
	}
	
	public void unreset() {		
//		tf_manhanvien.setEditable(true);
		tf_tennhanvien.setEditable(true);
		tf_ngaysinh.setEditable(true);
		tf_cccd.setEditable(true);
		tf_sdt.setEditable(true);
		tf_luong.setEditable(true);
		cbb_gioitinh.setEnabled(true);
		cbb_vaitro.setEnabled(true);
	}
	
}

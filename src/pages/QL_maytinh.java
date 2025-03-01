package pages;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.DB_Khachhangs;
import models.Models_Khachhang;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//import java.util.HashMap;





public class QL_maytinh extends JPanel{
	private Panel pn_hang1_t3;
	private Panel pn_hang2_t3;
	private Panel pn_hang3_t3;
	public JTable table;
	private QL_khachhang khachHangManager;
//	private HashMap<Integer, Timer> timerMap = new HashMap<>();

	public QL_maytinh(QL_khachhang khachHangManager) {
		this.khachHangManager = khachHangManager;
		
		setBackground(new Color(255, 255, 255));
		setSize(1170, 891);	
		setLayout(null);
		
		JLabel lb_title_nhanvien = new JLabel("");
		lb_title_nhanvien.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_nhanvien.setBounds(348, 0, 445, 59);
		add(lb_title_nhanvien);
		
		JLabel bt_may1 = new JLabel("");
		bt_may1.setBackground(new Color(0, 153, 204));
		bt_may1.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				 bt_may1.setBackground(new Color(34, 133, 205)); // Màu sáng hơn khi hover
			        bt_may1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 255, 0), 3)); // Đường viền xanh lá cây
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	bt_may1.setBackground(new Color(0, 153, 204)); // Màu ban đầu khi chuột rời đi
                bt_may1.setBorder(null); // Xóa đường viền
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				selectComputer(1); // Gọi máy tính số 1
			}
		});
		bt_may1.setHorizontalAlignment(SwingConstants.CENTER);
		bt_may1.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/icons8-computer-200.png")));
		bt_may1.setBounds(117, 62, 200, 181);
		add(bt_may1);
		
		JLabel bt_may2 = new JLabel("");
		bt_may2.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				bt_may2.setBackground(new Color(34, 133, 205)); // Màu sáng hơn khi hover
				bt_may2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 255, 0), 3)); // Đường viền xanh lá cây
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	bt_may2.setBackground(new Color(0, 153, 204)); // Màu ban đầu khi chuột rời đi
            	bt_may2.setBorder(null); // Xóa đường viền
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				 selectComputer(2); // Gọi máy tính số 2
			}
		});
		bt_may2.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/icons8-computer-200.png")));
		bt_may2.setHorizontalAlignment(SwingConstants.CENTER);
		bt_may2.setBounds(361, 62, 200, 181);
		add(bt_may2);
		
		JLabel bt_may3 = new JLabel("");
		bt_may3.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				bt_may3.setBackground(new Color(34, 133, 205)); // Màu sáng hơn khi hover
				bt_may3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 255, 0), 3)); // Đường viền xanh lá cây
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	bt_may3.setBackground(new Color(0, 153, 204)); // Màu ban đầu khi chuột rời đi
            	bt_may3.setBorder(null); // Xóa đường viền
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				selectComputer(3); // Gọi máy tính số 3
			}
		});
		bt_may3.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/icons8-computer-200.png")));
		bt_may3.setHorizontalAlignment(SwingConstants.CENTER);
		bt_may3.setBounds(607, 62, 200, 181);
		add(bt_may3);
		
		JLabel bt_may4 = new JLabel("");
		bt_may4.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				bt_may4.setBackground(new Color(34, 133, 205)); // Màu sáng hơn khi hover
				bt_may4.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 255, 0), 3)); // Đường viền xanh lá cây
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	bt_may4.setBackground(new Color(0, 153, 204)); // Màu ban đầu khi chuột rời đi
            	bt_may4.setBorder(null); // Xóa đường viền
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				selectComputer(4); // Gọi máy tính số 4
			}
		});
		bt_may4.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/icons8-computer-200.png")));
		bt_may4.setHorizontalAlignment(SwingConstants.CENTER);
		bt_may4.setBounds(851, 62, 200, 181);
		add(bt_may4);
		
		JLabel bt_may5 = new JLabel("");
		bt_may5.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				bt_may5.setBackground(new Color(34, 133, 205)); // Màu sáng hơn khi hover
				bt_may5.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 255, 0), 3)); // Đường viền xanh lá cây
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	bt_may5.setBackground(new Color(0, 153, 204)); // Màu ban đầu khi chuột rời đi
            	bt_may5.setBorder(null); // Xóa đường viền
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				selectComputer(5); // Gọi máy tính số 5
			}
		});
		bt_may5.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/icons8-computer-200.png")));
		bt_may5.setHorizontalAlignment(SwingConstants.CENTER);
		bt_may5.setBounds(117, 272, 200, 181);
		add(bt_may5);
		
		JLabel bt_may6 = new JLabel("");
		bt_may6.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				bt_may6.setBackground(new Color(34, 133, 205)); // Màu sáng hơn khi hover
				bt_may6.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 255, 0), 3)); // Đường viền xanh lá cây
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	bt_may6.setBackground(new Color(0, 153, 204)); // Màu ban đầu khi chuột rời đi
            	bt_may6.setBorder(null); // Xóa đường viền
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				selectComputer(6); // Gọi máy tính số 6
			}
		});
		bt_may6.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/icons8-computer-200.png")));
		bt_may6.setHorizontalAlignment(SwingConstants.CENTER);
		bt_may6.setBounds(361, 272, 200, 181);
		add(bt_may6);
		
		JLabel bt_may7 = new JLabel("");
		bt_may7.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				bt_may7.setBackground(new Color(34, 133, 205)); // Màu sáng hơn khi hover
				bt_may7.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 255, 0), 3)); // Đường viền xanh lá cây
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	bt_may7.setBackground(new Color(0, 153, 204)); // Màu ban đầu khi chuột rời đi
            	bt_may7.setBorder(null); // Xóa đường viền
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				 selectComputer(7); // Gọi máy tính số 7
			}
		});
		bt_may7.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/icons8-computer-200.png")));
		bt_may7.setHorizontalAlignment(SwingConstants.CENTER);
		bt_may7.setBounds(607, 272, 200, 181);
		add(bt_may7);
		
		JLabel bt_may8 = new JLabel("");
		bt_may8.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e) {
				bt_may8.setBackground(new Color(34, 133, 205)); // Màu sáng hơn khi hover
				bt_may8.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 255, 0), 3)); // Đường viền xanh lá cây
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	bt_may8.setBackground(new Color(0, 153, 204)); // Màu ban đầu khi chuột rời đi
            	bt_may8.setBorder(null); // Xóa đường viền
            }
			@Override
			public void mouseClicked(MouseEvent e) {
				selectComputer(8); // Gọi máy tính số 8
			}
		});
		bt_may8.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/icons8-computer-200.png")));
		bt_may8.setHorizontalAlignment(SwingConstants.CENTER);
		bt_may8.setBounds(851, 272, 200, 181);
		add(bt_may8);
		
		JLabel lbmaytext_01 = new JLabel("MÁY 01");
		JLabel lbmaytext_02 = new JLabel("MÁY 02");
		JLabel lbmaytext_03 = new JLabel("MÁY 03");
		JLabel lbmaytext_04 = new JLabel("MÁY 04");
		JLabel lbmaytext_05 = new JLabel("MÁY 05");
		JLabel lbmaytext_06 = new JLabel("MÁY 06");
		JLabel lbmaytext_07 = new JLabel("MÁY 07");
		JLabel lbmaytext_08 = new JLabel("MÁY 08");
		
		lbmaytext_01.setHorizontalAlignment(SwingConstants.CENTER);
		lbmaytext_01.setForeground(new Color(255, 0, 0));
		lbmaytext_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbmaytext_01.setBounds(194, 243, 48, 14);
		add(lbmaytext_01);
		
		
		lbmaytext_02.setHorizontalAlignment(SwingConstants.CENTER);
		lbmaytext_02.setForeground(Color.RED);
		lbmaytext_02.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbmaytext_02.setBounds(437, 243, 48, 14);
		add(lbmaytext_02);
		
		
		lbmaytext_03.setHorizontalAlignment(SwingConstants.CENTER);
		lbmaytext_03.setForeground(Color.RED);
		lbmaytext_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbmaytext_03.setBounds(685, 243, 48, 14);
		add(lbmaytext_03);
		
		
		lbmaytext_04.setHorizontalAlignment(SwingConstants.CENTER);
		lbmaytext_04.setForeground(Color.RED);
		lbmaytext_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbmaytext_04.setBounds(932, 243, 48, 14);
		add(lbmaytext_04);
		
		
		lbmaytext_05.setHorizontalAlignment(SwingConstants.CENTER);
		lbmaytext_05.setForeground(Color.RED);
		lbmaytext_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbmaytext_05.setBounds(194, 451, 48, 14);
		add(lbmaytext_05);
		
		
		lbmaytext_06.setHorizontalAlignment(SwingConstants.CENTER);
		lbmaytext_06.setForeground(Color.RED);
		lbmaytext_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbmaytext_06.setBounds(437, 451, 48, 14);
		add(lbmaytext_06);
		
		
		lbmaytext_07.setHorizontalAlignment(SwingConstants.CENTER);
		lbmaytext_07.setForeground(Color.RED);
		lbmaytext_07.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbmaytext_07.setBounds(685, 451, 48, 14);
		add(lbmaytext_07);
		
		
		lbmaytext_08.setHorizontalAlignment(SwingConstants.CENTER);
		lbmaytext_08.setForeground(Color.RED);
		lbmaytext_08.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbmaytext_08.setBounds(932, 451, 48, 14);
		add(lbmaytext_08);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 486, 1060, 306);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	            		"Mã máy", "Thời gian bắt đầu", "Thời gian còn lại", "Trạng thái", "Khách hàng"
	            }
	        ));
		scrollPane.setViewportView(table);
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 30));
		table.setRowHeight(40);
		
	}
	
	
	
	public void selectComputer(int computerId) {
	    JTextField phoneField = new JTextField();
	    JTextField moneyField = new JTextField();

	    Object[] message = {
	        "Số điện thoại:", phoneField,
	        "Số tiền nạp:", moneyField,
	    };

	    int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin khách hàng", JOptionPane.OK_CANCEL_OPTION);
	    if (option == JOptionPane.OK_OPTION) {
	        String phone = phoneField.getText();
	        int money;
	        try {
	            money = Integer.parseInt(moneyField.getText());
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền hợp lệ!");
	            return;
	        }

	        Models_Khachhang customer = DB_Khachhangs.getInstance().tracuu1(phone);

	        if (customer != null) {
	            int playTime = money / 1000; // Chuyển số tiền thành thời gian chơi (1 phút = 1000 đồng)
	            DB_Khachhangs.getInstance().updateCustomerDeposit(phone, money); // Cập nhật tiền nạp vào CSDL

	            // Định dạng thời gian hiện tại
	            LocalTime now = LocalTime.now();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	            String formattedTime = now.format(formatter);

	            // Cập nhật bảng với thông tin đầy đủ
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.addRow(new Object[]{
	                computerId,
	                formattedTime,                  // Thời gian bắt đầu (định dạng HH:mm:ss)
	                playTime + " phút",             // Thời gian còn lại
	                "Đang sử dụng",                 // Trạng thái ban đầu
	                customer.getTenkh()             // Tên khách hàng
	            });

	            // Bắt đầu đếm ngược
	            startPlayTime(computerId, playTime);
	        } else {
	            JOptionPane.showMessageDialog(null, "Khách hàng chưa tồn tại. Vui lòng thêm khách hàng trước!");
	        }
	    }
	}

	
	public void startPlayTime(int computerId, int playTime) {
	    Timer timer = new Timer(1000, new ActionListener() { // 1 giây = 1000ms
	        int remainingTime = playTime * 60; // Chuyển phút sang giây

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (remainingTime > 0) {
	                remainingTime--;

	                // Tính phút và giây còn lại
	                int minutes = remainingTime / 60;
	                int seconds = remainingTime % 60;
	                String timeDisplay;

	                if (minutes > 0) {
	                    timeDisplay = minutes + " phút " + seconds + " giây";
	                } else {
	                    timeDisplay = seconds + " giây";
	                }

	                // Cập nhật thời gian còn lại trong bảng
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
	                for (int i = 0; i < model.getRowCount(); i++) {
	                    if ((int) model.getValueAt(i, 0) == computerId) {
	                        model.setValueAt(timeDisplay, i, 2); // Cột "Thời gian còn lại"
	                        break;
	                    }
	                }

	                // Cập nhật trạng thái máy tính
	                updateComputerStatus(computerId, "Đang sử dụng: " + timeDisplay);
	            } else {
	                ((Timer) e.getSource()).stop(); // Dừng timer khi hết giờ

	                // Cập nhật trạng thái máy tính trong bảng
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
	                for (int i = 0; i < model.getRowCount(); i++) {
	                    if ((int) model.getValueAt(i, 0) == computerId) {
	                        model.setValueAt("Hết giờ", i, 2); // Cột "Thời gian còn lại"
	                        model.setValueAt("Ngừng hoạt động", i, 3); // Cột "Trạng thái"
	                        break;
	                    }
	                }

	                // Hiển thị thông báo hết giờ
	                JOptionPane.showMessageDialog(null, "Máy " + computerId + " đã hết thời gian chơi! Vui lòng nạp thêm tiền.");
	                updateComputerStatus(computerId, "Ngừng hoạt động");
	            }
	        }
	    });
	    timer.start();
	}

	
	public void updateComputerStatus(int computerId, String status) {
	    // Cập nhật trạng thái máy tính trên giao diện hoặc danh sách máy tính
	    System.out.println("Máy tính " + computerId + ": " + status);
	}
}

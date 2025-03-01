package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import services.Services;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Sidebar sidebar;
	private Bodys body;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1450, 900);
		setTitle("Game store");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new MigLayout("fillx, filly", "0[280!]0[fill, 100%]0", "0[fill]0"));
		
		sidebar = new Sidebar();
		contentPane.add(sidebar, "width 280:280:280");
		
		body = new Bodys();
		contentPane.add(body, "width 1170:1170:1170");

		setContentPane(contentPane);
		
		Services.getInstance(this);
	}
	
	public Sidebar getSidebar() {
		return sidebar;
	}

	public Bodys getBody() {
		return body;
	}

}

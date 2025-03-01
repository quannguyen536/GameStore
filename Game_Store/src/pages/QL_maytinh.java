package pages;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import views.computer.May1;
import views.computer.May10;
import views.computer.May11;
import views.computer.May12;
import views.computer.May13;
import views.computer.May14;
import views.computer.May15;
import views.computer.May16;
import views.computer.May17;
import views.computer.May18;
import views.computer.May19;
import views.computer.May2;
import views.computer.May20;
import views.computer.May21;
import views.computer.May22;
import views.computer.May23;
import views.computer.May24;
import views.computer.May25;
import views.computer.May26;
import views.computer.May27;
import views.computer.May28;
import views.computer.May29;
import views.computer.May3;
import views.computer.May30;
import views.computer.May31;
import views.computer.May32;
import views.computer.May33;
import views.computer.May34;
import views.computer.May35;
import views.computer.May36;
import views.computer.May37;
import views.computer.May38;
import views.computer.May39;
import views.computer.May4;
import views.computer.May40;
import views.computer.May41;
import views.computer.May42;
import views.computer.May43;
import views.computer.May44;
import views.computer.May45;
import views.computer.May46;
import views.computer.May47;
import views.computer.May48;
import views.computer.May49;
import views.computer.May5;
import views.computer.May50;
import views.computer.May51;
import views.computer.May52;
import views.computer.May53;
import views.computer.May54;
import views.computer.May6;
import views.computer.May7;
import views.computer.May8;
import views.computer.May9;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Panel;

public class QL_maytinh extends JPanel{
	private JPanel pn_tang1;
	private JPanel pn_tang2;
	private JPanel pn_tang3;
	private Panel pn_hang1_t1;
	private Panel pn_hang2_t1;
	private Panel pn_hang3_t1;
	private Panel pn_hang1_t2;
	private Panel pn_hang2_t2;
	private Panel pn_hang3_t2;
	private Panel pn_hang1_t3;
	private Panel pn_hang2_t3;
	private Panel pn_hang3_t3;

	public QL_maytinh() {
		setBackground(new Color(255, 255, 255));
		setSize(1170, 891);	
		setLayout(null);
		
		JLabel lb_title_nhanvien = new JLabel("");
		lb_title_nhanvien.setIcon(new ImageIcon(QL_maytinh.class.getResource("/images/logos/logo_title_445x64.png")));
		lb_title_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title_nhanvien.setBounds(348, 0, 445, 64);
		add(lb_title_nhanvien);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 52, 1100, 771);
		add(tabbedPane);
		//		===============================================================================================================================
		//		===============================================================================================================================
		//		===============================================================================================================================
				//		QUAN LI TANG 1
				pn_tang1 = new JPanel();
				pn_tang1.setForeground(new Color(255,212,58));
				pn_tang1.setBackground(new Color(0,28,65));
				tabbedPane.addTab("Tầng 1", null, pn_tang1, null);
				pn_tang1.setLayout(null);
				
//===============================================================================================================================
				pn_hang1_t1 = new Panel();
				pn_hang1_t1.setBackground(new Color(255, 204, 0));
				pn_hang1_t1.setBounds(39, 26, 1019, 212);
				pn_tang1.add(pn_hang1_t1);
				pn_hang1_t1.setLayout(null);
				
				May1 may1 = new May1();
				may1.setBounds(32, 0, 141, 212);
				pn_hang1_t1.add(may1);
				
				May2 may2 = new May2();
				may2.setBounds(196, 0, 141, 212);
				pn_hang1_t1.add(may2);
				
				May3 may3 = new May3();
				may3.setBounds(360, 0, 141, 212);
				pn_hang1_t1.add(may3);
				
				May4 may4 = new May4();
				may4.setBounds(523, 0, 141, 212);
				pn_hang1_t1.add(may4);
				
				May5 may5 = new May5();
				may5.setBounds(685, 0, 141, 212);
				pn_hang1_t1.add(may5);
				
				May6 may6 = new May6();
				may6.setBounds(849, 0, 141, 212);
				pn_hang1_t1.add(may6);
				
//===============================================================================================================================
				pn_hang2_t1 = new Panel();
				pn_hang2_t1.setBackground(new Color(255, 204, 0));
				pn_hang2_t1.setBounds(39, 263, 1019, 212);
				pn_tang1.add(pn_hang2_t1);
				pn_hang2_t1.setLayout(null);
				
				May7 may7 = new May7();
				may7.setBounds(31, 0, 141, 212);
				pn_hang2_t1.add(may7);
				
				May8 may8 = new May8();
				may8.setBounds(195, 0, 141, 212);
				pn_hang2_t1.add(may8);
				
				May9 may9 = new May9();
				may9.setBounds(359, 0, 141, 212);
				pn_hang2_t1.add(may9);
				
				May10 may10 = new May10();
				may10.setBounds(522, 0, 141, 212);
				pn_hang2_t1.add(may10);
				
				May11 may11 = new May11();
				may11.setBounds(684, 0, 141, 212);
				pn_hang2_t1.add(may11);
				
				May12 may12 = new May12();
				may12.setBounds(848, 0, 141, 212);
				pn_hang2_t1.add(may12);
				//		===============================================================================================================================
						pn_hang3_t1 = new Panel();
						pn_hang3_t1.setBackground(new Color(255, 204, 0));
						pn_hang3_t1.setBounds(39, 503, 1019, 212);
						pn_tang1.add(pn_hang3_t1);
						pn_hang3_t1.setLayout(null);
						
		May13 may13 = new May13();
		may13.setBounds(30, 0, 141, 212);
		pn_hang3_t1.add(may13);
		
		May14 may14 = new May14();
		may14.setBounds(194, 0, 141, 212);
		pn_hang3_t1.add(may14);
		
		May15 may15 = new May15();
		may15.setBounds(358, 0, 141, 212);
		pn_hang3_t1.add(may15);
		
		May16 may16 = new May16();
		may16.setBounds(521, 0, 141, 212);
		pn_hang3_t1.add(may16);
		
		May17 may17 = new May17();
		may17.setBounds(683, 0, 141, 212);
		pn_hang3_t1.add(may17);
		
		May18 may18 = new May18();
		may18.setBounds(847, 0, 141, 212);
		pn_hang3_t1.add(may18);
//===============================================================================================================================
//===============================================================================================================================
//===============================================================================================================================
//		QUAN LI TANG 2
		pn_tang2 = new JPanel();
		pn_tang2.setForeground(new Color(255,212,58));
		pn_tang2.setBackground(new Color(0,28,65));
		tabbedPane.addTab("Tầng 2", null, pn_tang2, null);
		pn_tang2.setLayout(null);
//		===============================================================================================================================
		pn_hang1_t2 = new Panel();
		pn_hang1_t2.setBackground(new Color(255, 204, 0));
		pn_hang1_t2.setBounds(40, 28, 1019, 212);
		pn_tang2.add(pn_hang1_t2);
		pn_hang1_t2.setLayout(null);
		
		May19 may19 = new May19();
		may19.setBounds(30, 0, 141, 212);
		pn_hang1_t2.add(may19);
		
		May20 may20 = new May20();
		may20.setBounds(194, 0, 141, 212);
		pn_hang1_t2.add(may20);
		
		May21 may21 = new May21();
		may21.setBounds(358, 0, 141, 212);
		pn_hang1_t2.add(may21);
		
		May22 may22 = new May22();
		may22.setBounds(521, 0, 141, 212);
		pn_hang1_t2.add(may22);
		
		May23 may23 = new May23();
		may23.setBounds(683, 0, 141, 212);
		pn_hang1_t2.add(may23);
		
		May24 may24 = new May24();
		may24.setBounds(847, 0, 141, 212);
		pn_hang1_t2.add(may24);
//		===============================================================================================================================
		pn_hang2_t2 = new Panel();
		pn_hang2_t2.setBackground(new Color(255, 204, 0));
		pn_hang2_t2.setBounds(40, 265, 1019, 212);
		pn_tang2.add(pn_hang2_t2);
		pn_hang2_t2.setLayout(null);
		
		May25 may25 = new May25();
		may25.setBounds(31, 0, 141, 212);
		pn_hang2_t2.add(may25);
		
		May26 may26 = new May26();
		may26.setBounds(195, 0, 141, 212);
		pn_hang2_t2.add(may26);
		
		May27 may27 = new May27();
		may27.setBounds(359, 0, 141, 212);
		pn_hang2_t2.add(may27);
		
		May28 may28 = new May28();
		may28.setBounds(522, 0, 141, 212);
		pn_hang2_t2.add(may28);
		
		May29 may29 = new May29();
		may29.setBounds(684, 0, 141, 212);
		pn_hang2_t2.add(may29);
		
		May30 may30 = new May30();
		may30.setBounds(848, 0, 141, 212);
		pn_hang2_t2.add(may30);
//		===============================================================================================================================		
		pn_hang3_t2 = new Panel();
		pn_hang3_t2.setBackground(new Color(255, 204, 0));
		pn_hang3_t2.setBounds(40, 505, 1019, 212);
		pn_tang2.add(pn_hang3_t2);
		pn_hang3_t2.setLayout(null);
		
		May31 may31 = new May31();
		may31.setBounds(32, 0, 141, 212);
		pn_hang3_t2.add(may31);
		
		May32 may32 = new May32();
		may32.setBounds(196, 0, 141, 212);
		pn_hang3_t2.add(may32);
		
		May33 may33 = new May33();
		may33.setBounds(360, 0, 141, 212);
		pn_hang3_t2.add(may33);
		
		May34 may34 = new May34();
		may34.setBounds(523, 0, 141, 212);
		pn_hang3_t2.add(may34);
		
		May35 may35 = new May35();
		may35.setBounds(685, 0, 141, 212);
		pn_hang3_t2.add(may35);
		
		May36 may36 = new May36();
		may36.setBounds(849, 0, 141, 212);
		pn_hang3_t2.add(may36);
//		===============================================================================================================================
//		===============================================================================================================================
//		===============================================================================================================================
//		QUAN LI TANG 3
		pn_tang3 = new JPanel();
		pn_tang3.setForeground(new Color(255,212,58));
		pn_tang3.setBackground(new Color(0,28,65));
		tabbedPane.addTab("Tầng 3", null, pn_tang3, null);
		pn_tang3.setLayout(null);
//		===============================================================================================================================
		Panel pn_hang1_t3 = new Panel();
		pn_hang1_t3.setBackground(new Color(255, 204, 0));
		pn_hang1_t3.setBounds(36, 27, 1019, 212);
		pn_tang3.add(pn_hang1_t3);
		pn_hang1_t3.setLayout(null);
		
		May37 may37 = new May37();
		may37.setBounds(32, 0, 141, 212);
		pn_hang1_t3.add(may37);
		
		May38 may38 = new May38();
		may38.setBounds(196, 0, 141, 212);
		pn_hang1_t3.add(may38);
		
		May39 may39 = new May39();
		may39.setBounds(360, 0, 141, 212);
		pn_hang1_t3.add(may39);
		
		May40 may40 = new May40();
		may40.setBounds(523, 0, 141, 212);
		pn_hang1_t3.add(may40);
		
		May41 may41 = new May41();
		may41.setBounds(685, 0, 141, 212);
		pn_hang1_t3.add(may41);
		
		May42 may42 = new May42();
		may42.setBounds(849, 0, 141, 212);
		pn_hang1_t3.add(may42);
//		===============================================================================================================================	
		Panel pn_hang2_t3 = new Panel();
		pn_hang2_t3.setBackground(new Color(255, 204, 0));
		pn_hang2_t3.setBounds(36, 264, 1019, 212);
		pn_tang3.add(pn_hang2_t3);
		pn_hang2_t3.setLayout(null);
		
		May43 may43 = new May43();
		may43.setBounds(33, 0, 141, 212);
		pn_hang2_t3.add(may43);
		
		May44 may44 = new May44();
		may44.setBounds(197, 0, 141, 212);
		pn_hang2_t3.add(may44);
		
		May45 may45 = new May45();
		may45.setBounds(361, 0, 141, 212);
		pn_hang2_t3.add(may45);
		
		May46 may46 = new May46();
		may46.setBounds(524, 0, 141, 212);
		pn_hang2_t3.add(may46);
		
		May47 may47 = new May47();
		may47.setBounds(686, 0, 141, 212);
		pn_hang2_t3.add(may47);
		
		May48 may48 = new May48();
		may48.setBounds(850, 0, 141, 212);
		pn_hang2_t3.add(may48);
//		===============================================================================================================================	
		Panel pn_hang3_t3 = new Panel();
		pn_hang3_t3.setBackground(new Color(255, 204, 0));
		pn_hang3_t3.setBounds(36, 504, 1019, 212);
		pn_tang3.add(pn_hang3_t3);
		pn_hang3_t3.setLayout(null);
		
		May49 may49 = new May49();
		may49.setBounds(32, 0, 141, 212);
		pn_hang3_t3.add(may49);
		
		May50 may50 = new May50();
		may50.setBounds(196, 0, 141, 212);
		pn_hang3_t3.add(may50);
		
		May51 may51 = new May51();
		may51.setBounds(360, 0, 141, 212);
		pn_hang3_t3.add(may51);
		
		May52 may52 = new May52();
		may52.setBounds(523, 0, 141, 212);
		pn_hang3_t3.add(may52);
		
		May53 may53 = new May53();
		may53.setBounds(685, 0, 141, 212);
		pn_hang3_t3.add(may53);
		
		May54 may54 = new May54();
		may54.setBounds(849, 0, 141, 212);
		pn_hang3_t3.add(may54);
//===============================================================================================================================
//===============================================================================================================================
//===============================================================================================================================

	}
}

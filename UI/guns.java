package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Model.Gamer;
import Model.Guns;

import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class guns extends JFrame {
	private JPanel contentPane;
	Gamer gamer=new Gamer();
	private JPanel defo;
	
	

	public guns(Gamer insan) {
		
		gamer=insan;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\logoturuncu.png"));
		setTitle("PUBG GunGuide");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 670);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuAnasayfa=new JMenu("Anasayfa");
		menuBar.add(menuAnasayfa);
		
		JMenu menuSecenekler=new JMenu("Seçenekler");
		menuBar.add(menuSecenekler);
		
		JMenuItem mnAnasayfa = new JMenuItem("Anasayfa");
		menuAnasayfa.add(mnAnasayfa);
		mnAnasayfa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu menu=new menu(gamer);
					menu.setVisible(true);
					
					dispose();
				}});
		
		JMenuItem mnProfil = new JMenuItem("Profil");
		menuSecenekler.add(mnProfil);
		mnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profil profil=new profil(gamer);
				profil.setVisible(true);
				
				dispose();
			}});
		JMenuItem mnAyarlar = new JMenuItem("Ayarlar");
		menuSecenekler.add(mnAyarlar);
		mnAyarlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(true) {
					adminPage admin=new adminPage(gamer);
				admin.setVisible(true);
				
				dispose();}
				else {
					//admin deðilsiniz.
				}
				
			}});
		
		JMenuItem mnk = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		menuSecenekler.add(mnk);
		mnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giris gir=new giris();
				gir.setVisible(true);
				dispose();
			}});
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblHogeldin = new JLabel("Ho\u015Fgeldin");
		lblHogeldin.setBounds(627, 24, 79, 29);
		lblHogeldin.setForeground(Color.DARK_GRAY);
		lblHogeldin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblHogeldin);
		
		String mka=gamer.getKullaniciAdi();
		JLabel kullanici = new JLabel(mka);
		kullanici.setBounds(718, 24, 133, 29);
		kullanici.setFont(new Font("Tahoma", Font.PLAIN, 17));
		kullanici.setForeground(Color.WHITE);
		contentPane.add(kullanici);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 0, 888, 73);
		lblNewLabel.setIcon(new ImageIcon(guns.class.getResource("/img/ust.png")));
		lblNewLabel.setBackground(Color.ORANGE);
		contentPane.add(lblNewLabel);
		
	
		
JButton btnGeri = new JButton("");
		
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu gun=new menu(gamer);
				gun.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBackground(Color.WHITE);
		btnGeri.setIcon(new ImageIcon("/img/geri1.png"));
		btnGeri.setBounds(22, 86, 35, 34);
		contentPane.add(btnGeri);
		
		
		
		
		JRadioButton rbAR = new JRadioButton("AR");
		rbAR.setBounds(127, 90, 45, 25);
		contentPane.add(rbAR);
		rbAR.setActionCommand("AR");
		
		JRadioButton rbSMG = new JRadioButton("SMG");
		rbSMG.setBounds(176, 90, 55, 25);
		contentPane.add(rbSMG);
		rbSMG.setActionCommand("SMG");
		
		JRadioButton rbSR = new JRadioButton("SR");
		rbSR.setBounds(235, 90, 45, 25);
		contentPane.add(rbSR);
		rbSR.setActionCommand("SR");
		
		JRadioButton rbDMR = new JRadioButton("DMR");
		rbDMR.setBounds(284, 90, 55, 25);
		contentPane.add(rbDMR);
		rbDMR.setActionCommand("DMR");
		
		JRadioButton rbMG = new JRadioButton("MG");
		rbMG.setBounds(343, 90, 55, 25);
		contentPane.add(rbMG);
		rbMG.setActionCommand("MG");
		
		JRadioButton rbSG = new JRadioButton("SG");
		rbSG.setBounds(402, 90, 45, 25);
		contentPane.add(rbSG);
		rbSG.setActionCommand("SG");
		
		JRadioButton rbPistol = new JRadioButton("Pistol");
		rbPistol.setBounds(451, 90, 59, 25);
		contentPane.add(rbPistol);
		rbPistol.setActionCommand("Pistol");
		ButtonGroup grup = new ButtonGroup();
		grup.add(rbPistol);
		grup.add(rbSG);
		grup.add(rbMG);
		grup.add(rbDMR);
		grup.add(rbSR);
		grup.add(rbSMG);
		grup.add(rbAR);
		
		JButton btnGoster = new JButton("Goster");
		
		btnGoster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String secilen = grup.getSelection().getActionCommand();
				System.out.println(secilen);
				Guns secilenG=new Guns();
				
				
				
					try {
						int yatay=12;
						int dikey=128;
						int sayac=1;
						
						ResultSet gosterilcek=secilenG.viewGunsbyType(secilen);
						while(gosterilcek.next()) {
							if((sayac==2)||(sayac==3)||(sayac==6)||(sayac==7)||(sayac==4)||(sayac==8)) {
								yatay+=224;
								
							}
							if((sayac==5)) {
								yatay=12;
								dikey+=242;
								
							}
							
							JPanel panel = new JPanel();
							panel.setBounds(yatay, dikey, 174, 222);
							contentPane.add(panel);
							panel.setLayout(null);
							
							JLabel lblM = new JLabel(gosterilcek.getString("GName"));
							lblM.setFont(new Font("Tahoma", Font.BOLD, 16));
							lblM.setForeground(Color.DARK_GRAY);
							lblM.setBounds(57, 13, 61, 20);
							panel.add(lblM);
							
							JLabel label = new JLabel("");
							label.setIcon(new ImageIcon(gosterilcek.getString("GImgKucuk")));
							label.setBounds(12, 33, 150, 150);
							panel.add(label);
							
							JButton btnBilgi = new JButton("Bilgi");
							btnBilgi.setBackground(Color.ORANGE);
							btnBilgi.setForeground(Color.DARK_GRAY);
							btnBilgi.setFont(new Font("Tahoma", Font.BOLD, 14));
							btnBilgi.setBounds(57, 184, 61, 25);
							panel.add(btnBilgi);
							btnBilgi.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									Guns g=new Guns();
									
									infoGun ig;
									try {
										ig = new infoGun(gosterilcek.getInt("GID"),gamer);
										ig.setVisible(true);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									
									
									dispose();
								}});
							
							
						
							
						sayac++;
							
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnGoster.setBackground(Color.ORANGE);
		btnGoster.setBounds(528, 90, 88, 25);
		contentPane.add(btnGoster);
		
		
	
		// Tekrarlanacak  kod parçasý
	/*	Guns goster=new Guns();
		ResultSet gosterilcek;
		try {
			int yatay=12;
			int dikey=128;
			int sayac=1;
			gosterilcek = goster.viewGuns();
			while(gosterilcek.next()) {
				if((sayac==2)||(sayac==3)||(sayac==6)||(sayac==7)||(sayac==4)||(sayac==8)) {
					yatay+=224;
					
				}
				if((sayac==5)) {
					yatay=12;
					dikey+=242;
					
				}
				
				JPanel panel = new JPanel();
				panel.setBounds(yatay, dikey, 174, 222);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblM = new JLabel(gosterilcek.getString("GName"));
				lblM.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblM.setForeground(Color.DARK_GRAY);
				lblM.setBounds(57, 13, 61, 20);
				panel.add(lblM);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(gosterilcek.getString("GImgKucuk")));
				label.setBounds(12, 33, 150, 150);
				panel.add(label);
				
				JButton btnBilgi = new JButton("Bilgi");
				btnBilgi.setBackground(Color.ORANGE);
				btnBilgi.setForeground(Color.DARK_GRAY);
				btnBilgi.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnBilgi.setBounds(57, 184, 71, 25);
				panel.add(btnBilgi);
				btnBilgi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					
						infoGun ig;
						try {
							ig = new infoGun(gosterilcek.getInt("GID"),gamer);
							ig.setVisible(true);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						dispose();
					}});
				
				
			
				
			sayac++;
				
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			*///tekrarlanacak kod parçasý
			
		/*JPanel panel = new JPanel();
		panel.setBounds(12, 128, 174, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblM = new JLabel("M416");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblM.setForeground(Color.DARK_GRAY);
		lblM.setBounds(57, 13, 61, 20);
		panel.add(lblM);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\gun\\ar\\150m4.png"));
		label.setBounds(12, 33, 150, 150);
		panel.add(label);
		
		JButton btnBilgi = new JButton("Bilgi");
		btnBilgi.setBackground(Color.ORANGE);
		btnBilgi.setForeground(Color.DARK_GRAY);
		btnBilgi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBilgi.setBounds(57, 184, 61, 25);
		panel.add(btnBilgi);
		btnBilgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guns g= new Guns();
				infoGun ig=new infoGun(g,gamer);
				
				ig.setVisible(true);
				
				dispose();
			}});
		
		*/
		//tekrarlanacak kod parçasý
		
	}
}

package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Model.Armor;
import Model.Gamer;
import Model.Guns;

public class armor extends JFrame {

	private JPanel contentPane;
	Gamer gamer=new Gamer();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public armor(Gamer insan) {
		
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
		lblNewLabel.setIcon(new ImageIcon(armor.class.getResource("/img/ust.png")));
		lblNewLabel.setBackground(Color.ORANGE);
		contentPane.add(lblNewLabel);
		
	
		
		
		
		JRadioButton rbKask = new JRadioButton("Kask");
		rbKask.setBounds(127, 90, 55, 25);
		contentPane.add(rbKask);
		
		JRadioButton rbYelek = new JRadioButton("Yelek");
		rbYelek.setBounds(186, 90, 70, 25);
		contentPane.add(rbYelek);
		
		JRadioButton rbCanta = new JRadioButton("\u00C7anta");
		rbCanta.setBounds(260, 90, 70, 25);
		contentPane.add(rbCanta);
		
		Armor goster=new Armor();
		ResultSet gosterilcek;
		try {
			int yatay=12;
			int dikey=128;
			int sayac=1;
			gosterilcek = goster.viewArmor();
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
				
				JLabel lblM = new JLabel(gosterilcek.getString("AType"));
				lblM.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblM.setForeground(Color.DARK_GRAY);
				lblM.setBounds(57, 13, 61, 20);
				panel.add(lblM);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(gosterilcek.getString("AImgKucuk")));
				label.setBounds(12, 33, 150, 150);
				panel.add(label);
				
			
				
				
			
				
			sayac++;
				
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

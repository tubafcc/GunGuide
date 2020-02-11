package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Gamer;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class menu extends JFrame {

	private JPanel contentPane;
	private JButton attach;
	private JButton maps;
	private JButton armor;
	private JButton crates;
	private JButton rank;
	private JButton throwable;
	private JMenu mnProfil;
	Gamer oyuncu=new Gamer();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public menu(Gamer insan) {

		oyuncu=insan;
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
					menu menu=new menu(oyuncu);
					menu.setVisible(true);
					
					dispose();
				}});
		
		JMenuItem mnProfil = new JMenuItem("Profil");
		menuSecenekler.add(mnProfil);
		mnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profil profil=new profil(oyuncu);
				profil.setVisible(true);
				
				dispose();
			}});
		JMenuItem mnAyarlar = new JMenuItem("Ayarlar");
		menuSecenekler.add(mnAyarlar);
		mnAyarlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(true) {
				adminPage admin=new adminPage(oyuncu);
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
		
		JButton guns = new JButton("");
		guns.setIcon(new ImageIcon(menu.class.getResource("/img/deneme12.png")));
		guns.setForeground(Color.DARK_GRAY);
		guns.setFont(new Font("Tahoma", Font.PLAIN, 25));
		guns.setBackground(Color.WHITE);
		guns.setBounds(12, 86, 214, 241);
		guns.setBorderPainted(false);
		contentPane.add(guns);
		guns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guns gun=new guns(oyuncu);
				gun.setVisible(true);
				
				dispose();
			}});
		
		JButton	attach = new JButton("");
		attach.setIcon(new ImageIcon(menu.class.getResource("/img/deneme13.png")));
		attach.setForeground(Color.DARK_GRAY);
		attach.setFont(new Font("Tahoma", Font.PLAIN, 25));
		attach.setBackground(new Color(255, 228, 225));
		attach.setBounds(238, 86, 214, 241);
		contentPane.add(attach);
		attach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attach at=new attach(oyuncu);
				at.setVisible(true);
				
				dispose();
			}});
		
		JButton	maps = new JButton("");
		maps.setIcon(new ImageIcon(menu.class.getResource("/img/deneme11.png")));
		maps.setForeground(Color.DARK_GRAY);
		maps.setFont(new Font("Tahoma", Font.PLAIN, 25));
		maps.setBackground(new Color(230, 230, 250));
		maps.setBounds(460, 86, 214, 241);
		contentPane.add(maps);
		maps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				map mp=new map(oyuncu);
				mp.setVisible(true);
				
				dispose();
			}});
		
		JButton	armor = new JButton("");
		armor.setIcon(new ImageIcon(menu.class.getResource("/img/deneme14.png")));
		armor.setForeground(Color.DARK_GRAY);
		armor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		armor.setBackground(new Color(224, 255, 255));
		armor.setBounds(686, 86, 214, 241);
		contentPane.add(armor);
		armor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				armor ar=new armor(oyuncu);
				ar.setVisible(true);
				
				dispose();
			}});
		
		JButton crates = new JButton("");
		crates.setIcon(new ImageIcon(menu.class.getResource("/img/deneme15.png")));
		crates.setForeground(Color.DARK_GRAY);
		crates.setFont(new Font("Tahoma", Font.PLAIN, 25));
		crates.setBackground(new Color(240, 255, 241));
		crates.setBounds(12, 343, 214, 241);
		contentPane.add(crates);
		crates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crates cr=new crates(oyuncu);
				cr.setVisible(true);
				
				dispose();
			}});
		
		JButton rank = new JButton("");
		rank.setIcon(new ImageIcon(menu.class.getResource("/img/deneme16.png")));
		rank.setForeground(Color.DARK_GRAY);
		rank.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rank.setBackground(new Color(255, 228, 196));
		rank.setBounds(238, 343, 214, 241);
		contentPane.add(rank);
		rank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rank menu=new rank(oyuncu);
				menu.setVisible(true);
				
				dispose();
			}});
		
		JButton throwable = new JButton("");
		throwable.setIcon(new ImageIcon(menu.class.getResource("/img/deneme17.png")));
		throwable.setForeground(Color.DARK_GRAY);
		throwable.setFont(new Font("Tahoma", Font.PLAIN, 25));
		throwable.setBackground(new Color(216, 191, 216));
		throwable.setBounds(460, 343, 214, 241);
		contentPane.add(throwable);
		throwable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				throwable menu=new throwable(oyuncu);
				menu.setVisible(true);
				
				dispose();
			}});
		
		JButton	melee = new JButton("");
		melee.setIcon(new ImageIcon(menu.class.getResource("/img/deneme18.png")));
		melee.setForeground(Color.DARK_GRAY);
		melee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		melee.setBackground(new Color(127, 255, 212));
		melee.setBounds(686, 343, 214, 241);
		contentPane.add(melee);
		melee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mele menu=new mele(oyuncu);
				menu.setVisible(true);
				
				dispose();
			}});
		
		JLabel lblHogeldin = new JLabel("Ho\u015Fgeldin");
		lblHogeldin.setForeground(Color.DARK_GRAY);
		lblHogeldin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHogeldin.setBounds(627, 24, 79, 29);
		contentPane.add(lblHogeldin);
		String mka=oyuncu.getKullaniciAdi();
		JLabel menuKullanici = new JLabel(mka);
		menuKullanici.setFont(new Font("Tahoma", Font.PLAIN, 17));
		menuKullanici.setForeground(Color.WHITE);
		menuKullanici.setBounds(718, 24, 133, 29);
		contentPane.add(menuKullanici);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(menu.class.getResource("/img/ust.png")));
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setBounds(12, 0, 888, 73);
		contentPane.add(lblNewLabel);
		
		
	}

}

package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Gamer;
import Model.Guns;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class infoGun extends JFrame {

	private JPanel contentPane;
	Guns g=new Guns();
	Gamer gamer=new Gamer();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame
	 */
	public infoGun(int id,Gamer in) {
		
		
		gamer=in;
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
		lblHogeldin.setForeground(Color.DARK_GRAY);
		lblHogeldin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHogeldin.setBounds(627, 24, 79, 29);
		contentPane.add(lblHogeldin);
		
		String mka=gamer.getKullaniciAdi();
		JLabel kullanici = new JLabel(mka);
		kullanici.setFont(new Font("Tahoma", Font.PLAIN, 17));
		kullanici.setForeground(Color.WHITE);
		kullanici.setBounds(718, 24, 133, 29);
		contentPane.add(kullanici);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\ust.png"));
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setBounds(12, 0, 888, 73);
		contentPane.add(lblNewLabel);
		
		JButton btnGeri = new JButton("");
		
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guns gun=new guns(gamer);
				gun.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBackground(Color.WHITE);
		btnGeri.setIcon(new ImageIcon("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\geri1.png"));
		btnGeri.setBounds(22, 86, 35, 34);
		contentPane.add(btnGeri);
		
		JLabel lblResim = new JLabel("");
		lblResim.setIcon(new ImageIcon("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\gun\\ar\\350m4.png"));
		lblResim.setBounds(32, 125, 394, 446);
		contentPane.add(lblResim);
		
		JLabel silahAdi = new JLabel("M416");
		silahAdi.setFont(new Font("Tahoma", Font.BOLD, 23));
		silahAdi.setForeground(Color.DARK_GRAY);
		silahAdi.setBounds(640, 125, 66, 40);
		contentPane.add(silahAdi);
		
		JLabel mermi = new JLabel("Kulland\u0131\u011F\u0131 Mermi :");
		mermi.setForeground(Color.DARK_GRAY);
		mermi.setFont(new Font("Tahoma", Font.BOLD, 16));
		mermi.setBounds(489, 211, 148, 16);
		contentPane.add(mermi);
		
		JLabel hasar = new JLabel("Hasar :");
		hasar.setForeground(Color.DARK_GRAY);
		hasar.setFont(new Font("Tahoma", Font.BOLD, 16));
		hasar.setBounds(489, 260, 66, 16);
		contentPane.add(hasar);
		
		JLabel atesHizi = new JLabel("Ate\u015F H\u0131z\u0131 :");
		atesHizi.setForeground(Color.DARK_GRAY);
		atesHizi.setFont(new Font("Tahoma", Font.BOLD, 16));
		atesHizi.setBounds(489, 306, 97, 16);
		contentPane.add(atesHizi);
		
		JLabel sarjor = new JLabel("\u015Earj\u00F6r :");
		sarjor.setFont(new Font("Tahoma", Font.BOLD, 16));
		sarjor.setForeground(new Color(64, 64, 64));
		sarjor.setBounds(489, 355, 66, 16);
		contentPane.add(sarjor);
		
		JLabel mermiHizi = new JLabel("Mermi H\u0131z\u0131 :");
		mermiHizi.setFont(new Font("Tahoma", Font.BOLD, 16));
		mermiHizi.setForeground(Color.DARK_GRAY);
		mermiHizi.setBounds(489, 403, 115, 16);
		contentPane.add(mermiHizi);
		
		JLabel mesafe = new JLabel("Mesafe :");
		mesafe.setForeground(Color.DARK_GRAY);
		mesafe.setFont(new Font("Tahoma", Font.BOLD, 16));
		mesafe.setBounds(489, 448, 79, 16);
		contentPane.add(mesafe);
		
		JLabel kMermi = new JLabel("New label");
		kMermi.setForeground(Color.DARK_GRAY);
		kMermi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kMermi.setBounds(640, 211, 187, 16);
		contentPane.add(kMermi);
		
		JLabel kHasar = new JLabel("New label");
		kHasar.setForeground(Color.DARK_GRAY);
		kHasar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kHasar.setBounds(555, 261, 272, 16);
		contentPane.add(kHasar);
		
		JLabel kAtes = new JLabel("New label");
		kAtes.setForeground(Color.DARK_GRAY);
		kAtes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kAtes.setBounds(577, 307, 250, 16);
		contentPane.add(kAtes);
		
		JLabel kSarjor = new JLabel("New label");
		kSarjor.setForeground(Color.DARK_GRAY);
		kSarjor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kSarjor.setBounds(555, 356, 272, 16);
		contentPane.add(kSarjor);
		
		JLabel kMHizi = new JLabel("New label");
		kMHizi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kMHizi.setForeground(Color.DARK_GRAY);
		kMHizi.setBounds(596, 404, 231, 16);
		contentPane.add(kMHizi);
		
		JLabel kMesafe = new JLabel("New label");
		kMesafe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		kMesafe.setForeground(Color.DARK_GRAY);
		kMesafe.setBounds(566, 449, 261, 16);
		contentPane.add(kMesafe);
		
		try {
			ResultSet rs=g.viewGunsID(id);
			while(rs.next()) {
				kMesafe.setText(rs.getString("GRange"));
				kAtes.setText(rs.getString("GFSpeed"));
				kSarjor.setText(String.valueOf(rs.getInt("GMagazine")));
				kMHizi.setText(rs.getString("GBSpeed"));
				kHasar.setText(String.valueOf(rs.getInt("GDamage")));
				kMermi.setText(rs.getString("GBullet"));
				ImageIcon im=new ImageIcon(rs.getString("GImgBuyuk"));
				   lblResim.setIcon(im);
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
	}
}

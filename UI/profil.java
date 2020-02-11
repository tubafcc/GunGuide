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

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPasswordField;

public class profil extends JFrame {

	private JPanel contentPane;
	private JTextField txKad;
	private JTextField txEma;
	private JTextField txSif;
	private JTextField txSiftr;
	private int vazgecis=0;;
	Gamer gamer=new Gamer();
	private JPasswordField pass;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public profil(Gamer insan) {
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
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(profil.class.getResource("/img/profil.png")));
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(64, 117, 296, 373);
		contentPane.add(lblNewLabel);
		
		String ad=gamer.getKullaniciAdi();
		String ema=gamer.getEmail();
		String sif=gamer.getSifre();
		
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblKullancAd.setForeground(Color.DARK_GRAY);
		lblKullancAd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKullancAd.setBounds(427, 117, 93, 16);
		contentPane.add(lblKullancAd);
		
		txKad = new JTextField();
		txKad.setBounds(425, 146, 290, 41);
		contentPane.add(txKad);
		txKad.setColumns(10);
		txKad.setText(ad);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(425, 200, 56, 16);
		contentPane.add(lblEmail);
		
		txEma = new JTextField();
		txEma.setBounds(425, 229, 290, 41);
		contentPane.add(txEma);
		txEma.setColumns(10);
		txEma.setText(ema);
		
		txSif = new JPasswordField();
		txSif.setBounds(425, 312, 290, 41);
		contentPane.add(txSif);
		txSif.setColumns(10);
		txSif.setText(sif);
		
		txSiftr = new JPasswordField();
		txSiftr.setBounds(425, 395, 290, 41);
		contentPane.add(txSiftr);
		txSiftr.setColumns(10);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setForeground(Color.DARK_GRAY);
		lblifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblifre.setBounds(425, 283, 56, 16);
		contentPane.add(lblifre);
		
		JLabel lblifreTekrar = new JLabel("\u015Eifre Tekrar:");
		lblifreTekrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblifreTekrar.setForeground(Color.DARK_GRAY);
		lblifreTekrar.setBounds(425, 366, 120, 16);
		contentPane.add(lblifreTekrar);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.setBackground(Color.ORANGE);
		btnGuncelle.setForeground(Color.DARK_GRAY);
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuncelle.setBounds(425, 449, 290, 41);
		contentPane.add(btnGuncelle);
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txEmail=txEma.getText().trim();
				String txKullaniciAdi=txKad.getText().trim();
				String txSifre=txSif.getText().trim();
				String txTSifre=txSiftr.getText().trim();
				
				if(txSifre.equals(txTSifre)) {
					Gamer guncel=new Gamer();
					guncel.setEmail(txEmail);
					guncel.setKullaniciAdi(txKullaniciAdi);
					guncel.setSifre(txSifre);
					guncel.setId(gamer.getId());
					try {
					int a;
						if(guncel.updateGamer()!=0) {
							JOptionPane.showMessageDialog(null, "Güncellendi", "Uyarý", -1);
							profil pro=new profil(guncel);
							pro.setVisible(true);
							dispose();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Þifreler uyuþmuyor..", "Uyarý", -1);
				
				}
				


			}});
		
		
		JLabel lblProfil = new JLabel("PROF\u0130L");
		lblProfil.setForeground(Color.DARK_GRAY);
		lblProfil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		lblProfil.setBounds(388, 29, 179, 39);
		contentPane.add(lblProfil);
		
		JButton btnHesabSil = new JButton("Hesab\u0131 Sil");
		btnHesabSil.setBackground(Color.WHITE);
		btnHesabSil.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnHesabSil.setForeground(Color.RED);
		btnHesabSil.setBorder(null);
		btnHesabSil.setBounds(423, 504, 292, 25);
		contentPane.add(btnHesabSil);
		btnHesabSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object [] noSaveOption = {"Evet","Hayýr","Ýptal" }; // Obje Dizisi Oluþturduk
				 
				String message = "Hesabý silmek istiyor musun?"; // Verilecek Mesaj
				 
				String title = "Dikkat!!"; // Pencere Baþlýðý
				 
				int noSave = JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,null, noSaveOption, null);
				 
				if (noSave == JOptionPane.YES_OPTION )
				 
				{
				try {
					gamer.deleteGamer();
					JOptionPane.showMessageDialog(null, "Hesap Silindi Giriþ sayfasýna yönlendiriliyorsunuz.", "Uyarý", -1);
					giris gir=new giris();
					gir.setVisible(true);
					dispose();
					
				} catch (Exception e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				 
				else if (noSave == JOptionPane.NO_OPTION)
				 
				{
				vazgecis++;
				}
				 
				else if (noSave == JOptionPane.CANCEL_OPTION)
				 
				{
				vazgecis++;
				}
			}});
	}
}

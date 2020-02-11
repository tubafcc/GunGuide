package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.Gamer;

import java.awt.Font;

public class kayitOl extends JFrame {

	
	private JPanel contentPane;
	private JTextField email;
	private JTextField kullaniciAdi;
	private JTextField sifre;
	private JTextField sifreTkr;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public kayitOl() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\logoturuncu.png"));
		setTitle("PUBG GunGuide");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 670);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnGeri = new JButton("");
		
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giris gun=new giris();
				gun.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBackground(Color.WHITE);
		btnGeri.setIcon(new ImageIcon("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\geri1.png"));
		btnGeri.setBounds(22, 86, 35, 34);
		contentPane.add(btnGeri);
		
		
		JLabel lblKaytOl = new JLabel("Kay\u0131t Ol");
		lblKaytOl.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblKaytOl.setForeground(Color.DARK_GRAY);
		lblKaytOl.setBounds(377, 52, 114, 34);
		contentPane.add(lblKaytOl);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setBounds(256, 117, 89, 16);
		contentPane.add(lblEmail);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblKullancAd.setForeground(Color.DARK_GRAY);
		lblKullancAd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKullancAd.setBounds(256, 194, 89, 16);
		contentPane.add(lblKullancAd);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setForeground(Color.DARK_GRAY);
		lblifre.setBounds(256, 270, 69, 16);
		contentPane.add(lblifre);
		
		JLabel lblifreTekrar = new JLabel("\u015Eifre Tekrar:");
		lblifreTekrar.setForeground(Color.DARK_GRAY);
		lblifreTekrar.setBounds(256, 346, 89, 16);
		contentPane.add(lblifreTekrar);
		
		email = new JTextField();
		email.setBounds(246, 146, 373, 34);
		contentPane.add(email);
		email.setColumns(10);
		
		kullaniciAdi = new JTextField();
		kullaniciAdi.setBounds(246, 223, 373, 34);
		contentPane.add(kullaniciAdi);
		kullaniciAdi.setColumns(10);
		
		sifre = new JPasswordField();
		sifre.setBounds(246, 299, 373, 34);
		contentPane.add(sifre);
		sifre.setColumns(10);
		
		sifreTkr = new JPasswordField();
		sifreTkr.setBounds(246, 375, 373, 31);
		contentPane.add(sifreTkr);
		sifreTkr.setColumns(10);
		
		JButton kayitOl = new JButton("Kay\u0131t Ol");
		kayitOl.setForeground(Color.DARK_GRAY);
		kayitOl.setFont(new Font("Tahoma", Font.PLAIN, 21));
		kayitOl.setBackground(Color.ORANGE);
		kayitOl.setBounds(246, 462, 373, 56);
		contentPane.add(kayitOl);
		kayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txEmail=email.getText().trim();
				String txKullaniciAdi=kullaniciAdi.getText().trim();
				String txSifre=sifre.getText().trim();
				String txTSifre=sifreTkr.getText().trim();
				if(txSifre.equals(txTSifre)) {
					Gamer yeni=new Gamer();
					yeni.setEmail(txEmail);
					yeni.setKullaniciAdi(txKullaniciAdi);
					yeni.setSifre(txSifre);
					try {
						if(yeni.addGamer()!=0) {
							giris gir=new giris();
							gir.setVisible(true);
							dispose();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Þifreler uyuþmuyor..", "Uyarý", -1);
				
				}
				giris gir=new giris();
				gir.setVisible(true);
				dispose();
			}});
	}
}

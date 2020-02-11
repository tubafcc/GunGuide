package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Model.Gamer;


public class giris extends JFrame {

	private JPanel contentPane;
	private JTextField txKullaniciAdi;
	private JTextField txSifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giris frame = new giris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public giris() {
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
		
		
		txKullaniciAdi = new JTextField();
		txKullaniciAdi.setBounds(351, 222, 252, 39);
		contentPane.add(txKullaniciAdi);
		txKullaniciAdi.setColumns(10);
		
		txSifre = new JPasswordField();
		txSifre.setBounds(351, 293, 252, 39);
		contentPane.add(txSifre);
		txSifre.setColumns(10);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKullancAd.setForeground(Color.WHITE);
		lblKullancAd.setBackground(Color.WHITE);
		lblKullancAd.setBounds(351, 191, 90, 25);
		contentPane.add(lblKullancAd);
		
		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblifre.setForeground(Color.WHITE);
		lblifre.setBounds(351, 262, 68, 31);
		contentPane.add(lblifre);
		
		JButton btnGiris = new JButton("Giriþ Yap");
		btnGiris.setForeground(Color.DARK_GRAY);
		btnGiris.setIcon(null);
		btnGiris.setBackground(Color.orange);
		btnGiris.setBounds(351, 354, 125, 45);
		contentPane.add(btnGiris);
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gamerName=txKullaniciAdi.getText().trim();
				String pass=txSifre.getText().trim();
				Gamer giren=new Gamer();
				giren.setKullaniciAdi(gamerName);
				giren.setSifre(pass);
				try {
					if(giren.login(gamerName,pass)) {
						
						
						dispose();
					}else {
						
						JOptionPane.showMessageDialog(null, "Hatalý Giriþ", "Uyarý", -1);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Kayýt Ol");
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(new Color(255, 204, 102));
		btnNewButton_1.setBounds(478, 354, 125, 45);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kayitOl kayit=new kayitOl();
				kayit.setVisible(true);
				dispose();
			}
			});
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(giris.class.getResource("/img/bgd2.jpg")));
		lblNewLabel.setBounds(12, 13, 888, 597);
		contentPane.add(lblNewLabel);
	}

}

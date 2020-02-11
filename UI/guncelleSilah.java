package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Guns;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class guncelleSilah extends JFrame {

	private JPanel contentPane;
	private JTextField adi;
	private JTextField turu;
	private JTextField mesafe;
	private JTextField mermihizi;
	private JTextField mermi;
	private JTextField hasar;
	private JLabel lblNewLabel;
	private JTextField sarjor;
	private JLabel lblarjr;
	private JLabel lblAteHz;
	private JTextField ates;
	private JLabel lblKucuk;
	private JLabel lblBuyuk;
	private JButton btnKckResimSe;
	private JButton btnbuyuk;
	private String resimKucuk;
	private String resimBuyuk;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guncelleSilah frame = new guncelleSilah();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public guncelleSilah(Guns g) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(guncelleSilah.class.getResource("/img/logoturuncu.png")));
		setTitle("Silahlar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 880, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSilahAd = new JLabel("Silah Ad\u0131:");
		lblSilahAd.setBounds(40, 45, 56, 16);
		contentPane.add(lblSilahAd);
		
		adi = new JTextField();
		adi.setBounds(198, 42, 116, 22);
		contentPane.add(adi);
		adi.setColumns(10);
		
		JLabel lblSilahTr = new JLabel("Silah T\u00FCr\u00FC:");
		lblSilahTr.setBounds(40, 83, 95, 16);
		contentPane.add(lblSilahTr);
		
		turu = new JTextField();
		turu.setBounds(198, 80, 116, 22);
		contentPane.add(turu);
		turu.setColumns(10);
		
		JLabel lblMesafe = new JLabel("Mesafe:");
		lblMesafe.setBounds(40, 120, 56, 16);
		contentPane.add(lblMesafe);
		
		mesafe = new JTextField();
		mesafe.setBounds(198, 117, 116, 22);
		contentPane.add(mesafe);
		mesafe.setColumns(10);
		
		JLabel lblMermiHz = new JLabel("Mermi h\u0131z\u0131:");
		lblMermiHz.setBounds(40, 155, 95, 16);
		contentPane.add(lblMermiHz);
		
		mermihizi = new JTextField();
		mermihizi.setBounds(198, 152, 116, 22);
		contentPane.add(mermihizi);
		mermihizi.setColumns(10);
		
		JLabel lblMermi = new JLabel("Mermi:");
		lblMermi.setBounds(40, 190, 56, 16);
		contentPane.add(lblMermi);
		
		mermi = new JTextField();
		mermi.setBounds(198, 187, 116, 22);
		contentPane.add(mermi);
		mermi.setColumns(10);
		
		hasar = new JTextField();
		hasar.setBounds(198, 222, 116, 22);
		contentPane.add(hasar);
		hasar.setColumns(10);
		
		lblNewLabel = new JLabel("Hasar:");
		lblNewLabel.setBounds(40, 225, 56, 16);
		contentPane.add(lblNewLabel);
		
		sarjor = new JTextField();
		sarjor.setBounds(198, 257, 116, 22);
		contentPane.add(sarjor);
		sarjor.setColumns(10);
		
		lblarjr = new JLabel("\u015Earj\u00F6r:");
		lblarjr.setBounds(40, 260, 56, 16);
		contentPane.add(lblarjr);
		
		lblAteHz = new JLabel("Ate\u015F H\u0131z\u0131:");
		lblAteHz.setBounds(40, 295, 56, 16);
		contentPane.add(lblAteHz);
		
		ates = new JTextField();
		ates.setBounds(198, 292, 116, 22);
		contentPane.add(ates);
		ates.setColumns(10);
		
		
		
		lblKucuk = new JLabel("Kucuk");
		lblKucuk.setBounds(340, 101, 151, 150);
		contentPane.add(lblKucuk);
		
		lblBuyuk = new JLabel("Buyuk");
		lblBuyuk.setBounds(519, 42, 301, 269);
		contentPane.add(lblBuyuk);
		
		btnKckResimSe = new JButton("K\u00FCc\u00FCk Resim Se\u00E7");
		btnKckResimSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnKckResimSe);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
				    File file = fc.getSelectedFile();
				    resimKucuk=file.getAbsolutePath();
				    JOptionPane.showMessageDialog(null, resimKucuk);
				   ImageIcon im=new ImageIcon(file.getAbsolutePath());
				   lblKucuk.setIcon(im);
				   
				  } else {
				    System.out.println("Seçim kullanýcý tarafýndan iptal edildi. ");
				  }
			}
		});
		btnKckResimSe.setBackground(Color.ORANGE);
		btnKckResimSe.setBounds(326, 327, 151, 39);
		contentPane.add(btnKckResimSe);
		
		btnbuyuk = new JButton("B\u00FCy\u00FCk Resim Se\u00E7");
		btnbuyuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnbuyuk);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
				    File file = fc.getSelectedFile();
				    resimBuyuk=file.getAbsolutePath();
				    JOptionPane.showMessageDialog(null, resimBuyuk);
				   ImageIcon im=new ImageIcon(file.getAbsolutePath());
				   lblBuyuk.setIcon(im);
				   
				  } else {
				    System.out.println("Seçim kullanýcý tarafýndan iptal edildi. ");
				  }
			}
		});
		btnbuyuk.setBackground(Color.ORANGE);
		btnbuyuk.setBounds(489, 327, 331, 39);
		contentPane.add(btnbuyuk);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad=adi.getText();
				String tur=turu.getText();
				int mes=Integer.parseInt(mesafe.getText());
				String mehi=mermihizi.getText();
				String m=mermi.getText();
				int h=Integer.parseInt(hasar.getText());
				int s=Integer.parseInt(sarjor.getText());
				String a=ates.getText();
				
				Guns g=new Guns();
				g.setGunBspeed(mehi);
				g.setGunBullet(m);
				g.setGunDamage(h);
				g.setGunFire(a);
				g.setGunMagazine(s);
				g.setGunName(ad);
				g.setGunRange(mes);
				g.setGunType(tur);
				g.setImgBuyuk(resimBuyuk);
				g.setImgKucuk(resimKucuk);
				try {
					g.addGun(g);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		btnEkle.setBackground(Color.ORANGE);
		btnEkle.setBounds(38, 327, 276, 39);
		contentPane.add(btnEkle);
		
		
		//iki parametre almalý bir silah güncellensinmi eklensinmi
		//iki silah objesi
		//iþlem baþarýlý olduðunda admine geri dönmeli 
		//resim nasýl kaydedilicek onu alýcaz
		//çift resim alýnýcak bir infopage için birde menu için
	}
}

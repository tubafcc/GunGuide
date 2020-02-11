package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Melee;

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

public class guncelleYakin extends JFrame {

	private JPanel contentPane;
	private JTextField adi;
	private JTextField bilgi;
	private String resimYol;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guncelleYakin frame = new guncelleYakin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public guncelleYakin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(guncelleYakin.class.getResource("/img/logoturuncu.png")));
		setTitle("Yak\u0131n D\u00F6v\u00FC\u015F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAd = new JLabel("Ad\u0131:");
		lblAd.setBounds(12, 25, 56, 16);
		contentPane.add(lblAd);
		
		adi = new JTextField();
		adi.setBounds(12, 54, 116, 22);
		contentPane.add(adi);
		adi.setColumns(10);
		
		JLabel lblBilgi = new JLabel("Bilgi:");
		lblBilgi.setBounds(12, 89, 56, 16);
		contentPane.add(lblBilgi);
		
		bilgi = new JTextField();
		bilgi.setBounds(12, 118, 116, 22);
		contentPane.add(bilgi);
		bilgi.setColumns(10);
		
		
		
		JLabel lblKucuk = new JLabel("Kucuk");
		lblKucuk.setBounds(146, 13, 171, 137);
		contentPane.add(lblKucuk);
		
		JButton btnResimEkle = new JButton("Resim Ekle");
		btnResimEkle.setBackground(Color.ORANGE);
		btnResimEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnResimEkle);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
				    File file = fc.getSelectedFile();
				    resimYol=file.getAbsolutePath();
				    JOptionPane.showMessageDialog(null, resimYol);
				   ImageIcon im=new ImageIcon(file.getAbsolutePath());
				   lblKucuk.setIcon(im);
				   
				  } else {
				    System.out.println("Seçim kullanýcý tarafýndan iptal edildi. ");
				  }
			}
		});
		btnResimEkle.setBounds(137, 171, 201, 33);
		contentPane.add(btnResimEkle);
		
		JButton btnTamamla = new JButton("Ekle");
		btnTamamla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad=adi.getText();
				Melee eklenenM=new Melee();
				eklenenM.setImgKucuk(resimYol);
				eklenenM.setMLtype(ad);
				try {
					eklenenM.addMelee(eklenenM);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTamamla.setForeground(Color.DARK_GRAY);
		btnTamamla.setBackground(Color.ORANGE);
		btnTamamla.setBounds(12, 171, 116, 33);
		contentPane.add(btnTamamla);
	}
}

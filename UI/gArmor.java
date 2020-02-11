package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Armor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class gArmor extends JFrame {

	private JPanel contentPane;
	private JTextField level;
	private JTextField omur;
	private JTextField kapasite;
	private JTextField tipi;
	private JTextField hasar;
	private String resimYol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gArmor frame = new gArmor();
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
	public gArmor() {
		setTitle("Z\u0131rh");
		setIconImage(Toolkit.getDefaultToolkit().getImage(gArmor.class.getResource("/img/logoturuncu.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZrhSeviyesi = new JLabel("Z\u0131rh seviyesi:");
		lblZrhSeviyesi.setBounds(12, 31, 94, 16);
		contentPane.add(lblZrhSeviyesi);
		
		level = new JTextField();
		level.setBounds(117, 28, 116, 22);
		contentPane.add(level);
		level.setColumns(10);
		
		JLabel lblZrhmr = new JLabel("Z\u0131rh \u00D6m\u00FCr\u00FC:");
		lblZrhmr.setBounds(12, 63, 80, 16);
		contentPane.add(lblZrhmr);
		
		omur = new JTextField();
		omur.setBounds(117, 63, 116, 22);
		contentPane.add(omur);
		omur.setColumns(10);
		
		JLabel lblZrhKapasitesi = new JLabel("Z\u0131rh Kapasitesi:");
		lblZrhKapasitesi.setBounds(12, 98, 94, 16);
		contentPane.add(lblZrhKapasitesi);
		
		kapasite = new JTextField();
		kapasite.setBounds(117, 95, 116, 22);
		contentPane.add(kapasite);
		kapasite.setColumns(10);
		
		tipi = new JTextField();
		tipi.setBounds(117, 130, 116, 22);
		contentPane.add(tipi);
		tipi.setColumns(10);
		
		JLabel lblZrhTipi = new JLabel("Z\u0131rh Tipi:");
		lblZrhTipi.setBounds(12, 133, 56, 16);
		contentPane.add(lblZrhTipi);
		
		hasar = new JTextField();
		hasar.setBounds(117, 165, 116, 22);
		contentPane.add(hasar);
		hasar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hasar Engelleme");
		lblNewLabel.setBounds(12, 168, 108, 16);
		contentPane.add(lblNewLabel);
		
		JLabel resim = new JLabel("*");
		resim.setBackground(Color.PINK);
		resim.setBounds(256, 31, 150, 149);
		contentPane.add(resim);
		
		
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.setBackground(Color.ORANGE);
		btnGuncelle.setBounds(117, 200, 108, 40);
		contentPane.add(btnGuncelle);
		
		JButton btnResimSe = new JButton("Resim Se\u00E7");
		btnResimSe.setBackground(Color.ORANGE);
		btnResimSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnResimSe);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
				    File file = fc.getSelectedFile();
				    resimYol=file.getAbsolutePath();
				    JOptionPane.showMessageDialog(null, resimYol);
				   ImageIcon im=new ImageIcon(file.getAbsolutePath());
				   resim.setIcon(im);
				   
				  } else {
				    System.out.println("Seçim kullanýcý tarafýndan iptal edildi. ");
				  }
			}
		});
		btnResimSe.setBounds(229, 200, 191, 40);
		contentPane.add(btnResimSe);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.setBackground(Color.ORANGE);
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tip=tipi.getText();
				int kap=Integer.parseInt(kapasite.getText());
				int has=Integer.parseInt(hasar.getText());
				int lev=Integer.parseInt(level.getText());
				int om=Integer.parseInt(omur.getText());
				Armor eklenen=new Armor();
				eklenen.setCapacity(kap);
				eklenen.setDamageReduction(has);
				eklenen.setDurability(om);
				eklenen.setImgkucuk(resimYol);
				eklenen.setLevel(lev);
				eklenen.setType(tip);
				try {
					eklenen.addArmor();
					dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnEkle.setBounds(12, 200, 97, 40);
		contentPane.add(btnEkle);
		
	}
}

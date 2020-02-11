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
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class guncelleArmor extends JFrame {

	private JPanel contentPane;
	private JTextField tipi;
	private JTextField level;
	private JTextField durability;
	private JTextField kapasite;
	private JTextField hasar;
	private JLabel lblResim;
	private JButton btnResimSe;
	private JButton btnTamamla;
	String resimYol="";
	String tip;
	int seviye;
	int omur;
	int kapasit;
	int dmg;
	private JButton btnGncelle;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guncelleArmor frame = new guncelleArmor();
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
	public guncelleArmor() {
			
		
		
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(guncelleArmor.class.getResource("/img/logoturuncu.png")));
		setTitle("Z\u0131rh");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZrhTipi = new JLabel("Z\u0131rh tipi:");
		lblZrhTipi.setBounds(24, 29, 56, 16);
		contentPane.add(lblZrhTipi);
		
		
		tipi = new JTextField();
		tipi.setBounds(133, 26, 116, 22);
		contentPane.add(tipi);
		tipi.setColumns(10);
		
		
		JLabel lblZrhLeveli = new JLabel("Z\u0131rh leveli:");
		lblZrhLeveli.setBounds(24, 64, 77, 16);
		contentPane.add(lblZrhLeveli);
		
		level = new JTextField();
		level.setBounds(133, 61, 116, 22);
		contentPane.add(level);
		level.setColumns(10);
		
		durability = new JTextField();
		durability.setBounds(133, 96, 116, 22);
		contentPane.add(durability);
		durability.setColumns(10);
		
		JLabel lblZrhmr = new JLabel("Z\u0131rh \u00F6mr\u00FC:");
		lblZrhmr.setBounds(24, 99, 77, 16);
		contentPane.add(lblZrhmr);
		
		kapasite = new JTextField();
		kapasite.setBounds(133, 131, 116, 22);
		contentPane.add(kapasite);
		kapasite.setColumns(10);
		
		JLabel lblZrhKapasitesi = new JLabel("Z\u0131rh Kapasitesi:");
		lblZrhKapasitesi.setBounds(24, 134, 97, 16);
		contentPane.add(lblZrhKapasitesi);
		
		hasar = new JTextField();
		hasar.setBounds(133, 166, 116, 22);
		contentPane.add(hasar);
		hasar.setColumns(10);
		
		JLabel lblHasarEngelleme = new JLabel("Hasar engelleme:");
		lblHasarEngelleme.setBounds(24, 169, 116, 16);
		contentPane.add(lblHasarEngelleme);
		
		tipi.setBounds(133, 26, 116, 22);
		System.out.println(tipi);
		contentPane.add(tipi);
		tipi.setColumns(10);
		
		lblResim = new JLabel("Resim");
		lblResim.setIcon(new ImageIcon(guncelleArmor.class.getResource("/img/armor/Icon_equipment_Back_C_01.png")));
		lblResim.setBounds(283, 28, 175, 159);
		contentPane.add(lblResim);
		
		btnResimSe = new JButton("Resim Se\u00E7");
		btnResimSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnResimSe);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
				    File file = fc.getSelectedFile();
				    resimYol=file.getAbsolutePath();
				    JOptionPane.showMessageDialog(null, resimYol);
				   ImageIcon im=new ImageIcon(file.getAbsolutePath());
				   lblResim.setIcon(im);
				   
				  } else {
				    System.out.println("Seçim kullanýcý tarafýndan iptal edildi. ");
				  }
				}
			
		});
		btnResimSe.setBackground(Color.ORANGE);
		btnResimSe.setBounds(266, 208, 222, 37);
		contentPane.add(btnResimSe);
		
	
		
		
		
		
		btnTamamla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnTamamla = new JButton("Ekle");
		btnTamamla.setBackground(Color.ORANGE);
		btnTamamla.setBounds(12, 208, 109, 37);
		contentPane.add(btnTamamla);
		
		btnGncelle = new JButton("G\u00FCncelle");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGncelle.setBackground(Color.ORANGE);
		btnGncelle.setForeground(Color.BLACK);
		btnGncelle.setBounds(133, 208, 121, 37);
		contentPane.add(btnGncelle);
		
		
		
		
		
		
	}
}

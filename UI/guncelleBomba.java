package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import Model.Throwable;

public class guncelleBomba extends JFrame {

	private JPanel contentPane;
	private JTextField adi;
	private JTextField bilgi;
	private String resimYol;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guncelleBomba frame = new guncelleBomba();
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
	public guncelleBomba() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\logoturuncu.png"));
		setTitle("Bomba");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBombaAd = new JLabel("Bomba Ad\u0131:");
		lblBombaAd.setBounds(12, 29, 66, 16);
		contentPane.add(lblBombaAd);
		
		adi = new JTextField();
		adi.setBounds(12, 58, 116, 22);
		contentPane.add(adi);
		adi.setColumns(10);
		
		JLabel lblBombaTipi = new JLabel("Bomba Tipi:");
		lblBombaTipi.setBounds(12, 93, 89, 16);
		contentPane.add(lblBombaTipi);
		
		bilgi = new JTextField();
		bilgi.setBounds(12, 122, 116, 22);
		contentPane.add(bilgi);
		bilgi.setColumns(10);
		
	
		
		JLabel lblKucuk = new JLabel("Kucuk");
		lblKucuk.setBounds(169, 13, 151, 151);
		contentPane.add(lblKucuk);
		
		JButton btnResimEkle = new JButton("Resim Ekle");
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
		btnResimEkle.setBackground(Color.ORANGE);
		btnResimEkle.setBounds(140, 182, 200, 33);
		contentPane.add(btnResimEkle);
		
		JButton btnTamamla = new JButton("Ekle");
		btnTamamla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad=adi.getText();
				String bil=bilgi.getText();
				Throwable eklenenT=new Throwable();
				eklenenT.setThaType(ad);
				eklenenT.setImgKucuk(resimYol);
				try {
					eklenenT.addThrowable(eklenenT);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnTamamla.setBackground(Color.ORANGE);
		btnTamamla.setForeground(Color.DARK_GRAY);
		btnTamamla.setBounds(12, 182, 116, 33);
		contentPane.add(btnTamamla);
	}

}

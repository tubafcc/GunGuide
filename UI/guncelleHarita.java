package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Maps;

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

public class guncelleHarita extends JFrame {

	private JPanel contentPane;
	private JTextField harita;
	private String resimYolKucuk;
	private String resimYolBuyuk;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guncelleHarita frame = new guncelleHarita();
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
	public guncelleHarita() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(guncelleHarita.class.getResource("/img/logoturuncu.png")));
		setTitle("Harita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHaritaAdi = new JLabel("Harita Adi:");
		lblHaritaAdi.setBounds(12, 27, 90, 16);
		contentPane.add(lblHaritaAdi);
		
		harita = new JTextField();
		harita.setBounds(12, 56, 631, 22);
		contentPane.add(harita);
		harita.setColumns(10);
		
		
		
		JLabel lblKucuk = new JLabel("Kucuk");
		lblKucuk.setBounds(37, 211, 190, 153);
		contentPane.add(lblKucuk);
		
		JLabel lblBuyuk = new JLabel("Buyuk");
		lblBuyuk.setBounds(276, 91, 379, 373);
		contentPane.add(lblBuyuk);
		
		JButton btnKckResimSe = new JButton("K\u00FCc\u00FCk Resim Se\u00E7");
		btnKckResimSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnKckResimSe);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
				    File file = fc.getSelectedFile();
				    resimYolKucuk=file.getAbsolutePath();
				    JOptionPane.showMessageDialog(null, resimYolKucuk);
				   ImageIcon im=new ImageIcon(file.getAbsolutePath());
				   lblKucuk.setIcon(im);
				   
				  } else {
				    System.out.println("Seçim kullanýcý tarafýndan iptal edildi. ");
				  }
			}
		});
		btnKckResimSe.setBackground(Color.ORANGE);
		btnKckResimSe.setBounds(12, 475, 236, 34);
		contentPane.add(btnKckResimSe);
		
		JButton btnBykResimSe = new JButton("B\u00FCy\u00FCk Resim Se\u00E7");
		btnBykResimSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnBykResimSe);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
				    File file = fc.getSelectedFile();
				    resimYolBuyuk=file.getAbsolutePath();
				    JOptionPane.showMessageDialog(null, resimYolBuyuk);
				   ImageIcon im=new ImageIcon(file.getAbsolutePath());
				   lblBuyuk.setIcon(im);
				   
				  } else {
				    System.out.println("Seçim kullanýcý tarafýndan iptal edildi. ");
				  }
			}
		});
		btnBykResimSe.setBackground(Color.ORANGE);
		btnBykResimSe.setBounds(260, 477, 410, 32);
		contentPane.add(btnBykResimSe);
		
		JButton btnTamamla = new JButton("Tamamla");
		btnTamamla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad=harita.getText();
				Maps eklenen=new Maps();
				eklenen.setImgBBuyuk(resimYolBuyuk);
				eklenen.setImgKucuk(resimYolKucuk);
				eklenen.setMapsName(ad);
				try {
					eklenen.addMaps(eklenen);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTamamla.setBackground(Color.ORANGE);
		btnTamamla.setBounds(12, 522, 658, 34);
		contentPane.add(btnTamamla);
	}
}

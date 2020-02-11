package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Loot;

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

public class guncelleKutu extends JFrame {

	private JPanel contentPane;
	private JTextField kasa; 
	private String resimYol;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guncelleKutu frame = new guncelleKutu();
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
	public guncelleKutu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(guncelleKutu.class.getResource("/img/logoturuncu.png")));
		setTitle("Kasalar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 421, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKutuAd = new JLabel("Kasa Ad\u0131:");
		lblKutuAd.setBounds(12, 52, 56, 16);
		contentPane.add(lblKutuAd);
		
		kasa = new JTextField();
		kasa.setBounds(12, 81, 116, 22);
		contentPane.add(kasa);
		kasa.setColumns(10);
		
		
		
		JLabel lblKucuk = new JLabel("Kucuk");
		lblKucuk.setBounds(169, 17, 145, 150);
		contentPane.add(lblKucuk);
		
		JButton btnResimSe = new JButton("Resim Se\u00E7");
		btnResimSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnResimSe);
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
		btnResimSe.setBackground(Color.ORANGE);
		btnResimSe.setBounds(140, 186, 199, 33);
		contentPane.add(btnResimSe);
		
		JButton btnTamamla = new JButton("Ekle");
		btnTamamla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad=kasa.getText();
				Loot eklenenL=new Loot();
				eklenenL.setCrateName(ad);
				try {
					eklenenL.addCrate(eklenenL);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTamamla.setBackground(Color.ORANGE);
		btnTamamla.setBounds(12, 186, 116, 33);
		contentPane.add(btnTamamla);
	}

}

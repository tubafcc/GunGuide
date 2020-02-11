package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Attach;

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

public class guncelleEklenti extends JFrame {

	private JPanel contentPane;
	private JTextField adi;
	private JTextField tur;
	private String resimYol;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guncelleEklenti frame = new guncelleEklenti();
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
	public guncelleEklenti() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(guncelleEklenti.class.getResource("/img/logoturuncu.png")));
		setTitle("Eklenti");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 394, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEklentiAd = new JLabel("Eklenti Ad\u0131:");
		lblEklentiAd.setBounds(22, 34, 78, 16);
		contentPane.add(lblEklentiAd);
		
		adi = new JTextField();
		adi.setBounds(22, 63, 116, 22);
		contentPane.add(adi);
		adi.setColumns(10);
		
		JLabel lblEklentiTr = new JLabel("Eklenti T\u00FCr\u00FC:");
		lblEklentiTr.setBounds(22, 98, 78, 16);
		contentPane.add(lblEklentiTr);
		
		tur = new JTextField();
		tur.setBounds(22, 127, 116, 22);
		contentPane.add(tur);
		tur.setColumns(10);
		
		
		
		JLabel lblKucuk = new JLabel("Kucuk");
		lblKucuk.setBounds(176, 13, 150, 151);
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
		btnResimSe.setBounds(150, 176, 176, 36);
		contentPane.add(btnResimSe);
		JButton btnTamamla = new JButton("Ekle");
		btnTamamla.setBackground(Color.ORANGE);
		btnTamamla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ad=adi.getText();
				String turu=tur.getText();
				Attach eklenen=new Attach();
				eklenen.setAttachName(ad);
				eklenen.setAttachType(turu);
				eklenen.setImgKucuk(resimYol);
				try {
					eklenen.addAttach(eklenen);
					dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnTamamla.setBounds(22, 176, 116, 36);
		contentPane.add(btnTamamla);
	}
}

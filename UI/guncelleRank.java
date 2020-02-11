package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class guncelleRank extends JFrame {

	private JPanel contentPane;
	private JTextField rank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guncelleRank frame = new guncelleRank();
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
	public guncelleRank() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\logoturuncu.png"));
		setTitle("Rank");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 158, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRankAd = new JLabel("Rank Ad\u0131:");
		lblRankAd.setBounds(12, 44, 56, 16);
		contentPane.add(lblRankAd);
		
		rank = new JTextField();
		rank.setBounds(12, 73, 116, 22);
		contentPane.add(rank);
		rank.setColumns(10);
		
		JButton btnTamamla = new JButton("Tamamla");
		btnTamamla.setBackground(Color.ORANGE);
		btnTamamla.setForeground(Color.DARK_GRAY);
		btnTamamla.setBounds(12, 108, 116, 33);
		contentPane.add(btnTamamla);
	}

}

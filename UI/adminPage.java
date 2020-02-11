package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Model.Armor;
import Model.Attach;
import Model.Gamer;
import Model.Guns;
import Model.Loot;
import Model.Maps;
import Model.Melee;
import Model.myUtil;
import Model.Throwable;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminPage extends JFrame {
	public static DefaultTableModel tablo(Gamer g) throws Exception {
			Gamer gm=g;
			
			
			ResultSet rs=g.viewGamer();
			int colcount = rs.getMetaData().getColumnCount();
			DefaultTableModel tm = new DefaultTableModel();
			for(int i = 1;i<=colcount;i++) {
			 tm.addColumn(rs.getMetaData().getColumnName(i));}
			
			
			 while(rs.next())
             {
                 Object[] row = new Object[colcount];
                 for(int i=1;i<=colcount;i++)
                     {row[i-1] = rs.getObject(i);}
                 tm.addRow(row);
             }
			 return tm;
			
			
			
	}

	private JPanel contentPane;
	Gamer gamer=new Gamer();
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPage frame = new adminPage(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	
	public adminPage(Gamer insan) {
		
		gamer=insan;
		JTable tableAdmin = new JTable();	
		//if(admin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tugba\\eclipse-workspace\\GunGuide\\src\\img\\logoturuncu.png"));
		setTitle("PUBG GunGuide");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 670);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuAnasayfa=new JMenu("Anasayfa");
		menuBar.add(menuAnasayfa);
		
		JMenu menuSecenekler=new JMenu("Seçenekler");
		menuBar.add(menuSecenekler);
		
		JMenuItem mnAnasayfa = new JMenuItem("Anasayfa");
		menuAnasayfa.add(mnAnasayfa);
		mnAnasayfa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu menu=new menu(gamer);
					menu.setVisible(true);
					
					dispose();
				}});
		
		JMenuItem mnProfil = new JMenuItem("Profil");
		menuSecenekler.add(mnProfil);
		mnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profil profil=new profil(gamer);
				profil.setVisible(true);
				
				dispose();
			}});
		JMenuItem mnAyarlar = new JMenuItem("Ayarlar");
		menuSecenekler.add(mnAyarlar);
		mnAyarlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(true) {
					adminPage admin=new adminPage(gamer);
				admin.setVisible(true);
				
				dispose();}
				else {
					//admin deðilsiniz.
				}
				
			}});
		
		JMenuItem mnk = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		menuSecenekler.add(mnk);
		mnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giris gir=new giris();
				gir.setVisible(true);
				dispose();
			}});
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel veriGoster = new JPanel();
		veriGoster.setBackground(Color.WHITE);
		veriGoster.setBounds(286, 104, 516, 420);
		contentPane.add(veriGoster);
		
		JButton btnEkle = new JButton("Yeni Veri Ekle");
		
		btnEkle.setForeground(Color.DARK_GRAY);
		btnEkle.setBackground(new Color(204, 255, 255));
		btnEkle.setBounds(208, 55, 679, 25);
		btnEkle.setVisible(false);
		contentPane.add(btnEkle);
		
		JLabel lblAdminPanel = new JLabel("ADM\u0130N PANEL");
		lblAdminPanel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAdminPanel.setForeground(Color.DARK_GRAY);
		lblAdminPanel.setBounds(12, 13, 157, 29);
		contentPane.add(lblAdminPanel);
		
		JButton btnOyuncu = new JButton("Oyuncular");
		btnOyuncu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOyuncu.setBackground(Color.ORANGE);
		btnOyuncu.setForeground(Color.DARK_GRAY);
		btnOyuncu.setBounds(12, 55, 157, 47);
		contentPane.add(btnOyuncu);
		btnOyuncu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JScrollPane scrollPane = new JScrollPane();
				Gamer g=new Gamer();
				
		        scrollPane.setBounds(0, 0, 516, 420);
		        veriGoster.add(scrollPane);
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(scrollPane, popupMenu);
				
				
				JMenuItem mnýtmSil = new JMenuItem("Sil");
				mnýtmSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
							try {
								int rowindex=tableAdmin.getSelectedRow();
								if(rowindex>=0) {
									int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
									Armor adelete=new Armor();
									adelete.setArmorID(id);
									int r;
								r = adelete.deleteArmor(adelete);
								if(r==1) {
									JOptionPane.showMessageDialog(null, "Silindi");
									tableAdmin.setModel(tablo(gamer));
								}
							}} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
					}
				});
				popupMenu.add(mnýtmSil);
				
				JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
				mnýtmGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Kullanýcýlarýn bilgilerini kullanýcýlar deðiþtirebilir!!");
					}
				});
				popupMenu.add(mnýtmGncelle);
					
				 scrollPane.setViewportView(tableAdmin);
					try {
						tableAdmin.setModel(tablo(gamer));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}});
		JButton btnSilah = new JButton("Silahlar");
		
		btnSilah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guns gun=new Guns();
				btnEkle.setVisible(true);
				btnEkle.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						guncelleSilah gs=new guncelleSilah(gun);
						gs.setVisible(true);
					}
				});
				
				JScrollPane scrollPane = new JScrollPane();
		        scrollPane.setBounds(0, 0, 516, 420);
		        veriGoster.add(scrollPane);
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(scrollPane, popupMenu);
				
				
				JMenuItem mnýtmSil = new JMenuItem("Sil");
				mnýtmSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							
							
						
							try {
								int rowindex=tableAdmin.getSelectedRow();
								if(rowindex>=0) {
									int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
									Guns silinen=new Guns();
									silinen.setGunID(id);
									int r;
								r = silinen.deleteGun(silinen);
								if(r==1) {
									JOptionPane.showMessageDialog(null, "Silindi");
									tableAdmin.setModel(myUtil.buildTableModel(silinen.viewGuns()));
								}
							}} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
					}
				});
				popupMenu.add(mnýtmSil);
				
				JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
				mnýtmGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Güncelleme yapým aþamasýnda");
					}
				});
				popupMenu.add(mnýtmGncelle);
					
				 scrollPane.setViewportView(tableAdmin);
					try {
						tableAdmin.setModel(myUtil.buildTableModel(gun.viewGuns()));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnSilah.setBackground(Color.ORANGE);
		btnSilah.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSilah.setForeground(Color.DARK_GRAY);
		btnSilah.setBounds(12, 117, 157, 47);
		contentPane.add(btnSilah);
		
		JButton btnEklenti = new JButton("Eklentiler");
		btnEklenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Attach at=new Attach();
				btnEkle.setVisible(true);
				btnEkle.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						guncelleEklenti ga=new guncelleEklenti();
						ga.setVisible(true);
					}
				});
				JScrollPane scrollPane = new JScrollPane();
		        scrollPane.setBounds(0, 0, 516, 420);
		        veriGoster.add(scrollPane);
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(scrollPane, popupMenu);
				
				
				JMenuItem mnýtmSil = new JMenuItem("Sil");
				mnýtmSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
							try {
								int rowindex=tableAdmin.getSelectedRow();
								if(rowindex>=0) {
									int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
									Attach silinenA=new Attach();
									silinenA.setAttachID(id);
									int r;
								r = silinenA.deleteAttach(silinenA);
								if(r==1) {
									JOptionPane.showMessageDialog(null, "Silindi");
									tableAdmin.setModel(myUtil.buildTableModel(silinenA.viewAttach()));
								}
							}} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
					}
				});
				popupMenu.add(mnýtmSil);
				
				JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
				mnýtmGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Yapým Aþamasýndasýn");
					}
				});
				popupMenu.add(mnýtmGncelle);
					
				 scrollPane.setViewportView(tableAdmin);
					try {
						tableAdmin.setModel(myUtil.buildTableModel(at.viewAttach()));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnEklenti.setForeground(Color.DARK_GRAY);
		btnEklenti.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEklenti.setBackground(Color.ORANGE);
		btnEklenti.setBounds(12, 177, 157, 47);
		contentPane.add(btnEklenti);
		
		JButton btnBomb = new JButton("Bombalar");
		btnBomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Throwable th=new Throwable();
				btnEkle.setVisible(true);
				btnEkle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guncelleBomba gb=new guncelleBomba();
						gb.setVisible(true);
					}
				});
				JScrollPane scrollPane = new JScrollPane();
		        scrollPane.setBounds(0, 0, 516, 420);
		        veriGoster.add(scrollPane);
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(scrollPane, popupMenu);
				
				
				JMenuItem mnýtmSil = new JMenuItem("Sil");
				mnýtmSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
							try {
								int rowindex=tableAdmin.getSelectedRow();
								if(rowindex>=0) {
									int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
									Throwable silinenT=new Throwable();
									silinenT.setThrowableID(id);
									int r;
								r = silinenT.deleteThrowable(silinenT);
								if(r==1) {
									JOptionPane.showMessageDialog(null, "Silindi");
									tableAdmin.setModel(myUtil.buildTableModel(silinenT.viewThrowable()));
								}
							}} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
					}
				});
				popupMenu.add(mnýtmSil);
				
				JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
				mnýtmGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Yapým Aþamasýnda");
					}
				});
				popupMenu.add(mnýtmGncelle);
					
				 scrollPane.setViewportView(tableAdmin);
					try {
						tableAdmin.setModel(myUtil.buildTableModel(th.viewThrowable()));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnBomb.setForeground(Color.DARK_GRAY);
		btnBomb.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBomb.setBackground(Color.ORANGE);
		btnBomb.setBounds(12, 237, 157, 47);
		contentPane.add(btnBomb);
		
		JButton btnMelee = new JButton("Yak\u0131n D\u00F6v\u00FC\u015F");
		btnMelee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Melee ml=new Melee();
				btnEkle.setVisible(true);
				btnEkle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guncelleYakin gy=new guncelleYakin();
						gy.setVisible(true);
					}
				});
				JScrollPane scrollPane = new JScrollPane();
		        scrollPane.setBounds(0, 0, 516, 420);
		        veriGoster.add(scrollPane);
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(scrollPane, popupMenu);
				
				
				JMenuItem mnýtmSil = new JMenuItem("Sil");
				mnýtmSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
							try {
								int rowindex=tableAdmin.getSelectedRow();
								if(rowindex>=0) {
									int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
									Melee silinenM=new Melee();
									silinenM.setMeleeID(id);
									int r;
								r = silinenM.deleteMelee(silinenM);
								if(r==1) {
									JOptionPane.showMessageDialog(null, "Silindi");
									tableAdmin.setModel(myUtil.buildTableModel(silinenM.viewMelee()));
								}
							}} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
					}
				});
				popupMenu.add(mnýtmSil);
				
				JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
				mnýtmGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Yapým aþamasýnda");
					}
				});
				popupMenu.add(mnýtmGncelle);
					
				 scrollPane.setViewportView(tableAdmin);
					try {
						tableAdmin.setModel(myUtil.buildTableModel(ml.viewMelee()));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnMelee.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMelee.setForeground(Color.DARK_GRAY);
		btnMelee.setBackground(Color.ORANGE);
		btnMelee.setBounds(12, 297, 157, 47);
		contentPane.add(btnMelee);
		
		JButton btnArmor = new JButton("Z\u0131rhlar");
		btnArmor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Armor armo=new Armor();
				armo.setArmorID(0);
				btnEkle.setVisible(true);
				btnEkle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						gArmor ga=new gArmor();
						ga.setVisible(true);
					}
				});
				
				JScrollPane scrollPane = new JScrollPane();
		        scrollPane.setBounds(0, 0, 516, 420);
		        veriGoster.add(scrollPane);
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(scrollPane, popupMenu);
				
				
				JMenuItem mnýtmSil = new JMenuItem("Sil");
				mnýtmSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
							try {
								int rowindex=tableAdmin.getSelectedRow();
								if(rowindex>=0) {
									int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
									Armor adelete=new Armor();
									adelete.setArmorID(id);
									int r;
								r = adelete.deleteArmor(adelete);
								if(r==1) {
									JOptionPane.showMessageDialog(null, "Silindi");
									tableAdmin.setModel(myUtil.buildTableModel(adelete.viewArmor()));
								}
							}} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
					}
				});
				popupMenu.add(mnýtmSil);
				
				JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
				mnýtmGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int rowindex=tableAdmin.getSelectedRow();
							
							if(rowindex>=0) {
								Armor garmo=new Armor();
								int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
								
								garmo.setArmorID(id);
								ResultSet ar=garmo.searchArmor(garmo);
								while(ar.next()) {
									garmo.setCapacity(ar.getInt("ACapacity"));
									garmo.setDamageReduction(ar.getInt("ADReduction"));
									garmo.setDurability(ar.getInt("ADurability"));
									garmo.setImgkucuk(ar.getString("AImgKucuk"));
									garmo.setLevel(ar.getInt("ALevel"));
									garmo.setType(ar.getString("AType"));
								}
								
							/*	guncelleArmor gar=new guncelleArmor(garmo);
								gar.setVisible(true);*/
							
							
						}} catch (Exception e5) {
							// TODO Auto-generated catch block
							e5.printStackTrace();
						}
					}
				});
				popupMenu.add(mnýtmGncelle);
				
					
				 scrollPane.setViewportView(tableAdmin);
					try {
						ResultSet ar=armo.viewArmor();
						tableAdmin.setModel(myUtil.buildTableModel(ar));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnArmor.setForeground(Color.DARK_GRAY);
		btnArmor.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnArmor.setBackground(Color.ORANGE);
		btnArmor.setBounds(12, 357, 157, 47);
		contentPane.add(btnArmor);
		
		JButton btnKasa = new JButton("Kasalar");
		btnKasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loot cr=new Loot();
				btnEkle.setVisible(true);
				btnEkle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guncelleKutu gk=new guncelleKutu();
						gk.setVisible(true);
					}
				});
				JScrollPane scrollPane = new JScrollPane();
		        scrollPane.setBounds(0, 0, 516, 420);
		        veriGoster.add(scrollPane);
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(scrollPane, popupMenu);
				
				
				JMenuItem mnýtmSil = new JMenuItem("Sil");
				mnýtmSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
							try {
								int rowindex=tableAdmin.getSelectedRow();
								if(rowindex>=0) {
									int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
									Loot silinenC=new Loot();
									silinenC.setCrateID(id);
									int r;
								r = silinenC.deleteCrate(silinenC);
								if(r==1) {
									JOptionPane.showMessageDialog(null, "Silindi");
									tableAdmin.setModel(myUtil.buildTableModel(silinenC.viewLoot()));
								}
							}} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
					}
				});
				popupMenu.add(mnýtmSil);
				
				JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
				mnýtmGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Yapým aþamasýnda");
					}
				});
				popupMenu.add(mnýtmGncelle);
					
				 scrollPane.setViewportView(tableAdmin);
					try {
						tableAdmin.setModel(myUtil.buildTableModel(cr.viewLoot()));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnKasa.setBackground(Color.ORANGE);
		btnKasa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKasa.setForeground(Color.DARK_GRAY);
		btnKasa.setBounds(12, 417, 157, 47);
		contentPane.add(btnKasa);
		
		JButton btnMaps = new JButton("Haritalar");
		btnMaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Maps mp=new Maps();
				btnEkle.setVisible(true);
				btnEkle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guncelleHarita gh=new guncelleHarita();
						gh.setVisible(true);
					}
				});
				JScrollPane scrollPane = new JScrollPane();
		        scrollPane.setBounds(0, 0, 516, 420);
		        veriGoster.add(scrollPane);
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(scrollPane, popupMenu);
				
				
				JMenuItem mnýtmSil = new JMenuItem("Sil");
				mnýtmSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
							try {
								int rowindex=tableAdmin.getSelectedRow();
								if(rowindex>=0) {
									int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
									Maps silinenM=new Maps();
									silinenM.setMapsID(id);
									int r;
								r = silinenM.deleteMaps(silinenM);
								if(r==1) {
									JOptionPane.showMessageDialog(null, "Silindi");
									tableAdmin.setModel(myUtil.buildTableModel(silinenM.viewMaps()));
								}
							}} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
					}
				});
				popupMenu.add(mnýtmSil);
				
				JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
				mnýtmGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Yapým Aþamasýnda");
					}
				});
				popupMenu.add(mnýtmGncelle);
					
				 scrollPane.setViewportView(tableAdmin);
					try {
						tableAdmin.setModel(myUtil.buildTableModel(mp.viewMaps()));
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnMaps.setForeground(Color.DARK_GRAY);
		btnMaps.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMaps.setBackground(Color.ORANGE);
		btnMaps.setBounds(12, 477, 157, 47);
		contentPane.add(btnMaps);
		
		
	//kodu her buton için yeniden düzenlenecek;	
/*	JPanel veriGoster = new JPanel();
		veriGoster.setBackground(Color.WHITE);
		veriGoster.setBounds(286, 104, 516, 420);
		contentPane.add(veriGoster);
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(195, 104, 692, 420);
        veriGoster.add(scrollPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem mnýtmSil = new JMenuItem("Sil");
		mnýtmSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					try {
						int rowindex=tableAdmin.getSelectedRow();
						if(rowindex>=0) {
							int id=Integer.parseInt(tableAdmin.getValueAt(rowindex,0).toString());
							Gamer gdelete=new Gamer();
							gdelete.setId(id);
							int r;
						r = gdelete.deleteGamer();
						if(r==1) {
							JOptionPane.showMessageDialog(null, "Silindi");
							tableAdmin.setModel(tablo(gamer));
						}
					}} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
			}
		});
		popupMenu.add(mnýtmSil);
		
		JMenuItem mnýtmGncelle = new JMenuItem("G\u00FCncelle");
		mnýtmGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Kullanýcýlarýn bilgilerini kullanýcýlar deðiþtirebilir!!");
			}
		});
		popupMenu.add(mnýtmGncelle);
			
		 scrollPane.setViewportView(tableAdmin);
			try {
				tableAdmin.setModel(tablo(gamer));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		
		//buraya kadar tekrarlý
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAL.DataAccess;
import UI.giris;
import UI.menu;

public class Gamer {
	private int id;
	private String kullaniciAdi;
	private String email;
	private String sifre;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	public int addGamer()throws Exception{
		String query=String.format("insert into gamer(gmKullaniciAdi,gmEmail,gmSifre,gmControl)"+
									"values('%s','%s','%s','%d')",getKullaniciAdi(),getEmail(),getSifre(),0);
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteGamer()throws Exception{
		String query=String.format("delete from gamer where gmID='%d'",getId());
		DataAccess da=new DataAccess();
		int a=da.ExecuteUpdate(query);
		
		return a;
	}
	
	public int updateGamer()throws Exception{
		String query=String.format("update gamer set gmKullaniciAdi='%s',gmEmail='%s',gmSifre='%s' where gmID='%d'",getKullaniciAdi(),getEmail(),getSifre(),getId());
		DataAccess da=new DataAccess();
		int a=da.ExecuteUpdate(query);
		
		return a;
	}
	public ResultSet viewGamer()throws Exception{
		String query="select * from gamer";
		DataAccess da=new DataAccess();
		
		return da.ExecuteQuery(query);
		
	}
	public  boolean login(String ka,String pas){
		Gamer secilmis=new Gamer();
		secilmis.setKullaniciAdi(ka);
		secilmis.setSifre(pas);
		DataAccess da;
		try {
			da = new DataAccess();
		
		String query =String.format("select * from gamer where gmKullaniciAdi='%s' and gmSifre='%s'",ka,pas);
		ResultSet sonuc=da.ExecuteQuery(query);
		if(sonuc.next()) {
			secilmis.setEmail(sonuc.getString("gmEmail"));
			secilmis.setId(sonuc.getInt("gmID"));
			menu menugecis=new menu(secilmis);
			menugecis.setVisible(true);
			da.con.close();
			return true;
		}else {
			return false;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();return false;
		}
		
	}
	public boolean logout()throws Exception{
		return true;
	}
	
}

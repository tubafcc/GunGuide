package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Guns {
	private int gunID;
	private String gunName;
	private String gunType;
	private String gunFire;
	private int gunDamage;
	private int gunMagazine;
	private int gunRange;
	private String gunBullet;
	private String gunBspeed;
	private String imgKucuk;
	private String imgBuyuk;
	
	
	
	public int getGunID() {
		return gunID;
	}

	public void setGunID(int gunID) {
		this.gunID = gunID;
	}

	public String getGunName() {
		return gunName;
	}

	public void setGunName(String gunName) {
		this.gunName = gunName;
	}

	public String getGunType() {
		return gunType;
	}

	public void setGunType(String gunType) {
		this.gunType = gunType;
	}

	public String getGunFire() {
		return gunFire;
	}

	public void setGunFire(String gunFire) {
		this.gunFire = gunFire;
	}

	public int getGunDamage() {
		return gunDamage;
	}

	public void setGunDamage(int gunDamage) {
		this.gunDamage = gunDamage;
	}

	public int getGunMagazine() {
		return gunMagazine;
	}

	public void setGunMagazine(int gunMagazine) {
		this.gunMagazine = gunMagazine;
	}

	public int getGunRange() {
		return gunRange;
	}

	public void setGunRange(int gunRange) {
		this.gunRange = gunRange;
	}

	public String getGunBullet() {
		return gunBullet;
	}

	public void setGunBullet(String gunBullet) {
		this.gunBullet = gunBullet;
	}

	public String getGunBspeed() {
		return gunBspeed;
	}

	public void setGunBspeed(String gunBspeed) {
		this.gunBspeed = gunBspeed;
	}

	public String getImgKucuk() {
		return imgKucuk;
	}

	public void setImgKucuk(String imgKucuk) {
		this.imgKucuk = imgKucuk;
	}

	public String getImgBuyuk() {
		return imgBuyuk;
	}

	public void setImgBuyuk(String imgBuyuk) {
		this.imgBuyuk = imgBuyuk;
	}

	public int addGun(Guns g)throws Exception{
		String query=String.format("insert into guns(GName,GDamage,GBSpeed,GRange,GMagazine,GBullet,GType,GFSpeed,GImgBuyuk,GImgKucuk) values('%s','%d','%s','%d','%d','%s','%s','%s','%s','%s')",g.getGunName(),g.getGunDamage(),g.getGunBspeed(),g.getGunRange(),g.getGunMagazine(),g.getGunBullet(),g.getGunType(),g.getGunFire(),g.getImgBuyuk(),g.getImgKucuk());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteGun(Guns g)throws Exception{
		String query=String.format("delete from guns where GID='%d'",g.getGunID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int updateGun(Guns g)throws Exception{
		String query=String.format("update guns set gunName=%s,gunType=%s,gunFire=%s,gunDamage=%s,gunMagazine=%s,gunRange=%s,gunBullet=%s,gunBspped=%s",g.getGunName(),g.getGunType(),g.getGunFire(),g.getGunDamage(),g.getGunMagazine(),g.getGunRange(),g.getGunBullet(),g.getGunBspeed());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet viewGuns()throws Exception{
		String query="select * from guns";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
	public ResultSet viewGunsID(int id)throws Exception{
		String query=String.format("select * from guns where GID='%d'",id);
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
	public ResultSet viewGunsbyType(String t)throws Exception{
		String query=String.format("select * from guns where GType='%s'",t);
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
}

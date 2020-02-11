package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Loot {
	private  int crateID;
	private String crateName;
	private String imgKucuk;
	
	public String getImgKucuk() {
		return imgKucuk;
	}
	public void setImgKucuk(String imgKucuk) {
		this.imgKucuk = imgKucuk;
	}
	public int getCrateID() {
		return crateID;
	}
	public void setCrateID(int crateID) {
		this.crateID = crateID;
	}
	public String getCrateName() {
		return crateName;
	}
	public void setCrateName(String crateName) {
		this.crateName = crateName;
	}
	public int addCrate(Loot g)throws Exception{
		String query=String.format("insert into loot(LName,LImgKucuk)"+
									"values('%s','%s')",g.getCrateName(),g.getImgKucuk());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteCrate(Loot g)throws Exception{
		String query=String.format("delete from loot where LID='%d'",g.getCrateID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int updateLoot(Loot g)throws Exception{
		String query=String.format("update loot set lootName=%s",g.getCrateName());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet viewLoot()throws Exception{
		String query="select * from loot";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
	
}

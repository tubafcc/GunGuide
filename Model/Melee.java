package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Melee {
	private int meleeID;
	private String MLtype;
	private String mlInformation;
	private String imgKucuk;
	public String getImgKucuk() {
		return imgKucuk;
	}
	public void setImgKucuk(String imgKucuk) {
		this.imgKucuk = imgKucuk;
	}
	public int getMeleeID() {
		return meleeID;
	}
	public void setMeleeID(int meleeID) {
		this.meleeID = meleeID;
	}
	public String getMLtype() {
		return MLtype;
	}
	public void setMLtype(String mLtype) {
		MLtype = mLtype;
	}
	public String getMlInformation() {
		return mlInformation;
	}
	public void setMlInformation(String mlInformation) {
		this.mlInformation = mlInformation;
	}
	
	public int addMelee(Melee m)throws Exception{
		String query=String.format("insert into melee(MName,MImgKucuk)"+
									"values('%s','%s')",m.getMLtype(),m.getImgKucuk());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteMelee(Melee m)throws Exception{
		String query=String.format("delete from melee where MeID='%d'",m.getMeleeID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int updateMelee(Melee m)throws Exception{
		String query=String.format("update melee set type=%s,information=%s",m.getMLtype(),m.getMlInformation());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet viewMelee()throws Exception{
		String query="select * from melee";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
}

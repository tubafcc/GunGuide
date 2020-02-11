package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Maps {
	private int mapsID;
	private String mapsName;
	private String imgKucuk;
	private String imgBBuyuk;
	public String getImgKucuk() {
		return imgKucuk;
	}
	public void setImgKucuk(String imgKucuk) {
		this.imgKucuk = imgKucuk;
	}
	public String getImgBBuyuk() {
		return imgBBuyuk;
	}
	public void setImgBBuyuk(String imgBBuyuk) {
		this.imgBBuyuk = imgBBuyuk;
	}
	public int getMapsID() {
		return mapsID;
	}
	public void setMapsID(int mapsID) {
		this.mapsID = mapsID;
	}
	public String getMapsName() {
		return mapsName;
	}
	public void setMapsName(String mapsName) {
		this.mapsName = mapsName;
	}
	
	public int addMaps(Maps g)throws Exception{
		String query=String.format("insert into maps(MName,MImgKucuk,MImgBuyuk)"+
									"values('%s','%s','%s')",g.getMapsName(),g.getImgKucuk(),g.getImgBBuyuk());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteMaps(Maps g)throws Exception{
		String query=String.format("delete from maps where MID='%d'",g.getMapsID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int updateMaps(Maps g)throws Exception{
		String query=String.format("update maps set mapName=%s",g.getMapsName());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet viewMaps()throws Exception{
		String query="select * from maps";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
}

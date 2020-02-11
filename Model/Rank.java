package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Rank {
	private int rankID;
	private String rankName;
	private String imgKucuk;
	public String getImgKucuk() {
		return imgKucuk;
	}
	public void setImgKucuk(String imgKucuk) {
		this.imgKucuk = imgKucuk;
	}
	public int getRankID() {
		return rankID;
	}
	public void setRankID(int rankID) {
		this.rankID = rankID;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	
	public int addRank(Rank g)throws Exception{
		String query=String.format("insert into gamer(RName)"+
									"values('%s')",g.getRankName());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteRank(Rank g)throws Exception{
		String query=String.format("delete from rank where RID='%s'",g.getRankID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int updateRank(Rank g)throws Exception{
		String query=String.format("update rank set RName='%s'",g.getRankName());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet viewRank()throws Exception{
		String query="select * from rank";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
}

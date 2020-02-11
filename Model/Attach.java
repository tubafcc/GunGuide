package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Attach {
	private int attachID;
	private String attachName;
	private String imgKucuk;
	
	public String getImgKucuk() {
		return imgKucuk;
	}
	public void setImgKucuk(String imgKucuk) {
		this.imgKucuk = imgKucuk;
	}
	public int getAttachID() {
		return attachID;
	}
	public void setAttachID(int attachID) {
		this.attachID = attachID;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public String getAttachType() {
		return attachType;
	}
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	private String attachType;
	
	
	public int addAttach(Attach g)throws Exception{
		String query=String.format("insert into Attach(AtType,AtName,AtImgKucuk)"+
									"values('%s','%s','%s')",g.getAttachType(),g.getAttachName(),g.getImgKucuk());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteAttach(Attach g)throws Exception{
		String query=String.format("delete from Attach where AtID='%s'",g.getAttachID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int updateAttach(Attach g)throws Exception{
		String query=String.format("update attach set attachType=%s,attachName=%s,",g.getAttachType(),g.getAttachName());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet viewAttach()throws Exception{
		String query="select * from Attach";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
}

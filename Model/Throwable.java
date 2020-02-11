package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Throwable {
	private int throwableID;
	private String thaType;
	private String imgKucuk;
	
	public String getImgKucuk() {
		return imgKucuk;
	}
	public void setImgKucuk(String imgKucuk) {
		this.imgKucuk = imgKucuk;
	}
	public int getThrowableID() {
		return throwableID;
	}
	public void setThrowableID(int throwableID) {
		this.throwableID = throwableID;
	}
	public String getThaType() {
		return thaType;
	}
	public void setThaType(String thaType) {
		this.thaType = thaType;
	}
	
	
	public int addThrowable(Throwable t)throws Exception{
		String query=String.format("insert into throwable(TName,TImgKucuk)"+
									"values('%s','%s')",t.getThaType(),t.getImgKucuk());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteThrowable(Throwable t)throws Exception{
		String query=String.format("delete from throwable where TID='%d'",t.getThrowableID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int updateThrowable(Throwable t)throws Exception{
		String query=String.format("update throwable set type=%s,information=%s",t.getThaType());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet viewThrowable()throws Exception{
		String query="select * from throwable";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
}

package Model;

import java.sql.ResultSet;

import DAL.DataAccess;

public class Armor {
	private int armorID;
	private int level;
	private String type;//helmet west backpack
	private int durability;
	private int capacity;
	private int damageReduction;
	private String imgkucuk;
	
	
	public String getImgkucuk() {
		return imgkucuk;
	}
	public void setImgkucuk(String imgkucuk) {
		this.imgkucuk = imgkucuk;
	}
	public int getArmorID() {
		return armorID;
	}
	public void setArmorID(int armorID) {
		this.armorID = armorID;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getDamageReduction() {
		return damageReduction;
	}
	public void setDamageReduction(int damageReduction) {
		this.damageReduction = damageReduction;
	}
	
	public int addArmor()throws Exception{
		String query=String.format("insert into armor(ALevel,AType,ADurability,ACapacity,ADReduction,AImgKucuk)"+
									"values('%s','%s','%s','%s','%s','%s')",getLevel(),getType(),getDurability(),getCapacity(),getDamageReduction(),getImgkucuk());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int deleteArmor(Armor a)throws Exception{
		String query=String.format("delete from armor where AID='%s'",a.getArmorID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	
	public int updateArmor(Armor a)throws Exception{
		String query=String.format("update armor set ALevel='%s',AType='%s',ADurability='%s',ACapacity='%s',ADReduction='%s',AImgKucuk='%s' where AID='%s'",a.getLevel(),a.getType(),a.getDurability(),a.getCapacity(),a.getDamageReduction(),a.getImgkucuk(),a.getArmorID());
		DataAccess da=new DataAccess();
		return da.ExecuteUpdate(query);
	}
	public ResultSet viewArmor()throws Exception{
		String query="select * from armor";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
	public ResultSet viewWest()throws Exception{
		String query="select * from armor where AType='Yelek'";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
	public ResultSet viewHel()throws Exception{
		String query="select * from armor where AType='Kask'";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
	public ResultSet viewBack()throws Exception{
		String query="select * from armor where AType='Sýrt Çantasý'";
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
	public ResultSet searchArmor(Armor a) throws Exception {
		String query=String.format("select * from armor where AID='"+a.getArmorID()+"'");
		DataAccess da=new DataAccess();
		return da.ExecuteQuery(query);
	}
	
}

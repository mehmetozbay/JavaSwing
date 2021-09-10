package javagui;

public class User {

	private static int nextId=0;
	private int id;
	private String adi;
	private String meslek;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String adi, String meslek) {
		super();
		setId(++nextId);
		this.adi = adi;
		this.meslek = meslek;
	}
	
	public User(int id, String adi, String meslek) {
		super();
		this.id=id;
		this.adi = adi;
		this.meslek = meslek;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getMeslek() {
		return meslek;
	}
	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}
	
	
}

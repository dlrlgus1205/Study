package vo;

public class AdminVo {
	 private int ad_no;
	 private String id;
	 private String name;
	 private String pass;
	public int getAd_no() {
		return ad_no;
	}
	public void setAd_no(int ad_no) {
		this.ad_no = ad_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "AdminVo [ad_no=" + ad_no + ", id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	 
}

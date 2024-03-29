package kr.or.ddit.member.vo;

public class ZipVo {
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	@Override
	public String toString() {
		return "ZipVo [zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + "]";
	}
	
	
}

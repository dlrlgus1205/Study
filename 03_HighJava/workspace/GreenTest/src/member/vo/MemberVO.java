package member.vo;

public class MemberVO {

	 private String mem_id;
	 private String mem_pass;
	 private String mem_name;
	 private String mem_bir;
	 private String mem_mail;
	 private String mem_tel;
	 private String mem_leaveyn;
	 private String mem_nickname;
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_leaveyn() {
		return mem_leaveyn;
	}
	public void setMem_leaveyn(String mem_leaveyn) {
		this.mem_leaveyn = mem_leaveyn;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_name=" + mem_name + ", mem_bir="
				+ mem_bir + ", mem_mail=" + mem_mail + ", mem_tel=" + mem_tel + ", mem_leaveyn=" + mem_leaveyn
				+ ", mem_nickname=" + mem_nickname + "]";
	}
	 
	 
}

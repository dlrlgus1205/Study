package vo;

public class MemberVo {
	 private int mem_no;
	 private String id;
	 private String name;
	 private String pass;
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
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
		return "MemberVo [mem_no=" + mem_no + ", id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	 
}

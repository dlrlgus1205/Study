package user.vo;

public class UserVO {

	
	 private int user_no;
	 private String mem_id;
	 private String admin_id;
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	@Override
	public String toString() {
		return "UserVO [user_no=" + user_no + ", mem_id=" + mem_id + ", admin_id=" + admin_id + "]";
	}
	 
	 
}

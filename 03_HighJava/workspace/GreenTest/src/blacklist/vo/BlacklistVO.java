package blacklist.vo;

public class BlacklistVO {

	 private int blacklist_no;
	 private String blacklist_date;
	 private String mem_id;
	 private String blacklist_id;
	public int getBlacklit_no() {
		return blacklist_no;
	}
	public void setBlacklit_no(int blacklist_no) {
		this.blacklist_no = blacklist_no;
	}
	public String getBlacklist_date() {
		return blacklist_date;
	}
	public void setBlacklist_date(String blacklist_date) {
		this.blacklist_date = blacklist_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBlacklist_id() {
		return blacklist_id;
	}
	public void setBlacklist_id(String blacklist_id) {
		this.blacklist_id = blacklist_id;
	}
	
	@Override
	public String toString() {
		return "BlacklistVO [blacklist_no=" + blacklist_no + ", blacklist_date=" + blacklist_date + ", mem_id=" + mem_id
				+ ", blacklist_id=" + blacklist_id + "]";
	}
	 
	 
}

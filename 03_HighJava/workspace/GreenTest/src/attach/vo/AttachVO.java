package attach.vo;

public class AttachVO {

	 private int attach_no;
	 private String attach_path;
	 private String attach_date;
	 private String attach_name;
	 private int notice_no;
	public int getAttach_no() {
		return attach_no;
	}
	public void setAttach_no(int attach_no) {
		this.attach_no = attach_no;
	}
	public String getAttach_path() {
		return attach_path;
	}
	public void setAttach_path(String attach_path) {
		this.attach_path = attach_path;
	}
	public String getAttach_date() {
		return attach_date;
	}
	public void setAttach_date(String attach_date) {
		this.attach_date = attach_date;
	}
	public String getAttach_name() {
		return attach_name;
	}
	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
	}
	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	
	@Override
	public String toString() {
		return "AttachVO [attach_no=" + attach_no + ", attach_path=" + attach_path + ", attach_date=" + attach_date
				+ ", attach_name=" + attach_name + ", notice_no=" + notice_no + "]";
	}
	 
	 
}

package message.vo;

public class MessageVO {

	 private int message_no;
	 private String message_title;
	 private String message_contetn;
	 private String message_date;
	 private String message_readyn;
	 private int user_no1;
	 private int user_no2;
	 private String message_checkyn;
	 private String message_group;
	public int getMessage_no() {
		return message_no;
	}
	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}
	public String getMessage_title() {
		return message_title;
	}
	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}
	public String getMessage_contetn() {
		return message_contetn;
	}
	public void setMessage_contetn(String message_contetn) {
		this.message_contetn = message_contetn;
	}
	public String getMessage_date() {
		return message_date;
	}
	public void setMessage_date(String message_date) {
		this.message_date = message_date;
	}
	public String getMessage_readyn() {
		return message_readyn;
	}
	public void setMessage_readyn(String message_readyn) {
		this.message_readyn = message_readyn;
	}
	public int getUser_no1() {
		return user_no1;
	}
	public void setUser_no1(int user_no1) {
		this.user_no1 = user_no1;
	}
	public int getUser_no2() {
		return user_no2;
	}
	public void setUser_no2(int user_no2) {
		this.user_no2 = user_no2;
	}
	public String getMessage_checkyn() {
		return message_checkyn;
	}
	public void setMessage_checkyn(String message_checkyn) {
		this.message_checkyn = message_checkyn;
	}
	public String getMessage_group() {
		return message_group;
	}
	public void setMessage_group(String message_group) {
		this.message_group = message_group;
	}
	@Override
	public String toString() {
		return "MessageVO [message_no=" + message_no + ", message_title=" + message_title + ", message_contetn="
				+ message_contetn + ", message_date=" + message_date + ", message_readyn=" + message_readyn
				+ ", user_no1=" + user_no1 + ", user_no2=" + user_no2 + ", message_checkyn=" + message_checkyn
				+ ", message_group=" + message_group + "]";
	}
	 
	 
}

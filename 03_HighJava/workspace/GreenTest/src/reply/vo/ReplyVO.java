package reply.vo;

public class ReplyVO {

	 private int reply_no;
	 private int post_no;
	 private String reply_content;
	 private String reply_write_date;
	 private String reply_update_date;
	 private String reply_delyn;
	 private String reportyn;
	 private int report_count;
	 private int user_no;
	 
	 private String mem_name;
	 
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_write_date() {
		return reply_write_date;
	}
	public void setReply_write_date(String reply_write_date) {
		this.reply_write_date = reply_write_date;
	}
	public String getReply_update_date() {
		return reply_update_date;
	}
	public void setReply_update_date(String reply_update_date) {
		this.reply_update_date = reply_update_date;
	}
	public String getReply_delyn() {
		return reply_delyn;
	}
	public void setReply_delyn(String reply_delyn) {
		this.reply_delyn = reply_delyn;
	}
	public String getReportyn() {
		return reportyn;
	}
	public void setReportyn(String reportyn) {
		this.reportyn = reportyn;
	}
	public int getReport_count() {
		return report_count;
	}
	public void setReport_count(int report_count) {
		this.report_count = report_count;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "ReplyVO [reply_no=" + reply_no + ", post_no=" + post_no + ", reply_content=" + reply_content
				+ ", reply_write_date=" + reply_write_date + ", reply_update_date=" + reply_update_date
				+ ", reply_delyn=" + reply_delyn + ", reportyn=" + reportyn + ", report_count=" + report_count
				+ ", user_no=" + user_no + "]";
	}
	 
	 
}

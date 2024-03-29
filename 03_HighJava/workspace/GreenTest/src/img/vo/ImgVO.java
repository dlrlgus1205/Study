package img.vo;

import admin.vo.AdminVO;
import notice.vo.NoticeVO;

public class ImgVO {

	 private int img_no;
	 private int post_no;
	 private String img_name;
	 private String img_path;
	 private String img_upload_date;
	 
	 private AdminVO adminVo;
	 private NoticeVO noticeVo;
	 
	 
	public NoticeVO getNoticeVo() {
		return noticeVo;
	}
	public void setNoticeVo(NoticeVO noticeVo) {
		this.noticeVo = noticeVo;
	}
	public AdminVO getAdminVo() {
		return adminVo;
	}
	public void setAdminVo(AdminVO adminVo) {
		this.adminVo = adminVo;
	}
	public int getImg_no() {
		return img_no;
	}
	public void setImg_no(int img_no) {
		this.img_no = img_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getImg_upload_date() {
		return img_upload_date;
	}
	public void setImg_upload_date(String img_upload_date) {
		this.img_upload_date = img_upload_date;
	}
	@Override
	public String toString() {
		return "ImgVO [img_no=" + img_no + ", post_no=" + post_no + ", img_name=" + img_name + ", img_path=" + img_path
				+ ", img_upload_date=" + img_upload_date + "]";
	}
	 
	 
}

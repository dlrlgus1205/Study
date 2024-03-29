package notice.vo;

import java.util.List;

import admin.vo.AdminVO;
import img.vo.ImgVO;
import reply.vo.ReplyVO;

public class NoticeVO {

	 private int notice_no;
	 private String notice_date;
	 private String notice_title;
	 private String notice_content;
	 private String admin_id;
	 
	 private AdminVO adminVo;
	 public AdminVO getAdminVo() {
		return adminVo;
	}
	public void setAdminVo(AdminVO adminVo) {
		this.adminVo = adminVo;
	}
	public List<ImgVO> getImgList() {
		return imgList;
	}
	public void setImgList(List<ImgVO> imgList) {
		this.imgList = imgList;
	}
	public ReplyVO getReplyVo() {
		return replyVo;
	}
	public void setReplyVo(ReplyVO replyVo) {
		this.replyVo = replyVo;
	}
	private List<ImgVO> imgList;
	 private ReplyVO replyVo;
	 
	 
	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	@Override
	public String toString() {
		return "NoticeVO [notice_no=" + notice_no + ", notice_date=" + notice_date + ", notice_title=" + notice_title
				+ ", notice_content=" + notice_content + ", admin_id=" + admin_id + "]";
	}
	 
	 
}

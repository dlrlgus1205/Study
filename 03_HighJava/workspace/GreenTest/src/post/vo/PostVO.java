package post.vo;

import java.util.List;

import img.vo.ImgVO;
import member.vo.MemberVO;
import reply.vo.ReplyVO;

public class PostVO {

	 private int post_no;
	 private String post_title;
	 private String post_content;
	 private String post_write_date;
	 private String post_update_date;
	 private int post_count;
	 private String post_delyn;
	 private String mem_id;
	 private String report_yn;
	 private int report_count;
	 private int category_no;
	 private int board_no;
	 
	 private MemberVO memVo;
	 private List<ImgVO> imgList;
	 private ReplyVO replyVo;
	 
	//게시판별 총 조회수가 담겨질 변수
	 private int total_likes;
	 
	 

	 
	 
	public ReplyVO getReplyVo() {
		return replyVo;
	}
	public void setReplyVo(ReplyVO replyVo) {
		this.replyVo = replyVo;
	}

	 
	public int getTotal_likes() {
		return total_likes;
	}
	public void setTotal_likes(int total_likes) {
		this.total_likes = total_likes;
	}

	public MemberVO getMemVo() {
		return memVo;
	}
	public void setMemVo(MemberVO memVo) {
		this.memVo = memVo;
	}
	public List<ImgVO> getImgList() {
		return imgList;
	}
	public void setImgList(List<ImgVO> imgList) {
		this.imgList = imgList;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_write_date() {
		return post_write_date;
	}
	public void setPost_write_date(String post_write_date) {
		this.post_write_date = post_write_date;
	}
	public String getPost_update_date() {
		return post_update_date;
	}
	public void setPost_update_date(String post_update_date) {
		this.post_update_date = post_update_date;
	}
	public int getPost_count() {
		return post_count;
	}
	public void setPost_count(int post_count) {
		this.post_count = post_count;
	}
	public String getPost_delyn() {
		return post_delyn;
	}
	public void setPost_delyn(String post_delyn) {
		this.post_delyn = post_delyn;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getReport_yn() {
		return report_yn;
	}
	public void setReport_yn(String report_yn) {
		this.report_yn = report_yn;
	}
	public int getReport_count() {
		return report_count;
	}
	public void setReport_count(int report_count) {
		this.report_count = report_count;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	@Override
	public String toString() {
		return "PostVO [post_no=" + post_no + ", post_title=" + post_title + ", post_content=" + post_content
				+ ", post_write_date=" + post_write_date + ", post_update_date=" + post_update_date + ", post_count="
				+ post_count + ", post_delyn=" + post_delyn + ", mem_id=" + mem_id + ", report_yn=" + report_yn
				+ ", report_count=" + report_count + ", category_no=" + category_no + ", board_no=" + board_no + "]";
	}
	 
	 

}

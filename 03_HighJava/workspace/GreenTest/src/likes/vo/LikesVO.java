package likes.vo;

public class LikesVO {

	 private int likes_no;
	 private int post_no;
	 private String mem_id;
	public int getLike_no() {
		return likes_no;
	}
	public void setLike_no(int likes_no) {
		this.likes_no = likes_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "LikesVO [likes_no=" + likes_no + ", post_no=" + post_no + ", mem_id=" + mem_id + "]";
	}
	 
	 
}

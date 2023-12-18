package vo;

public class BookVo {
	 private int book_no;
	 private String name;
	 private String content;
	 private String writer;
	 private int rent_return;
	 private String del_yn;
	 private String rent_yn;
	public String getRent_yn() {
		return rent_yn;
	}
	public void setRent_yn(String rent_yn) {
		this.rent_yn = rent_yn;
	}
	public int getBook_no() {
		return book_no;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getRent_return() {
		return rent_return;
	}
	public void setRent_return(int rent_return) {
		this.rent_return = rent_return;
	}
	@Override
	public String toString() {
		return "BookVo [book_no=" + book_no + ", name=" + name + ", content=" + content + ", writer=" + writer
				+ ", rent_return=" + rent_return + ", del_yn=" + del_yn + ", rent_yn=" + rent_yn + "]";
	}
	
	
	 
	 

}

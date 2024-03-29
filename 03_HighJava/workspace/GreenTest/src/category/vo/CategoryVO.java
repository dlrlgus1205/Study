package category.vo;

public class CategoryVO {

	 private int category_no;
	 private int board_no;
	 private String category_name;
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
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	@Override
	public String toString() {
		return "CategoryVO [category_no=" + category_no + ", board_no=" + board_no + ", category_name=" + category_name
				+ "]";
	}
	 
	 
}

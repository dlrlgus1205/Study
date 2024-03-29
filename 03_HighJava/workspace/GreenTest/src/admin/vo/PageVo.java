package admin.vo;

public class PageVo {
	private int start;
	private int end;
	private int startPage;
	private int endPage;
	private int totalPage;
	
	private int count;
	private static int perList = 10; // 한 페이지에 보여질 글 갯수
	private static int perPage = 3; // 보여질 페이지 수
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static int getPerList() {
		return perList;
	}
	public static void setPerList(int perList) {
		PageVo.perList = perList;
	}
	public static int getPerPage() {
		return perPage;
	}
	public static void setPerPage(int perPage) {
		PageVo.perPage = perPage;
	}
	@Override
	public String toString() {
		return "PageVo [start=" + start + ", end=" + end + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", count=" + count + "]";
	}
	
	
	
}

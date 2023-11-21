package kr.or.ddit.study06.sec06.test03;

public class Prod {
	
	private static int prodno = 1;
	
	private int no;
	private String name;
	private String price;
	
	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return no + ". [이름 = " + name + ", 가격 = " + price + "]";
	}
	
	Prod(){
		no = prodno++;
	}
}

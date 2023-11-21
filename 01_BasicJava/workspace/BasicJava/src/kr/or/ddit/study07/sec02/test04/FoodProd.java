package kr.or.ddit.study07.sec02.test04;

public class FoodProd extends Prod {
	
	private int date;

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "식품 [유통기한 = " + getDate() + ", 이름 = " + getName() + ", 가격 = " + getPrice() + "]";
	}
	
}

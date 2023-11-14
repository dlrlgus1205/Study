package kr.or.ddit.study06.sec03.tes02;

public class Menu {
	int price;
	String store;
	String name;
	
	Menu(int price, String store, String name){
		this.price = price;
		this.store = store;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Menu [price=" + price + ", store=" + store + ", name=" + name + "]";
	}
}

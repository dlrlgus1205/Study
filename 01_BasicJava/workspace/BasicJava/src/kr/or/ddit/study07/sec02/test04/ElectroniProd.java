package kr.or.ddit.study07.sec02.test04;

public class ElectroniProd extends Prod {
	
	private int voltage;
	private int wh;
	
	public int getVoltage() {
		return voltage;
	}
	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}
	public int getWh() {
		return wh;
	}
	public void setWh(int wh) {
		this.wh = wh;
	}
	
	@Override
	public String toString() {
		return "전자제품 [전압 = " + getVoltage() + ", 전력 = " + getWh() + ", 이름 = " + getName()
				+ ", 가격 = " + getPrice() + "]";
	}
	
}

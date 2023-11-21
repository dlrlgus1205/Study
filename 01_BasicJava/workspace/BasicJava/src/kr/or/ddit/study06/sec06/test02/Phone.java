package kr.or.ddit.study06.sec06.test02;

public class Phone {
	
	private String num;
	private String name;
	private String group;
	private String sn;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	@Override
	public String toString() {
		return "[전화번호 = " + num + ", 이름 = " + name + ", 그룹 = " + group + ", 단축키 = " + sn + "]";
	}
	
}

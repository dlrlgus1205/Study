package kr.or.ddit.study07.sec01.test02;

public class Main {
	
	public static void main(String[] args) {
		FolderPhone fp = new FolderPhone();
		System.out.println("폴더폰-----------------------------");
		fp.camera();
		fp.tell();
		fp.fold();
		fp.internet();
		SmartPhone sp = new SmartPhone();
		System.out.println("스마트폰---------------------------");
		sp.camera();
		sp.tell();
		sp.touch();
		sp.internet();
	}
	
}

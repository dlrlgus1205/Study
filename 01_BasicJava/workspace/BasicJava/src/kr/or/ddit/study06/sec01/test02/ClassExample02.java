package kr.or.ddit.study06.sec01.test02;

public class ClassExample02 {
	public static void main(String[] args) {
		/*
		 * Book 이라는 클래스 만들어보고
		 * Book 이라는 필드 값에
		 * 각각
		 * 가격, 이름, 저자 생성해보기
		 */
		Book b1 = new Book();
		b1.price = 9500;
		b1.name = "이 멋진 세계에 축복을!";
		b1.writer = "아카츠키 나츠메";
		
		Book b2 = new Book();
		b2.price = 13500;
		b2.name = "Re: 제로부터 시작하는 이세계 생활";
		b2.writer = "나가츠키 탓페이";		
		
		Book b3 = new Book();
		b3.price = 12000;
		b3.name = "최애의 아이";
		b3.writer = "요코야리 멩고";
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3
				);
	}
}

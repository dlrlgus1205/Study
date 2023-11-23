package kr.or.ddit.study13.sec01;

public class CustomList {
	int[] arr;
	int size = 0;
	// 생성자가 만들어질 때 배열 크기를 생성
	
	public CustomList() {
		arr = new int[10];
	}
	
	public void add(int num) {
		// 배열 크기가 꽉 찼다면 배열 크기를 10만큼 늘려줌
		if(size - 1 >= arr.length) {
			// 배열 크기가 10만큼 큰 배열 임시 생성
			int[] temp = new int[arr.length + 10];
			// for 문을 통해 현재까지의 데이터 전체 넣어주기
			for(int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
		}
		//값이 추가 되면 배열 인덱스 값을 증가시키기
		arr[size++] = num;
	}
	
	public int remove(int index) {
		// 0 1 7 9 10 0 0 0 0 0
		// index = 2
		int[] temp = new int[arr.length];
		int num = 0;
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i == index) {
				result = arr[i];
				continue;
			}
			temp[num++] = arr[i];
		}
		arr = temp;
		size--;
		return result;
	}
	
	public int get(int index) {
		return arr[index];
	}
	
	public int size() {
		return size;
	}
}

package kr.or.ddit.study06.sec04.test02;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		Lotto l = new Lotto();
		int[][][] bundle = l.lottoBundle(12000);
		l.printBundle(bundle);
	}
	
	public void printBundle(int[][][] bundle) {
		for(int i = 0; i < bundle.length; i++) {
			int[][] paper = bundle[i];
			System.out.println("--------------------------------------------");
			for(int j = 0; j < bundle[i].length; j++) {
				int[]lotto = paper[j];
				for(int k = 0; k < bundle[i][j].length; k++) {
					int num = lotto[k];
					System.out.print(num + "\t");
				}
				System.out.println();
			}
		}
	}
	
	public int[][][] lottoBundle(int money) {
		int paper = money / 5000;
		if(money % 5000 != 0) {
			paper++;
		}
		int[][][] bundle = new int[paper][5][6];
		for(int i = 0; i < bundle.length; i++) {
			bundle[i] = lottoPaper();
		}
		if(money % 5000 != 0) {
			bundle[paper - 1] = lottoPaper((money % 5000) / 1000);
		}
		return bundle;
	}
	
	public int[][] lottoPaper(int num) {
		int[][] paper = new int[num][6];
		for(int i = 0; i < paper.length; i++) {
			paper[i] = generateLotto();
		}
		return paper;
	}
	
	public int[][] lottoPaper() {
		return lottoPaper(5);
	}
	
	public int[] generateLotto() {
		
		int[] lotto = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			int ran = new Random().nextInt(45) + 1;
			lotto[i] = ran;
			for (int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		sort(lotto);
//		Arrays.sort(lotto);
//		System.out.println(Arrays.toString(lotto));
		return lotto;
	}
	
	public String arrayTostring(int[] lotto) {
		String result = "[";
		for(int i = 0; i < lotto.length; i++) {
			result += lotto[i];
			if(lotto.length - 1 == i) {
				result +="]";
			}
			else {
				result += ", ";
			}
		}
		return result;
	}
	
	public int[] sort(int[] lotto) {
		for(int i = 0; i < lotto.length - 1; i++) {
			for(int j = 0; j < lotto.length - 1; j++) {
				if(lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}
		}
		return lotto;
	}
}

package kr.or.ddit.study05;

import java.util.Scanner;

public class Free02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		String answer = "";
        String rsp = "502";
        answer = rsp.replace("2", "0").replace("0", "5").replace("5", "2");
        
        System.out.println(answer);
	}
}

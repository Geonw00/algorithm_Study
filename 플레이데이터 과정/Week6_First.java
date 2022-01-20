package playdataTest;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10829

public class Week6_First {
	static String result = "";
	public static void changeNum(long inNum) {
		if(inNum > 0) {
			// 마지막에 추가되는 나머지값이 이진수의 맨 앞에 위치하기 때문에 result에 추가되는 문자열 위치 변경
			result = inNum % 2 + result;
			changeNum(inNum/2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inStr = sc.next();
		// (1 ≤ N ≤ 100,000,000,000,000)로 int의 범위를 초과하기에 long 타입 사용
        long inNum = Long.parseLong(inStr);
		changeNum(inNum);
		System.out.println(result);
		
	}
}

package baekjoon;
//https://www.acmicpc.net/problem/10870

import java.util.Scanner;

public class baekjoon_10870 {
	static int lastNum ;
	static int[] numArr;
	
	public static void calNum(int nowNum) {
		// input이 0 일경우 nowNum == 1 조건보다 함수를 종료시키는 조건을 먼저 검사하도록 배치
		if(nowNum == lastNum+1 ) {
			return;
		}
		else if(nowNum == 0 || nowNum == 1) {
			numArr[nowNum] = nowNum;
			calNum(nowNum+1);
		}
		else {
			numArr[nowNum] = numArr[nowNum-2] + numArr[nowNum-1];
			calNum(nowNum+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		lastNum = sc.nextInt();
		numArr = new int[lastNum+1];
		
		calNum(0);
		System.out.println(numArr[lastNum]);
	}
}


package playdataTest;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2579

public class Week7_First {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stLen = sc.nextInt();
		// 인덱스의 편의를 위해서 해당 어레이길이 stLen+1로 지정
		int[] stArr = new int[stLen+1];
		int[] addArr = new int[stLen+1];
		
		for(int i = 1 ; i < stLen + 1; i++) {
			stArr[i] = sc.nextInt();
		}
		
		// Bottom-up 방식 사용(반복문)
		for(int i = 1; i < stLen + 1; i++) {
			// 숫자가 한 개일 경우에는 첫번째 계단의 값이, 두 개 일경우 1, 2번 계단의 합이 최대값으로 들어감.
			if(i <= 2) {
				addArr[i] = stArr[i] + stArr[i-1];
			}
			
			// 숫자가 3개 이상일 경우부터는 연속된 세 개의 계단을 모두 밟을 수 없기에 연속된 세 개의 계단을 모두 밟는 경우를 제외한 
			// 합 중에서 최대값이 i번째 계단까지 존재할 경우의 최대값으로 들어감.
			else {
				addArr[i] = Math.max(addArr[i-2] + stArr[i], addArr[i-3] + stArr[i-1] + stArr[i]);
			}
		}
		System.out.print(addArr[stLen]);
	}

}

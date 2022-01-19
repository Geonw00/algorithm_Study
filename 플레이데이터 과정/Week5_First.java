package playdataTest;

import java.util.Scanner;

// https://www.acmicpc.net/problem/15829

public class Week5_First {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stLen = sc.nextInt();
		String inStr = sc.next();
        int mulNum = 31;
        // 정수타입 크기  long > int 
		long total = 0;
        long bePow = 1;
        
        // Mod란 나머지 연산으로 
        // ex) 10 mod 3 = 1; ==> 10 % 3 = 1; 과 같다.
		for(int i = 0; i < stLen; i++) {
			// Math.pow(제곱할 수 , 제곱) <== 사용하면 값이 일정수준을 넘어가면 숫자가 ~~~~~~+e 이렇게 되어 연산불가
			// 그러므로 증가하는 31의 제곱값에 mod 1234567891을 해줘서 숫자를 낮춰야함.
			total += (inStr.charAt(i) - 96) * bePow;
			
			// 인덱스에 따라 제곱 수 증가
			bePow *= mulNum;
			
			// 제곱에 따라 Mod 1234567891 해줌(초과하는 값을 방지하기 위해서)
			bePow %= 1234567891;
		}
		// 모든 수를 더한 최종 값에도 Mod 1234567891를 해줘야 함.
		System.out.println(total % 1234567891);

	}

}

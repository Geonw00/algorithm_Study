package playdataTest;

//https://www.acmicpc.net/problem/10162

import java.util.Scanner;

public class Week9_Second {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A = 300;
		int B = 60;
		int C = 10;

		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		
		if(T >= A) {
			aCount = T / A;
			T = T % A;
		}
		
		if(T >= B) {
			bCount = T / B;
			T = T % B;
		}
		
		if(T >= C) {
			cCount = T / C;
			T = T % C;
		}

		if(T == 0) {
			System.out.println(aCount + " " + bCount + " " + cCount);
		}
		else {
			System.out.println(-1);
		}

	}

}

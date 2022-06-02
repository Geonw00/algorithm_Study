package baekjoon;

// https://www.acmicpc.net/problem/2748

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2748 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// int의 최대값 == 2,147,483,647 이고, 출력대상의 수는 int를 초과하는 경우가 있기때문에 long타입 사용
		long n0 = 0;
		long n1 = 1;
		long res = 1;
		
		for(int i = 1; i < N; i++) {
			res = n0 + n1;
			n0 = n1;
			n1 = res;
		}
		
		System.out.println(res);
	}
}

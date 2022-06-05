package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// int의 범위를 초과하기때문에 long타입 사용해야함
		long[] dp = new long[91];
		
		// 이친수의 경우 자릿수가 하나 작은 이친수에 0이
		// 자릿수가 둘 작은 이친수에서 01이 추가되는 패턴을 보이고 있다.
		// 그러므로 N-1, N-2 자릿수의 이친수 수를 더한 값은
		// N 자릿스의 이친수 수를 의미한다. 
		for(int i = 1; i <= N; i++) {
			if(i == 1 || i == 2) {
				dp[i] = 1;
			}
			else {
				dp[i] = dp[i-2] + dp[i-1];
			}
		}
		
		System.out.println(dp[N]);
	}
}

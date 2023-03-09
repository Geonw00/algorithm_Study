package baekjoon;

// https://www.acmicpc.net/problem/11047

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputC = br.readLine().split(" ");
		int N = Integer.parseInt(inputC[0]);
		int K = Integer.parseInt(inputC[1]);
		List<Integer> coinList = new ArrayList<>();
		int coinC = 0;
		
		for(int i = 0; i <= N - 1; i++) {
			coinList.add(Integer.parseInt(br.readLine()));
		}
		
		// 동전의 가치 순으로 내림차순 정렬
		Collections.reverse(coinList);
		
		for(int coin : coinList) {
			if(K == 0) {
				break;
			}
			
			// while을 사용하지 않고
			// coinC += (K / coin);
			// K = K % coin;
			// 위의 두 코드를 사용하는 방법 존재
			while(K >= coin) {
				K -= coin;
				coinC++;
			}
		}
		
		System.out.println(coinC);
	}
}

package baekjoon;

//https://www.acmicpc.net/problem/2839

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon_2839 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 특정 크기를 단정할 수 없기때문에
		// 메모리가 허용하는 한 추가 가능한 List 사용
		List resBasket = new ArrayList();
		int fiveCount = 0;
		int threeCount = 0;
		
		for(int i = 0; i <= (N/5); i++) {
			fiveCount = i;
			threeCount = (N - 5 * i) / 3;

			if(fiveCount * 5 + threeCount * 3 == N) {
				resBasket.add(fiveCount + threeCount);
			}
		}
		
		// 리스트가 비어있을 경우 조건에 부합하는 답이 없음을 의미하기때문에 -1반환
		if(resBasket.isEmpty()) {
			System.out.println(-1);
		}
		else {
			// List내의 가장 작은 값 출력
			System.out.println(Collections.min(resBasket));
		}
	}
}

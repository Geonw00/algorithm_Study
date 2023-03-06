package baekjoon;

// https://www.acmicpc.net/problem/5052

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon_5052 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			
			int n = Integer.parseInt(br.readLine());
			List<String> numList = new ArrayList<String>();
			String res = "YES";
			
			for (int j = 0; j < n; j++) {
				numList.add(br.readLine());
			}
			
			// 오름차순 정렬
			// 숫자를 String으로 오름차순 정렬시 앞부분이 비슷한 수가 앞뒤로 위치
			Collections.sort(numList);

			for (int k = 0; k < numList.size()-1; k++) {
				
				// startsWith를 통하여 접두어 검사
				// k번째보다 k+1번에 더 큰 수가 위치하기 때문에 
				// k+1에 위치한 수에 k에 위치한 수가 접두어로 사용되는지 검사
				if(numList.get(k+1).startsWith(numList.get(k))) {
					res = "NO";
					break;
				}
			}
			
			System.out.println(res);
			
		}
	}
}

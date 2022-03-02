package baekjoon;

//https://www.acmicpc.net/problem/11279

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class baekjoon_11279 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner 사용시 시간초과문제발생
		// bufferedReader 사용으로 시간 단축
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		// reverseOrder로 내림차순 priorityQueue 사용
		PriorityQueue<Integer> prQue = new PriorityQueue<>(Collections.reverseOrder());

		for(int i = 0; i < n; i++) {
			int inNum = Integer.parseInt(bf.readLine());
			
			// 0일 경우 최댓값 출력후 삭제
			if(inNum == 0) {
				prQue.add(inNum);
				System.out.println(prQue.poll());
			}
			else {
				prQue.add(inNum);
			}
		}
	}
}

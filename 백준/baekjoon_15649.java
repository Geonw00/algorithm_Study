package baekjoon;

// https://www.acmicpc.net/problem/15649

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_15649 {
	static int N;
	static int M;
	static boolean[] checkNum;
	static int[] answer;
	
	public static void DFS(int nDeep) {
        // 고른 수가 M개가 된다면 지금까지 고른 숫자 출력
		if(nDeep == M) {
			for(int i = 1; i <= M; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}
	    	 
		for(int i = 1; i <= N; i ++) {
			if(!checkNum[i]) {
				answer[nDeep+1] = i;
				// 중복 여부 체크
				checkNum[i] = true;
				DFS(nDeep+1);
				
				// 중복 체크 초기화
				checkNum[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] readNum = br.readLine().split(" ");
		N = Integer.parseInt(readNum[0]);
		M = Integer.parseInt(readNum[1]);
		
		// 편의를 위해 방문여부 체크와 답 리스트 크기 + 1
		checkNum = new boolean[N+1];
		answer = new int[M+1];
		
		DFS(0);
	}

}

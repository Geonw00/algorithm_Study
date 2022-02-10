package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/12978

import java.util.Arrays;

public class Week8_First {
	public int solution(int N, int[][] road, int K) {
		int[][] a = new int[N][N];
		int result = 0;
		
		// 음식 배달이 가능한 최대시간은 500000이므로 걸리는 시간을 저장할 2차원 배열에 500001의 값을 넣는다.
		for(int i = 0; i < N; i++) {
			Arrays.fill(a[i], 500001);
		}
		
		// 자기 자신에게 가는데 걸리는 시간은 0으로 변
		for(int i = 0; i < N; i++) {
			a[i][i] = 0;
		}
		
		for(int i = 0; i <= road.length-1; i++) {
			// 시간을 저장하는 배열 a의 0번 인덱스는 1번 지점을 의미하므로 road에서 말하는 마을의 원소 -1
			if(a[road[i][0]-1][road[i][1]-1] >= road[i][2]) {
				a[road[i][0]-1][road[i][1]-1] = a[road[i][1]-1][road[i][0]-1] = road[i][2];
			}
		}

		for(int mid = 0; mid < a.length; mid++) {
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < a.length; j++) {
					if(a[i][j] > a[i][mid] + a[mid][j]) {
						a[i][j] = a[i][mid] + a[mid][j];
					}
				}
			}
		}
		
		for(int i = 0; i < a.length; i++) {
			if(a[0][i] <= K ) {
				result++;
			}
		}
		
		return result;
    }
}

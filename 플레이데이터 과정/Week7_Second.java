package playdataTest;

//https://programmers.co.kr/learn/courses/30/lessons/43105

public class Week7_Second {
	public int solution(int[][] triangle) {
		// 현재 위치의 숫자와 위에 위치한 수의 합의 최대값을 담을 2차원어레이 생성 
        int[][] dap = new int[triangle.length][triangle.length];
        
		for(int i =0; i<= triangle.length-1; i++) {
			for(int j =0; j<= triangle[i].length-1; j++) {
				// 맨 꼭대기에는 숫자가 하나 밖에 존재하지 않으므로 최대값도 자신의 값이다.
				if(i == 0) {
					dap[i][j] = triangle[i][j];
				}
				// 0번 열의 경우 해당위치 위에 왼쪽 값이 존재하지 않으므로 아래와 같다.
				else if(j == 0) {
					dap[i][j] = dap[i-1][j] + triangle[i][j];
				}
				// 마지막 열의 경우 해당위치 위에 오른쪽 값이 존재하지 않으므로 아래와 같다.
				else if(j == triangle[i].length-1) {
					dap[i][j] = dap[i-1][j-1] + triangle[i][j];
				}
				// 현재위치의 수와 상단 왼, 오른쪽의 위치한 수의 합을 각각 구한 후 최댓값을 구해 최대값 어레이에 넣는다.
				else {
					dap[i][j] = Math.max(dap[i-1][j-1] + triangle[i][j], dap[i-1][j] + triangle[i][j]);
				}
			}
			
		}
		int result = 0;
		// 바닥까지의 합 중 최댓값을 구한다.
		for(int i =0; i<= triangle.length-1; i++) {
			if(result < dap[triangle.length-1][i]) {
				result = dap[triangle.length-1][i];
			}
		}
        
        return result;
    }
}

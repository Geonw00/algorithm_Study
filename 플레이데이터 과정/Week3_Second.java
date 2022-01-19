package playdataTest;

import java.util.Scanner;
import java.util.Stack;

//문제
//신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
//
//예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
//
//
//
//어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
//
//출력
//1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
//
//예제 입력 1 
//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7

public class Week3_Second {
	static int cNum;
	static int lineCount;
	static int[][] dfsG;
	static boolean[] check;
	static Stack<Integer> ckCount = new Stack<Integer>(); 
	
	public static int dfsNum(int nowNum) {
		check[nowNum] = true;
		// 1을 제외하고 중복되지않게 바이러스가 방문한 컴퓨터를 스택에 넣음
		if(nowNum != 1 && !ckCount.contains(nowNum)) {
			ckCount.add(nowNum);
		}
		for(int i = 0; i <= cNum; i++) {
			if(dfsG[nowNum][i] == 1 && check[i] == false) {
				dfsNum(i);
			}
		}
		// 더 이상 감염이 퍼질 컴퓨터가 없는 경우 1로 인하여 감염된 컴퓨터의 수 리턴
		return ckCount.size();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cNum = sc.nextInt();
		lineCount = sc.nextInt();
		dfsG = new int[cNum+1][cNum+1];
		check = new boolean[cNum+1];
		
		// 서로 연결된 컴퓨터 x, y의 값은 양방향으로 값을 1로 표현
		for(int i = 0; i <= lineCount-1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			dfsG[x][y] = dfsG[y][x] = 1; 
		}
		
		System.out.print(dfsNum(1));
	}

}

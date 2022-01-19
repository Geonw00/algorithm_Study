package playdataTest;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//문제
//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
//입력
//첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
//
//출력
//첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
//
//예제 입력 1 
//4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4
//예제 출력 1 
//1 2 4 3
//1 2 3 4
//예제 입력 2 
//5 5 3
//5 4
//5 2
//1 2
//3 4
//3 1
//예제 출력 2 
//3 1 2 5 4
//3 1 4 2 5
//예제 입력 3 
//1000 1 1000
//999 1000
//예제 출력 3 
//1000 999
//1000 999

public class Week3_First {
	static int cNum;
	static int lineCount;
	static int startNum;
	static int[][] dbfsG;
	static boolean[] check;
	
	public static void dfsTest(int startNum) {
		check[startNum] = true;
		System.out.print(startNum + " ");
		for(int i = 1; i <= cNum; i++) {
			// 현재 위치한 정점의 값과 연결된 정점들 중 다녀오지 않은 값으로 이동.
			// for문이 1부터 시작하기 때문에 가장 낮은 수부터 찾아감.
			if(dbfsG[startNum][i] == 1 && check[i] == false) {
				dfsTest(i);
			}
		}
	}
	
	public static void bfsTest(int startNum) {
		Queue<Integer> bfsG = new LinkedList<>();
		// dfsTest를 먼저 사용하기 때문에 check를 초기화 시켜줌
		check = new boolean[cNum+1];
		
		// 시작 번호를 큐타입의 bfsG에 담고 해당 번호의 check를 다녀왔다고 표시
		bfsG.add(startNum);
		check[startNum] = true;
		System.out.println();
		
		// 큐에 아무런 값이 존재한다면 해당 while문 종료
		while(!bfsG.isEmpty()) {
			// 큐에 가장 앞에 있는 값이 도착한 정점의 값이므로 해당 위치 check true
			check[bfsG.peek()] = true;
			System.out.print(bfsG.peek() + " ");
			
			for(int i = 1; i <= cNum; i++) {
				// 해당 정점과 연결되어 있고, 다녀온 적이 없으며 큐에 포함되지 않은 정점의 번호를 큐에 추가해줌
				if(dbfsG[bfsG.peek()][i] == 1 && check[i] == false && !bfsG.contains(i)) {
					bfsG.add(i);
				}
			}
			// 해당 정점의 값을 통한 탐색이 끝났으므로 해당 정점의 값을 버림.
			bfsG.poll();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 정점의 수 
		cNum = sc.nextInt();
		
		// 간선의 수
		lineCount = sc.nextInt();
		
		// 시작 숫자
		startNum = sc.nextInt();
		
		// 배열의 인덱스는 0부터이기 때문에 편의를 위해서 정점의 수 +1로 크기를 지정하여 만듬
		// check는 해당 정점에 도달한 적이 있는지 불린 값으로 표현
		dbfsG = new int[cNum+1][cNum+1];
		check = new boolean[cNum+1];
		
		// 2차원 배열을 통하여 x와 y 간의 연결이 있다면 그 값을 1로 변경
		// 연결은 양방향이기때문에 [x][y]와 [y][x] 둘 다 변경, 연결이 없다면 값이 0임
		for(int i = 0; i <= lineCount-1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			dbfsG[x][y] = dbfsG[y][x] = 1;
		}
		// 깊이우선탐색 함수
		dfsTest(startNum);
		// 너비우선탐색 함수
		bfsTest(startNum);
		
	}

}

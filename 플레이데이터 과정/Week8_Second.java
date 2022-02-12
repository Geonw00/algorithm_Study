package playdataTest;

// https://www.acmicpc.net/problem/18352

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Week8_Second {
	static int N;
	static int M;
	static int K;
	static int X;
	static ArrayList<Integer>[] road;
	static int[] dap ;
	
	public static void BFSD(int startC) {
		// 최단거리를 비교하기때문에 방문기록은 따로 필요 x
		Queue<Integer> node = new LinkedList<>();
		
		node.add(startC);
		
		while(!node.isEmpty()) {
			int nowNode = node.poll();
			for(int i = 0; i < road[nowNode].size(); i++) {
				// 출발도시기준 nowNode까지의 거리가 0일 경우 첫 방문이자 최단경로  
				if(dap[road[nowNode].get(i)] == 0) {
					dap[road[nowNode].get(i)] = dap[nowNode] + 1;
					node.add(road[nowNode].get(i));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();
		dap = new int[N + 1];
		
		road = new ArrayList[N + 1];
		
		for(int i = 0; i < road.length; i++) {
			road[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int arrival = sc.nextInt();
			road[start].add(arrival);
		}
		
		sc.close();
		
		// BFS 
		BFSD(X);
		
		List ckDap = new ArrayList();
		
		for(int i = 0; i < dap.length; i++) {
			// 시작 도시가 답에 포함되는 경우 방지 
			if(i != X && dap[i] == K) {
				ckDap.add(i);
			}
		} 
		
		// 답이 없을 경우 -1 반환 
		if(ckDap.isEmpty()) {
			System.out.println("-1");
		}
		else {
			for(Object i : ckDap ) {
				System.out.println(i);
			}
		}
	}

}

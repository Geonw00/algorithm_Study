package baekjoon;

// https://www.acmicpc.net/problem/15591

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class baekjoon_15591 {
	public static List<int[]>[] usadoGraph;
	public static boolean[] visitCk;
	public static int k;
	
	// 현재 시청중인 비디오를 기준으로 유사도 측정	
	public static int bfs(int startNum) {
		visitCk[startNum] = true;
		int res = 0;
		Queue<Integer> usadoQue = new LinkedList<>();
		usadoQue.add(startNum);
		
		while(!usadoQue.isEmpty()) {
			
			int nowV = usadoQue.poll();
			
			for(int[] i: usadoGraph[nowV]) {
				// 시작 비디오를 기준 유사도 측정값이 기준 k값보다 유사도가 높을 경우 추천
				if(!visitCk[i[0]] && k <= i[1]) {
					res++;
					usadoQue.add(i[0]);
					visitCk[i[0]] = true;
				}
			}	
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] readInput = br.readLine().split(" ");
		int N = Integer.parseInt(readInput[0]);
		int Q = Integer.parseInt(readInput[1]);
		
		// int[]로 이루어진 N+1개의 리스트 생성
		usadoGraph = new ArrayList[N+1];
		List<Integer> resList = new ArrayList();
		
		// 각 idx내부에 int[]로 구성될 리스트 생성 
		for(int i = 0; i < N+1; i++) {
			usadoGraph[i] = new ArrayList();
		}
		
		for(int i = 0; i < N-1; i++) {
			String[] readInput2 = br.readLine().split(" ");
			int p = Integer.parseInt(readInput2[0]);
			int q = Integer.parseInt(readInput2[1]);
			int r = Integer.parseInt(readInput2[2]);
			
			usadoGraph[p].add(new int[] {q, r});
			usadoGraph[q].add(new int[] {p, r});
		}
		
		for(int i = 0; i < Q; i++) {
			String[] readInput3 = br.readLine().split(" ");
			k = Integer.parseInt(readInput3[0]);
			int v = Integer.parseInt(readInput3[1]);
			
			visitCk = new boolean[N+1];
			
			resList.add(bfs(v));
		}
		
		for(int res : resList) {
			System.out.println(res);
		}	
	}
}

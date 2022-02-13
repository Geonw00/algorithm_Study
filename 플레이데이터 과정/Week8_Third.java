package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/49189

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Week8_Third {
	public int solution(int n, int[][] edge) {
		ArrayList<Integer>[] road = new ArrayList[n + 1];
		int[] dap = new int[n + 1];
		int answer = 0;
		int topNode = 0;
		Queue<Integer> node = new LinkedList<Integer>();
		
		for(int i = 0; i < road.length; i++) {
			road[i] = new ArrayList<Integer>();
		}
		
		// 간선은 양방향
		for(int i = 0; i < edge.length; i++) {
			road[edge[i][0]].add(edge[i][1]);
			road[edge[i][1]].add(edge[i][0]);
		}
		
		// BFS
		node.add(1);
		
		while(!node.isEmpty()) {
			int nowNode = node.poll();
			for(int i = 0; i < road[nowNode].size(); i++) {
				if(dap[road[nowNode].get(i)] == 0) {
					dap[road[nowNode].get(i)] = dap[nowNode] + 1;
					node.add(road[nowNode].get(i));
				}
			}
		}
		
		// 가장 멀리 떨어진 노드의 거리
		for(int i = 1; i < road.length; i++) {
			topNode = Integer.max(topNode, dap[i]);
		}
		
		// 거리 정보 중 시작 노드의 거리 정보 제외
		for(int i = 2; i < road.length; i++) {
			if(dap[i] == topNode) {
				answer++;
			}
		}
        return answer;
    }
}

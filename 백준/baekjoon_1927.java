package baekjoon;

//https://www.acmicpc.net/problem/1927

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baekjoon_1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> prQue = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int inNum = Integer.parseInt(br.readLine());
			if(inNum == 0 && prQue.isEmpty()) {
				System.out.println("0");
			}
			else if(inNum == 0) {
				System.out.println(prQue.poll());				
			}
			else {
				prQue.add(inNum);
			}
		}
	}
}

package baekjoon;

//https://www.acmicpc.net/problem/1655

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class baekjoon_1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		// 최대 힙과 최소 힙 생성
		PriorityQueue<Integer> prMinQue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> prMaxQue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			// Max부터 교차로 값 추가
			if(i % 2 == 0) {
				prMaxQue.add(Integer.parseInt(br.readLine()));
			}
			else {
				prMinQue.add(Integer.parseInt(br.readLine()));
			}
			
			// Max의 최댓값이 가운데의 값인데
			// 만약 Min의 값이 Max의 값보다 작다면 두 값을 교체해준다.
			if(!prMinQue.isEmpty() && prMaxQue.peek() > prMinQue.peek()) {
				int ckNum = prMaxQue.poll();
				prMaxQue.add(prMinQue.poll());
				prMinQue.add(ckNum);
			}
			// 버퍼에 값 저장하여 한번에 출력하는 형식으로 시간 줄임
			bw.write(prMaxQue.peek());
		}
		bw.flush();
		bw.close();
	}
}

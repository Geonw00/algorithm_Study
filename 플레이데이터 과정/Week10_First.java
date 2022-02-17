package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/42587

import java.util.Arrays; 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Week10_First {
	public int solution(int[] priorities, int location) {
        Queue<Integer> prQue = new LinkedList<Integer>();
		Stack<Integer> maxQue = new Stack<Integer>();
		int answer = 0;
		
		// 인쇄대기목록을 순서대로 queue에 넣음
		for(int i : priorities) {
			prQue.add(i);
		}
		
		// 인쇄대기목록을 정렬하여 Stack에 넣음
		Arrays.sort(priorities);
		for(int i : priorities) {
			maxQue.push(i);
		}
		
		while(!prQue.isEmpty()) {
			// 중요도 순으로 내림차순 정렬된 Stack의 경우 가장 위에 쌓인 수가 중요도가 제일 높음을 의미
			int max = maxQue.peek();
			// 이번 순서의 인쇄대기물의 중요도가 max 중요도와 같다면 해당 인쇄물을 뽑음
			if(prQue.peek() == max) {
				prQue.poll();
				maxQue.pop();
				answer++;
				// 만약 내가 요청한 문성의 위치가 0이라면 뽑힌 것을 의미
				if(location == 0) {
					break;
				}
				// 0이 아닐 경우 앞의 인쇄물이 하나 뽑힌 것이므로 위치 앞으로 한 칸 이동
				else {
					location--;
				}
			}
			else {
				// 중요도가 max보다 낮다면 해당 인쇄물을 맨 뒤로 보냄
				prQue.add(prQue.poll());
				// 위치가 0이였다면 내가 요청한 인쇄물을 의미하며 대기열의 맨 뒤로 이동
				if(location == 0) {
					location = prQue.size()-1;
				}
				// 0이 아닐 경우 앞의 인쇄물이 하나 뽑힌 것이므로 위치 앞으로 한 칸 이동
				else {
					location--;
				}
			}
		}
        return answer;
    }
}

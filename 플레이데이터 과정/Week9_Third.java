package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/42885

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Week9_Third {
	public int solution(int[] people, int limit) {	
		// people[] 을 정렬
		Arrays.sort(people);
        int answer = 0;
        
        // deque의 경우 stack과 queue가 합쳐진 것으로 보면된다.
        // add, poll, peek 과 같은 기능이 First, Last를 통해서 어느 지점에서 실행할 지 정할 수 있다.
        Deque<Integer> de = new ArrayDeque<Integer>();
        
        // de에 오름차순으로 정렬된 people의 값을 차례로 add
        for(int i : people) {
        	// addLast와 같음
        	de.add(i);
        }
        
        // 무인도에 갇힌 사람이 없을 때까지 반복
        while(!de.isEmpty()) {
        	// 몸무게가 최대값 사람과 최솟값 사람의 합이 limit보다 작거나 같을 경우 한 구명보트 사용가능
        	if(de.peekLast() + de.peekFirst() <= limit) {
        		de.pollLast();
        		de.pollFirst();
        		answer++;
        	}
        	// 클 경우 최댓값 사람만 탈출
        	else {
        		de.pollLast();
        		answer++;
        	}
        }
        
        return answer;
    }
}

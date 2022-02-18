package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/42626?language=java

import java.util.PriorityQueue;

public class Week10_Second {
	public int solution(int[] scoville, int K) {
       		int answer = 0;
        
       		// priorityQueue 는 우선순위 큐로써 기본형은 낮은 숫자부터 우선순위가 부여된다.
        	// 높은 숫자부터 우선순위를 부여하기 위해서는 new PriorityQueue<>(Collections.reverseOrder())가 필요하다.
        	// 큐에 들어간 수들은 정렬되어 있지 않지만 poll, peek 같은 경우 우선순위가 높은 숫자들을 대상으로 처리가 이루어진다.
		PriorityQueue<Integer> scDqu = new PriorityQueue<Integer>();
		
		for(int i : scoville) {
			scDqu.add(i);
		}
		
		while(true) {
			// 스코피지수가 가장 낮은 수가 Leo가 원하는 스코빌 숫자 K보다 크면 나머지 음식들은 모두 K보다 스코빌 지수가
			// 높음을 의미한다.
			if(scDqu.peek() >= K) {
				break;
			}
			// 음식의 스코빌 지수를 담은 큐의 크기가 1이며 K보다 작아 앞서 실행된 조건문에 걸리지 않을 경우
			// 모든 음식을 섞어도 스코빌 지수 K를 만족하지 못하므로 return -1
			else if(scDqu.size() == 1) {
				answer = -1;
                		break;
			}
			// 스코빌 지수가 가장 낮은 음식이 K를 만족하지 못할 경우, 음식을 섞음.
			else if(scDqu.peek() < K) {
				int calNum = scDqu.poll() + ( scDqu.poll() * 2 );
				scDqu.add(calNum);
				answer ++;
			}	
		}
        	return answer;
	}
}

package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/42628

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week10_Third {
	public int[] solution(String[] operations) {
        int[] answer = {};
        List<Integer> sortOp = new ArrayList<Integer>();
        
        for(String i : operations) {
        	// operations[]의 값은 "I 16" 등의 형식으로 이루어져 있음
        	// 명령어가 들어가는 문자열과 숫자가 들어가는 문자열 분리
	    	String[] spOP = i.split(" ");
	    	
	    	// 삽입 명령일 경우 해당 숫자 List에 삽입 후 정렬
	    	if(spOP[0].equals("I")) {
	    		sortOp.add(Integer.parseInt(spOP[1]));
	    		Collections.sort(sortOp);
	    	}
	    	
	    	// 삽입 명령이 아닐경우 삭제 명령
	    	else {
	    		// 만약 삭제할 숫자가 없을 경우 해당 명령 스킵
	    		if(sortOp.size() == 0) {
	    	        continue;
	    		}
	    		
	    		// 정렬된 sortOp의 마지막 인덱스는 최댓값을 의미
	    		if(spOP[1].equals("1")) {
            		sortOp.remove(sortOp.size()-1);
                	}
	    		
	    		// 정렬된 sortOp의 첫 인덱스는 최솟값을 의미
            		else if(spOP[1].equals("-1")) {
            		sortOp.remove(0);
                	}
	    	}
	    }
        
        // sortOp가 비었을 경우 [0,0]반환
        if(sortOp.size() == 0) {
        	answer = new int[] {0, 0};
        }
        // 아닐경우, [최댓값,최솟값]반환
        else {
        	answer = new int[] {sortOp.get(sortOp.size()-1), sortOp.get(0)};
        }
         
        return answer;
    }
}

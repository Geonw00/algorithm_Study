package playdataTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// https://programmers.co.kr/learn/courses/30/lessons/42576
// 최초에 문제를 풀 때, 지문을 잘못읽고 2명 이상의 사람이 존재할 수 도 있다는 가정하여 힘들어짐.

public class Week5_Second {
	Map<String, Integer> paMap = new HashMap<>();
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";

        // HashMap을 사용하여 해당 키값이 존재하지 않을 경우 초기값 = 0 + 1
        // 해당 키 값이 존재할 경우 해당 키의 밸류값을 가져와서 + 1
        for(int i = 0; i <= participant.length-1; i++) {
        	paMap.put(participant[i], paMap.getOrDefault(participant[i], 0) + 1);
        }
        
        // 해당 키의 밸류 값은 같은 이름의 사람이 몇 명 참가했는지를 알려주기 때문에 
        // 해당 이름의 참가자가 몇 명 있는지 count에 넣고
        // 해당 이름의 참가자가 도착하였을 때, 그 이름의 참가자가 1명이라면 해당 entry를 삭제하고
        // 2명 이라면 1명이 도착한 것이기때문에 같은 이름의 참가자 명수 -1를 해준다.
        for(int i = 0; i <= completion.length-1; i++) {
        	int count = paMap.get(completion[i]);
        	
        	if(paMap.get(completion[i]) == 1) {
        		paMap.remove(completion[i]);
        	}
        	else if(paMap.get(completion[i]) > 1){
        		paMap.put(completion[i], --count);
        	}
        	
        }
        
        // 참가자 명단 중 도착하지 않은 사람의 이름만들 answer에 넣어줌.
        // 동명이인이 아니거나 둘 다 도착한 참가자 명단은 remove를 통해 map에서 삭제되어 있기 때문에.
        // Entry를 통해 map을 순회.
        for(Entry<String, Integer> entry: paMap.entrySet()) {
        	answer += entry.getKey();
        }
        
        return answer;
    }
}



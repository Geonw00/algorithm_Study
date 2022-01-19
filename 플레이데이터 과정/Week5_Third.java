package playdataTest;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/42577

public class Week5_Third {
	 public boolean solution(String[] phone_book) {
	        boolean answer = true;
			Map<String, Integer> phMap = new HashMap<>();
			
			// HashMap에 phone_book의 값을 하나씩 키로 넣어준다.
			for(String i : phone_book) {
				phMap.put(i, 0);
			}
			
			// phone_book[i]의 값이  phone_book의 값들 중 접두사를 가지는 지 확인
			for(int i = 0; i <= phone_book.length-1; i++) {
				
				// phone_book[i]의 값을 자신의 크기만큼 잘라서 키에 해당 값이 있는지 반복
				// 즉, phone_book[i] = "12356"이라면
				// phMap의 키 들 중 "12356"의 접두사인 "1", "12", "123", "1235"가 있는지 확인
				for(int j = 1; j <= phone_book[i].length()-1; j++) {
					
					// 접두사가 존재한다면 answer = false;
					if(phMap.containsKey(phone_book[i].substring(0, j))){
						answer = false;
					}
					
				}
			}
	        
	        return answer;
	    }

// 시간초과 코드 ( 답은 다 맞음)
//	public boolean solution(String[] phone_book) {
//        boolean answer = true;
//        for(int i =0; i <= phone_book.length-1; i++) {
//			
//			for(int j =0; j <= phone_book.length-1; j++) {
//				
//				if(i != j && phone_book[i].length() <= phone_book[j].length() ) {
//					
//					if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
//						answer = false;
//					}
//				}
//			}
//		}
//        
//        return answer;
//    }
}

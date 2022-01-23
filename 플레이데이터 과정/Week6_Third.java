package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/60058

public class Week6_Third {
	static String answer;
	
	// 매개변수 문자열이 균형잡힌 괄호 문자열인지 올바른 괄호 문자열인지 판단.
	public static boolean checkS(String u) {
		String ckStr = u;
		StringBuilder ckBuil = new StringBuilder(ckStr);
		int ckIn = 0;
		while(true) {
			if(ckStr.isEmpty() || ckIn == ckStr.length()-1) {
				break;
			}
			if(ckStr.charAt(ckIn) == '(' && ckStr.charAt(ckIn+1) == ')') {
				ckBuil.deleteCharAt(ckIn);
				ckBuil.deleteCharAt(ckIn);
				ckStr = ckBuil.toString();
				ckIn = 0;
			}
			else {
				ckIn ++;
			}
		}
		// 올바른 괄호 문자열일 경우 ckStr의 모든 문자열은 삭제되므로 true반환
		if(ckStr.isEmpty()) {
			return true;
		}
		else { return false;}
	}
	
	// u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙이는 함수
	public static String changeStr(String u) {
		String chStr = u;
		StringBuilder chBuil = new StringBuilder(chStr);
        chBuil.deleteCharAt(chStr.length()-1);
		chBuil.deleteCharAt(0);
        
		// 첫 번째 문자와 마지막 문자가 제거되었기 때문에
		// chBuil의 인덱스는 chStr에서 첫번째, 마지막 문자가 제거된 인덱스 임을 인지.
		for(int i =1; i< chStr.length()-1; i++) {
			if(chStr.charAt(i) == '(') {
				chBuil.setCharAt(i-1, ')');
			}
			else if(chStr.charAt(i) == ')') {
				chBuil.setCharAt(i-1, '(');
			}
		}
		chStr = chBuil.toString();
		
		return chStr;
	}
	
	// 주어진 문자열을 올바른 괄호 문자열로 반환하는 함수
	public static String chParen(String test) {
		String u ="";
        String v ="";
        int leftParen= 0;
        int rightParen= 0;
        // 반환할 값을 담을 변수
        String notStr = "";
        
        // 입력 값이 빈 문자열일 경우, 빈 문자열 반환
        if(test.isEmpty()) {
        	return "";
        }
        
        // 처음 값은 left와 right가 0으로 같은 값이기에 0번 인덱스가 (, ) 인지 먼저 분류하고 반복문 시작
		if (test.charAt(0) == '(') {
			leftParen ++;
		}
		else if (test.charAt(0) == ')') {
			rightParen ++;
		}
		
		for(int i = 1; i<= test.length(); i++) {
			// 문자열 test를 두 "균형잡힌 괄호 문자열" u, v로 분리
			// 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있음
			if(leftParen == rightParen) {
				u = test.substring(0, i);
				v = test.substring(i);
				break;
			}
			else if (test.charAt(i) == '(') {
				leftParen ++;
			}
			else if (test.charAt(i) == ')') {
				rightParen ++;
			}
		}
		
		// u가 올바른 문자열 일 경우 
		// 수행한 결과 문자열을 u에 이어 붙인 후 반환
		if(checkS(u)) {
            notStr = u + chParen(v);
		}
		
		// 아닐 경우, 빈 문자열에 첫 번째 문자로 '('를 붙임 
		// 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙임 
		// ')'를 다시 붙임
		// u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임 
		else {
			notStr = "(";
			notStr += chParen(v);
			notStr += ")";
			notStr += changeStr(u);
		}
		// 생성된 문자열을 반환
		return notStr;
	}
    public String solution(String p) {  
        answer = chParen(p);
        return answer;
    }
	
}

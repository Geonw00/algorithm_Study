package playdataTest;

import java.util.HashSet;
//문제 설명
//한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//numbers는 길이 1 이상 7 이하인 문자열입니다.
//numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
//입출력 예
//numbers	return
//"17"		3
//"011"		2
//입출력 예 설명
//예제 #1
//[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
//
//예제 #2
//[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
//
//11과 011은 같은 숫자로 취급합니다.
public class Week2_Second {
	 
	public static boolean[] check;
	public static HashSet<Integer> setNum;
	public static int[] arrNum;
    public static int answer;
	
    // 주어진 종잇조각으로 만들 수 있는 모든 수를 구함.
    // boolean type의 check를 통하여 요소의 중복 방지
    // setNum이라는 set에 담음으로써 같은 숫자 중복 방지
    public static void cal(String str, int n, char[] arrInt, int Count){
	    if(Count == n) {
	    	for(int i=0; i<n; i++){
	    		setNum.add(Integer.parseInt(str)); 
	    	}
	    }
	   	for(int i=0; i<n; i++){
	   		if(!check[i] && str == "") {
	   			check[i] = true;
    			cal(str+arrInt[i], n, arrInt, Count+1);
    			check[i] = false;
	    	}
	   		else if(!check[i]) {
	   			check[i] = true;
	   			setNum.add(Integer.parseInt(str)); 
    			cal(str+arrInt[i], n, arrInt, Count+1);
    			check[i] = false;
	    	}
	    }
	}
	
    // 종잇조각으로 만들 수 있는 모든 수들에 대하여 소수 판별
    public static int decNum(int[] arrNum) {
		answer = 0;
		for(int i = 0; i <= arrNum.length-1; i++) {
			// 0과 1의 경우 소수가 아니기 때문에 제외
			if(arrNum[i] < 2) {
				continue;
			}
			// 1은 소수가 아니기 때문에 2부터 해당 숫자의 크기까지 판별 반복
			// 중간에 나눗셈 후 나머지가 0이 나올 경우 해당 반복문 중지
			// 중지되지 않고 j와 해당 숫자가 동일할 경우 소수라는 뜻이기 때문에 answer에 + 1 
			for(int j = 2; j <= arrNum[i]; j++) {
				if(j == arrNum[i]) {
					answer += 1;
				}
				else if(arrNum[i] % j == 0) {
					break;
				}
			}
		}
		return answer;
	}
	    
    public int solution(String numbers) {
        String str = "";
		String arr = numbers;
		int Count = 0;
		int n = arr.length();
		setNum = new HashSet<Integer>();
		
		// 주어진 종잇조각의 수만큼 char타입의 배열을 생성
		// 배열에 해당 종잇조각에 적힌 수를 하나씩 넣음
		char[] arrInt = new char[arr.length()];
		for(int i = 0; i <= arr.length()-1; i++) {
			arrInt[i] = arr.charAt(i);
		}	
		// 요소 중복 방지를 위한 check의 크기도 주어진 종잇조각의 수만큼으로 만듬
		check = new boolean[arr.length()];

		cal(str, n, arrInt, Count);
		arrNum = new int[setNum.size()];
		int in = 0;
		// set의 경우 순서가 없기 때문에 인덱스 지정하여 소수판별하기 힘듬
		// 그렇기 때문에 int 타입의 배열을 생성하여 향상된 for문을 통하여 옮김
		for(int i : setNum) {
			arrNum[in] = i;
			in++;
		}
		decNum(arrNum);
        
        return answer;
    }	
}

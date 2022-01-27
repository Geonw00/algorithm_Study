package playdataTest;

import java.util.HashSet;
import java.util.Set;
// https://programmers.co.kr/learn/courses/30/lessons/42895

public class Week7_Third {
	public static Set<Integer>[] setResult = new Set[9];
	public static int N;
	public static int number;
	public static String sumNumst = "";
    
    public static void calExp() {
		for(int i = 1; i < 9; i++) {
			// N이 사칙연산 뿐만 아니라 NN으로도 사용 가능
			sumNumst += N;	
			if(i == 1) {
				setResult[i].add(N);
			}
			else {
				setResult[i].add(Integer.parseInt(sumNumst)); 
				for(int j = 1; j <= i-1; j++) {
					// 예를 들어 N = 1, number = 22 로 주어질 때 
					// 11 + 11 = 22로 return이 4가 되는 경우의 수가 존재하기 때문에 
					// j개만 사용했을 때의 값들과 i-j개만 사용했을 때의 값을 통해서 i개를 사용했을 때의 값에 넣어줌
					for(int beNum : setResult[i-j]) {
						for(int anoNum : setResult[j]) {   
							setResult[i].add(beNum + anoNum); 
							setResult[i].add(beNum - anoNum); 
							setResult[i].add(beNum * anoNum); 
							// ArithmeticException을 방지하기위함 ( x / 0 같은 경우 발생) <- 0으로 나눌경우
							if(anoNum != 0) {  					
								setResult[i].add(beNum / anoNum);
							}
							setResult[i].add(anoNum - beNum);
							// ArithmeticException을 방지하기위함 ( x / 0 같은 경우 발생) <- 0으로 나눌경우
							if(beNum != 0) {
								setResult[i].add(anoNum / beNum);
							}
						}
					}
				}
			}
		}
	}
    
    // N의 사용횟수 별 값을 모두 저장한 setResult[]에서 
    // 1부터 순차적으로 반복문을 통해 해당 값이 존재할 경우 최솟값 return
    public static int reAns() {
		for(int i = 1; i < 9; i++) {
			for(int testNum : setResult[i]) {
				if(testNum == number) {
					return i;
				}
			}
		}
		return -1;
	}
    
    public int solution(int N, int number) {
        int answer = 0;
        this.N = N;
        this.number = number;
        // set[]의 NullPointerException을 방지하기 위해서 각 []마다 해시셋으로 값을 넣어준다.
        for(int i = 1; i < 9; i++) {
			setResult[i] = new HashSet<>();
		}
        calExp();
        answer = reAns();
        return answer;
    }
}

package playdataTest;

//문제 설명
//n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
//각 숫자는 1 이상 50 이하인 자연수입니다.
//타겟 넘버는 1 이상 1000 이하인 자연수입니다.
//입출력 예
//numbers			target	return
//[1, 1, 1, 1, 1]	3		5

public class Week3_Third {
	 static int answer;
		static int[] numbers;
		static int target;
		static int sum;
		
		public static void dfsNum(int nowNum) {
			
			// numbers의 모든 인덱스를 다 계산하였으면 함수를 종료시킴
			if(nowNum == numbers.length) {
				if(sum == target) {
					answer += 1;
				}
				return;
			}
			
			for(int i = 0; i <= 1; i++ ) {		
				// i가 0일 경우 해당 인덱스를 가진 numbers의 값을 더하고, 1일 경우 뺌.
				if(i == 0) {
					sum += numbers[nowNum];
				}
				else {
					sum -= numbers[nowNum];
				}
				
				// 재귀함수를 통하여 해당 nowNum에 해당하는 인덱스를 가진 numbers의 값을 각각 더하고 뺌
				dfsNum(nowNum+1);
				
				// 해당 계산으로 달라진 sum의 값을 해당 nowNum 번째의 재귀함수에 들어올 때의 sum의 값으로 초기화 시켜주어야함.
				if(i == 0) {
					sum -= numbers[nowNum];
				}
				else {
					sum += numbers[nowNum];
				}
			}
		}
			
		public int solution(int[] numbers, int target) {
	        answer = 0;
	        // 매개변수를 해당 클래스의 필드에 값을 넣어줌.
	        this.numbers = numbers;
	        this.target = target;
	        dfsNum(0);
	        
	        return answer;
	    }

}

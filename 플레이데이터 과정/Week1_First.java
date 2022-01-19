package playdataTest;

public class Week1_First {
//	문제 설명
//	초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
//
//	제한사항
//	prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
//	prices의 길이는 2 이상 100,000 이하입니다.
	
//	입출력 예
//	prices	        return
//	[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
//	입출력 예 설명
//	1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
//	2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
//	3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
//	4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
//	5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다. 
	
	public int[] solution(int[] prices) {
		// 주어지는 가격의 수와 동일한 길이를 가진 리스트 생성
        int[] answer = new int[prices.length];
        
        for(int i = 0; i <= prices.length-1; i++){
            int sec = 0;
            // 기준 지점의 값과 시간의 흐름에 따른 값 비교
            for(int j = i + 1; j <= prices.length-1; j++){
            	// 마지막 인덱스의 값 경우에는 비교할 다음 인덱스가 없으므로 가격이 떨어지지 않은 초를 0으로 고정
                if(i == prices.length-1){
                    sec = 0;
                }
                // 현재 인덱스의 값이 다음 인덱스보다 작거나 같을 경우 가격이 떨어지지 않음을 의미한다.
                // 그러므로 가격이 떨어지지 않은 초에 1초 추가
                else if(prices[i] <= prices[j]){
                    sec += 1;
                }
                // 다음 초의 값이 현재 초의 값보다 작을 경우 1초뒤에 가격이 떨어짐을 의미한다.
                // 그러므로 현재 초에서 다음 초까지 가는 1초를 가격이 떨어지지 않은 초에 추가하며 for문을 끝낸다.
                else if(prices[i] > prices[j]){
                    sec += 1;
                    break;
                }
            }
            answer[i] = sec;    
        }
           
        return answer;
    }
}



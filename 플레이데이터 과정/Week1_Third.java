package playdataTest;

import java.util.LinkedList;
import java.util.Queue;
//문제 설명
//트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
//
//예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
//
//경과 시간	다리를 지난 트럭		다리를 건너는 트럭	대기 트럭
//0			[]				[]				[7,4,5,6]
//1~2		[]				[7]				[4,5,6]
//3			[7]				[4]				[5,6]
//4			[7]				[4,5]			[6]
//5			[7,4]			[5]				[6]
//6~7		[7,4,5]			[6]				[]
//8			[7,4,5,6]		[]				[]
//따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
//
//solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
//
//제한 조건
//bridge_length는 1 이상 10,000 이하입니다.
//weight는 1 이상 10,000 이하입니다.
//truck_weights의 길이는 1 이상 10,000 이하입니다.
//모든 트럭의 무게는 1 이상 weight 이하입니다.
//입출력 예
//bridge_length		weight		truck_weights					return
//2					10			[7,4,5,6]						8
//100				100			[10]							101
//100				100			[10,10,10,10,10,10,10,10,10,10]	110
public class Week1_Third {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> bridge_ing = new LinkedList<>();
		Queue<Integer> truck = new LinkedList<>();
		
		// 트럭 한 대가 들어가는 순간 다리 길이의 한 칸을 차지하기 때문에 
		// 다리의 길이 -1 만큼 bridge_ing에 0을 넣는다. 0은 무게를 의미.
		for(int i = 0; i <= bridge_length-2 ; i++ ) {
			bridge_ing.add(0);
		}
		
		// 큐를 사용하기 위해서 int[]타입으로 받아온 변수를 truck에 순차적으로 담는다.
	    for(int i : truck_weights) {
	        truck.add(i);
	    }
	    // 무게의 합
		int sum = 0;
		// 걸린 초
	    int answer = 0;
	    
	    
	    while(true){
	    	// 더 이상 다리 위에 새롭게 지나갈 차량이 없는 경우
	    	// 마지막 차량이 다 건너는 시간을 더한 뒤 해당 반복문을 멈춘다.
	    	// 건너는 시간은 다리의 길이와 동일.
	        if(truck.isEmpty() == true){
	            answer += bridge_length;
	            break;
	        }
	        
	        // 시간의 흐름에 따라 변동하는 다리 위 무게의 합을 표현하기 위해서
	        // 두 조건문 모두에 다리 위 무게의 합에서 다리 위에 순차적으로 올라간 차량(추가하지 않은 경우 0)의 무게를 빼준다.
	        else{
	        	// 현재 다리 위에 존재하는 차량들의 무게와 다음 차례 차량의 무게 합이 다리가 견딜 수 있는 무게보다 작을 경우 
	        	// 차량이 추가되어도 다리가 견딜 수 있기 때문에 다리에 차량을 추가해 준다.
	        	if(sum + truck.peek() <= weight){
	        		bridge_ing.add(truck.peek()); 
	        		sum += truck.poll(); 
	        		sum = sum - bridge_ing.poll(); 
	        	}
	            
	        	// 현재 다리 위에 존재하는 차량들의 무게와 다음 차례 차량의 무게 합이 다리가 견딜 수 있는 무게보다 클 경우 
	        	// 다리가 견딜 수 없기 때문에 차량을 추가해주지 못하며 추가하지 못한 부분에 0의 값을 넣는다.
	        	// 이는 이후에 시간이 흐름에 따라 차량이 다리를 건넌 후 현재 다리 위의 무게를 빼주는 과정에서 
	        	// 추가된 차량이 없기에 무게도 빼지 않기 위함.
	        	else if(sum + truck.peek() > weight){
	        		bridge_ing.add(0);
	        		sum = sum - bridge_ing.poll(); 
	        	}
	        	// 위의 조건문 중 하나라도 실행될 경우, 이는 1초를 사용한 것을 의미하기 때문에 
	        	// 다리를 모두 건너는데 걸린 시간에 1초를 추가해준다.
	        	answer++;
	        }
	    }   
	    return answer;
    }
}

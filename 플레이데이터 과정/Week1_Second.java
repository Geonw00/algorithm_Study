package playdataTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Week1_Second {
//	문제 설명
//	프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
//
//	또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
//
//	먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
//
//	제한 사항
//	작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
//	작업 진도는 100 미만의 자연수입니다.
//	작업 속도는 100 이하의 자연수입니다.
//	배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
//	입출력 예
//	progresses	          		speeds				return
//	[93, 30, 55]				[1, 30, 5]			[2, 1]
//	[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
//	입출력 예 설명
//	입출력 예 #1
//	첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
//	두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
//	세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
//
//	따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
//
//	입출력 예 #2
//	모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다. 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
//
//	따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
	
	// Stack을 사용하지 않은 첫번째 방법 ( 코드의 길이가 길지만 , 속도측면에서 sol2에 비해 좋음)
	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        int[] answer;
	        int[] dateCom = new int[progresses.length];
	        int[] answerG = new int[dateCom.length];
	        int answerCount = 0;
	        int date = 0;
	        int ansDate = 1;
	        int fIndex = 0;
	        int sIndex = 0;
	        int fNum = 0;
	        int sNum = 0;
	        
	        // 해당 인덱스의 작업이 완료되려면 얼마나 걸리는 지 
	        // 진도에 속도를 대입하여 결과 산출 => int[] dateCom
	        for(int i = 0; i <= progresses.length-1; i++){
	            date = 0;
	            while(true){
	                if(progresses[i] < 100){
	                    progresses[i] += speeds[i];
	                    date += 1;
	                }
	                else if(progresses[i] >= 100){
	                    dateCom[i] = date;
	                    break;
	                }
	            }
	        }    
	        
	        // 순서별 기능들의 작업완료 시간을 비교하여 순서상 앞에 위치한 작업 일수가 더 오래 걸릴 경우
	        // 뒤의 기능이 일찍 완료되더라도 앞의 기능 완료시 까지 배포를 기다려야하기 때문에 첫 기능 출시일에 같이 배포
	        // 그러므로 첫 기능 출시일에 배포되는 기능수에 더함 
	        while(true){
	            if(sIndex > dateCom.length-1){
	                break;
	            }
	            sIndex = fIndex + 1;
	            ansDate = 1;
	            while(true){
	                if(sIndex > dateCom.length-1){
	                    answerCount += 1;
	                    answerG[fIndex] = ansDate;
	                    break;
	                }
	                else if (dateCom[fIndex] >= dateCom[sIndex]){
	                    ansDate += 1;
	                    sIndex++;
	                }
	                else if (dateCom[fIndex] < dateCom[sIndex]){
	                    answerCount += 1;
	                    answerG[fIndex] = ansDate;
	                    fIndex = sIndex;
	                    break;
	                }
	            }     
	        }
	        // 각 배포의 총 수를 통하여 answer의 크기를 정하고, 
	        // 동시에 배포되는 기능들 중 가장 앞에 위치한 기능을 배포되는 날을 기준으로 하여
	        // 몇 개의 기능이 동시에 배포되어 있는지 answerG에 입력되어 있으며 동시배포되는 기능들 중 가장 앞에 위치한 기능이 아닐 경우 0이 들어감.
	        // 그러므로 answerG에서 0을 제외하고 필요한 데이터 값만 answer에 입력
	        answer = new int[answerCount];
	        while(true){
	            if(sNum > answerG.length-1){
	                break;
	            }
	            else if(answerG[sNum] != 0){
	                answer[fNum] = answerG[sNum];
	                fNum++;
	                sNum++;
	            }
	            else{ sNum++;}
	        }
	       
	        
	        return answer;
	    }
	}
}
	
	//Stack을 사용한 두번째 방법 ( 코드의 길이가 짧음 )
	class Solution2 {
		public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] dateCom = new int[progresses.length];
        Stack<Integer> answerG = new Stack<>();
        int date = 0;
        int ansDate = 1;
        int sIndex = 0;
        int fIndex = 0;
        
        // 해당 인덱스의 작업이 완료되려면 얼마나 걸리는 지 
        // 진도에 속도를 대입하여 결과 산출 => int[] dateCom
        for(int i = 0; i <= progresses.length-1; i++){
            date = 0;
            while(true){
                if(progresses[i] < 100){
                    progresses[i] += speeds[i];
                    date += 1;
                }
                else if(progresses[i] >= 100){
                    dateCom[i] = date;
                    break;
                }
            }
        }    
        
        // 순서별 기능들의 작업완료 시간을 비교하여 순서상 앞에 위치한 작업 일수가 더 오래 걸릴 경우
        // 뒤의 기능이 일찍 완료되더라도 앞의 기능 완료시 까지 배포를 기다려야하기 때문에 첫 기능 출시일에 같이 배포
        // 그러므로 첫 기능 출시일에 배포되는 기능수에 더함 
        while(true){
            if(sIndex > dateCom.length-1){
                break;
            }
            sIndex = fIndex + 1;
            ansDate = 1;
            while(true){
                if(sIndex > dateCom.length-1){
                    answerG.push(ansDate);
                    break;
                }
                else if (dateCom[fIndex] >= dateCom[sIndex]){
                    ansDate += 1;
                    sIndex++;
                }
                else if (dateCom[fIndex] < dateCom[sIndex]){
                    answerG.push(ansDate);
                    fIndex = sIndex;
                    break;
                }
            }     
        }
        
        // stack answerG의 크기를 통하여 answer의 크기를 정하고, 
        // 동시에 배포되는 기능들 중 가장 앞에 위치한 기능을 배포되는 날을 기준으로 하여
        // 몇 개의 기능이 동시에 배포되어 있는지 answerG에 입력되어 있음.
        // 값을 리턴하기위해 stack 타입의 answerG.get()을 통하여 제일 앞에 있는 데이터부터 순차적으로 
        // int[] answer에 입력.
        answer = new int[answerG.size()];
        for(int i = 0; i <= answerG.size()-1; i++){
            answer[i] = answerG.get(i);
        }
       
        
        return answer;
    }
}

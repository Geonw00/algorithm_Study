package playdataTest;

public class Week2_First {
//	문제 설명
//	수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//	1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//	2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//	3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//	1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//	제한 조건
//	시험은 최대 10,000 문제로 구성되어있습니다.
//	문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//	가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
//	입출력 예
//	answers		return
//	[1,2,3,4,5]	[1]
//	[1,3,2,4,2]	[1,2,3]
//	입출력 예 설명
//	입출력 예 #1
//
//	수포자 1은 모든 문제를 맞혔습니다.
//	수포자 2는 모든 문제를 틀렸습니다.
//	수포자 3은 모든 문제를 틀렸습니다.
//	따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
//
//	입출력 예 #2
//
//	모든 사람이 2문제씩을 맞췄습니다.
	 public int[] solution(int[] answers) {
		 
	        int[] answer1 = new int[answers.length]; 
	        int[] answer2 = new int[answers.length]; 
	        int[] answer3 = new int[answers.length];
	        int[] answer = null;
	        
	        int point1 = 0;
	        int point2 = 0;
	        int point3 = 0;
	        
	        // 수포자 1의 찍는 방식으로 answers의 length만큼의 답안 생성
	        for(int i = 0; i <= answers.length-1; i++){
	            if(i % 5 == 0){
	                answer1[i] = 1;
	            }
	            else if(i % 5 == 1){
	                answer1[i] = 2;
	            }
	            else if(i % 5 == 2){
	                answer1[i] = 3;
	            }
	            else if(i % 5 == 3){
	                answer1[i] = 4;
	            }
	            else if(i % 5 == 4){
	                answer1[i] = 5;
	            }
	        }
	        
	        // 수포자 2의 찍는 방식으로 answers의 length만큼의 답안 생성
	        for(int i = 0; i <= answers.length-1; i++){
	            if(i % 8 == 1){
	                answer2[i] = 1;
	            }
	            else if(i % 8 == 3){
	                answer2[i] = 3;
	            }
	            else if(i % 8 == 5){
	                answer2[i] = 4;
	            }
	            else if(i % 8 == 7){
	                answer2[i] = 5;
	            }
	            else{ answer2[i] = 2;}
	            
	        }
	        
	        // 수포자 3의 찍는 방식으로 answers의 length만큼의 답안 생성
	        for(int i = 0; i <= answers.length-1; i++){
	            if(i % 10 == 0 || i % 10 == 1){
	                answer3[i] = 3;
	            }
	            else if(i % 10 == 2 || i % 10 == 3){
	                answer3[i] = 1;
	            }
	            else if(i % 10 == 4 || i % 10 == 5){
	                answer3[i] = 2;
	            }
	            else if(i % 10 == 6 || i % 10 == 7){
	                answer3[i] = 4;
	            }
	            else if(i % 10 == 8 || i % 10 == 9){
	                answer3[i] = 5;
	            }
	            
	        }
	        
	        // 수포자1이 작성한 답안과 실제 답안 비교하여 맞춘 문제의 개수를 point1에 입력
	        for(int i = 0; i <= answers.length-1; i++){
	            if(answer1[i] == answers[i]){
	                point1 += 1;
	            }
	            else{ continue;}
	        }
	        
	        // 수포자2가 작성한 답안과 실제 답안 비교하여 맞춘 문제의 개수를 point2에 입력
	        for(int i = 0; i <= answers.length-1; i++){
	            if(answer2[i] == answers[i]){
	                point2 += 1;
	            }
	            else{ continue;}
	        }
	        
	        // 수포자3이 작성한 답안과 실제 답안 비교하여 맞춘 문제의 개수를 point3에 입력
	        for(int i = 0; i <= answers.length-1; i++){
	            if(answer3[i] == answers[i]){
	                point3 += 1;
	            }
	            else{ continue;}
	        }
	        
	        // 세 명의 점수를 비교하여 최고 점수를 도출
	        // 최고득점자의 번호를 int[] answer에 길이를 선언하여 모두 넣음.
	        if(point1 < point2){
	            if(point2 < point3){
	                answer = new int[1];
	                answer[0] = 3;
	            }
	            else if(point2 > point3){
	                answer = new int[1];
	                answer[0] = 2;
	            }
	            else if(point2 == point3){
	                answer = new int[2];
	                answer[0] = 2;
	                answer[1] = 3;
	            }
	        }
	        else if(point1 > point2){
	            if(point1 < point3){
	                answer = new int[1];
	                answer[0] = 3;
	            }
	            else if(point1 > point3){
	                answer = new int[1];
	                answer[0] = 1;
	            }
	            else if(point1 == point3){
	                answer = new int[2];
	                answer[0] = 1;
	                answer[1] = 3;
	            }
	        }
	        else if(point1 == point2){
	            if(point1 < point3){
	                answer = new int[1];
	                answer[0] = 3;
	            }
	            else if(point1 > point3){
	                answer = new int[2];
	                answer[0] = 1;
	                answer[1] = 2;
	            }
	            else if(point1 == point3){
	                answer = new int[3];
	                answer[0] = 1;
	                answer[1] = 2;
	                answer[2] = 3;
	            }
	        }
	         
	        return answer;
	    }
}

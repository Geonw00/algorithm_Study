package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/17681

public class Week4_Third {
	
	public static String[] changeArr(int[] arr, int n) {
		String[] chArr = new String[n];
		
		for(int i = 0; i <= n-1; i++) {
			// 기본값을 공백으로 지정해주지 않으면 null이 들어가 있으므로 공백지정
			chArr[i] = "";	
			// 주어진 십진법의 수를 2진법으로 변환
			// 문자열에 더할 때 , 새로 추가되는 나머지를 문자열의 앞부분부터 더하도록 해야함.
			for(int j = 0; j <= n-1; j++) {
				chArr[i] = arr[i] % 2 + chArr[i];
				arr[i] /= 2;
			}
		} 
		return chArr;
		
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        
		String[] arr1Nota = new String[n];
		String[] arr2Nota = new String[n];
		String[] answer = new String[n];
		
		// 십진법으로 이루어진 지도배열을 이진법으로 변환
		arr1Nota = changeArr(arr1, n);
		arr2Nota = changeArr(arr2, n);

		for(int i = 0; i <= n-1; i++) {
			// 기본값을 공백으로 지정해주지 않으면 null이 들어가 있으므로 공백지정
			answer[i] = "";
			for(int j = 0; j <= n-1; j++) {
				// 두 개의 지도를 겹쳤을 때, 두 지도 중 하나라도 길이 막혀 있다면 최종지도는 벽으로 구성
				if(arr1Nota[i].charAt(j) == '1' || arr2Nota[i].charAt(j) == '1') {
					answer[i] += "#";
				}
				else {
					answer[i] += " ";
				}
			}
		}
        return answer;
    }
}

package playdataTest;

// https://programmers.co.kr/learn/courses/30/lessons/42862

import java.util.Arrays;

public class Week9_First {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] student = new int[n + 1];
		Arrays.fill(student, 1);
		
		for(int i : lost) {
			student[i] -= 1;
			System.out.println(student[i] + " " + i);
		}
		
		// reserve 값 정렬되지 않을 경우 앞 번호의 학생부터 계산이 이루어지지 않으므로 정렬
		Arrays.sort(reserve);
		
		// 여벌체육복을 가진 학생이 도난 당했을 경우 , 자신이 여벌체육복을 사용하게 되는데
		// lost = 1,2,3이며 reserve = 2,3,4일 경우 자신이 여벌체육복을 사용함을 먼저 계산하지 않을 경우 1이 2를 빌려주는 형태로
		// 마지막에 4번 학생까지 체육복을 가지는 오차가 발생한다.
		for(int i : reserve) {
			if(student[i] == 0) {
				// 자기 자신의 체육복을 사용한 학생의 경우 값을 2로 넣어 구별
				student[i] = 2;
			}
		}
		
		for(int i: reserve) {
			System.out.println(student[i] + " " + i);
			// 값이 2인 경우 도난당하여 자신이 여벌을 사용하는 경우이므로 이미 여벌을 사용했으므로 continue
			if(student[i] == 2) {
				continue;
			}
			else if(student[i] == 1) {
				if(i == 1 && student[i+1] == 0) {
					student[i+1] += 1;
				}
				else if(i == student.length-1 && student[i-1] == 0) {
					System.out.println(student[i]);
					student[i-1] += 1;
				}
				else if(i != 1 && i != student.length-1) {
					if(student[i-1] == 0) {
						student[i-1] += 1;
					}
					else if(student[i+1] == 0) {
						student[i+1] += 1;
					}
				}
			}
		}
		
		for(int i = 1; i < student.length; i++) {
			System.out.println(student[i]);
			if(student[i] > 0) {
				answer ++;
			}
		}
		
		return answer;
    }
}

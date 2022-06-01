package baekjoon;

// https://www.acmicpc.net/problem/4673

import java.util.ArrayList;
import java.util.List;

public class baekjoon_4673 {

	public static void main(String[] args) {
		List<Integer> selfList = new ArrayList<>();

		for(int i = 1; i <= 10000; i++) {
			String strNum = Integer.toString(i);
			int resNum = i;
			for(int j = 0; j < strNum.length(); j++) {
				// char타입은 ascii 코드로의 변환으로 char타입 0 == int타입 48을 의미한다.
				// 그러므로 char => int변환 시 -48 or -'0'을 해줄 필요가 있다.
				System.out.println(strNum.charAt(j));
				resNum += (int)strNum.charAt(j) - 48;
			}
			
			if(resNum <= 10000) {
				selfList.add(resNum);
			}
		}
		
		for(int i = 1; i <= 10000; i++) {
			if(!selfList.contains(i)) {
				System.out.println(i);
			}
		}
	}
}

package baekjoon;

// https://www.acmicpc.net/problem/5073

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class baekjoon_5073 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] triLen = br.readLine().split(" ");
			int[] testTri = new int[3];
			
			// String[]을 int[]로 변환
			for(int i = 0; i < 3; i++) {
				testTri[i] = Integer.parseInt(triLen[i]);
			}
			
			Arrays.sort(testTri);
			
			// 0 0 0이 주어질 경우 프로그램 종료
			if(testTri[0] + testTri[1] + testTri[2] == 0) {
				break;
			}
			// 삼각형의 조건 테스트
			// 가장 큰 변의 길이가 나머지 두 변의 길이보다 작아야 함
			else if(testTri[0] + testTri[1] <= testTri[2]) {
				System.out.println("Invalid");
				continue;
			}
			
			// set으로 변환 통해 중복된 값 제거
			Set<String> triSet = Arrays.stream(triLen).collect(Collectors.toSet());
			
			if(triSet.size() == 1) {
				System.out.println("Equilateral");
			}
			else if(triSet.size() == 2) {
				System.out.println("Isosceles");
				
			}
			else if(triSet.size() == 3) {
				System.out.println("Scalene");
				
			}
		}
	}
}

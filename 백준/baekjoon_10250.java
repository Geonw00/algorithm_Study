package baekjoon;

// https://www.acmicpc.net/problem/10250

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10250 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] inputArray = br.readLine().split(" ");
			int H = Integer.parseInt(inputArray[0]);
			int W = Integer.parseInt(inputArray[1]);
			int N = Integer.parseInt(inputArray[2]);
			String Y;
			String X;
			
			// 온 순서를 건물의 층 수로 나눈 나머지가 0일 경우 최상층을 의미
			if(N % H == 0) {
				Y = Integer.toString(H);
				X = Integer.toString((int) N / H);
			}
			else {
				Y = Integer.toString(N % H);
				X = Integer.toString(1 + ((int) N / H));
			}
			
			// X가 한자리일 경우, 앞에 '0'추가
			if(X.length() == 1) {
				X = "0" + X;
			}
			
			System.out.println(Y+X);
		}
	}
}

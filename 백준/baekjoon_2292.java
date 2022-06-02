package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int maxN = 1;
		int count = 1;
		
		while(N > maxN) {
			maxN += count * 6;
			count++;
		}
		
		System.out.println(count);
	}
}

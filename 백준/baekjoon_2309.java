package baekjoon;

// https://www.acmicpc.net/problem/2309

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class baekjoon_2309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		for(int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				
				// IntStream.of(dwarf).sum()을 통해서 dwarf배열 요소들의 총합 도출
				// int[] 배열을 모든 합친 값에서 난쟁이 둘을 제외하였을 때, 키의 합이 100이면 두명 제외
				if(IntStream.of(dwarf).sum() - (dwarf[i] + dwarf[j]) == 100) {
					dwarf[i] = 0;
					dwarf[j] = 0;
					
					break;
				}
			}
			
			// 이중 for문 사용하기때문에 break 두번 사용
			if(dwarf.length != 9) {
				break;
			}
		}
		
		// 오름차순으로 배열 sort
		Arrays.sort(dwarf);
		for(int result : dwarf) {
			if(result != 0) {
				System.out.println(result);
			}
		}
	}
}

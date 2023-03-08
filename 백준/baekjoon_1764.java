package baekjoon;

// https://www.acmicpc.net/problem/1764

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class baekjoon_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputC = br.readLine().split(" ");
		int N = Integer.parseInt(inputC[0]);
		int M = Integer.parseInt(inputC[1]);
		
		List<String> resList = new ArrayList<>();
		Map<String, Integer> no_H_L_people = new HashMap<>();
		for(int i = 0; i <= N-1; i++) {
			no_H_L_people.put(br.readLine(), 1);
		}
		
		// List의 contains로 중복검사 시 시간초과 발생
		// map을 사용하여 key를 통한 중복여부 검사
		for(int j = 0; j <= M-1; j++) {
			String noLpeople = br.readLine();
			// getOrDefault = 새로운 값일 경우 디폴트값 반환, 아닐 경우 기존 값 반환 
			no_H_L_people.put(noLpeople, no_H_L_people.getOrDefault(noLpeople, 0) + 1);
			// value가 2일 경우 중복된 이름으로 판단
			if(no_H_L_people.get(noLpeople) == 2) {
				resList.add(noLpeople);
			}
		}
		
		// 결과값 사전순으로 정리
		Collections.sort(resList);
		
		// 수와 명단 출력
		System.out.println(resList.size());
		for(String res : resList) {
			System.out.println(res);
		}
	}
}

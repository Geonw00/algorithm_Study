package baekjoon;

// https://www.acmicpc.net/problem/1254

import java.util.Scanner;

public class baekjoon_1254 {
	// 문자열이 팰린드롬인지 확인 
	public static boolean ckPal(String sen) {
		int reTime = sen.length() / 2;
		
		for(int i = 0; i < reTime; i++) {
			if(sen.charAt(i) != sen.charAt(sen.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inStr = sc.next();
		int stLen = inStr.length();
		
		// input 문자열에 대해서 팰린드롬 여부를 확인하고 몇 개의 문자를 추가해야하는 지 구함 
		for(int i = 0; i < inStr.length(); i++) {
			// 문자열을 앞부분부터 substring하여 해당 문자열이 팰린드롬인지 확인
			// 만약 자른 문자열이 팰린드롬일 경우, i개의 앞부분 문자열을 뒷부분에 추가하기때문에
			// 최종 팰린드롬이 완성된 문자열의 길이는 기존 문자열의 길이 + i 로 표현가능 
			if(ckPal(inStr.substring(i))) {
				stLen += i;
				break;
			}
		}
		
		System.out.println(stLen);
	}
}

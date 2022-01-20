package playdataTest;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10872

public class Week6_Second {
	static int result = 1;
	public static void facCal(int inNum){
		if(inNum > 0) {
			result *= inNum;
			facCal(inNum-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inNum = sc.nextInt();
		facCal(inNum);
		System.out.print(result);

	}

}

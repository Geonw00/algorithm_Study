package playdataTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
// BufferedReader와 BufferedWriter로 성능을 높이고  HashMap을 사용하여 최초 이중for문을 변경하였지만
// 3%에서 지속적인 시간초과.

//문제
//숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
//
//셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
//
//출력
//첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
//
//예제 입력 1 
//10
//6 3 2 10 10 10 -10 -10 7 3
//8
//10 9 -5 2 3 4 5 -10
//
//예제 출력 1 
//3 0 0 1 2 0 0 2

public class Week2_Third {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int nLen = Integer.parseInt(br.readLine());
		String[] nsArr = br.readLine().split(" ");
		int rLen = Integer.parseInt(br.readLine());
		String[] rsArr = br.readLine().split(" ");
		br.close();
		HashMap<String, Integer> reArr = new HashMap<String, Integer>();
		
		// 주어진 N의 수를 HashMap타입의 reArr에 key값으로 넣으며 만약 같은 키 값이 존재할 경우 value + 1 
		for(String i : nsArr) {
			reArr.put(i, reArr.getOrDefault(i, 0) + 1);
		}
		
		// M의 수를 키로 가지는 reArr의 value를 통해서 해당 M의 수가 N의 항목들 중 몇번 등장하였는지 출력
		// 해당 M의 수가 하나도 존재하지 않을 경우 null값이 출력되기 때문에 0으로 변환하여 출력
		for(String i : rsArr) {
			if(reArr.get(i) == null) {
				bw.write(0 + " ");
			}
			else {
				bw.write(reArr.get(i) + " ");
			}
		}
		bw.flush();
		bw.close();
	}

}

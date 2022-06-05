package baekjoon;

// https://www.acmicpc.net/problem/17952

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_17952 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 과제 클래스로 stack 생성
		Stack<Task> taskStack = new Stack<>();
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			String[] inTask = br.readLine().split(" ");
			
			if(inTask[0].equals("1")) {
				if(Integer.parseInt(inTask[2]) - 1 == 0) {
					res += Integer.parseInt(inTask[1]);
				}
				else {
					taskStack.add(new Task(Integer.parseInt(inTask[1]), Integer.parseInt(inTask[2])-1));
				}
			}
			else {
				if(taskStack.empty()) {
					continue;
				}
				else {
					Task nowTask = taskStack.pop();
					if(nowTask.time - 1 == 0) {
						res += nowTask.score;
					}
					else {
						taskStack.add(new Task(nowTask.score, nowTask.time - 1));
					}
				}			
			}
		}
		
		System.out.println(res);
	}
}

// 과제 클래스 생성
class Task{
	int score;
	int time;
	
	Task(int score, int time){
		this.score = score;
		this.time = time;
	}
}

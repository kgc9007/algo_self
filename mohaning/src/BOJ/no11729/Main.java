// BOJ 11729번 하노이 탑 이동 순서

package BOJ.no11729;

import java.util.Scanner;

public class Main {

	// 총 이동횟수를 저장할 변수 count
	public static int count = 0;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 원판의 개수 N 입력
		int N = sc.nextInt();
		
		hanoi(N, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb);
		
	}
	
	// 높이가 N인 경우
	// N-1 높이의 하노이 탑을 1번 장대에서 2번 장대로 이동시킨 후
	// 가장 큰 원판을 1번 장대에서 3번 장대로 이동시키고
	// 다시 N-1 높이의 하노이 탑을 2번 장대에서 3번 장대로 이동
	// -> N-1 높이의 탑을 이동시키는 경우
	// N 높이에서의 도착점 = 경유지점, 경유지점 = 도착점 
	
	// ex) 높이 3인 경우
	// 높이 2 짜리 탑을 2번 장대로 이동 : 1 -> 3, 1 -> 2, 3 -> 2
	// 가장 큰 원판을 3번 장대로 이동 : 1 -> 3
	// 다시 높이 2 짜리 탑을 3번 장대로 이동 : 2 -> 1, 2 -> 3, 1 -> 3 
	public static void hanoi(int N, int start, int middle, int end) {
		if (N == 1) {
			sb.append(start + " " + end + "\n");
			count++;
		} else {
			hanoi(N-1, start, end, middle);
			hanoi(1, start, middle, end);
			hanoi(N-1, middle, start, end);
		}
	}
}

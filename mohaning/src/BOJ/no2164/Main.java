// BOJ 2164번 카드2

// 큐 구현 X, 패키지 사용 O

package BOJ.no2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 가장 큰 카드 번호 N 입력
		int N = sc.nextInt();
		
		// 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		
		// 큐에 1부터 N까지 카드 입력
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		// 카드가 한장 남을때까지
		// 맨 앞에서 한장 제거 + 다음 한 장을 뽑아서 맨 뒤에 입력을 반복
		while (queue.size() != 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		// 결과 (마지막에 남은 카드) 출력
		System.out.println(queue.poll());
		
	}
}

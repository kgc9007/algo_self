// BOJ 1966번 프린터 큐

package BOJ.no1966;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 전체 테스트 케이스의 수 입력
		int T = sc.nextInt();

		while (T-- > 0) {
			// N : 문서의 개수
			// M : 몇번째로 인쇄되었는지 확인하려는 문서의 현재 위치(0 <= M < N)
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 중요도와 인덱스를 두 개의 큐로 생성해서 저장
			Queue<Integer> priority = new LinkedList<>();
			Queue<Integer> index = new LinkedList<>();
			
			for (int i=0; i<N; i++) {
				priority.add(sc.nextInt());
				index.add(i);
			}
			
			// 큐를 탐색해서 
			// 현재 남아있는 원소 중 우선순위가 최대이면 큐에서 제거(poll)
			// 제거 후 남아있는 queueSize--, count++
			// 만약 처음 인덱스가 M이면 종료
			// 우선순위가 최대가 아니라면 맨 뒤에 다시 추가(add)
			int count = 0;
			int queueSize = N;
			while (!priority.isEmpty()) {
				int maxPriority = 0;
				for (int i=0; i<queueSize; i++) {
					int num = priority.poll();
					if (num > maxPriority) {
						maxPriority = num;
					}
					priority.add(num);
				}
				if (priority.peek() == maxPriority) {
					count++;
					priority.poll();
					int num = index.poll();
					queueSize--;
					if (num == M) {
						break;
					}
				} else if (priority.peek() < maxPriority) {
					priority.add(priority.poll());
					index.add(index.poll());
				}
			}
			
			// 결과 출력
			System.out.println(count);
		}
	}
}

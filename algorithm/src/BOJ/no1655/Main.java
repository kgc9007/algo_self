// BOJ 1655번 가운데를 말해요
// https://www.acmicpc.net/problem/1655

package BOJ.no1655;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);

		while (N-- > 0) {
			int num = sc.nextInt();

			if (minHeap.size() == maxHeap.size()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}

			if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(minHeap.poll());
			}

			sb.append(maxHeap.peek()).append('\n');
		}
		
		// 결과 출력
		System.out.println(sb);
	}
}

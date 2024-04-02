// BOJ 11279번 최대 힙
// https://www.acmicpc.net/problem/11279

package BOJ.no11279;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		while (N-- > 0) {
			int x = sc.nextInt();

			if (x == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(x);
			}
		}
	}
}

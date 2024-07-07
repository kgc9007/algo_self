// BOJ 13549번 숨바꼭질 3
// https://www.acmicpc.net/problem/13549

package BOJ.no13549;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] visited = new int[100001];
		Queue<Integer> queue = new LinkedList<>();

		visited[N] = 1;
		queue.add(N);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (curr == K) {
				break;
			}

			int next = curr * 2;
			while (next <= 100000 && visited[next] == 0) {
				visited[next] = visited[curr];
				queue.add(next);
				next *= 2;
			}

			if (curr - 1 >= 0 && visited[curr - 1] == 0) {
				visited[curr - 1] = visited[curr] + 1;
				queue.add(curr - 1);
			}

			if (curr + 1 <= 100000 && visited[curr + 1] == 0) {
				visited[curr + 1] = visited[curr] + 1;
				queue.add(curr + 1);
			}
		}

		// 결과 출력
		System.out.println(visited[K] - 1);
	}
}

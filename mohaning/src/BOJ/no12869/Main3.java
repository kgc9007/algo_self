// BOJ 12869번 뮤탈리스크
// https://www.acmicpc.net/problem/12869

package BOJ.no12869;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {
	static int[][][] visited = new int[61][61][61];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] SCV = new int[3];

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			SCV[i] = sc.nextInt();
		}

		bfs();

	}

	// BFS?
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { 0, 0, 0 });
		visited[0][0][0] = 1;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			int hp0 = curr[0];
			int hp1 = curr[1];
			int hp2 = curr[2];

		}
	}

}

// BOJ 1389번 케빈 베이컨의 6단계 법칙

package BOJ.no1389;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static boolean[][] graph;
	static boolean[] visited;
	static int[][] kbn;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 유저의 수 N, 친구 관계의 수 M 입력
		N = sc.nextInt();
		int M = sc.nextInt();

		// 인접행렬을 통해 표현
		graph = new boolean[N + 1][N + 1];
		kbn = new int[N + 1][N + 1];

		// 친구 관계 입력
		while (M-- > 0) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			graph[s][e] = graph[e][s] = true;
		}

		// 전체 유저에 대해 bfs 실시
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			bfs(i);
		}

		// 전체 유저의 케빈 베이컨 수의 최소값 확인, 결과 저장
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			// sum = 0으로 초기화 후 케빈 베이컨 수 계산
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += kbn[i][j];
			}
			// 구한 케빈 베이컨 수가 최소값보다 작다면 갱신
			if (sum < min) {
				result = i;
				min = sum;
			}
		}
		
		// 결과 출력
		System.out.println(result);
	}

	// bfs
	public static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();

		visited[idx] = true;
		queue.add(idx);

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (graph[tmp][i] && !visited[i]) {
					// 이전 사람까지 이어지는데 걸린 횟수 + 1
					kbn[idx][i] = kbn[idx][tmp] + 1;
					visited[i] = true;

					queue.add(i);
				}
			}
		}
	}
}

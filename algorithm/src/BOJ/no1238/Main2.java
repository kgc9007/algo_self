// BOJ 1238번 파티
// https://www.acmicpc.net/problem/1238

package BOJ.no1238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {

	// INF : MAX_VALUE
	static final int INF = Integer.MAX_VALUE;

	static int N; // N : 학생의 수 (노드의 수)
	static int M; // M : 도로의 수 (간선의 수, 단방향)
	static int X; // X : 모이기로 한 마을 (기준점이 되는 노드)

	static List<int[]>[] graph; // 인접리스트로 그래프 표현
	static int[] dist; // 최소 거리 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 학생 수, 도로의 수, 도착 마을 입력
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();

		// 그래프 초기화
		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<int[]>();
		}

		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			int S = sc.nextInt(); // 시작점
			int E = sc.nextInt(); // 도착점
			int W = sc.nextInt(); // 가중치(소요시간)

			graph[S].add(new int[] { E, W });
		}

		// 최소거리배열 초기화
		dist = new int[N + 1];
		Arrays.fill(dist, INF);

		// 다익스트라 : 목적지 -> 각 집까지의 최소거리 계산(돌아가는 시간)
		dijkstra(X);

		// result 배열 생성 후 돌아가는 시간 입력
		int[] result = Arrays.copyOf(dist, N + 1);

		// 각 집에서 출발한 후 목적지까지의 시간을 계산하여 추가
		for (int i = 1; i < N + 1; i++) {
			dist = new int[N + 1];
			Arrays.fill(dist, INF);

			dijkstra(i);
			result[i] += dist[X];
		}

		// 소요시간의 최대값 계산
		int max = 0;
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(max, result[i]);
		}

		// 결과 출력
		System.out.println(max);
	}

	// 다익스트라 알고리즘
	public static void dijkstra(int start) {
		boolean[] visited = new boolean[N + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		dist[start] = 0;

		pq.add(new int[] { start, 0 });
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			int v = curr[0];
			int w = curr[1];

			if (!visited[v]) {
				visited[v] = true;

				for (int i = 0; i < graph[v].size(); i++) {
					int nv = graph[v].get(i)[0];
					int nw = graph[v].get(i)[1];

					if (!visited[nv] && dist[v] + nw < dist[nv]) {
						dist[nv] = dist[v] + nw;
						pq.add(new int[] { nv, dist[nv] });
					}
				}
			}
		}

	}
}

// BOJ 18352번 특정 거리의 도시 찾기
// https://www.acmicpc.net/problem/18352

package BOJ.no18352;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 노드의 개수 N, 간선의 개수 M
	static int N;
	static int M;

	// 인접 리스트 adj, 방문배열 visited : 해당 노드까지의 최소 거리 표시
	static List<Integer>[] adj;
	static int[] visited;

	// 구하려는 거리(목표값) K, 출발 노드 X
	static int K;
	static int X;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		while (M-- > 0) {
			int S = sc.nextInt();
			int E = sc.nextInt();

			adj[S].add(E);
		}

		visited = new int[N + 1];
		bfs(X);

		// 전체 노드를 순차적으로 확인하며 거리가 K인 노드들을 결과에 추가
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (visited[i] == K + 1) {
				result.add(i);
			}
		}

		// 오름차순 정렬
		Collections.sort(result);

		// 결과 출력
		if (result.size() == 0) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}

	// bfs
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		visited[start] = 1;
		queue.add(start);

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 0; i < adj[curr].size(); i++) {
				if (visited[adj[curr].get(i)] == 0) {
					visited[adj[curr].get(i)] = visited[curr] + 1;
					queue.add(adj[curr].get(i));
				}
			}
		}

	}
}

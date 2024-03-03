// BOJ 2606번 바이러스

package BOJ.no2606;

import java.util.Scanner;

public class Main {

	// graph - 2차원 배열을 이용해 인접행렬로 구현
	// visited - 각 노드를 방문한 적이 있는지를 확인
	// count - 연결된 노드의 수(탐색을 시작할 노드 포함)
	static boolean[][] graph;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 컴퓨터의 수(노드의 수) N, 네트워크에서 직접 연결되어 있는 컴퓨터 쌍의 수(간선의 수) L 입력
		int N = sc.nextInt();
		int L = sc.nextInt();

		// graph, visited 초기화
		graph = new boolean[N][N];
		visited = new boolean[N];

		// 간선 정보 입력
		while (L-- > 0) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;

			// 연결 상태 표현
			graph[s][e] = true;
			graph[e][s] = true;
		}

		// count = 0으로 초기화 후 dfs 실시
		count = 0;
		dfs(0);

		// 결과 출력
		System.out.println(count - 1);
	}

	// dfs
	public static void dfs(int node) {
		// 방문 노드의 수++
		count++;
		
		// 해당 노드 방문 여부 true로 변경
		visited[node] = true;
		
		// 순차적으로 다른 노드와 연결되었는지, 이전에 방문한 적이 없는지 확인
		// 조건에 맞으면 해당 노드에서 dfs 실시
		for (int i = 0; i < graph.length; i++) {
			if (graph[node][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
}

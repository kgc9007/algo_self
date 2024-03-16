// BOJ 11403번 경로 찾기

package BOJ.no11403;

import java.util.Scanner;

public class Main {

	static int N;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		graph = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				graph[r][c] = sc.nextInt();
			}
		}

		for (int s = 0; s < N; s++) {
			visited = new boolean[N];
			dfs(s);
			
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					graph[s][i] = 1;
				}
			}
		}
		
		// 결과 출력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(graph[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	// dfs
	public static void dfs(int start) {
		for (int end = 0; end < N; end++) {
			if (graph[start][end] == 1 && !visited[end]) {
				visited[end] = true;
				dfs(end);
			}
		}
	}
}

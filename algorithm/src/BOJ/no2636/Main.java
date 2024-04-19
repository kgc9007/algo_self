// BOJ 2636번 치즈
// https://www.acmicpc.net/problem/2636

package BOJ.no2636;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 판의 크기 N, M
	// 판의 정보를 입력할 배열 map
	static int N;
	static int M;
	static int[][] map;

	// bfs를 위한 방문 배열 
	static boolean[][] visited;
	
	// 모든 치즈가 녹아서 없어지는데 걸리는 시간 lastTime
	// 마지막까지 남아있는 치즈 조각의 수 peice
	static int lastTime = -1;
	static int peice;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 모든 치즈가 녹으면 종료
		// bfs를 반복하며 공기와 접촉한 치즈 제거
		// bfs를 1회 실시할 때마다 lastTime++
		boolean isAllMelted = false;
		while (!isAllMelted) {
			lastTime++;
			int count = bfs();

			if (count == 0) {
				isAllMelted = true;
			} else {
				peice = count;
			}
		}

		// 결과 출력
		System.out.println(lastTime);
		System.out.println(peice);

	}

	// bfs
	public static int bfs() {
		visited = new boolean[N][M];
		int count = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if (map[nr][nc] == 0) {
						queue.add(new int[] { nr, nc });
					}
					if (map[nr][nc] == 1) {
						map[nr][nc] = 0;
						count++;
					}
				}
			}
		}
		return count;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}

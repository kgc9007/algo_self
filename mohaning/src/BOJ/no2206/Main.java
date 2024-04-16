// BOJ 2206번 벽 부수고 이동하기

package BOJ.no2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 맵의 크기 N, M
	static int N;
	static int M;
	static int[][] map;

	static int[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N, M 입력
		N = sc.nextInt();
		M = sc.nextInt();

		// 맵 생성
		map = new int[N][M];

		// 맵 정보 입력
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}

		// 방문배열 초기화 후 bfs 실시
		visited = new int[N][M][2];

		bfs(new int[] { 0, 0, 0 });

		// 결과 출력
		// 불가능할 때는 -1 출력, 가능하면 최단 거리 출력
		if (visited[N - 1][M - 1][0] == 0 && visited[N - 1][M - 1][1] == 0) {
			System.out.println(-1);
		} else {
			// 벽을 부수고 가는 경우만 가능하거나
			// 벽을 안 부수고 가는 경우만 가능하면
			// 가능한 경우가 최단거리
			if (visited[N - 1][M - 1][0] == 0) {
				System.out.println(visited[N - 1][M - 1][1]);
			} else if (visited[N - 1][M - 1][1] == 0) {
				System.out.println(visited[N - 1][M - 1][0]);
			}
			// 둘 다 가능하면 더 빠른 결과 출력
			else {
				int min = Math.min(visited[N - 1][M - 1][0], visited[N - 1][M - 1][1]);
				System.out.println(min);
			}
		}
	}

	// bfs
	public static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		// 0, 0에서 벽을 부수지 않고 시작
		visited[0][0][0] = 1;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			int broken = curr[2]; // 벽을 부순적이 없다면 0, 있다면 1

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 경계를 벗어나면 진행 X
				if (!check(nr, nc)) {
					continue;
				}

				// 벽을 부수지 않고 온 경우
				if (broken == 0) {
					// 다음 칸이 벽이 아니고 아직 방문하지 X
					if (map[nr][nc] == 0 && visited[nr][nc][0] == 0) {
						visited[nr][nc][0] = visited[r][c][0] + 1;
						queue.add(new int[] { nr, nc, 0 });
					}
					// 다음 칸이 벽이고 아직 벽을 부수고 해당 칸에 방문하지 X
					if (map[nr][nc] == 1 && visited[nr][nc][1] == 0) {
						visited[nr][nc][1] = visited[r][c][0] + 1;
						queue.add(new int[] { nr, nc, 1 });
					}
				}
				// 벽을 부수고 온 경우
				else {
					// 다음 칸이 벽이 아니고 아직 방문하지 X
					if (map[nr][nc] == 0 && visited[nr][nc][1] == 0) {
						visited[nr][nc][1] = visited[r][c][1] + 1;
						queue.add(new int[] { nr, nc, 1 });
					}
				}
			}
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}

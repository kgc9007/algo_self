// BOJ 2206번 벽 부수고 이동하기

package BOJ.no2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] wall;

	static int minDistance;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//
		N = sc.nextInt();
		M = sc.nextInt();

		//
		map = new int[N][M];
		wall = new boolean[N][M];

		//
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			for (int c = 0; c < M; c++) {
				if (line.charAt(c) == '1') {
					wall[r][c] = true;
				}
			}
		}

		// 
		minDistance = Integer.MAX_VALUE;
		
		//
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (wall[r][c]) {
					wall[r][c] = false;
					bfs(new int[] { 0, 0 });
					wall[r][c] = true;
				}
			}
		}
		
		// 결과 출력
		if (minDistance != Integer.MAX_VALUE) {
			System.out.println(minDistance);			
		} else {
			System.out.println(-1);
		}

	}

	// bfs
	public static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<>();

		map[start[0]][start[1]] = 1;
		queue.add(start);
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			int r = tmp[0];
			int c = tmp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && !wall[nr][nc] && map[nr][nc] == 0) {
					map[nr][nc] = map[r][c] + 1;
					queue.add(new int[] { nr, nc });
				}
			}
		}
		
		if (map[N - 1][M - 1] != 0) {
			minDistance = Math.min(minDistance, map[N - 1][M - 1]);
		}

	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}

// BOJ 17070번 파이프 옮기기 1
// https://www.acmicpc.net/problem/17070

package BOJ.no17070;

import java.util.Scanner;

public class Main {

	// 새 집의 크기 N, 새 집의 정보를 나타낼 배열 map
	static int N;
	static int[][] map;

	// 파이프를 이동시킬 수 있는 방법의 수 count
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정보 입력
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// dfs를 이용해 파이프를 이동시킬 수 있는 방법의 수 탐색
		dfs(1, 1, 0);
		// 결과 출력
		System.out.println(count);
	}

	// dfs
	// direction : 0 -> 가로, 1 -> 세로, 2 -> 대각선
	public static void dfs(int r, int c, int direction) {
		// 가로로 도착
		if (r == N && c == N - 1 && direction == 0) {
			count++;
			return;
		}
		// 세로로 도착
		if (r == N - 1 && c == N && direction == 1) {
			count++;
			return;
		}
		// 대각선으로 도착
		if (r == N - 1 && c == N - 1 && direction == 2) {
			count++;
			return;
		}

		// 가로 상태
		if (direction == 0) {
			int nr = r;
			int nc = c + 1;

			if (check(nr, nc)) {
				if (check(nr, nc + 1) && map[nr][nc + 1] != 1) {
					dfs(nr, nc, 0);
				}
				if (check(nr + 1, nc + 1) && map[nr][nc + 1] != 1 && map[nr + 1][nc] != 1 && map[nr + 1][nc + 1] != 1) {
					dfs(nr, nc, 2);
				}
			}
		}

		// 세로 상태
		if (direction == 1) {
			int nr = r + 1;
			int nc = c;

			if (check(nr, nc)) {
				if (check(nr + 1, nc) && map[nr + 1][nc] != 1) {
					dfs(nr, nc, 1);
				}
				if (check(nr + 1, nc + 1) && map[nr][nc + 1] != 1 && map[nr + 1][nc] != 1 && map[nr + 1][nc + 1] != 1) {
					dfs(nr, nc, 2);
				}
			}
		}

		// 대각선 상태
		if (direction == 2) {
			int nr = r + 1;
			int nc = c + 1;

			if (check(nr, nc)) {
				if (check(nr, nc + 1) && map[nr][nc + 1] != 1) {
					dfs(nr, nc, 0);
				}
				if (check(nr + 1, nc) && map[nr + 1][nc] != 1) {
					dfs(nr, nc, 1);
				}
				if (check(nr + 1, nc + 1) && map[nr][nc + 1] != 1 && map[nr + 1][nc] != 1 && map[nr + 1][nc + 1] != 1) {
					dfs(nr, nc, 2);
				}
			}
		}
	}

	// 범위를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 1 && r <= N && c >= 1 && c <= N;
	}
}

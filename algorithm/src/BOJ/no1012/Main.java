// BOJ 1012번 유기농 배추

package BOJ.no1012;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T-- > 0) {
			// 가로 길이 M, 세로 길이 N, 배추가 심어진 위치의 개수 K 입력
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[][] map = new int[N][M];

			// K개의 배추의 위치 입력
			while (K-- > 0) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X]++;
			}

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int count = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1) {
						map[r][c] = 2;
						boolean flag = true;
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							while (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0) {
								if (map[nr][nc] == 2) {
									flag = false;
								}
								if (map[nr][nc] == 1) {
									map[nr][nc] = 2;
								}
								nr += dr[d];
								nc += dc[d];
							}
						}
						if (flag) {
							count++;
						}
					}
				}
			}

			// 결과 출력
			System.out.println(count);
		}
	}
}

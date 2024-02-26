// BOJ 2615 오목

package BOJ.no2615;

import java.util.Scanner;

public class Main {

	static int[][] board = new int[19][19];
	static int startr;
	static int startc;

	static int[] dr = { 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				board[r][c] = sc.nextInt();
			}
		}

		int result = check();

		// 결과 출력
		if (result == 0) {
			System.out.println(result);
		} else {
			System.out.println(result);
			System.out.printf("%d %d", startr, startc);
		}

	}

	public static int check() {
		for (int c = 0; c < 19; c++) {
			for (int r = 0; r < 19; r++) {
				if (board[r][c] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = r;
						int nc = c;
						int count = 0;
						while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == 1) {
							count++;
							nr += dr[d];
							nc += dc[d];
						}
						if (count == 5) {
							startr = r + 1;
							startc = c + 1;
							return 1;
						}
					}
				}

				if (board[r][c] == 2) {
					for (int d = 0; d < 4; d++) {
						int nr = r;
						int nc = c;
						int count = 0;
						while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == 2) {
							count++;
							nr += dr[d];
							nc += dc[d];
						}
						if (count == 5) {
							startr = r + 1;
							startc = c + 1;
							return 2;
						}
					}
				}
			}
		}
		return 0;
	}
}
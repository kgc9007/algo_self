// BOJ 2636번 치즈
// https://www.acmicpc.net/problem/2636

package BOJ.no2636;

import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;

	static int[][] visited;
	static int time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 2][M + 2];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
	}
}

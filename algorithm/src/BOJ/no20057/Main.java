// BOJ 20057번 마법사 상어와 토네이도
// https://www.acmicpc.net/problem/20057

package BOJ.no20057;

import java.util.Scanner;

public class Main {
	// 델타배열
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	// 모래밭의 크기 N, 모래밭의 정보를 나타낼 배열 map
	static int N;
	static int[][] map;

	// 처음 모래의 양의 합 start
	// 최종 모래의 양의 합 start
	static int start;
	static int end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		start = getTotalSand();
		
		// 토네이도!!!!!
		tornado();

		end = getTotalSand();

		// 결과 출력
		System.out.println(start - end);
	}

	// 토네이도 발생
	public static void tornado() {
		// 가운데에서 시작
		// 반시계방향으로 회전하며 점점 커지는 모양
		/*
		 * 25 24 23 22 21 10 9 8 7 20 11 2 1 6 19 12 3 4 5 18 13 14 15 16 17
		 * 
		 */
		int r = N / 2 + 1;
		int c = N / 2 + 1;
		int d = 0;
		int length = 1;

		while (length < N) {
			for (int i = 0; i < length; i++) {
				move(r, c, d);
				r = r + dr[d];
				c = c + dc[d];
			}
			d = (d + 1) % 4;
			for (int i = 0; i < length; i++) {
				move(r, c, d);
				r = r + dr[d];
				c = c + dc[d];
			}
			d = (d + 1) % 4;
			length++;
		}

		for (int i = 0; i < length; i++) {
			move(1, N - i, d);
		}

	}

	// 토네이도 이동
	public static void move(int r, int c, int d) {
		int prevr = r;
		int prevc = c;
		int nextr = r + dr[d];
		int nextc = c + dc[d];
		int frontr = nextr + dr[d];
		int frontc = nextc + dc[d];
		int sand = map[nextr][nextc];
		int remain = sand;

		// 5% 이동 (이동방향 앞으로 2칸)
		if (check(nextr + dr[d] * 2, nextc + dc[d] * 2)) {
			int moveSand = (sand * 5) / 100;
			map[nextr + dr[d] * 2][nextc + dc[d] * 2] += moveSand;
			remain -= moveSand;
		}

		// 7% 이동 (이동방향 좌, 우로 1칸)
		if (check(nextr + dr[(d + 1) % 4], nextc + dc[(d + 1) % 4])) {
			int moveSand = (sand * 7) / 100;
			map[nextr + dr[(d + 1) % 4]][nextc + dc[(d + 1) % 4]] += moveSand;
			remain -= moveSand;
		}
		if (check(nextr - dr[(d + 1) % 4], nextc - dc[(d + 1) % 4])) {
			int moveSand = (sand * 7) / 100;
			map[nextr - dr[(d + 1) % 4]][nextc - dc[(d + 1) % 4]] += moveSand;
			remain -= moveSand;
		}

		// 2% 이동 (이동방향 좌, 우로 2칸)
		if (check(nextr + dr[(d + 1) % 4] * 2, nextc + dc[(d + 1) % 4] * 2)) {
			int moveSand = (sand * 2) / 100;
			map[nextr + dr[(d + 1) % 4] * 2][nextc + dc[(d + 1) % 4] * 2] += moveSand;
			remain -= moveSand;
		}
		if (check(nextr - dr[(d + 1) % 4] * 2, nextc - dc[(d + 1) % 4] * 2)) {
			int moveSand = (sand * 2) / 100;
			map[nextr - dr[(d + 1) % 4] * 2][nextc - dc[(d + 1) % 4] * 2] += moveSand;
			remain -= moveSand;
		}

		// 10% 이동 (이동방향으로 1칸, 이동방향 좌, 우로 한칸)
		if (check(frontr + dr[(d + 1) % 4], frontc + dc[(d + 1) % 4])) {
			int moveSand = sand / 10;
			map[frontr + dr[(d + 1) % 4]][frontc + dc[(d + 1) % 4]] += moveSand;
			remain -= moveSand;
		}
		if (check(frontr - dr[(d + 1) % 4], frontc - dc[(d + 1) % 4])) {
			int moveSand = sand / 10;
			map[frontr - dr[(d + 1) % 4]][frontc - dc[(d + 1) % 4]] += moveSand;
			remain -= moveSand;
		}

		// 1% 이동 (이동 전 위치에서 좌, 우로 한칸)
		if (check(prevr + dr[(d + 1) % 4], prevc + dc[(d + 1) % 4])) {
			int moveSand = sand / 100;
			map[prevr + dr[(d + 1) % 4]][prevc + dc[(d + 1) % 4]] += moveSand;
			remain -= moveSand;
		}
		if (check(prevr - dr[(d + 1) % 4], prevc - dc[(d + 1) % 4])) {
			int moveSand = sand / 100;
			map[prevr - dr[(d + 1) % 4]][prevc - dc[(d + 1) % 4]] += moveSand;
			remain -= moveSand;
		}

		if (check(frontr, frontc)) {
			map[frontr][frontc] += remain;
		}

		if (check(nextr, nextc)) {
			map[nextr][nextc] = 0;
		}

	}

	//
	public static int getTotalSand() {
		int sum = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				sum += map[r][c];
			}
		}
		return sum;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 1 && r <= N && c >= 1 && c <= N;
	}
}

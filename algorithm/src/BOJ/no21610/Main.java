// BOJ 21610번 마법사 상어와 비바라기
// https://www.acmicpc.net/problem/21610

package BOJ.no21610;

import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	// 격자의 크기 N, 이동 명령의 수 M
	static int N;
	static int M;
	static int[][] map;

	// 구름의 위치를 나타낼 배열 cloud
	// 이동 명령의 [3. 구름이 모두 사라진다] 에서 사라지는 구름의 위치를 나타낼 배열 disappeard
	static boolean[][] cloud;
	static boolean[][] disappeard;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N, M 입력
		N = sc.nextInt();
		M = sc.nextInt();

		// 격자판 생성 후 초기 상태 입력
		map = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// cloud 초기화 + 처음 구름의 위치 입력
		cloud = new boolean[N + 1][N + 1];
		cloud[N][1] = true;
		cloud[N][2] = true;
		cloud[N - 1][1] = true;
		cloud[N - 1][2] = true;

		// M개의 이동 명령 실행
		while (M-- > 0) {
			int d = sc.nextInt();
			int s = sc.nextInt();

			move(d, s);
		}

		// 결과 출력
		// 전체 물의 양 계산
		int count = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				count += map[r][c];
			}
		}
		System.out.println(count);
	}

	// 구름 이동 메소드
	public static void move(int direction, int distance) {
		// 배열 cloudCopy를 만들어서 구름이 이동할 위치에 표시
		boolean[][] cloudCopy = new boolean[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int nr = nextr(r + distance * dr[direction]);
				int nc = nextc(c + distance * dc[direction]);

				cloudCopy[nr][nc] = cloud[r][c];
			}
		}

		// 구름에서 비가 내려 구름이 있는 칸의 물의 양 1 증가
		// 증가 이후 구름이 사라짐 -> disappeard 배열에 입력
		disappeard = new boolean[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (cloudCopy[r][c]) {
					map[r][c]++;
					disappeard[r][c] = true;
				}
			}
		}

		// 물복사버그 마법 사용
		copy();

		// 바구니에 저장된 물의 양이 2 이상이면 구름 생성, 물의 양 2 감소
		// 단, 이전에 사라진 자리에는 생성 X
		cloud = new boolean[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (map[r][c] >= 2 && !disappeard[r][c]) {
					map[r][c] -= 2;
					cloud[r][c] = true;
				}
			}
		}
	}

	// 물복사버그 마법
	public static void copy() {
		// 배열을 순회하면서 바로 값을 변경시키면 다음 위치에 영향을 줄 수 있음
		// -> 한번에 변경시키기 위해 물이 늘어나는 양을 plus 배열에 저장
		int[][] plus = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				// 구름이 없어진 위치라면
				// 대각선 방향 4칸을 확인 후 물이 있는 바구니 수만큼 해당 칸에 물의 양 증가
				if (disappeard[r][c]) {
					int count = 0;
					for (int d = 2; d <= 8; d += 2) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (check(nr, nc) && map[nr][nc] != 0) {
							count++;
						}
					}
					plus[r][c] = count;
				}
			}
		}

		// plus 배열의 값만큼 추가
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (plus[r][c] > 0) {
					map[r][c] += plus[r][c];
				}
			}
		}
	}

	// 1번 행과 N번 행 연결
	public static int nextr(int r) {
		while (r > N) {
			r -= N;
		}
		while (r < 1) {
			r += N;
		}
		return r;
	}

	// 1번 열과 N번 열 연결
	public static int nextc(int c) {
		while (c > N) {
			c -= N;
		}
		while (c < 1) {
			c += N;
		}
		return c;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 1 && r <= N && c >= 1 && c <= N;
	}
}

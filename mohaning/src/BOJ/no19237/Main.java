// BOJ 19237번 어른 상어
// https://www.acmicpc.net/problem/19237

package BOJ.no19237;

import java.util.Scanner;

public class Main {
	// 탐색을 위한 델타 배열
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	// 격자의 크기 N, 상어의 수 M, 냄새가 사라지는데 걸리는 시간 K
	static int N;
	static int M;
	static int K;

	// 격자의 정보를 저장할 배열 map
	// map[r][c][0] : r행 c열의 현재 상어 유무(상어가 없으면 0, 있으면 상어 번호)
	// map[r][c][1] : r행 c열에 현재 남아있는 냄새(없으면 0, 있으면 해당 냄새를 뿌린 상어 번호)
	// map[r][c][2] : r행 c열에 위치한 냄새가 사라지기까지 남은 시간
	static int[][][] map;

	// 상어 정보를 저장할 배열 shark
	// shark[i][0] : i번째 상어의 현재 위치(행)
	// shark[i][1] : i번째 상어의 현재 위치(열)
	// shark[i][2] : i번째 상어가 보고있는 방향 (-1이면 해당 상어 X)
	static int[][] shark;

	// 각 상어의 방향 우선순위를 저장할 배열
	// priority[i][j][k] : i번 상어가 j번 방향을 볼 때의 k번째 우선순위
	static int[][][] priority;

	// 1번 상어만 남을때까지 걸리는 시간
	static int time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 변수 입력
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		// 배열 생성 후 격자 정보, 상어 정보 입력
		map = new int[N][N][3];
		shark = new int[M + 1][3];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c][0] = sc.nextInt();
				if (map[r][c][0] != 0) {
					shark[map[r][c][0]][0] = r;
					shark[map[r][c][0]][1] = c;
				}
			}
		}

		// 상어의 초기 방향 입력
		for (int i = 1; i <= M; i++) {
			shark[i][2] = sc.nextInt();
		}

		// 각 상어의 이동방향의 우선순위 입력
		priority = new int[M + 1][5][5];
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 4; k++) {
					priority[i][j][k] = sc.nextInt();
				}
			}
		}

		// 시간 0으로 초기화, 처음 위치에 냄새를 뿌린 후 시작
		int time = 0;
		for (int i = 1; i <= M; i++) {
			spread(i);
		}

		// 시간이 1000을 넘기면(초과하면) 종료
		while (time <= 1000) {
			time++;
			move();

			// 더 이상 1번 상어를 제외한 나머지 상어가 없으면 종료
			if (isEnd()) {
				break;
			}

		}

		// 결과 출력
		if (time > 1000) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}

	}

	// 상어 이동 메소드
	public static void move() {
		// 1번 상어부터 순차적으로 확인
		for (int i = 1; i <= M; i++) {
			// 해당 상어가 아직 남아있다면 현재 상어의 위치를 기준으로 탐색
			// 1. 주변에 냄새가 없는 칸이 있는지 확인 (현재 방향의 우선순위 순서대로)
			// -> 있다면 그 방향으로 이동 (한번에 이동해야 하므로 map 배열은 변경 X)
			if (shark[i][2] != -1) {
				int r = shark[i][0];
				int c = shark[i][1];

				boolean moved = false;
				for (int d = 1; d <= 4; d++) {
					int direction = priority[i][shark[i][2]][d];

					int nr = r + dr[direction];
					int nc = c + dc[direction];

					if (!check(nr, nc)) {
						continue;
					}

					if (map[nr][nc][1] == 0) {
						shark[i][0] = nr;
						shark[i][1] = nc;
						shark[i][2] = direction;
						moved = true;
						break;
					}
				}

				// 2. 주변에 냄새가 없는 칸이 없었다면 자신의 냄새가 남아있는 칸이 있는지 확인 (현재 방향의 우선순위 순서대로)
				// -> 있다면 그 방향으로 이동 (한번에 이동해야 하므로 map 배열은 변경 X)
				if (!moved) {
					for (int d = 1; d <= 4; d++) {
						int direction = priority[i][shark[i][2]][d];

						int nr = r + dr[direction];
						int nc = c + dc[direction];

						if (!check(nr, nc)) {
							continue;
						}
						if (map[nr][nc][1] == i) {
							shark[i][0] = nr;
							shark[i][1] = nc;
							shark[i][2] = direction;
							moved = true;
							break;
						}
					}
				}
			}
		}

		// 전체 map 배열 초기화
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c][0] = 0;
			}
		}

		// 번호가 작은 상어부터 map 배열에 위치 입력
		for (int i = 1; i <= M; i++) {
			if (shark[i][2] == -1) {
				continue;
			}

			int r = shark[i][0];
			int c = shark[i][1];

			// 빈 칸이라면 해당 위치에 상어 번호 입력
			if (map[r][c][0] == 0) {
				map[r][c][0] = i;
			}
			// 이미 상어가 있다면 해당 상어는 쫓겨나게 된 것이므로 shark 배열의 값을 -1로 갱신
			else {
				shark[i][0] = -1;
				shark[i][1] = -1;
				shark[i][2] = -1;
			}
		}

		// 현재 격자에 남아있는 냄새들의 지속시간 감소
		disappear();

		// 남아있는 상어들이 현재 위치에 냄새를 뿌리는 과정
		for (int i = 1; i <= M; i++) {
			if (shark[i][2] != -1) {
				spread(i);
			}
		}
	}

	// 상어가 현재 위치한 칸에 냄새를 뿌리는 메소드
	public static void spread(int idx) {
		int r = shark[idx][0];
		int c = shark[idx][1];

		map[r][c][1] = idx;
		map[r][c][2] = K;
	}

	// 냄새가 있는 모든 칸의 남은 지속시간을 감소시키는 메소드
	// 만약 지속시간이 다 지났다면 해당 칸의 냄새 제거
	public static void disappear() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c][2] > 0) {
					map[r][c][2]--;
				}
				if (map[r][c][1] != 0 && map[r][c][2] == 0) {
					map[r][c][1] = 0;
				}
			}
		}
	}

	// 1번 상어를 제외하고 모두 격자 밖으로 나갔는지 확인하는 메소드
	public static boolean isEnd() {
		for (int i = 2; i <= M; i++) {
			if (shark[i][2] != -1) {
				return false;
			}
		}
		return true;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}

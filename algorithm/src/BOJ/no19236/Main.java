// BOJ 19236번 청소년 상어
// https://www.acmicpc.net/problem/19236

package BOJ.no19236;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

	// 물고기 정보
	static int[][] map = new int[4][4]; // 현재 각 지역의 상태
	static int[][] fish = new int[17][3]; // 물고기가 향한 방향

	// 최대 점수
	static int maxResult = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// map, fish 정보 추가
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				map[r][c] = sc.nextInt();

				fish[map[r][c]][0] = r;
				fish[map[r][c]][1] = c;
				fish[map[r][c]][2] = sc.nextInt() - 1;
			}
		}

		// 가장 왼쪽 위에 있는 물고기를 먹고 시작
		// 상어의 방향 = 먹은 물고기의 방향
		int startd = fish[map[0][0]][2];
		int startsum = map[0][0];

		// fish, map 변경
		fish[map[0][0]][2] = 8;
		map[0][0] = 17;

		// 최대 점수 계산
		getMax(0, 0, startd, startsum);

		// 결과 출력
		System.out.println(maxResult);

	}

	// 최대 점수 계산
	public static void getMax(int r, int c, int d, int sum) {
		// 기존 최대값과 비교 후 갱신
		maxResult = Math.max(maxResult, sum);
		
		// 물고기 이동
		fishMove();

		// 현재 방향으로 이동
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		// 경계를 벗어나지 않는 한계 내에서 반복
		while (check(nr, nc)) {
			// 해당 위치에 물고기가 있는 경우
			if (map[nr][nc] != 0 && map[nr][nc] != 17) {
				// 해당 위치의 물고기 번호와 방향 저장
				int fishNum = map[nr][nc];
				int fishd = fish[fishNum][2];

				// 상어 이동 전 상태 저장
				// 1. map 배열 저장 -> mapCopy
				int[][] mapCopy = new int[4][4];
				for (int i = 0; i < 4; i++) {
					mapCopy[i] = Arrays.copyOf(map[i], map[i].length);
				}
				// 2. fish 배열 저장 -> fishCopy
				int[][] fishCopy = new int[17][3];
				for (int i = 0; i < 17; i++) {
					fishCopy[i] = Arrays.copyOf(fish[i], fish[i].length);
				}

				// 상어 이동 후 해당 위치에서 getMax 실시
				map[r][c] = 0;
				sharkMove(fishNum);
				getMax(nr, nc, fishd, sum + fishNum);

				// 상태 복구
				// 1. map 배열 복구
				for (int i = 0; i < 4; i++) {
					map[i] = mapCopy[i];
				}
				
				// 2. fish 배열 복구
				for (int i = 0; i < 17; i++) {
					fish[i] = fishCopy[i];
				}
			}

			// 다음 칸으로 이동
			nr += dr[d];
			nc += dc[d];
		}

	}

	// 상어 이동
	public static void sharkMove(int targetFish) {
		int nextr = fish[targetFish][0];
		int nextc = fish[targetFish][1];
		map[nextr][nextc] = 17;

		fish[targetFish][2] = 8;
	}

	// 물고기 이동
	public static void fishMove() {
		for (int i = 1; i < 17; i++) {
			if (fish[i][2] != 8) {
				int r = fish[i][0];
				int c = fish[i][1];
				for (int dd = 0; dd < 8; dd++) {
					int d = (fish[i][2] + dd) % 8;

					int nr = r + dr[d];
					int nc = c + dc[d];

					// 해당 방향의 다음 칸이 빈 칸 이라면 해당 칸으로 이동
					if (check(nr, nc) && map[nr][nc] == 0) {
						map[nr][nc] = i;
						map[r][c] = 0;
						
						fish[i][0] = nr;
						fish[i][1] = nc;
						fish[i][2] = d;
						break;
					}
					// 해당 방향의 다음 칸에 다른 물고기가 있다면 위치 교환
					if (check(nr, nc) && map[nr][nc] != 17) {
						fishSwap(i, map[nr][nc]);
						fish[i][2] = d;
						break;
					}
				}
			}
		}
	}

	// 두 물고기의 위치 교환 메소드
	public static void fishSwap(int i, int j) {
		// 1. map 배열 수정
		// j의 현재 위치에 i 입력
		map[fish[j][0]][fish[j][1]] = i;
		// i의 현재 위치에 j 입력
		map[fish[i][0]][fish[i][1]] = j;

		// 2. fish 배열 수정
		int tmpr = fish[i][0];
		int tmpc = fish[i][1];
		fish[i][0] = fish[j][0];
		fish[i][1] = fish[j][1];
		fish[j][0] = tmpr;
		fish[j][1] = tmpc;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}
}

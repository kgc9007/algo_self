// BOJ 14502번 연구소

package BOJ.no14502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	// 지도의 가로, 세로 크기 N, M과 지도 정보를 저장할 배열 map
	static int N;
	static int M;
	static int[][] map;

	// 안전영역의 최대 크기 maxSafeArea
	static int maxSafeArea;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 지도의 크기 N, M 입력
		N = sc.nextInt();
		M = sc.nextInt();

		// N * M 크기의 지도에 정보 입력
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		// 최대 안전영역의 크기 계산
		addWall(0, 0, 0);
		
		// 결과 출력
		System.out.println(maxSafeArea);

	}

	// 벽을 추가하는 메소드
	// startr, startc 부터 벽을 추가하도록 설정
	// -> 똑같은 경우를 여러 번 확인하지 않도록 구현
	public static void addWall(int startr, int startc, int count) {
		if (count == 3) {
			// 바이러스가 퍼지기 전 상태를 tmp로 저장
			int[][] tmp = new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					tmp[r][c] = map[r][c];
				}
			}
			
			// 바이러스가 있는 구역을 찾고 spread 실시
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 2) {
						spread(new int[] { r, c });
					}
				}
			}
			// 해당 경우의 안전영역의 크기를 계산하고
			// 기존 최댓값과 비교 후 갱신
			int safeArea = getSafeArea();
			maxSafeArea = Math.max(maxSafeArea, safeArea);
			
			// map을 원래 상태로 복구
			map = tmp;
			
			return;
		}

		for (int r = startr; r < N; r++) {
			for (int c = startc; c < M; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					addWall(startr, startc, count + 1);
					map[r][c] = 0;
				}
			}
		}
	}

	// bfs
	// 바이러스가 퍼져나갈 수 있는 곳의 값을 2로 변경
	public static void spread(int[] start) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(start);

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}

	// 안전영역의 크기를 계산하는 메소드
	public static int getSafeArea() {
		// 안전영역의 크기를 0으로 초기화
		int safeArea = 0;

		// 모든 구역을 순차적으로 탐색하여 해당 구역이 빈 칸이면 안전영역의 크기++
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					safeArea++;
				}
			}
		}
		// 결과(안전영역의 크기) 반환
		return safeArea;
	}
}

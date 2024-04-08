// BOJ 17135번 캐슬 디펜스
// https://www.acmicpc.net/problem/17135

package BOJ.no17135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 델타배열
	static int[] dr = { 0, -1, 0 };
	static int[] dc = { -1, 0, 1 };

	// 격자판의 크기 N * M, 궁수의 공격 제한 거리 D
	static int N;
	static int M;
	static int D;
	static int[][] map;

	// bfs에 사용할 distance 배열(visited 역할 + 거리를 나타내는 배열)
	static int[][] distance;

	// 조합을 위한 변수 selected(궁수를 배치하기로 선택된 위치 표시)
	static boolean[] selected;

	// 제거할 적을 저장할 리스트
	static List<int[]> list;

	// 제거할 수 있는 적의 수의 최대값 max
	static int max = 0;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		selected = new boolean[M];
		getCombination(0, 0);

		// 결과 출력
		System.out.println(max);
	}

	// 조합
	public static void getCombination(int idx, int archers) {
		// 궁수를 배치할 위치를 모두 정한 경우
		if (archers == 3) {
			// 원상복구시키기 위해 배열을 미리 복사
			int[][] copy = new int[N][M];
			for (int r = 0; r < N; r++) {
				copy[r] = Arrays.copyOf(map[r], M);
			}

			// 제거할 수 있는 적의 수 count를 0으로 초기화
			count = 0;
			// 모든 적이 사라질 때까지 반복
			while (!isEnd()) {
				kill();
				move();
			}

			// map 배열을 원래 상태로 복구
			for (int r = 0; r < N; r++) {
				map[r] = copy[r];
			}

			// 최대값 갱시
			max = Math.max(count, max);
			return;
		}

		// 끝까지 궁수 배치 여부를 정한 경우
		if (idx == M) {
			return;
		}

		// 해당 자리에 궁수 배치 X
		selected[idx] = true;
		getCombination(idx + 1, archers + 1);

		// 해당 자리에 궁수 배치 O
		selected[idx] = false;
		getCombination(idx + 1, archers);
	}

	// 적을 제거하는 메소드
	public static void kill() {
		list = new ArrayList<>();

		for (int c = 0; c < M; c++) {
			if (!selected[c]) {
				continue;
			}

			distance = new int[N][M];
			bfs(new int[] { N - 1, c });
		}

		// 리스트의 위치에 해당하는 map 배열의 위치에 적이 있다면 count++, map 배열에서 적 제거
		for (int i = 0; i < list.size(); i++) {
			int[] enemy = list.get(i);
			if (map[enemy[0]][enemy[1]] == 1) {
				map[enemy[0]][enemy[1]] = 0;
				count++;
			}
		}

	}

	// bfs
	public static void bfs(int[] front) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(front);
		distance[front[0]][front[1]] = 1;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			int r = curr[0];
			int c = curr[1];

			if (distance[r][c] > D) {
				return;
			}
			if (map[r][c] == 1) {
				list.add(new int[] { r, c });
				return;
			}

			for (int d = 0; d < 3; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && distance[nr][nc] == 0) {
					distance[nr][nc] = distance[r][c] + 1;
					queue.add(new int[] { nr, nc });
				}

			}

		}
	}

	// 적이 아래로 한 칸 이동하는 메소드
	public static void move() {
		for (int r = N - 1; r > 0; r--) {
			for (int c = 0; c < M; c++) {
				map[r][c] = map[r - 1][c];
			}
		}
		for (int c = 0; c < M; c++) {
			map[0][c] = 0;
		}
	}

	// 게임이 종료되었는지 확인하는 메소드
	public static boolean isEnd() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}

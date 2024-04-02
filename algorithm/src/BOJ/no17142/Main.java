// BOJ 17142번 연구소 3
// https://www.acmicpc.net/problem/17142

package BOJ.no17142;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 상, 하, 좌, 우 탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 연구소의 크기 N(가로, 세로 길이)
	// 연구소의 각 구역의 정보를 나타낼 배열 map
	// 해당 위치에 바이러스가 퍼지는데(활성화 되는데) 걸리는 시간 visited
	static int N;
	static int[][] map;
	static int[][] visited;

	// 활성화 시킬 수 있는 바이러스의 수 M
	static int M;

	// 전체 바이러스 위치를 저장할 리스트 virus
	// 처음에 활성화 시킬지 여부를 저장할 배열 selected
	static List<int[]> virus;
	static boolean[] selected;

	static int minTime = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 연구소 크기 N, 활성화시킬 바이러스 개수 M 입력
		N = sc.nextInt();
		M = sc.nextInt();

		// 연구소 정보 입력
		// 0 : 빈 칸, 1 : 벽, 2 : 바이러스
		map = new int[N][N];
		virus = new ArrayList<int[]>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();

				// 해당 구역에 바이러스가 있으면 리스트에 추가
				if (map[r][c] == 2) {
					virus.add(new int[] { r, c });
				}
			}
		}

		// selected배열 초기화 후 조합 실시
		selected = new boolean[virus.size()];
		getCombination(0, 0);

		// 결과 출력
		int result = (minTime != Integer.MAX_VALUE) ? minTime : -1;
		System.out.println(result);
	}

	// 조합
	public static void getCombination(int idx, int count) {
		// M개의 바이러스가 정해지면 확산 -> 전체 구역에 바이러스가 퍼지는데 걸리는 최소시간 갱신
		if (count == M) {
			spread();
			return;
		}

		// M개의 바이러스가 결정되지 않은채로 마지막 바이러스까지 사용 여부를 결정한 경우
		if (idx == virus.size()) {
			return;
		}

		// 해당 바이러스(idx번째 바이러스) 선택 O
		selected[idx] = true;
		getCombination(idx + 1, count + 1);

		// 해당 바이러스(idx번째 바이러스) 선택 X
		selected[idx] = false;
		getCombination(idx + 1, count);
	}

	// 바이러스가 퍼지는 시간 계산
	public static void spread() {
		// visited 초기화 후 bfs 실시
		visited = new int[N][N];
		bfs();

		// 전체 구역 중 바이러스가 퍼지는 데 가장 오래 걸린 시간 max
		int max = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 빈 칸이 아닌 경우(비활성 바이러스나 벽) continue
				if (map[r][c] != 0) {
					continue;
				}

				// 기존 최대값보다 오래 걸린 구역이 있다면 갱신
				// 아직 퍼지지 않은 빈 칸이 있다면 return
				if (visited[r][c] > max) {
					max = visited[r][c] - 1;
				} else if (visited[r][c] == 0) {
					return;
				}
			}
		}

		minTime = Math.min(minTime, max);
	}

	// bfs
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();

		// 선택된 바이러스 큐에 추가
		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) {
				queue.add(virus.get(i));
				visited[virus.get(i)[0]][virus.get(i)[1]] = 1;
			}
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 해당 위치에 벽이 아니면서 아직 바이러스가 활성화되지 않은 경우(빈 칸이거나 바이러스가 비활성)
				if (check(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] != 1) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}

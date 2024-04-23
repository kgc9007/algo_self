// BOJ 11559번 Puyo Puyo
// https://www.acmicpc.net/problem/11559

package BOJ.no11559;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 필드의 크기 : 12(행) * 6(열)
	static int N = 12;
	static int M = 6;
	static char[][] map = new char[N][M];

	// bfs를 위한 방문배열
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 필드 정보 입력
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c);
			}
		}

		// 더 이상 터질 수 있는 뿌요가 없을 때까지 반복
		boolean isEnd = false;
		int time = -1;
		while (!isEnd) {
			time++;
			// 방문 배열 초기화 후 전체 필드를 순회하며 bfs 실시
			visited = new boolean[N][M];
			isEnd = true;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != '.' && !visited[r][c]) {
						boolean exploded = bfs(r, c, map[r][c]);

						// bfs 결과 뿌요가 4개 이상 모여 터지게 되었다면 isEnd = false로 변경
						if (exploded) {
							isEnd = false;
						}
					}
				}
			}
			// 중력의 영향을 받아 뿌요들이 아래로 떨어지는 과정
			move();
		}

		// 결과 출력
		System.out.println(time);

	}

	// bfs
	public static boolean bfs(int startr, int startc, char color) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { startr, startc });

		List<int[]> list = new ArrayList<>();
		int count = 0;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] == color) {
					count++;
					visited[nr][nc] = true;
					list.add(new int[] { nr, nc });

					queue.add(new int[] { nr, nc });
				}
			}
		}

		// 4개 이상 연결되지 않았다면
		// 1. 변화 X
		// 2. false 반환
		if (count < 4) {
			return false;
		}

		// 4개 이상 연결되어 있다면
		// 1. 뿌요들이 터지고 -> map 배열 변경
		// 2. true 반환
		for (int i = 0; i < list.size(); i++) {
			map[list.get(i)[0]][list.get(i)[1]] = '.';
		}
		return true;
	}

	// 뿌요들이 터진 후 남은 뿌요들이 이동하는 메소드
	public static void move() {
		// 각 열별로 가장 마지막 행부터 순서대로 확인
		// 뿌요가 남아있다면 리스트에 추가
		for (int c = 0; c < M; c++) {
			List<Character> list = new ArrayList<>();
			for (int r = N - 1; r >= 0; r--) {
				if (map[r][c] != '.') {
					list.add(map[r][c]);
				}
			}

			// 리스트에 추가된 순으로 가장 아래 행부터 map에 입력
			int idx = N - 1;
			for (int i = 0; i < list.size(); i++) {
				map[idx--][c] = list.get(i);
			}
			// 남은 칸은 모두 '.'으로 입력
			for (int i = list.size(); i < N; i++) {
				map[idx--][c] = '.';
			}
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}

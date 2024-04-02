// BOJ 21736번 헌내기는 친구가 필요해
// https://www.acmicpc.net/problem/21736

package BOJ.no21736;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 캠퍼스 크기 N, M
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 지도, 방문배열 생성
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];

		// 시작 위치(도연이의 첫 위치)
		int[] start = new int[2];

		// 지도 정보 입력
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == 'I') {
					start = new int[] { r, c };
				}
			}
		}

		// bfs
		int count = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				} else {
					// 아직 방문 X, 벽이 아니면 탐색 가능
					if (!visited[nr][nc] && map[nr][nc] != 'X') {
						// 사람을 만나면 count++
						if (map[nr][nc] == 'P') {
							count++;
						}
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
					}
				}
			}
		}

		// 결과 출력
		if (count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
	}
}

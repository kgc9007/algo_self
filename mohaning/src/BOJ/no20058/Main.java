// BOJ 20058번 마법사 상어와 파이어스톰
// https://www.acmicpc.net/problem/20058

package BOJ.no20058;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 격자판의 크기 2^N(length) * 2^N(length)
	static int N;
	static int length;
	static int[][] map;

	// 파이어스톰의 총 시전횟수 Q
	// 각 파이어스톰을 시전한 단계를 저장할 배열 level
	static int Q;
	static int[] level;

	// bfs(dfs)를 위한 방문배열
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정보 입력 - 격자판의 크기, 파이어스톰 시전 횟수
		N = sc.nextInt();
		Q = sc.nextInt();

		// 정보 입력 - 격자판 정보(얼음 크기)
		length = (int) Math.pow(2, N);
		map = new int[length][length];
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < length; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 정보 입력 - 시전할 파이어스톰의 단계
		level = new int[Q];
		for (int i = 0; i < Q; i++) {
			level[i] = sc.nextInt();
		}

		// 파이어스톰 시전
		for (int i = 0; i < Q; i++) {
			firestorm(level[i]);
		}

		// 결과 출력
		System.out.println(getSum());
		System.out.println(getMax());
	}

	// 파이어스톰!!
	public static void firestorm(int level) {
		rotate(level);
		decrease();
	}

	// 격자를 부분 격자로 나누고 회전시키는 메소드
	public static void rotate(int level) {
		// map 배열 복사
		int[][] copy = new int[length][length];
		for (int r = 0; r < length; r++) {
			copy[r] = Arrays.copyOf(map[r], length);
		}

		// 부분 격자의 크기 smallLength
		int smallLength = (int) Math.pow(2, level);

		// 각 부분격자마다 반복
		for (int startr = 0; startr < length; startr += smallLength) {
			for (int startc = 0; startc < length; startc += smallLength) {
				// copy 배열의 값을 기준으로 설정하고 배열 회전 결과 입력
				for (int r = 0; r < smallLength; r++) {
					for (int c = 0; c < smallLength; c++) {
						map[startr + c][startc + smallLength - 1 - r] = copy[startr + r][startc + c];
					}
				}
			}
		}
	}

	// 주변 탐색 후 얼음의 양을 감소시키는 메소드
	public static void decrease() {
		// 순차적으로 탐색하며 바로 얼음의 양을 감소시키면 X
		// -> 얼음의 양을 감소시킬지 여부를 저장할 배열 toBeDecreased 생성
		boolean[][] toBeDecreased = new boolean[length][length];

		// 전체 map 배열을 순회하며 3곳 이상 얼음이 있는 칸과 인접하고 있는지 확인
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < length; c++) {
				if (map[r][c] == 0) {
					continue;
				}

				int count = 0;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (check(nr, nc) && map[nr][nc] != 0) {
						count++;
					}
				}

				// 3칸 이상 얼음이 있는 칸과 인접하고 있다면 해당 칸의 얼음의 양 1 감소 예정
				if (count < 3) {
					toBeDecreased[r][c] = true;
				}
			}
		}

		// 전체 배열 갱신(얼음 양 감소)
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < length; c++) {
				if (toBeDecreased[r][c]) {
					map[r][c]--;
				}
			}
		}
	}

	// 남아있는 얼음의 합을 구하는 메소드
	public static int getSum() {
		int sum = 0;

		for (int r = 0; r < length; r++) {
			for (int c = 0; c < length; c++) {
				sum += map[r][c];
			}
		}

		return sum;
	}

	// 남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수를 구하는 메소드
	public static int getMax() {
		int max = 0;

		visited = new boolean[length][length];

		for (int r = 0; r < length; r++) {
			for (int c = 0; c < length; c++) {
				if (!visited[r][c] && map[r][c] != 0) {
					visited[r][c] = true;
					int size = bfs(new int[] { r, c });
					max = Math.max(max, size);
				}
			}
		}

		return max;
	}

	// bfs
	// 연결되어 있는 얼음 덩어리의 크기 반환
	public static int bfs(int[] start) {
		int count = 1;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
					count++;
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}
			}
		}

		return count;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < length && c >= 0 && c < length;
	}
}

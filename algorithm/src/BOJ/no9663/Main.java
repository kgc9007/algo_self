// BOJ 9663번 N-Queen

package BOJ.no9663;

import java.util.Scanner;

public class Main {
	// 탐색을 위한 델타배열
	static int[] dr = { -1, -1, -1 };
	static int[] dc = { -1, 0, 1 };

	static int N;
	static boolean[][] board;

	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		board = new boolean[N][N];

		// count 초기화 후 백트래킹 실시
		count = 0;
		solve(0);

		// 결과 출력
		System.out.println(count);

	}

	// 백트래킹
	public static void solve(int r) {
		// 마지막 행까지 퀸을 추가한 후 서로 공격하지 않으면 
		// -> count를 증가시킨 후 return
		if (r == N) {
			count++;
			return;
		}

		// 마지막 행 이전의 경우
		// 0번 열부터 순서대로 퀸을 놓아보고 이미 놓아진 퀸과 서로 공격하지 않는지 확인
		// 서로 공격하지 않는다면 -> possible = true, 다음 행으로 이동
		// 서로 공격한다면 -> possible = false, 다음 열로 이동
		for (int c = 0; c < N; c++) {
			board[r][c] = true;

			boolean possible = true;
			for (int d = 0; d < 3; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (board[nr][nc]) {
						possible = false;
						break;
					}
					nr += dr[d];
					nc += dc[d];
				}
				if (!possible) {
					break;
				}
			}
			if (possible) {
				solve(r + 1);
			}
			board[r][c] = false;
		}
	}
}

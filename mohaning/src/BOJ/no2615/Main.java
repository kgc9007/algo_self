// BOJ 2615 오목

package BOJ.no2615;

import java.util.Scanner;

public class Main {

	// 바둑판 정보를 저장할 배열 board
	static int[][] board = new int[19][19];
	
	// 검은색 또는 흰색이 이겼을 경우 가장 왼쪽 위에 위치한 바둑알의 위치 startr, startc 
	static int startr;
	static int startc;

	// 델타배열 생성
	static int[] dr = { 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 바둑판 정보 입력
		for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				board[r][c] = sc.nextInt();
			}
		}

		// 결과
		int result = check();

		// 결과 출력
		// 무승부라면 0 출력
		// 검은색 (또는 흰색)이 이긴 경우 1 (2) 출력 후 
		// 다음줄에 가장 왼쪽 위에 있는 바둑알의 위치 출력
		if (result == 0) {
			System.out.println(result);
		} else {
			System.out.println(result);
			System.out.printf("%d %d", startr, startc);
		}

	}

	// 결과 확인 메소드
	public static int check() {
		// 첫번째 열부터 마지막 열까지
		// 첫번째 행부터 한칸씩 아래로 이동하며
		// 1 또는 2가 있으면 아래, 오른쪽, 우상향, 우하향 방향으로 탐색 실시 (델타배열 이용)
		for (int c = 0; c < 19; c++) {
			for (int r = 0; r < 19; r++) {
				// 1(검은색 바둑돌)인 경우
				if (board[r][c] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = r;
						int nc = c;
						int count = 0;
						// 바둑판을 벗어나거나 1이 아닐때까지 반복하며 count++
						while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == 1) {
							count++;
							nr += dr[d];
							nc += dc[d];
						}
						// 5개가 이어진 경우
						if (count == 5) {
							nr = r - dr[d];
							nc = c - dc[d];
							// 반대 방향으로 한 칸 이동했을 때 바둑판을 벗어나지 않으면
							// 육목인지 아닌지 확인 - 반대방향도 1이라면 육목
							if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
								if (board[nr][nc] != 1) {
									startr = r + 1;
									startc = c + 1;
									return 1;									
								}
							} else { // 반대방향으로 한 칸 이동시 바둑판을 벗어나면 육목 체크할 필요 X
								startr = r + 1;
								startc = c + 1;
								return 1;								
							}
						}
					}
				}
				
				// 2(흰색 바둑돌)인 경우
				if (board[r][c] == 2) {
					for (int d = 0; d < 4; d++) {
						int nr = r;
						int nc = c;
						int count = 0;
						// 바둑판을 벗어나거나 2가 아닐때까지 반복하며 count++
						while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == 2) {
							count++;
							nr += dr[d];
							nc += dc[d];
						}
						// 5개가 이어진 경우
						if (count == 5) {
							nr = r - dr[d];
							nc = c - dc[d];
							// 반대 방향으로 한 칸 이동했을 때 바둑판을 벗어나지 않으면
							// 육목인지 아닌지 확인 - 반대방향도 1이라면 육목
							if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
								if (board[nr][nc] != 2) {
									startr = r + 1;
									startc = c + 1;
									return 2;									
								}
							} else { // 반대방향으로 한 칸 이동시 바둑판을 벗어나면 육목 체크할 필요 X
								startr = r + 1;
								startc = c + 1;
								return 2;								
							}
						}
					}
				}
			}
		}
		// 승부가 나지 않으면 0 반환
		return 0;
	}
}
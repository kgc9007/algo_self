// SWEA 7236번 저수지의 물의 총 깊이 구하기

package SWEA.no7236;

import java.util.Scanner;

public class Solution {

	// 팔방탐색을 위한 델타배열 생성
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 전체 테스트 케이스의 수 입력, 테스트 케이스 번호 0으로 초기화
		int T = sc.nextInt();
		int testCase = 0;

		while (T-- > 0) {
			testCase++;
			
			// 저수지 구획의 크기 N 입력
			int N = sc.nextInt();

			// N*N 배열 map 생성 후 저수지 구획의 지역 정보 입력
			// W / G으로 구성
			char[][] map = new char[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.next().charAt(0);
				}
			}
			
			// 최대 깊이 0으로 초기화
			int maxDepth = 0;
			// [0][0]부터 [N-1][N-1]까지 전체 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 해당 위치가 W이면
					if (map[r][c] == 'W') {
						// depth = 0으로 초기화 후 8방탐색 실시
						int depth = 0;
						for (int d = 0; d < 8; d++) {
							// 경계를 벗어나지 않고 인접한 지역이 W이면 depth++
							if (r + dr[d] >= 0 && r + dr[d] < N && c + dc[d] >= 0 && c + dc[d] < N
									&& map[r + dr[d]][c + dc[d]] == 'W') {
								depth++;
							}
						}

						// 팔방탐색 후 depth가 0이면 depth를 최소값인 1로 변경
						if (depth == 0) {
							depth = 1;
						}
						
						// depth가 기존 maxDepth보다 크면 갱신
						if (depth > maxDepth) {
							maxDepth = depth;
						}
					}
				}
			}

			// 결과 출력
			System.out.printf("#%d %d%n", testCase, maxDepth);
		}

	}
}

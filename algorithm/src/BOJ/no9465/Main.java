// BOJ 9465번 스티커
// https://www.acmicpc.net/problem/9465

package BOJ.no9465;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		while (T-- > 0) {
			// 스티커 길이 N
			int N = sc.nextInt();

			// 스티커 정보를 배열에 입력
			int[][] sticker = new int[2][N];
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < N; c++) {
					sticker[r][c] = sc.nextInt();
				}
			}

			// dp 배열 생성
			int[][] dp = new int[2][N];

			// 첫번째 열은 기존 배열 값 그대로 입력
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];

			// 두번째 열부터는 더 큰 값을 비교 후 입력
			for (int c = 1; c < N; c++) {
				dp[0][c] = Math.max(dp[0][c - 1], dp[1][c - 1] + sticker[0][c]);
				dp[1][c] = Math.max(dp[1][c - 1], dp[0][c - 1] + sticker[1][c]);
			}

			// 마지막 열에서 최종 최대값 계산
			int max = Math.max(dp[0][N - 1], dp[1][N - 1]);

			// 결과 출력
			System.out.println(max);
		}
	}
}

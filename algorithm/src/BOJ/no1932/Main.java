// BOJ 1932번 정수 삼각형
// https://www.acmicpc.net/problem/1932

package BOJ.no1932;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 삼강형의 높이 N 입력
		int N = sc.nextInt();

		// 삼각형 정보 입력
		int[][] triangle = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < r + 1; c++) {
				triangle[r][c] = sc.nextInt();
			}
		}

		// dp 배열 생성
		// dp[r][c] : r행 c열까지 선택된 수의 합의 최대값
		int[][] dp = new int[N][N];
		// 맨 위층의 값 입력(시작점)
		dp[0][0] = triangle[0][0];
		// 가장 왼쪽 줄과 오른쪽 줄은 가능한 길이 한가지 뿐이므로 바로 계산
		for (int r = 1; r < N; r++) {
			dp[r][0] = dp[r - 1][0] + triangle[r][0];
			dp[r][r] = dp[r - 1][r - 1] + triangle[r][r];
		}
		// 나머지 위치의 경우 2가지 길 중 더 숫자의 합이 큰 경우를 선택
		for (int r = 2; r < N; r++) {
			for (int c = 1; c < r; c++) {
				dp[r][c] = Math.max(dp[r - 1][c - 1], dp[r - 1][c]) + triangle[r][c];
			}
		}

		// 최대값 확인
		int max = 0;
		for (int c = 0; c < N; c++) {
			max = Math.max(max, dp[N - 1][c]);
		}

		// 결과 출력
		System.out.println(max);
	}
}

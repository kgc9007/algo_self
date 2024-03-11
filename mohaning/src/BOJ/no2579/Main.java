// BOJ 2579번 계단 오르기

package BOJ.no2579;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 계단의 개수 N 입력
		int N = sc.nextInt();
		
		// 각 계단의 점수를 배열 score에 입력
		int[] score = new int[N];

		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}

		// dp[i] : i번째 계단에 도착했을 때 얻을 수 있는 최고 점수
		int[] dp = new int[N];

		// dp[0], dp[1], dp[2] 입력
		dp[0] = score[0];
		if (N >= 2) {
			dp[1] = Math.max(score[0] + score[1], score[1]);
		}
		if (N >= 3) {
			dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);			
		}

		// i번째 칸에 도착하는 경우
		// 1. i-2번 칸에서 2칸 위로 올라오는 경우
		// 2. i-3번 칸에서 2칸, 1칸씩 올라오는 경우
		// -> 3칸을 연속으로 이동할 수 없기 때문에 위의 방식으로 계산
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
		}
		
		// 결과 출력
		System.out.println(dp[N - 1]);
	}
}

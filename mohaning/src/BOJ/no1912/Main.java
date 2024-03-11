// BOJ 1912번 연속합

package BOJ.no1912;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 수열의 길이 N 입력
		int N = sc.nextInt();
		
		// 수열의 정보 입력
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		// 최댓값 초기화
		int max = Integer.MIN_VALUE;

		// dp[i] : i번째 숫자를 마지막으로 하는 수열의 합의 최댓값
		int[] dp = new int[N];
		
		// dp[0] 입력
		// dp[0]과 최대값 비교 후 최댓값 갱신
		dp[0] = num[0];
		max = Math.max(max, dp[0]);
		
		// dp[1] ~ dp[N-1] 계산
		// dp[i] 계산 후 max 값 갱신
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
			max = Math.max(max, dp[i]);
		}
		
		// 결과 출력
		System.out.println(max);
	}
}

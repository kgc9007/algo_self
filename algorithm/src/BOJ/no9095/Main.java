// BOJ 9095번 1, 2, 3 더하기
// https://www.acmicpc.net/problem/9095

package BOJ.no9095;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			// dp[N] 계산 방법
			// [N - 1] + 1 로 만드는 경우의 수
			// [N - 2] + 2 로 만드는 경우의 수
			// [N - 3] + 3 로 만드는 경우의 수
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();

			System.out.println(dp[N]);
		}
	}
}

// BOJ 15989번 1, 2, 3 더하기 4
// https://www.acmicpc.net/problem/15989

package BOJ.no15989;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] dp = new int[10001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i <= 10000; i++) {
			dp[i] = dp[i - 3] + (i / 2) + 1;
		}

		while (T-- > 0) {
			int n = sc.nextInt();
			
			System.out.println(dp[n]);
		}
	}
}

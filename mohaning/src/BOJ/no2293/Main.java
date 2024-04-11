// BOJ 2293번 동전 1
// https://www.acmicpc.net/problem/2293

package BOJ.no2293;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 동전 종류의 수 N, 만들려고 하는 가치의 합 K 입력
		int N = sc.nextInt();
		int K = sc.nextInt();

		// 각 동전의 가치를 배열 coin에 입력
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		int[][] dp = new int[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			dp[i][0] = 1;
		}

	}
}

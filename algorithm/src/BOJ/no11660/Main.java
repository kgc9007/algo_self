// BOJ 11660번 구간 합 구하기 5
// https://www.acmicpc.net/problem/11660

package BOJ.no11660;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		// 표 생성 후 정보(숫자) 입력
		int[][] table = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				table[r][c] = sc.nextInt();
			}
		}

		// 누적합 배열 생성 후 값 입력(DP)
		int[][] prefixSum = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				prefixSum[r][c] = prefixSum[r][c - 1] + table[r][c];
			}
			for (int c = 1; c <= N; c++) {
				prefixSum[r][c] += prefixSum[r - 1][c];
			}

		}

		// M번 계산 
		while (M-- > 0) {
			int startr = sc.nextInt();
			int startc = sc.nextInt();
			int endr = sc.nextInt();
			int endc = sc.nextInt();

			int result = prefixSum[endr][endc] + prefixSum[startr - 1][startc - 1] - prefixSum[startr - 1][endc]
					- prefixSum[endr][startc - 1];

			// 결과 출력
			System.out.println(result);
		}
	}
}

// BOJ 1806번 부분합
// https://www.acmicpc.net/problem/1806

package BOJ.no1806;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열의 길이 N, 부분합의 최소값 S 입력
		int N = sc.nextInt();
		int S = sc.nextInt();

		// 수열 입력
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 누적합 배열 입력
		int[] prefixSum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
		}

		// 누적합이 S보다 작으면
		// -> S 이상의 부분합을 만들 수 없으므로 0 출력
		if (prefixSum[N] < S) {
			System.out.println(0);
		}
		// 이외의 경우 구하고자 하는 최소 길이 계산
		else {
			// 최소 길이 초기화
			int minLength = Integer.MAX_VALUE;

			// 투포인터, 누적합을 이용해 부분합이 S이상인 최소 길이 계산
			// [풀이방법]
			// idx1 : 0부터 1씩 증가시키면서 확인
			// idx2 : 1부터 증가시키면서 확인
			// sum(부분합) = prefixSum[idx2] - prefixSum[idx1]
			// sum(부분합)이 S보다 크면 idx1++
			// sum(부분합)이 S보다 작으면 idx2++ (M보다 커질때까지 반복)
			// 조건 1. idx1, idx2 <= N
			// 조건 2. idx1 < idx2 (-> idx1 <= N - 1)
			int idx2 = 1;
			for (int idx1 = 0; idx1 < N; idx1++) {
				if (idx2 <= idx1) {
					idx2 = idx1 + 1;
				}
				while (idx2 <= N) {
					int sum = prefixSum[idx2] - prefixSum[idx1];
					if (sum >= S) {
						minLength = Math.min(idx2 - idx1, minLength);
						break;
					}
					idx2++;
				}
			}

			// 결과 출력
			System.out.println(minLength);
		}

	}
}

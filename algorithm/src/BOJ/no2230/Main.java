// BOJ 2230번 수 고르기
// https://www.acmicpc.net/problem/2230

package BOJ.no2230;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열의 길이 N, 최소 차이 M 입력
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 수열 입력
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 정렬 실시
		Arrays.sort(arr);

		// minDiff 초기화
		int minDiff = Integer.MAX_VALUE;

		// 투포인터를 이용해 M이상이면서 가장 작은 두 수의 차이 계산
		// [풀이방법]
		// idx1 : 0부터 1씩 증가시키면서 확인
		// idx2 : 1부터 증가시키면서 확인
		// arr[idx2] - arr[idx1]이 M보다 크면 idx1++
		// arr[idx2] - arr[idx1]이 M보다 작으면 idx2++ (M보다 커질때까지 반복)
		// 조건 1. idx1, idx2 < N
		// 조건 2. idx1 < idx2 (-> idx1 < N - 1)
		int idx2 = 1;
		for (int idx1 = 0; idx1 < N - 1; idx1++) {
			if (idx2 <= idx1) {
				idx2 = idx1 + 1;
			}
			while (idx2 < N) {
				int diff = arr[idx2] - arr[idx1];
				if (diff >= M) {
					minDiff = Math.min(diff, minDiff);
					break;
				}
				idx2++;
			}
		}

		// 결과 출력
		System.out.println(minDiff);

	}
}

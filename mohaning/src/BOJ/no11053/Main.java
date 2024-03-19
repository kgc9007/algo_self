// BOJ 11053번 가장 긴 증가하는 부분 수열

package BOJ.no11053;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열의 길이 N 입력
		int N = sc.nextInt();

		// 길이 N의 수열 생성 후 숫자 입력
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// dp 배열 생성
		int[] dp = new int[N];

		// 첫번째 수부터 마지막 숫자까지
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			
			// i번재 수 전의 모든 숫자들을 확인
			for (int j = 0; j < i; j++) {
				// arr[j] < arr[i]
				// -> arr[0] ~ arr[j], arr[i]로 이루어진 수열의 증가하는 부분수열의 길이 + 1
				/* ex)	- 수열 [10, 20, 10, 30, 20, 50]
				 * 		- dp[j] = arr[j]를 포함하는 증가하는 부분수열의 길이
				 * 		
				 * 		i = 3, j = 1 이면
				 * 		arr[j] = 20, arr[i] = 30으로 arr[i] > arr[j]
				 * 		arr[0]부터 arr[j] 까지의 가장 긴 증가하는 부분수열의 길이 = dp[j]
				 * 		-> dp[i] = dp[j] + 1과 기존 dp[i] 중 큰 값
				 */
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		// 최대 길이 확인
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}

		// 결과 출력
		System.out.println(max);
	}
}

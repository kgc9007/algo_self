// BOJ 2512번 예산
// https://www.acmicpc.net/problem/2512

package BOJ.no2512;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] needs = new int[N];
		for (int i = 0; i < N; i++) {
			needs[i] = sc.nextInt();
		}

		int budget = sc.nextInt();

		// 결과 출력
		System.out.println(getMax(N, needs, budget));

	}

	// 가장 크게 배정된 지방의 예산액을 구하는 메소드
	public static int getMax(int N, int[] needs, int budget) {
		int sum = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			sum += needs[i];
			max = Math.max(max, needs[i]);
		}

		// 모든 예산요청이 배정될 수 있는 경우 요청의 최대값 반환
		if (sum <= budget) {
			return max;
		}

		// 모든 예산요청이 그대로 배정될 수 없는 경우
		// 이분탐색을 활용해 최대값 계산

		// 초기 설정
		int left = 1;
		int right = max;
		int mid = (left + right) / 2;

		// 하한이 상한보다 작거나 같을때까지 반복(하한이 상한을 넘어가면 종료)
		while (left <= right) {
			mid = (left + right) / 2;
			sum = 0;

			// 예산을 배정한 합계를 계산
			for (int i = 0; i < N; i++) {
				// 예산 요청이 상한액보다 작다면 예산 요청만큼만 배정
				if (needs[i] < mid) {
					sum += needs[i];
				}
				// 예산 요청이 상한액보다 크다면 상한액만큼만 배정
				else {
					sum += mid;
				}
			}

			// 나누어준 예산 배정액이
			// - 전체 예산보다 크다면 예산 상한액을 줄여서 반복
			// - 전체 예산보다 작다면 예산 상한액을 줄여서 반복
			if (sum > budget) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		// 결과(최종 상한액) 반환
		return left - 1;
	}
}

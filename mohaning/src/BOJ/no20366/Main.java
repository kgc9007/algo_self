// BOJ 20366번 같이 눈사람 만들래?
// https://www.acmicpc.net/problem/20366

package BOJ.no20366;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] length = new int[N];
		for (int i = 0; i < N; i++) {
			length[i] = sc.nextInt();
		}

		// 정렬 실시
		Arrays.sort(length);

		// 높이차의 최소값 초기화
		int min = Integer.MAX_VALUE;

		// 두 개의 눈덩이를 선택할 수 있는 모든 경우마다 탐색 실시
		// 각 경우마다 나머지 두 개의 눈덩이를 골라서 차이를 최소로 만드는 경우를 확인
		// -> 투포인터 활용
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// 첫번째 눈사람의 키(눈덩이의 지름의 합) 계산
				int sum1 = length[i] + length[j];

				int start = 0;
				int end = N - 1;
				while (start < end) {
					// 이미 선택된 눈덩이라면 패스
					if (start == i || start == j) {
						start++;
						continue;
					}
					// 이미 선택된 눈덩이라면 패스
					if (end == i || end == j) {
						end--;
						continue;
					}

					// 두번째 눈사람의 키(눈덩이의 지름의 합) 계산
					int sum2 = length[start] + length[end];

					// 기존 차이의 최소값과 키 차이 비교 후 갱신
					min = Math.min(min, Math.abs(sum1 - sum2));

					// 두 눈사람의 키를 비교 후 상한과 하한(포인터) 이동 결정
					if (sum1 >= sum2) {
						start++;
					} else {
						end--;
					}
				}
			}
		}

		// 결과 출력
		System.out.println(min);

	}
}

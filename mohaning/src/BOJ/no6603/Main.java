// BOJ 6603번 로또
// https://www.acmicpc.net/problem/6603

package BOJ.no6603;

import java.util.Scanner;

public class Main {

	static int N; // 집합 S의 크기
	static int[] arr; // S의 원소들을 저장할 배열
	static boolean[] isUsed; // S의 각 원소들의 사용 여부를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			// N 입력
			N = sc.nextInt();

			// N = 0이면 종료
			if (N == 0) {
				break;
			}

			// arr, isUsed 생성 및 초기화
			arr = new int[N];
			isUsed = new boolean[N];
			for (int i = 0; i < N; i++) {
				// 배열 arr에 값 입력
				arr[i] = sc.nextInt();
			}

			// 결과 확인 + 다음 케이스로 넘어갈때 줄바꿈
			getCombination(0, 0);
			System.out.println();
		}

	}

	// 조합 구하기 + 결과 출력
	public static void getCombination(int idx, int count) {
		// 6개의 숫자를 정했다면 결과 출력 후 종료
		if (count == 6) {
			for (int i = 0; i < N; i++) {
				if (isUsed[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		// 마지막 숫자까지 결정했다면 종료
		if (idx == N) {
			return;
		}

		// 해당 번호를 포함하게 하고 다음 번호로
		isUsed[idx] = true;
		getCombination(idx + 1, count + 1);

		// 해당 번호를 포함하지 않게 하고 다음 번호로
		isUsed[idx] = false;
		getCombination(idx + 1, count);
	}
}

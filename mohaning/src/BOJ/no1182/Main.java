// BOJ 1182번 부분수열의 합
// https://www.acmicpc.net/problem/1182

package BOJ.no1182;

import java.util.Scanner;

public class Main {
	// 수열의 크기 N
	// 구하려는 부분수열의 합 S
	static int N;
	static int S;
	static int[] arr;

	// 해당 원소가 부분수열에 포함되는지를 표시할 배열
	static boolean[] selected;

	// 합이 S가 되는 부분수열의 개수
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 부분집합 구하기
		getPowerset(0);

		// S = 0이라면 공집합도 포함하여 count가 계산되었으니 1개 경우 제외
		if (S == 0) {
			count--;
		}

		// 결과 출력
		System.out.println(count);

	}

	// 부분집합 구하기
	public static void getPowerset(int idx) {
		// 마지막 원소까지 포함 여부를 결정했다면
		// 합이 S와 같은지 확인 후 같다면 count++, 종료
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					sum += arr[i];
				}
			}
			if (sum == S) {
				count++;
			}
			return;
		}

		// 해당 원소 포함
		selected[idx] = true;
		getPowerset(idx + 1);

		// 해당 원소 미포함
		selected[idx] = false;
		getPowerset(idx + 1);
	}
}

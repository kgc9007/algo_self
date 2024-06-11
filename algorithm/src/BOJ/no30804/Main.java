// BOJ 30804번 과일 탕후루
// https://www.acmicpc.net/problem/30804

package BOJ.no30804;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] fruits = new int[N];

		for (int i = 0; i < N; i++) {
			fruits[i] = sc.nextInt();
		}

		int[] counting = new int[10];

		int max = 0;
		int count = 0;

		int start = 0;
		int end = 0;

		while (end < N) {
			if (counting[fruits[end]] == 0) {
				count++;
			}
			counting[fruits[end]]++;

			if (count > 2) {
				if (--counting[fruits[start]] == 0) {
					count--;
				}
				start++;
			}

			end++;

			max = Math.max(max, end - start);
		}

		// 결과 출력
		System.out.println(max);

	}
}

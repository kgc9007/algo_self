// BOJ 1253번 좋다

package BOJ.no1253;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < N; i++) {
			int target = arr[i];

			int left = 0;
			int right = N - 1;
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				}
				if (right == i) {
					right--;
					continue;
				}

				if (arr[left] + arr[right] == target) {
					count++;
					break;
				}

				if (arr[left] + arr[right] > target) {
					right--;
				} else if (arr[left] + arr[right] < target) {
					left++;
				}
			}
		}

		// 결과 출력
		System.out.println(count);
	}
}

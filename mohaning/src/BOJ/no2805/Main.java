// BOJ 2805번 나무 자르기

package BOJ.no2805;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int[] trees;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 나무의 수 N과 필요한 나무의 길이 M 입력
		int N = sc.nextInt();
		int M = sc.nextInt();

		// N개의 나무의 길이를 trees 배열에 입력
		trees = new int[N];
		for (int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
		}

		Arrays.sort(trees);

		int hi = trees[N - 1];
		int lo = trees[0];
		int mid = (hi + lo) / 2;

		long totalLength = 0;
		while (lo < hi) {
			mid = (hi + lo) / 2;
			totalLength = cut(mid);
			if (totalLength >= M) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		// 결과 출력
//		System.out.println(mid);
		System.out.println("lo: " + lo);
		System.out.println("mid: " + mid);
		System.out.println("hi: " + hi);
		System.out.println("totalLength: " + totalLength);
	}

	public static long cut(int height) {
		long sum = 0;
		for (int i = 0; i < trees.length; i++) {
			if (trees[i] > height) {
				sum += trees[i] - height;
			}
		}
		return sum;
	}
}

// BOJ 15649번 N과 M(3)
// https://www.acmicpc.net/problem/15651

package BOJ.no15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		result = new int[M];
		getCombination(0, 0);
		System.out.println(sb);

	}

	// 중복 조합 구하기
	public static void getCombination(int idx, int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < N; i++) {
			result[count] = arr[i];
			getCombination(i, count + 1);
		}
	}
}

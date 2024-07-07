// BOJ 2170번 선 긋기
// https://www.acmicpc.net/problem/2170

package BOJ.no2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] points = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}

				return o1[0] - o2[0];
			}
		});

		int start = points[0][0];
		int end = points[0][1];

		int sum = end - start;

		for (int i = 1; i < N; i++) {
			if (points[i][1] <= end) {
				continue;
			}

			if (points[i][0] > end) {
				sum += points[i][1] - points[i][0];
			} else {
				sum += points[i][1] - end;
			}

			end = points[i][1];

		}

		// 결과 출력
		System.out.println(sum);
	}
}

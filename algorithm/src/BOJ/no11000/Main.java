// BOJ 11000번 강의실 배정
// https://www.acmicpc.net/problem/11000

package BOJ.no11000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] lecture = new int[N][2];
		for (int i = 0; i < N; i++) {
			lecture[i][0] = sc.nextInt();
			lecture[i][1] = sc.nextInt();
		}

		Arrays.sort(lecture, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}

		});

		int count = 0;
		for (int i = 0; i < N; i++) {
			
		}

	}
}

// BOJ 1931번 회의실 배정

package BOJ.no1931;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 회의의 수 N 입력
		int N = sc.nextInt();

		// 회의의 정보(시작시간, 종료시간) 입력
		int[][] info = new int[N][2];

		for (int i = 0; i < N; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
		}

		// 정렬
		// 1. 회의 시작이 빠른 순으로
		// 2. 회의 시작 시간이 같다면 종료 시간이 빠른 순으로
		Arrays.sort(info, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.printf("%d %d", info[i][0], info[i][1]);
			System.out.println();
		}

		// 총 회의 진행 수 count
		// count = 0으로 초기화
		int count = 0;

		for (int i = 0; i < N; i++) {

		}
	}
}

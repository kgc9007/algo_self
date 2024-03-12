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

		
		int[] startTime = new int[N];
		int[] endTime = new int[N];
		for (int i = 0; i < N; i++) {
			startTime[i] = info[i][0];
			endTime[i] = info[i][1];
		}

		// 총 회의 진행 수 count
		// count = 0으로 초기화
		int count = 0;
		int nowStartTime = 0;
		int nowEndTime = 0;
		int prevEndTime = 0;

		for (int i = 0; i < N; i++) {
			nowStartTime = startTime[i];
			nowEndTime = endTime[i];

			if (i == N - 2) {
				if (nowEndTime <= startTime[i + 1]) {
					count += 2;
				} else {
					count++;
				}
				break;
			} else {
				if (prevEndTime > nowStartTime) {
					continue;
				}
				if (nowEndTime <= startTime[i + 1]) {
					count++;
					prevEndTime = nowEndTime;
				} else {
					if (nowEndTime > endTime[i + 1]) {
						continue;
					} else {
						count++;
						prevEndTime = nowEndTime;
					}
				}
			}
		}

		System.out.println(count);
	}
}

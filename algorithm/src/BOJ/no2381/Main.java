// BOJ 2381번 최대 거리

package BOJ.no2381;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] points = new int[N][2];
		for (int i = 0; i < N; i++) {
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
		}
		
		// 1. x, y 좌표가 모두 가장 작은 점과 모두 가장 큰 점의 거리 계산
		// (-1000000, -1000000)을 기준으로 두고 가장 가까운 점과 가장 먼 점의 거리 차이 계산
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int x = 1000000 + points[i][0];
			int y = 1000000 + points[i][1];
			if (x + y < min) {
				min = x + y;
			}
			if (x + y > max) {
				max = x + y;
			}
		}
		int result1 = max - min;

		// 2. x 좌표가 가장 작고 y 좌표가 가장 큰 점과 x 좌표가 가장 크고 y 좌표가 가장 작은 점의 거리 계산
		// (-1000000, 1000000)을 기준으로 두고 가장 가까운 점과 가장 먼 점의 거리 차이 계산
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int x = 1000000 + points[i][0];
			int y = 1000000 - points[i][1];
			if (x + y < min) {
				min = x + y;
			}
			if (x + y > max) {
				max = x + y;
			}
		}
		int result2 = max - min;
		
		int result = Math.max(result1, result2);
		
		// 결과 출력
		System.out.println(result);
	}
}

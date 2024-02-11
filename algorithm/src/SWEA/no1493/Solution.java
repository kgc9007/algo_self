// SWEA 1493번 수의 새로운 연산

package SWEA.no1493;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int testCase = 0;
		while (T-- > 0) {
			testCase++;

			// 두 점 p, q 입력
			int p = sc.nextInt();
			int q = sc.nextInt();

			// 두 점 p, q좌표를 구해서 연산 실행
			int x = getCoordinate(p)[0] + getCoordinate(q)[0];
			int y = getCoordinate(p)[1] + getCoordinate(q)[1];
			int result = getPoint(x, y);

			// 결과 출력
			System.out.printf("#%d %d%n", testCase, result);
		}
	}

	// p 값을 좌표로 바꾸는 메소드
	public static int[] getCoordinate(int p) {
		int times = 0;
		while (p > 0) {
			times++;
			p -= times;
		}

		int x = times;
		int y = 1;
		while (p != 0) {
			p++;
			x--;
			y++;
		}

		int[] result = { x, y };
		return result;
	}

	// 좌표를 입력해서 점의 번호를 구하는 메소드
	public static int getPoint(int x, int y) {
		int sum = x + y;

		int times = 0;
		int result = 0;
		for (int i = 1; i < sum; i++) {
			times++;
			result += times;
		}

		result -= sum - (x + 1);

		return result;
	}
}

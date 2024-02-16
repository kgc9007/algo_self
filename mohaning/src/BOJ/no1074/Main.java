// BOJ 1074번 Z

package BOJ.no1074;

import java.util.Scanner;

public class Main {

	static int[][] map;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		map = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
		func(N, 0, 0);

		// 결과 출력
		System.out.println(map[r][c]);
	}

	// 재귀함수
	public static void func(int N, int r, int c) {
		if (N == 0) {
			map[r][c] = count++;
			return;
		}
		int length = (int) Math.pow(2, N - 1);
		func(N - 1, r, c);
		func(N - 1, r, c + length);
		func(N - 1, r + length, c);
		func(N - 1, r + length, c + length);

	}
}

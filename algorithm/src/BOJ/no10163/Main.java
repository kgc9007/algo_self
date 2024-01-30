// BOJ 10163번 색종이

package BOJ.no10163;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 색종이가 놓이는 가로 1001칸, 세로 1001칸 크기의 평면 map 생성
		int[][] map = new int[1001][1001];

		// 색종이의 개수 N 입력
		int N = sc.nextInt();

		// 각 색종이별 결과를 저장할 배열 result 생성
		int[] result = new int[N + 1];

		// N개의 색종이의 위치, 가로, 세로 길이를 입력받아
		int idx = 1;
		while (N-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			// map 배열에 색종이 번호를 입력
			// 이미 색종이가 있는 곳에 다른 색종이가 덮이면 번호 변경
			for (int dx = 0; dx < w; dx++) {
				for (int dy = 0; dy < h; dy++) {
					map[y + dy][x + dx] = idx;
				}
			}
			idx++;
		}

		for (int x = 0; x < 1001; x++) {
			for (int y = 0; y < 1001; y++) {
				if (map[y][x] != 0) {
					result[map[y][x]]++;
				}
			}
		}

		// 결과 출력
		for (int i = 1; i < idx; i++) {
			System.out.println(result[i]);
		}

	}
}

// BOJ 2630번 색종이 만들기

package BOJ.no2630;

import java.util.Scanner;

public class Main {
	// 종이의 정보를 저장할 배열
	static int[][] paper;

	static int whiteCount; // 하얀색 색종이의 수
	static int blueCount; // 파란색 색종이의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 종이의 크기 N 입력
		int N = sc.nextInt();

		// 종이 정보 입력
		paper = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}

		// 재귀함수 실행
		cut(0, 0, N);

		// 결과 출력
		System.out.println(whiteCount);
		System.out.println(blueCount);

	}

	// 재귀함수
	// 종이가 모두 같은색이 아니라면 4등분하여 다시 확인
	// 크기가 1이라면 더이상 자를 수 없음 -> 색 확인 후 whiteCount/blueCount++
	public static void cut(int startr, int startc, int length) {
		if (length == 1) {
			if (paper[startr][startc] == 0) {
				whiteCount++;
			} else {
				blueCount++;
			}
			return;
		}

		for (int r = startr; r < startr + length; r++) {
			for (int c = startc; c < startc + length; c++) {
				// 모두 같은 색이 아니라면
				if (paper[r][c] != paper[startr][startc]) {
					// 길이를 반으로 줄이고
					length /= 2;
					// 4등분하여 다시 확인
					cut(startr, startc, length);
					cut(startr, startc + length, length);
					cut(startr + length, startc, length);
					cut(startr + length, startc + length, length);
					return;
				}
			}
		}

		// 모두 같은 색이라면
		// 해당 종이의 색에 맞는 whiteCount/blueCount++
		if (paper[startr][startc] == 0) {
			whiteCount++;
		} else {
			blueCount++;
		}

	}
}

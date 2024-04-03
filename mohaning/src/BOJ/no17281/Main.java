// BOJ 17281번 ⚾
// https://www.acmicpc.net/problem/17281

package BOJ.no17281;

import java.util.Scanner;

public class Main {
	// 전체 이닝 수 N
	static int N;

	// 이닝 별 각 선수가 얻는 결과 result
	// result[i][j] = i 이닝에 j 선수가 얻는 결과
	static int[][] result;

	static int[] order;

	static int maxScore = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		result = new int[N + 1][10];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				result[i][j] = sc.nextInt();
			}
		}
	}

	// 순열
	public static void getPermutation(int idx) {
		if (idx == 10) {
			int score = play();

			maxScore = Math.max(score, maxScore);
			return;
		}

		if (idx == 4) {
			order[idx] = 1;
			getPermutation(idx + 1);
		} else {
			for (int i = 2; i <= 9; i++) {
				order[idx] = i;
				getPermutation(idx + 1);
			}
		}

	}

	// 구해진 타순대로 경기를 진행하고 점수를 반환하는 메소드
	public static int play() {
		int score = 0;

		return score;
	}
}

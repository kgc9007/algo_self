// BOJ 17140번 이차원 배열과 연산
// https://www.acmicpc.net/problem/17140

package BOJ.no17140;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// N행 M열의 값이 K이면 종료
	static int N;
	static int M;
	static int K;
	static int[][] arr;

	// 가장 긴 행, 열의 길이
	// 3으로 초기화
	static int maxR = 3;
	static int maxC = 3;

	// 연산시 정렬을 위한 counting 배열
	static int[] counting;

	// 연산횟수
	static int time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		arr = new int[101][101];
		for (int r = 1; r <= 3; r++) {
			for (int c = 1; c <= 3; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		time = 0;
		// 최대 100초까지 확인하려는 위치의 값이 K가 아니라면 반복
		while (!check() && time <= 100) {
			time++;
			// 최대 행의 길이가 더 길거나 같으면 R 연산
			if (maxR >= maxC) {
				calculationR();
			}
			// 최대 열의 길이가 더 길면 C 연산
			else {
				calculationC();
			}
		}

		// 결과 출력
		if (time == 101) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}
	}

	// r연산
	public static void calculationR() {
		maxC = 2;
		int[][] copy = new int[101][101];
		for (int r = 1; r < 101; r++) {
			copy[r] = Arrays.copyOf(arr[r], 101);
		}

		arr = new int[101][101];
		for (int r = 1; r < 101; r++) {
			counting = new int[101];
			int max = 0;
			for (int c = 1; c < 101; c++) {
				counting[copy[r][c]]++;
				max = Math.max(counting[copy[r][c]], max);
			}

			int idx = 1;
			int count = 1;
			while (count <= max) {
				for (int i = 1; i < 101; i++) {
					if (idx > 100) {
						break;
					}
					if (counting[i] == count) {
						arr[r][idx++] = i;
						arr[r][idx++] = count;
					}
				}
				count++;
			}
			maxC = Math.max(maxC, idx - 1);
		}
	}

	// c연산
	public static void calculationC() {
		maxR = 2;
		int[][] copy = new int[101][101];
		for (int r = 1; r < 101; r++) {
			copy[r] = Arrays.copyOf(arr[r], 101);
		}

		arr = new int[101][101];
		for (int c = 1; c < 101; c++) {
			counting = new int[101];
			int max = 0;
			for (int r = 1; r < 101; r++) {
				counting[copy[r][c]]++;
				max = Math.max(counting[copy[r][c]], max);
			}

			int idx = 1;
			int count = 1;
			while (count <= max) {
				for (int i = 1; i < 101; i++) {
					if (idx > 100) {
						break;
					}
					if (counting[i] == count) {
						arr[idx++][c] = i;
						arr[idx++][c] = count;
					}
				}
				count++;
			}
			maxR = Math.max(maxR, idx - 1);
		}
	}

	// A[N][M]의 값이 K인지 확인하는 메소드
	public static boolean check() {
		return arr[N][M] == K;
	}
}

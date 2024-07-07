// BOJ 2096번 내려가기
// https://www.acmicpc.net/problem/2096

package BOJ.no2096;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 줄(열) 수 입력
		int N = sc.nextInt();

		// 배열 입력
		int[][] arr = new int[N][3];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 3; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		// 최대, 최소값 초기화
		int max = 0;
		int min = Integer.MAX_VALUE;

		// dp 테이블 생성 및 첫번째 줄 초기화
		int[][] dpMax = new int[N][3];
		int[][] dpMin = new int[N][3];
		dpMax[0] = arr[0];
		dpMin[0] = arr[0];

		// 한 줄씩 내려가며 dp 테이블에 값 입력
		for (int r = 1; r < N; r++) {
			// [dpMax]
			// 왼쪽, 오른쪽 칸의 경우 반대쪽 칸에서는 올 수 없으므로
			// 왼쪽(오른쪽) + 중간 두 칸 중 큰 값에 원본 배열의 값을 더하여 입력
			dpMax[r][0] = Math.max(dpMax[r - 1][0], dpMax[r - 1][1]) + arr[r][0];
			dpMax[r][2] = Math.max(dpMax[r - 1][1], dpMax[r - 1][2]) + arr[r][2];

			// 중간 칸의 경우 윗줄의 모든 칸에서 올 수 있으므로
			// 세 칸 중 가장 큰 값에 원본 배열의 값을 더하여 입력
			dpMax[r][1] = Math.max(dpMax[r - 1][0], dpMax[r - 1][1]);
			dpMax[r][1] = Math.max(dpMax[r][1], dpMax[r - 1][2]);
			dpMax[r][1] += arr[r][1];

			// [dpMin]
			// 왼쪽, 오른쪽 칸의 경우 반대쪽 칸에서는 올 수 없으므로
			// 왼쪽(오른쪽) + 중간 두 칸 중 작은 값에 원본 배열의 값을 더하여 입력
			dpMin[r][0] = Math.min(dpMin[r - 1][0], dpMin[r - 1][1]) + arr[r][0];
			dpMin[r][2] = Math.min(dpMin[r - 1][1], dpMin[r - 1][2]) + arr[r][2];

			// 중간 칸의 경우 윗줄의 모든 칸에서 올 수 있으므로
			// 세 칸 중 가장 작은 값에 원본 배열의 값을 더하여 입력
			dpMin[r][1] = Math.min(dpMin[r - 1][0], dpMin[r - 1][1]);
			dpMin[r][1] = Math.min(dpMin[r][1], dpMin[r - 1][2]);
			dpMin[r][1] += arr[r][1];
		}

		// dpMax, dpMin 테이블의 마지막 줄에서 가장 큰 값, 작은 값 확인
		for (int c = 0; c < 3; c++) {
			max = Math.max(max, dpMax[N - 1][c]);
			min = Math.min(min, dpMin[N - 1][c]);
		}

		// 결과 출력
		System.out.println(max + " " + min);
	}
}

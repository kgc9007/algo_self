// SWEA 1204번 최빈수 구하기

package SWEA.no1204;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 입력
		int T = sc.nextInt();

		// 테스트 케이스의 수만큼 반복
		while (T-- > 0) {
			// 테스트 케이스 번호 입력
			int testCase = sc.nextInt();

			// 각 점수별 빈도수를 저장할 배열 score 생성
			int[] score = new int[101];

			// 학생 1000명의 점수를 입력받으며
			// 점수에 해당하는 score 배열의 값 증가
			// ex) 10점 -> score[10]++
			for (int i = 0; i < 1000; i++) {
				score[sc.nextInt()]++;
			}

			// score 배열을 0~100까지 확인하면서
			// 기존 최대값보다 큰 숫자가 나오면
			// 최빈수, 최대 빈도 갱신
			int mode = 0;
			int maxPreq = 0;
			for (int i = 0; i < score.length; i++) {
				if (score[i] >= maxPreq) {
					mode = i;
					maxPreq = score[i];
				}
			}

			// 결과 출력
			System.out.printf("#%d %d%n", testCase, mode);
		}

	}
}

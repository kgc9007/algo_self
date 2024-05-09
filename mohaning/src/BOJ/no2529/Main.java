// BOJ 2529번 부등호
// https://www.acmicpc.net/problem/2529

package BOJ.no2529;

import java.util.Scanner;

public class Main {

	static int K;
	static char[] signs;
	static int[] result;
	static boolean[] selected;

	// 첫번째 숫자가 0인 경우 0을 포함하여야 하므로 문자열 형태로 저장
	static String min = Long.toString(Long.MAX_VALUE);
	static String max = Long.toString(Long.MIN_VALUE);

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		signs = new char[K];
		for (int i = 0; i < K; i++) {
			signs[i] = sc.next().charAt(0);
		}

		// result 초기화 후 최소값, 최대값 계산
		result = new int[K + 1];
		selected = new boolean[10];
		for (int i = 0; i < 10; i++) {
			selected[i] = true;
			result[0] = i;
			calculate(0);
			selected[i] = false;
		}

		// 결과 출력
		System.out.println(max);
		System.out.println(min);
	}

	// 최소값, 최대값 구하기
	// 재귀를 통해 첫번째자리 숫자부터 마지막자리 숫자까지 입력하며 확인
	// -> N-queen과 유사한 방법으로 진행
	public static void calculate(int idx) {
		// 마지막 숫자까지 조건에 맞게 입력한 경우 기존 최대 최소값과 비교 후 갱신
		if (idx == K) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= K; i++) {
				sb.append(result[i]);
			}
			String str = sb.toString();
			if (Long.parseLong(str) < Long.parseLong(min)) {
				min = str;
			}
			if (Long.parseLong(str) > Long.parseLong(max)) {
				max = str;
			}
			return;
		}

		// 등호가 > 이면 다음 자릿수가 더 큰 경우만 가능
		if (signs[idx] == '>') {
			for (int i = 0; i < 10; i++) {
				if (!selected[i] && result[idx] > i) {
					selected[i] = true;
					result[idx + 1] = i;
					calculate(idx + 1);
					selected[i] = false;
				}
			}
		}
		// 등호가 < 이면 다음 자릿수가 더 작은 경우만 가능
		else {
			for (int i = 0; i < 10; i++) {
				if (!selected[i] && result[idx] < i) {
					selected[i] = true;
					result[idx + 1] = i;
					calculate(idx + 1);
					selected[i] = false;
				}
			}
		}
	}
}

// BOJ 12869번 뮤탈리스크
// https://www.acmicpc.net/problem/12869

package BOJ.no12869;

import java.util.Scanner;

public class Main {
	// 각 SCV를 공격할 데미지
	static int[][] damage = { { 9, 3, 1 }, { 9, 1, 3 }, { 3, 9, 1 }, { 3, 1, 9 }, { 1, 9, 3 }, { 1, 3, 9 } };

	// 모든 SCV를 파괴하기 위해 필요한 공격횟수의 최소값
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] SCV = new int[3];
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			SCV[i] = sc.nextInt();
		}

		for (int i = 0; i < 6; i++) {
			attack(SCV[0], SCV[1], SCV[2], damage[i], 0);
		}

		// 결과 출력
		System.out.println(min);
	}

	//
	public static void attack(int hp0, int hp1, int hp2, int[] attack, int count) {
		if (hp0 <= 0 && hp1 <= 0 && hp2 <= 0) {
			min = Math.min(min, count);
			return;
		}

		if (count >= min) {
			return;
		}

		if (hp0 > 0 && hp1 > 0 && hp2 > 0) {
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[0], count + 1);
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[1], count + 1);
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[2], count + 1);
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[3], count + 1);
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[4], count + 1);
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[5], count + 1);
		} else if (hp0 > 0 && hp1 > 0 && hp2 <= 0) {
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[0], count + 1);
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[2], count + 1);
		} else if (hp0 > 0 && hp1 <= 0 && hp2 > 0) {
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[1], count + 1);
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[3], count + 1);
		} else if (hp0 <= 0 && hp1 > 0 && hp2 > 0) {
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[4], count + 1);
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[5], count + 1);
		} else if (hp0 > 0 && hp1 <= 0 && hp2 <= 0) {
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[0], count + 1);
		} else if (hp0 <= 0 && hp1 > 0 && hp2 <= 0) {
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[2], count + 1);
		} else if (hp0 <= 0 && hp1 <= 0 && hp2 > 0) {
			attack(hp0 - attack[0], hp1 - attack[1], hp2 - attack[2], damage[5], count + 1);
		}

	}
}

// BOJ 14696번 딱지놀이

package BOJ.no14696;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 총 라운드 수 N 입력
		int N = sc.nextInt();

		// 각 라운드마다 a, b의 딱지의 그림 정보를 aPicture, bPicture 배열에 저장
		for (int i = 0; i < N; i++) {
			// [0] ~ [3] : 세모, 네모, 동그라미, 별의 개수
			int[] aPicture = new int[4];
			int[] bPicture = new int[4];

			int a = sc.nextInt();
			for (int j = 0; j < a; j++) {
				int num = sc.nextInt();
				aPicture[num - 1]++;
			}

			int b = sc.nextInt();
			for (int j = 0; j < b; j++) {
				int num = sc.nextInt();
				bPicture[num - 1]++;
			}

			System.out.println(play(aPicture, bPicture));
		}

	}

	// 별, 동그라미, 네모, 세모의 개수 순으로 비교
	// 모두 같으면 무승부 (D)
	public static String play(int[] aPicture, int[] bPicture) {
		if (aPicture[3] > bPicture[3]) {
			return "A";
		} else if (aPicture[3] < bPicture[3]) {
			return "B";
		} else {
			if (aPicture[2] > bPicture[2]) {
				return "A";
			} else if (aPicture[2] < bPicture[2]) {
				return "B";
			} else {
				if (aPicture[1] > bPicture[1]) {
					return "A";
				} else if (aPicture[1] < bPicture[1]) {
					return "B";
				} else {
					if (aPicture[0] > bPicture[0]) {
						return "A";
					} else if (aPicture[0] < bPicture[0]) {
						return "B";
					} else {
						return "D";
					}
				}
			}
		}

	}

	
}

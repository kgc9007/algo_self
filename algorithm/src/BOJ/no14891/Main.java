// BOJ 14891번 톱니바퀴

package BOJ.no14891;

import java.util.Scanner;

public class Main {
	
	static int[][] wheel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		wheel = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String line =  sc.next();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = line.charAt(i) - '0';
			}
		}
		
		rotate(sc.nextInt(), sc.nextInt());
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(wheel[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void rotate(int N, int D) {
		// 반시계 방향 회전
		if (D == -1) {
			// 임시 배열 tmp를 생성 후 회전 후 정보를 저장
			int[] tmp = new int[8];
			for (int i = 0; i < 8; i++) {
				tmp[i] = wheel[N - 1][(i + 1) % 8];
			}
			// 임시 배열의 값을 wheel에 입력
			for (int i = 0; i < 8; i++) {
				wheel[N - 1][i] = tmp[i];
			}
		} else { // 시계 방향 입력
			// 임시 배열 tmp를 생성 후 회전 후 정보를 저장
			int[] tmp = new int[8];
			for (int i = 15; i >= 8; i--) {
				tmp[i % 8] = wheel[N - 1][(i - 1) % 8];
			}
			// 임시 배열의 값을 wheel에 입력
			for (int i = 0; i < 8; i++) {
				wheel[N - 1][i] = tmp[i];
			}
		}
	}

	public static int getScore() {
		int score = 0;
		if (wheel[0][0] == 1) {
			score += 1;
		}
		if (wheel[1][0] == 1) {
			score += 2;
		}
		if (wheel[2][0] == 1) {
			score += 4;
		}
		if (wheel[3][0] == 1) {
			score += 8;
		}
		return score;
	}
}

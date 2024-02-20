// BOJ 2477번 참외밭

package BOJ.no2477;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int[][] coordinate = new int[6][2];
		int x = 0;
		int y = 0;
		for (int i = 0; i < 6; i++) {
			int d = sc.nextInt();
			int length = sc.nextInt();
			if (d == 1) {
				x += length;
				coordinate[i][0] = x;
				coordinate[i][1] = y;
			} else if (d == 2) {
				x -= length;
				coordinate[i][0] = x;
				coordinate[i][1] = y;
			} else if (d == 3) {
				y -= length;
				coordinate[i][0] = x;
				coordinate[i][1] = y;
			} else {
				y += length;
				coordinate[i][0] = x;
				coordinate[i][1] = y;				
			}
		}
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("x : %d   y : %d%n", coordinate[i][0], coordinate[i][1]);
		}
		
	}

}

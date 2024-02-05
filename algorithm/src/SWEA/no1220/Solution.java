// SWEA 1220번 Magnetic

package SWEA.no1220;

import java.util.Scanner;

public class Solution {
	public static int[][] table = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 총 10개의 테스트 케이스
		int T = 10;
		while (T-- > 0) {
			int N = sc.nextInt();
			
			// 1 : N극, 2 : S극, 0 : 빈 칸
			// table에 값 입력
			for (int r = 0; r < table.length; r++) {
				for (int c = 0; c < table.length; c++) {
					table[r][c] = sc.nextInt();
				}
			}
			
			// 1열부터 마지막 열까지 순차적으로 탐색
			// 해당 열의 1행부터 마지막 행까지 확인하면서
			// 값이 1(N극) 이면 flag = true로 변환
			// 위에 1(N극)이 있는 상태에서 (flag = true) 값이 2(S극)이면 cnt++, flag = false로 초기화
			int cnt = 0;
			for (int c = 0; c < table.length; c++) {
				boolean flag = false;
				for (int r = 0; r < table.length; r++) {
					if (table[r][c] == 1) {
						flag = true;
					}
					if (flag && table[r][c] == 2) {
						cnt++;
						flag = false;
					}
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d%n", 10 - T, cnt);
			
			
			
		}
	}

}

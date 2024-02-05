// SWEA 1220번 Magnetic

package SWEA.no1220;

import java.util.Scanner;

public class Solution {
	public static int[][] table = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
			
			int cnt = 0;
			for (int c = 0; c < table.length; c++) {
				boolean flag = false;;
				for (int r = 0; r < table.length - 1; r++) {
					if (table[r][c] == 1) {
						flag = true;
					}
					if (flag && table[r][c] == 2) {
						cnt++;
						flag = false;
					}
				}
			}
			
			System.out.println(cnt);
			
			
			
		}
	}

}

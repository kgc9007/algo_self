// SWEA 11315번 오목 판정

package SWEA.no11315;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase=1; testCase<=T; testCase++) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for (int i=0; i<N; i++) {
				String str = sc.next();
				for (int j=0; j<N; j++) {
					if (str.charAt(j) == 'O') {
						map[i][j] = 1;
					} else {
						map[i][j] = 0;;						
					}
				}
			}
			
			
			
		}
	}
}

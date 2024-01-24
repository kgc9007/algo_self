// SWEA 2905번 농작물 수확하기

package SWEA.no2805;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase=1; testCase<T; testCase++) {
			int N = sc.nextInt();
			
			int[][] farm = new int[N][N];
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					farm[r][c] = sc.nextInt();
				}
			}
		}
		
	}
}

// SWEA 2005번 파스칼의 삼각형

package SWEA.no2005;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 삼각형의 크기 N 입력
			int N = sc.nextInt();
			
			// N*N 배열 생성
			int[][] map = new int[N][N];

			// 0번째 열과 마지막 열에 1입력
			for (int r=0; r<N; r++) {
				map[r][0] = 1;
				map[r][r] = 1;
			}
			
			// 2번째 행부터 숫자 입력
			// i번째 행의 j번째 열의 숫자는
			// i-1번째 행의 j-1번째 숫자와 j번째 숫자의 합
			for (int r=2; r<N; r++) {
				for (int c=1; c<r; c++) {
					map[r][c] = map[r-1][c-1] + map[r-1][c];
				}
			}
			
			// 출력 형식에 맞게 결과 출력
			System.out.printf("#%d%n", testCase);
			for (int r=0; r<N; r++) {
				for (int c=0; c<r+1; c++) {
					System.out.printf("%d ", map[r][c]);
				}
				System.out.println();
			}
		}
		
	}
}

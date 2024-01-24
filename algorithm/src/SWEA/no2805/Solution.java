// SWEA 2905번 농작물 수확하기

package SWEA.no2805;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 농장의 크기 N 입력
			int N = sc.nextInt();
			
			// N*N 배열 생성
			int[][] farm = new int[N][N];
			
			// 배열에 농작물의 가치 입력
			// 농작물의 가치가 한줄씩 주어지므로
			// charAt()을 사용해서 farm 배열에 값 입력 
			for (int r=0; r<N; r++) {
				String rowInput = sc.next();
				for (int c=0; c<N; c++) {
					farm[r][c] = rowInput.charAt(c)-48;
				}
			}
			

			
			// 얻을 수 있는 수익을 계산하여 result에 입력
			int result = 0;
			
			// 중간을 기준으로 위는 좌 우로 한칸씩 계산 범위 증가
			// 아래는 좌 우로 한칸씩 계산 범위 감소
			// -> 아래의 경우 (N-r-1)
			for (int r=0; r<N; r++) {
				if (r < N/2) {
					for (int c=N/2-r; c<=N/2+r; c++) {
						result += farm[r][c];
					}
				} else {
					for (int c=N/2-(N-r-1); c<=N/2+(N-r-1); c++) {
						result += farm[r][c];
					}
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d%n", testCase, result);
			
		}
		
	}
}

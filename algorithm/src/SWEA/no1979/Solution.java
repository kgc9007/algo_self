// SWEA 1979번 어디에 단어가 들어갈 수 있을까

package SWEA.no1979;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 단어 퍼즐의 가로, 세로 길이 N 입력
			// 단어의 길이 K 입력
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// 단어 퍼즐 생성 후 각 셀이 무슨 색인지 입력
			// 1 -> 흰색 부분(단어가 들어갈 곳)
			// 0 -> 검은색 부분
			int[][] puzzle = new int[N][N];
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					puzzle[r][c] = sc.nextInt();
				}
			}
			
			// 가로 빈칸 발견 시 길이 확인
			int columnResult = 0;
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					int blankLength = 0;
					// puzzle 순회중 빈 칸(흰색 부분)을 발견하면
					// blankLength = 1 로 변경
					// 배열의 끝까지 c를 증가시키면서
					// 빈 칸이면 blankLength를 증가시키고 아니면 break
					if (puzzle[r][c] == 1) {
						blankLength++;
						while (c<N-1) {
							c++;
							if (puzzle[r][c] == 1) {
								blankLength++;
							} else {
								break;
							}
						}
					}
					
					// 빈 칸의 길이가 주어진 단어의 길이 K와 같으면 columnResult 증가
					if (blankLength == K) {
						columnResult++;
					}
				}
			}
			
			// 세로 빈칸 발견 시 길이 확인
			int rowResult = 0;
			for (int c=0; c<N; c++) {
				for (int r=0; r<N; r++) {
					int blankLength = 0;
					// puzzle 순회중 빈 칸(흰색 부분)을 발견하면
					// blankLength = 1 로 변경
					// 배열의 끝까지 r를 증가시키면서
					// 빈 칸이면 blankLength를 증가시키고 아니면 break
					if (puzzle[r][c] == 1) {
						blankLength++;
						while (r<N-1) {
							r++;
							if (puzzle[r][c] == 1) {
								blankLength++;
							} else {
								break;
							}
						}
					}
					
					// 빈 칸의 길이가 주어진 단어의 길이 K와 같으면 columnResult 증가
					if (blankLength == K) {
						rowResult++;
					}
				}
			}
			
			// 전체 결과 계산 후 출력
			int result = columnResult + rowResult;
			
			System.out.printf("#%d %d%n", testCase, result);
		}
		
		
	}
}

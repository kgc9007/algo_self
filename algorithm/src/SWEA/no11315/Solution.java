// SWEA 11315번 오목 판정

package SWEA.no11315;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase=1; testCase<=T; testCase++) {
			int N = sc.nextInt();
			
			// 결과를 저장할 boolean 변수 result 생성, false로 초기화
			boolean result = false;
			
			// N*N 크기의 판 생성
			boolean[][] map = new boolean[N][N];
			
			// 한줄씩 입력받고 돌이 있으면 true, 없으면 false를 배열에 저장
			// boolean 배열의 기본값이 false이므로 돌이 있는 경우만 true로 변경
			for (int r=0; r<N; r++) {
				String str = sc.next();
				for (int c=0; c<N; c++) {
					if (str.charAt(c) == 'o') {
						map[r][c] = true;
					}
				}
			}
			
			// 순차적으로 이동하면서 돌이 있는 위치에 도달하면
			// 오목인지 아닌지 확인
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (map[r][c]) {
						if(check(map, r, c)) {
							result = true;
						}
					}
				}
			}
			
			// 결과 출력
			if (result) {
				System.out.printf("#%d YES%n", testCase);
			} else {
				System.out.printf("#%d NO%n", testCase);				
			}
		}
	}
	
	// 오목인지 체크하는 메소드
	// 시작점이 true일 때 사용!
	public static boolean check (boolean[][] map, int r, int c) {
		boolean result = false;
		
		int N = map.length;
		
		// 전체를 탐색할 것이므로 4방향만 확인해도 전체 경우 체크 가능
		int[] dr = {0, 1, 1, 1};
		int[] dc = {1, 0, 1, -1};
		
		// 4방향마다 다음 칸이 true이면 길이 ++
		// 길이가 5가 되면 true반환
		// 모든 방향에서 길이가 5가 아니면 기본값 false 반환
		for (int d=0; d<4; d++) {
			int length = 1;
			int nr = r + dr[d];
			int nc = c + dc[d];
			while (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc]) {
				length++;
				
				if (length == 5) {
					result = true;
					return result;
				}
				
				nr += dr[d];
				nc += dc[d];
			}
		}
		
		return result;
	}
	
	
}

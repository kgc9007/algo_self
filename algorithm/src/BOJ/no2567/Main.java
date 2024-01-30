// BOJ 2567번 색종이 2

package BOJ.no2567;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 흰색 도화지를 102*102 배열로 표현
		// 100*100 + 한칸씩 여유분 설정 -> 102*102
		int[][] map = new int[102][102];
		
		// 색종이의 수 N 입력
		int N = sc.nextInt();
		
		// 색종이의 수 N 만큼 반복하며
		// 색종이를 붙인 위치에 해당하는 배열의 값을 1로 변경
		for (int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int r=y+1; r<y+11; r++) {
				for (int c=x+1; c<x+11; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		// 색종이가 붙은 영역의 바깥 부분을 통해 둘레의 길이 계산
		// 배열의 값이 0이면서
		// 주변 (상하좌우)에 1이 있는 경우 -> 둘레 O(외부에서 본 둘레), cnt만큼 length +
		// 주변 (상하좌우)에 1이 없는 경우 -> 둘레 X
		
		// 예시) 색종이 O -> 1, 색종이 X -> 0, 색종이 X이고 주변에 색종이가 붙은 경우 -> 2
		// 2로 체크된 부분을 통해 둘레 계산
		// 0 0 0 0 0 0 0 0 0 0
		// 0 0 2 2 2 2 0 0 0 0
		// 0 2 1 1 1 1 2 0 0 0
		// 0 2 1 1 1 1 2 2 0 0
		// 0 2 1 1 1 1 1 1 2 0
		// 0 2 1 1 1 1 1 1 2 0
		// 0 0 2 2 1 1 1 1 2 0
		// 0 0 0 2 1 1 1 1 2 0
		// 0 0 0 0 2 2 2 2 0 0
		// 0 0 0 0 0 0 0 0 0 0
		
		int length = 0;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int r=0; r<102; r++) {
			for (int c=0; c<102; c++) {
				if (map[r][c] == 0) {
					int cnt = 0;
					for (int d=0; d<4; d++) {
						// 범위 안에 있는 경우만
						if (r+dr[d] >= 0 && r+dr[d] < 102 && c+dc[d] >= 0 && c+dc[d] < 102) {
							// 주변에 색종이가 붙은 경우 cnt++
							if (map[r+dr[d]][c+dc[d]] == 1) {
								cnt++;
							}
						}
					}
					length += cnt;
				}
			}
		}
		
		// 결과 출력
		System.out.println(length);

	}
}

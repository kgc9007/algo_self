// BOJ 2567번 색종이 2

package BOJ.no2567;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		// 전체 흰색 도화지를 100*100 배열로 표현
		int[][] map = new int[100][100];
		
		// 색종이의 수 N 입력
		int N = sc.nextInt();
		
		// 색종이의 수 N 만큼 반복하며
		// 색종이를 붙인 위치에 해당하는 배열의 값을 1로 변경
		for (int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int r=y; r<y+10; r++) {
				for (int c=x; c<x+10; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		// 색종이가 붙은 영역의 둘레의 길이 계산
		// 배열의 값이 1이면서
		// 주변 (상, 하, 좌, 우)의 값이 모두 1인 경우 -> 
		int length = 0;
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (map[i][j] == 1) {
					length++;
				}
			}
		}
		
		// 결과 출력
		System.out.println(length);

	}
}

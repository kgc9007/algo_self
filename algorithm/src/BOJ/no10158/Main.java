// BOJ 10158번 개미
// 시간초과 -> Main2로 개선

package BOJ.no10158;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 가로 길이 w와 세로 길이 h 입력
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		// 현재 위치 p, q 입력
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		// 계산할 시간 t 입력
		int t = sc.nextInt();
		
		// x, y이동 방향을 표현할 dx, dy를 1로 초기화
		int dx = 1;
		int dy = 1;
		
		// t 시간동안 이동
		while (t-- > 0) {
			// x 이동
			// 만약 오른쪽 경계면에 부딪치면(좌표가 같아지면) 방향을 반대로 (dx = -1)
			// 만약 왼쪽 경계면에 부딪치면(좌표가 같아지면) 방향을 반대로 (dx = 1)
			x += dx;
			if (x == w) {
				dx = -1;
			} else if (x == 0) {
				dx = 1;
			}
			
			// y 이동
			// 만약 위쪽 경계면에 부딪치면(좌표가 같아지면) 방향을 반대로 (dy = -1)
			// 만약 아래쪽 경계면에 부딪치면(좌표가 같아지면) 방향을 반대로 (dy = 1)
			y += dy;
			if (y == h) {
				dy = -1;
			} else if (y == 0) {
				dy = 1;
			}
			
		}
		
		// 결과 출력
		System.out.printf("%d %d", x, y);
		
		
	}
}

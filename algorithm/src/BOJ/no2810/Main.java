// BOJ 2810번 컵홀더

package BOJ.no2810;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 좌석의 수 N 입력
		int N = sc.nextInt();
		
		// 좌석의 정보(일반석, 커플석) seat 입력
		String seat = sc.next();
		
		// 일반좌석의 수, 커플좌석의 수 0으로 초기화
		int normalSeat = 0;
		int coupleSeat = 0;
		
		// 일반좌석 수 세기
		for (int i=0; i<seat.length(); i++) {
			if (seat.charAt(i)=='S') {
				normalSeat++;
			}
		}
		
		// 커플석 수 = 전체좌석수 - 일반좌석 수
		coupleSeat = N - normalSeat;
		
		// 커플석 X -> 전체 인원(N)이 컵을 컵홀더에 놓을 수 있음
		// 커플석 O -> (좌석 수 + 1)에서 커플석 2자리당 1개씩 컵홀더 감소
		if (normalSeat == N) {
			System.out.println(N);
		} else {
			System.out.println(N+1-coupleSeat/2);			
		}
	}
}

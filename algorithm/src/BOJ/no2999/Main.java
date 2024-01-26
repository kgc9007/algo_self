// BOJ 2999번 비밀 이메일

package BOJ.no2999;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 메세지 입력
		String message = sc.next();
		
		// 메세지 길이 -> R, C 계산
		int N = message.length();
		
		int R = 0;
		int C = 0;
		
		// i=1 부터 증가시키면서 메세지 길이 N을 i로 나누었을 때 나머지가 0이면
		// R = i 로 갱신,  C = N/R
		for (int i=1; i<=Math.sqrt(N); i++) {
			if (N % i == 0) {
				R = i;
				C = N/R;
			}
		}
		
		
		// 정인 메세지 작성 -> 암호화
		// [R][C] 배열 생성 후 
		// 1행, 2행, 3행, ..., R행 순으로 입력
		// 1열, 2열, 3열, ..., C열 순으로 바꾸고 전송 : 상근이가 받은 메세지
		
		
		// [R][C] 배열 생성 후 한글자씩 입력 - 상근이가 받은 메세지
		// 1행, 2행, 3행, ..., R행 순으로 입력
		int idx=0;
		char[][] arr = new char[R][C];
		for (int c=0; c<C; c++) {
			for (int r=0; r<R; r++) {
				arr[r][c] = message.charAt(idx++);
			}
		}
		
		
		// 결과 출력
		// 1열, 2열, 3열, ..., C열 순으로 출력 - 원래 메세지
		for (int r=0; r<R; r++) {
			for (int c=0; c<C; c++) {
				System.out.print(arr[r][c]);
			}
		}
		
		
		
	}

}

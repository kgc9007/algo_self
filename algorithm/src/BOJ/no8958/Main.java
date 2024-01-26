// BOJ 8958번 OX퀴즈

package BOJ.no8958;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// OX퀴즈 결과 입력
			String result = sc.next();
			
			// 점수, 연속으로 맞춘 문제의 수를 0으로 초기화  
			int score = 0;
			int continuedLength = 0;
			
			// 점수 계산
			// 정답 -> 연속으로 맞춘 문제의 수만큼 점수+, 연속으로 맞춘 문제의 수 +
			// 오답 -> 점수 변동 X, 연속으로 맞춘 문제의 수 0으로 초기화
			for (int i=0; i<result.length(); i++) {
				if (result.charAt(i) == 'O') {
					continuedLength++;
					score += continuedLength;
				} else {
					continuedLength = 0;
				}
			}
			
			// 결과 출력
			System.out.println(score);
		}
		
	}
}

// SWEA 5432번 쇠막대기 자르기

package SWEA.no5432;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스의 수 입력
		int T = sc.nextInt();

		// 전체 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 쇠막대기 배치 입력
			String str = sc.next();
			
			// 전체 조각 수(piece)와 현재 겹쳐진 쇠막대기의 수(cnt) 0으로 초기환
			int piece = 0;
			int cnt = 0;
			
			// 계산
			for (int i=0; i<str.length(); i++) {
				// ( 다음이 ( 인 경우
				// -> 맨 위에 쇠막대기 추가 : cnt++
				// ( 다음이 ) 인 경우 
				// -> 레이저 : 현재 겹쳐진 쇠막대기 수만큼 조각 +, 다음 위치로 이동
				if (str.charAt(i) == '(') {
					if (str.charAt(i+1) == '(') {
						cnt++;
					} else {
						piece += cnt;
						i++;
					}
				} 
				// ) 다음이 ) 인 경우 
				// -> 맨 위의 쇠막대기 끝 : piece++, cnt--
				// ( 다음이 ) 인 경우는 위의 if 블록에서 모두 확인 가능
				else {
					piece++;
					cnt--;
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d%n", testCase, piece);
		}
		
	}
}

// SWEA 5432번 쇠막대기 자르기

package SWEA.no5432;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int testCase=1; testCase<=T; testCase++) {
			String str = sc.next();
			
			int piece = 0;
			int cnt = 0;
			for (int i=1; i<str.length(); i++) {
				if (str.charAt(i) == ')') {
					if (str.charAt(i-1) == '(') {
						piece += cnt++;
					} else {
						piece++;
						cnt--;
					}
				} else {
					if (str.charAt(i-1) == '(') {
						cnt++;
					} 
				}
			}
//			( )
//			) )
//			( (
//			)) (
//			() (
			
			System.out.printf("#%d %d%n", testCase, cnt);
		}
		
		// 레이저()
		// 쇠막대기의 왼쪽 끝 ( 
		// 쇠막대기의 오른쪽 끝 )
		
		// (가 나오면
		// 다음이 )이면 레이저 -> 현재까지 쌓여있는 쇠막대기의 개수만큼 조각의 수 +
		// 다음이 (이면 쇠막대기 -> 쇠막대기가 쌓여있는 개수 +1
		
		// )가 나오면
		// 이전이 (이면 레이저
		// 이전이 )이면 쇠막대기 -> 쇠막대기가 쌓여있는 개수 -1, 조각의 수 +1
		
	}

}

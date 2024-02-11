// SWEA 7272번 안경이 없어

package SWEA.no7272;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int testCase = 0;
		while (T-- > 0) {
			testCase++;
			String str1 = sc.next();
			String str2 = sc.next();
			
			// 결과 출력
			if (isSame(str1, str2)) {
				System.out.printf("#%d SAME%n", testCase);
			} else {
				System.out.printf("#%d DIFF%n", testCase);
			}
		}
		
	}
	
	// 두 문자열이 같은지 확인하는 메소드
	// 두 문자열의 길이가 같은 경우
	// 문자열을 한글자씩 확인해서 빈칸의 개수가 다른 경우가 있으면 false 반환
	// 끝가지 모든 글자가 같으면 true 반환
	public static boolean isSame(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		} else {
			for (int i = 0; i < str1.length(); i++) {
				if (blankCount(str1.charAt(i)) != blankCount(str2.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}
	
	// 문자를 입력받아 구멍의 개수를 반환하는 메소드
	// ADOPQR -> 1
	// B -> 2
	// 나머지 (CEFGHIJKLMNSTUVWXYZ) -> 0
	public static int blankCount(char ch) {
		if (ch == 'A' || ch == 'D' || ch == 'O' || ch == 'P' || ch == 'Q' || ch == 'R') {
			return 1;
		} else if (ch == 'B') {
			return 0;
		} else {
			return 2;
		}
	}
}

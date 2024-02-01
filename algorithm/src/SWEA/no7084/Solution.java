// SWEA 7084번 문제 제목 붙이기

package SWEA.no7084;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			// A ~ Z까지 사용되었는지를 저장할 배열 isUsed 생성
			boolean[] isUsed = new boolean[26];

			
			// 은기가 만든 문제의 제목을 입력받아서 
			// 첫번째 글자에 해당하는 isUsed 배열의 값을 true로 변환
			
			// ASCII Code -  A : 65, B : 66, ...
			
			for (int i=0; i<N; i++) {
				char firstText = sc.next().charAt(0);
				isUsed[firstText-65] = true;
			}
			
			// isUsed 배열을 0번부터 확인하면서
			// 해당 알파벳이 사용되었으면 notSuedAlphabet++
			// 해당 알파벳이 사용되지 않았으면 break
			
			// notUsedAlphabet이 0이면 A, 1이면 B, 2이면 C, ...
			
			int notUsedAlphabet = 0;
			for (int i=0; i<26; i++) {
				if (isUsed[i]) {
					notUsedAlphabet++;
				} else {
					break;
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d%n", testCase, notUsedAlphabet);
			
			
		}
		
	}

}

// SWEA 5356번 의석이의 세로로 말해요

package SWEA.no5356;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
				
		// 전체 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 한글자씩 sb에 추가해서 출력하기 위해 sb 생성
			sb = new StringBuilder();
			
			// A~Z, a~z, 0~9로 이루어진 5개의 단어(문자열)을 배열에 입력
			// 5개의 단어 중 가장 긴 단어의 길이 -> maxLength
			String[] str = new String[5];
			int maxLength = 0;
			for (int i=0; i<5; i++) {
				str[i] = sc.next();
				if(str[i].length()>maxLength) {
					maxLength = str[i].length();
				}
			}
			
			// 각 열별로 한글자씩 sb에 추가
			// 반복 범위 : 가장 긴 단어의 길이만큼
			// i번째 열을 읽을 때
			// j번째 단어의 길이가 i보다 짧다면 패스 (continue)
			// 아니라면 sb에 글자 추가
			for (int i=0; i<maxLength; i++) {
				for (int j=0; j<str.length; j++) {
					if (i>=str[j].length()) {
						continue;
					} else {
						sb.append(str[j].charAt(i));						
					}
					
				}
			}
			
			
			// 결과 출력
			System.out.printf("#%d %s%n", testCase, sb);
		}
		
	}
}

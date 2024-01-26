// SWEA 4789번 성공적인 공연 기획

package SWEA.no4789;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 문자열 입력
			// i번째 글자 : i-1명이 기립 박수를 하고 있을 때 기립 박수를 하는 사람의 수
			String str = sc.next();
			
			// 입력된 문자열을 숫자 배열로 전환
			int[] clap = new int[str.length()];
			for (int i=0; i<str.length(); i++) {
				clap[i] = str.charAt(i)-48;
			}
			
			// 전체 고용해야 할 사람의 수 empToal = 0으로 초기화
			// 이미 박수를 치고 있는 사람의 수 sum = clap[0]으로 초기화
			int empTotal = 0;
			int emp = 0;
			int sum = clap[0];

			// i=1부터 반복을 실시하며
			
			// clap[i] 가 0이 아니라면
			// 이미 박수를 치고 있는 사람이 충분한지 아닌지 확인
			
			// 부족하지 않다면 추가된 사람 수만큼 sum 증가
			
			// 만약 부족하다면 부족한 사람 수(i - sum)만큼 고용 -> emp +
			// empTotal, sum 갱신
			// 다음 반복시 emp = 0으로 초기화
			
			for (int i=1; i<clap.length; i++) {
				emp = 0;
				if (clap[i] != 0) {
					if (sum >= i) {
						sum += clap[i];
					} else {
						emp += i - sum;
						sum += emp + clap[i];
						empTotal += emp;
					}
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d%n", testCase, empTotal);
		}
	}
}

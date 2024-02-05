// SWEA 1289번 원재의 메모리 복구하기

package SWEA.no1289;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			// 원래 메모리 상태를 문자열 memory에 저장
			String memory = sc.next();
			
			// 메모리를 고쳐야 하는 횟수 cnt = 0으로 초기화
			int cnt = 0;
			
			// 현재 bit의 상태 (i번째 이후의 bit들의 값) 을 0으로 초기화
			char currentBit = '0';
			
			// 첫번째 비트부터 끝까지 확인하면서
			// 수정이 필요하면 cnt++, currentBit 변경
			// 원래 메모리 = 1, currentBit = 0 이면 currentBit ++
			// 원래 메모리 = 0, currentBit = 1 이면 currentBit --
			for (int i=0; i<memory.length(); i++) {
				if (memory.charAt(i) > currentBit) {
					cnt++;
					currentBit++;
				} else if (memory.charAt(i) < currentBit) {
					cnt++;
					currentBit--;
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d%n", testCase, cnt);
		}
	}

}

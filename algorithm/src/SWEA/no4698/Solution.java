// SWEA 4698번 테네스의 특별한 소수

package SWEA.no4698;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 1~1000000 중 소수를 확인 -> isNotPrime[i] = false이면 소수
		// 에라토스테네스의 체 활용

		// 테스트 케이스마다 반복하지 않고
		// 전체 범위의 수를 대상으로 한번만 소수인지 아닌지 판별해서 저장
		boolean[] isNotPrime = new boolean[1000001];
		
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		for (int i=2; i<=Math.sqrt(isNotPrime.length); i++) {
			if (! isNotPrime[i]) {
				for (int j=2; i*j < isNotPrime.length; j++) {
					isNotPrime[i*j] = true;
				}				
			}
		}
		
		
		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 소수가 포함하는지 확인할 숫자 D 입력
			// 문자열로 변환
			int D = sc.nextInt();
			String check = Integer.toString(D);
			
			// 확인할 숫자의 범위 A, B 입력
			int A = sc.nextInt(); 
			int B = sc.nextInt();
			
			// 해당 범위에 특별한 소수가 몇개인지 확인해서 cnt로 저장
			// cnt = 0으로 초기화
			int cnt = 0;
			for (int i=A; i<=B; i++) {
				// i가 소수라면
				if (! isNotPrime[i]) {
					// i를 문자열로 변환
					String str = Integer.toString(i);

					// i가 D를 포함하는지 확인
					if (str.contains(check)) {
						cnt++;
					}
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d%n", testCase, cnt);
		}
		
		
	}
}

// SWEA 6485번 삼성시의 버스 노선

package SWEA.no6485;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		
		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			sb = new StringBuilder();
			
			// 1~5000번까지 각 버스 정류장에 몇 개의 노선이 다니는지 저장
			int[] busStop = new int[5001];
			
			// 버스 노선 개수 N 입력
			int N = sc.nextInt();
			
			// 각 노선별 출발점, 도착점 입력
			for (int i=0; i<N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				// 노선이 지나가는 버스 정류장의 값++
				for (int j=A; j<=B; j++) {
					busStop[j]++;
				}
				
			}
			
			// 확인하려는 버스 정류장의 수 P 입력
			int P = sc.nextInt();
			
			// 각 버스 정류장별로 지나다니는 버스의 수를 sb에 추가
			while (P-- > 0) {
				int C = sc.nextInt();
				sb.append(busStop[C] + " ");
			}
			
			
			// 결과 출력
			System.out.printf("#%d %s%n", testCase, sb);
		}		
		
		
	}
}

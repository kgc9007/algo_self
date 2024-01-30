// SWEA 7964번 부먹 왕국의 차원 관문

package SWEA.no7964;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 도시 수 N, 제한 거리 D 입력
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			// 지도 정보를 city 배열에 저장
			int[] city = new int[N];
			for (int i=0; i<N; i++) {
				city[i] = sc.nextInt();
			}
			
			// 추가로 건설해야 하는 차원문의 수 cnt = 0으로 초기화
			// 이전 차원문과의 거리 distance = 0으로 초기화
			// 오른쪽으로 한칸씩 이동하며 distance++
			// distance = D이면 해당 위치에 차원관문 추가
			// -> cnt++, distance = 0으로 초기화
			int cnt = 0;
			int distance = 0;
			for (int i=0; i<N; i++) {
				if (city[i] == 0) {
					distance++;
				} else {
					distance = 0;
				}
				if (distance == D) {
					cnt++;
					distance = 0;
				}
			}
			
			// 결과 출력
			System.out.printf("#%d %d%n", testCase, cnt);
		}
		
	}
}

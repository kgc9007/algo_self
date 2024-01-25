// SWEA 3499번 퍼펙트 셔플

package SWEA.no3499;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스별 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 카드 개수 입력
			int N = sc.nextInt();
			
			// 셔플 결과를 입력할 배열 result 선언
			String[] arr = new String[N];
			
			// 덱의 앞 절반 -> split1
			// 덱의 뒤 절반 -> split2
			// N이 홀수이면 split1이 한 장 더 많게 설정
			String[] split1 = new String[N-N/2];
			String[] split2 = new String[N/2];
			
			// split1과 split2 입력
			for (int i=0; i<split1.length; i++) {
				split1[i] = sc.next();
			}
			for (int i=0; i<split2.length; i++) {
				split2[i] = sc.next();
			}
			
			// 셔플 진행
			for (int i=0; i<arr.length; i++) {
				if (i%2==0) {
					arr[i] = split1[i/2];					
				} else {
					arr[i] = split2[i/2];
				}
			}
			
			// 결과 출력
			System.out.printf("#%d ", testCase);
			for (int i=0; i<arr.length; i++) {
				System.out.printf("%S ", arr[i]);
			}
			System.out.println();
		}
		
		
	}
}

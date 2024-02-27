// BOJ 9372번 상근이의 여행
// 모든 가중치가 동일한 MST(Minimum Spanning Tree)

package BOJ.no9372;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		while (T-- > 0) {
			// 국가의 수 N, 비행기 종류의 수 M 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// M개의 비행기가 연결시키는 두 국가 입력
			while (M-- > 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
			}
			
			// 결과 출력
			System.out.println(N-1);
		}
	}
}

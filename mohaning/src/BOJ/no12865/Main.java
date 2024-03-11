// BOJ 12865번 평범한 배낭

package BOJ.no12865;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 물품의 수 N, 버틸 수 있는 무게 K 입력
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 배열 info 생성 후 물건의 무게 W와 가치 V를 저장
		// info[i][0] : i번째 물건의 무게
		// info[i][1] : i번째 물건의 가치
		int[][] info = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {

		}
	}
}

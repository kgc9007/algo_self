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
		int[][] info = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
		}

		// dp 배열 생성 후 초기화
		// dp[i][j] : i번째 물건까지 있을 때, 가방이 j만큼 버틸 수 있다면 가방에 넣을 수 있는 최대 가치
		// -> dp[i][0] : 가방이 버틸 수 있는 무게가 0이므로 0
		// -> dp[0][j] : 물건이 아직 주어지지 않았으므로 0
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			dp[i][0] = 0;
		}

		// dp 배열 정보 입력
		// bottom - up 방식
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				// 해당 물품이 가방이 버틸 수 있는 무게보다 크다면
				// 가방에 담을 수 없으므로 해당 물품 이전까지 확인한 dp[i - 1][j]를 입력
				if (info[i][0] > j) {
					dp[i][j] = dp[i - 1][j];
				} 
				// 해당 물품이 가방이 버틸 수 있는 무게보다 작거나 같다면
				// 해당 물품을 넣지 않는 경우와 넣는 경우의 가치 비교
				// 1. 넣지 않는 경우 : 이전 물품까지 확인한 최대 가치 dp[i - 1][j]
				// 2. 넣는 경우 : 해당 물품을 넣고 남은 용량으로 담을 수 있는 최대 가치의 합
				// -> info[i][1] + dp[i - 1][j - info[i][0]]
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - info[i][0]] + info[i][1]);
				}
			}
		}
		
		// 결과 출력
		System.out.println(dp[N][K]);
	}
}

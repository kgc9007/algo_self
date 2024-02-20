// BOJ 1654번 랜선 자르기

package BOJ.no1654;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 이미 가지고 있는 랜선의 개수 K
		// 필요한 랜선의 개수 N
		int K = sc.nextInt();
		int N = sc.nextInt();

		// K개의 랜선의 길이를 cables 배열에 입력
		// 가장 긴 랜선의 길이를 maxLength로 저장
		int[] cables = new int[K];
		long maxLength = 0;
		for (int i = 0; i < K; i++) {
			cables[i] = sc.nextInt();
			if (cables[i] > maxLength) {
				maxLength = cables[i];
			}
		}

		
		// N개의 랜선을 만들 수 있는 최대 길이 계산
		// 이분탐색 활용
		// 가능한 가장 긴 길이를 찾아야 하므로 UpperBound 방식 사용
		
		// hi = 1, lo = 0인 경우 mid = 0이 되어 런타임 에러 발생
		// -> hi = maxLength + 1로 설정
		long hi = maxLength + 1;
		long lo = 0;
		long mid;
		
		while (lo < hi) {
			// mid 계산
			mid = (hi + lo) / 2;

			// 중간 길이(mid)로 랜선을 잘랐을 때 몇개의 랜선이 만들어지는지 계산 -> count
			int count = 0;
			for (int i = 0; i < K; i++) {
				count += cables[i] / mid;
			}
			
			// 나누어진 랜선의 개수가 필요한 랜선의 개수보다 많거나 같다면
			// -> 더 길게 잘라야 하므로 
			// 길이를 늘려서(mid ~ hi) 재탐색
			if (count >= N) {
				lo = mid + 1;
			}
			
			// 나누어진 랜선의 개수가 필요한 랜선의 개수보다 적다면
			// -> 더 짧게 잘라야 하므로 
			// 길이를 줄여서(lo ~ mid) 재탐색
			
			// 종료 조건이 lo < hi 이므로 
			// hi = mid 로 변경
			// hi = mid - 1로 설정할 경우 종료하지 못하는 경우 발생
			
			else {
				hi = mid;
			}
		}
		
		// 이분탐색 종료 후 lo = hi = 가능한 랜선의 최대 길이 + 1이므로
		// result = lo - 1
		int result = (int) lo - 1;
		
		// 결과 출력
		System.out.println(result);
		
	}
}

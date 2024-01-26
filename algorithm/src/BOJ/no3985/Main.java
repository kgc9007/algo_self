// BOJ 3985번 롤 케이크

package BOJ.no3985;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 롤 케이크의 길이 L 입력
		int L = sc.nextInt();
		int[] cake = new int[L+1];
		
		// 방청객의 수 N 입력
		int N = sc.nextInt();
		
		// 각 방청객이 받는 케이크 조각의 수를 입력할 배열 get 생성
		// 각 방청객이 받을 것으로 기대하고 있는 케이크 조각의 수를 입력할 배열 wish 생성
		int[] get = new int[N+1];
		int[] wish = new int[N+1];
		
		
		// 각 방청객이 종이에 쓴 숫자 입력
		for (int i=1; i<N+1; i++) {
			// start번째 조각부터 end번째 조각까지의 케이크를 먹고싶어하므로
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			// end - start + 1 -> i번째 사람이 받고자 하는 케이크 조각의 수
			wish[i] = end - start + 1;

			// 아직 할당되지 않은 위치의 조각이면
			// i번째 방청객에게 할당
			for (int j=start; j<=end; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
				}
			}
		}
		
		// 케이크 조각별로 누가 받아갔는지를 확인 -> get에서 ++ (해당 숫자의 방청객에게 할당)
		for (int i=1; i<L+1; i++) {
			get[cake[i]]++;
		}
		
		
		// wish배열과 get 배열을 탐색해서 결과 확인
		int wishMax = 0;
		int result1 = 0;
		
		int getMax = 0;
		int result2 = 0;
		
		for (int i=1; i<N+1; i++) {
			if (wish[i]>wishMax) {
				result1 = i;
				wishMax = wish[i];
			}
			if (get[i]>getMax) {
				result2 = i;
				getMax = get[i];
			}
			
		}
		
		// 결과 출력
		System.out.printf("%d%n%d", result1, result2);
		
		
	}
}

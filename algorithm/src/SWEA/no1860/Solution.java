// SWEA 1860번 진기의 최고급 붕어빵

package SWEA.no1860;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		int testCase = 0;
		
		while (T-- > 0) {
			testCase++;
			
			// 전체 손님의 수 N
			int N = sc.nextInt();
			// M초의 시간마다 K개의 붕어빵을 만들 수 있음
			int M = sc.nextInt();
			int K = sc.nextInt();

			// N명의 손님의 도착 시간을 arrivalTime 배열에 입력
			int[] arrivalTime = new int[N];
			for (int i = 0; i < N; i++) {
				arrivalTime[i] = sc.nextInt();
			}

			// 정렬 후 마지막 손님의 도착 시간을 lastArrivalTime으로 저장
			// 0초부터 시작이므로 1 추가한 값으로 설정
			Arrays.sort(arrivalTime);
			int lastArrivalTime = arrivalTime[N - 1] + 1;

			// 마지막 손님 도착 시간까지
			// 해당 시간의 손님 수를 저장할 배열 counting 생성, 값 입력
			int[] counting = new int[lastArrivalTime];
			for (int i = 0; i < N; i++) {
				counting[arrivalTime[i]]++;
			}

			// 마지막 손님 도착 시간까지 붕어빵 재고 수를 표현할 배열 inventory 생성
			int[] inventory = new int[lastArrivalTime];

			// 0초 ~ 마지막 손님 도착까지
			// M초가 지날때마다 붕어빵 K개 +
			// counting[time]의 값이 0이 아니면
			// -> 해당 시간에 손님이 방문할 예정이므로 counting[time] = 0이 될때까지 재고--

			// 재고가 0보다 작아지는 경우 붕어빵을 바로 제공할 수 X -> isPossible = false
			boolean isPossible = true;
			for (int time = 0; time < lastArrivalTime; time++) {
				if (time != 0) {
					inventory[time] = inventory[time - 1];
					if (time % M == 0) {
						inventory[time] += K;
					}
				}

				if (counting[time] != 0) {
					inventory[time] -= counting[time];
				}

				if (inventory[time] < 0) {
					isPossible = false;
					break;
				}
			}
			
			// 결과 출력
			if (isPossible) {
				System.out.printf("#%d Possible %n", testCase);
			} else {
				System.out.printf("#%d Impossible %n", testCase);
			}

		}

	}

}

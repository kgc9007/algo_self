// BOJ 1107번 리모컨

package BOJ.no1107;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 이동하려고 하는 채널 N, 고장난 버튼은 개수 M
		// broken : 고장난 버튼
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] broken = new int[M];
		for (int i = 0; i < M; i++) {
			broken[i] = sc.nextInt();
		}

		// 1. +, - 버튼만 눌러서 이동하는 경우
		int minCount = Math.abs(N - 100);

		// 2. 특정 채널 이동 후 +, - 버튼을 눌러서 이동하는 경우
		// 10개 버튼이 모두 고장난 경우 불가
		if (M != 10) {

			// 2-1. N부터 1씩 증가시키며 확인
			// 이동하려는 채널이 고장난 버튼을 포함하고 있는지 확인
			// 포함하고 있다면 바로 갈 수 없으므로 다음 채널로(+1)
			// 포함하지 않는다면 바로 갈 수 있으므로 해당 채널로 이동 시 count 계산
			int count;
			int moveChanel = N;
			while (moveChanel <= 1000000) {
				String str = Integer.toString(moveChanel);
				boolean flag = true;	// 해당 채널로 바로 이동할 수 있는지 확인
				for (int i = 0; i < M; i++) {
					if (str.contains(Integer.toString(broken[i]))) {
						flag = false;
					}
				}
				if (flag) {
					count = moveChanel - N + str.length();
					minCount = Math.min(minCount, count);
					break;
				}
				moveChanel++;
			}

			// 2-2. N-1부터 1씩 감소시키며 확인
			// 이동하려는 채널이 고장난 버튼을 포함하고 있는지 확인
			// 포함하고 있다면 바로 갈 수 없으므로 다음 채널로(-1)
			// 포함하지 않는다면 바로 갈 수 있으므로 해당 채널로 이동 시 count 계산
			moveChanel = N - 1;
			while (moveChanel >= 0) {
				String str = Integer.toString(moveChanel);
				boolean flag = true;	// 해당 채널로 바로 이동할 수 있는지 확인
				for (int i = 0; i < M; i++) {
					if (str.contains(Integer.toString(broken[i]))) {
						flag = false;
					}
				}
				if (flag) {
					count = N - moveChanel + str.length();
					minCount = Math.min(minCount, count);
					break;
				}
				moveChanel--;
			}

		}
		
		// 결과 출력
		System.out.println(minCount);
	}
}

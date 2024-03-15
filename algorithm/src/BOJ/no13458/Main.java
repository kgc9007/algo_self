// BOJ 13458번 시험 감독

package BOJ.no13458;

import java.util.Scanner;

public class Main {

	static int N; // 시험장 수 N
	static int B; // 총감독관이 감시할 수 있는 응시자의 수 B
	static int C; // 부감독관이 감시할 수 있는 응시자의 수 C
	static int[] candidates; // 각 시험장의 응시자 수를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 시험장 수 N 입력
		N = sc.nextInt();

		// 각 시험장의 응시자 수 입력
		candidates = new int[N];
		for (int i = 0; i < N; i++) {
			candidates[i] = sc.nextInt();
		}

		// 총감독관, 부감독관이 감시할 수 있는 응시자의 수 입력
		B = sc.nextInt();
		C = sc.nextInt();

		// 결과 출력
		System.out.println(getMin());
	}

	// 필요한 감독관 수의 최솟값을 구하는 메소드
	public static long getMin() {
		// 1000000 * 1000000 > int형 범위이므로 long으로 초기화
		long count = 0;

		// 각 시험장별로 계산
		for (int i = 0; i < N; i++) {
			// 총감독관 1명 고정
			// 총감독관으로 충분하면 count++;
			if (candidates[i] < B) {
				count++;
			}
			// 총감독관으로 부족하면
			// 총감독관이 감독할 수 있는 인원을 빼고 계산
			else {
				count += (candidates[i] - B) / C + 1;

				if ((candidates[i] - B) % C != 0) {
					count++;
				}
			}
		}
		return count;
	}
}

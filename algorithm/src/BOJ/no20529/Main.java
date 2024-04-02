// BOJ 20529번 가장 가까운 세 사람의 심리적 거리
// https://www.acmicpc.net/problem/20529

package BOJ.no20529;

import java.util.Scanner;

public class Main {
	static int result;
	static String[] mbti;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		while (T-- > 0) {
			// 사람의 수 입력
			int N = sc.nextInt();

			// 각 사람의 mbti를 저장할 배열 생성, 정보 입력
			mbti = new String[N];
			for (int i = 0; i < N; i++) {
				mbti[i] = sc.next();
			}

			// N > 32보다 크면 항상 0
			// [비둘기집 원리]
			// N > 16이면 항상 같은 mbti를 가진 사람이 두 명 이상 존재
			// 같은 방식으로 n > 32이면 항상 같은 mbti를 가진 사람이 세 명 이상 존재 -> 최소값 = 0
			if (N > 32) {
				result = 0;
			} else {
				// N <= 32인 경우 모든 경우에 대해 최소값 계산
				int minDistance = Integer.MAX_VALUE;
				for (int i = 0; i < N - 2; i++) {
					for (int j = i + 1; j < N - 1; j++) {
						for (int k = j + 1; k < N; k++) {
							String personA = mbti[i];
							String personB = mbti[j];
							String personC = mbti[k];

							int distance = getDistance(personA, personB, personC);

							minDistance = Math.min(minDistance, distance);
						}
					}
				}
				result = minDistance;
			}

			// 결과 출력
			System.out.println(result);
		}
	}

	// 세 사람의 mbti가 입력되었을 때 세 사람의 심리적인 거리를 구하는 메소드
	public static int getDistance(String personA, String personB, String personC) {
		int distance = 0;
		for (int i = 0; i < 4; i++) {
			if (personA.charAt(i) != personB.charAt(i)) {
				distance++;
			}
			if (personA.charAt(i) != personC.charAt(i)) {
				distance++;
			}
			if (personB.charAt(i) != personC.charAt(i)) {
				distance++;
			}
		}
		return distance;
	}
}

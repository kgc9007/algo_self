// BOJ 2467번 용액
// https://www.acmicpc.net/problem/2467

package BOJ.no2467;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 용액의 개수 입력
		int N = sc.nextInt();

		// 배열 생성 후 각 용액의 정보 입력
		int[] solution = new int[N];
		for (int i = 0; i < N; i++) {
			solution[i] = sc.nextInt();
		}

		// minDiff : 가장 작은 혼합용액의 특성값 초기화
		int minDiff = Integer.MAX_VALUE;

		// 정답인 경우의 인덱스 sol1, sol2
		int sol1 = 0;
		int sol2 = N - 1;

		// 투포인터
		// 가장 작은 값/가장 큰 값에서 시작해서 두 포인터가 겹쳐질 때 까지
		int left = 0;
		int right = N - 1;

		while (left < right) {
			// mix : 혼합 용액의 특성값
			int mix = solution[left] + solution[right];

			// diff : 혼합 용액의 특성값과 0과의 차이(절대값)
			int diff = Math.abs(mix);

			// 기존 minDiff 와 비교 후 혼합용액의 특성값을 0에 더 가깝게 할 수 있다면 갱신
			if (diff < minDiff) {
				sol1 = left;
				sol2 = right;

				minDiff = diff;
			}

			// 혼합용액의 특성값이 0보다 큰지, 작은지에 따라 포인터 이동
			if (mix > 0) {
				right--;
			} else if (mix < 0) {
				left++;
			} else {
				break;
			}
		}

		// 결과 출력
		System.out.println(solution[sol1] + " " + solution[sol2]);
	}
}

// BOJ 22866번 탑 보기
// https://www.acmicpc.net/problem/22866

package BOJ.no22866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 건물의 개수

		int[] height = new int[N + 1]; // 1번 ~ N번 건물의 높이

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[N + 1]; // i번 건물에서 볼 수 있는 건물의 수
		int[] nearest = new int[N + 1]; // i번 건물에서 볼 수 있는 가장 가까운 건물 번호

		// [스택을 이용해서 풀이]
		// 1. i번 건물의 오른쪽에 위치한 건물 중 볼 수 있는 건물 확인
		// 가장 오른쪽부터 시작해서 한칸씩 왼쪽으로 이동하며
		// 해당 건물 오른쪽에 위치한 볼 수 있는 건물의 수 확인
		// 볼 수 있는 건물이 있다면 가장 가까운 건물 번호 입력
		Stack<int[]> stack = new Stack<>();
		for (int i = N; i >= 1; i--) {
			if (stack.isEmpty()) {
				stack.add(new int[] { height[i], i });
				continue;
			}

			while (!stack.isEmpty() && height[i] >= stack.peek()[0]) {
				stack.pop();
			}
			count[i] += stack.size();
			if (!stack.isEmpty()) {
				nearest[i] = stack.peek()[1];
			}
			stack.add(new int[] { height[i], i });
		}

		// 2. i번 건물의 왼쪽에 위치한 건물 중 볼 수 있는 건물 확인
		// 가장 왼쪽부터 시작해서 한칸씩 오른쪽으로 이동하며
		// 해당 건물 왼쪽에 위치한 볼 수 있는 건물의 수 확인
		// 볼 수 있는 건물이 있다면 가장 가까운 건물 번호 확인 후 기존값과 비교, 더 가깝거나 같은 거리라면 갱신
		stack.clear();
		for (int i = 1; i <= N; i++) {
			if (stack.isEmpty()) {
				stack.add(new int[] { height[i], i });
				continue;
			}

			while (!stack.isEmpty() && height[i] >= stack.peek()[0]) {
				stack.pop();
			}
			count[i] += stack.size();

			if (!stack.isEmpty() && (i - stack.peek()[1] <= nearest[i] - i || nearest[i] == 0)) {
				nearest[i] = stack.peek()[1];
			}
			stack.add(new int[] { height[i], i });
		}

		// 결과 출력
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				System.out.println(count[i]);
			} else {
				System.out.println(count[i] + " " + nearest[i]);
			}
		}
	}
}

// BOJ 13913번 숨바꼭질 4
// https://www.acmicpc.net/problem/13913

package BOJ.no13913;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int min = 0;

		// visited[i][0] : i 위치에 처음으로 도달하는 시간
		// visited[i][1] : i 위치에 도달하기 전 위치 - 연결리스트의 이전 노드 역할
		int[][] visited = new int[100001][2];
		Queue<Integer> queue = new LinkedList<>();
		visited[N][0] = 1;
		queue.add(N);

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			if (curr == K) {
				min = visited[curr][0];
				break;
			}

			if (curr - 1 >= 0 && visited[curr - 1][0] == 0) {
				visited[curr - 1][0] = visited[curr][0] + 1;
				visited[curr - 1][1] = curr;
				
				queue.add(curr - 1);
			}
			if (curr + 1 <= 100000 && visited[curr + 1][0] == 0) {
				visited[curr + 1][0] = visited[curr][0] + 1;
				visited[curr + 1][1] = curr;
				
				queue.add(curr + 1);
			}
			if (curr * 2 <= 100000 && visited[curr * 2][0] == 0) {
				visited[curr * 2][0] = visited[curr][0] + 1;
				visited[curr * 2][1] = curr;

				queue.add(curr * 2);
			}
		}

		int[] result = new int[min];
		int idx = min - 1;
		result[idx--] = K;
		int curr = K;
		while (idx >= 0) {
			result[idx--] = visited[curr][1];
			curr = visited[curr][1];
		}
		
		// 결과 출력
		System.out.println(min - 1);
		for (int i = 0; i < min; i++) {
			System.out.print(result[i] + " ");
		}

	}

}

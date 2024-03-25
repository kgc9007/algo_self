// BOJ 16928번 뱀과 사다리 게임
// https://www.acmicpc.net/problem/16928

package BOJ.no16928;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 1~100까지의 보드판을 저장할 배열
	// i번 칸에 도달하기까지 필요한 최소 주사위 횟수 저장
	static int[] map = new int[101];

	// 사다리, 뱀 정보를 저장할 배열
	// ladderAndSnake[i] = 0 : 사다리, 뱀 X
	// ladderAndSnake[i] != 0 : 사다리, 뱀 O, 연결된 위치의 번호 저장
	static int[] ladderAndSnake = new int[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 사다리의 수 N, 뱀의 수 M 입력
		int N = sc.nextInt();
		int M = sc.nextInt();

		// 사다리 정보 입력
		for (int i = 0; i < N; i++) {
			ladderAndSnake[sc.nextInt()] = sc.nextInt();
		}

		// 뱀 정보 입력
		for (int i = 0; i < M; i++) {
			ladderAndSnake[sc.nextInt()] = sc.nextInt();
		}

		// bfs 실행
		bfs(1);

		// 결과 출력
		System.out.println(map[100]);
	}

	// bfs
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		// 시작점 큐에 추가
		queue.add(start);

		// 큐가 빌때까지
		while (!queue.isEmpty()) {
			int now = queue.poll();

			// 주사위 1~6
			for (int dice = 1; dice <= 6; dice++) {
				int next = now + dice;
				// 다음 칸이 100보다 작은 경우에만
				if (next <= 100) {
					// 다음 칸에 아직 간 적이 없고 사다리나 뱀이 없다면
					// 다음 칸에 최소 주사위 횟수 입력, 큐에 추가
					if (map[next] == 0 && ladderAndSnake[next] == 0) {
						map[next] = map[now] + 1;
						queue.add(next);
					}
					// 다음 칸에 사다리나 뱀이 있고 아직 이동할 위치에 간 적이 없다면
					// 사다리나 뱀을 통해 이동할 칸에 최소 주사위 횟수 입력, 큐에 추가
					if (ladderAndSnake[next] != 0) {
						if (map[ladderAndSnake[next]] == 0) {
							map[ladderAndSnake[next]] = map[now] + 1;
							queue.add(ladderAndSnake[next]);
						}
					}
				}
			}
		}

	}
}
